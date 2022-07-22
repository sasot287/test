/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author sarah
 */
public class Invoice_Tablemodel extends AbstractTableModel{
    private ArrayList <Invoice_data> data;
   private String[] cols={"invoice_id","cstoer","date","total"};
  
          public  Invoice_Tablemodel(ArrayList <Invoice_data> data)
  
    {this.data=data;}
          
            @Override
    public int getRowCount() {
        return data.size();
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int getColumnCount() {
       // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    return cols.length;  }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
    //    throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
   Invoice_data invd=data.get(rowIndex);
   switch(columnIndex){
       case  0:
               return invd.getNum();
       case  1:
               return invd.getCustomer();
                case  2:
                    //return invd.getDat();
                    LocalDate x = invd.getDat();
                   x.format(DateTimeFormatter.ofPattern("dd-YYYY"));
            return x.format(DateTimeFormatter.ofPattern("dd-MM-YYYY"));
                case 3: return invd.total();
               
            }
   return "";
    }

    @Override
    public String getColumnName(int column) {
        return cols[column]; // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }
    
    
}
