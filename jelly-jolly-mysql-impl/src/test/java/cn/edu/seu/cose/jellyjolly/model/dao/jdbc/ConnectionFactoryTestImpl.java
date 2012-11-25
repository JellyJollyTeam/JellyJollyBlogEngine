///*
// * To change this template, choose Tools | Templates
// * and open the template in the editor.
// */
//package cn.edu.seu.cose.jellyjolly.model.dao.jdbc;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.SQLException;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//
///**
// *
// * @author Administrator
// */
//public class ConnectionFactoryTestImpl implements ConnectionFactory{
//
//    private static final String JDBC_DRIVER_CLASS_NAME = "com.mysql.jdbc.Driver";
//
//    private static final String JDBC_BASE_URL =
//            "jdbc:mysql://127.0.0.1:3306/jellyjolly_schema?useUnicode=true"
//            +"&characterEncoding=UTF-8";
//
//    private String jdbcUrl;
//
//    private String username;
//
//    private String password;
//
//
//    protected ConnectionFactoryTestImpl() {
//        jdbcUrl = JDBC_BASE_URL ;
//        username = "root";
//        password = "root";
//        try {
//            Class.forName(JDBC_DRIVER_CLASS_NAME);
//        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(ConnectionFactoryTestImpl.class.getName())
//                    .log(Level.SEVERE, null, ex);
//        }
//    }
//
//    public Connection newConnection() throws JdbcDataAccessException {
//        try {
//            return DriverManager.getConnection(jdbcUrl, username,password);
//        } catch (SQLException ex) {
//            Logger.getLogger(ConnectionFactoryTestImpl.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
//            throw new JdbcDataAccessException(ex);
//        }
//    }
//
//    public void closeConnection(Connection connection) throws JdbcDataAccessException {
//        try{
//            if(connection != null)
//                connection.close();
//        } catch (SQLException ex) {
//            Logger.getLogger(ConnectionFactoryTestImpl.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
//            throw new JdbcDataAccessException(ex);
//        }
//    }
//
//    public void rollbackConnection(Connection connection) throws JdbcDataAccessException {
//        try{
//            if(connection != null)
//                connection.rollback();
//        } catch (SQLException ex) {
//            Logger.getLogger(ConnectionFactoryTestImpl.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
//            throw new JdbcDataAccessException(ex);
//        }
//    }
//
//}
