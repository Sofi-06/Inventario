package com.usta.formularios;

import com.usta.configuraciones.DominioManual;
import com.usta.daos.DaoElemento;
import com.usta.daos.DaoElementoExperimento;
import com.usta.daos.DaoExperimento;
import com.usta.entities.Elemento;
import com.usta.entities.ElementoExperimento;
import com.usta.entities.Experimento;
import java.awt.Color;
import java.awt.Component;
import java.awt.Image;
import java.io.File;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import org.kordamp.ikonli.materialdesign2.MaterialDesignA;
import org.kordamp.ikonli.materialdesign2.MaterialDesignH;
import org.kordamp.ikonli.swing.FontIcon;

public class FrmEditarExperimentos extends javax.swing.JFrame {

    InputStream fotoInputStream;
    ImageIcon foto;
    private Integer IndiceManual;
    private List<Integer> listaInicialAccesorios;

    FontIcon iconoUsuario = new FontIcon();
    FontIcon iconoInicio = new FontIcon();

    private Experimento objActualizar;
    private String rutaAplicacion;
    private Map<Integer, Boolean> codigosManual = new HashMap<>();
    private final DefaultComboBoxModel<String> miModeloCombo = new DefaultComboBoxModel<>();

    private String titulos[] = {"ID", "Nombre", "Agregar"};
    private String titulosSeleccionados[] = {"ID", "Nombre", "Cantidad", "Eliminar"};
    private DefaultTableModel modelotablaAgregado = new DefaultTableModel(titulosSeleccionados, 0) {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }

