/**
 * 
 */
package com.ibm.basics.collection;

import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.ArrayList;

/**
 * @author 004ISA744
 *
 */
public class LatestThreePurchaseOrders {
	public static void main(String[] args) {
		// Populate customers
		List<Customer> customers = new ArrayList<>();
		customers.add(new Customer("John", 1));
		customers.add(new Customer("Alice", 2));
		customers.add(new Customer("Bob", 3));

		// Populate orders
		List<Order> orders = new ArrayList<>();
		Calendar calendar = Calendar.getInstance();

		// Orders for John
		calendar.set(2023, Calendar.JANUARY, 15);
		orders.add(new Order(1, 1, calendar.getTime()));

		calendar.set(2023, Calendar.FEBRUARY, 10);
		orders.add(new Order(2, 1, calendar.getTime()));

		calendar.set(2023, Calendar.MARCH, 5);
		orders.add(new Order(3, 1, calendar.getTime()));

		// Orders for Alice
		calendar.set(2023, Calendar.MARCH, 8);
		orders.add(new Order(4, 2, calendar.getTime()));

		// Orders for Bob
		calendar.set(2023, Calendar.MAY, 20);
		orders.add(new Order(5, 3, calendar.getTime()));

		// Rest of the code remains the same...
		Map<Integer, List<Order>> ordersByCustomerId = orders.stream()
				.collect(Collectors.groupingBy(Order::getCustomer_id));

		List<Order> selectedOrders = customers.stream().flatMap(customer -> {
			List<Order> customerOrders = ordersByCustomerId.getOrDefault(customer.getCustomer_id(),
					Collections.emptyList());
			return customerOrders.stream().sorted(Comparator.comparing(Order::getOrder_date).reversed()).limit(3);
		}).collect(Collectors.toList());

		// Print the results
		selectedOrders.forEach(order -> {
			System.out.println("Customer Name: " + customers.get(order.getCustomer_id() - 1).getName()
					+ ", Customer ID: " + order.getCustomer_id() + ", Order ID: " + order.getOrder_id()
					+ ", Order Date: " + order.getOrder_date());
		});
	}
}
