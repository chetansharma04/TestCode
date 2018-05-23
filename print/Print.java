package print;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Print {
	public static void main(String[] args) {
		
		try {
			
			System.out.println("Print Start");
//			File file = new File("C:/Users/chetans/Desktop/Spring-Framework.pdf");
			
//			Desktop.getDesktop().print(file);
//			Desktop.getDesktop().print(file);
			
			Runtime runtime = Runtime.getRuntime();;
			runtime.exec("jar -xvf printEvidences.jar");
			
			Thread.sleep(5000);
			
			File directoryToZip = new File("/print");
			List<File> fileList = new ArrayList<File>();
		
			System.out.println("---Getting references to all files in: " + directoryToZip.getCanonicalPath());
			getAllFiles(directoryToZip, fileList);
			
			for (File file : fileList) {
				System.out.println("     Printing file:" + file.getCanonicalPath());
				Desktop.getDesktop().print(file);
			}
			
			System.out.println("Print Done");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void getAllFiles(File dir, List<File> fileList) {
		try {
			File[] files = dir.listFiles();
			for (File file : files) {
				if(!(file.getName().contains("MANIFEST.MF") || file.getName().contains("Print.class") || file.getName().contains("Print.java"))){
					fileList.add(file);
					if (file.isDirectory()) {
						System.out.println("directory:" + file.getCanonicalPath());
						getAllFiles(file, fileList);
					} else {
						System.out.println("     file:" + file.getCanonicalPath());
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	

}
