package com.usta.formularios;

import com.usta.daos.DaoElemento;
import com.usta.entities.Elemento;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import org.kordamp.ikonli.materialdesign2.MaterialDesignA;
import org.kordamp.ikonli.materialdesign2.MaterialDesignH;
import org.kordamp.ikonli.swing.FontIcon;

public class FrmActualizarRecursos extends javax.swing.JFrame {

    FontIcon iconoUsuario = new FontIcon();
    FontIcon iconoInicio = new FontIcon();

    Integer seleccionarBuscar = 0;
    private Integer codRecurso = null;

    private String titulos[] = {"Itém", "Nombre", "Código Inventario", "Referencia", "Cantidad", "Eliminar", "Editar"};
    private DefaultTableModel miModeloTabla = new DefaultTableModel(titulos, 0) {

        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }

        @Override
        public Class<?> getColumnClass(int columnIndex) {
            if (columnIndex == 5) {
                return ImageIcon.class;
            }
            if (columnIndex == 6) {
                return ImageIcon.class;
            }
            return Object.class;
        }

    };

    public FrmActualizarRecursos() {
        initComponents();

        setImageToLabel(lblEncabezado, "..\\proyectoFinalTerminado\\Imagenes\\Encabezado.png");
        tblDatos.setModel(miModeloTabla);
        cargarRecursos("");

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

        String nombreElim = "/com/usta/iconos/borrar.png";
        String rutaIconoElim = this.getClass().getResource(nombreElim).getPath();
        ImageIcon borrarIcono = new ImageIcon(rutaIconoElim);

        String nombreEdit = "/com/usta/iconos/editar.png";
        String rutaIconoEdit = this.getClass().getResource(nombreEdit).getPath();
        ImageIcon editIcono = new ImageIcon(rutaIconoEdit);

        miModeloTabla.setNumRows(0);

        arrElemento = miDao.consultar(ordencito);

        for (Elemento elemento : arrElemento) {
            Object filita[] = new Object[7];

            filita[0] = elemento.getCodElemento();
            filita[1] = elemento.getNombreElemento();
            filita[2] = elemento.getCodElemento();
            filita[3] = elemento.getReferenciaElemento();
            filita[4] = elemento.getCantidadElemento();
            filita[5] = borrarIcono;
            filita[6] = editIcono;

            miModeloTabla.addRow(filita);
        }

        DefaultTableCellRenderer centrado = new DefaultTableCellRenderer();
        centrado.setHorizontalAlignment(JLabel.CENTER);
    }

    private boolean siElimino(Integer codigoRecursos) {
        int opcion;
        Boolean bandera = false;
        String textoBotones[] = {"Aceptar", "Cancelar"};

        DaoElemento miDao = new DaoElemento();
        Elemento objElemento = miDao.buscar(codigoRecursos);

        opcion = JOptionPane.showOptionDialog(panelCuerpo, "¿Esta seguro de eliminar el elemento: " + objElemento.getNombreElemento()
                + "?", "Aviso", JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE, null, textoBotones, textoBotones[1]);

        if (opcion == JOptionPane.YES_OPTION) {

            bandera = true;

        }

        return bandera;
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
            Object filita[] = new Object[7];

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

        panelCuerpo = new javax.swing.JPanel();
        cmbFiltro = new javax.swing.JComboBox<>();
        lblEncabezado = new javax.swing.JLabel();
        lblTitulo = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDatos = new javax.swing.JTable();
        panelUsuario = new javax.swing.JPanel();
        lblUsuario = new javax.swing.JLabel();
        panelInicio = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lblInicio = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        panelCuerpo.setBackground(new java.awt.Color(255, 255, 255));

        cmbFiltro.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        cmbFiltro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione algún tipo", "Nombre", "Código de Inventario" }));

        lblTitulo.setFont(new java.awt.Font("Quando", 0, 40)); // NOI18N
        lblTitulo.setText("RECURSOS");

        txtBuscar.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarKeyReleased(evt);
            }
        });

        jScrollPane1.setBackground(new java.awt.Color(222, 243, 251));

        tblDatos.setBackground(new java.awt.Color(222, 243, 251));
        tblDatos.setFont(new java.awt.Font("Quando", 0, 16)); // NOI18N
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
        jScrollPane1.setViewportView(tblDatos);

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
            .addComponent(lblEncabezado, javax.swing.GroupLayout.PREFERRED_SIZE, 1336, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(panelCuerpoLayout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(lblTitulo)
                .addGap(449, 449, 449)
                .addComponent(panelInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(panelCuerpoLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(panelCuerpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 986, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelCuerpoLayout.createSequentialGroup()
                        .addComponent(cmbFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtBuscar))))
        );
        panelCuerpoLayout.setVerticalGroup(
            panelCuerpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCuerpoLayout.createSequentialGroup()
                .addComponent(lblEncabezado, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelCuerpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTitulo)
                    .addComponent(panelUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(panelCuerpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                    .addComponent(cmbFiltro))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 411, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 6, Short.MAX_VALUE)
                .addComponent(panelCuerpo, javax.swing.GroupLayout.PREFERRED_SIZE, 1023, javax.swing.GroupLayout.PREFERRED_SIZE))
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

        if (columnaEliminar == 5) {
            int filaSeleccionada = tblDatos.getSelectedRow();

            String codTexto = miModeloTabla.getValueAt(filaSeleccionada, 0).toString();

            codRecurso = Integer.valueOf(codTexto);
            DaoElemento miDao = new DaoElemento();
            Elemento objElemento = miDao.buscar(codRecurso);

            if (objElemento == null) {
                JOptionPane.showMessageDialog(panelCuerpo, "No se encontró el elemento", "Advertencia", JOptionPane.WARNING_MESSAGE);
            } else {

                if (siElimino(codRecurso)) {
                    DaoElemento daoElim = new DaoElemento();
                    if (daoElim.eliminar(codRecurso)) {
                        cargarRecursos("");
                        JOptionPane.showMessageDialog(panelCuerpo, "Eliminación Exitosa", "Información", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(panelCuerpo, "No se pudo eliminar el elemento", "Información", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }

        }

        if (columnaEliminar == 6) {

            int filaSeleccionada = tblDatos.getSelectedRow();
            String codigoTexto = miModeloTabla.getValueAt(filaSeleccionada, 0).toString();
            codRecurso = Integer.valueOf(codigoTexto);

            DaoElemento miDao = new DaoElemento();
            Elemento objElemento = miDao.buscar(codRecurso);

            FrmEditarRecursos ventanaFlotante = new FrmEditarRecursos(objElemento);
            ventanaFlotante.setVisible(true);

            ventanaFlotante.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
                    cargarRecursos("");
                }

            });
        }
    }//GEN-LAST:event_tblDatosMouseClicked

    private void txtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyReleased
        seleccionarBuscar = cmbFiltro.getSelectedIndex();
        String campoSelect = campoBuscar(seleccionarBuscar);
        System.out.println("campo: " + campoSelect);

        buscarDato("%" + txtBuscar.getText().toUpperCase() + "%", campoSelect);
    }//GEN-LAST:event_txtBuscarKeyReleased

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
            java.util.logging.Logger.getLogger(FrmActualizarRecursos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmActualizarRecursos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmActualizarRecursos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmActualizarRecursos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmActualizarRecursos().setVisible(true);
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
