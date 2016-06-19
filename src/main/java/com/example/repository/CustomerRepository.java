package com.example.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.example.domain.Customer;

@Repository
public interface CustomerRepository extends PagingAndSortingRepository<Customer, Long>{

}
