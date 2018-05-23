package com.chetan.common;

import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.chetan.stock.bo.StockBo;
import com.chetan.stock.model.Stock;

public class App {

	 public static void main( String[] args )
	    {
	    	ApplicationContext appContext = 
	    	  new ClassPathXmlApplicationContext("spring/config/BeanLocations.xml");
		
	    	StockBo stockBo = (StockBo)appContext.getBean("stockBo");
	    	
	    	/** insert **/
	    	Stock stock = new Stock();
	    	stock.setStockCode("7668");
	    	stock.setStockName("StockName_"+new Date());
	    	stockBo.save(stock);
	    	
	    	/** select **/
	    	Stock stock2 = stockBo.findByStockCode("7668");
	    	System.out.println(stock2);
	    	
	    	/** update **/
	    	stock2.setStockName("HAIO-1");
	    	stockBo.update(stock2);
	    	
	    	/** delete **/
	    	stockBo.delete(stock2);
	    	
	    	System.out.println("Done");
	    }
}
