/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HotelDatabase;
import java.awt.HeadlessException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import java.sql.*;
import java.text.DateFormat;
import java.text.MessageFormat;
import java.text.ParseException;
import javax.swing.JTextField;

/**
 *
 * @author Vilardo
 */
public class HotelDatabase extends javax.swing.JFrame {
    
    Connection conn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    
    DefaultTableModel model = new DefaultTableModel();
    
    
    /**
     * Creates new form HotelDatabase
     */
    public HotelDatabase() {
        initComponents();
        
        Object col[] = {"Cliente", "Nombre", "Apellido", "Direccion", "CodigoPostal", "Telefono", "Email", "Nacionalidad", "Nacimiento", "DNI", 
            "Genero", "Llegada", "Salida", "Pension", "Tipohabitacion", "Ndehabitacion"};
        
        model.setColumnIdentifiers(col);
        jTabla.setModel(model);
        conn = this.ConnectDB();
        this.updateTable();
        
    }
    
    public static Connection ConnectDB(){
        try{
            Class.forName("org.sqlite.JDBC");
            Connection conn = DriverManager.getConnection("jdbc:sqlite:hotelDatabase.db");
            return conn;
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }
    
    public void updateTable(){
        conn = this.ConnectDB();
        if(conn != null){
            String sql = "Select Cliente,Nombre,Apellido,Direccion,CodigoPostal,Telefono,Email,Nacionalidad,Nacimiento,DNI,"
                    + "Genero,Llegada,Salida,Pension,Tipohabitacion,Numerohabitacion from hotelDatabase";
            
            try{
                pst = conn.prepareStatement(sql);
                rs = pst.executeQuery();
                Object[] columnData = new Object[16];
                
                while(rs.next()){
                    columnData[0] = rs.getString("Cliente");
                    columnData[1] = rs.getString("Nombre");
                    columnData[2] = rs.getString("Apellido");
                    columnData[3] = rs.getString("Direccion");
                    columnData[4] = rs.getString("CodigoPostal");
                    columnData[5] = rs.getString("Telefono");
                    columnData[6] = rs.getString("Email");
                    columnData[7] = rs.getString("Nacionalidad");
                    columnData[8] = rs.getString("Nacimiento");
                    columnData[9] = rs.getString("DNI");
                    columnData[10] = rs.getString("Genero");
                    columnData[11] = rs.getString("Llegada");
                    columnData[12] = rs.getString("Salida");
                    columnData[13] = rs.getString("Pension");
                    columnData[14] = rs.getString("Tipohabitacion");
                    columnData[15] = rs.getString("Numerohabitacion");
                    model.addRow(columnData);             
                }
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTxtCliente = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTxtNombre = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTxtApellido = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTxtDireccion = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTxtCodigoPostal = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTxtTelefono = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jTxtEmail = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jTxtDni = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jButtonImprimir = new javax.swing.JButton();
        jButtonTotal = new javax.swing.JButton();
        jButtonReiniciar = new javax.swing.JButton();
        jButtonActualizar = new javax.swing.JButton();
        jButtonBorrar = new javax.swing.JButton();
        jButtonSalir = new javax.swing.JButton();
        jTxtCliente18 = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jTxtCliente19 = new javax.swing.JTextField();
        jTxtCliente20 = new javax.swing.JTextField();
        jTxtTotal = new javax.swing.JTextField();
        jTxtImpuestos = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jTxtSubtotal = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTabla = new javax.swing.JTable();
        jBoxNumeroExternoHabitacion = new javax.swing.JComboBox<>();
        jBoxGenero = new javax.swing.JComboBox<>();
        jBoxPension = new javax.swing.JComboBox<>();
        jBoxTipoHabitacion = new javax.swing.JComboBox<>();
        jBoxNumeroHabitacion = new javax.swing.JComboBox<>();
        jBoxNacionalidad = new com.toedter.components.JLocaleChooser();
        jTxtSalida = new com.toedter.calendar.JDateChooser();
        jTxtNacimiento = new com.toedter.calendar.JDateChooser();
        jTxtLlegada = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        jLabel1.setText("Cliente");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jTxtCliente.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        getContentPane().add(jTxtCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 10, 190, -1));

        jLabel2.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        jLabel2.setText("Nombre");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, -1, -1));

        jTxtNombre.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        getContentPane().add(jTxtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 40, 190, -1));

