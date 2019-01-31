/*
 *  
Java18-OOJ
 */
package shoestore.modell;

/**
 *
 * @author xingao
 */
public class Shoe {
    
    private int id;
    
    private String name;
    
    private int size;
    
    private int price;
    
    private Color color;
    
    private Brand brand;

    private Category category; 
    
    private int stockNumber;

    

    

    public Shoe() {
     
    }

    public Shoe(int id) {
        this.id = id;
    }

    
    public Shoe(int id, String name, int size, int price, Color color, Brand brand, Category category) {
        this.id = id;
        this.name = name;
        this.size = size;
        this.price = price;
        this.color = color;
        this.brand = brand;
        this.category = category;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getSize() {
        return size;
    }

    public int getPrice() {
        return price;
    }

    public Color getColor() {
        return color;
    }

    public Brand getBrand() {
        return brand;
    }

    public Category getCategory() {
        return category;
    }
    
    public int getStockNumber() {
        return stockNumber;
    }

    public void setStockNumber(int stockNumber) {
        this.stockNumber = stockNumber;
    }

    public String ShoeInfo() {
        return name + "\t" + size+"\t"+price+"\t"+color.getName() + "\t" + brand.getName() + "\t" + category.getName();
    }
    
    

}
