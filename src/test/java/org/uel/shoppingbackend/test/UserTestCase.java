package org.uel.shoppingbackend.test;
import static org.junit.Assert.assertEquals;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.uel.shoppingbackend.dao.UserDAO;
import org.uel.shoppingbackend.dto.Address;
import org.uel.shoppingbackend.dto.Cart;
import org.uel.shoppingbackend.dto.User;

public class UserTestCase {

	private static AnnotationConfigApplicationContext context;
	private static UserDAO userDAO;
	private User user = null;
	private Cart cart = null;
	private Address address = null;
	
	
	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("org.uel.shoppingbackend");
		context.refresh();
		
		userDAO = (UserDAO) context.getBean("userDAO");
	}
	

	@Test
	public void testAddUser() {
		
		user = new User() ;
		user.setFirstName("ram");
		user.setLastName("H");
		user.setEmail("hr1@gmail.com");
		user.setContactNumber("1234512345");
		user.setRole("CUSTOMER");
		user.setEnabled(true);
		user.setPassword("12345");
		
		
		address = new Address();
		address.setAddressLineOne("123");
		address.setAddressLineTwo("23");
		address.setCity("London");
		address.setState("UK");
		address.setCountry("UK");
		address.setPostalCode("NW12");
		address.setBilling(true);
		
		cart = new Cart();
		
		// linked the address with the user
		address.setUserId(user.getId());
		
		// linked the cart with the user
		cart.setUser(user);
		// link the user with the cart
		user.setCart(cart);
		
		// add the user
		assertEquals("Failed to add the user!", true, userDAO.add(user));	
		// add the address
		//assertEquals("Failed to add the billing address!", true, userDAO.addAddress(address));

				
		// add the shipping address
		address = new Address();
		address.setAddressLineOne("23");
		address.setAddressLineTwo("434");
		address.setCity("London");
		address.setState("England");
		address.setCountry("UK");
		address.setPostalCode("NU7");
		address.setUserId(user.getId());
		assertEquals("Failed to add the shipping address!", true, userDAO.addAddress(address));
		
	}
	
	

	// working for uni-directional

	@Test
	public void testAddAddress() {
		user = userDAO.get(1);
		
		address = new Address();
		address.setAddressLineOne("123");
		address.setAddressLineTwo("32");
		address.setCity("London");
		address.setState("England");
		address.setCountry("UK");
		address.setPostalCode("NW23");
				
		address.setUserId(user.getId());
		// add the address
		assertEquals("Failed to add the address!", true, userDAO.addAddress(address));	
	}
	
	/*
	 * @Test public void testUpdateCart() { user = userDAO.get(1); cart =
	 * user.getCart(); cart.setGrandTotal(10000); cart.setCartLines(1);
	 * assertEquals("Failed to update the cart!", true, userDAO.updateCart(cart)); }
	 */ 


	

	
}
