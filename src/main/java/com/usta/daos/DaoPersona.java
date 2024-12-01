package com.usta.daos;

import com.usta.configuraciones.MiConexion;
import com.usta.entities.Persona;
import com.usta.formularios.FrmHomeDirector;
import com.usta.formularios.FrmHomeLaboratorista;
import com.usta.formularios.FrmPrincipal;
import com.usta.interfaces.Funcionalidad;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class DaoPersona extends MiConexion implements Funcionalidad<Persona> {

    @Override
    public boolean registrar(Persona elObjeto) {
        try {
            miCadenaSQL = "INSERT INTO personas(nombre, apellido, documento, correo, telefono, usuario, contrasenna, nivel_acceso)values(?,?,?,?,?,?,?,?)";
            miConsulta = miObjConexion.prepareStatement(miCadenaSQL);

            miConsulta.setString(1, elObjeto.getNombrePersona());
            miConsulta.setString(2, elObjeto.getApellidoPersona());
            miConsulta.setString(3, elObjeto.getDocumentoPersona());
            miConsulta.setString(4, elObjeto.getCorreoPersona());
            miConsulta.setString(5, elObjeto.getTelefonoPersona());
            miConsulta.setString(6, elObjeto.getUsuarioPersona());
            miConsulta.setString(7, elObjeto.getContrasennaPersona());
            miConsulta.setString(8, elObjeto.getNivelAccesoPersona());

            miCantidad = miConsulta.executeUpdate();
            miObjConexion.close();
            return miCantidad > 0;
        } catch (SQLException ex) {
            Logger.getLogger(DaoPersona.class.getName()).log(Level.SEVERE, null, ex);
            return false;

        }
    }

    @Override
    public List<Persona> consultar(String orden) {

        try {
            if (orden.isEmpty()) {
                orden = "id_persona";
            }
            miCadenaSQL = "SELECT id_persona, nombre, apellido, documento, correo, telefono, usuario, contrasenna, nivel_acceso "
                    + "FROM personas "
                    + "ORDER BY "
                    + orden;

            miConsulta = miObjConexion.prepareStatement(miCadenaSQL);
            misRegistros = miConsulta.executeQuery();
            List<Persona> arregloPer = new ArrayList<>();

            while (misRegistros.next()) {
                Integer cod = misRegistros.getInt(1);
                String nombre = misRegistros.getString(2);
                String ape = misRegistros.getString(3);
                String docu = misRegistros.getString(4);
                String corr = misRegistros.getString(5);
                String tele = misRegistros.getString(6);
                String usu = misRegistros.getString(7);
                String cont = misRegistros.getString(8);
                String acc = misRegistros.getString(9);

                Persona objPer = new Persona(cod, nombre, ape, docu, corr, tele, usu, cont, acc);

                arregloPer.add(objPer);
            }
            miObjConexion.close();
            return arregloPer;
        } catch (SQLException ex) {
            Logger.getLogger(DaoPersona.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public Persona buscar(Integer llavePrimaria) {
        try {
            miCadenaSQL = "SELECT id_persona, nombre, apellido, correo, telefono, usuario, contrasenna, nivel_acceso "
                    + "FROM personas WHERE id_persona = ?";
            miConsulta = miObjConexion.prepareStatement(miCadenaSQL);
            miConsulta.setInt(1, llavePrimaria);
            misRegistros = miConsulta.executeQuery();

            Persona objEncontrada = null;
            if (misRegistros.next()) {
                Integer cod = misRegistros.getInt(1);
                String nombre = misRegistros.getString(2);
                String ape = misRegistros.getString(3);
                String docu = misRegistros.getString(4);
                String corr = misRegistros.getString(5);
                String tele = misRegistros.getString(6);
                String usu = misRegistros.getString(7);
                String cont = misRegistros.getString(8);
                String acc = misRegistros.getString(9);

                Persona objPer = new Persona(cod, nombre, ape, docu, corr, tele, usu, cont, acc);

            }
            miObjConexion.close();
            return objEncontrada;
        } catch (SQLException ex) {
            Logger.getLogger(DaoPersona.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public boolean eliminar(Integer llavePrimaria) {
        try {
            miCadenaSQL = "DELETE FROM personas "
                    + "WHERE id_persona = ?";
            miConsulta = miObjConexion.prepareStatement(miCadenaSQL);
            miConsulta.setInt(1, llavePrimaria);

            miCantidad = miConsulta.executeUpdate();
            miObjConexion.close();
            return miCantidad > 0;
        } catch (SQLException ex) {
            Logger.getLogger(DaoPersona.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public boolean actualizar(Persona elObjeto) {
        try {
            miCadenaSQL = "UPDATE personas SET nombre = ?, apellido = ?, correo = ?, telefono = ?, "
                    + "usuario = ?, contrasenna = ?, nivel_acceso = ? "
                    + "WHERE id_persona = ?";

            miConsulta = miObjConexion.prepareStatement(miCadenaSQL);

            miConsulta.setString(1, elObjeto.getNombrePersona());
            miConsulta.setString(2, elObjeto.getApellidoPersona());
            miConsulta.setString(3, elObjeto.getCorreoPersona());
            miConsulta.setString(4, elObjeto.getTelefonoPersona());
            miConsulta.setString(5, elObjeto.getUsuarioPersona());
            miConsulta.setString(6, elObjeto.getContrasennaPersona());
            miConsulta.setString(7, elObjeto.getNivelAccesoPersona());
            miConsulta.setInt(8, elObjeto.getCodPersona());

            miCantidad = miConsulta.executeUpdate();

            miObjConexion.close();

            return miCantidad > 0;

        } catch (SQLException ex) {
            Logger.getLogger(DaoPersona.class.getName()).log(Level.SEVERE, null, ex);

            return false;
        }
    }

    @Override
    public Integer totalRegistros() {
        try {
            miCadenaSQL = "SELECT count(id_persona) FROM personas";
            miConsulta = miObjConexion.prepareStatement(miCadenaSQL);

            misRegistros = miConsulta.executeQuery();

            while (misRegistros.next()) {
                miCantidad = misRegistros.getInt(1);
            }

            miObjConexion.close();

            return miCantidad;

        } catch (SQLException ex) {
            Logger.getLogger(DaoPersona.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }

    @Override
    public List<Persona> buscarNombre(String dato, String nombre) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void validarUsuario(JTextField usuario, JPasswordField contrasenia) {
        miCadenaSQL = "SELECT * FROM personas WHERE usuario = ? AND contrasenna = ?";
        String contrasenna = String.valueOf(contrasenia.getPassword());

        try {
            miObjConexion = MiConexion.obtenerConexion();
            miConsulta = miObjConexion.prepareStatement(miCadenaSQL);

            miConsulta.setString(1, usuario.getText());
            miConsulta.setString(2, contrasenna);

            misRegistros = miConsulta.executeQuery();

            if (misRegistros.next()) {
                String nivelAcceso = misRegistros.getString("nivel_acceso");

                if (null == nivelAcceso) {
                    JOptionPane.showMessageDialog(null, "Nivel de acceso desconocido");
                } else {
                    switch (nivelAcceso) {
                        case "Laboratorista" -> {
                            JOptionPane.showMessageDialog(null, "El Usuario es Laboratorista");
                            FrmHomeLaboratorista homeLaboratorista = new FrmHomeLaboratorista();
                            homeLaboratorista.setVisible(true);

                        }
                        case "Director" -> {
                            JOptionPane.showMessageDialog(null, "El Usuario es Director");
                            FrmHomeDirector homeDirector = new FrmHomeDirector();
                            homeDirector.setVisible(true);

                        }
                        default ->
                            JOptionPane.showMessageDialog(null, "Nivel de acceso es desconocido");
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "El Usuario o Contraseña es Incorrecto, Intentelo de nuevo");
                FrmPrincipal login = new FrmPrincipal();
                login.setVisible(true);
            }

            // Cerrar recursos
            misRegistros.close();
            miConsulta.close();
            miObjConexion.close();

        } catch (SQLException e) {
            Logger.getLogger(DaoPersona.class.getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(null, "ERROR: " + e.getMessage());
        }
    }

}
