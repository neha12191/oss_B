package org.uel.shoppingbackend.dao;

import java.util.List;

import org.uel.shoppingbackend.dto.OrderDetail;

public interface OrderDAO {

	public boolean update(OrderDetail orderDetail);
	public boolean remove(OrderDetail orderDetail);
	
	// fetch the CartLine based on cartId and productId
	public List<OrderDetail> getOrder();		
		
	// updating the cart
	
	
	
}
