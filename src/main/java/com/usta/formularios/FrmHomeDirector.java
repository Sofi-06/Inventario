package com.usta.formularios;

import java.awt.Color;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import org.kordamp.ikonli.materialdesign2.MaterialDesignA;
import org.kordamp.ikonli.materialdesign2.MaterialDesignE;
import org.kordamp.ikonli.swing.FontIcon;

public class FrmHomeDirector extends javax.swing.JFrame {

    FontIcon iconoVisuzalizar = new FontIcon();
    FontIcon iconoUsuario = new FontIcon();

    public FrmHomeDirector() {
        initComponents();

        iconoVisuzalizar.setIkon(MaterialDesignE.EYE_OUTLINE);
        iconoVisuzalizar.setIconSize(40);
        iconoVisuzalizar.setIconColor(Color.decode("#000000"));
        this.lblVisualizar1.setIcon(iconoVisuzalizar);

        iconoVisuzalizar.setIkon(MaterialDesignE.EYE_OUTLINE);
        iconoVisuzalizar.setIconSize(40);
        iconoVisuzalizar.setIconColor(Color.decode("#000000"));
        this.lblVisualizar5.setIcon(iconoVisuzalizar);

        iconoVisuzalizar.setIkon(MaterialDesignE.EYE_OUTLINE);
        iconoVisuzalizar.setIconSize(40);
        iconoVisuzalizar.setIconColor(Color.decode("#000000"));
        this.lblVisualizar6.setIcon(iconoVisuzalizar);

        iconoVisuzalizar.setIkon(MaterialDesignE.EYE_OUTLINE);
        iconoVisuzalizar.setIconSize(40);
        iconoVisuzalizar.setIconColor(Color.decode("#000000"));
        this.lblVisualizar7.setIcon(iconoVisuzalizar);

        iconoUsuario.setIkon(MaterialDesignA.ACCOUNT_CIRCLE_OUTLINE);
        iconoUsuario.setIconSize(40);
        iconoUsuario.setIconColor(Color.decode("#000000"));
        this.lblUsuario1.setIcon(iconoUsuario);

        setImageToLabel(lblEncabezado, "..\\proyectoFinalTerminado\\Imagenes\\Encabezado.png");
        setImageToLabel(lblHome, "..\\proyectoFinalTerminado\\Imagenes\\BarraHome.png");
        setImageToLabel(lblInicio, "..\\proyectoFinalTerminado\\Imagenes\\Inicio.png");
        setImageToLabel(lblEquipos, "..\\proyectoFinalTerminado\\Imagenes\\FotoEquipos.png");
        setImageToLabel(lblExperimentos, "..\\proyectoFinalTerminado\\Imagenes\\FotoExperimentos.png");
        setImageToLabel(lblConsumibles, "..\\proyectoFinalTerminado\\Imagenes\\FotoConsumibles.png");
        setImageToLabel(lblRecursos, "..\\proyectoFinalTerminado\\Imagenes\\FotoRecursos.png");

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
        lblIngresar = new javax.swing.JLabel();
        lblLocalizacion = new javax.swing.JLabel();
        lblInicio = new javax.swing.JLabel();
        lblHome = new javax.swing.JLabel();
        lblEncabezado = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblConsumibles = new javax.swing.JLabel();
        lblEquipos = new javax.swing.JLabel();
        lblExperimentos = new javax.swing.JLabel();
        lblRecursos = new javax.swing.JLabel();
        lblNomRecursos = new javax.swing.JLabel();
        lblNomEquipos = new javax.swing.JLabel();
        lblNomExperimentos = new javax.swing.JLabel();
        lblNomConsumibles = new javax.swing.JLabel();
        panelUsuario = new javax.swing.JPanel();
        lblUsuario1 = new javax.swing.JLabel();
        panelVisualizar = new javax.swing.JPanel();
        lblVisualizar1 = new javax.swing.JLabel();
        panelVisualizar1 = new javax.swing.JPanel();
        lblVisualizar5 = new javax.swing.JLabel();
        panelVisualizar2 = new javax.swing.JPanel();
        lblVisualizar6 = new javax.swing.JLabel();
        panelVisualizar3 = new javax.swing.JPanel();
        lblVisualizar7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(51, 153, 255));
        setResizable(false);

