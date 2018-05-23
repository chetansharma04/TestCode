package com.chetan.common;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.chetan.bo.CategoryBo;
import com.chetan.bo.StockBo;
import com.chetan.model.Category;
import com.chetan.model.Stock;
import com.chetan.model.StockDailyRecords;

public class App {

	 private static ApplicationContext appContext;

	public static void main( String[] args )
	    {
	    	appContext = new ClassPathXmlApplicationContext("spring/config/BeanLocations.xml");

	    	StockBo stockBo = (StockBo)appContext.getBean("stockBo");
	    	
	    	App app = new App();
	    	app.addStock(stockBo);
	    	app.readStock(stockBo);

//	    	CategoryBo categoryBo = (CategoryBo)appContext.getBean("categoryBo");
//	    	app.updateCategory(categoryBo);
	    	
	    	System.out.println("Done");
	    }
	 
	 
	 public void addStock(StockBo stockBo){
		 
		 
		 /** insert **/
	    	Stock stock = new Stock();
	    	stock.setStockCode("7668");
	    	stock.setStockName("HAIO");
	    	
//	    	Set<StockDailyRecords> stockDailyRecordSet = new HashSet<StockDailyRecords>();
//	    	StockDailyRecords stockDailyRecords = new StockDailyRecords(); d 
//	    	stockDailyRecords.setStockInDate(new Date());
//	    	stockDailyRecords.setStockOutDate(new Date());
//	    	stockDailyRecordSet.add(stockDailyRecords);
//	    	stockDailyRecords.setStock(stock);
//	        stock.setStockDailyRecords(stockDailyRecordSet);

	    	Set<Category> stockCategorySet = new HashSet<Category>();
	    	Category category = new Category();
	    	category.setCategory("MapCategory "+new Date());
	    	stockCategorySet.add(category);
	    	
	    	Set<Stock> categoryStockSet = new HashSet<Stock>();
	    	categoryStockSet.add(stock);
	    	
//	        stock.setStockDailyRecords(stockCategorySet);

	        
	        
	    	stockBo.save(stock);


	    	
	    	
	   

//	    	/** update **/
//	    	stock2.setStockName("HAIO-1");
//	    	stockBo.update(stock2);
	    	
	    	/** delete **/
//	    	stockBo.delete(stock2);
	    	
	 }
	 
	 
	 public void readStock(StockBo stockBo){

	    	/** select **/
	    	System.out.println("\n Printing saved records----------");
	    	List<Stock> stockList = stockBo.findAll();
	    	for (Stock stock2 : stockList) {
				System.out.println(stock2);
				Set<StockDailyRecords> stockDailyRecordSet2 = stock2.getStockDailyRecords();
				for (StockDailyRecords stockDailyRecords2 : stockDailyRecordSet2) {
					System.out.println(stockDailyRecords2);
				}
				
			}
		 
//	    	
//	    	/** select **/
//	    	Stock stock2 = stockBo.findByStockCode("7668");
//	    	System.out.println(stock2);
//	    	

	   }
	 
	 public void updateCategory(CategoryBo categoryBo){
		 /** insert **/
	    	Category Category = new Category();
	    	Category.setCategory("Category 1");
	    	categoryBo.save(Category);
	    	
	    	/** select **/
	    	List<Category> categoryList = categoryBo.findAllCategory();
	    	for (Category category2 : categoryList) {
				System.out.println("category = "+category2);
			}
	    	
	    	/** delete **/
//	    	stockBo.delete(stock2);
	 }
	 
}
