/*
 *  
Java18-OOJ
 */
package shoestore.modell;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author xingao
 */
public class Orderform {
   
    private int id;
    
    private int customerId;
    
    private String orderdate;
    
    private String city;
    
    private int shoeId;
    
    private int shoequantity;
   
    private int expedited;
    
    private Map<Integer,Integer> shoeMap;
    
    public Orderform() {
    }

    public Orderform(int id, int customerId, String orderdate, String city, int shoeId, int shoequantity) {
        this.id = id;
        this.customerId = customerId;
        this.orderdate = orderdate;
        this.city = city;
        this.shoeId = shoeId;
        this.shoequantity = shoequantity;
    }

  

    public String getOrderdate() {
        return orderdate;
    }

    public void setOrderdate(String orderdate) {
        this.orderdate = orderdate;
    } 
    

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
   

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getShoequantity() {
        return shoequantity;
    }

    public void setShoequantity(int shoequantity) {
        this.shoequantity = shoequantity;
    }


    public int getShoe() {
        return shoeId;
    }

    public void setShoe(int shoeId) {
        this.shoeId = shoeId;
    }

    
    public int getExpedited() {
        return expedited;
    }

    public void setExpedited(int expedited) {
        this.expedited = expedited;
    }
   
    
    public String printOrderform() {
        return orderdate + " \t "+ city+" \t "+shoeId+"\t"+shoequantity;
               
    }

 
}