        @Override
        public Class<?> getColumnClass(int columnIndex) {
            if (columnIndex == 3) {
                return ImageIcon.class;
            }
            return Object.class;
        }
    };
    Integer columnaSeleccionada;

    private DefaultTableModel modeloTablaAccesorios = new DefaultTableModel(titulos, 0) {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;

        }

        @Override
        public Class<?> getColumnClass(int columnIndex) {
            if (columnIndex == 2) {
                return ImageIcon.class;
            }
            return Object.class;
        }
    };

    public class IconCellRenderer extends DefaultTableCellRenderer {

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            if (value instanceof ImageIcon) {
                JLabel label = new JLabel((ImageIcon) value);
                label.setOpaque(true);
                label.setBackground(table.getSelectionBackground());
                label.setForeground(table.getSelectionForeground());
                return label;
            } else {
                return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            }
        }
    }

    public FrmEditarExperimentos(Experimento objExperimento) {
        initComponents();

        cmbManual.setModel(miModeloCombo);
        rutaAplicacion = System.getProperty("user.dir");
        tablaAccesorios.setModel(modeloTablaAccesorios);
        tablaSelecccionados.setModel(modelotablaAgregado);

        cargarRecursos("");
        setImageToLabel(lblEncabezado, "..\\proyectoFinalTerminado\\Imagenes\\Encabezado.png");
        objActualizar = objExperimento;
        txtNombre.setText(objExperimento.getNombreExperimento());
        txtInventario.setText(objExperimento.getCodInventario());
        txtMarca.setText(objExperimento.getMarcaExperimento());
        txtActa.setText(objExperimento.getActaExperimento());
        txtCosto.setText(objExperimento.getCostoExperimento().toString());
        fCompra.setDate(objExperimento.getFechaCompraExperimento());
        cargarManual();
        Integer codExp = objActualizar.getCodExperimento();
        cargarAccesorioEditar(codExp);
        ImageIcon imagen = new ImageIcon(objActualizar.getFotoExperimento());
        lblFoto.setIcon(imagen);

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

        iconoUsuario.setIkon(MaterialDesignA.ACCOUNT_CIRCLE_OUTLINE);
        iconoUsuario.setIconSize(40);
        iconoUsuario.setIconColor(Color.decode("#000000"));
        this.lblUsuario.setIcon(iconoUsuario);

        iconoInicio.setIkon(MaterialDesignH.HOME);
        iconoInicio.setIconSize(40);
        iconoInicio.setIconColor(Color.decode("#000000"));
        this.lblInicio.setIcon(iconoInicio);

        //ENCONTRAR ID INICIALES
        List<Integer> listaIdInicial = new ArrayList<>(obtenerIDTablaAccesorio(tablaSelecccionados));
        System.out.println("" + listaIdInicial);
    }

    private void cargarAccesorioEditar(Integer idGrupo) {
        List<ElementoExperimento> listaCargar;
        DaoElementoExperimento miDao = new DaoElementoExperimento();
        listaCargar = miDao.consultarNombresPorExp(idGrupo);

        String nombreElim = "/com/usta/iconos/borrar.png";
        String rutaIconoElim = this.getClass().getResource(nombreElim).getPath();
        ImageIcon borrarIcono = new ImageIcon(rutaIconoElim);
        modelotablaAgregado.setNumRows(0);

        listaCargar.forEach((rompe) -> {
            Object filita[] = new Object[4];
            filita[0] = rompe.getCodElemento().getCodElemento();
            filita[1] = rompe.getCodElemento().getNombreElemento();
            filita[2] = rompe.getCodElemento().getCantidadElemento();
            filita[3] = borrarIcono;
            modelotablaAgregado.addRow(filita);

            IconCellRenderer iconRenderer = new IconCellRenderer();
            tablaSelecccionados.getColumnModel().getColumn(2).setCellRenderer(iconRenderer);
        });
    }
    private String convertirBooleanAString(Boolean valor) {
        if (valor == null) {
            return "Seleccione una opción";
        } else if (valor) {
            return "Sí";
        } else {
            return "No";
        }
    }   
    public void cargarManual() {
        IndiceManual = 0; // Inicializamos el índice a -1
        codigosManual = DominioManual.ARREGLO_MANUAL;

        miModeloCombo.removeAllElements(); // Limpiar el modelo antes de agregar nuevos elementos

        for (Map.Entry<Integer, Boolean> entry : codigosManual.entrySet()) {
            Integer key = entry.getKey();
            Boolean value = entry.getValue();
            String displayValue = convertirBooleanAString(value);

            miModeloCombo.addElement(displayValue);

            if (Objects.equals(objActualizar.getManualExperimento(), value)) {
                IndiceManual = key; // Ajustado para el índice basado en cero en el combo box
            }
        }
        cmbManual.setSelectedIndex(IndiceManual);// Asegurarse de establecer el modelo antes de seleccionar el índice
    }

    private void cargarRecursos(String ordencito) {
        List<Elemento> arrElemento;
        DaoElemento miDao = new DaoElemento();

        String nombreEdit = "/com/usta/iconos/agregar.png";
        String rutaIconoEdit = this.getClass().getResource(nombreEdit).getPath();
        ImageIcon editIcono = new ImageIcon(rutaIconoEdit);

        modeloTablaAccesorios.setNumRows(0);

        arrElemento = miDao.consultar(ordencito);

        arrElemento.forEach((elemento) -> {
            Object filita[] = new Object[3];

            filita[0] = elemento.getCodElemento();
            filita[1] = elemento.getNombreElemento();
            filita[2] = editIcono;
            modeloTablaAccesorios.addRow(filita);
        });
        DefaultTableCellRenderer centrado = new DefaultTableCellRenderer();
        centrado.setHorizontalAlignment(JLabel.CENTER);
    }

    private void agregarAccesorio() {

        String nombreElim = "/com/usta/iconos/borrar.png";
        String rutaIconoElim = this.getClass().getResource(nombreElim).getPath();
        ImageIcon borrarIcono = new ImageIcon(rutaIconoElim);

        int filaSeleccionada = tablaAccesorios.getSelectedRow();

        if (filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(panelCuerpo, "No se ha seleccionado ningún accesorio", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }

        String nombreAccesorio;
        int cant;
        DefaultTableModel modelTablaAccesorio = (DefaultTableModel) tablaAccesorios.getModel();
        DefaultTableModel modelTablaAccesorioSeleccionado = (DefaultTableModel) tablaSelecccionados.getModel();

        nombreAccesorio = (String) modelTablaAccesorio.getValueAt(filaSeleccionada, 1);
        cant = 1;

        boolean exists = false;
        for (int i = 0; i < modelTablaAccesorioSeleccionado.getRowCount(); i++) {
            if (modelTablaAccesorioSeleccionado.getValueAt(i, 1).equals(nombreAccesorio)) {
                int cantAccesorioSeleccionado = (int) modelTablaAccesorioSeleccionado.getValueAt(i, 2);
                cant += cantAccesorioSeleccionado;
                modelTablaAccesorioSeleccionado.setValueAt(cant, i, 2);
                exists = true;
                break;
            }
        }

        if (!exists) {
            Object[] datosFila = new Object[4]; // Asegurarse de tener espacio para 4 columnas
            datosFila[0] = modelTablaAccesorio.getValueAt(filaSeleccionada, 0); // ID o lo que haya en la primera columna
            datosFila[1] = nombreAccesorio; // Nombre del accesorio
            datosFila[2] = cant; // Cantidad
            datosFila[3] = borrarIcono; // Suponiendo que la cuarta columna de tablaAccesorios es la descripción

            modelTablaAccesorioSeleccionado.addRow(datosFila);
        }

        int cantProductosTotal = sumarColumnaCant(tablaSelecccionados, 2);
        lblCantidad.setText(String.valueOf(cantProductosTotal));
    }

    public static int sumarColumnaCant(JTable tabla, int columna) {
        int total = 0;
        int rowCount = tabla.getRowCount();

        for (int i = 0; i < rowCount; i++) {
            total += (int) tabla.getValueAt(i, columna);
        }

        return total;
    }

    private void eliminarAccesorio() {
        int filaSeleccionada = tablaSelecccionados.getSelectedRow();

        if (filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(panelCuerpo, "No se ha seleccionado ningún accesorio para eliminar", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }

        String nombreAccesorio;
        int cant;
        DefaultTableModel modelTablaAccesorioSeleccionado = (DefaultTableModel) tablaSelecccionados.getModel();

        nombreAccesorio = (String) modelTablaAccesorioSeleccionado.getValueAt(filaSeleccionada, 1);
        cant = (int) modelTablaAccesorioSeleccionado.getValueAt(filaSeleccionada, 2);

        if (cant > 1) {
            cant -= 1;
            modelTablaAccesorioSeleccionado.setValueAt(cant, filaSeleccionada, 2);
        } else {
            modelTablaAccesorioSeleccionado.removeRow(filaSeleccionada);
        }

        int cantProductosTotal = sumarColumnaCant(tablaSelecccionados, 2);
        lblCantidad.setText(String.valueOf(cantProductosTotal));
    }

    private void registrarAccesoriosEditar(List<Integer> ids, Integer cant) {
        DaoElementoExperimento daoElementoExperimento = new DaoElementoExperimento();
        for (Integer id : ids) {

            ElementoExperimento objElementoExperimento = new ElementoExperimento();
            Elemento objElemento = new Elemento(id, "", "", 0, rutaAplicacion);
            Experimento objExperimento = new Experimento(objActualizar.getCodExperimento(), "", "", "", "", false, "", 0, null);
            objElementoExperimento.setCodExperimento(objExperimento);
            objElementoExperimento.setCodElemento(objElemento);
            objElementoExperimento.setCantAccesorios(cant);

            daoElementoExperimento.actualizar(objElementoExperimento);
        }
    }

    public static List<Integer> obtenerIDTablaAccesorio(JTable tabla) {
        List<Integer> primeraColumna = new ArrayList<>();
        for (int i = 0; i < tabla.getRowCount(); i++) {
            String valor = tabla.getValueAt(i, 0).toString();
            primeraColumna.add(Integer.valueOf(valor));
        }

        return primeraColumna;
    }

    // Método para eliminar estudiantes
    private void eliminarAccesorioEditar(List<Integer> ids) {
        DaoElementoExperimento daoElementoExperimento = new DaoElementoExperimento();
        for (Integer id : ids) {
            daoElementoExperimento.eliminar(id);
        }
    }

    private Boolean estaTodoBien() {
        String nombre, marca, acta, inventario;
        Integer costo, indiceSeleccionado;

        Boolean bandera = true;
        nombre = txtNombre.getText();
        if (nombre.equals("")) {
            txtNombre.requestFocus();
            bandera = false;
            JOptionPane.showMessageDialog(panelCuerpo, "Digite el nombre del elemento", "Advertencia", JOptionPane.WARNING_MESSAGE);
        } else {
            marca = txtMarca.getText();
            if (marca.equals("")) {
                txtMarca.requestFocus();
                bandera = false;
                JOptionPane.showMessageDialog(panelCuerpo, "Digite la marca del experimento", "Advertencia", JOptionPane.WARNING_MESSAGE);
            } else {
                acta = txtActa.getText();
                if (acta.equals("")) {
                    txtActa.requestFocus();
                    bandera = false;
                    JOptionPane.showMessageDialog(panelCuerpo, "Digite el acta del experimento", "Advertencia", JOptionPane.WARNING_MESSAGE);
                } else {
                    inventario = txtInventario.getText();
                    if (inventario.equals("")) {
                        txtInventario.requestFocus();
                        bandera = false;
                        JOptionPane.showMessageDialog(panelCuerpo, "Digite el inventario del experimento", "Advertencia", JOptionPane.WARNING_MESSAGE);
                    } else {
                        indiceSeleccionado = cmbManual.getSelectedIndex();
                        if (indiceSeleccionado == 0) {
                            bandera = false;
                            JOptionPane.showMessageDialog(panelCuerpo, "Por favor seleccione si existe el manual",
                                    "Advertencia", JOptionPane.ERROR_MESSAGE);
                        } else {
                            try {
                                costo = Integer.valueOf(txtCosto.getText());
                                if (costo < 0) {
                                    bandera = false;
                                    JOptionPane.showMessageDialog(panelCuerpo, "Por favor digite el costo del experimento", "Advertencia", JOptionPane.ERROR_MESSAGE);
                                    txtCosto.requestFocus();
                                }
                            } catch (NumberFormatException e) {
                                bandera = false;
                                JOptionPane.showMessageDialog(panelCuerpo, "Escriba números en costo del experimento", "Advertencia", JOptionPane.ERROR_MESSAGE);
                                txtCosto.requestFocus();
                            }
                        }
                    }

                }

            }

        }
        return bandera;

    }

    private Integer buscarDatoExperimento(String dato, String campo) {
        List<Experimento> arrayExperimento;
        DaoExperimento dao = new DaoExperimento();

        arrayExperimento = dao.buscarNombre(dato, campo);
        for (Experimento experimento : arrayExperimento) {
            // Si el nombre del experimento coincide con el dato buscado
            if (experimento.getNombreExperimento().equals(dato)) {
                // Devolvemos el código del experimento
                return experimento.getCodExperimento();
            }
        }

        return null;
    }

//    private Integer buscarId(String dato) {
//        Integer codElemento;
//        DaoElemento dao = new DaoElemento();
//
//        codElemento = dao.buscarId(dato);
//
//        return codElemento;
//    }
    private void registrarRompe() {
        System.out.println("entre");
        List<Integer> listaIdsDespues = new ArrayList<>(obtenerIDTablaAccesorio(tablaSelecccionados));

// Convertir las listas a conjuntos para facilitar las operaciones de comparación
        System.out.println("ista: " + listaInicialAccesorios);
        Set<Integer> setAntiguo = new HashSet<>(listaInicialAccesorios);

        Set<Integer> setNuevo = new HashSet<>(listaIdsDespues);

        // Encontrar IDs que se han eliminado
        Set<Integer> eliminados = new HashSet<>(setAntiguo);
        eliminados.removeAll(setNuevo);

        // Encontrar IDs que se han añadido
        Set<Integer> añadidos = new HashSet<>(setNuevo);
        añadidos.removeAll(setAntiguo);

        // Encontrar IDs que permanecen iguales
        Set<Integer> iguales = new HashSet<>(setAntiguo);
        iguales.retainAll(setNuevo);

        // Convertir los sets a listas
        List<Integer> listaEliminados = new ArrayList<>(eliminados);
        List<Integer> listaAñadidos = new ArrayList<>(añadidos);

        // Imprimir resultados
        System.out.println("IDs eliminados: " + listaEliminados);
        System.out.println("IDs añadidos: " + listaAñadidos);

        // Imprimir resultados
        System.out.println("IDs eliminados: " + eliminados);
        System.out.println("IDs añadidos: " + añadidos);
        System.out.println("IDs que permanecen iguales: " + iguales);

        if (modelotablaAgregado.getRowCount() == 0) {
            JOptionPane.showMessageDialog(panelCuerpo, "Agregue elementos o elimine el experimento",
                    "Información", JOptionPane.INFORMATION_MESSAGE);
            cargarAccesorioEditar(objActualizar.getCodExperimento());
            cargarRecursos("");
        } else {

            // Procesar los IDs eliminados y añadidos
            eliminarAccesorioEditar(listaEliminados);
            Integer cantAccesorios = Integer.valueOf(lblCantidad.getText());
            registrarAccesoriosEditar(listaAñadidos, cantAccesorios);

            JOptionPane.showMessageDialog(panelCuerpo, "Actualización exitosa accesorios",
                    "Información", JOptionPane.INFORMATION_MESSAGE);
        }

    }

    private void buscarDato(String dato, String campo) {
        List<Elemento> arrElemento;
        DaoElemento dao = new DaoElemento();

        String nombreElim = "/com/usta/iconos/agregar.png";
        String rutaIconoElim = this.getClass().getResource(nombreElim).getPath();
        ImageIcon borrarIcono = new ImageIcon(rutaIconoElim);

        arrElemento = dao.buscarNombre(dato, campo);
        modeloTablaAccesorios.setRowCount(0); // Limpiar la tabla antes de añadir los nuevos resultados
        arrElemento.forEach((elemento) -> {
            Object filita[] = new Object[3];

            filita[0] = elemento.getNombreElemento();
            filita[1] = elemento.getCantidadElemento();
            filita[2] = borrarIcono;

            modeloTablaAccesorios.addRow(filita);
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelCuerpo = new javax.swing.JPanel();
        lblEncabezado = new javax.swing.JLabel();
        lblTitulo = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtInventario = new javax.swing.JTextField();
        txtMarca = new javax.swing.JTextField();
        txtCosto = new javax.swing.JTextField();
        btnAñadir = new javax.swing.JButton();
        lblInventario = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        lblMarca = new javax.swing.JLabel();
        lblCosto = new javax.swing.JLabel();
        lblActa = new javax.swing.JLabel();
        lblFoto1 = new javax.swing.JLabel();
        lblFoto = new javax.swing.JLabel();
        cmbManual = new javax.swing.JComboBox<>();
        lblManual = new javax.swing.JLabel();
        fCompra = new com.toedter.calendar.JDateChooser();
        lblFecha = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaSelecccionados = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaAccesorios = new javax.swing.JTable();
        lblAccesorios = new javax.swing.JLabel();
        txtActa = new javax.swing.JTextField();
        lblCantidad = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        panelUsuario = new javax.swing.JPanel();
        lblUsuario = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        panelInicio = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lblInicio = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        panelCuerpo.setBackground(new java.awt.Color(255, 255, 255));

        lblTitulo.setFont(new java.awt.Font("Quando", 0, 40)); // NOI18N
        lblTitulo.setText("RECURSOS DE EXPERIMENTOS");

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

        txtCosto.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        txtCosto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCostoActionPerformed(evt);
            }
        });

        btnAñadir.setBackground(new java.awt.Color(0, 204, 255));
        btnAñadir.setFont(new java.awt.Font("Roboto", 1, 20)); // NOI18N
        btnAñadir.setForeground(new java.awt.Color(255, 255, 255));
        btnAñadir.setText("AÑADIR EXPERIMENTO");
        btnAñadir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAñadirActionPerformed(evt);
            }
        });

        lblInventario.setFont(new java.awt.Font("Quando", 0, 16)); // NOI18N
        lblInventario.setText("INVENTARIO");

        lblNombre.setFont(new java.awt.Font("Quando", 0, 16)); // NOI18N
        lblNombre.setText("NOMBRE");

        lblMarca.setFont(new java.awt.Font("Quando", 0, 16)); // NOI18N
        lblMarca.setText("MARCA");

        lblCosto.setFont(new java.awt.Font("Quando", 0, 16)); // NOI18N
        lblCosto.setText("COSTO");

        lblActa.setFont(new java.awt.Font("Quando", 0, 16)); // NOI18N
        lblActa.setText("ACTA");

        lblFoto1.setFont(new java.awt.Font("Quando", 0, 16)); // NOI18N
        lblFoto1.setText("FOTO");

        lblFoto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblFoto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblFoto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblFotoMouseClicked(evt);
            }
        });

        cmbManual.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N

        lblManual.setFont(new java.awt.Font("Quando", 0, 16)); // NOI18N
        lblManual.setText("MANUAL");

        fCompra.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N

        lblFecha.setFont(new java.awt.Font("Quando", 0, 16)); // NOI18N
        lblFecha.setText("FECHA DE COMPRA:");

        tablaSelecccionados.setModel(new javax.swing.table.DefaultTableModel(
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
        tablaSelecccionados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaSelecccionadosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaSelecccionados);

        tablaAccesorios.setModel(new javax.swing.table.DefaultTableModel(
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
        tablaAccesorios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaAccesoriosMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tablaAccesorios);

        lblAccesorios.setFont(new java.awt.Font("Quando", 0, 16)); // NOI18N
        lblAccesorios.setText("ACCESORIOS");

        lblCantidad.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel2.setText("CANTIDAD DE ACCESORIOS:");

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

        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField1KeyReleased(evt);
            }
        });

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
            .addGroup(panelCuerpoLayout.createSequentialGroup()
                .addGroup(panelCuerpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelCuerpoLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblTitulo)
                        .addGap(297, 297, 297)
                        .addComponent(panelInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(panelUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelCuerpoLayout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addGroup(panelCuerpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelCuerpoLayout.createSequentialGroup()
                                .addGroup(panelCuerpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panelCuerpoLayout.createSequentialGroup()
                                        .addGap(9, 9, 9)
                                        .addComponent(lblNombre))
                                    .addGroup(panelCuerpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(txtMarca, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtNombre, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(panelCuerpoLayout.createSequentialGroup()
                                            .addGroup(panelCuerpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(panelCuerpoLayout.createSequentialGroup()
                                                    .addGap(9, 9, 9)
                                                    .addComponent(lblActa))
                                                .addComponent(txtActa, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                                            .addGroup(panelCuerpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(lblManual)
                                                .addComponent(cmbManual, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addComponent(lblFoto, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(panelCuerpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panelCuerpoLayout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addGroup(panelCuerpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtInventario, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelCuerpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(lblCosto)
                                                .addGroup(panelCuerpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(txtCosto, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(fCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addComponent(lblFecha))))
                                    .addGroup(panelCuerpoLayout.createSequentialGroup()
                                        .addGap(22, 22, 22)
                                        .addComponent(lblInventario))
                                    .addGroup(panelCuerpoLayout.createSequentialGroup()
                                        .addGap(50, 50, 50)
                                        .addComponent(btnAñadir))))
                            .addGroup(panelCuerpoLayout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addComponent(lblMarca))
                            .addGroup(panelCuerpoLayout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(lblFoto1)))
                        .addGroup(panelCuerpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelCuerpoLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblAccesorios)
                                .addGap(169, 169, 169))
                            .addGroup(panelCuerpoLayout.createSequentialGroup()
                                .addGap(66, 66, 66)
                                .addGroup(panelCuerpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(panelCuerpoLayout.createSequentialGroup()
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(51, 51, 51))
                                    .addGroup(panelCuerpoLayout.createSequentialGroup()
                                        .addGroup(panelCuerpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jTextField1)
                                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                                .addGroup(panelCuerpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelCuerpoLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {cmbManual, txtActa});

        panelCuerpoLayout.setVerticalGroup(
            panelCuerpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCuerpoLayout.createSequentialGroup()
                .addGroup(panelCuerpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelCuerpoLayout.createSequentialGroup()
                        .addComponent(lblEncabezado, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelCuerpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblTitulo)
                            .addComponent(panelInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelCuerpoLayout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(panelUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(panelCuerpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblInventario, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelCuerpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblNombre)
                        .addComponent(lblAccesorios)))
                .addGroup(panelCuerpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelCuerpoLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAñadir, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(95, 95, 95))
                    .addGroup(panelCuerpoLayout.createSequentialGroup()
                        .addGroup(panelCuerpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelCuerpoLayout.createSequentialGroup()
                                .addGroup(panelCuerpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtInventario, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(39, 39, 39)
                                .addGroup(panelCuerpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblMarca)
                                    .addComponent(lblCosto))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panelCuerpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtCosto, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(39, 39, 39)
                                .addGroup(panelCuerpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblActa)
                                    .addComponent(lblManual)
                                    .addComponent(lblFecha))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panelCuerpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panelCuerpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(cmbManual, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtActa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(fCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(32, 32, 32)
                                .addComponent(lblFoto1)
                                .addGap(0, 0, 0)
                                .addComponent(lblFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 11, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelCuerpoLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(panelCuerpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 386, Short.MAX_VALUE)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))))
                        .addGap(18, 18, 18)
                        .addGroup(panelCuerpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(lblCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18))))
        );

        panelCuerpoLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {cmbManual, txtActa});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelCuerpo, javax.swing.GroupLayout.DEFAULT_SIZE, 1269, Short.MAX_VALUE)
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

    private void txtInventarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtInventarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtInventarioActionPerformed

    private void txtMarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMarcaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMarcaActionPerformed

    private void txtCostoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCostoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCostoActionPerformed

    private void btnAñadirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAñadirActionPerformed

        if (estaTodoBien()) {
            String nombre, marca, acta, inventario;
            Integer costo, indiceSeleccionado;
            Boolean manual;
            nombre = txtNombre.getText();
            marca = txtMarca.getText();
            acta = txtActa.getText();
            costo = Integer.valueOf(txtCosto.getText());
            inventario = txtInventario.getText();

            indiceSeleccionado = cmbManual.getSelectedIndex();

            if (indiceSeleccionado == 1) {
                manual = true;
            } else {
                manual = false;
            }

            objActualizar.setNombreExperimento(nombre);
            objActualizar.setMarcaExperimento(marca);
            objActualizar.setActaExperimento(acta);
            objActualizar.setCostoExperimento(costo);
            objActualizar.setManualExperimento(manual);
            objActualizar.setCodInventario(inventario);
            objActualizar.setFechaCompraExperimento(fCompra.getDate());
            objActualizar.setFotoExperimento(rutaAplicacion);

            DaoExperimento daoExperimento = new DaoExperimento();

            if (daoExperimento.actualizar(objActualizar)) {
                JOptionPane.showMessageDialog(panelCuerpo, "Actualización exitosa", "Información", JOptionPane.INFORMATION_MESSAGE);
                registrarRompe();
//                limpiarCajas();

            } else {
                JOptionPane.showMessageDialog(panelCuerpo, "No se pudo resgistrar", "Error", JOptionPane.ERROR_MESSAGE);
            }

        }


    }//GEN-LAST:event_btnAñadirActionPerformed

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

    private void tablaAccesoriosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaAccesoriosMouseClicked
        columnaSeleccionada = tablaAccesorios.getSelectedColumn();
        if (columnaSeleccionada == 2) {
            agregarAccesorio();
        }
    }//GEN-LAST:event_tablaAccesoriosMouseClicked

    private void tablaSelecccionadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaSelecccionadosMouseClicked
        columnaSeleccionada = tablaSelecccionados.getSelectedColumn();
        if (columnaSeleccionada == 3) {
            eliminarAccesorio();
        }
    }//GEN-LAST:event_tablaSelecccionadosMouseClicked

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

    private void jTextField1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyReleased
        buscarDato("%" + jTextField1.getText().toUpperCase() + "%", "nom_elemento");
    }//GEN-LAST:event_jTextField1KeyReleased

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
            java.util.logging.Logger.getLogger(FrmEditarExperimentos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmEditarExperimentos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmEditarExperimentos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmEditarExperimentos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
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
                FrmEditarExperimentos dialog = new FrmEditarExperimentos(new Experimento());
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
    private javax.swing.JButton btnAñadir;
    private javax.swing.JComboBox<String> cmbManual;
    private com.toedter.calendar.JDateChooser fCompra;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel lblAccesorios;
    private javax.swing.JLabel lblActa;
    private javax.swing.JLabel lblCantidad;
    private javax.swing.JLabel lblCosto;
    private javax.swing.JLabel lblEncabezado;
    private javax.swing.JLabel lblFecha;
    private javax.swing.JLabel lblFoto;
    private javax.swing.JLabel lblFoto1;
    private javax.swing.JLabel lblInicio;
    private javax.swing.JLabel lblInventario;
    private javax.swing.JLabel lblManual;
    private javax.swing.JLabel lblMarca;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JPanel panelCuerpo;
    private javax.swing.JPanel panelInicio;
    private javax.swing.JPanel panelUsuario;
    private javax.swing.JTable tablaAccesorios;
    private javax.swing.JTable tablaSelecccionados;
    private javax.swing.JTextField txtActa;
    private javax.swing.JTextField txtCosto;
    private javax.swing.JTextField txtInventario;
    private javax.swing.JTextField txtMarca;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
