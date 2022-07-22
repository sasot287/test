/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.text.DateFormat;
import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author sarah
 */
public class Invoice_data {
    private int Num;
    private String Customer;
    private LocalDate Dat;
    private ArrayList<Items> Itl;
    private  double Invoice_total;
   
    public Invoice_data(int num, String customer, LocalDate  dat) {
        this.Num = num;
        this.Customer = customer;
        this.Dat = dat;
    }

    public LocalDate getDat() {
        Dat.format(DateTimeFormatter.ofPattern("dd-MM-YYYY"));
        return Dat;
    }

    public void setDat(LocalDate dat) {
        this.Dat = dat;
    }

    public int getNum() {
        return Num;
    }

    public void setNum(int num) {
        this.Num = num;
    }

    public String getCustomer() {
        return Customer;
    }

    public void setCustomer(String customer) {
        this.Customer = customer;
    }

    public ArrayList<Items> getitl() {
        if(Itl==null)
        {Itl=new ArrayList<>();}
        return Itl;
    }

    public void setLine(ArrayList<Items> itl) {
        this.Itl = itl;
    }

       public double total() {
           double total=0;
           for(Items line: getitl())
           {total+=line.getCount()*line.getPrice();}
        return total;
    }
    @Override
    public String toString() {
        return Num + ","+ Customer+"," +   Dat.format(DateTimeFormatter.ofPattern("dd-MM-YYYY"));
    }
    
    
    
}
