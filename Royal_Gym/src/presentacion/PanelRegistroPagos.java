/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion;

import com.mxrck.autocompleter.TextAutoCompleter;
import java.awt.Color;
import java.awt.event.ItemEvent;
import java.awt.event.KeyEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import royal_gym.Conexion;
import royal_gym.FormatoTabla;
import royal_gym.Pagos;

/**
 *
 * @author alxcr
 */
public class PanelRegistroPagos extends javax.swing.JPanel {
    int filaseleccionadatablapagos;   
    final Conexion con = new Conexion();
    Pagos pagos = new Pagos();
    private String cliente;
    
    
     int d,m,a;
     int df,mf,af;
     int totalanio;
     int totalmes;
     String dia ;
     String mes ;
     String anio ;
     String fecha ;
     int tm = 0;
     int an = 0;
     int me = 0;
     int td = 0;
     String tiempo;
     int mess ;
     int diaa ;
     int annio;
     
     String totalme ;
     String anioo;
     String totalm ;
     String totalan ;
     
     
     String totald ;
     String mees;
     String totaldi;
     
     String fechaFinal = "";
            

    private static Statement statement;
    static ResultSet resultado;
   
    // columnas de la tabla pagos
    private final String[] columnasPagos = {
        "No.",
        "Cliente",
        "Monto",
        "Tiempo",
        "Tipo de Pago",
        "Tipo de Plan",
        "Fecha de Pago",
        "Fecha de Vencimiento",
       
    };
    
    public PanelRegistroPagos() {
        initComponents();
        
        con.conectar();
        jcbPagoPlan.setEnabled(false);
        
        DefaultTableModel modeloTablaPagos = new DefaultTableModel(pagos.getPago(), columnasPagos);
        tablaPagos.setModel(modeloTablaPagos);
       
        
        tablaPagos.setDefaultRenderer (Object.class, new FormatoTabla());
        
    }

    public PanelRegistroPagos( String cliente) {
        
        this.cliente = cliente;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }
    
    public void setNombreCliente(){
        jtfBuscarCliente.setText(getCliente());
    }
    
    
    /*
     public void items(){
       //String nombre = jtfBuscarCliente.getText();
       TextAutoCompleter  textAutoCompleter = new  TextAutoCompleter(jtfBuscarCliente);
          
        try {
            String consulta = "Select nombres ||' '|| apellidos as nombreCompleto from cliente ORDER BY nombres ||' '|| apellidos ASC";
            statement = Conexion.getConexion().createStatement();
            resultado = statement.executeQuery(consulta);
           

        while (resultado.next()) {
                 textAutoCompleter.addItem(resultado.getString("nombreCompleto"));
                
            }
            
        } catch (Exception e) {
            System.out.println("buscar:" + e.getMessage());
        }
     }*/
     
   
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelDatosPago = new javax.swing.JPanel();
        jtfClienteAPagar = new javax.swing.JLabel();
        jlMontoPagar = new javax.swing.JLabel();
        jtfMontoAPagar = new javax.swing.JTextField();
        jlTiempoPago = new javax.swing.JLabel();
        jtfTiempoAPagar = new javax.swing.JTextField();
        jcbPagoPlan = new javax.swing.JComboBox<>();
        jtfPagoTipodePlan = new javax.swing.JLabel();
        jbPagoAceptar = new javax.swing.JButton();
        jbPagoCancelar = new javax.swing.JButton();
        jcbTiempoPago = new javax.swing.JComboBox<>();
        jlRegistroClientes1 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jtfBuscarCliente = new javax.swing.JTextField();
        botonAgregarCliente = new javax.swing.JButton();
        PanelTablaPagos = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaPagos = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        combobuscarportipoplan = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jtfbuscarpago = new javax.swing.JTextField();

        setBackground(new java.awt.Color(85, 96, 128));
        setPreferredSize(new java.awt.Dimension(919, 580));

        panelDatosPago.setBackground(new java.awt.Color(85, 96, 128));
        panelDatosPago.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Registrar Pago", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 18), new java.awt.Color(255, 255, 255))); // NOI18N
        panelDatosPago.setPreferredSize(new java.awt.Dimension(350, 487));