        panelCuerpo.setBackground(new java.awt.Color(255, 255, 255));
        panelCuerpo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        panelCuerpo.add(lblIngresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 190, 320, 40));

        lblLocalizacion.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        lblLocalizacion.setText("       LOCALIZACION");
        lblLocalizacion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblLocalizacion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblLocalizacionMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblLocalizacionMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblLocalizacionMouseExited(evt);
            }
        });
        panelCuerpo.add(lblLocalizacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 260, 320, 30));

        lblInicio.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        lblInicio.setText("           ");
        panelCuerpo.add(lblInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 190, 320, 40));
        panelCuerpo.add(lblHome, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 317, 617));
        panelCuerpo.add(lblEncabezado, new org.netbeans.lib.awtextra.AbsoluteConstraints(323, 0, 1010, 45));

        jLabel4.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        jLabel4.setText("DIRECTOR");
        panelCuerpo.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1120, 70, -1, -1));

        lblConsumibles.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        panelCuerpo.add(lblConsumibles, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 390, 310, 150));

        lblEquipos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        panelCuerpo.add(lblEquipos, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 140, 310, 150));

        lblExperimentos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        panelCuerpo.add(lblExperimentos, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 140, 310, 150));

        lblRecursos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        panelCuerpo.add(lblRecursos, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 400, 310, 150));

        lblNomRecursos.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        lblNomRecursos.setText("RECURSOS");
        panelCuerpo.add(lblNomRecursos, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 370, -1, -1));

        lblNomEquipos.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        lblNomEquipos.setText("EQUIPOS");
        panelCuerpo.add(lblNomEquipos, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 110, -1, -1));

        lblNomExperimentos.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        lblNomExperimentos.setText("EXPERIMENTOS");
        panelCuerpo.add(lblNomExperimentos, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 110, -1, -1));

        lblNomConsumibles.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        lblNomConsumibles.setText("CONSUMIBLES");
        panelCuerpo.add(lblNomConsumibles, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 360, -1, -1));

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

        lblUsuario1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout panelUsuarioLayout = new javax.swing.GroupLayout(panelUsuario);
        panelUsuario.setLayout(panelUsuarioLayout);
        panelUsuarioLayout.setHorizontalGroup(
            panelUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblUsuario1, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
        );
        panelUsuarioLayout.setVerticalGroup(
            panelUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblUsuario1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        panelCuerpo.add(panelUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(1250, 60, -1, -1));

        panelVisualizar.setBackground(new java.awt.Color(255, 255, 255));
        panelVisualizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelVisualizarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                panelVisualizarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                panelVisualizarMouseExited(evt);
            }
        });

        lblVisualizar1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout panelVisualizarLayout = new javax.swing.GroupLayout(panelVisualizar);
        panelVisualizar.setLayout(panelVisualizarLayout);
        panelVisualizarLayout.setHorizontalGroup(
            panelVisualizarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblVisualizar1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
        );
        panelVisualizarLayout.setVerticalGroup(
            panelVisualizarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblVisualizar1, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        panelCuerpo.add(panelVisualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 300, 80, 50));

        panelVisualizar1.setBackground(new java.awt.Color(255, 255, 255));
        panelVisualizar1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelVisualizar1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                panelVisualizar1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                panelVisualizar1MouseExited(evt);
            }
        });

        lblVisualizar5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout panelVisualizar1Layout = new javax.swing.GroupLayout(panelVisualizar1);
        panelVisualizar1.setLayout(panelVisualizar1Layout);
        panelVisualizar1Layout.setHorizontalGroup(
            panelVisualizar1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblVisualizar5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
        );
        panelVisualizar1Layout.setVerticalGroup(
            panelVisualizar1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblVisualizar5, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        panelCuerpo.add(panelVisualizar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 300, 80, 50));

        panelVisualizar2.setBackground(new java.awt.Color(255, 255, 255));
        panelVisualizar2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelVisualizar2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                panelVisualizar2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                panelVisualizar2MouseExited(evt);
            }
        });

        lblVisualizar6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout panelVisualizar2Layout = new javax.swing.GroupLayout(panelVisualizar2);
        panelVisualizar2.setLayout(panelVisualizar2Layout);
        panelVisualizar2Layout.setHorizontalGroup(
            panelVisualizar2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblVisualizar6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
        );
        panelVisualizar2Layout.setVerticalGroup(
            panelVisualizar2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblVisualizar6, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        panelCuerpo.add(panelVisualizar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 550, 80, 50));

        panelVisualizar3.setBackground(new java.awt.Color(255, 255, 255));
        panelVisualizar3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelVisualizar3MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                panelVisualizar3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                panelVisualizar3MouseExited(evt);
            }
        });

        lblVisualizar7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout panelVisualizar3Layout = new javax.swing.GroupLayout(panelVisualizar3);
        panelVisualizar3.setLayout(panelVisualizar3Layout);
        panelVisualizar3Layout.setHorizontalGroup(
            panelVisualizar3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblVisualizar7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
        );
        panelVisualizar3Layout.setVerticalGroup(
            panelVisualizar3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblVisualizar7, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        panelCuerpo.add(panelVisualizar3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 560, 80, 50));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelCuerpo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelCuerpo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void lblLocalizacionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblLocalizacionMouseClicked
        FrmLocalizacionDirector localDirec = new FrmLocalizacionDirector();
        localDirec.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_lblLocalizacionMouseClicked

    private void panelUsuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelUsuarioMouseClicked
        int opcion;

        String textoBotones[] = {"Salir", "Cancelar"};

        opcion = JOptionPane.showOptionDialog(lblUsuario1, "¿ Desea Salir del Sistema ?", "Aviso", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, textoBotones, textoBotones[1]);

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

    private void panelVisualizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelVisualizarMouseClicked
        FrmVisualizarEquiposDir visuzalizarEquipos = new FrmVisualizarEquiposDir();
        visuzalizarEquipos.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_panelVisualizarMouseClicked

    private void panelVisualizarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelVisualizarMouseEntered
        panelVisualizar.setBackground(Color.decode("#00CCC0"));
        iconoVisuzalizar.setIconColor(Color.decode("#ffffff"));
    }//GEN-LAST:event_panelVisualizarMouseEntered

    private void panelVisualizarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelVisualizarMouseExited
        panelVisualizar.setBackground(Color.decode("#ffffff"));
        iconoVisuzalizar.setIconColor(Color.decode("#000000"));
    }//GEN-LAST:event_panelVisualizarMouseExited

    private void panelVisualizar1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelVisualizar1MouseClicked
        FrmVisualizarExperimentosDir visualizarExp = new FrmVisualizarExperimentosDir();
        visualizarExp.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_panelVisualizar1MouseClicked

    private void panelVisualizar1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelVisualizar1MouseEntered
        panelVisualizar1.setBackground(Color.decode("#00CCC0"));
        iconoVisuzalizar.setIconColor(Color.decode("#ffffff"));
    }//GEN-LAST:event_panelVisualizar1MouseEntered

    private void panelVisualizar1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelVisualizar1MouseExited
        panelVisualizar1.setBackground(Color.decode("#ffffff"));
        iconoVisuzalizar.setIconColor(Color.decode("#000000"));
    }//GEN-LAST:event_panelVisualizar1MouseExited

    private void panelVisualizar2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelVisualizar2MouseClicked
        FrmVisualizarConsumiblesDir visualizarConsumibles = new FrmVisualizarConsumiblesDir();
        visualizarConsumibles.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_panelVisualizar2MouseClicked

    private void panelVisualizar2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelVisualizar2MouseEntered
        panelVisualizar2.setBackground(Color.decode("#00CCC0"));
        iconoVisuzalizar.setIconColor(Color.decode("#ffffff"));
    }//GEN-LAST:event_panelVisualizar2MouseEntered

    private void panelVisualizar2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelVisualizar2MouseExited
        panelVisualizar2.setBackground(Color.decode("#ffffff"));
        iconoVisuzalizar.setIconColor(Color.decode("#000000"));
    }//GEN-LAST:event_panelVisualizar2MouseExited

    private void panelVisualizar3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelVisualizar3MouseClicked
        FrmVisualizarRecursosDir visualizarRecursos = new FrmVisualizarRecursosDir();
        visualizarRecursos.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_panelVisualizar3MouseClicked

    private void panelVisualizar3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelVisualizar3MouseEntered
        panelVisualizar3.setBackground(Color.decode("#00CCC0"));
        iconoVisuzalizar.setIconColor(Color.decode("#ffffff"));
    }//GEN-LAST:event_panelVisualizar3MouseEntered

    private void panelVisualizar3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelVisualizar3MouseExited
        panelVisualizar3.setBackground(Color.decode("#ffffff"));
        iconoVisuzalizar.setIconColor(Color.decode("#000000"));
    }//GEN-LAST:event_panelVisualizar3MouseExited

    private void lblLocalizacionMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblLocalizacionMouseEntered
        lblLocalizacion.setForeground(Color.decode("#3CA6A6"));
    }//GEN-LAST:event_lblLocalizacionMouseEntered

    private void lblLocalizacionMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblLocalizacionMouseExited
        lblLocalizacion.setForeground(Color.BLACK);
    }//GEN-LAST:event_lblLocalizacionMouseExited

    private void lblIngresarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblIngresarMouseEntered
        lblIngresar.setForeground(Color.decode("#3CA6A6"));
    }//GEN-LAST:event_lblIngresarMouseEntered

    private void lblIngresarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblIngresarMouseExited
        lblIngresar.setForeground(Color.BLACK);
    }//GEN-LAST:event_lblIngresarMouseExited

    private void lblIngresarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblIngresarMouseClicked
        FrmHomeDirector inicio = new FrmHomeDirector();
        inicio.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_lblIngresarMouseClicked

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
            java.util.logging.Logger.getLogger(FrmHomeDirector.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmHomeDirector.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmHomeDirector.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmHomeDirector.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmHomeDirector().setVisible(true);
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
    private javax.swing.JLabel lblConsumibles;
    private javax.swing.JLabel lblEncabezado;
    private javax.swing.JLabel lblEquipos;
    private javax.swing.JLabel lblExperimentos;
    private javax.swing.JLabel lblHome;
    private javax.swing.JLabel lblIngresar;
    private javax.swing.JLabel lblInicio;
    private javax.swing.JLabel lblLocalizacion;
    private javax.swing.JLabel lblNomConsumibles;
    private javax.swing.JLabel lblNomEquipos;
    private javax.swing.JLabel lblNomExperimentos;
    private javax.swing.JLabel lblNomRecursos;
    private javax.swing.JLabel lblRecursos;
    private javax.swing.JLabel lblUsuario1;
    private javax.swing.JLabel lblVisualizar1;
    private javax.swing.JLabel lblVisualizar5;
    private javax.swing.JLabel lblVisualizar6;
    private javax.swing.JLabel lblVisualizar7;
    private javax.swing.JPanel panelCuerpo;
    private javax.swing.JPanel panelUsuario;
    private javax.swing.JPanel panelVisualizar;
    private javax.swing.JPanel panelVisualizar1;
    private javax.swing.JPanel panelVisualizar2;
    private javax.swing.JPanel panelVisualizar3;
    // End of variables declaration//GEN-END:variables
}
