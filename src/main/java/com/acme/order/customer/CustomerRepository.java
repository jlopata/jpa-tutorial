package com.acme.order.customer;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
	
/*	List<Customer> findByCustomerName(@Param("name") String name);*/
	
	@Query("select u from customer_t u join customer_type_t z on u.type_id = z.id where z.name = EEIA")
	  CustomerType findByCustomerTypeName(String name);
	
}