        jtfClienteAPagar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jtfClienteAPagar.setForeground(new java.awt.Color(255, 255, 255));
        jtfClienteAPagar.setText("Cliente:");

        jlMontoPagar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jlMontoPagar.setForeground(new java.awt.Color(255, 255, 255));
        jlMontoPagar.setText("Monto:");

        jtfMontoAPagar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jtfMontoAPagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfMontoAPagarActionPerformed(evt);
            }
        });
        jtfMontoAPagar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtfMontoAPagarKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfMontoAPagarKeyTyped(evt);
            }
        });

        jlTiempoPago.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jlTiempoPago.setForeground(new java.awt.Color(255, 255, 255));
        jlTiempoPago.setText("Tiempo:");

        jtfTiempoAPagar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jtfTiempoAPagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfTiempoAPagarActionPerformed(evt);
            }
        });
        jtfTiempoAPagar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtfTiempoAPagarKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfTiempoAPagarKeyTyped(evt);
            }
        });

        jcbPagoPlan.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jcbPagoPlan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione", "Individual", "Pareja", "Grupo", "Estudiante" }));
        jcbPagoPlan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbPagoPlanActionPerformed(evt);
            }
        });

        jtfPagoTipodePlan.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jtfPagoTipodePlan.setForeground(new java.awt.Color(255, 255, 255));
        jtfPagoTipodePlan.setText("Tipo de Plan:");

        jbPagoAceptar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/src/iconos/btn_guardar.png"))); // NOI18N
        jbPagoAceptar.setText("Guardar");
        jbPagoAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbPagoAceptarActionPerformed(evt);
            }
        });

        jbPagoCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/src/iconos/btn_limpiar.png"))); // NOI18N
        jbPagoCancelar.setText("Limpiar");
        jbPagoCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbPagoCancelarActionPerformed(evt);
            }
        });

        jcbTiempoPago.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jcbTiempoPago.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione el tiempo a pagar", "Dia", "Mes", "Año" }));
        jcbTiempoPago.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcbTiempoPagoItemStateChanged(evt);
            }
        });
        jcbTiempoPago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbTiempoPagoActionPerformed(evt);
            }
        });

        jlRegistroClientes1.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        jlRegistroClientes1.setForeground(new java.awt.Color(255, 255, 255));
        jlRegistroClientes1.setText("<html> <center>Registro de<center> <center> Pagos<center>");

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/RegistroNuevoPagos.png"))); // NOI18N

        jtfBuscarCliente.setMinimumSize(new java.awt.Dimension(6, 30));
        jtfBuscarCliente.setPreferredSize(new java.awt.Dimension(6, 23));
        jtfBuscarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfBuscarClienteActionPerformed(evt);
            }
        });

        botonAgregarCliente.setText("+");
        botonAgregarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAgregarClienteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelDatosPagoLayout = new javax.swing.GroupLayout(panelDatosPago);
        panelDatosPago.setLayout(panelDatosPagoLayout);
        panelDatosPagoLayout.setHorizontalGroup(
            panelDatosPagoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDatosPagoLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(panelDatosPagoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelDatosPagoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelDatosPagoLayout.createSequentialGroup()
                            .addComponent(jLabel11)
                            .addGap(20, 20, 20)
                            .addComponent(jlRegistroClientes1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jtfPagoTipodePlan, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelDatosPagoLayout.createSequentialGroup()
                            .addComponent(jbPagoAceptar)
                            .addGap(65, 65, 65)
                            .addComponent(jbPagoCancelar)))
                    .addGroup(panelDatosPagoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jtfTiempoAPagar, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jlMontoPagar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jtfClienteAPagar)
                        .addComponent(jtfMontoAPagar)
                        .addComponent(jcbTiempoPago, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jcbPagoPlan, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jlTiempoPago, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(panelDatosPagoLayout.createSequentialGroup()
                            .addComponent(jtfBuscarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(botonAgregarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        panelDatosPagoLayout.setVerticalGroup(
            panelDatosPagoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDatosPagoLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(panelDatosPagoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlRegistroClientes1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addComponent(jtfClienteAPagar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelDatosPagoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfBuscarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonAgregarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addComponent(jlMontoPagar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtfMontoAPagar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jlTiempoPago)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelDatosPagoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcbTiempoPago, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfTiempoAPagar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addComponent(jtfPagoTipodePlan)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jcbPagoPlan, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelDatosPagoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbPagoAceptar)
                    .addComponent(jbPagoCancelar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        PanelTablaPagos.setBackground(new java.awt.Color(85, 96, 128));
        PanelTablaPagos.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Pagos Registrados", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 18), new java.awt.Color(255, 255, 255))); // NOI18N
        PanelTablaPagos.setPreferredSize(new java.awt.Dimension(1213, 830));

        tablaPagos.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tablaPagos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tablaPagos.setPreferredSize(new java.awt.Dimension(300, 64));
        tablaPagos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaPagosMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tablaPagos);

        combobuscarportipoplan.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        combobuscarportipoplan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Individual", "Pareja", "Grupo", "Estudiante", "No aplica", "Todo" }));
        combobuscarportipoplan.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                combobuscarportipoplanItemStateChanged(evt);
            }
        });
        combobuscarportipoplan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combobuscarportipoplanActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Tipo de Plan:");

        jPanel1.setBackground(new java.awt.Color(85, 96, 128));

        jtfbuscarpago.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                jtfbuscarpagoCaretUpdate(evt);
            }
        });
        jtfbuscarpago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfbuscarpagoActionPerformed(evt);
            }
        });
        jtfbuscarpago.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtfbuscarpagoKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfbuscarpagoKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jtfbuscarpago, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jtfbuscarpago, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout PanelTablaPagosLayout = new javax.swing.GroupLayout(PanelTablaPagos);
        PanelTablaPagos.setLayout(PanelTablaPagosLayout);
        PanelTablaPagosLayout.setHorizontalGroup(
            PanelTablaPagosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelTablaPagosLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(PanelTablaPagosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelTablaPagosLayout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(combobuscarportipoplan, 0, 46, Short.MAX_VALUE))
                    .addComponent(jScrollPane2))
                .addGap(20, 20, 20))
        );
        PanelTablaPagosLayout.setVerticalGroup(
            PanelTablaPagosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelTablaPagosLayout.createSequentialGroup()
                .addGroup(PanelTablaPagosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelTablaPagosLayout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addGroup(PanelTablaPagosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(combobuscarportipoplan, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)))
                    .addGroup(PanelTablaPagosLayout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 393, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(panelDatosPago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(PanelTablaPagos, javax.swing.GroupLayout.DEFAULT_SIZE, 509, Short.MAX_VALUE)
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelDatosPago, javax.swing.GroupLayout.DEFAULT_SIZE, 557, Short.MAX_VALUE)
                    .addComponent(PanelTablaPagos, javax.swing.GroupLayout.DEFAULT_SIZE, 557, Short.MAX_VALUE))
                .addGap(20, 20, 20))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jtfMontoAPagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfMontoAPagarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfMontoAPagarActionPerformed

    private void jtfMontoAPagarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfMontoAPagarKeyPressed
        // TODO add your handling code here:
        if(evt.isControlDown() || evt.isAltDown() || evt.isShiftDown()){
            evt.consume();
        }
    }//GEN-LAST:event_jtfMontoAPagarKeyPressed

    private void jtfMontoAPagarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfMontoAPagarKeyTyped
        Number n = evt.getKeyCode();
        if(!Character.isDigit(evt.getKeyChar())){
            evt.consume();

        }

        int limit = 4;
        if (jtfMontoAPagar.getText().length() == limit) {
            evt.consume();

        }
    }//GEN-LAST:event_jtfMontoAPagarKeyTyped

    private void jtfTiempoAPagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfTiempoAPagarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfTiempoAPagarActionPerformed

    private void jtfTiempoAPagarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfTiempoAPagarKeyPressed
        // TODO add your handling code here:
        if(evt.isControlDown() || evt.isAltDown() || evt.isShiftDown()){
            evt.consume();
        }
    }//GEN-LAST:event_jtfTiempoAPagarKeyPressed

    private void jtfTiempoAPagarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfTiempoAPagarKeyTyped
        Number n = evt.getKeyCode();
        if(!Character.isDigit(evt.getKeyChar())){
            evt.consume();
        }

        int limit = 2;
        if (jtfTiempoAPagar.getText().length() == limit) {
            evt.consume();

        }
    }//GEN-LAST:event_jtfTiempoAPagarKeyTyped

    private void jcbPagoPlanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbPagoPlanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcbPagoPlanActionPerformed

    private void jbPagoAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbPagoAceptarActionPerformed
        
        
         Calendar c = Calendar.getInstance();
         d = c.get(Calendar.DATE);
         m = 1 + (c.get(Calendar.MONTH));
         a = c.get(Calendar.YEAR);

         dia = Integer.toString(d);
         mes = Integer.toString(m);
         anio = Integer.toString(a);
         fecha = (anio + "-" + mes + "-" + dia);
        
         int comboBoxTiempoPago = jcbTiempoPago.getSelectedIndex(); 
         int comboBoxPagoPlan = jcbPagoPlan.getSelectedIndex();
         
         //validaciones para campos vacios
        if (jtfBuscarCliente.getText().isEmpty()
                && jtfMontoAPagar.getText().isEmpty()
                && jtfTiempoAPagar.getText().isEmpty()
                && comboBoxTiempoPago == 0
                && comboBoxPagoPlan == 0) 
        {
            JOptionPane.showMessageDialog(this, "ingrese Toda la Información", "Error!", JOptionPane.ERROR_MESSAGE);
        } else if (jtfBuscarCliente.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Debe Ingresar el NOMBRE del Cliente", "Error!", JOptionPane.ERROR_MESSAGE);
        } else if (jtfMontoAPagar.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Debe Ingresar el MONTO a a pagar", "Error!", JOptionPane.ERROR_MESSAGE);
        } else if (jtfTiempoAPagar. getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Debe Ingresar el TIEMPO a pagar", "Error!", JOptionPane.ERROR_MESSAGE);
        } else if (jcbTiempoPago.getSelectedIndex()== 0) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar el TIEMPO a pagar" , "Error!", JOptionPane.ERROR_MESSAGE);
        } else if (jcbPagoPlan.getSelectedIndex()== 0) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar el TIPO DE PLAN a pagar", "Error!", JOptionPane.ERROR_MESSAGE);
       
        } else {
            
          
       
         tiempo = jtfTiempoAPagar.getText();
         mess = Integer.parseInt(tiempo);
         diaa = Integer.parseInt(tiempo);
         annio = Integer.parseInt(tiempo);
        
         //sumar dias a la fecha
          if(jcbTiempoPago.getSelectedIndex() == 1)
          {
           int totaldia = d + diaa;
            
             if(totaldia >30){
             td = totaldia - 30;
             me = m + 1;
             
             String totald = Integer.toString(td);
             String mees = Integer.toString(me);
             fechaFinal = (anio+ "-" + mees + "-" + totald);
            }else{
            String totaldi = Integer.toString(totaldia);
            fechaFinal = (anio + "-" + mes + "-" +  totaldi);
             }   
          } 
         
         
         //Sumar meses a la fecha actual
         if(jcbTiempoPago.getSelectedIndex() == 2)
         {
            totalmes = m + mess;
            
             if(totalmes >12){
             tm = totalmes - 12;
             an = a + 1;
             
             totalme = Integer.toString(tm);
             anioo = Integer.toString(an);
             fechaFinal = (anioo+ "-" + totalme + "-" + dia);
            }else{
            totalm = Integer.toString(totalmes);
            fechaFinal = (anio + "-" + totalm + "-" + dia);
            
            }   
        }    
         
         //sumar anio  a la fecha actual
          if(jcbTiempoPago.getSelectedIndex() == 3)
           {
            totalanio = a + annio;
            
            totalan = Integer.toString( totalanio);
            fechaFinal = (totalan + "-" + mes + "-" + dia);
            }
            
            
      
            if (jcbPagoPlan.getSelectedItem() != null) {
                pagos.insertarPagos(jtfBuscarCliente.getText(), jtfMontoAPagar.getText(), jtfTiempoAPagar.getText(),
                    jcbTiempoPago.getSelectedItem().toString(), jcbPagoPlan.getSelectedItem().toString(), fecha,fechaFinal);
            } else {
                pagos.insertarPagos(jtfBuscarCliente.getText(), jtfMontoAPagar.getText(), jtfTiempoAPagar.getText(),
                    jcbTiempoPago.getSelectedItem().toString(), "No aplica", fecha,fechaFinal);
            }
        
        
        
      
        jtfBuscarCliente.setText("");
        jtfMontoAPagar.setText("");
        jtfTiempoAPagar.setText("");
        jcbTiempoPago.setSelectedIndex(0);
        jcbPagoPlan.setSelectedIndex(0);

        JOptionPane.showMessageDialog(this, "Registro Exitoso", "Exitoso", JOptionPane.INFORMATION_MESSAGE);
        DefaultTableModel modeloTablaPagos = new DefaultTableModel(pagos.getPago(),columnasPagos);
        tablaPagos.setModel(modeloTablaPagos);
        }
    }//GEN-LAST:event_jbPagoAceptarActionPerformed

    
    private void jbPagoCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbPagoCancelarActionPerformed
        jtfBuscarCliente.setText("");
        jtfMontoAPagar.setText("");
        jtfTiempoAPagar.setText("");
        jcbTiempoPago.setSelectedIndex(0);
        jcbPagoPlan.setSelectedIndex(0);
    }//GEN-LAST:event_jbPagoCancelarActionPerformed

    private void jcbTiempoPagoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcbTiempoPagoItemStateChanged
        if(evt.getStateChange() == ItemEvent.SELECTED)
        {
           if(this.jcbTiempoPago.getSelectedIndex()==2)
            {
                jcbPagoPlan.setEnabled(true);
                
//                this.jcbPagoPlan.setModel(new DefaultComboBoxModel
//                    (this.getTipoTiempo(this.jcbTiempoPago.getSelectedItem().toString())));
            }
        }
    }//GEN-LAST:event_jcbTiempoPagoItemStateChanged

    private void jcbTiempoPagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbTiempoPagoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcbTiempoPagoActionPerformed

    private void jtfbuscarpagoCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_jtfbuscarpagoCaretUpdate
        // TODO add your handling code here:

        DefaultTableModel modeloTablaPagos = new DefaultTableModel(pagos.buscarPago(jtfbuscarpago.getText()), columnasPagos);
        tablaPagos.setModel(modeloTablaPagos);
    }//GEN-LAST:event_jtfbuscarpagoCaretUpdate

    private void jtfbuscarpagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfbuscarpagoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfbuscarpagoActionPerformed

    private void jtfbuscarpagoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfbuscarpagoKeyPressed

        if(evt.isControlDown() || evt.isAltDown() || evt.isShiftDown()){
            evt.consume();
        }
    }//GEN-LAST:event_jtfbuscarpagoKeyPressed

    private void jtfbuscarpagoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfbuscarpagoKeyTyped
        // TODO add your handling code here:
        Character s = evt.getKeyChar();

        if(!Character.isLetter(s) && s != KeyEvent.VK_SPACE){
            evt.consume();
        }

        int limit = 10;
        if (jtfbuscarpago.getText().length() == limit) {
            evt.consume();

        }
    }//GEN-LAST:event_jtfbuscarpagoKeyTyped

    private void tablaPagosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaPagosMouseClicked
        // TODO add your handling code here:
          if(evt.getClickCount()==2)
         {
        filaseleccionadatablapagos = tablaPagos.getSelectedRow();
        jtfBuscarCliente.setText(tablaPagos.getValueAt(filaseleccionadatablapagos, 1).toString());
        jtfMontoAPagar.setText(tablaPagos.getValueAt(filaseleccionadatablapagos, 2).toString());
        jtfTiempoAPagar.setText(tablaPagos.getValueAt(filaseleccionadatablapagos, 3).toString());
        jcbTiempoPago.setSelectedItem(tablaPagos.getValueAt(filaseleccionadatablapagos, 4));
        jcbPagoPlan.setSelectedItem(tablaPagos.getValueAt(filaseleccionadatablapagos, 5));
         }
          
          
          
    }//GEN-LAST:event_tablaPagosMouseClicked

    private void combobuscarportipoplanItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_combobuscarportipoplanItemStateChanged
        // TODO add your handling code here:
        int tf = combobuscarportipoplan.getSelectedIndex();
				switch (tf) {
				
				case 0:
					//String idt = filtro.getText();
					DefaultTableModel modeloTablaPagos = new DefaultTableModel(pagos.getClienteTipoPlan(combobuscarportipoplan.getSelectedItem().toString()), columnasPagos);
                                        tablaPagos.setModel(modeloTablaPagos);
					break;
				case 1:
					 DefaultTableModel modeloTablaPagos1 = new DefaultTableModel(pagos.getClienteTipoPlan(combobuscarportipoplan.getSelectedItem().toString()), columnasPagos);
                                         tablaPagos.setModel(modeloTablaPagos1);
					break;
				case 2:
					
					 DefaultTableModel modeloTablaPagos2 = new DefaultTableModel(pagos.getClienteTipoPlan(combobuscarportipoplan.getSelectedItem().toString()), columnasPagos);
                                         tablaPagos.setModel(modeloTablaPagos2);
					break;
                                        
                                case 3:
                                    
                                        DefaultTableModel modeloTablaPagos3 = new DefaultTableModel(pagos.getClienteTipoPlan(combobuscarportipoplan.getSelectedItem().toString()), columnasPagos);
                                         tablaPagos.setModel(modeloTablaPagos3);
					break;
                                    
                                case 4:    
					
					 DefaultTableModel modeloTablaPagos4 = new DefaultTableModel(pagos.getClienteTipoPlan(combobuscarportipoplan.getSelectedItem().toString()), columnasPagos);
                                         tablaPagos.setModel(modeloTablaPagos4);
					break;  
                                        
                                        
                                case 5:    
					
					 DefaultTableModel modeloTablaPagos5 = new DefaultTableModel(pagos.getPago(), columnasPagos);
                                         tablaPagos.setModel(modeloTablaPagos5);
					break;          
					
				}
			
        
        
    }//GEN-LAST:event_combobuscarportipoplanItemStateChanged

    private void jtfBuscarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfBuscarClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfBuscarClienteActionPerformed

    private void combobuscarportipoplanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combobuscarportipoplanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_combobuscarportipoplanActionPerformed

    private void botonAgregarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAgregarClienteActionPerformed
        // TODO add your handling code here:
        new ListaClientes2(new javax.swing.JDialog(), true).setVisible(true);
        
    }//GEN-LAST:event_botonAgregarClienteActionPerformed

     public String[] getTipoTiempo(String tiempo) {
        String[] plan = new String[4];
        if (tiempo.equalsIgnoreCase("Mes")) {
            plan[0] = "Individual";
            plan[1] = "Pareja";
            plan[2] = "Grupo";
            plan[3] = "Estudiante";
        }
        return plan;
    }


     
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelTablaPagos;
    private javax.swing.JButton botonAgregarCliente;
    private javax.swing.JComboBox<String> combobuscarportipoplan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton jbPagoAceptar;
    private javax.swing.JButton jbPagoCancelar;
    private javax.swing.JComboBox<String> jcbPagoPlan;
    private javax.swing.JComboBox<String> jcbTiempoPago;
    private javax.swing.JLabel jlMontoPagar;
    private javax.swing.JLabel jlRegistroClientes1;
    private javax.swing.JLabel jlTiempoPago;
    private javax.swing.JTextField jtfBuscarCliente;
    private javax.swing.JLabel jtfClienteAPagar;
    private javax.swing.JTextField jtfMontoAPagar;
    private javax.swing.JLabel jtfPagoTipodePlan;
    private javax.swing.JTextField jtfTiempoAPagar;
    private javax.swing.JTextField jtfbuscarpago;
    private javax.swing.JPanel panelDatosPago;
    public static javax.swing.JTable tablaPagos;
    // End of variables declaration//GEN-END:variables
}
