/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import model.Invoice_Tablemodel;
import model.Item_Tablemodel;
import model.Invoice_data;
import model.Items;
import view.create_invoice;
import view.create_item;
import view.invoice;

/**
 *
 * @author sarah
 */
 public class invoice_controller implements ActionListener, ListSelectionListener {
    private invoice frame;
    private int invoice_id;
    private  String  c_name;
    private create_invoice ci;
          private Date date1;
       private create_item ic;
              private DateFormat df=new SimpleDateFormat("dd-MM-yyyy");
              DateTimeFormatter format
            = DateTimeFormatter.ofPattern("dd-MM-yyyy");
     ArrayList < Invoice_data > invoicelist = new ArrayList < > ();
    public invoice_controller(invoice frame) {
        this.frame = frame;
    }
    @Override 
    
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "new invoice":
              
                newinv();
                break;
            case "delete invoice":
                deleteinv();
                break;

            case "new item":
              
                new_item();
                break;

            case "delete item":
             
                delete_item();

                break;
            case "load file":
                {
                    try {
                        load_file();
                    } catch (ParseException ex) {
                        Logger.getLogger(invoice_controller.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                break;


            case "save file":
                save_file();
                break;
                
                
             case  "InvoiceOK":
              create_invoice_ok();
                break;
                
             case "InvoiceCancel":
                        create_invoice_cancel();
                        break;
                        
                       case "Itemok":
                           create_Item_ok();
                           break;
           
                
             case "Itemcancel":
                        create_Item_cancel();
                        break;
                         
                
        }
        //  throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void newinv(){
      //  throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
   /* new_inv frameText = new new_inv();
        frameText.setVisible(true);
        frameText.pack();
        frameText.setLocationRelativeTo(null);
        frameText.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); */
     ci = new create_invoice(frame);
        ci.setVisible(true);
    }

    private void deleteinv() {
      int rowsel= frame.getinvoice_Table().getSelectedRow();
       if (rowsel != -1) {
            frame.getInvoicelist().remove(rowsel);
            frame.getinvoiceTablemodel().fireTableDataChanged();
              frame.getitem_Table().setModel(new Item_Tablemodel(null));
                          frame.setInvoiceilist(null);

            frame.getCst().setText("");
            frame.getDate().setText("");
            frame.getNum().setText("");
            frame.getTotal().setText("");
         
       } }

    private void new_item() {
        ic= new create_item(frame);
        ic.setVisible(true);// throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void delete_item() {
       int lineselec = frame.getitem_Table().getSelectedRow();
        int invoiceselect = frame.getinvoice_Table().getSelectedRow();
       double totalt=0;
            frame.getInvoiceilist().remove(lineselec);
            Item_Tablemodel ite = (Item_Tablemodel) frame.getitem_Table().getModel();
            ite.fireTableDataChanged();
            totalt=frame.getInvoicelist().get(invoiceselect).total();
           frame.getTotal().setText("" + totalt);
            frame.getinvoiceTablemodel().fireTableDataChanged();
       
        }//   throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    

    private void load_file() throws ParseException {
        // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        String path;
       
        JFileChooser fc = new JFileChooser();
        int result = fc.showSaveDialog(frame);
        if (result == fc.APPROVE_OPTION) {
            path = fc.getSelectedFile().getPath();

            path = fc.getSelectedFile().getAbsolutePath();
            //JOptionPane.showMessageDialog(null,null,path,1);
            Path invoicepath = Paths.get(path);
            try {
                List < String > invoiceLines = Files.lines(invoicepath).collect(Collectors.toList());
                 invoicelist = new ArrayList < > ();
Date date=new Date();
                for (String invoiceline: invoiceLines) {
                    String[] line = invoiceline.split(",");
                    //  System.out.println("lll"+line.length);
                    int invoice_id = Integer.parseInt(line[0].trim());
                    c_name= line[1];
                     System.out.println("daaaaaaa"+line[2].trim());
                    

LocalDate date1= LocalDate.parse(line[2].trim(), format);
                     
             // date1=StringToDate(line[2]);
                    System.out.println("da"+date1);
                   
                    Invoice_data invdata = new Invoice_data(invoice_id, line[1],date1);
                    invoicelist.add(invdata);
                }
            } catch (IOException ex) {
                Logger.getLogger(invoice_controller.class.getName()).log(Level.SEVERE, null, ex);
            }

            int result1 = fc.showSaveDialog(frame);
            if (result1 == fc.APPROVE_OPTION) {

                String ite_path = fc.getSelectedFile().getPath();

                ite_path = fc.getSelectedFile().getAbsolutePath();
                //JOptionPane.showMessageDialog(null,null,path,1);
                Path itempath = Paths.get(ite_path);
                try {
                    List < String > itLines = Files.lines(itempath).collect(Collectors.toList());
                   
                    for (String ls: itLines) {
                        String[] line = ls.split(",");
                        int invoice_id = Integer.parseInt(line[0]);
                        double price = Double.parseDouble(line[2]);
                        int i_cont = Integer.parseInt(line[3]);
                        // System.out.println(invoice_id);
                        Invoice_data invoice_h = getinvoicebyid(invoicelist, invoice_id);
                        if (invoice_h != null) {
                            Items iline = new Items(invoice_h, line[1], price, i_cont);
                            invoice_h.getitl().add(iline);
                        }
                    }
                    frame.setInvoicelist(invoicelist);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }


        }
    }

    private Invoice_data getinvoicebyid(ArrayList < Invoice_data > inv, int id) {
        for (Invoice_data inh: inv) {
            if (inh.getNum() == id) {
                return inh;
            }
        }
        return null;
    }

  

    private void save_file() {
      //  System.out.println("klkllklklklll");
       ArrayList<Invoice_data> invoices = frame.getInvoicelist();
        String path;
        try{
        JFileChooser fc = new JFileChooser();
        int result = fc.showSaveDialog(frame);
       
             
        if (result == fc.APPROVE_OPTION) {
       
          File invoicefile=fc.getSelectedFile();
         
            FileWriter invoicefilewriter=new FileWriter(invoicefile);
             
             String in_data="";
             String it_data="";
          
            
            for(Invoice_data invoices_data: invoices)
            {
                    in_data+=invoices_data.toString();
           in_data+="\n";
           
            for(Items invl:invoices_data.getitl())
            {it_data+=invl.toString();
            it_data+="\n";
      ///      // System.out.print("inn"+line_data);
            } }
          in_data=  in_data.substring(0, in_data.length()-1);
           it_data= it_data.substring(0, it_data.length()-1);
            result=fc.showSaveDialog(frame);
         File detailFile = fc.getSelectedFile();
                FileWriter detailfilewriter = new FileWriter(detailFile);
          invoicefilewriter.write(in_data);
          detailfilewriter.write(it_data);
            invoicefilewriter.close();
            detailfilewriter.close(); 
        }
        }
        catch(IOException e)
        {e.printStackTrace();}
// throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        
           int selected_row=frame.getinvoice_Table().getSelectedRow();
         if (selected_row != -1) {
     
       ArrayList<Items>  ite_line=frame.getInvoicelist().get(selected_row).getitl();
       frame.getitem_Table().setModel(new Item_Tablemodel(ite_line));
        frame.setInvoiceilist(ite_line);
     String cn=  frame.getInvoicelist().get(selected_row).getCustomer();
    int no=  frame.getInvoicelist().get(selected_row).getNum();
  LocalDate da=  frame.getInvoicelist().get(selected_row).getDat();
  // String formattedDate = String.format("%1$tb %1$te, %1$tY %1$tI:%1$tM %1$Tp", da);
Double t=frame.getInvoicelist().get(selected_row).total();
      //  System.out.println(cn);//  throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
      frame.getCst().setText(cn);
      frame.getNum().setText(String.valueOf(no));
      frame.getDate().setText(""+da.format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
      frame.getTotal().setText(String.valueOf(t));
         }
    }

  /*  public static Date StringToDate(String d) throws ParseException {
      //Instantiating the SimpleDateFormat class
      SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
      //Parsing the given String to Date object
      Date date = formatter.parse(d);
   String date=formatter.format(d);
     return date;}*/
   
    private void create_invoice_ok() {
      //  throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
      System.out.println("inside iiiii create_invoice_ok()");
   ci.setVisible(false);
      
        String C_name = ci.getCustomer().getText();
    
        String invoice_date = ci.getInvoiceDate().getText();
          System.out.println("print"+C_name+invoice_date);
  LocalDate date1= LocalDate.parse(invoice_date, format);

        int invoice_n = 0;
       /* try {
        date=df.parse(invoice_date);}
        catch (ParseException ex) {
            JOptionPane.showMessageDialog(frame, "", "Invalid date format", JOptionPane.ERROR_MESSAGE);
        }*/
        for (Invoice_data invoice : frame.getInvoicelist()) {
            if (invoice.getNum() > invoice_n) {
                invoice_n = invoice.getNum();
            }
           
        }
        invoice_n++;
           System.out.println("innnnv1:::"+invoice_n);
        Invoice_data new_record = new Invoice_data(invoice_n, C_name, date1);
         System.out.println("innnnv2::"+invoice_n);
        frame.getInvoicelist().add(new_record);
       frame.getinvoiceTablemodel().fireTableDataChanged();
        ci.dispose();
        ci = null;}
    
    private void create_invoice_cancel() {
        ci.setVisible(false);
        ci = null;
    }

    private void create_Item_ok() {
   //     throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
      ic.setVisible(false);
  int itemcount = 0;
        double itemprice = 0;
        String item_name = ic.getItem().getText();
        String item_price = ic.getPrice().getText();
        String item_cont= ic.getI_cont().getText();
      
        try {
            itemcount = Integer.parseInt(item_cont.trim());
             itemprice = Double.parseDouble(item_price.trim());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(frame, "", "Invalid numbert", JOptionPane.ERROR_MESSAGE);
        }    
        int invoicerow = frame.getinvoice_Table().getSelectedRow();
     if (invoicerow != -1) {
            Invoice_data invoice = frame.getInvoicelist().get(invoicerow);
            Items new_line = new Items(invoice,item_name, itemprice, itemcount);
            System.err.println("kkk"+itemcount+"--"+itemprice);
            frame.getInvoiceilist().add(new_line);
       
          Item_Tablemodel  dtm= (Item_Tablemodel) frame.getitem_Table().getModel();
          
            
            dtm.fireTableDataChanged();
            frame.getinvoiceTablemodel().fireTableDataChanged();
 
    }
 frame.getinvoice_Table().setRowSelectionInterval(invoicerow, invoicerow);
      
     ic= null;
    }
    private void create_Item_cancel() {
         ic.setVisible(false);
       ic = null;
      //  throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    

}