        jLabel3.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        jLabel3.setText("Apellido");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, -1, -1));

        jTxtApellido.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        getContentPane().add(jTxtApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 70, 190, -1));

        jLabel4.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        jLabel4.setText("Direccion");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, -1, -1));

        jTxtDireccion.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        getContentPane().add(jTxtDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 100, 190, -1));

        jLabel5.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        jLabel5.setText("Codigo postal");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, -1, -1));

        jTxtCodigoPostal.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        getContentPane().add(jTxtCodigoPostal, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 130, 190, -1));

        jLabel6.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        jLabel6.setText("Telefono");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, -1, -1));

        jTxtTelefono.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        getContentPane().add(jTxtTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 160, 190, -1));

        jLabel7.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        jLabel7.setText("Email");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, -1, -1));

        jTxtEmail.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        getContentPane().add(jTxtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 190, 190, -1));

        jLabel8.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        jLabel8.setText("Nacionalidad");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, -1, -1));

        jLabel9.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        jLabel9.setText("Fecha de nacimiento");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, -1, -1));

        jLabel10.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        jLabel10.setText("DNI");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, -1, -1));

        jTxtDni.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        getContentPane().add(jTxtDni, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 280, 190, -1));

        jLabel11.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        jLabel11.setText("Genero");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 310, -1, -1));

        jLabel12.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        jLabel12.setText("Fecha de llegada");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 340, -1, -1));

        jLabel13.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        jLabel13.setText("Fecha de salida");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 370, -1, -1));

        jLabel14.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        jLabel14.setText("Pension");
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 400, -1, -1));

        jLabel15.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        jLabel15.setText("Tipo de habitacion");
        getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 430, -1, -1));

        jLabel16.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        jLabel16.setText("N° habitacion");
        getContentPane().add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 460, -1, -1));

        jLabel17.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        jLabel17.setText("N° Ext. habitacion");
        getContentPane().add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 490, -1, -1));

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        jPanel1.setFocusable(false);
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButtonImprimir.setFont(new java.awt.Font("Berlin Sans FB", 0, 18)); // NOI18N
        jButtonImprimir.setText("Imprimir");
        jButtonImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonImprimirActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonImprimir, new org.netbeans.lib.awtextra.AbsoluteConstraints(1130, 30, 130, 50));

        jButtonTotal.setFont(new java.awt.Font("Berlin Sans FB", 0, 18)); // NOI18N
        jButtonTotal.setText("Total");
        jButtonTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonTotalActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 30, 130, 50));

        jButtonReiniciar.setFont(new java.awt.Font("Berlin Sans FB", 0, 18)); // NOI18N
        jButtonReiniciar.setText("Reiniciar");
        jButtonReiniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonReiniciarActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonReiniciar, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 30, 130, 50));

        jButtonActualizar.setFont(new java.awt.Font("Berlin Sans FB", 0, 18)); // NOI18N
        jButtonActualizar.setText("Actualizar");
        jButtonActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonActualizarActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonActualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 30, 130, 50));

        jButtonBorrar.setFont(new java.awt.Font("Berlin Sans FB", 0, 18)); // NOI18N
        jButtonBorrar.setText("Borrar");
        jButtonBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBorrarActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonBorrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 30, 130, 50));

        jButtonSalir.setFont(new java.awt.Font("Berlin Sans FB", 0, 18)); // NOI18N
        jButtonSalir.setText("Salir");
        jButtonSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalirActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 30, 130, 50));

        jTxtCliente18.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        jPanel1.add(jTxtCliente18, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 460, 110, -1));

        jLabel19.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        jLabel19.setText("Cliente");
        jPanel1.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 460, -1, -1));

        jLabel20.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        jLabel20.setText("Cliente");
        jPanel1.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 490, -1, -1));

        jLabel21.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        jLabel21.setText("Cliente");
        jPanel1.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 520, -1, -1));

        jTxtCliente19.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        jPanel1.add(jTxtCliente19, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 520, 110, -1));

        jTxtCliente20.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        jPanel1.add(jTxtCliente20, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 490, 110, -1));

        jTxtTotal.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        jPanel1.add(jTxtTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 80, 240, -1));

        jTxtImpuestos.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        jPanel1.add(jTxtImpuestos, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 20, 240, -1));

        jLabel22.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        jLabel22.setText("Impuestos");
        jPanel1.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        jTxtSubtotal.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        jPanel1.add(jTxtSubtotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 50, 240, -1));

        jLabel24.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        jLabel24.setText("Total");
        jPanel1.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, -1, -1));

        jLabel23.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        jLabel23.setText("Subtotal");
        jPanel1.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 570, 1280, 110));

        jTabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cliente", "Nombre", "Apellido", "Direccion", "CodigoPostal", "Telefono", "Email", "Nacionalidad", "Nacimiento", "DNI", "Genero", "Llegada", "Salida", "Pension", "Tipohabitacion", "Numerohabitacion"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTabla);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 10, 1050, 540));

        jBoxNumeroExternoHabitacion.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        jBoxNumeroExternoHabitacion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select", "101", "102", "103", "104", "105", "106", "107", "108", "109", "110", "111", "112" }));
        getContentPane().add(jBoxNumeroExternoHabitacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 490, 190, -1));

        jBoxGenero.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        jBoxGenero.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select", "Hombre", "Mujer", "Otro" }));
        getContentPane().add(jBoxGenero, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 310, 190, -1));

        jBoxPension.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        jBoxPension.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select", "Media Pension", "Pension Completa" }));
        getContentPane().add(jBoxPension, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 400, 190, -1));

        jBoxTipoHabitacion.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        jBoxTipoHabitacion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select", "Simple", "Doble", "Family" }));
        getContentPane().add(jBoxTipoHabitacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 430, 190, -1));

        jBoxNumeroHabitacion.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        jBoxNumeroHabitacion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select", "001", "002", "003", "004", "005", "006", "007", "008", "009", "010", "011", "012" }));
        getContentPane().add(jBoxNumeroHabitacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 460, 190, -1));
        getContentPane().add(jBoxNacionalidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 220, 190, -1));
        getContentPane().add(jTxtSalida, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 370, 190, -1));
        getContentPane().add(jTxtNacimiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 250, 190, -1));
        getContentPane().add(jTxtLlegada, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 340, 190, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonImprimirActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonImprimirActionPerformed

    private void jButtonTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonTotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonTotalActionPerformed

    private void jButtonReiniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonReiniciarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonReiniciarActionPerformed

    private void jButtonActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonActualizarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonActualizarActionPerformed

    private void jButtonBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBorrarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonBorrarActionPerformed

    private void jButtonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalirActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonSalirActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(HotelDatabase.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HotelDatabase.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HotelDatabase.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HotelDatabase.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HotelDatabase().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> jBoxGenero;
    private com.toedter.components.JLocaleChooser jBoxNacionalidad;
    private javax.swing.JComboBox<String> jBoxNumeroExternoHabitacion;
    private javax.swing.JComboBox<String> jBoxNumeroHabitacion;
    private javax.swing.JComboBox<String> jBoxPension;
    private javax.swing.JComboBox<String> jBoxTipoHabitacion;
    private javax.swing.JButton jButtonActualizar;
    private javax.swing.JButton jButtonBorrar;
    private javax.swing.JButton jButtonImprimir;
    private javax.swing.JButton jButtonReiniciar;
    private javax.swing.JButton jButtonSalir;
    private javax.swing.JButton jButtonTotal;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTabla;
    private javax.swing.JTextField jTxtApellido;
    private javax.swing.JTextField jTxtCliente;
    private javax.swing.JTextField jTxtCliente18;
    private javax.swing.JTextField jTxtCliente19;
    private javax.swing.JTextField jTxtCliente20;
    private javax.swing.JTextField jTxtCodigoPostal;
    private javax.swing.JTextField jTxtDireccion;
    private javax.swing.JTextField jTxtDni;
    private javax.swing.JTextField jTxtEmail;
    private javax.swing.JTextField jTxtImpuestos;
    private com.toedter.calendar.JDateChooser jTxtLlegada;
    private com.toedter.calendar.JDateChooser jTxtNacimiento;
    private javax.swing.JTextField jTxtNombre;
    private com.toedter.calendar.JDateChooser jTxtSalida;
    private javax.swing.JTextField jTxtSubtotal;
    private javax.swing.JTextField jTxtTelefono;
    private javax.swing.JTextField jTxtTotal;
    // End of variables declaration//GEN-END:variables
}
