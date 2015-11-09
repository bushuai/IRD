package me.donkey.action;

import me.donkey.entity.Customer;
import me.donkey.service.CustomerService;
import me.donkey.service.impl.CustomerServiceImpl;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by bushuai on 7/12/15.
 */
@WebServlet(name = "customer", urlPatterns = { "/customer.action" })
public class CustomerAction extends HttpServlet {
    CustomerService customerService = new CustomerServiceImpl();
    PrintWriter out;
    JSONObject  jsonObject;

    protected void service( HttpServletRequest request, HttpServletResponse response ) {
        String type = request.getParameter( "act" );
        switch( type ) {
            case "login":
                this.doLogin( request, response );
                break;
            case "logout":
                this.doLogout( request, response );
                break;
            case "query":
                this.doQuery( request, response );
                break;
            case "remove":
                this.doRemove( request, response );
                break;
            case "update":
                this.doUpdate( request, response );
                break;
            case "insert":
                this.doInsert( request, response );
                break;
        }
    }

    private void doLogin( HttpServletRequest request, HttpServletResponse response ) {

        try {
            out = response.getWriter();
            jsonObject = new JSONObject();
            String loginId = request.getParameter( "loginId" );
            String password = request.getParameter( "password" );
            System.out.print( "loginId=" + loginId + " password=" + password );
            if( customerService.verify( loginId, password ) ) {
                System.out.println( "login success" );
                Customer customer = customerService.getCustomerByLoginId( loginId );
                request.getSession().setAttribute( "currentUser", customer );
                jsonObject.put( "status", "success" );
                jsonObject.put( "customer", customer );
            } else {
                jsonObject.put( "status", "failed" );
            }
        } catch(IOException e) {
            e.printStackTrace();
            jsonObject.put( "status", "failed" );
        }
        out.println( jsonObject );
    }


    private void doLogout( HttpServletRequest request, HttpServletResponse response ) {
        request.getSession().removeAttribute( "currentUser" );
        try {
            request.getRequestDispatcher( "index.html" ).forward( request, response );
        } catch(ServletException | IOException e) {
            e.printStackTrace();
        }

    }


    private void doUpdate( HttpServletRequest request, HttpServletResponse response ) {

        try {
            String loginId = request.getParameter( "loginId" );
            String password = request.getParameter( "password" );
            int age = Integer.parseInt( request.getParameter( "age" ) );
            String address = request.getParameter( "address" );
            String phone = request.getParameter( "phone" );
            String name = request.getParameter( "name" );
            String id = request.getParameter( "id" );

            Customer customer = new Customer();
            customer.setLoginId( loginId );
            customer.setPassword( password );
            customer.setAge( age );
            customer.setPhone( phone );
            customer.setName( name );
            customer.setAddress( address );
            customer.setId( Integer.parseInt( id ) );
            out = response.getWriter();
            jsonObject = new JSONObject();
            if( customerService.updateCustomer( customer ) ) {
                jsonObject.put( "status", "success" );
            } else {
                jsonObject.put( "status", "failed" );
            }
        } catch(IOException e) {
            e.printStackTrace();
        }
        out.println( jsonObject );
    }


    private void doRemove( HttpServletRequest request, HttpServletResponse response ) {
        int id = Integer.parseInt( request.getParameter( "id" ) );
        jsonObject = new JSONObject();
        try {
            out = response.getWriter();
            if( customerService.deleteCustomerById( id ) ) {
                jsonObject.put( "status", "success" );
            } else {
                jsonObject.put( "statuc", "failed" );
            }
        } catch(IOException e) {
            e.printStackTrace();
        }
        out.println( jsonObject );

    }

    private void doInsert( HttpServletRequest request, HttpServletResponse response ) {
        try {
            jsonObject = new JSONObject();
            String loginId = request.getParameter( "loginId" );
            String password = request.getParameter( "password" );
            String name = request.getParameter( "name" );
            out = response.getWriter();
            Customer customer = new Customer();
            customer.setLoginId( loginId );
            customer.setPassword( password );
            customer.setName( name );
            if( customerService.addCustomer( customer ) ) {
                jsonObject.put( "status", "success" );
            } else {
                jsonObject.put( "status", "success" );
            }
        } catch(IOException e) {
            e.printStackTrace();
        }
        out.println( jsonObject );
    }

    private void doQuery( HttpServletRequest request, HttpServletResponse response ) {
        String queryType = request.getParameter( "type" );
        System.out.println( "type=" + queryType );
        try {
            out = response.getWriter();
            if( queryType.equals( "all" ) ) {
                System.out.println( "====" + customerService.getAllCustomer() );
                out.println( JSONArray.fromObject( customerService.getAllCustomer() ) );
            } else if( queryType.equals( "loginId" ) ) {
                String loginId = request.getParameter( "loginId" );
                out.println( JSONArray.fromObject( customerService.getCustomerByLoginId( loginId ) ) );
            } else {
                int id = Integer.parseInt( request.getParameter( "id" ) );
                out.println( JSONArray.fromObject( customerService.getCustomerById( id ) ) );
            }
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}
