package com.vpllop.mipetstore.control;

import java.sql.Connection;
import java.sql.SQLException;
import javax.naming.InitialContext;
import javax.sql.DataSource;

/**
 *
 * @author J746869
 */
public class ConnectionPool {

    private static ConnectionPool pool = null;
    private static DataSource dataSource = null;
    private static String JNDI = "BancoDB";

    public static ConnectionPool getInstance() {
        if (pool == null) {
            pool = new ConnectionPool();
        }
        return pool;
    }

    private ConnectionPool() {
        try {
            InitialContext ic = new InitialContext();
            dataSource = (DataSource) ic.lookup(JNDI);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public Connection obtenerConnection() {
        try {
            return dataSource.getConnection();
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public void liberarConnection(Connection c) {
        try {
            c.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
