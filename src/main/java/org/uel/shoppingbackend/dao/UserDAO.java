package org.uel.shoppingbackend.dao;

import java.util.List;

import org.uel.shoppingbackend.dto.Address;
import org.uel.shoppingbackend.dto.Cart;
import org.uel.shoppingbackend.dto.User;

public interface UserDAO {

	// user related operation
	User getByEmail(String email);
	User get(int id);

	boolean add(User user);
	
	// adding and updating a new address
	Address getAddress(int addressId);
	boolean addAddress(Address address);
	boolean updateAddress(Address address);
	Address getBillingAddress(int userId);
	List<Address> listShippingAddresses(int userId);
	

	
}
