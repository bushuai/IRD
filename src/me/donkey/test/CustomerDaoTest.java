package me.donkey.test;

import me.donkey.dao.CustomerDao;
import me.donkey.dao.impl.CustomerDaoImpl;
import me.donkey.entity.Customer;

public class CustomerDaoTest {

    public static void main( String[] args ) {
        // TODO Auto-generated method stub
        CustomerDao csdao = new CustomerDaoImpl();
        Customer customer = new Customer();
        customer.setLoginId( "new" );
        customer.setPassword( "newpwd" );
        if( csdao.addCustomer( customer ) ) {
            System.out.println( "success" );

        } else {
            System.out.println( "error" );
        }

//		if(csdao.deleteCustomerById(1012)){
//			System.out.println("success");
//		}
//		else{
//			System.out.println("error");
//		}
//        System.out.println( String.valueOf( csdao.verify( "lisi", "liasi" ) ) );

        customer.setAge( 10 );
        customer.setPhone( "12121221" );
        customer.setLoginId( "1000 ");
        customer.setId( 1009 );
        if(csdao.updateCustomer( customer )){
            System.out.println("succ");
        }else{
            System.out.println("error");
        }
    }
}
