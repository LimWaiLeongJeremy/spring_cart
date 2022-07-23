package ssf.homework.shopping.cart.model;

import java.io.InputStream;
import java.io.OutputStream;

public class Cart {

    private String username;
    private String item;
    private int price;
    private int quantity;


  

    public Cart() {
        this.price = 0;
    }
  
    public Cart(String username) {
        this.username = username;
    }

    public Cart(String username, String item) {
        this.username = username;
        this.item = item;
    }
    
    public Cart(String username, String item, int price) {
        this.username = username;
        this.item = item;
        this.price = price;
    }

    public Cart(String username, String item, int price, int quantity) {
        this.username = username;
        this.item = item;
        this.price = price;
        this.quantity = quantity;
    }


    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public String getItem() {
        return item;
    }
    public void setItem(String item) {
        this.item = item;
    }

    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }

    public void save(OutputStream os) {
    }

    public void load(InputStream is) {
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
