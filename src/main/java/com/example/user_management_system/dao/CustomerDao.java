package com.example.user_management_system.dao;

import com.example.user_management_system.model.Customer;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class CustomerDao {

    private static Map<Integer, Customer> customers;

    static{
        customers = new HashMap<>();
        customers.put(1, new Customer(1, "李七", "93745656", "上海光明南路七号", "2020-10-20"));
    }

    private static Integer id = 2;

    public Collection<Customer> getAll(){
        return customers.values();
    }

    public Customer getCustomerById(Integer id){
        return customers.get(id);
    }

    public void add(Customer customer){
        if(customer.getId() == null)
            customer.setId(id++);
        customers.put(customer.getId(), customer);
    }

    public void deleteCustomerById(Integer id){
        customers.remove(id);
    }
}
