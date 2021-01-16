package org.uel.shoppingbackend.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.uel.shoppingbackend.dao.OrderDAO;
import org.uel.shoppingbackend.dto.OrderDetail;

@Repository("orderDAO")
@Transactional
public class OrderDAOImpl implements OrderDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<OrderDetail> getOrder() {
		String query = "FROM OrderDetail";
		try {
			
			return sessionFactory.getCurrentSession()
									.createQuery(query,OrderDetail.class)
									.getResultList();
			
		}catch(Exception ex) {
			return null;	
		}
		
	}

	
	@Override
	public boolean update(OrderDetail orderDetail) {
		try {
			sessionFactory.getCurrentSession().update(orderDetail);
			return true;
		}
		catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean remove(OrderDetail orderDetail) {	
		try {			
			sessionFactory.getCurrentSession().delete(orderDetail);
			return true;
		}catch(Exception ex) {
			return false;
		}		
	}
	
}
