package me.donkey.service.impl;

import me.donkey.dao.CustomerDao;
import me.donkey.dao.impl.CustomerDaoImpl;
import me.donkey.entity.Customer;
import me.donkey.service.CustomerService;

import java.util.List;

/**
 * Created by bushuai on 7/12/15.
 */
public class CustomerServiceImpl implements CustomerService {
    CustomerDao customerDao = new CustomerDaoImpl();

    @Override
    public List<Customer> getAllCustomer() {
        return customerDao.getAllCustomer();
    }

    @Override
    public boolean addCustomer( Customer customer ) {
        return customerDao.addCustomer( customer );
    }

    @Override
    public Customer getCustomerById( int id ) {
        return customerDao.getCustomerById( id );
    }

    @Override
    public Customer getCustomerByLoginId( String loginId ) {
        return customerDao.getCustomerByLoginId( loginId );
    }

    @Override
    public boolean verify( String loginId, String password ) {
        return customerDao.verify( loginId, password );
    }

    @Override
    public boolean updateCustomer( Customer customer ) {
        return customerDao.updateCustomer( customer );
    }

    @Override
    public boolean deleteCustomerById( int id ) {
        return customerDao.deleteCustomerById( id );
    }

    @Override
    public boolean deleteCustomerByLoginId( String loginId ) {
        return customerDao.deleteCustomerByLoginId( loginId );
    }
}
