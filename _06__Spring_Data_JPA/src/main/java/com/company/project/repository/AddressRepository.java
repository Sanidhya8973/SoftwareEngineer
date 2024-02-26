package com.company.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.company.project.model.Address;

public interface AddressRepository extends JpaRepository<Address, Long>{

}
