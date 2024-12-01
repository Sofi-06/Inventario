package com.usta.formularios;

import com.usta.daos.DaoConsumible;
import com.usta.entities.Consumible;
import java.awt.Color;
import java.awt.Image;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.kordamp.ikonli.materialdesign2.MaterialDesignA;
import org.kordamp.ikonli.materialdesign2.MaterialDesignH;
import org.kordamp.ikonli.swing.FontIcon;

public class FrmEditarConsumibles extends javax.swing.JFrame {

    FontIcon iconoUsuario = new FontIcon();
    FontIcon iconoInicio = new FontIcon();

    private String rutaAplicacion;
    private Consumible objActualizar;

    public FrmEditarConsumibles(Consumible ObjExterno) {
        initComponents();

        objActualizar = ObjExterno;
        rutaAplicacion = System.getProperty("user.dir");

        txtNombre.setText(objActualizar.getNombreConsumible());
        txtMarca.setText(objActualizar.getMarcaConsumible());
        txtObservaciones.setText(objActualizar.getObservacionConsumible());
        txtReferencia.setText(objActualizar.getReferenciaConsumible());
        txtCantidad.setText(objActualizar.getCantidadConsumible() + "");
        txtGabinete.setText(objActualizar.getNumeroGabineteConsumible() + "");

        lblFoto.setText(objActualizar.getFotoConsumible());

        try {
            // define la URL de la imagen externa
            URL imageUrl = new URL("https://cdn-icons-png.freepik.com/256/568/568761.png?ga=GA1.1.1932565225.1716349192&semt=ais_hybrid");
            // crea una imagenIcon a partir de la URL
            Image imageIcon = new ImageIcon(imageUrl).getImage().getScaledInstance(50, 50, 0);
            ImageIcon icono = new ImageIcon(imageIcon);
            // crea un Jlabel y asigna el ImageIcon
            lblFoto.setIcon(icono);

        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        setImageToLabel(lblEncabezado, "..\\proyectoFinalTerminado\\Imagenes\\Encabezado.png");
        iconoUsuario.setIkon(MaterialDesignA.ACCOUNT_CIRCLE_OUTLINE);
        iconoUsuario.setIconSize(40);
        iconoUsuario.setIconColor(Color.decode("#000000"));
        this.lblUsuario.setIcon(iconoUsuario);

        iconoInicio.setIkon(MaterialDesignH.HOME);
        iconoInicio.setIconSize(40);
        iconoInicio.setIconColor(Color.decode("#000000"));
        this.lblInicio.setIcon(iconoInicio);
    }

    private Boolean estaTodoBien() {
        Boolean bandera = true;

        String nombre;
        nombre = txtNombre.getText();
        if (nombre.equals("")) {
            txtNombre.requestFocus();
            bandera = false;
            JOptionPane.showMessageDialog(panelCuerpo, "Ingrese un nombre correcto", "Error", JOptionPane.ERROR_MESSAGE);
        }

        String marca;
        marca = txtMarca.getText();
        if (marca.equals("")) {
            txtMarca.requestFocus();
            bandera = false;
            JOptionPane.showMessageDialog(panelCuerpo, "Ingrese la Marca", "Error", JOptionPane.ERROR_MESSAGE);
        }

        String observaciones;
        observaciones = txtObservaciones.getText();
        if (observaciones.equals("")) {
            txtMarca.requestFocus();
            bandera = false;
            JOptionPane.showMessageDialog(panelCuerpo, "Ingrese las Observaciones", "Error", JOptionPane.ERROR_MESSAGE);
        }

        String referencias;
        referencias = txtReferencia.getText();
        if (referencias.equals("")) {
            txtMarca.requestFocus();
            bandera = false;
            JOptionPane.showMessageDialog(panelCuerpo, "Ingrese la Referencia", "Error", JOptionPane.ERROR_MESSAGE);
        }

        Integer cantidad;
        try {
            cantidad = Integer.valueOf(txtCantidad.getText());

            if (cantidad < 0) {

                bandera = false;
                txtCantidad.requestFocus();
                JOptionPane.showMessageDialog(panelCuerpo, "Digite numeros positivos", "advertencia", JOptionPane.WARNING_MESSAGE);
            }
        } catch (NumberFormatException e) {
            bandera = false;
            JOptionPane.showMessageDialog(panelCuerpo, "Digite la cantidad", "advertencia", JOptionPane.WARNING_MESSAGE);
        }

        Integer gabinete;
        try {
            gabinete = Integer.valueOf(txtCantidad.getText());

            if (gabinete < 0) {

                bandera = false;
                txtCantidad.requestFocus();
                JOptionPane.showMessageDialog(panelCuerpo, "Digite el numero de gabinete", "advertencia", JOptionPane.WARNING_MESSAGE);
            }
        } catch (NumberFormatException e) {
            bandera = false;
            JOptionPane.showMessageDialog(panelCuerpo, "Digite la cantidad", "advertencia", JOptionPane.WARNING_MESSAGE);
        }

        return bandera;
    }

    private void limpiarCajas() {
        txtNombre.setText("");
        txtReferencia.setText("");
        txtMarca.setText("");
        txtCantidad.setText("");
        txtObservaciones.setText("");
        txtGabinete.setText("");
        lblFoto.setText(null);

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

        panelCuerpo = new javax.swing.JPanel();
        lblEncabezado = new javax.swing.JLabel();
        lblTitulo = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtReferencia = new javax.swing.JTextField();
        txtMarca = new javax.swing.JTextField();
        txtCantidad = new javax.swing.JTextField();
        btnAñadir = new javax.swing.JButton();
        txtGabinete = new javax.swing.JTextField();
        lblReferencia = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        lblMarca = new javax.swing.JLabel();
        lblCantidad = new javax.swing.JLabel();
        lblObservaciones = new javax.swing.JLabel();
        lblGabinete = new javax.swing.JLabel();
        lblFoto1 = new javax.swing.JLabel();
        txtObservaciones = new javax.swing.JTextField();
        lblFoto = new javax.swing.JLabel();
        panelUsuario = new javax.swing.JPanel();
        lblUsuario = new javax.swing.JLabel();
        panelInicio = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lblInicio = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        panelCuerpo.setBackground(new java.awt.Color(255, 255, 255));

        lblTitulo.setFont(new java.awt.Font("Quando", 0, 40)); // NOI18N
        lblTitulo.setText("CONSUMIBLES DE LABORATORIO");

        txtNombre.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });

