package me.donkey.dao;

import me.donkey.entity.Customer;

import java.util.List;

public interface CustomerDao {

    public List<Customer> getAllCustomer();

    public boolean addCustomer( Customer customer );
    
    public Customer getCustomerById( int id );
    
    public Customer getCustomerByLoginId( String loginId );

    public boolean verify( String loginId, String password );
 
    public boolean updateCustomer( Customer customer );

    public boolean deleteCustomerById( int id );

    public boolean deleteCustomerByLoginId( String loginId );
}
