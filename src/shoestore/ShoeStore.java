/*
 *  
Java18-OOJ
 */

package shoestore;

import shoestore.modell.Customer;


public class ShoeStore {

  
    public static void main(String[] args) {
      Repository p= new Repository();
   
//        System.out.println(p.getAllShoes().get(0));
//        System.out.println(p.getAllCustomers().get(0).getName()+ p.getAllCustomers().get(0).getPassword());
        System.out.println(p.getOrderformsforCustomerbyCustomer(1).get(0).getCity());
//        System.out.println(p.getShoesMapforOrderformbyOrderformId(1).size());
//        Controller con=new Controller();
//        con.checkLogin("Harry Potter", "Har12345");
//        System.out.println(con.showSelectedShoes("Sandals", "ecco", "black").size());
//        System.out.println(con.addOrderformsforCustomer(new Customer(1, "Harry", "Potter", "Har12345")).size());
//          p.callAddToCart(2,0,3);
//         con.AddToCart(new Customer(1, "Harry", "Potter", "Har12345"), 0, 7);
    
    }
}
