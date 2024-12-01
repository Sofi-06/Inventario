package com.usta.daos;

import com.usta.configuraciones.MiConexion;
import com.usta.entities.Elemento;
import com.usta.interfaces.Funcionalidad;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DaoElemento extends MiConexion implements Funcionalidad<Elemento> {

    @Override
    public boolean registrar(Elemento elObjeto) {
        try {
            miCadenaSQL = "INSERT INTO elementos "
                    + "(nom_elemento, inv_accesorio, cantidad, referencia) "
                    + "VALUES (?, ?, ?, ?)";
            miConsulta = miObjConexion.prepareStatement(miCadenaSQL);

            miConsulta.setString(1, elObjeto.getNombreElemento());
            miConsulta.setString(2, elObjeto.getInventarioElemento());
            miConsulta.setInt(3, elObjeto.getCantidadElemento());
            miConsulta.setString(4, elObjeto.getReferenciaElemento());

            miCantidad = miConsulta.executeUpdate();
            miObjConexion.close();
            return miCantidad > 0;

        } catch (SQLException ex) {
            Logger.getLogger(DaoElemento.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public List<Elemento> consultar(String orden) {
        try {
            if (orden.isEmpty()) {
                orden = "id_elemento";
            }

            miCadenaSQL = "SELECT id_elemento, nom_elemento, inv_accesorio, cantidad, referencia "
                    + "FROM elementos"
                    + " ORDER BY " + orden;

            miConsulta = miObjConexion.prepareStatement(miCadenaSQL);
            misRegistros = miConsulta.executeQuery();

            List<Elemento> arrElementos = new ArrayList<>();

            while (misRegistros.next()) {
                int cod = misRegistros.getInt(1);
                String nom = misRegistros.getString(2);
                String inv = misRegistros.getString(3);
                int Cant = misRegistros.getInt(4);
                String referencia = misRegistros.getString(5);

                Elemento objEle = new Elemento(cod, nom, inv, Cant, referencia);
                arrElementos.add(objEle);
            }
            miObjConexion.close();
            return arrElementos;

        } catch (SQLException ex) {
            Logger.getLogger(DaoElemento.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public Elemento buscar(Integer llavePrimaria) {
        try {
            miCadenaSQL = "SELECT id_elemento, nom_elemento, inv_accesorio, cantidad, referencia "
                    + "FROM elementos WHERE id_elemento=?";
            miConsulta = miObjConexion.prepareStatement(miCadenaSQL);
            miConsulta.setInt(1, llavePrimaria);

            misRegistros = miConsulta.executeQuery();

            Elemento objEncontrado = null;

            if (misRegistros.next()) {
                int cod = misRegistros.getInt(1);
                String nom = misRegistros.getString(2);
                String inv = misRegistros.getString(3);
                int Cant = misRegistros.getInt(4);
                String referencia = misRegistros.getString(5);

                objEncontrado = new Elemento(cod, nom, inv, Cant, referencia);
            }
            miObjConexion.close();
            return objEncontrado;

        } catch (SQLException ex) {
            Logger.getLogger(DaoElemento.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public boolean eliminar(Integer llavePrimaria) {
        try {
            miCadenaSQL = "DELETE FROM elementos WHERE id_elemento=?";
            miConsulta = miObjConexion.prepareStatement(miCadenaSQL);
            miConsulta.setInt(1, llavePrimaria);

            miCantidad = miConsulta.executeUpdate();

            miObjConexion.close();
            return miCantidad > 0;

        } catch (SQLException ex) {
            Logger.getLogger(DaoElemento.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public boolean actualizar(Elemento elObjeto) {
        try {
            miCadenaSQL = "UPDATE elementos SET nom_elemento = ?, inv_accesorio = ?, cantidad = ?, referencia = ? "
                    + "WHERE id_elemento = ?";

            miConsulta = miObjConexion.prepareStatement(miCadenaSQL);

            miConsulta.setString(1, elObjeto.getNombreElemento());
            miConsulta.setString(2, elObjeto.getInventarioElemento());
            miConsulta.setInt(3, elObjeto.getCantidadElemento());
            miConsulta.setString(4, elObjeto.getReferenciaElemento());
            miConsulta.setInt(5, elObjeto.getCodElemento());

            miCantidad = miConsulta.executeUpdate();

            miObjConexion.close();

            return miCantidad > 0;

        } catch (SQLException ex) {
            Logger.getLogger(DaoElemento.class.getName()).log(Level.SEVERE, null, ex);

            return false;
        }
    }

    @Override
    public Integer totalRegistros() {
        try {
            miCadenaSQL = "SELECT count(id_elemento) FROM elementos";
            miConsulta = miObjConexion.prepareStatement(miCadenaSQL);

            misRegistros = miConsulta.executeQuery();

            while (misRegistros.next()) {
                miCantidad = misRegistros.getInt(1);
            }

            miObjConexion.close();

            return miCantidad;

        } catch (SQLException ex) {
            Logger.getLogger(DaoElemento.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }

    @Override
    public List<Elemento> buscarNombre(String dato, String nombre) {
        try {

            miCadenaSQL = "SELECT id_elemento, nom_elemento, inv_accesorio, cantidad, referencia "
                    + "FROM elementos WHERE " + nombre + " LIKE ? ";

            System.out.println("cadena: " + miCadenaSQL);
            miConsulta = miObjConexion.prepareStatement(miCadenaSQL);
            miConsulta.setString(1, dato);
            misRegistros = miConsulta.executeQuery();

            List<Elemento> arrayEle = new ArrayList<>();

            while (misRegistros.next()) {
                int cod = misRegistros.getInt(1);
                String nom = misRegistros.getString(2);
                String inv = misRegistros.getString(3);
                int Cant = misRegistros.getInt(4);
                String referencia = misRegistros.getString(5);

                Elemento objEle = new Elemento(cod, nom, inv, Cant, referencia);
                arrayEle.add(objEle);
            }
            miObjConexion.close();
            return arrayEle;

        } catch (SQLException ex) {
            Logger.getLogger(DaoElemento.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public Integer buscarId(String dato) {
        Integer codElemento = 0;
        try {

            miCadenaSQL = "SELECT id_elemento "
                    + "FROM elementos WHERE nom_elemento = ? ";

            System.out.println("cadena: " + miCadenaSQL);
            miConsulta = miObjConexion.prepareStatement(miCadenaSQL);
            miConsulta.setString(1, dato);
            misRegistros = miConsulta.executeQuery();

            while (misRegistros.next()) {
                 codElemento = misRegistros.getInt(1);

            }
            miObjConexion.close();
            return codElemento;

        } catch (SQLException ex) {
            Logger.getLogger(DaoElemento.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

}
