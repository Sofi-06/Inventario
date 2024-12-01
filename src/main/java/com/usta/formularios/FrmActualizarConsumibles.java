package com.usta.formularios;

import com.usta.daos.DaoConsumible;
import com.usta.entities.Consumible;
import java.awt.Color;
import java.awt.Component;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import org.kordamp.ikonli.materialdesign2.MaterialDesignA;
import org.kordamp.ikonli.materialdesign2.MaterialDesignH;
import org.kordamp.ikonli.swing.FontIcon;

public class FrmActualizarConsumibles extends javax.swing.JFrame {

    FontIcon iconoUsuario = new FontIcon();
    FontIcon iconoInicio = new FontIcon();

    Integer seleccionarBuscar = 0;
    private Integer codigoConsumible = null;
    private String titulos[] = {"Código", "Nombre", "Marca", "Observaciones", "Foto", "Referencia", "Cantidad", "Gabinete", "Elim", "Editar"};
    private DefaultTableModel miModelitoTabla = new DefaultTableModel(titulos, 0) {

        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }

        @Override
        public Class<?> getColumnClass(int columnIndex) {

            if (columnIndex == 8) {
                return ImageIcon.class;
            }
            if (columnIndex == 9) {
                return ImageIcon.class;

            }
            return Object.class;
        }

    };

    public FrmActualizarConsumibles() {
        initComponents();

        setImageToLabel(lblEncabezado, "..\\proyectoFinalTerminado\\Imagenes\\Encabezado.png");
        tblDatos.setModel(miModelitoTabla);
        cargarConsumible("");

        iconoUsuario.setIkon(MaterialDesignA.ACCOUNT_CIRCLE_OUTLINE);
        iconoUsuario.setIconSize(40);
        iconoUsuario.setIconColor(Color.decode("#000000"));
        this.lblUsuario.setIcon(iconoUsuario);

        iconoInicio.setIkon(MaterialDesignH.HOME);
        iconoInicio.setIconSize(40);
        iconoInicio.setIconColor(Color.decode("#000000"));
        this.lblInicio.setIcon(iconoInicio);
    }

    private void cargarConsumible(String ordencito) {
        List<Consumible> arrConsumible;
        DaoConsumible miDao = new DaoConsumible();

         String nombreElim = "/com/usta/iconos/borrar.png";
        String rutaIconoElim = this.getClass().getResource(nombreElim).getPath();
        ImageIcon borrarIcono = new ImageIcon(rutaIconoElim);

        String nombreEdit = "/com/usta/iconos/editar.png";
        String rutaIconoEdit = this.getClass().getResource(nombreEdit).getPath();
        ImageIcon editIcono = new ImageIcon(rutaIconoEdit);

        miModelitoTabla.setNumRows(0);
        arrConsumible = miDao.consultar(ordencito);

        arrConsumible.forEach((Consumible) -> {
            Object filita[] = new Object[10];

            filita[0] = Consumible.getCodConsumible();
            filita[1] = Consumible.getNombreConsumible();
            filita[2] = Consumible.getMarcaConsumible();
            filita[3] = Consumible.getObservacionConsumible();
            filita[4] = cargarImagenDesdeArchivo(Consumible.getFotoConsumible());
            filita[5] = Consumible.getReferenciaConsumible();
            filita[6] = Consumible.getCantidadConsumible();
            filita[7] = Consumible.getNumeroGabineteConsumible();
            filita[8] = borrarIcono;
            filita[9] = editIcono;

            miModelitoTabla.addRow(filita);

        });

//        tblDatos.getColumnModel().getColumn(0).setPreferredWidth(50);
//        tblDatos.getColumnModel().getColumn(1).setPreferredWidth(350);
//        tblDatos.getColumnModel().getColumn(2).setPreferredWidth(100);
//        tblDatos.getColumnModel().getColumn(3).setPreferredWidth(100);
//        tblDatos.getColumnModel().getColumn(4).setPreferredWidth(50);
//        tblDatos.getColumnModel().getColumn(5).setPreferredWidth(50);
//        tblDatos.getColumnModel().getColumn(6).setPreferredWidth(50);
//        tblDatos.getColumnModel().getColumn(7).setPreferredWidth(50);
//        tblDatos.getColumnModel().getColumn(8).setPreferredWidth(50);
//        tblDatos.getColumnModel().getColumn(9).setPreferredWidth(50);
//
//        DefaultTableCellRenderer centrado = new DefaultTableCellRenderer();
//        centrado.setHorizontalAlignment(JLabel.CENTER);
//        tblDatos.getColumnModel().getColumn(0).setCellRenderer(centrado);
//        tblDatos.getColumnModel().getColumn(1).setCellRenderer(centrado);
//        tblDatos.getColumnModel().getColumn(2).setCellRenderer(centrado);
//        tblDatos.getColumnModel().getColumn(3).setCellRenderer(centrado);
//        tblDatos.getColumnModel().getColumn(4).setCellRenderer(centrado);
//        tblDatos.getColumnModel().getColumn(5).setCellRenderer(centrado);
//        tblDatos.getColumnModel().getColumn(6).setCellRenderer(centrado);
//        tblDatos.getColumnModel().getColumn(7).setCellRenderer(centrado);
//        tblDatos.getColumnModel().getColumn(8).setCellRenderer(centrado);
//        tblDatos.getColumnModel().getColumn(9).setCellRenderer(centrado);

        tblDatos.getColumnModel().getColumn(4).setCellRenderer(new FrmActualizarConsumibles.ImageRenderer());

    }

    private ImageIcon cargarImagenDesdeArchivo(String rutaArchivo) {
        File archivo = new File(rutaArchivo);
        if (!archivo.exists()) {
            return null;
        }

        ImageIcon icon = new ImageIcon(rutaArchivo);
        Image img = icon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        return new ImageIcon(img);
    }

    private static class ImageRenderer extends JLabel implements TableCellRenderer {

        public ImageRenderer() {
            setHorizontalAlignment(JLabel.CENTER);
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            if (value instanceof ImageIcon) {
                setIcon((ImageIcon) value);
            } else {
                setIcon(null);
            }
            return this;
        }
    }

    private Boolean siElimino(Integer codigoElim) {
        int opcion;
        Boolean bandera = false;
        String textoBotones[] = {"Aceptar", "Cancelar"};

        DaoConsumible miDao = new DaoConsumible();

        Consumible objConsumible = miDao.buscar(codigoElim);

        opcion = JOptionPane.showOptionDialog(panelCuerpo, "¿Desea eliminar el elemento: " + objConsumible.getNombreConsumible() + "?", "Aviso", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, textoBotones, textoBotones[1]);
        if (opcion == JOptionPane.YES_OPTION) {
            bandera = true;
        }
        return bandera;
    }

    private void buscarDato(String dato, String campo) {
        List<Consumible> arrayProv;
        miModelitoTabla.setNumRows(0);
        DaoConsumible dao = new DaoConsumible();

        String nombreElim = "/com/usta/iconos/borrar.png";
        String rutaIconoElim = this.getClass().getResource(nombreElim).getPath();
        ImageIcon borrarIcono = new ImageIcon(rutaIconoElim);

        String nombreEdit = "/com/usta/iconos/editar.png";
        String rutaIconoEdit = this.getClass().getResource(nombreEdit).getPath();
        ImageIcon editIcono = new ImageIcon(rutaIconoEdit);

        arrayProv = dao.buscarNombre(dato, campo);
        arrayProv.forEach((consumible) -> {

            Object filita[] = new Object[10];

            filita[0] = consumible.getCodConsumible();
            filita[1] = consumible.getNombreConsumible();
            filita[2] = consumible.getMarcaConsumible();
            filita[3] = consumible.getObservacionConsumible();
            filita[4] = cargarImagenDesdeArchivo(consumible.getFotoConsumible());
            filita[5] = consumible.getReferenciaConsumible();
            filita[6] = consumible.getCantidadConsumible();
            filita[7] = consumible.getNumeroGabineteConsumible();
            filita[8] = borrarIcono;
            filita[9] = editIcono;

            miModelitoTabla.addRow(filita);

        });
    }

    private String campoBuscar(int select) {
        System.out.println("indice: " + select);
        String campo = "";
        switch (select) {
            case 0 -> {
                campo = "id_consumibles";
            }
            case 1 -> {
                campo = "nom_elemento";
            }
            case 2 -> {
                campo = "referencia";
            }

            default ->
                throw new AssertionError();
        }
        return campo;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelCuerpo = new javax.swing.JPanel();
        lblEncabezado = new javax.swing.JLabel();
        lblTitulo = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDatos = new javax.swing.JTable();
        cmbFiltro = new javax.swing.JComboBox<>();
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

        txtBuscar.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarKeyReleased(evt);
            }
        });

        tblDatos.setBackground(new java.awt.Color(222, 243, 251));
        tblDatos.setFont(new java.awt.Font("Quando", 0, 15)); // NOI18N
        tblDatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblDatos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDatosMouseClicked(evt);
            }
        });
        tblDatos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tblDatosKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tblDatos);

        cmbFiltro.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        cmbFiltro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione algún tipo", "Nombre", "Referencia" }));

        panelUsuario.setBackground(new java.awt.Color(255, 255, 255));
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
            .addComponent(lblUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, 69, Short.MAX_VALUE)
        );
        panelUsuarioLayout.setVerticalGroup(
            panelUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblUsuario, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 61, Short.MAX_VALUE)
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
                .addGroup(panelCuerpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelCuerpoLayout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(lblTitulo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(panelInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(panelUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44))
                    .addGroup(panelCuerpoLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panelCuerpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(panelCuerpoLayout.createSequentialGroup()
                                .addComponent(cmbFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtBuscar))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1258, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(64, 64, 64))
        );
        panelCuerpoLayout.setVerticalGroup(
            panelCuerpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCuerpoLayout.createSequentialGroup()
                .addComponent(lblEncabezado, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(panelCuerpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelCuerpoLayout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(lblTitulo)
                        .addGap(6, 6, 6))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelCuerpoLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelCuerpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(panelInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(panelUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(panelCuerpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                    .addComponent(cmbFiltro))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 421, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelCuerpo, javax.swing.GroupLayout.PREFERRED_SIZE, 1295, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelCuerpo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tblDatosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDatosMouseClicked
        int columnaEliminar = tblDatos.getSelectedColumn();
        int columnaActualizar = tblDatos.getSelectedColumn();

        int columnaSeleccionar = tblDatos.getSelectedColumn();

        if (columnaSeleccionar == 8) {
            int filaSeleccionada = tblDatos.getSelectedRow();

            String codigoTexto = miModelitoTabla.getValueAt(filaSeleccionada, 0).toString();
            codigoConsumible = Integer.valueOf(codigoTexto);

            DaoConsumible miDao = new DaoConsumible();
            Consumible objConsumible = miDao.buscar(codigoConsumible);

            if (objConsumible == null) {

                JOptionPane.showMessageDialog(panelCuerpo, "No encontró el elemento", "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
            } else {
                if (siElimino(codigoConsumible)) {
                    DaoConsumible miDaoElim = new DaoConsumible();

                    if (miDaoElim.eliminar(codigoConsumible)) {

                        cargarConsumible("");
                        JOptionPane.showMessageDialog(panelCuerpo, "Eliminación Exitosa!!!", "AVISO", JOptionPane.INFORMATION_MESSAGE);

                    } else {
                        JOptionPane.showMessageDialog(panelCuerpo, "Eliminación no Exitosa ", "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
                    }

                }
            }
        }

        if (columnaActualizar == 9) {
            Integer filaSeleccionada = tblDatos.getSelectedRow();

            String codigoTexto = miModelitoTabla.getValueAt(filaSeleccionada, 0).toString();
            codigoConsumible = Integer.valueOf(codigoTexto);

            DaoConsumible miDao = new DaoConsumible();
            Consumible objConsumible = miDao.buscar(codigoConsumible);

            FrmEditarConsumibles ventanaPrincipal = new FrmEditarConsumibles(objConsumible);
            ventanaPrincipal.setVisible(true);
            ventanaPrincipal.setAlwaysOnTop(true);

            ventanaPrincipal.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
                    cargarConsumible("");
                }
            });
        }
    }//GEN-LAST:event_tblDatosMouseClicked

    private void tblDatosKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblDatosKeyReleased
        seleccionarBuscar = cmbFiltro.getSelectedIndex();
        String campoSelect = campoBuscar(seleccionarBuscar);
        System.out.println("campo: " + campoSelect);

        buscarDato("%" + txtBuscar.getText().toUpperCase() + "%", campoSelect);

    }//GEN-LAST:event_tblDatosKeyReleased

    private void panelUsuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelUsuarioMouseClicked
        int opcion;

        String textoBotones[] = {"Salir", "Cancelar"};

        opcion = JOptionPane.showOptionDialog(lblUsuario, "¿ Desea Salir del Sistema ?", "Aviso", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, textoBotones, textoBotones[1]);

        if (opcion == JOptionPane.YES_OPTION) {

            this.dispose();
            FrmPrincipal princi = new FrmPrincipal();
            princi.setVisible(true);
            this.setVisible(false);

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

    private void txtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyReleased
        seleccionarBuscar = cmbFiltro.getSelectedIndex();

        String campoSelect = campoBuscar(seleccionarBuscar);

        buscarDato("%" + txtBuscar.getText().toLowerCase() + "%", campoSelect);
    }//GEN-LAST:event_txtBuscarKeyReleased

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
            java.util.logging.Logger.getLogger(FrmActualizarConsumibles.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmActualizarConsumibles.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmActualizarConsumibles.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmActualizarConsumibles.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmActualizarConsumibles().setVisible(true);
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
    private javax.swing.JComboBox<String> cmbFiltro;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblEncabezado;
    private javax.swing.JLabel lblInicio;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JPanel panelCuerpo;
    private javax.swing.JPanel panelInicio;
    private javax.swing.JPanel panelUsuario;
    private javax.swing.JTable tblDatos;
    private javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables
}
