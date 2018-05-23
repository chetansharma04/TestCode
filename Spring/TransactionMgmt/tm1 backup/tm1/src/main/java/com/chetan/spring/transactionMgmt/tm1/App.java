package com.chetan.spring.transactionMgmt.tm1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.chetan.spring.transactionMgmt.tm1.bo.ProductBo;
import com.chetan.spring.transactionMgmt.tm1.model.Product;


public class App  
{
	@Autowired
	ApplicationContext appContext;
    
	public static void main( String[] args )
    {
    	Product product = new Product();
    	  product.setProductCode("ABC");
    	  product.setProductId(1);
           product.setProductDesc("This is product ABC");

        ApplicationContext appContext = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        
        ProductBo productBo = (ProductBo)appContext.getBean("productBoImpl");
        productBo.save(product, 100);
    }

}
