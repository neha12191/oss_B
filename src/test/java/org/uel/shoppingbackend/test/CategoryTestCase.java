package org.uel.shoppingbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.uel.shoppingbackend.dao.CategoryDAO;
import org.uel.shoppingbackend.dto.Category;

public class CategoryTestCase {

	private static AnnotationConfigApplicationContext context;
	
	
	private static CategoryDAO categoryDAO;
	
	
	private Category category;
	
	
	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("org.uel.shoppingbackend");
		context.refresh();
		categoryDAO = (CategoryDAO)context.getBean("categoryDAO");
	}
	
	
@Test
	public void testAddCategory() {
		
		category = new Category();
		
		category.setName("Furniture");
		category.setDescription("This is some description for all kind of furnitures!");
		category.setImageURL("CAT_105.png");
		
		assertEquals("Successfully added a category inside the table!",true,categoryDAO.add(category));
		
		
	}
	
	
	@Test
	public void testGetCategory() {
		
		category = categoryDAO.get(3);
		
		
		assertEquals("Successfully fetched a single category from the table!","Throws",category.getName());
		
		
	}
	
	
	@Test
	public void testUpdateCategory() {
		
		category = categoryDAO.get(4);
		
		category.setName("Burners");
		
		assertEquals("Successfully updated a single category in the table!",true,categoryDAO.update(category));
		
		
	}
	

	@Test
	public void testDeleteCategory() {
		
		category = categoryDAO.get(4);		
		assertEquals("Successfully deleted a single category in the table!",true,categoryDAO.delete(category));
		
		
	}
	
	@Test
	public void testListCategory() {
					
		assertEquals("Successfully fetched the list of categories from the table!",3,categoryDAO.list().size());
		
		
	}
	

	
	@Test
	public void testCRUDCategory() {
		
		// add operation
		category = new Category();
		
		category.setName("Wall Hanging");
		category.setDescription("This is some description for Wall Hanging!");
		category.setImageURL("CAT_1.png");
		
		assertEquals("Successfully added a category inside the table!",true,categoryDAO.add(category));
		
		
		category = new Category();
		
		category.setName("Burners");
		category.setDescription("This is some description for Burners!");
		category.setImageURL("CAT_2.png");
		
		assertEquals("Successfully added a category inside the table!",true,categoryDAO.add(category));

		
		// fetching and updating the category
		category = categoryDAO.get(4);
		
		category.setName("Furniture");
		
		assertEquals("Successfully updated a single category in the table!",true,categoryDAO.update(category));
		
		
		// delete the category
		assertEquals("Successfully deleted a single category in the table!",true,categoryDAO.delete(category));
		
		
		//fetching the list
		assertEquals("Successfully fetched the list of categories from the table!",6,categoryDAO.list().size());		
				
		
	}
	
	
}
