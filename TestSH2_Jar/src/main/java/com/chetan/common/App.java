package com.chetan.common;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.chetan.bo.CategoryBo;
import com.chetan.bo.StockBo;
import com.chetan.model.Category;
import com.chetan.model.Stock;

public class App {

	 private static ApplicationContext appContext;

	public static void main( String[] args )
	    {
	    	appContext = new ClassPathXmlApplicationContext("spring/config/BeanLocations.xml");

	    	StockBo stockBo = (StockBo)appContext.getBean("stockBo");
	    	CategoryBo categoryBo = (CategoryBo)appContext.getBean("categoryBo");
	    	
	    	App app = new App();
	    	app.updateStock(stockBo);
	    	app.updateCategory(categoryBo);
	    	
	    	System.out.println("Done");
	    }
	 
	 
	 public void updateStock(StockBo stockBo){
		 
		 
		 /** insert **/
	    	Stock stock = new Stock();
	    	stock.setStockCode("7668");
	    	stock.setStockName("HAIO");
	    	stockBo.save(stock);
	    	
	    	/** select **/
	    	Stock stock2 = stockBo.findByStockCode("7668");
	    	System.out.println(stock2);
	    	
	    	/** update **/
	    	stock2.setStockName("HAIO-1");
	    	stockBo.update(stock2);
	    	
	    	/** delete **/
//	    	stockBo.delete(stock2);
	    	
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
