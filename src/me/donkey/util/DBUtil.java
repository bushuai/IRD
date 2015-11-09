package me.donkey.util;

import java.sql.*;
import java.util.List;

public class DBUtil {
    private static final String DRIVER   = "com.mysql.jdbc.Driver";
    private static final String USER     = "root";
    private static final String PASSWORD = "root";
    private static final String URL      = "jdbc:mysql://localhost:3306/house";
    private Connection        connection;
    private ResultSet         resultSet;
    private PreparedStatement preparedStatement;

    /**
     * get a database connection
     *
     * @return a database connection
     */
    public Connection getConnection() {
        try {
            Class.forName( DRIVER );
            connection = DriverManager.getConnection( URL, USER, PASSWORD );
        } catch(Exception e) {
            e.printStackTrace();
        }
        return connection;
    }

    /**
     * ִ���в����ѯ����ѯ
     *
     * @param sql
     * @param arguments
     */
    public ResultSet executeQuery( String sql, List<?> arguments ) {
        try {
            this.generate( sql, arguments );
            return preparedStatement.executeQuery();
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     *
     *
     * @param sql SQL statements
     *
     * @return the effected rows
     */
    public int query( String sql, List<?> arguments ) {
        try {
            this.generate( sql, arguments );
            return preparedStatement.executeUpdate();
        } catch(Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    /**
     * generate sql statement for execute
     *
     * @param sql       SQL statement
     * @param arguments SQL arguments
     *
     * @return
     *
     * @throws SQLException
     */
    public void generate( String sql, List<?> arguments ) throws SQLException {
        preparedStatement = this.getConnection().prepareStatement( sql );
        if( arguments != null && arguments.size() > 0 ) {
            int length = arguments.size();
            for( int i = 0; i < length; i++ ) {
                preparedStatement.setString( i + 1, (String) arguments.get( i ) );
            }
        }
        System.out.println( "sql====" + sql );
    }

    /**
     * close connection
     */
    public void close() {

        try {
            if( this.connection != null ) this.connection.close();
            if( this.resultSet != null ) this.resultSet.close();
            if( this.preparedStatement != null ) this.preparedStatement.close();
        } catch(SQLException e) {
            e.printStackTrace();
        }

    }
}
