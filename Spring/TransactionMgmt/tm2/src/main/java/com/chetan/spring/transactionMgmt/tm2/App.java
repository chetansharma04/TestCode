package com.chetan.spring.transactionMgmt.tm2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.chetan.spring.transactionMgmt.tm2.bo.ProductBo;
import com.chetan.spring.transactionMgmt.tm2.model.Product;

public class App 
{
	@Autowired
	ApplicationContext appContext;
    
	public static void main( String[] args )
    {
    	Product product = new Product();
    	  product.setProductCode("BBB");
    	  product.setProductId(11);
           product.setProductDesc("This is product BBB");

        ApplicationContext appContext = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        
        ProductBo productBo = (ProductBo)appContext.getBean("productBoImpl");
        productBo.save(product, 100);
    }

}
