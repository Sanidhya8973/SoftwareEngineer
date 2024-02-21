package com.company.project.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.stereotype.Service;

import com.company.project.domain.Address;
import com.company.project.repository.AddressRepository;

@Service(value = "service_address")
public class AddressService {

	@Autowired
	private AddressRepository addressRepository;

	public long count() {
		return addressRepository.count();
	}

	public boolean existsById(Long id) {
		return addressRepository.existsById(id);
	}

	public Address findById(Long id) {
		return addressRepository.findById(id).get();
	}

	public List<Address> findAll() {
		return addressRepository.findAll();
	}

	public List<Address> findAllById(List<Long> addressIdList) {
		return addressRepository.findAllById(addressIdList);
	}

	public void save(Address product) {
		addressRepository.save(product);
	}

	public void saveAll(List<Address> productList) {
		addressRepository.saveAll(productList);
	}

	public void update(Long id, Address newAddress) {
		Address oldAddress = addressRepository.findById(id).get();
		if (oldAddress.getId() == newAddress.getId()) {
			addressRepository.save(newAddress);
		}
	}

	public void deleteById(Long id) {
		addressRepository.deleteById(id);
	}

	public void delete(Address address) {
		addressRepository.delete(address);
	}

	public void deleteAll() {
		addressRepository.deleteAll();
	}

	public void deleteAll(List<Address> addressList) {
		addressRepository.deleteAll(addressList);
	}

	public void deleteAllById(List<Long> addressIdList) {
		addressRepository.deleteAllById(addressIdList);
	}

	public List<Address> doPaginationAndSorting(int pageNumber, int pageSize, String[] sortBy, String sortDir) {
		List<Order> orderList = new ArrayList<>();
		for (int i = 0; i < sortBy.length; i++) {
			Order order;
			if (sortDir.equalsIgnoreCase(Sort.Direction.ASC.name())) {
				order = new Order(Sort.Direction.ASC, sortBy[i]);
			} else {
				order = new Order(Sort.Direction.DESC, sortBy[i]);
			}
			orderList.add(order);
		}
		Sort sort = Sort.by(orderList);
		Pageable pageable = PageRequest.of(pageNumber, pageSize, sort);
		Page<Address> page = addressRepository.findAll(pageable);
		List<Address> addressList = page.getContent();
		return addressList;
	}

}
