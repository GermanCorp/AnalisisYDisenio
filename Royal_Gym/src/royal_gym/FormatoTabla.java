/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package royal_gym;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import presentacion.PanelRegistroClientes;
import presentacion.PanelRegistroPagos;

//  if(String.valueOf(table.getValueAt(row,5)).equals("ACTIVO"))  setForeground(Color.blue);
public class FormatoTabla extends DefaultTableCellRenderer {
  
    @Override
    public Component getTableCellRendererComponent(JTable jtable, Object o, boolean bln, boolean bln1, int i, int i1) {
       
        Calendar c1 = Calendar.getInstance();
        int mes = c1.get(Calendar.MONTH)+1;
        int anio = c1.get(Calendar.YEAR);
        String mess = Integer.toString(mes);
        String anioo = Integer.toString(anio);
       
        JPanel p = new JPanel();
        p.setLayout(new BorderLayout());
        p.add(new JLabel(o.toString()));
      
       if (i1 == 7)
       {
        String[] parts = o.toString().split("-");
             String a = parts[0];
             String m = parts[1];
             String d = parts[2];
             
        if(a == anioo && m == mess) {  
           p.setBackground(Color.red);
        
        }else{
             p.setBackground(Color.blue);
        }
     
     }
       return p;
      
   }
}


//     
//        Date fechaActual = Calendar.getInstance().getTime();
//        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
//        String fecha;
//        fecha = jtable.getValueAt(i, 7).toString();
//        Date fechafromtable = null;
//        try{
//            fechafromtable = formato.parse(fecha);
//        }catch(Exception ex){
//            
//            }
//        if(formato.format(fechaActual).equals(fecha))
//        {this.setBackground(Color.yellow);
//            
//    }else 
//        
//            
//    }
//        
       /* 
        JLabel celda = new JLabel() {
            @Override
            public void paint(Graphics g) {
                super.paint(g);
                if (bln) {
                    g.setColor(Color.blue);
                } else {
                    g.setColor(Color.red);
                }
                g.fillRect(0, 0, getWidth(), getHeight());

                g.setColor(bln ? Color.white : Color.black);

                g.setFont(getFont());
                g.drawString(getText(), 3, getHeight() - 3);

            }

        };
        
*/     


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


///////////////////////////////////////////////////////////////////////////////////////////////////////

  Calendar c1 = Calendar.getInstance();
        int mes = c1.get(Calendar.MONTH)+1;
        int anio = c1.get(Calendar.YEAR);
        String mess = Integer.toString(mes);
        String anioo = Integer.toString(anio);
       
      
       
       
        JPanel p = new JPanel();
        
        p.setLayout(new BorderLayout());
        //p.add(new JLabel(new javax.swing.ImageIcon(getClass().getResource("/iconos/Aceptar.png"))),BorderLayout.WEST);
        p.add(new JLabel());
        p.add(new JLabel(o.toString()));
       
       // celda.setText(o.toString());
       
       if(o instanceof String) {
        if (i1 == 7)
        { //cellEditorRedender
             String[] parts = o.toString().split("-");
             String a = parts[0];
             String m = parts[1];
             String d = parts[2];
            
         if(anioo==a && mess == m  ) {  
         p.setBackground(Color.red);
            return p;
            
            }else  
                    p.setBackground(Color.blue);
        }
    }
   
             return super.getTableCellRendererComponent(jtable, o, bln, bln1, i, i1); //To change body of generated methods, choose Tools | Templates  

    }
   
}       
*/
