/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author sarah
 */
public class create_item extends JDialog {
    
     private JTextField item;
    private JTextField price;
    private JLabel itemlabel;
    private JLabel pricelabel;
    private JButton ok;
    private JButton cancel;
private JTextField i_cont;
    private JLabel icontlabel;
    public create_item(invoice frame) {
        itemlabel = new JLabel("item Name:");
        price = new JTextField(25);
        item=new JTextField(25);
        pricelabel = new JLabel("price:");
        price = new JTextField(25);
        icontlabel = new JLabel("cont:");
        i_cont = new JTextField(25);
        ok = new JButton("OK");
        cancel = new JButton("Cancel");
        
        ok.setActionCommand("Itemok");
        cancel.setActionCommand("Itemcancel");
        
        ok.addActionListener(frame.getHandler());
        cancel.addActionListener(frame.getHandler());
        setLayout(new GridLayout(5,6));
        
         add(itemlabel);
         add(item);
         add(pricelabel);
         add(price);
         add(icontlabel);
        add(i_cont);

   add(ok);
  add(cancel);

       /* SimpleDateFormat formatter= new SimpleDateFormat("dd-mm-yyyy");
        String date = formatter.format(System.currentTimeMillis());
        invoiceDate.setText(date);*/

        
        pack();
        
    }

    public JTextField getItem() {
        return item;
    }

    public JTextField getPrice() {
        return price;
    }

    public JTextField getI_cont() {
        return i_cont;
    }

   
    
}
