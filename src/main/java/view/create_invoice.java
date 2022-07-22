/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;
import java.awt.GridLayout;
import java.text.SimpleDateFormat;
import java.util.Date;
import  javax.swing.*;
import javax.swing.JDialog;

/**
 *
 * @author sarah
 */
public class create_invoice extends JDialog{
    
 
    private JTextField customer;
    private JTextField invoiceDate;
    private JLabel customerlabel;
    private JLabel invoiceDatelabel;
    private JButton ok;
    private JButton cancel;

    public create_invoice(invoice frame) {
        customerlabel = new JLabel("Customer Name:");
        customer = new JTextField(30);
        invoiceDatelabel = new JLabel("Invoice Date:");
        invoiceDate = new JTextField(20);
        ok = new JButton("OK");
        cancel = new JButton("Cancel");
        
        ok.setActionCommand("InvoiceOK");
        cancel.setActionCommand("InvoiceCancel");
        
        ok.addActionListener(frame.getHandler());
        cancel.addActionListener(frame.getHandler());
        setLayout(new GridLayout(3, 4));
        
        add(customerlabel);
        add(customer);
        add(invoiceDatelabel);
        add(invoiceDate);
       /* SimpleDateFormat formatter= new SimpleDateFormat("dd-mm-yyyy");
        String date = formatter.format(System.currentTimeMillis());
        invoiceDate.setText(date);*/
        add(ok);
        add(cancel);
        
        pack();
        
    }

    public JTextField getCustomer() {
        return customer;
    }

    public JTextField getInvoiceDate() {
        return invoiceDate;
    }


    
}

