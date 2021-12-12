package com.mintic.RetosCiclo4.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mintic.RetosCiclo4.model.Order;

/**
 * Repository to ACCES Model order
 * 
 * @author G5 Desarrollo WEB
 *
 */
@Repository
public class OrderRepository {

	@Autowired
	private OrderInterface interfOderRepo;

	/**
	 * Method to get All orders items Return list orders
	 * 
	 * @return list Orders
	 */
	public List<Order> getAllOrders() {
		return (List<Order>) interfOderRepo.findAll();
	}

	/**
	 * Method to get order item by Id
	 * 
	 * @param id
	 * @return order
	 */
	public Optional<Order> getOrder(int id) {
		return interfOderRepo.findById(id);
	}

	/**
	 * Method to create order item
	 * 
	 * @param order
	 * @return order
	 */
	public Order createOrder(Order order) {
		return interfOderRepo.save(order);

	}

	/**
	 * Method to Update order item
	 * 
	 * @param order
	 */
	public void updateOrder(Order order) {
		interfOderRepo.save(order);
	}

	/**
	 * Method to Delete order item
	 * 
	 * @param order
	 */
	public void deleteOrder(Order order) {
		interfOderRepo.delete(order);
	}

	/**
	 * Method to get last id in Collection orders
	 * 
	 * @return Last id
	 */
	public Optional<Order> lastUserId() {
		return interfOderRepo.findTopByOrderByIdDesc();
	}

	/**
	 * Method to get orders by Key salesMan.zone Collection "orders"
	 * 
	 * @param zone
	 * @return orders by salesman.zone key
	 */
	public List<Order> getOrdersByZone(String zone) {
		return (List<Order>) interfOderRepo.findByZone(zone);
	}

}
