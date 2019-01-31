/*
 *  
Java18-OOJ
 */
package shoestore;

import shoestore.modell.Shoe;
import shoestore.modell.Orderform;
import shoestore.modell.Customer;
import shoestore.modell.Brand;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import shoestore.modell.Category;
import shoestore.modell.Color;

/**
 *
 * @author xingao
 */
public class Repository {
    private Properties p= new Properties();
    public Repository(){
        try {
            p.load(new FileInputStream("src/shoestore/Setting.properties"));
//            Class.forName("com.mysql.jdbc.Driver");
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    public List<Customer> getAllCustomers(){
        List<Customer> customers = new ArrayList<>();
        String query="select * from customer; ";
        
        try (Connection con = DriverManager.getConnection(p.getProperty("connectionString"),
                             p.getProperty("username"),
                             p.getProperty("password"));
            Statement stmt = con.createStatement();
            ResultSet rs =stmt.executeQuery(query);){
            while (rs.next()) {
               Customer temp=new Customer(rs.getInt("id"), rs.getString("firstname"),rs.getString("surname"),
                                          rs.getString("password"));
               customers.add(temp);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return customers;
    }
    
    
    public List<Category> getAllCategories(){
         List<Category> categories = new ArrayList<>();
        String query="select * from category;";
        try (Connection con = DriverManager.getConnection(p.getProperty("connectionString"),
                             p.getProperty("username"),
                             p.getProperty("password"));
            Statement stmt = con.createStatement();
            ResultSet rs =stmt.executeQuery(query);){
               
            while (rs.next()) {
              Category temp=new Category(rs.getInt("idcategory"),rs.getString("name"));
              categories.add(temp);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return categories; 
    }
       
    public List<Brand> getAllBrands(){
         List<Brand> brands = new ArrayList<>();
        String query="select * from brand;";
        try (Connection con = DriverManager.getConnection(p.getProperty("connectionString"),
                             p.getProperty("username"),
                             p.getProperty("password"));
            Statement stmt = con.createStatement();
            ResultSet rs =stmt.executeQuery(query);){
               
            while (rs.next()) {
              Brand temp=new Brand(rs.getInt("idbrand"),rs.getString("name"));
              brands.add(temp);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return brands; 
    }
    
    public List<Color> getAllColors(){
         List<Color> colors = new ArrayList<>();
        String query="select * from color;";
        try (Connection con = DriverManager.getConnection(p.getProperty("connectionString"),
                             p.getProperty("username"),
                             p.getProperty("password"));
            Statement stmt = con.createStatement();
            ResultSet rs =stmt.executeQuery(query);){
               
            while (rs.next()) {
              Color temp=new Color(rs.getInt("idcolor"),rs.getString("name"));
              colors.add(temp);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return colors; 
    }
    public List<Shoe> getAllShoes(){
        List<Shoe> shoes = new ArrayList<>();
        String query="select shoe.idshoe,model.name,shoe.size,shoe.price,color.name,"
                + "brand.name,category.name,shoe.stockNumber from shoe "
                + "inner join color on shoe.colorId=color.idcolor "
                + "inner join brand on shoe.brandId=brand.idbrand "
                + "inner join classify on classify.shoeId=shoe.idshoe "
                + "inner join category on classify.categoryId=category.idcategory "
                + "inner join model on shoe.nameId=model.idmodel;";
        try (Connection con = DriverManager.getConnection(p.getProperty("connectionString"),
                             p.getProperty("username"),
                             p.getProperty("password"));
            Statement stmt = con.createStatement();
            ResultSet rs =stmt.executeQuery(query);){
               
            while (rs.next()) {
              Shoe temp=new Shoe();
              temp.setId(rs.getInt("shoe.idshoe"));
              temp.setName(rs.getString("model.name"));
              temp.setSize(rs.getInt("shoe.size"));
              temp.setPrice(rs.getInt("shoe.price"));
              temp.setColor(new Color(rs.getString("color.name")));
              temp.setBrand(new Brand(rs.getString("brand.name")));
              temp.setCategory(new Category(rs.getString("category.name")));
              temp.setStockNumber(rs.getInt("shoe.stockNumber"));
              shoes.add(temp);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return shoes; 
    }
  
    
    public List<Orderform> getOrderformsforCustomerbyCustomer(int customerId){
        List<Orderform> orderforms = new ArrayList<>();
        ResultSet rs =null;
        String query="select idorderform,customerId,orderdate,city.name,"
                + "expedited,shoeId,shoeQuantity from orderform "
                + "inner join orderItems on idorderform=orderItems.orderformId "
                + "inner join city on city.idcity=orderform.cityId "
                + "inner join customer on customer.id=orderform.customerId "
                + "where customerId= ? ;";
        
        try (Connection con = DriverManager.getConnection(p.getProperty("connectionString"),
                             p.getProperty("username"),
                             p.getProperty("password"));
            PreparedStatement stmt = con.prepareStatement(query);){
            stmt.setInt(1, customerId);
            rs = stmt.executeQuery();
            while (rs.next()) {              
               Orderform temp=new Orderform();
               temp.setId(rs.getInt("idorderform"));
               temp.setCustomerId(rs.getInt("customerId"));
               temp.setCity(rs.getString("city.name"));
               temp.setOrderdate(rs.getString("orderdate"));
               temp.setShoe(rs.getInt("shoeId"));
               temp.setShoequantity(rs.getInt("shoeQuantity"));
               temp.setExpedited(rs.getInt("expedited"));
               orderforms.add(temp);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return orderforms;
    }
    
    
    
    
    
     public void callAddToCart(int customerId,int orderformId,int shoeId){
        ResultSet rs =null;
        String query="call AddToCart( ?, ?,? ); ";
                       
        try (Connection con = DriverManager.getConnection(p.getProperty("connectionString"),
                             p.getProperty("username"),
                             p.getProperty("password"));
            PreparedStatement stmt = con.prepareStatement(query);){
            stmt.setInt(1, customerId);
            stmt.setInt(2, orderformId);
            stmt.setInt(3,shoeId);
            rs = stmt.executeQuery();
            }
        catch (Exception e){
            e.printStackTrace();
        }
      
    }
    
    
}
