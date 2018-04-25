/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package royal_gym;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.util.Calendar;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import presentacion.PanelRegistroClientes;
import presentacion.PanelRegistroPagos;
/**
 *
 * @author Jazmin Vargas
 */
public class FormatoTabla  extends DefaultTableCellRenderer{  
    PanelRegistroPagos rp = new PanelRegistroPagos();
      Calendar c1 = Calendar.getInstance();
       int mes = c1.get(Calendar.MONTH)+1;
       int anio = c1.get(Calendar.YEAR);
    @Override
    public Component getTableCellRendererComponent(JTable jtable, Object o, boolean bln, boolean bln1, int i, int i1) {
       
        
        
        
        return super.getTableCellRendererComponent(jtable, o, bln, bln1, i, i1); //To change body of generated methods, choose Tools | Templates.
    }
    
 }
    
   
/*

 //tablaPagos.setDefaultRenderer (Object.class, new FormatoTabla());
    @Override 
    public Component getTableCellRendererComponent ( JTable table, Object value, boolean selected, boolean focused, int row, int column ) 
    {
        Calendar c1 = Calendar.getInstance();
       int mes = c1.get(Calendar.MONTH)+1;
        
        
         JLabel label =(JLabel) super.getTableCellRendererComponent(table, value, selected, focused, row, column);         
        if(value instanceof Long) {
            //long valor = (long) value;
            if(column == 7){
              label.setBackground(Color.yellow);
             }
        }
       
              

     return label;
*/