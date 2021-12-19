package com.mintic.RetosCiclo4.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mintic.RetosCiclo4.model.Order;
import com.mintic.RetosCiclo4.repository.OrderRepository;

/**
 * Class to acces Repository User
 * 
 * @author G5 Desarrollo WEB Ciclo4
 *
 */

@Service
public class OrderService {

	@Autowired
	private OrderRepository repositoryOrder;

	/**
	 * Method to get All orders
	 * 
	 * @return list orders
	 */
	public List<Order> getAllOrders() {
		return repositoryOrder.getAllOrders();
	}

	/**
	 * Method to get unique order by id
	 * 
	 * @param id
	 * @return unique order
	 */
	public Optional<Order> getOrder(int id) {
		return repositoryOrder.getOrder(id);
	}

	/**
	 * Method to create item order in collection "orders"
	 * 
	 * @param order
	 * @return order
	 */
	public Order createOrder(Order order) {

		// get max id of collection order
		Optional<Order> maxIdOrder = repositoryOrder.lastUserId();

		// if id order == null , set id order to 1 or last id + 1 collection orders
		if (order.getId() == null) {
			// if not Id 1 in collection orders, set id to 1
			if (maxIdOrder.isEmpty())
				order.setId(1);
			// set order id to last id + 1
			else
				order.setId(maxIdOrder.get().getId() + 1);
		}

		Optional<Order> itemOrder = repositoryOrder.getOrder(order.getId());
		if (itemOrder.isEmpty()) {
			return repositoryOrder.createOrder(order);
		} else {
			return order;
		}
	}

	/**
	 * Method to update order
	 * 
	 * @param order
	 * @return
	 */
	public Order updateOrder(Order order) {

		if (order.getId() != null) {
			Optional<Order> dBOrder = repositoryOrder.getOrder(order.getId());
			if (!dBOrder.isEmpty()) {
				if (order.getStatus() != null) {
					dBOrder.get().setStatus(order.getStatus());
				}
				repositoryOrder.updateOrder(dBOrder.get());
				return dBOrder.get();
			} else {
				return order;
			}
		} else {
			return order;
		}
	}

	/**
	 * Delete order collection "orders" by id
	 * 
	 * @param id
	 * @return boolean value
	 */
	public boolean deleteOrder(int id) {
		Boolean booleanValue = getOrder(id).map(order -> {
			repositoryOrder.deleteOrder(order);
			return true;
		}).orElse(false);
		return booleanValue;
	}

	/**
	 * Method to get Order by zone user
	 * 
	 * @param zone
	 * @return orders by zone user
	 */
	public List<Order> getOrdersByZone(String zone) {
		return repositoryOrder.getOrdersByZone(zone);
	}

	/**
	 * Method to get orders by salesMan´s Id
	 * 
	 * @param id
	 * @return List Orders salesMan´s Id
	 */
	public List<Order> getOrderBySalesManId(Integer id) {
		return repositoryOrder.getOrderBySalesManId(id);
	}

	/**
	 * Method to get orders by status by salesMan´s Id
	 * 
	 * @param status
	 * @param id
	 * @return List orders
	 */
	public List<Order> getOrderByStateBySalesManId(String status, Integer id) {
		return repositoryOrder.getOrderByStateBySalesManId(status, id);
	}

	/**
	 * Method to get Orders by registerDay and salesMan´s id
	 * 
	 * @param registerDay
	 * @param id
	 * @return List Orders
	 */

	public List<Order> ordersSalesManByDate(String dateStr, Integer id) {
		return repositoryOrder.ordersSalesManByDate(dateStr, id);
	}

}
