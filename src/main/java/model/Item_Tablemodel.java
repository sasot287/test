/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author sarah
 */
public class Item_Tablemodel extends AbstractTableModel{
 private String[] cols={"item","price","count","total"};
 private ArrayList <Items> ldata;
  public  Item_Tablemodel(ArrayList <Items> ldata)
  
    {this.ldata=ldata;}
    @Override
    public int getRowCount() {
       // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
if(ldata==null )     
{return 0;}
return ldata.size();
    }

    @Override
    public int getColumnCount() {
      //  throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
     return cols.length; 
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
       // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    
    Items header=ldata.get(rowIndex);
   switch(columnIndex){
       case  0:
               return header.getName();
       case  1:
               return header.getPrice();
                case  2:
               return header.getCount();
                case 3:
                    return header.getPrice()*header.getCount();
               
            }
   return "";}
     @Override
    public String getColumnName(int column) {
        return cols[column]; // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }
}
