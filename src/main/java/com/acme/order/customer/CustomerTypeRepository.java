package com.acme.order.customer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CustomerTypeRepository extends JpaRepository<CustomerType, Long> {	
	
	
	
}
