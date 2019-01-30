/*
 *  
Java18-OOJ
 */
package shoestore;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.swing.JOptionPane;
import shoestore.modell.Brand;
import shoestore.modell.Category;
import shoestore.modell.Color;
import shoestore.modell.Customer;
import shoestore.modell.Orderform;
import shoestore.modell.Shoe;

/**
 *
 * @author xingao
 */
public class Controller {
   Repository repo= new Repository();
   
   public Customer checkLogin (String username,String password){
       List<Customer> customers=repo.getAllCustomers();
       for(Customer c:customers){
           if(username.equals(c.getFirstname())){
               if(password.equals(c.getPassword())){                                
                   return c;
               }
               else
                   JOptionPane.showMessageDialog(null,"Invalid Login Details","Login Error",JOptionPane.ERROR_MESSAGE);
           }
       }
       return null;
   }
   
   public List<Orderform> addOrderformsforCustomer(Customer c){
       List<Orderform> unexpeditedorderforms=repo.getOrderformsforCustomerbyCustomer(c.getId()).
               stream().filter(o->o.getExpedited()==0).collect(Collectors.toList());      
       return unexpeditedorderforms;
   }

   
   public List<Category> addCategoriesItems(){
       List<Category> categorys=repo.getAllCategories();
       return categorys;
   }
   
   public List<Brand> addBrandsItems(){
       List<Brand> brands=repo.getAllBrands();
       return brands;
   }
   
   public List<Color> addColorsItems(){
       List<Color> colors=repo.getAllColors();
       return colors;
   }
   
//   public List<Shoe> showSelectedShoes(String categoryname,String brandname,String colorname){
//       List<Shoe> compliantShoes = new LinkedList<>();
//       for(Shoe s:repo.getAllShoes()){
//           if(categoryname.equals(s.getCategory().getName()) 
//              && brandname.equals(s.getBrand().getName())
//              && colorname.equals(s.getColor().getName())
//              && s.getStockNumber()>0){
//              compliantShoes.add(s);
//           }
//       }
//       return compliantShoes;
//   }
//   
   public List<Shoe> showSelectedShoes(String categoryname,String brandname,String colorname){
       List<Shoe> compliantShoes = repo.getAllShoes().stream().
                     filter(s->categoryname.equals(s.getCategory().getName()) 
                     && brandname.equals(s.getBrand().getName())
                     && colorname.equals(s.getColor().getName())
                     && s.getStockNumber()>0).collect(Collectors.toList());
                   
       return compliantShoes;
   }
   
//   public List<Orderform> showSelectedOrderforms(String date,String cityname,Customer customer){
//       List<Orderform> compliantOrderforms = new LinkedList<>();
//       for(Orderform o:repo.getOrderformsforCustomerbyCustomer(customer.getId())){
//           if(date.equals(o.getOrderdate().toString())
//              && cityname.equals(o.getCity())){
//              compliantOrderforms.add(o);
//           }
//       }
//       return compliantOrderforms;
//   }
   
    public List<Orderform> showSelectedOrderforms(String date,String cityname,Customer customer){
       List<Orderform> compliantOrderforms = repo.getOrderformsforCustomerbyCustomer(customer.getId()).
                            stream().filter(o->date.equals(o.getOrderdate().toString())
                            && cityname.equals(o.getCity())).collect(Collectors.toList());
              
       return compliantOrderforms;
   }
   
   
   public void AddToCart(Customer c,int orderformid,int shoeid){
       repo.callAddToCart(c.getId(), orderformid, shoeid);
   }
}
