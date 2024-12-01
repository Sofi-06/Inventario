package com.usta.formularios;

import java.awt.Color;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import org.kordamp.ikonli.materialdesign2.MaterialDesignA;
import org.kordamp.ikonli.swing.FontIcon;

public class FrmLocalizacionDirector extends javax.swing.JFrame {

    FontIcon iconoUsuario = new FontIcon();

    public FrmLocalizacionDirector() {
        initComponents();

        setImageToLabel(lblEncabezado, "..\\proyectoFinalTerminado\\Imagenes\\Encabezado.png");
        setImageToLabel(lblHome, "..\\proyectoFinalTerminado\\Imagenes\\BarraHome.png");
        setImageToLabel(lblInicio, "..\\proyectoFinalTerminado\\Imagenes\\Inicio.png");
        setImageToLabel(lblMapa, "..\\proyectoFinalTerminado\\Imagenes\\Edificio_Santo_Domingo_piso_2.png");

        iconoUsuario.setIkon(MaterialDesignA.ACCOUNT_CIRCLE_OUTLINE);
        iconoUsuario.setIconSize(40);
        iconoUsuario.setIconColor(Color.decode("#000000"));
        this.lblUsuario.setIcon(iconoUsuario);
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
        lblIngresar = new javax.swing.JLabel();
        lblLocalizacion = new javax.swing.JLabel();
        lblInicio = new javax.swing.JLabel();
        lblHome = new javax.swing.JLabel();
        lblEncabezado = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblMapa = new javax.swing.JLabel();
        lblNom = new javax.swing.JLabel();
        lblNom2 = new javax.swing.JLabel();
        lblNom3 = new javax.swing.JLabel();
        panelUsuario = new javax.swing.JPanel();
        lblUsuario = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblIngresar.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        lblIngresar.setText("       INICIO");
        lblIngresar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblIngresar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblIngresarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblIngresarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblIngresarMouseExited(evt);
            }
        });
        jPanel1.add(lblIngresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 190, 320, 40));

        lblLocalizacion.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        lblLocalizacion.setText("       LOCALIZACION");
        lblLocalizacion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblLocalizacion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblLocalizacionMouseEntered(evt);
            }
        });
        jPanel1.add(lblLocalizacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 260, 320, 30));

        lblInicio.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        lblInicio.setText("           ");
        jPanel1.add(lblInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 190, 320, 40));
        jPanel1.add(lblHome, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 317, 617));
        jPanel1.add(lblEncabezado, new org.netbeans.lib.awtextra.AbsoluteConstraints(323, 0, 1010, 45));

        jLabel4.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        jLabel4.setText("DIRECTOR");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1130, 70, -1, -1));
        jPanel1.add(lblMapa, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 60, 540, 560));

        lblNom.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        lblNom.setText("SEGUNDO PISO");
        jPanel1.add(lblNom, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 250, -1, -1));

        lblNom2.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        lblNom2.setText("EDIFICIO SANTO");
        jPanel1.add(lblNom2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 280, -1, -1));

        lblNom3.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        lblNom3.setText("DOMINGO");
        jPanel1.add(lblNom3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1100, 310, -1, -1));

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
            .addComponent(lblUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
        );
        panelUsuarioLayout.setVerticalGroup(
            panelUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblUsuario, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        jPanel1.add(panelUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(1250, 50, 60, 50));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void lblIngresarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblIngresarMouseClicked
        FrmHomeDirector homeDirector = new FrmHomeDirector();
        homeDirector.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_lblIngresarMouseClicked

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

    private void lblIngresarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblIngresarMouseEntered
        lblIngresar.setForeground(Color.decode("#3CA6A6"));
    }//GEN-LAST:event_lblIngresarMouseEntered

    private void lblIngresarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblIngresarMouseExited
        lblIngresar.setForeground(Color.BLACK);
    }//GEN-LAST:event_lblIngresarMouseExited

    private void lblLocalizacionMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblLocalizacionMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_lblLocalizacionMouseEntered

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
            java.util.logging.Logger.getLogger(FrmLocalizacionDirector.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmLocalizacionDirector.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmLocalizacionDirector.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmLocalizacionDirector.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmLocalizacionDirector().setVisible(true);
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
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblEncabezado;
    private javax.swing.JLabel lblHome;
    private javax.swing.JLabel lblIngresar;
    private javax.swing.JLabel lblInicio;
    private javax.swing.JLabel lblLocalizacion;
    private javax.swing.JLabel lblMapa;
    private javax.swing.JLabel lblNom;
    private javax.swing.JLabel lblNom2;
    private javax.swing.JLabel lblNom3;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JPanel panelUsuario;
    // End of variables declaration//GEN-END:variables
}
