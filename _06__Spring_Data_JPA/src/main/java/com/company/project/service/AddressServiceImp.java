package com.company.project.service;

import java.util.List;
import java.util.ArrayList;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.company.project.repository.AddressRepository;
import com.company.project.service.interfaces.AddressService;
import com.company.project.entity.Address;
import org.springframework.data.domain.*;

@Service(value = "service_address")
public class AddressServiceImp implements AddressService {

    private final AddressRepository addressRepository;

    @Autowired
    public AddressServiceImp(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public List<Address> doPaginationAndSorting(int pageNumber, int pageSize, String[] sortBy, String sortDir) {
        List<Sort.Order> orderList = new ArrayList<>();
        for (int i = 0; i < sortBy.length; i++) {
            Sort.Order order;
            if (sortDir.equalsIgnoreCase(Sort.Direction.ASC.name())) {
                order = new Sort.Order(Sort.Direction.ASC, sortBy[i]);
            } else {
                order = new Sort.Order(Sort.Direction.DESC, sortBy[i]);
            }
            orderList.add(order);
        }
        Sort sort = Sort.by(orderList);
        Pageable pageable = PageRequest.of(pageNumber, pageSize, sort);
        Page<Address> page = addressRepository.findAll(pageable);
        List<Address> addressList = page.getContent();
        return addressList;
    }

    @Override
    public Address createAddress(Address address) throws Exception {
        return null;
    }

    @Override
    public List<Address> createAddresses(List<Address> addressList) throws Exception {
        return null;
    }

    @Override
    public Address readAddress(Long id) throws Exception {
        return null;
    }

    @Override
    public List<Address> readAddresses() {
        return null;
    }

    @Override
    public Address updateAddress(Long id, Address address) throws Exception {
        return null;
    }

    @Override
    public String deleteAddress(Long id) throws Exception {
        return null;
    }

    @Override
    public Address patchAddress(Long id, Address address) throws Exception {
        return null;
    }

}
