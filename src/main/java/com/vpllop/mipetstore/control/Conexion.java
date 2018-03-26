/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vpllop.mipetstore.control;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Connection;

/**
 *
 * @author J746869
 */
public class Conexion {

    private static String dbURL = "jdbc:postgresql://localhost:5432/petstoredb";
    private static String dbUser = "petuser";
    private static String dbPass = "petuser";
    private static Connection con = null;

    public static Connection obtenerConnection() {

        try {
            Class.forName("org.postgresql.jdbc.Driver");
            con = DriverManager.getConnection(dbURL, dbUser, dbPass);

        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Connection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con;
    }

    public void liberarConnection(Connection c) {
        try {
            c.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
