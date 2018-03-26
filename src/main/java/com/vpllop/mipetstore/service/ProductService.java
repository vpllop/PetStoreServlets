package com.vpllop.mipetstore.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.vpllop.mipetstore.beans.Category;
import com.vpllop.mipetstore.beans.Item;
import com.vpllop.mipetstore.beans.Product;
import com.vpllop.mipetstore.db.DBConnection;

public class ProductService {
    
        private List<Category> categories = null;
	private List<Product> products = null;
        private List<String> subProducts = null;
	private List<Item> items = null;
	private String categoryName;

        // Method to get all the available Categories
	public List<Category> getAllCategories() {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql;
		conn = DBConnection.getConnecton();
		sql = "select catid, name, descn  from category";
		categories = new ArrayList<Category>();

		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				Category c = new Category(rs.getString("catid"),
                                        rs.getString("name"),
                                        rs.getString("desc")
                                );
				categories.add(c);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

			try {
				if (ps != null) {
					ps.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

	
		}
		return categories;
	}
        
	// Method to get all products available
	public List<Product> getAllProducts() throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql;
		conn = DBConnection.getConnecton();
		sql = "select * from products";
		products = new ArrayList<Product>();

		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				Product p = new Product(rs.getString("productid"),
						rs.getString("category"),
						rs.getString("name"),
						rs.getString("desc")
						);
				products.add(p);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				rs.close();
			}
			if (ps != null) {
				ps.close();
			}
		}

		return products;

	}

	// Method to get the required Product Details
	public Product getProductDetails(String productid) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql;
		conn = DBConnection.getConnecton();
		Product p = new Product();
		sql = "select productid,category,name,desc from product where productid=?";

		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, productid);
			rs = ps.executeQuery();
			while (rs.next()) {
				p.setProductid(productid);
				p.setCategory(rs.getString(1));
                                p.setName(rs.getString(2));
				p.setDesc(rs.getString(3));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

			try {
				if (ps != null) {
					ps.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return p;
	}

	

	// Method to get all the available Subcategories under a Category
	public List<String> getSubProduct(Category category) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql;
		conn = DBConnection.getConnecton();
		sql = "SELECT productid FROM product p where p.category = ? ";

		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, category.getCatid());
			rs = ps.executeQuery();
			subProducts = new ArrayList<String>();
			while (rs.next()) {
				subProducts.add(rs.getString("productid"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

			try {
				if (ps != null) {
					ps.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return subProducts;
	}

	// Method to get all the items based on specified Product
	public List<Item> getItemByProduct(String product) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql;
		conn = DBConnection.getConnecton();
		sql = "select itemid, productid,listprice,unitcost,supplier,status,attr1 from item where productid = ?";
		items = new ArrayList<Item>();
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, product);
			rs = ps.executeQuery();
			while (rs.next()) {
				Item i = new Item(rs.getString(1), 
                                        rs.getString(2),
					rs.getDouble(3), 
                                        rs.getDouble(4), 
                                        rs.getInt(5),
					rs.getString(6),
                                        rs.getString(7));
				items.add(i);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

			try {
				if (ps != null) {
					ps.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		return items;
	}

	// Method to get all the Products based on specified SubCategory
	

	// Method to get Product Category
	// based on Sub Category
	public String getCategoryBySubCategory(String subCategory) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql;
		conn = DBConnection.getConnecton();
		sql = "select productCategory from subcategory where productSubCategory=?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, subCategory);
			rs = ps.executeQuery();
			while (rs.next()) {
				categoryName = rs.getString("productCategory");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		return categoryName;
	}
}
