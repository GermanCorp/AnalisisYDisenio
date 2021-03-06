/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion;

import com.toedter.calendar.JDateChooser;
import java.awt.event.ItemEvent;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import royal_gym.Utilidad;


/**
 *
 * @author alxcr
 */
public class PanelUtilidad extends javax.swing.JPanel {
    DecimalFormat df = new DecimalFormat("#,##0.00");
    
    
     private final String[] columnasUtilidad = {
        "No.",
        "Fecha ",
        "Nombre ",
        "Monto"
    };

    Utilidad utilidad = new Utilidad();
    public PanelUtilidad() {
     initComponents();
     setFechaActual();  
     getTotal();
     
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        Panelfecha = new javax.swing.JPanel();
        jdcfechaInicio = new com.toedter.calendar.JDateChooser();
        jdcfechaFinal = new com.toedter.calendar.JDateChooser();
        tbingresos = new javax.swing.JToggleButton();
        tbgastos = new javax.swing.JToggleButton();
        tbtodo = new javax.swing.JToggleButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        PaneltablaUtilidad = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tablautilidadingresos = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        Paneltotales = new javax.swing.JPanel();
        labeltotalingresos = new javax.swing.JLabel();
        labeltotalgastos = new javax.swing.JLabel();
        labelutilidad = new javax.swing.JLabel();
        jlTotalIngresos = new javax.swing.JLabel();
        jlTotalUtilidad = new javax.swing.JLabel();
        jlTotalGastos = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();

        setBackground(new java.awt.Color(85, 96, 128));

        Panelfecha.setBackground(new java.awt.Color(85, 96, 128));
        Panelfecha.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)), "Rangos De Fecha", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 18), new java.awt.Color(255, 255, 255))); // NOI18N
        Panelfecha.setMaximumSize(new java.awt.Dimension(483, 229));

        jdcfechaInicio.setDateFormatString("yyyy-MM-dd");

        jdcfechaFinal.setDateFormatString("yyyy-MM-dd");

        buttonGroup1.add(tbingresos);
        tbingresos.setText("Ingresos");
        tbingresos.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tbingresos.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                tbingresosItemStateChanged(evt);
            }
        });
        tbingresos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbingresosActionPerformed(evt);
            }
        });

        buttonGroup1.add(tbgastos);
        tbgastos.setText("Gastos");
        tbgastos.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                tbgastosItemStateChanged(evt);
            }
        });
        tbgastos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbgastosActionPerformed(evt);
            }
        });

        buttonGroup1.add(tbtodo);
        tbtodo.setText("Ingresos y Gastos");
        tbtodo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                tbtodoItemStateChanged(evt);
            }
        });
        tbtodo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbtodoActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Desde:");

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Hasta:");

        javax.swing.GroupLayout PanelfechaLayout = new javax.swing.GroupLayout(Panelfecha);
        Panelfecha.setLayout(PanelfechaLayout);
        PanelfechaLayout.setHorizontalGroup(
            PanelfechaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelfechaLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(PanelfechaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelfechaLayout.createSequentialGroup()
                        .addComponent(tbingresos, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(tbgastos, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(tbtodo))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelfechaLayout.createSequentialGroup()
                        .addGroup(PanelfechaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jdcfechaInicio, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                            .addComponent(jLabel8))
                        .addGap(33, 33, 33)
                        .addGroup(PanelfechaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13)
                            .addComponent(jdcfechaFinal, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE))))
                .addGap(20, 20, 20))
        );
        PanelfechaLayout.setVerticalGroup(
            PanelfechaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelfechaLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(PanelfechaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelfechaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jdcfechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jdcfechaFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(PanelfechaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tbgastos, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tbingresos, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tbtodo, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(40, Short.MAX_VALUE))
        );

        PaneltablaUtilidad.setBackground(new java.awt.Color(85, 96, 128));
        PaneltablaUtilidad.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)), "Ingresos y Gastos Registrados", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 18), new java.awt.Color(255, 255, 255))); // NOI18N

        tablautilidadingresos.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tablautilidadingresos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane5.setViewportView(tablautilidadingresos);

        javax.swing.GroupLayout PaneltablaUtilidadLayout = new javax.swing.GroupLayout(PaneltablaUtilidad);
        PaneltablaUtilidad.setLayout(PaneltablaUtilidadLayout);
        PaneltablaUtilidadLayout.setHorizontalGroup(
            PaneltablaUtilidadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PaneltablaUtilidadLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addGap(20, 20, 20))
        );
        PaneltablaUtilidadLayout.setVerticalGroup(
            PaneltablaUtilidadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PaneltablaUtilidadLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 324, Short.MAX_VALUE)
                .addGap(20, 20, 20))
        );

        Paneltotales.setBackground(new java.awt.Color(85, 96, 128));
        Paneltotales.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 18), new java.awt.Color(255, 255, 255))); // NOI18N

        labeltotalingresos.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        labeltotalingresos.setForeground(new java.awt.Color(255, 255, 255));
        labeltotalingresos.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labeltotalingresos.setText("Total Ingresos:");

        labeltotalgastos.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        labeltotalgastos.setForeground(new java.awt.Color(255, 255, 255));
        labeltotalgastos.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labeltotalgastos.setText("Total Gastos:");

        labelutilidad.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        labelutilidad.setForeground(new java.awt.Color(255, 255, 255));
        labelutilidad.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelutilidad.setText("Utilidad:");

        jlTotalIngresos.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jlTotalIngresos.setForeground(new java.awt.Color(255, 255, 255));
        jlTotalIngresos.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jlTotalIngresos.setText("L. 0.00");

        jlTotalUtilidad.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jlTotalUtilidad.setForeground(new java.awt.Color(255, 255, 255));
        jlTotalUtilidad.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jlTotalUtilidad.setText("L. 0.00");

        jlTotalGastos.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jlTotalGastos.setForeground(new java.awt.Color(255, 255, 255));
        jlTotalGastos.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jlTotalGastos.setText("L. 0.00");

        javax.swing.GroupLayout PaneltotalesLayout = new javax.swing.GroupLayout(Paneltotales);
        Paneltotales.setLayout(PaneltotalesLayout);
        PaneltotalesLayout.setHorizontalGroup(
            PaneltotalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PaneltotalesLayout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addGroup(PaneltotalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labeltotalgastos, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(labeltotalingresos, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(labelutilidad, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 167, Short.MAX_VALUE)
                .addGroup(PaneltotalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlTotalUtilidad, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jlTotalGastos, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jlTotalIngresos, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18))
        );
        PaneltotalesLayout.setVerticalGroup(
            PaneltotalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PaneltotalesLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(PaneltotalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labeltotalingresos, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jlTotalIngresos, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(15, 15, 15)
                .addGroup(PaneltotalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labeltotalgastos, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jlTotalGastos, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(5, 5, 5)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(PaneltotalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelutilidad, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jlTotalUtilidad, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(10, 10, 10))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Panelfecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(Paneltotales, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addComponent(PaneltablaUtilidad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Panelfecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                        .addComponent(Paneltotales, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(PaneltablaUtilidad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(20, 20, 20))
        );
    }// </editor-fold>//GEN-END:initComponents

    
    public void setFechaActual(){
        java.util.Date date = new Date();
        java.sql.Date fechaActual = new java.sql.Date(date.getTime());
        
        jdcfechaInicio.setDate(fechaActual);
        jdcfechaFinal.setDate(fechaActual);
        
    }
    
    public void getTotal(){
           
            TitledBorder t = (TitledBorder )PaneltablaUtilidad.getBorder();
            t.setTitle("Ingresos y Gastos");

            DefaultTableModel modeloTablaUtilidadIngresos = new DefaultTableModel(utilidad.getUtilidad(fechaJCalendar(jdcfechaInicio).toString(), fechaJCalendar(jdcfechaFinal).toString()), columnasUtilidad);
            tablautilidadingresos.setModel(modeloTablaUtilidadIngresos);
            
            utilidad.getIngresosSeleccinados(fechaJCalendar(jdcfechaInicio).toString(), fechaJCalendar(jdcfechaFinal).toString());
            
            utilidad.getGastosSeleccionados(fechaJCalendar(jdcfechaInicio).toString(), fechaJCalendar(jdcfechaFinal).toString());
            
            double totalGasto = utilidad.totalGastos;
            jlTotalGastos.setText("L. "+df.format(totalGasto ));

            double totalIngreso = utilidad.totalIngresos;
            jlTotalIngresos.setText("L. "+df.format(totalIngreso));

            double totalUtili = utilidad.totalIngresos - utilidad.totalGastos;
            jlTotalUtilidad.setText("L. "+df.format(totalUtili));
        
    }
    
    
    
    
    private void tbingresosItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_tbingresosItemStateChanged
        // TODO add your handling code here:
        
          if (evt.getStateChange() == ItemEvent.SELECTED) {
              double totali = 0;
            PaneltablaUtilidad.setVisible(true);
            jScrollPane5.setVisible(true);
            Paneltotales.setVisible(true);
            TitledBorder t = (TitledBorder )PaneltablaUtilidad.getBorder();
            t.setTitle("Ingresos");

            DefaultTableModel modeloTablaUtilidadIngresos = new DefaultTableModel(utilidad.getIngresosSeleccinados(fechaJCalendar(jdcfechaInicio).toString(), fechaJCalendar(jdcfechaFinal).toString()), columnasUtilidad);
            tablautilidadingresos.setModel(modeloTablaUtilidadIngresos);

            totali = utilidad.totalIngresos;
            jlTotalIngresos.setText("L. " + df.format(utilidad.totalIngresos));
            jlTotalGastos.setText("L. 0.00");
            jlTotalUtilidad.setText("L. 0.00");

        } else {
            PaneltablaUtilidad.setVisible(false);
            jScrollPane5.setVisible(false);
            Paneltotales.setVisible(false);
        }
    }//GEN-LAST:event_tbingresosItemStateChanged

    private void tbingresosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbingresosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tbingresosActionPerformed

    private void tbgastosItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_tbgastosItemStateChanged
        // TODO add your handling code here:
        double totalg =0;
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            
            
            PaneltablaUtilidad.setVisible(true);
            jScrollPane5.setVisible(true);
            Paneltotales.setVisible(true);
            TitledBorder t = (TitledBorder )PaneltablaUtilidad.getBorder();
            t.setTitle("Gastos");

            DefaultTableModel modeloTablaUtilidadGastos = new DefaultTableModel(utilidad.getGastosSeleccionados(fechaJCalendar(jdcfechaInicio).toString(), fechaJCalendar(jdcfechaFinal).toString()), columnasUtilidad);
            tablautilidadingresos.setModel(modeloTablaUtilidadGastos);

             totalg = utilidad.totalGastos;
            jlTotalGastos.setText("L. "+ df.format(totalg));
            jlTotalIngresos.setText("L. 0.00");
            jlTotalUtilidad.setText("L. 0.00");
            
            

        } else {
            PaneltablaUtilidad.setVisible(false);
            jScrollPane5.setVisible(false);
            Paneltotales.setVisible(false);
        }
        
        
    }//GEN-LAST:event_tbgastosItemStateChanged

    private void tbgastosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbgastosActionPerformed
        // TODO add your handling code here
    }//GEN-LAST:event_tbgastosActionPerformed

    private void tbtodoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_tbtodoItemStateChanged
        // TODO add your handling code here:
        if (evt.getStateChange() == ItemEvent.SELECTED) {

            PaneltablaUtilidad.setVisible(true);
            jScrollPane5.setVisible(true);
            Paneltotales.setVisible(true);
            TitledBorder t = (TitledBorder )PaneltablaUtilidad.getBorder();
            t.setTitle("Ingresos y Gastos");

            DefaultTableModel modeloTablaUtilidadIngresos = new DefaultTableModel(utilidad.getUtilidad(fechaJCalendar(jdcfechaInicio).toString(), fechaJCalendar(jdcfechaFinal).toString()), columnasUtilidad);
            tablautilidadingresos.setModel(modeloTablaUtilidadIngresos);
            
            double totalg = utilidad.totalGastos;
            jlTotalGastos.setText("L. "+df.format(totalg));

            double totali = utilidad.totalIngresos;
            jlTotalIngresos.setText("L. "+df.format(totali));

            double totalu = utilidad.totalIngresos - utilidad.totalGastos;
            jlTotalUtilidad.setText("L. "+df.format(totalu));

        } else {
            PaneltablaUtilidad.setVisible(false);
            jScrollPane5.setVisible(false);
            Paneltotales.setVisible(false);
            
            jlTotalGastos.setText("L. 0.00");
             jlTotalIngresos.setText("L. 0.00");
             jlTotalUtilidad.setText("L. 0.00");

        }
        
       
    }//GEN-LAST:event_tbtodoItemStateChanged

    private Date fechaJCalendar(JDateChooser calendario) {
        Date date = calendario.getDate();
        long d = date.getTime();
        java.sql.Date fecha = new java.sql.Date(d);
        return fecha;
    }
    
    private void tbtodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbtodoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tbtodoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Panelfecha;
    private javax.swing.JPanel PaneltablaUtilidad;
    private javax.swing.JPanel Paneltotales;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JSeparator jSeparator1;
    private com.toedter.calendar.JDateChooser jdcfechaFinal;
    private com.toedter.calendar.JDateChooser jdcfechaInicio;
    private javax.swing.JLabel jlTotalGastos;
    private javax.swing.JLabel jlTotalIngresos;
    private javax.swing.JLabel jlTotalUtilidad;
    private javax.swing.JLabel labeltotalgastos;
    private javax.swing.JLabel labeltotalingresos;
    private javax.swing.JLabel labelutilidad;
    private javax.swing.JTable tablautilidadingresos;
    private javax.swing.JToggleButton tbgastos;
    private javax.swing.JToggleButton tbingresos;
    private javax.swing.JToggleButton tbtodo;
    // End of variables declaration//GEN-END:variables
}