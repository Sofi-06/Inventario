package com.usta.formularios;

import com.usta.configuraciones.DominioEstado;
import com.usta.configuraciones.DominioMantenimiento;
import com.usta.configuraciones.DominioRequerimiento;
import com.usta.daos.DaoEquipo;
import com.usta.entities.Equipo;
import java.awt.Color;
import java.awt.Image;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import org.kordamp.ikonli.materialdesign2.MaterialDesignA;
import org.kordamp.ikonli.materialdesign2.MaterialDesignH;
import org.kordamp.ikonli.swing.FontIcon;

public class FrmEditarEquipos extends javax.swing.JFrame {

    FontIcon iconoUsuario = new FontIcon();
    FontIcon iconoInicio = new FontIcon();

    private Equipo objActualizar;

    private Integer IndiceMantenimiento;
    private Integer IndiceRequerimiento;
    private Integer IndiceEstado;

    private Map<Integer, String> arrayMantenimiento = new HashMap<>();
    private Map<Integer, String> arrayRequerimiento = new HashMap<>();
    private Map<Integer, String> arrayEstado = new HashMap<>();

    private DefaultComboBoxModel<String> miModeloCombo = new DefaultComboBoxModel<>();
    private DefaultComboBoxModel<String> miModeloCombo1 = new DefaultComboBoxModel<>();
    private DefaultComboBoxModel<String> miModeloCombo2 = new DefaultComboBoxModel<>();

    public FrmEditarEquipos(Equipo objEquipo) {
        initComponents();

        setImageToLabel(lblEncabezado, "..\\proyectoFinalTerminado\\Imagenes\\Encabezado.png");
        objActualizar = objEquipo;

        cmbMantenimiento.setModel(miModeloCombo);
        cmbRequerimiento.setModel(miModeloCombo1);
        cmbEstado.setModel(miModeloCombo2);

        txtNombre.setText(objEquipo.getNombreEquipo());
        txtInventario.setText(objEquipo.getInventarioEquipo());
        txtModelo.setText(objEquipo.getModeloEquipo());
        txtSerie.setText(objEquipo.getSerieEquipo());
        txtMarca.setText(objEquipo.getMarcaEquipo());

        cargarMantenimiento();
        cargarRequerimiento();
        cargarEstado();

        iconoUsuario.setIkon(MaterialDesignA.ACCOUNT_CIRCLE_OUTLINE);
        iconoUsuario.setIconSize(40);
        iconoUsuario.setIconColor(Color.decode("#000000"));
        this.lblUsuario.setIcon(iconoUsuario);

        iconoInicio.setIkon(MaterialDesignH.HOME);
        iconoInicio.setIconSize(40);
        iconoInicio.setIconColor(Color.decode("#000000"));
        this.lblInicio.setIcon(iconoInicio);

    }

    private void cargarMantenimiento() {

        IndiceMantenimiento = 0;
        arrayMantenimiento = DominioMantenimiento.ARREGLO_MANTENIMIENTO;

        for (Map.Entry<Integer, String> entry : arrayMantenimiento.entrySet()) {
            Integer key = entry.getKey();
            String value = entry.getValue();

            miModeloCombo.addElement(value);

            if (Objects.equals(objActualizar.getMantemimientoEquipo(), value)) {
                IndiceMantenimiento = key;
            }

        }
        cmbMantenimiento.setSelectedIndex(IndiceMantenimiento);
    }

    private void cargarRequerimiento() {

        IndiceRequerimiento = 0;
        arrayRequerimiento = DominioRequerimiento.ARREGLO_REQUERIMIENTO;

        for (Map.Entry<Integer, String> entry : arrayRequerimiento.entrySet()) {
            Integer key = entry.getKey();
            String value = entry.getValue();

            miModeloCombo1.addElement(value);

            if (Objects.equals(objActualizar.getReqMantemimientoEquipo(), value)) {
                IndiceRequerimiento = key;
            }

        }
        cmbRequerimiento.setSelectedIndex(IndiceRequerimiento);
    }

