package com.company.project.service.interfaces;

import java.util.List;

import com.company.project.model.Address;

public interface AddressService {

    public abstract List<Address> doPaginationAndSorting(int pageNumber, int pageSize, String[] sortBy, String sortDir);

    public abstract Address createAddress(Address address) throws Exception;

    public abstract List<Address> createAddresses(List<Address> addressList) throws Exception;

    public abstract Address readAddress(Long id) throws Exception;

    public abstract List<Address> readAddresses();

    public abstract Address updateAddress(Long id, Address address) throws Exception;

    public abstract String deleteAddress(Long id) throws Exception;

    public abstract Address patchAddress(Long id, Address address) throws Exception;

}
