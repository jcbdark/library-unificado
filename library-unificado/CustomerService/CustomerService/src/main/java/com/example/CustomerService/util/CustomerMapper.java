package com.example.CustomerService.util;

import com.example.CustomerService.dto.CustomerDTO;
import com.example.CustomerService.entity.Customer;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    CustomerDTO toDTO(Customer customer);
    Customer toEntity(CustomerDTO dto);

    List<CustomerDTO> toDTOs(List<Customer> customers);
    List<Customer> toEntities(List<CustomerDTO> customerDTOs);
}
