
package shoestore.modell;


public class Customer {
    private int id;   
    private String firstname;   
    private String surname;
    private String password;

    public Customer(int id, String firstname, String surname, String password) {
        this.id = id;
        this.firstname = firstname;
        this.surname = surname;
        this.password = password;
    }
   

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
  
    public int getId() {
        return id;
    }
  
    public void setId(int id) {
        this.id = id;
    }

      

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

      
}
