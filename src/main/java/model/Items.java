/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author sarah
 */
public class Items {
  Invoice_data invoice;
    String name;
    double price;
    int count;
    

    public Items(Invoice_data invoice, String name, double price, int count) {
        this.invoice = invoice;
        this.name = name;
        this.price = price;
        this.count = count;
      
    }

    public Invoice_data getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice_data invoice) {
        this.invoice = invoice;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
    
     public double getLineTotal() {
        return count*price;
    }

    @Override
    public String toString() {
         return invoice.getNum() + "," + name + "," + price + "," + count;}
   
}