        txtReferencia.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        txtReferencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtReferenciaActionPerformed(evt);
            }
        });

        txtMarca.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        txtMarca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMarcaActionPerformed(evt);
            }
        });

        txtCantidad.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        txtCantidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCantidadActionPerformed(evt);
            }
        });

        btnAñadir.setBackground(new java.awt.Color(0, 204, 255));
        btnAñadir.setFont(new java.awt.Font("Roboto", 1, 20)); // NOI18N
        btnAñadir.setForeground(new java.awt.Color(255, 255, 255));
        btnAñadir.setText("AÑADIR CONSUMIBLE DE LABORATORIO");
        btnAñadir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAñadirActionPerformed(evt);
            }
        });

        txtGabinete.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        txtGabinete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtGabineteActionPerformed(evt);
            }
        });

        lblReferencia.setFont(new java.awt.Font("Quando", 0, 16)); // NOI18N
        lblReferencia.setText("REFERENCIA");

        lblNombre.setFont(new java.awt.Font("Quando", 0, 16)); // NOI18N
        lblNombre.setText("NOMBRE");

        lblMarca.setFont(new java.awt.Font("Quando", 0, 16)); // NOI18N
        lblMarca.setText("MARCA");

        lblCantidad.setFont(new java.awt.Font("Quando", 0, 16)); // NOI18N
        lblCantidad.setText("CANTIDAD");

        lblObservaciones.setFont(new java.awt.Font("Quando", 0, 16)); // NOI18N
        lblObservaciones.setText("OBSERVACIONES");

        lblGabinete.setFont(new java.awt.Font("Quando", 0, 16)); // NOI18N
        lblGabinete.setText("NÚMERO DE GABINETE");

        lblFoto1.setFont(new java.awt.Font("Quando", 0, 16)); // NOI18N
        lblFoto1.setText("FOTO");

        txtObservaciones.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        txtObservaciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtObservacionesActionPerformed(evt);
            }
        });

        lblFoto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblFoto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblFoto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblFotoMouseClicked(evt);
            }
        });

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

        jLabel1.setText("___________________________");
        panelInicio.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, -1, -1));

        lblInicio.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        panelInicio.add(lblInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, 120, 63));

        javax.swing.GroupLayout panelCuerpoLayout = new javax.swing.GroupLayout(panelCuerpo);
        panelCuerpo.setLayout(panelCuerpoLayout);
        panelCuerpoLayout.setHorizontalGroup(
            panelCuerpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCuerpoLayout.createSequentialGroup()
                .addComponent(lblEncabezado, javax.swing.GroupLayout.PREFERRED_SIZE, 1336, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelCuerpoLayout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(lblObservaciones)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblGabinete)
                .addGap(412, 412, 412))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelCuerpoLayout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addComponent(lblMarca)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblCantidad)
                .addGap(504, 504, 504))
            .addGroup(panelCuerpoLayout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(panelCuerpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelCuerpoLayout.createSequentialGroup()
                        .addComponent(lblTitulo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(panelInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(panelUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(80, 80, 80))
                    .addGroup(panelCuerpoLayout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(lblFoto1)
                        .addContainerGap())
                    .addGroup(panelCuerpoLayout.createSequentialGroup()
                        .addGroup(panelCuerpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(lblFoto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtNombre, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtMarca, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelCuerpoLayout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addComponent(lblNombre))
                            .addComponent(txtObservaciones, javax.swing.GroupLayout.DEFAULT_SIZE, 509, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(panelCuerpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelCuerpoLayout.createSequentialGroup()
                                .addComponent(lblReferencia)
                                .addGap(472, 472, 472))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelCuerpoLayout.createSequentialGroup()
                                .addGroup(panelCuerpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 509, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtReferencia, javax.swing.GroupLayout.PREFERRED_SIZE, 509, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtGabinete, javax.swing.GroupLayout.PREFERRED_SIZE, 509, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(135, 135, 135))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelCuerpoLayout.createSequentialGroup()
                                .addComponent(btnAñadir)
                                .addGap(208, 208, 208))))))
        );
        panelCuerpoLayout.setVerticalGroup(
            panelCuerpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCuerpoLayout.createSequentialGroup()
                .addComponent(lblEncabezado, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panelCuerpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelCuerpoLayout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(lblTitulo))
                    .addComponent(panelInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelCuerpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblReferencia)
                    .addComponent(lblNombre))
                .addGroup(panelCuerpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelCuerpoLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39))
                    .addGroup(panelCuerpoLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtReferencia, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(panelCuerpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMarca)
                    .addComponent(lblCantidad))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelCuerpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(panelCuerpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelCuerpoLayout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(lblObservaciones))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelCuerpoLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblGabinete)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelCuerpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtGabinete, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtObservaciones, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addComponent(lblFoto1)
                .addGroup(panelCuerpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelCuerpoLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(btnAñadir, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelCuerpoLayout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(lblFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(25, 25, 25))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelCuerpo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelCuerpo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreActionPerformed

    private void txtReferenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtReferenciaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtReferenciaActionPerformed

    private void txtMarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMarcaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMarcaActionPerformed

    private void txtCantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCantidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCantidadActionPerformed

    private void btnAñadirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAñadirActionPerformed
        if (estaTodoBien()) {
            String nombre, marca, observaciones, referencia;

            Integer cantidad, gabinete;

            nombre = txtNombre.getText();
            marca = txtMarca.getText();
            observaciones = txtObservaciones.getText();
            referencia = txtReferencia.getText();
            cantidad = Integer.valueOf(txtCantidad.getText());
            gabinete = Integer.valueOf(txtGabinete.getText());

            objActualizar.setNombreConsumible(nombre);
            objActualizar.setMarcaConsumible(marca);
            objActualizar.setObservacionConsumible(observaciones);
            objActualizar.setReferenciaConsumible(referencia);
            objActualizar.setCantidadConsumible(cantidad);
            objActualizar.setNumeroGabineteConsumible(gabinete);
            objActualizar.setFotoConsumible(rutaAplicacion);

            DaoConsumible miDao = new DaoConsumible();
            if (miDao.actualizar(objActualizar)) {
                limpiarCajas();
                JOptionPane.showMessageDialog(panelCuerpo, "¡¡Se actualizo exitosamente!!", "Informacion", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(panelCuerpo, "Registro fallido", "Error", JOptionPane.ERROR_MESSAGE);
            }

        }
    }//GEN-LAST:event_btnAñadirActionPerformed

    private void txtGabineteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtGabineteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtGabineteActionPerformed

    private void txtObservacionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtObservacionesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtObservacionesActionPerformed

    private void lblFotoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblFotoMouseClicked
        String rutaArchivoSeleccionado;

        File rutaReal = new File(rutaAplicacion);
        JFileChooser seleccionar = new JFileChooser(); // permite abrir ventana flotante
        seleccionar.setCurrentDirectory(rutaReal); // directorio actual
// filtrar tipo de archivos, * es como un comodin significa cualquier nombre pero que sea jpg o png
        seleccionar.setFileFilter(new FileNameExtensionFilter("Imagenes (*.jpg, *.png)", "jpg", "png"));

        int resultado = seleccionar.showOpenDialog(null);

        if (resultado == JFileChooser.APPROVE_OPTION) {
            try {
                rutaArchivoSeleccionado = seleccionar.getSelectedFile().toString();
                System.out.println("Archivo seleccionado: " + rutaArchivoSeleccionado);

                // Aquí puedes agregar el código para manejar el archivo de imagen seleccionado
                // Por ejemplo, podrías cargar la imagen en un JLabel
                ImageIcon imagen = new ImageIcon(rutaArchivoSeleccionado);
//                setImageToLabel(lblAccesorios, rutaAplicacion);
                lblFoto.setIcon(imagen);

                // Suponiendo que tienes un panel para agregar esta etiqueta
                panelCuerpo.revalidate();   // Actualiza el contenedor para mostrar la nueva imagen
                panelCuerpo.repaint();

            } catch (Exception ex) {
                Logger.getLogger(FrmPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }//GEN-LAST:event_lblFotoMouseClicked

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
            java.util.logging.Logger.getLogger(FrmEditarConsumibles.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmEditarConsumibles.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmEditarConsumibles.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmEditarConsumibles.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmEditarConsumibles(new Consumible()).setVisible(true);
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
    private javax.swing.JButton btnAñadir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblCantidad;
    private javax.swing.JLabel lblEncabezado;
    private javax.swing.JLabel lblFoto;
    private javax.swing.JLabel lblFoto1;
    private javax.swing.JLabel lblGabinete;
    private javax.swing.JLabel lblInicio;
    private javax.swing.JLabel lblMarca;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblObservaciones;
    private javax.swing.JLabel lblReferencia;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JPanel panelCuerpo;
    private javax.swing.JPanel panelInicio;
    private javax.swing.JPanel panelUsuario;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtGabinete;
    private javax.swing.JTextField txtMarca;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtObservaciones;
    private javax.swing.JTextField txtReferencia;
    // End of variables declaration//GEN-END:variables
}
