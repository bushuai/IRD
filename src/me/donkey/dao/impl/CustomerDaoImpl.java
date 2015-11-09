package me.donkey.dao.impl;

import me.donkey.dao.CustomerDao;
import me.donkey.entity.Customer;
import me.donkey.util.DBUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerDaoImpl implements CustomerDao {

    DBUtil db = new DBUtil();
    List<String> arguments;
    String       sql;
    ResultSet    resultSet;
    Customer     customer;

    @Override
    public List<Customer> getAllCustomer() {
        sql = "select * from customer";
        resultSet = db.executeQuery( sql, null );
        List<Customer> customers = new ArrayList();

        try {
            while( resultSet.next() ) {
                customer = new Customer();
                customer.setId( Integer.parseInt( resultSet.getString( "id" ) ) );
                customer.setLoginId( resultSet.getString( "loginId" ) );
                customer.setPassword( resultSet.getString( "password" ) );
                customer.setPhone( resultSet.getString( "phone" ) );
                customer.setAge( Integer.parseInt( resultSet.getString( "age" ) ) );
                customer.setAddress( resultSet.getString( "address" ) );
                customer.setName( resultSet.getString( "name" ) );
                customers.add( customer );
            }
        } catch(NumberFormatException | SQLException e) {
            e.printStackTrace();
            return null;
        }
        return customers;
    }

    @Override
    public boolean addCustomer( Customer customer ) {
        arguments = new ArrayList();
        sql = "insert into customer(loginId,password,name) values(?,?,?)";
        arguments.add( customer.getLoginId() );
        arguments.add( customer.getPassword() );
        arguments.add( customer.getName() );
        return (db.query( sql, arguments ) == 0) ? false : true;

    }

    @Override
    public Customer getCustomerById( int id ) {
        // TODO Auto-generated method stub
        sql = "select * from customer where id = " + id;
        resultSet = db.executeQuery( sql, null );
        try {
            if( resultSet.next() ) {
                customer = new Customer();
                customer.setId( resultSet.getInt( "id" ) );
                customer.setLoginId( resultSet.getString( "loginId" ) );
                customer.setPassword( resultSet.getString( "password" ) );
                customer.setName( resultSet.getString( "name" ) );
                customer.setAge( resultSet.getInt( "age" ) );
                customer.setPhone( resultSet.getString( "phone" ) );
                customer.setAddress( resultSet.getString( "address" ) );
            }
            return customer;
        } catch(SQLException e) {
            e.printStackTrace();
            return null;
        }

    }

    @Override
    public Customer getCustomerByLoginId( String loginId ) {
        sql = "select * from customer where loginId = ? ";
        arguments = new ArrayList();
        arguments.add( loginId );
        resultSet = db.executeQuery( sql, arguments );
        try {
            if( resultSet.next() ) {
                customer = new Customer();
                customer.setId( resultSet.getInt( "id" ) );
                customer.setLoginId( resultSet.getString( "loginId" ) );
                customer.setPassword( resultSet.getString( "password" ) );
                customer.setName( resultSet.getString( "name" ) );
                customer.setAge( resultSet.getInt( "age" ) );
                customer.setPhone( resultSet.getString( "phone" ) );
                customer.setAddress( resultSet.getString( "address" ) );
            }
            return customer;
        } catch(SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean verify( String loginId, String password ) {
        sql = "select * from customer where loginId = ? and password=?";
        arguments = new ArrayList();
        arguments.add( loginId );
        arguments.add( password );
        System.out.println( arguments.toString() );
        try {
            if( db.executeQuery( sql, arguments ).next() ) return true;
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean updateCustomer( Customer customer ) {
        sql = "update customer set loginId = ?,password = ? ,name = ? ,age=?,address = ?,phone=? where id=?";
        System.out.println( sql );
        arguments = new ArrayList();
        arguments.add( customer.getLoginId() );
        arguments.add( customer.getPassword() );
        arguments.add( customer.getName() );
        arguments.add( String.valueOf( customer.getAge() ) );
        arguments.add( customer.getAddress() );
        arguments.add( customer.getPhone() );
        arguments.add( String.valueOf( customer.getId() ) );
        return (db.query( sql, arguments ) == 0) ? false : true;
    }

    @Override
    public boolean deleteCustomerById( int id ) {
        arguments = new ArrayList();
        sql = "delete from customer where id = ?";
        arguments.add( String.valueOf( id ) );
        return (db.query( sql, arguments ) == 0) ? false : true;
    }

    @Override
    public boolean deleteCustomerByLoginId( String loginId ) {
        return false;
    }

}
