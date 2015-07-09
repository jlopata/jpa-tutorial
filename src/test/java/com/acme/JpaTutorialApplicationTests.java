package com.acme;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.acme.order.customer.Customer;
import com.acme.order.customer.CustomerRepository;
import com.acme.order.customer.CustomerType;
import com.acme.order.customer.CustomerTypeRepository;
import com.acme.order.pizza.PizzaOrderService;
import com.acme.order.pizza.PizzaType;
import com.google.common.collect.Lists;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = JpaTutorialApplication.class)
public class JpaTutorialApplicationTests {

	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private PizzaOrderService pizzaOrderService;
	
	@Autowired
	private CustomerTypeRepository customerTypeRepository;
	
	/*@Test
	public void contextLoads() {
		SpringApplication.run(JpaTutorialApplication.class, args);
	}*/
	
	@Test
	public void LoadData() {
		
		CustomerType theBestCustomerTypeEver = new CustomerType(null, "EEIA");
		customerTypeRepository.save(Lists.newArrayList(theBestCustomerTypeEver));
		
		Customer customer1 = new Customer(null, "Jerry", "q@com", "Jaracza 77", theBestCustomerTypeEver);
		Customer customer2 = new Customer(null, "Łukasz", "a@com", "Jaracza 77", theBestCustomerTypeEver);
		Customer customer3 = new Customer(null, "Konrad", "z@com", "Woronicza 30", theBestCustomerTypeEver);
		customerRepository.save(Lists.newArrayList(customer1, customer2, customer3));
		
		pizzaOrderService.createOrder(customer1, PizzaType.LARGE);
		pizzaOrderService.createOrder(customer2, PizzaType.LARGE);
		pizzaOrderService.createOrder(customer3, PizzaType.LARGE);
	}

}
