package com.usta.formularios;

import com.usta.daos.DaoElemento;
import com.usta.entities.Elemento;
import java.awt.Color;
import java.awt.Image;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import org.kordamp.ikonli.materialdesign2.MaterialDesignA;
import org.kordamp.ikonli.materialdesign2.MaterialDesignH;
import org.kordamp.ikonli.swing.FontIcon;

public class FrmVisualizarRecursosLab extends javax.swing.JFrame {

    FontIcon iconoUsuario = new FontIcon();
    FontIcon iconoInicio = new FontIcon();

    Integer seleccionarBuscar = 0;
    private String titulos[] = {"Código", "Nombre", "Código Inventario", "Referencia", "Cantidad"};
    private DefaultTableModel miModeloTabla = new DefaultTableModel(titulos, 0) {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }

    };

    public FrmVisualizarRecursosLab() {
        initComponents();
        tblDatos.setModel(miModeloTabla);
        cargarRecursos("");

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

    private void cargarRecursos(String ordencito) {
        List<Elemento> arrElemento;
        DaoElemento miDao = new DaoElemento();

        String nomElim = "/com/usta/iconos/borrar.png";
        String nomEdit = "/com/usta/iconos/editar.png";

        InputStream inputStreamElim = getClass().getResourceAsStream(nomElim);
        InputStream inputStreamEdit = getClass().getResourceAsStream(nomEdit);

        ImageIcon borrarIcono = null;
        ImageIcon editarIcono = null;

        if (inputStreamElim != null && inputStreamEdit != null) {
            try {
                borrarIcono = new ImageIcon(ImageIO.read(inputStreamElim));
                editarIcono = new ImageIcon(ImageIO.read(inputStreamEdit));
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("One or both of the resource files were not found.");
        }

        miModeloTabla.setNumRows(0);

        arrElemento = miDao.consultar(ordencito);

        for (Elemento elemento : arrElemento) {
            Object filita[] = new Object[7]; // Increase array size to accommodate icons

            filita[0] = elemento.getCodElemento();
            filita[1] = elemento.getNombreElemento();
            filita[2] = elemento.getCodElemento();
            filita[3] = elemento.getReferenciaElemento();
            filita[4] = elemento.getCantidadElemento();

            if (borrarIcono != null && editarIcono != null) {
                filita[5] = borrarIcono;
                filita[6] = editarIcono;
            } else {
                // Handle the case where icons are not loaded
                filita[5] = null;
                filita[6] = null;
            }

            miModeloTabla.addRow(filita);
        }

        DefaultTableCellRenderer centrado = new DefaultTableCellRenderer();
        centrado.setHorizontalAlignment(JLabel.CENTER);
    }

    private void buscarDato(String dato, String campo) {
        List<Elemento> arrElemento;
        DaoElemento dao = new DaoElemento();

        String nombreElim = "/com/usta/iconos/borrar.png";
        String rutaIconoElim = this.getClass().getResource(nombreElim).getPath();
        ImageIcon borrarIcono = new ImageIcon(rutaIconoElim);

        String nombreEdit = "/com/usta/iconos/editar.png";
        String rutaIconoEdit = this.getClass().getResource(nombreEdit).getPath();
        ImageIcon editIcono = new ImageIcon(rutaIconoEdit);

        arrElemento = dao.buscarNombre(dato, campo);
        arrElemento.forEach((elemento) -> {
            Object filita[] = new Object[11];

            filita[0] = elemento.getCodElemento();
            filita[1] = elemento.getNombreElemento();
            filita[2] = elemento.getCodElemento();
            filita[3] = elemento.getReferenciaElemento();
            filita[4] = elemento.getCantidadElemento();
            filita[5] = borrarIcono;
            filita[6] = editIcono;

            miModeloTabla.addRow(filita);

        });
    }

    private String campoBuscar(int select) {
        System.out.println("indice: " + select);
        String campo = "";
        switch (select) {
            case 0 -> {
                campo = "id_elemento";
            }
            case 1 -> {
                campo = "nom_elemento";
            }
            case 2 -> {
                campo = "inventario";
            }

            default ->
                throw new AssertionError();
        }
        return campo;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
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

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        lblTitulo.setFont(new java.awt.Font("Quando", 0, 40)); // NOI18N
        lblTitulo.setText("RECURSOS");

        jScrollPane1.setBackground(new java.awt.Color(222, 243, 251));

        tblDatos.setBackground(new java.awt.Color(222, 243, 251));
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
        tblDatos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tblDatosKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tblDatos);

        cmbFiltro.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        cmbFiltro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione algún tipo", "Nombre", "Código de Inventario" }));

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
            .addComponent(lblUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE)
        );
        panelUsuarioLayout.setVerticalGroup(
            panelUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, 63, Short.MAX_VALUE)
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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(cmbFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtBuscar))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1304, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(30, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(lblTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(panelInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(panelUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(lblEncabezado, javax.swing.GroupLayout.DEFAULT_SIZE, 1348, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(lblTitulo))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(panelUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(panelInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                    .addComponent(cmbFiltro))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 405, Short.MAX_VALUE)
                .addGap(16, 16, 16))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addComponent(lblEncabezado, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 555, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(FrmVisualizarRecursosLab.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmVisualizarRecursosLab.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmVisualizarRecursosLab.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmVisualizarRecursosLab.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmVisualizarRecursosLab().setVisible(true);
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblEncabezado;
    private javax.swing.JLabel lblInicio;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JPanel panelInicio;
    private javax.swing.JPanel panelUsuario;
    private javax.swing.JTable tblDatos;
    private javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables
}
