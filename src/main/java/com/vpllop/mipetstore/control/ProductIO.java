
package com.vpllop.mipetstore.control;

import com.vpllop.mipetstore.beans.Product;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author J746869
 */
public class ProductIO {
    //    Aquí van las sentencias SQL para cada una de las operaciones de recuperación, búsqueda, alta,
//actualización y eliminación de Products en la base de datos. Todas las SQLs son parametrizadas.

    private static String SQL_LISTAR = "SELECT productid, category, name, descn FROM PRODUCT";
    private static String SQL_FILTRAR = SQL_LISTAR
            + " WHERE category LIKE ?";
    private static String SQL_OBTENER = SQL_LISTAR
            + " WHERE productid = ?";
    private static String SQL_ACTUALIZAR = "UPDATE PRODUCT SET name = ?, descn = ? WHERE productid = ?";
    private static String SQL_ALTA = "INSERT INTO PRODUCT (productid, category, name, descn) VALUES (?,?,?,?);";
    private static String SQL_ELIMINAR = "DELETE FROM PRODUCT WHERE productid = ?";

//    Este método devuelve el objeto Consulta correspondiente con el nº de Product indicado , que es la clave primaria de la tabla ProductS en la base de datos.Si no existe la Product retorna NULL.
    public static Product obtener(String productid) throws SQLException {
        
        Connection con = Conexion.obtenerConnection();
        PreparedStatement st = null;
        ResultSet rs = null;
        Product objProduct = null;
        try {
            st = con.prepareStatement(SQL_OBTENER);
            st.setString(1, productid);
            rs = st.executeQuery();
            if (rs.next()) {
                objProduct = getObject(rs);
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (st != null) {
                st.close();
            }
            con.close();
        }
        return objProduct;
    }

//    Este método retorna una colección ArrayList genérica de objetos Product correspondientes a todos los
//    registros contenidos en la tabla ProductS de la base de datos.Si no hay ninguna Product retorna una colección
//    vacía(no NULL)
    public static ArrayList<Product> listar() throws SQLException {
       Connection con = Conexion.obtenerConnection();
        PreparedStatement st = null;
        ResultSet rs = null;
        ArrayList<Product> resultado = new ArrayList<Product>();
        try {
           
            st = con.prepareStatement(SQL_LISTAR);
            rs = st.executeQuery();
            while (rs.next()) {
                resultado.add(getObject(rs));
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (st != null) {
                st.close();
            }
           con.close();
        }
        return resultado;
    }

//    Este método retorna una colección ArrayList genérica de objetos Product pertenecientes a un
//determinado titular. Si no hay ninguna Product retorna una colección vacía ( no NULL ).
    public static ArrayList<Product> filtrar(String category) throws SQLException {
        Connection con = Conexion.obtenerConnection();
        PreparedStatement st = null;
        ResultSet rs = null;
        ArrayList<Product> resultado = new ArrayList<Product>();
        try {
            st = con.prepareStatement(SQL_FILTRAR);
            st.setString(1, category);
            rs = st.executeQuery();
            while (rs.next()) {
                resultado.add(getObject(rs));
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (st != null) {
                st.close();
            }
            con.close();
        }
        return resultado;
    }

//    Este método actualiza en la base de datos los campos del registro Product correspondiente al objeto
//    Product indicado como parámetro
    public static void actualizar(Product objProduct) throws SQLException {
        ConnectionPool pool = null;
        Connection con = null;
        PreparedStatement st = null;
        try {
            pool = ConnectionPool.getInstance();
            con = pool.obtenerConnection();
            st = con.prepareStatement(SQL_ACTUALIZAR);
            st.setString(1, objProduct.getName());
            st.setString(2, objProduct.getDesc());
            st.setString(3, objProduct.getProductid());
            st.executeUpdate();
        } finally {
            if (st != null) {
                st.close();
            }
            pool.liberarConnection(con);
        }
    }

//Este método elimina el registro de la tabla ProductS correspondiente al objeto Product indicado como
//parámetro.
    public static void eliminar(String productid) throws SQLException {
        ConnectionPool pool = null;
        Connection con = null;
        PreparedStatement st = null;
        try {
            pool = ConnectionPool.getInstance();
            con = pool.obtenerConnection();
            st = con.prepareStatement(SQL_ELIMINAR);
            st.setString(1, productid);
            st.executeUpdate();
        } finally {
            if (st != null) {
                st.close();
            }
            pool.liberarConnection(con);
        }
    }

//    Este método inserta en la tabla ProductS un nuevo registro con los valores del objeto Product indicado
//como parámetro.
    public static void alta(Product objProduct) throws SQLException {
        ConnectionPool pool = null;
        Connection con = null;
        PreparedStatement st = null;
        try {
            pool = ConnectionPool.getInstance();
            con = pool.obtenerConnection();
            st = con.prepareStatement(SQL_ALTA);
            st.setString(1, objProduct.getProductid());
            st.setString(2, objProduct.getName());
            st.setString(3, objProduct.getCategory());
            st.setString(4, objProduct.getDesc());
            st.executeUpdate();
        } finally {
            if (st != null) {
                st.close();
            }
            pool.liberarConnection(con);
        }
    }

//    Este es un método auxiliar que lee los campos del registro apuntado por el objeto ResultSet resultante
//de una consulta y retorna el objeto Product correspondiente. Este método es empleado por los métodos
//listar(), obtener() y filtrar().
    private static Product getObject(ResultSet rs) throws SQLException {
        Product objProduct = new Product();
        objProduct.setProductid(rs.getString("productid"));
        objProduct.setCategory(rs.getString("name"));
        objProduct.setName(rs.getString("Category"));
        objProduct.setDesc(rs.getString("descn"));
        return objProduct;
    }
}
