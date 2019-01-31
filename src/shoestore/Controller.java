/*
 *  
Java18-OOJ
 */
package shoestore;

import java.util.Date;
import java.util.LinkedList;
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
         
//    public Customer checkLogin (String username,String password){
//        Map<Integer,Customer> customerMap=repo.getAllCustomers().stream()
//                .collect(Collectors.toMap(Customer::getId,Customer->Customer));
//        for(Integer key:customerMap.keySet()){
//            if(customerMap.get(key).getFirstname().equals(username.trim())){
//                if(customerMap.get(key).getPassword().equals(password.trim()))
//                    return customerMap.get(key);
//                }
//                else
//                   JOptionPane.showMessageDialog(null,"Invalid Login Details","Login Error",JOptionPane.ERROR_MESSAGE);
//        }
//       return null;
//}
     
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


   
    public Map<Integer,Category> addCategoriesItems(){
       Map<Integer,Category> categorysMap=repo.getAllCategories().stream()
                .collect(Collectors.toMap(Category::getId,Category->Category));;
       return categorysMap;
   }
   
   public Map<Integer,Brand> addBrandsItems(){
       Map<Integer,Brand> brandsMap=repo.getAllBrands().stream()
                .collect(Collectors.toMap(Brand::getId,Brand->Brand));;
       return brandsMap;
   }
   
   public Map<Integer,Color> addColorsItems(){
       Map<Integer,Color> colorsMap=repo.getAllColors().stream()
                .collect(Collectors.toMap(Color::getId,Color->Color));;
       return colorsMap;
   }
      
   public List<Shoe> showSelectedShoes(String categoryname,String brandname,String colorname){
       List<Shoe> compliantShoes = repo.getAllShoes().stream().
                     filter(s->categoryname.equals(s.getCategory().getName()) 
                     && brandname.equals(s.getBrand().getName())
                     && colorname.equals(s.getColor().getName())
                     && s.getStockNumber()>0).collect(Collectors.toList());
                   
       return compliantShoes;
   }
   
    public Map<Integer,Shoe> getAllInstockShoeMap(){
        return repo.getAllShoes().stream().filter(s->s.getStockNumber()>0).
                collect(Collectors.toMap(Shoe::getId, Shoe->Shoe));

    }
   
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
