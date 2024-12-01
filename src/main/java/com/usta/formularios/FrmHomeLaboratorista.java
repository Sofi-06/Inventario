package com.usta.formularios;

import com.usta.daos.DaoEncabezado;
import com.usta.entities.Encabezado;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import org.kordamp.ikonli.materialdesign2.MaterialDesignA;
import org.kordamp.ikonli.materialdesign2.MaterialDesignE;
import org.kordamp.ikonli.materialdesign2.MaterialDesignP;
import org.kordamp.ikonli.swing.FontIcon;

public class FrmHomeLaboratorista extends javax.swing.JFrame {

    FontIcon iconoRegistrar = new FontIcon();
    FontIcon iconoActualizar = new FontIcon();
    FontIcon iconoVisuzalizar = new FontIcon();
    FontIcon iconoUsuario = new FontIcon();
    private Integer codEncabezado = 2;

    public FrmHomeLaboratorista() {
        initComponents();

        iconoRegistrar.setIkon(MaterialDesignP.PLUS_BOX_OUTLINE);
        iconoRegistrar.setIconSize(40);
        iconoRegistrar.setIconColor(Color.decode("#000000"));
        this.lblRegistrar.setIcon(iconoRegistrar);

        iconoActualizar.setIkon(MaterialDesignA.AUTORENEW);
        iconoActualizar.setIconSize(40);
        iconoActualizar.setIconColor(Color.decode("#000000"));
        this.lblActualizar.setIcon(iconoActualizar);

        iconoVisuzalizar.setIkon(MaterialDesignE.EYE_OUTLINE);
        iconoVisuzalizar.setIconSize(40);
        iconoVisuzalizar.setIconColor(Color.decode("#000000"));
        this.lblVisualizar.setIcon(iconoVisuzalizar);

        iconoRegistrar.setIkon(MaterialDesignP.PLUS_BOX_OUTLINE);
        iconoRegistrar.setIconSize(40);
        iconoRegistrar.setIconColor(Color.decode("#000000"));
        this.lblRegistrar4.setIcon(iconoRegistrar);

        iconoActualizar.setIkon(MaterialDesignA.AUTORENEW);
        iconoActualizar.setIconSize(40);
        iconoActualizar.setIconColor(Color.decode("#000000"));
        this.lblActualizar4.setIcon(iconoActualizar);

        iconoVisuzalizar.setIkon(MaterialDesignE.EYE_OUTLINE);
        iconoVisuzalizar.setIconSize(40);
        iconoVisuzalizar.setIconColor(Color.decode("#000000"));
        this.lblVisualizar1.setIcon(iconoVisuzalizar);

        iconoRegistrar.setIkon(MaterialDesignP.PLUS_BOX_OUTLINE);
        iconoRegistrar.setIconSize(40);
        iconoRegistrar.setIconColor(Color.decode("#000000"));
        this.lblRegistrar5.setIcon(iconoRegistrar);

        iconoActualizar.setIkon(MaterialDesignA.AUTORENEW);
        iconoActualizar.setIconSize(40);
        iconoActualizar.setIconColor(Color.decode("#000000"));
        this.lblActualizar5.setIcon(iconoActualizar);

        iconoVisuzalizar.setIkon(MaterialDesignE.EYE_OUTLINE);
        iconoVisuzalizar.setIconSize(40);
        iconoVisuzalizar.setIconColor(Color.decode("#000000"));
        this.lblVisualizar2.setIcon(iconoVisuzalizar);

        iconoRegistrar.setIkon(MaterialDesignP.PLUS_BOX_OUTLINE);
        iconoRegistrar.setIconSize(40);
        iconoRegistrar.setIconColor(Color.decode("#000000"));
        this.lblRegistrar6.setIcon(iconoRegistrar);

        iconoActualizar.setIkon(MaterialDesignA.AUTORENEW);
        iconoActualizar.setIconSize(40);
        iconoActualizar.setIconColor(Color.decode("#000000"));
        this.lblActualizar6.setIcon(iconoActualizar);

        iconoVisuzalizar.setIkon(MaterialDesignE.EYE_OUTLINE);
        iconoVisuzalizar.setIconSize(40);
        iconoVisuzalizar.setIconColor(Color.decode("#000000"));
        this.lblVisualizar4.setIcon(iconoVisuzalizar);

        iconoUsuario.setIkon(MaterialDesignA.ACCOUNT_CIRCLE_OUTLINE);
        iconoUsuario.setIconSize(40);
        iconoUsuario.setIconColor(Color.decode("#000000"));
        this.lblUsuario.setIcon(iconoUsuario);
        
        
        
        setImageToLabel(lblEncabezado, "..\\proyectoFinalTerminado\\Imagenes\\Encabezado.png");
        setImageToLabel(lblHome, "..\\proyectoFinalTerminado\\Imagenes\\BarraHome.png");
        setImageToLabel(lblInicio, "..\\proyectoFinalTerminado\\Imagenes\\Inicio.png");
        setImageToLabel(lblEquipos, "..\\proyectoFinalTerminado\\Imagenes\\FotoEquipos.png");
        setImageToLabel(lblExperimentos, "..\\proyectoFinalTerminado\\Imagenes\\FotoExperimentos.png");
        setImageToLabel(lblConsumibles, "..\\proyectoFinalTerminado\\Imagenes\\FotoConsumibles.png");
        setImageToLabel(lblRecursos, "..\\proyectoFinalTerminado\\Imagenes\\FotoRecursos.png");

        // Crear una instancia del DAO de encabezado
        DaoEncabezado daoEncabezado = new DaoEncabezado();

        // Obtener el encabezado con el ID correspondiente
        Encabezado encabezado = daoEncabezado.buscar(codEncabezado); // Suponiendo que quieres obtener los datos para el ID 2

        // Establecer los datos en los JLabels
        lblLaboratorio.setText(encabezado.getLaboratorioEncabezado());
        lblSemestre.setText(encabezado.getSemestreEncabezado());
        lblFecha.setText(encabezado.getFechaActualizacionEncabezado().toString());
        lblLaboratorista.setText(encabezado.getCodPersona().getNombrePersona());
        lblEdificio.setText(encabezado.getEdificioEncabezado());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        panelUsuario = new javax.swing.JPanel();
        lblUsuario = new javax.swing.JLabel();
        panelActualizar3 = new javax.swing.JPanel();
        lblActualizar6 = new javax.swing.JLabel();
        panelRegistrar3 = new javax.swing.JPanel();
        lblRegistrar6 = new javax.swing.JLabel();
        panelActualizar2 = new javax.swing.JPanel();
        lblActualizar5 = new javax.swing.JLabel();
        panelRegistrar2 = new javax.swing.JPanel();
        lblRegistrar5 = new javax.swing.JLabel();
        panelVisualizar = new javax.swing.JPanel();
        lblVisualizar = new javax.swing.JLabel();
        panelVisualizar1 = new javax.swing.JPanel();
        lblVisualizar1 = new javax.swing.JLabel();
        panelVisualizar2 = new javax.swing.JPanel();
        lblVisualizar2 = new javax.swing.JLabel();
        panelVisualizar3 = new javax.swing.JPanel();
        lblVisualizar4 = new javax.swing.JLabel();
        panelActualizar = new javax.swing.JPanel();
        lblActualizar = new javax.swing.JLabel();
        panelRegistrar = new javax.swing.JPanel();
        lblRegistrar = new javax.swing.JLabel();
        panelActualizar1 = new javax.swing.JPanel();
        lblActualizar4 = new javax.swing.JLabel();
        panelRegistrar1 = new javax.swing.JPanel();
        lblRegistrar4 = new javax.swing.JLabel();
        btnActualizar = new javax.swing.JButton();
        lblLaboratorista = new javax.swing.JLabel();
        lblEdificio = new javax.swing.JLabel();
        lblVersion = new javax.swing.JLabel();
        lblFecha = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblSemestre = new javax.swing.JLabel();
        lblLaboratorio = new javax.swing.JLabel();
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
            .addComponent(lblUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
        );
        panelUsuarioLayout.setVerticalGroup(
            panelUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblUsuario, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        jPanel1.add(panelUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(1250, 50, 60, 50));

        panelActualizar3.setBackground(new java.awt.Color(255, 255, 255));
        panelActualizar3.setToolTipText("Actualizar Recurso");
        panelActualizar3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelActualizar3MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                panelActualizar3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                panelActualizar3MouseExited(evt);
            }
        });

        lblActualizar6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout panelActualizar3Layout = new javax.swing.GroupLayout(panelActualizar3);
        panelActualizar3.setLayout(panelActualizar3Layout);
        panelActualizar3Layout.setHorizontalGroup(
            panelActualizar3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblActualizar6, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
        );
        panelActualizar3Layout.setVerticalGroup(
            panelActualizar3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblActualizar6, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        jPanel1.add(panelActualizar3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 560, 80, 50));

        panelRegistrar3.setBackground(new java.awt.Color(255, 255, 255));
        panelRegistrar3.setToolTipText("Registrar Recurso");
        panelRegistrar3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelRegistrar3MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                panelRegistrar3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                panelRegistrar3MouseExited(evt);
            }
        });

        lblRegistrar6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout panelRegistrar3Layout = new javax.swing.GroupLayout(panelRegistrar3);
        panelRegistrar3.setLayout(panelRegistrar3Layout);
        panelRegistrar3Layout.setHorizontalGroup(
            panelRegistrar3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRegistrar3Layout.createSequentialGroup()
                .addComponent(lblRegistrar6, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        panelRegistrar3Layout.setVerticalGroup(
            panelRegistrar3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblRegistrar6, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        jPanel1.add(panelRegistrar3, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 560, 70, 50));

        panelActualizar2.setBackground(new java.awt.Color(255, 255, 255));
        panelActualizar2.setToolTipText("Actualizar Consumible");
        panelActualizar2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelActualizar2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                panelActualizar2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                panelActualizar2MouseExited(evt);
            }
        });

        lblActualizar5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout panelActualizar2Layout = new javax.swing.GroupLayout(panelActualizar2);
        panelActualizar2.setLayout(panelActualizar2Layout);
        panelActualizar2Layout.setHorizontalGroup(
            panelActualizar2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblActualizar5, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
        );
        panelActualizar2Layout.setVerticalGroup(
            panelActualizar2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblActualizar5, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        jPanel1.add(panelActualizar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 550, 80, 50));

        panelRegistrar2.setBackground(new java.awt.Color(255, 255, 255));
        panelRegistrar2.setToolTipText("Registrar Consumible");
        panelRegistrar2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelRegistrar2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                panelRegistrar2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                panelRegistrar2MouseExited(evt);
            }
        });

        lblRegistrar5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout panelRegistrar2Layout = new javax.swing.GroupLayout(panelRegistrar2);
        panelRegistrar2.setLayout(panelRegistrar2Layout);
        panelRegistrar2Layout.setHorizontalGroup(
            panelRegistrar2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRegistrar2Layout.createSequentialGroup()
                .addComponent(lblRegistrar5, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        panelRegistrar2Layout.setVerticalGroup(
            panelRegistrar2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblRegistrar5, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        jPanel1.add(panelRegistrar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 550, 70, 50));

        panelVisualizar.setBackground(new java.awt.Color(255, 255, 255));
        panelVisualizar.setToolTipText("Visualizar Equipo");
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

        lblVisualizar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout panelVisualizarLayout = new javax.swing.GroupLayout(panelVisualizar);
        panelVisualizar.setLayout(panelVisualizarLayout);
        panelVisualizarLayout.setHorizontalGroup(
            panelVisualizarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblVisualizar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
        );
        panelVisualizarLayout.setVerticalGroup(
            panelVisualizarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblVisualizar, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        jPanel1.add(panelVisualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 300, 80, 50));

        panelVisualizar1.setBackground(new java.awt.Color(255, 255, 255));
        panelVisualizar1.setToolTipText("Visualizar Experimento");
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

        lblVisualizar1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout panelVisualizar1Layout = new javax.swing.GroupLayout(panelVisualizar1);
        panelVisualizar1.setLayout(panelVisualizar1Layout);
        panelVisualizar1Layout.setHorizontalGroup(
            panelVisualizar1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblVisualizar1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
        );
        panelVisualizar1Layout.setVerticalGroup(
            panelVisualizar1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblVisualizar1, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        jPanel1.add(panelVisualizar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, 300, 80, 50));

        panelVisualizar2.setBackground(new java.awt.Color(255, 255, 255));
        panelVisualizar2.setToolTipText("Visualizar Consumible");
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

        lblVisualizar2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout panelVisualizar2Layout = new javax.swing.GroupLayout(panelVisualizar2);
        panelVisualizar2.setLayout(panelVisualizar2Layout);
        panelVisualizar2Layout.setHorizontalGroup(
            panelVisualizar2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblVisualizar2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
        );
        panelVisualizar2Layout.setVerticalGroup(
            panelVisualizar2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblVisualizar2, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        jPanel1.add(panelVisualizar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 550, 80, 50));

        panelVisualizar3.setBackground(new java.awt.Color(255, 255, 255));
        panelVisualizar3.setToolTipText("Visualizar Recurso");
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

        lblVisualizar4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout panelVisualizar3Layout = new javax.swing.GroupLayout(panelVisualizar3);
        panelVisualizar3.setLayout(panelVisualizar3Layout);
        panelVisualizar3Layout.setHorizontalGroup(
            panelVisualizar3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblVisualizar4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
        );
        panelVisualizar3Layout.setVerticalGroup(
            panelVisualizar3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblVisualizar4, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        jPanel1.add(panelVisualizar3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, 560, 80, 50));

        panelActualizar.setBackground(new java.awt.Color(255, 255, 255));
        panelActualizar.setToolTipText("Actualizar Equipo");
        panelActualizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelActualizarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                panelActualizarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                panelActualizarMouseExited(evt);
            }
        });

        lblActualizar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout panelActualizarLayout = new javax.swing.GroupLayout(panelActualizar);
        panelActualizar.setLayout(panelActualizarLayout);
        panelActualizarLayout.setHorizontalGroup(
            panelActualizarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblActualizar, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
        );
        panelActualizarLayout.setVerticalGroup(
            panelActualizarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblActualizar, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        jPanel1.add(panelActualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 300, 80, 50));

        panelRegistrar.setBackground(new java.awt.Color(255, 255, 255));
        panelRegistrar.setToolTipText("Registrar Equipo");
        panelRegistrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelRegistrarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                panelRegistrarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                panelRegistrarMouseExited(evt);
            }
        });

        lblRegistrar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout panelRegistrarLayout = new javax.swing.GroupLayout(panelRegistrar);
        panelRegistrar.setLayout(panelRegistrarLayout);
        panelRegistrarLayout.setHorizontalGroup(
            panelRegistrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRegistrarLayout.createSequentialGroup()
                .addComponent(lblRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        panelRegistrarLayout.setVerticalGroup(
            panelRegistrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblRegistrar, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        jPanel1.add(panelRegistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 300, 70, 50));

        panelActualizar1.setBackground(new java.awt.Color(255, 255, 255));
        panelActualizar1.setToolTipText("Actualizar Experimento");
        panelActualizar1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelActualizar1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                panelActualizar1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                panelActualizar1MouseExited(evt);
            }
        });

        lblActualizar4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout panelActualizar1Layout = new javax.swing.GroupLayout(panelActualizar1);
        panelActualizar1.setLayout(panelActualizar1Layout);
        panelActualizar1Layout.setHorizontalGroup(
            panelActualizar1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblActualizar4, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
        );
        panelActualizar1Layout.setVerticalGroup(
            panelActualizar1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblActualizar4, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        jPanel1.add(panelActualizar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 300, 80, 50));

        panelRegistrar1.setBackground(new java.awt.Color(255, 255, 255));
        panelRegistrar1.setToolTipText("Registrar Experimento");
        panelRegistrar1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelRegistrar1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                panelRegistrar1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                panelRegistrar1MouseExited(evt);
            }
        });

        lblRegistrar4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout panelRegistrar1Layout = new javax.swing.GroupLayout(panelRegistrar1);
        panelRegistrar1.setLayout(panelRegistrar1Layout);
        panelRegistrar1Layout.setHorizontalGroup(
            panelRegistrar1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRegistrar1Layout.createSequentialGroup()
                .addComponent(lblRegistrar4, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        panelRegistrar1Layout.setVerticalGroup(
            panelRegistrar1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblRegistrar4, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        jPanel1.add(panelRegistrar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 300, 70, 50));

        btnActualizar.setText("Actualizar");
        btnActualizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnActualizarMouseClicked(evt);
            }
        });
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });
        jPanel1.add(btnActualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 580, -1, -1));

        lblLaboratorista.setFont(new java.awt.Font("Quando", 0, 12)); // NOI18N
        jPanel1.add(lblLaboratorista, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 460, 60, 20));

        lblEdificio.setFont(new java.awt.Font("Quando", 0, 12)); // NOI18N
        jPanel1.add(lblEdificio, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 470, 110, 30));

        lblVersion.setFont(new java.awt.Font("Quando", 0, 12)); // NOI18N
        lblVersion.setText("Versión 1.0.0 v");
        jPanel1.add(lblVersion, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 560, -1, -1));

        lblFecha.setFont(new java.awt.Font("Quando", 0, 12)); // NOI18N
        jPanel1.add(lblFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 540, -1, -1));

        jLabel8.setFont(new java.awt.Font("Quando", 0, 12)); // NOI18N
        jLabel8.setText("Fecha actualizacion:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 540, -1, -1));

        jLabel1.setFont(new java.awt.Font("Quando", 0, 12)); // NOI18N
        jLabel1.setText("Laboratorista:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 460, -1, -1));

        jLabel2.setFont(new java.awt.Font("Quando", 0, 12)); // NOI18N
        jLabel2.setText("Edificio:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 476, 60, 20));

        lblSemestre.setFont(new java.awt.Font("Quando", 0, 12)); // NOI18N
        jPanel1.add(lblSemestre, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 520, -1, -1));

        lblLaboratorio.setFont(new java.awt.Font("Quando", 0, 12)); // NOI18N
        jPanel1.add(lblLaboratorio, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 500, -1, -1));

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
        jPanel1.add(lblLocalizacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 260, 320, 30));

        lblInicio.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        lblInicio.setText("           ");
        jPanel1.add(lblInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 190, 320, 40));
        jPanel1.add(lblHome, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 320, 617));
        jPanel1.add(lblEncabezado, new org.netbeans.lib.awtextra.AbsoluteConstraints(323, 0, 1010, 45));

        jLabel4.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        jLabel4.setText("LABORATORISTA");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 60, -1, -1));

        lblConsumibles.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(lblConsumibles, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 390, 310, 150));

        lblEquipos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(lblEquipos, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 140, 310, 150));

        lblExperimentos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(lblExperimentos, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 140, 310, 150));

        lblRecursos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(lblRecursos, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 400, 310, 150));

        lblNomRecursos.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        lblNomRecursos.setText("RECURSOS");
        jPanel1.add(lblNomRecursos, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 370, -1, -1));

        lblNomEquipos.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        lblNomEquipos.setText("EQUIPOS");
        jPanel1.add(lblNomEquipos, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 110, -1, -1));

        lblNomExperimentos.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        lblNomExperimentos.setText("EXPERIMENTOS");
        jPanel1.add(lblNomExperimentos, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 110, -1, -1));

        lblNomConsumibles.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        lblNomConsumibles.setText("CONSUMIBLES");
        jPanel1.add(lblNomConsumibles, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 360, -1, -1));

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
        FrmHomeLaboratorista inicio = new FrmHomeLaboratorista();
        inicio.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_lblIngresarMouseClicked

    private void lblLocalizacionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblLocalizacionMouseClicked
        FrmLocalizacionLaboratorista localLab = new FrmLocalizacionLaboratorista();
        localLab.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_lblLocalizacionMouseClicked

    private void panelRegistrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelRegistrarMouseClicked
        FrmRegistrarEquipos registrarEquipos = new FrmRegistrarEquipos();
        registrarEquipos.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_panelRegistrarMouseClicked

    private void panelRegistrarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelRegistrarMouseEntered
        panelRegistrar.setBackground(Color.decode("#00CCC0"));
        iconoRegistrar.setIconColor(Color.decode("#ffffff"));
    }//GEN-LAST:event_panelRegistrarMouseEntered

    private void panelRegistrarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelRegistrarMouseExited
        panelRegistrar.setBackground(Color.decode("#ffffff"));
        iconoRegistrar.setIconColor(Color.decode("#000000"));
    }//GEN-LAST:event_panelRegistrarMouseExited

    private void panelActualizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelActualizarMouseClicked
        FrmActualizarEquipos actualizarEquipos = new FrmActualizarEquipos();
        actualizarEquipos.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_panelActualizarMouseClicked

    private void panelActualizarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelActualizarMouseEntered
        panelActualizar.setBackground(Color.decode("#00CCC0"));
        iconoActualizar.setIconColor(Color.decode("#ffffff"));
    }//GEN-LAST:event_panelActualizarMouseEntered

    private void panelActualizarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelActualizarMouseExited
        panelActualizar.setBackground(Color.decode("#ffffff"));
        iconoActualizar.setIconColor(Color.decode("#000000"));
    }//GEN-LAST:event_panelActualizarMouseExited

    private void panelVisualizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelVisualizarMouseClicked
        FrmVisualizarEquiposLab visuzalizarEquipos = new FrmVisualizarEquiposLab();
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
        FrmVisualizarExperimentosLab visualizarExp = new FrmVisualizarExperimentosLab();
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

    private void panelActualizar1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelActualizar1MouseClicked
        FrmActualizarExperimentos actualizarExp = new FrmActualizarExperimentos();
        actualizarExp.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_panelActualizar1MouseClicked

    private void panelActualizar1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelActualizar1MouseEntered
        panelActualizar1.setBackground(Color.decode("#00CCC0"));
        iconoActualizar.setIconColor(Color.decode("#ffffff"));
    }//GEN-LAST:event_panelActualizar1MouseEntered

    private void panelActualizar1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelActualizar1MouseExited
        panelActualizar1.setBackground(Color.decode("#ffffff"));
        iconoActualizar.setIconColor(Color.decode("#000000"));
    }//GEN-LAST:event_panelActualizar1MouseExited

    private void panelRegistrar1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelRegistrar1MouseClicked
        FrmRegistrarExperimentos registrarExp = new FrmRegistrarExperimentos();
        registrarExp.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_panelRegistrar1MouseClicked

    private void panelRegistrar1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelRegistrar1MouseEntered
        panelRegistrar1.setBackground(Color.decode("#00CCC0"));
        iconoRegistrar.setIconColor(Color.decode("#ffffff"));
    }//GEN-LAST:event_panelRegistrar1MouseEntered

    private void panelRegistrar1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelRegistrar1MouseExited
        panelRegistrar1.setBackground(Color.decode("#ffffff"));
        iconoRegistrar.setIconColor(Color.decode("#000000"));
    }//GEN-LAST:event_panelRegistrar1MouseExited

    private void panelVisualizar2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelVisualizar2MouseClicked
        FrmVisualizarConsumiblesLab visualizarConsumibles = new FrmVisualizarConsumiblesLab();
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

    private void panelActualizar2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelActualizar2MouseClicked
        FrmActualizarConsumibles actualizarConsumibles = new FrmActualizarConsumibles();
        actualizarConsumibles.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_panelActualizar2MouseClicked

    private void panelActualizar2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelActualizar2MouseEntered
        panelActualizar2.setBackground(Color.decode("#00CCC0"));
        iconoActualizar.setIconColor(Color.decode("#ffffff"));
    }//GEN-LAST:event_panelActualizar2MouseEntered

    private void panelActualizar2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelActualizar2MouseExited
        panelActualizar2.setBackground(Color.decode("#ffffff"));
        iconoActualizar.setIconColor(Color.decode("#000000"));
    }//GEN-LAST:event_panelActualizar2MouseExited

    private void panelRegistrar2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelRegistrar2MouseClicked
        FrmRegistrarConsumibles registrarConsumibles = new FrmRegistrarConsumibles();
        registrarConsumibles.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_panelRegistrar2MouseClicked

    private void panelRegistrar2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelRegistrar2MouseEntered
        panelRegistrar2.setBackground(Color.decode("#00CCC0"));
        iconoRegistrar.setIconColor(Color.decode("#ffffff"));
    }//GEN-LAST:event_panelRegistrar2MouseEntered

    private void panelRegistrar2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelRegistrar2MouseExited
        panelRegistrar2.setBackground(Color.decode("#ffffff"));
        iconoRegistrar.setIconColor(Color.decode("#000000"));
    }//GEN-LAST:event_panelRegistrar2MouseExited

    private void panelVisualizar3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelVisualizar3MouseClicked
        FrmVisualizarRecursosLab visualizarRecursos = new FrmVisualizarRecursosLab();
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

    private void panelActualizar3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelActualizar3MouseClicked
        FrmActualizarRecursos actualizarRecursos = new FrmActualizarRecursos();
        actualizarRecursos.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_panelActualizar3MouseClicked

    private void panelActualizar3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelActualizar3MouseEntered
        panelActualizar3.setBackground(Color.decode("#00CCC0"));
        iconoActualizar.setIconColor(Color.decode("#ffffff"));
    }//GEN-LAST:event_panelActualizar3MouseEntered

    private void panelActualizar3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelActualizar3MouseExited
        panelActualizar3.setBackground(Color.decode("#ffffff"));
        iconoActualizar.setIconColor(Color.decode("#000000"));
    }//GEN-LAST:event_panelActualizar3MouseExited

    private void panelRegistrar3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelRegistrar3MouseClicked
        FrmRegistrarRecursos registrarRecursos = new FrmRegistrarRecursos();
        registrarRecursos.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_panelRegistrar3MouseClicked

    private void panelRegistrar3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelRegistrar3MouseEntered
        panelRegistrar3.setBackground(Color.decode("#00CCC0"));
        iconoRegistrar.setIconColor(Color.decode("#ffffff"));
    }//GEN-LAST:event_panelRegistrar3MouseEntered

    private void panelRegistrar3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelRegistrar3MouseExited
        panelRegistrar3.setBackground(Color.decode("#ffffff"));
        iconoRegistrar.setIconColor(Color.decode("#000000"));
    }//GEN-LAST:event_panelRegistrar3MouseExited

    private void lblLocalizacionMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblLocalizacionMouseEntered
        lblLocalizacion.setForeground(Color.decode("#3CA6A6"));
    }//GEN-LAST:event_lblLocalizacionMouseEntered

    private void lblLocalizacionMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblLocalizacionMouseExited
        lblLocalizacion.setForeground(Color.BLACK);
    }//GEN-LAST:event_lblLocalizacionMouseExited

    private void panelUsuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelUsuarioMouseClicked
        int opcion;

        String textoBotones[] = {"Salir", "Cancelar"};

        opcion = JOptionPane.showOptionDialog(lblUsuario, "¿ Desea Salir del Sistema ?", "Aviso", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, textoBotones, textoBotones[1]);

        if (opcion == JOptionPane.YES_OPTION) {
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

    private void btnActualizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnActualizarMouseClicked
       
    }//GEN-LAST:event_btnActualizarMouseClicked

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
         int opcion;

        String textoBotones[] = {"Actualizar", "Cancelar"};

        opcion = JOptionPane.showOptionDialog(lblFecha, "¿ Desea actualizar los datos ?", "Aviso", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, textoBotones, textoBotones[1]);

        if (opcion == JOptionPane.YES_OPTION) {

            DaoEncabezado miDao = new DaoEncabezado();
            Encabezado objEncabezado = miDao.buscar(codEncabezado);
            System.out.println(codEncabezado);

            FrmEncabezado ventanaFlotante = new FrmEncabezado(objEncabezado);
            ventanaFlotante.setVisible(true);

            ventanaFlotante.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {

                }

            });
            this.dispose();

        }
    }//GEN-LAST:event_btnActualizarActionPerformed

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
            java.util.logging.Logger.getLogger(FrmHomeLaboratorista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmHomeLaboratorista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmHomeLaboratorista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmHomeLaboratorista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmHomeLaboratorista().setVisible(true);
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
    private javax.swing.JButton btnActualizar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblActualizar;
    private javax.swing.JLabel lblActualizar4;
    private javax.swing.JLabel lblActualizar5;
    private javax.swing.JLabel lblActualizar6;
    private javax.swing.JLabel lblConsumibles;
    private javax.swing.JLabel lblEdificio;
    private javax.swing.JLabel lblEncabezado;
    private javax.swing.JLabel lblEquipos;
    private javax.swing.JLabel lblExperimentos;
    private javax.swing.JLabel lblFecha;
    private javax.swing.JLabel lblHome;
    private javax.swing.JLabel lblIngresar;
    private javax.swing.JLabel lblInicio;
    private javax.swing.JLabel lblLaboratorio;
    private javax.swing.JLabel lblLaboratorista;
    private javax.swing.JLabel lblLocalizacion;
    private javax.swing.JLabel lblNomConsumibles;
    private javax.swing.JLabel lblNomEquipos;
    private javax.swing.JLabel lblNomExperimentos;
    private javax.swing.JLabel lblNomRecursos;
    private javax.swing.JLabel lblRecursos;
    private javax.swing.JLabel lblRegistrar;
    private javax.swing.JLabel lblRegistrar4;
    private javax.swing.JLabel lblRegistrar5;
    private javax.swing.JLabel lblRegistrar6;
    private javax.swing.JLabel lblSemestre;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JLabel lblVersion;
    private javax.swing.JLabel lblVisualizar;
    private javax.swing.JLabel lblVisualizar1;
    private javax.swing.JLabel lblVisualizar2;
    private javax.swing.JLabel lblVisualizar4;
    private javax.swing.JPanel panelActualizar;
    private javax.swing.JPanel panelActualizar1;
    private javax.swing.JPanel panelActualizar2;
    private javax.swing.JPanel panelActualizar3;
    private javax.swing.JPanel panelRegistrar;
    private javax.swing.JPanel panelRegistrar1;
    private javax.swing.JPanel panelRegistrar2;
    private javax.swing.JPanel panelRegistrar3;
    private javax.swing.JPanel panelUsuario;
    private javax.swing.JPanel panelVisualizar;
    private javax.swing.JPanel panelVisualizar1;
    private javax.swing.JPanel panelVisualizar2;
    private javax.swing.JPanel panelVisualizar3;
    // End of variables declaration//GEN-END:variables
}
