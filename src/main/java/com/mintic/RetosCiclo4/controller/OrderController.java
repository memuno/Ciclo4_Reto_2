package com.mintic.RetosCiclo4.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.mintic.RetosCiclo4.model.Order;
import com.mintic.RetosCiclo4.service.OrderService;

/**
 * Class to Access Endpoints collections "orders"
 * 
 * @author MARIO GOMEZ
 *
 */

@RestController
@RequestMapping("/api/order")
@CrossOrigin("*")
public class OrderController {

	@Autowired
	private OrderService serviceOrder;

	/**
	 * Method Endpoint to get all orders
	 * 
	 * @return list orders
	 */
	@GetMapping("/all")
	public List<Order> getAllOrders() {
		return serviceOrder.getAllOrders();
	}

	/**
	 * Method endpoint to get order by id
	 * 
	 * @param id
	 * @return order
	 */
	@GetMapping("/{id}")
	public Optional<Order> getOrder(@PathVariable("id") int id) {
		return serviceOrder.getOrder(id);
	}

	/**
	 * Method Endpoint to create order
	 * 
	 * @param gadget
	 * @return order
	 */
	@PostMapping("/new")
	@ResponseStatus(HttpStatus.CREATED)
	public Order createOrder(@RequestBody Order order) {
		return serviceOrder.createOrder(order);
	}

	/**
	 * Method Endpoint to update order
	 * 
	 * @param order
	 * @return order
	 */
	@PutMapping("/update")
	@ResponseStatus(HttpStatus.CREATED)
	public Order updateOrder(@RequestBody Order order) {
		return serviceOrder.updateOrder(order);
	}

	/**
	 * Method Endpoint to Delete order by id
	 * 
	 * @param id
	 * @return true or false
	 */
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public boolean deleteOrder(@PathVariable("id") int id) {
		return serviceOrder.deleteOrder(id);
	}

	/**
	 * Method Endpoint to Get orders by key salesman Collection "orders"
	 * 
	 * @param zone
	 * @return
	 */
	@GetMapping("/zona/{zone}")
	public List<Order> getOrdersByZone(@PathVariable("zone") String zone) {
		return serviceOrder.getOrdersByZone(zone);
	}

}
