package excelRelated;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataValidation;
import org.apache.poi.ss.usermodel.DataValidationConstraint;
import org.apache.poi.ss.usermodel.DataValidationHelper;
import org.apache.poi.ss.util.CellRangeAddressList;
import org.apache.poi.xssf.usermodel.XSSFDataValidationHelper;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DropDownList {

	public static void main(String[] args)  throws IOException {

DataValidation dataValidation = null;
DataValidationConstraint constraint = null;
DataValidationHelper validationHelper = null;

 XSSFWorkbook wb = new XSSFWorkbook();
 XSSFSheet sheet1=(XSSFSheet) wb.createSheet("sheet1");


    validationHelper=new XSSFDataValidationHelper(sheet1);
    CellRangeAddressList addressList = new  CellRangeAddressList(0,5,0,0);
    constraint =validationHelper.createExplicitListConstraint(new String[]{"SELECT","10", "20", "30"});
    dataValidation = validationHelper.createValidation(constraint, addressList);
    dataValidation.setSuppressDropDownArrow(true);      
    sheet1.addValidationData(dataValidation);

    FileOutputStream fileOut = new FileOutputStream("c:\\temp\\vineet.xlsx");
    wb.write(fileOut);
    fileOut.close();
}

}