    private void cargarEstado() {

        IndiceEstado = 0;
        arrayEstado = DominioEstado.ARREGLO_ESTADO;

        for (Map.Entry<Integer, String> entry : arrayEstado.entrySet()) {
            Integer key = entry.getKey();
            String value = entry.getValue();

            miModeloCombo2.addElement(value);

            if (Objects.equals(objActualizar.getEstadoEquipo(), value)) {
                IndiceEstado = key;
            }

        }
        cmbEstado.setSelectedIndex(IndiceEstado);
    }

    private Boolean estaTodoBien() {

        String nombre, inventario, modelo, serie, marca;
        Boolean bandera = true;

        nombre = txtNombre.getText();
        if (nombre.equals("")) {
            txtNombre.requestFocus();
            bandera = false;
            JOptionPane.showMessageDialog(jPanel1, "Digite el Nombre del Equipo", "Advertencia", JOptionPane.WARNING_MESSAGE);

        } else {

            inventario = txtInventario.getText();
            if (inventario.equals("")) {
                txtInventario.requestFocus();
                bandera = false;
                JOptionPane.showMessageDialog(jPanel1, "Digite el Inventario del Equipo", "Advertencia", JOptionPane.WARNING_MESSAGE);

            } else {

                modelo = txtModelo.getText();
                if (modelo.equals("")) {
                    txtModelo.requestFocus();
                    bandera = false;
                    JOptionPane.showMessageDialog(jPanel1, "Digite el Modelo del Equipo", "Advertencia", JOptionPane.WARNING_MESSAGE);

                } else {

                    serie = txtSerie.getText();
                    if (serie.equals("")) {
                        txtSerie.requestFocus();
                        bandera = false;
                        JOptionPane.showMessageDialog(jPanel1, "Digite la Serie del Equipo", "Advertencia", JOptionPane.WARNING_MESSAGE);

                    } else {

                        marca = txtMarca.getText();
                        if (marca.equals("")) {
                            txtMarca.requestFocus();
                            bandera = false;
                            JOptionPane.showMessageDialog(jPanel1, "Digite la Serie del Equipo", "Advertencia", JOptionPane.WARNING_MESSAGE);

                        } else {

                            if (cmbMantenimiento.getSelectedIndex() == 0) {
                                bandera = false;
                                JOptionPane.showMessageDialog(jPanel1, "Por favor seleccione un Mantenimiento", "Advertencia", JOptionPane.WARNING_MESSAGE);

                            } else {

                                if (cmbRequerimiento.getSelectedIndex() == 0) {
                                    bandera = false;
                                    JOptionPane.showMessageDialog(jPanel1, "Por favor seleccione un Requerimiento", "Advertencia", JOptionPane.WARNING_MESSAGE);
                                } else {

                                    if (cmbEstado.getSelectedIndex() == 0) {
                                        bandera = false;
                                        JOptionPane.showMessageDialog(jPanel1, "Por favor seleccione un Estado", "Advertencia", JOptionPane.WARNING_MESSAGE);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return bandera;
    }

    private void limpiarCajas() {
        txtNombre.setText("");
        txtInventario.setText("");
        txtModelo.setText("");
        txtSerie.setText("");
        txtMarca.setText("");
        cmbMantenimiento.setSelectedIndex(0);
        cmbRequerimiento.setSelectedIndex(0);
        cmbEstado.setSelectedIndex(0);

        txtNombre.requestFocus();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblEncabezado = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtInventario = new javax.swing.JTextField();
        txtMarca = new javax.swing.JTextField();
        txtModelo = new javax.swing.JTextField();
        cmbRequerimiento = new javax.swing.JComboBox<>();
        cmbMantenimiento = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        cmbEstado = new javax.swing.JComboBox<>();
        txtSerie = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        panelUsuario = new javax.swing.JPanel();
        lblUsuario = new javax.swing.JLabel();
        panelInicio = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        lblInicio = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Quando", 0, 40)); // NOI18N
        jLabel1.setText("EQUIPOS DE LABORATORIO");

        txtNombre.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });

        txtInventario.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        txtInventario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtInventarioActionPerformed(evt);
            }
        });

        txtMarca.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        txtMarca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMarcaActionPerformed(evt);
            }
        });

        txtModelo.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        txtModelo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtModeloActionPerformed(evt);
            }
        });

        cmbRequerimiento.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        cmbRequerimiento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione Requerimiento", "Preventivo", "Correctivo", "Calibración" }));

        cmbMantenimiento.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        cmbMantenimiento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione Mantenimiento", "Semestral", "Bianual", "Anual" }));

        jButton1.setBackground(new java.awt.Color(0, 204, 255));
        jButton1.setFont(new java.awt.Font("Roboto", 1, 20)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("EDITAR EQUIPO DE LABORATORIO");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        cmbEstado.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        cmbEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione Uso", "Activo", "Inactivo", "Dar de baja" }));

        txtSerie.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        txtSerie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSerieActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Quando", 0, 16)); // NOI18N
        jLabel3.setText("INVENTARIO");

        jLabel4.setFont(new java.awt.Font("Quando", 0, 16)); // NOI18N
        jLabel4.setText("NOMBRE");

        jLabel5.setFont(new java.awt.Font("Quando", 0, 16)); // NOI18N
        jLabel5.setText("MARCA");

        jLabel6.setFont(new java.awt.Font("Quando", 0, 16)); // NOI18N
        jLabel6.setText("MODELO");

        jLabel7.setFont(new java.awt.Font("Quando", 0, 16)); // NOI18N
        jLabel7.setText("MANTENIMIENTO");

        jLabel8.setFont(new java.awt.Font("Quando", 0, 16)); // NOI18N
        jLabel8.setText("SERIE");

        jLabel9.setFont(new java.awt.Font("Quando", 0, 16)); // NOI18N
        jLabel9.setText("REQUERIMIENTO DE MANTENIMIENTO");

        jLabel10.setFont(new java.awt.Font("Quando", 0, 16)); // NOI18N
        jLabel10.setText("ESTADO DE USO");

        panelUsuario.setBackground(new java.awt.Color(255, 255, 255));
        panelUsuario.setToolTipText("Cerrar Sesión");
        panelUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelUsuarioMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                panelUsuarioMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                panelUsuarioMouseExited(evt);
            }
        });

        lblUsuario.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout panelUsuarioLayout = new javax.swing.GroupLayout(panelUsuario);
        panelUsuario.setLayout(panelUsuarioLayout);
        panelUsuarioLayout.setHorizontalGroup(
            panelUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
        );
        panelUsuarioLayout.setVerticalGroup(
            panelUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblUsuario, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 63, Short.MAX_VALUE)
        );

        panelInicio.setBackground(new java.awt.Color(255, 255, 255));
        panelInicio.setToolTipText("Inicio");
        panelInicio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelInicioMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                panelInicioMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                panelInicioMouseExited(evt);
            }
        });
        panelInicio.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setText("___________________________");
        panelInicio.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, -1, -1));

        lblInicio.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        panelInicio.add(lblInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, 120, 63));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(lblEncabezado, javax.swing.GroupLayout.PREFERRED_SIZE, 1336, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 509, Short.MAX_VALUE)
                                        .addComponent(txtMarca)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addGap(9, 9, 9)
                                            .addComponent(jLabel4)))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(cmbMantenimiento, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGap(193, 193, 193)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(cmbRequerimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 509, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(188, 188, 188)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtSerie)
                            .addComponent(txtModelo)
                            .addComponent(txtInventario)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addComponent(jLabel3))
                            .addComponent(cmbEstado, 0, 509, Short.MAX_VALUE))
                        .addGap(84, 84, 84))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addGap(140, 140, 140))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(351, 351, 351)
                                .addComponent(panelInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(panelUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(jLabel9)
                                .addGap(350, 350, 350)
                                .addComponent(jLabel10)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addGap(531, 531, 531))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addGap(504, 504, 504))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(lblEncabezado, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(panelInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtInventario, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtModelo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbMantenimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSerie, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cmbRequerimiento)
                    .addComponent(cmbEstado, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE))
                .addGap(81, 81, 81)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 1320, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreActionPerformed

    private void txtInventarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtInventarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtInventarioActionPerformed

    private void txtMarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMarcaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMarcaActionPerformed

    private void txtModeloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtModeloActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtModeloActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (estaTodoBien()) {
            String nombre, inventario, modelo, serie, marca, mantenimiento, requerimiento, estado;

            nombre = txtNombre.getText();
            inventario = txtInventario.getText();
            modelo = txtModelo.getText();
            serie = txtSerie.getText();
            marca = txtMarca.getText();
            mantenimiento = cmbMantenimiento.getSelectedItem().toString();
            requerimiento = cmbRequerimiento.getSelectedItem().toString();
            estado = cmbEstado.getSelectedItem().toString();

            objActualizar.setNombreEquipo(nombre);
            objActualizar.setInventarioEquipo(inventario);
            objActualizar.setModeloEquipo(modelo);
            objActualizar.setSerieEquipo(serie);
            objActualizar.setMarcaEquipo(marca);
            objActualizar.setMantemimientoEquipo(mantenimiento);
            objActualizar.setReqMantemimientoEquipo(requerimiento);
            objActualizar.setEstadoEquipo(estado);

            DaoEquipo miDaoEquipo = new DaoEquipo();

            if (miDaoEquipo.actualizar(objActualizar)) {
                JOptionPane.showMessageDialog(jPanel1, "Se ha Editado Exitosamente", "Información", JOptionPane.INFORMATION_MESSAGE);
                limpiarCajas();
            } else {
                JOptionPane.showMessageDialog(jPanel1, "No se ha Podido Editar", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtSerieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSerieActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSerieActionPerformed

    private void panelUsuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelUsuarioMouseClicked
        int opcion;

        String textoBotones[] = {"Salir", "Cancelar"};

        opcion = JOptionPane.showOptionDialog(lblUsuario, "¿ Desea Salir del Sistema ?", "Aviso", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, textoBotones, textoBotones[1]);

        if (opcion == JOptionPane.YES_OPTION) {

            this.dispose();

        }
    }//GEN-LAST:event_panelUsuarioMouseClicked

    private void panelUsuarioMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelUsuarioMouseEntered
        panelUsuario.setBackground(Color.decode("#00CCC0"));
        iconoUsuario.setIconColor(Color.decode("#ffffff"));
    }//GEN-LAST:event_panelUsuarioMouseEntered

    private void panelUsuarioMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelUsuarioMouseExited
        panelUsuario.setBackground(Color.decode("#ffffff"));
        iconoUsuario.setIconColor(Color.decode("#000000"));
    }//GEN-LAST:event_panelUsuarioMouseExited

    private void panelInicioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelInicioMouseClicked
        FrmHomeLaboratorista laboratorista = new FrmHomeLaboratorista();
        laboratorista.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_panelInicioMouseClicked

    private void panelInicioMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelInicioMouseEntered
        panelInicio.setBackground(Color.decode("#10ABB4"));
        iconoInicio.setIconColor(Color.decode("#ffffff"));
    }//GEN-LAST:event_panelInicioMouseEntered

    private void panelInicioMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelInicioMouseExited
        panelInicio.setBackground(Color.decode("#ffffff"));
        iconoInicio.setIconColor(Color.decode("#000000"));
    }//GEN-LAST:event_panelInicioMouseExited

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
            java.util.logging.Logger.getLogger(FrmEditarEquipos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmEditarEquipos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmEditarEquipos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmEditarEquipos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FrmEditarEquipos dialog = new FrmEditarEquipos(new Equipo());
                dialog.setVisible(true);
            }
        });
    }

    public static void setImageToLabel(JLabel lbl, String imagePath) {
        // Cargar la imagen desde el archivo
        ImageIcon imageIcon = new ImageIcon(imagePath);

        // Obtener el ancho y alto del JLabel
        int width = lbl.getWidth();
        int height = lbl.getHeight();

        // Escalar la imagen al tamaño del JLabel
        Image scaledImage = imageIcon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);

        // Crear un nuevo ImageIcon con la imagen escalada
        ImageIcon scaledIcon = new ImageIcon(scaledImage);

        // Establecer la imagen escalada en el JLabel
        lbl.setIcon(scaledIcon);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cmbEstado;
    private javax.swing.JComboBox<String> cmbMantenimiento;
    private javax.swing.JComboBox<String> cmbRequerimiento;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblEncabezado;
    private javax.swing.JLabel lblInicio;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JPanel panelInicio;
    private javax.swing.JPanel panelUsuario;
    private javax.swing.JTextField txtInventario;
    private javax.swing.JTextField txtMarca;
    private javax.swing.JTextField txtModelo;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtSerie;
    // End of variables declaration//GEN-END:variables
}
