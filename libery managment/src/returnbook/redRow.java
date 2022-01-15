/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package returnbook;

import java.awt.Color;
import java.awt.Component;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author PC
 */
public class redRow {
    
    JTable table;
//Creating constructor
    public redRow () {
    //let me add header and data for table
    //i am using date format as dd-MM-yyyy, the format use
    String [] header = {"Joining Date","Expired Date"};
    String [] [] data = {
        {"20-05-2000","31-05-2036"},
        {"20-05-2000","31-05-2016"},
        {"20-05-2000","31-05-2036"},
        {"20-05-2000","31-05-2020"}
        };
        table = new JTable (data,header){
            
            @Override
            public Component prepareRenderer(TableCellRenderer renderer, int row , int column){
            Component comp= super.prepareRenderer (renderer, row, column);
           SimpleDateFormat sdf = new SimpleDateFormat ("dd-MM-YYYY");
            //creating String object for current date
            String d = sdf.format (new java.util.Date ());
            try{
                       Date dl = new SimpleDateFormat("dd-MM-yyyy").parse(d) ;
                       //here di is current date
                        Date d2 = sdf.parse (getValueAt(row, 1).toString());
                        if (dl.compareTo(d2)==1) {
                                comp.setBackground (Color.red);
                        }else {
                            comp.setBackground (Color.white);
                       }
                }catch (ParseException e) {System.out.println("error"); }
            
            return comp;
            };
            
        };
JFrame frame = new JFrame ();
frame.add (new JScrollPane (table));
frame.setSize(300, 400);

frame.setVisible(true);
frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
}
    
    
    
    
    
    public static void main(String... args) {
        redRow redRow = new redRow ();

    }
}

