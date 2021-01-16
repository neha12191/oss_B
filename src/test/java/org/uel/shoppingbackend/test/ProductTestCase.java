package org.uel.shoppingbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.uel.shoppingbackend.dao.ProductDAO;
import org.uel.shoppingbackend.dto.Product;

public class ProductTestCase {

	private static AnnotationConfigApplicationContext context;
	
	
	private static ProductDAO productDAO;
	
	
	private Product product;
	
	
	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("org.uel.shoppingbackend");
		context.refresh();
		productDAO = (ProductDAO)context.getBean("productDAO");
	}
	
	@Test
	public void testCRUDProduct() {
		
		// create operation
		product = new Product();
				
		product.setName("Dream Catcher");
		product.setBrand("Dreamz");
		product.setDescription("This is some description for Dream Catcher!");
		product.setUnitPrice(12);
		product.setActive(true);
		product.setCategoryId(1);
		product.setSupplierId(1);
		
		assertEquals("Something went wrong while inserting a new product!",
				true,productDAO.add(product));		
		
		
		// reading and updating the category
		product = productDAO.get(2);
		product.setName("Ganesha Back flow Holder");
		assertEquals("Something went wrong while updating the existing record!",
				true,productDAO.update(product));		
				
		assertEquals("Something went wrong while deleting the existing record!",
				true,productDAO.delete(product));		
		
		// list
		assertEquals("Something went wrong while fetching the list of products!",
				21,productDAO.list().size());		
				
	}
		
	
	@Test
	public void testListActiveProducts() {
		assertEquals("Something went wrong while fetching the list of products!",
				19,productDAO.listActiveProducts().size());				
	} 
	
	
	@Test
	public void testListActiveProductsByCategory() {
		assertEquals("Something went wrong while fetching the list of products!",
				5,productDAO.listActiveProductsByCategory(3).size());
		assertEquals("Something went wrong while fetching the list of products!",
				13,productDAO.listActiveProductsByCategory(1).size());
	} 
	
	@Test
	public void testGetLatestActiveProduct() {
		assertEquals("Something went wrong while fetching the list of products!",
				3,productDAO.getLatestActiveProducts(3).size());
		
	} 
	
	
	
		
}
