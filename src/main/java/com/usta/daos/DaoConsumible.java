package com.usta.daos;

import com.usta.configuraciones.MiConexion;
import com.usta.entities.Consumible;
import com.usta.entities.Experimento;
import com.usta.interfaces.Funcionalidad;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DaoConsumible extends MiConexion implements Funcionalidad<Consumible> {

    @Override
    public boolean registrar(Consumible elObjeto) {
        try {
            miCadenaSQL = "INSERT INTO inv_consumibles "
                    + "(nom_elemento, referencia, marca, cantidad, foto, observaciones, num_gabinete) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?)";
            miConsulta = miObjConexion.prepareStatement(miCadenaSQL);

            miConsulta.setString(1, elObjeto.getNombreConsumible());
            miConsulta.setString(2, elObjeto.getReferenciaConsumible());
            miConsulta.setString(3, elObjeto.getMarcaConsumible());
            miConsulta.setInt(4, elObjeto.getCantidadConsumible());
            miConsulta.setString(5, elObjeto.getFotoConsumible());
            miConsulta.setString(6, elObjeto.getObservacionConsumible());
            miConsulta.setInt(7, elObjeto.getNumeroGabineteConsumible());

            miCantidad = miConsulta.executeUpdate();
            miObjConexion.close();
            return miCantidad > 0;

        } catch (SQLException ex) {
            Logger.getLogger(DaoConsumible.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public List<Consumible> consultar(String orden) {
        try {
            if (orden.isEmpty()) {
                orden = "id_consumibles";
            }
            miCadenaSQL = "SELECT id_consumibles, nom_elemento, referencia, marca, cantidad, foto, observaciones, num_gabinete FROM inv_consumibles "
                    + "ORDER BY "
                    + orden;

            miConsulta = miObjConexion.prepareStatement(miCadenaSQL);
            misRegistros = miConsulta.executeQuery();
            List<Consumible> arregloCon = new ArrayList<>();

            while (misRegistros.next()) {
                Integer cod = misRegistros.getInt(1);
                String nombre = misRegistros.getString(2);
                String ref = misRegistros.getString(3);
                String mar = misRegistros.getString(4);
                Integer cant = misRegistros.getInt(5);
                String foto = misRegistros.getString(6);
                String obs = misRegistros.getString(7);
                Integer numG = misRegistros.getInt(8);

                Consumible objCon = new Consumible(cod, nombre, ref, mar, cant, foto, obs, numG);

                arregloCon.add(objCon);
            }
            miObjConexion.close();
            return arregloCon;
        } catch (SQLException ex) {
            Logger.getLogger(DaoConsumible.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public Consumible buscar(Integer llavePrimaria) {
        try {
            miCadenaSQL = "SELECT id_consumibles, nom_elemento, referencia, marca, cantidad, foto, observaciones, num_gabinete FROM inv_consumibles "
                    + "WHERE id_consumibles = ?";
            miConsulta = miObjConexion.prepareStatement(miCadenaSQL);
            miConsulta.setInt(1, llavePrimaria);
            misRegistros = miConsulta.executeQuery();

            Consumible objEncontrada = null;
            if (misRegistros.next()) {
                Integer cod = misRegistros.getInt(1);
                String nombre = misRegistros.getString(2);
                String ref = misRegistros.getString(3);
                String mar = misRegistros.getString(4);
                Integer cant = misRegistros.getInt(5);
                String foto = misRegistros.getString(6);
                String obs = misRegistros.getString(7);
                Integer numG = misRegistros.getInt(8);

                objEncontrada = new Consumible(cod, nombre, ref, mar, cant, foto, obs, numG);

            }
            miObjConexion.close();
            return objEncontrada;
        } catch (SQLException ex) {
            Logger.getLogger(DaoConsumible.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public boolean eliminar(Integer llavePrimaria) {
        try {
            miCadenaSQL = "DELETE FROM inv_consumibles "
                    + "WHERE id_consumibles = ?";
            miConsulta = miObjConexion.prepareStatement(miCadenaSQL);
            miConsulta.setInt(1, llavePrimaria);

            miCantidad = miConsulta.executeUpdate();
            miObjConexion.close();
            return miCantidad > 0;
        } catch (SQLException ex) {
            Logger.getLogger(DaoConsumible.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public boolean actualizar(Consumible elObjeto) {
        try {
            miCadenaSQL = "UPDATE inv_consumibles SET nom_elemento = ? , referencia = ? , marca = ?, cantidad = ?, foto = ?, "
                    + "observaciones = ?, num_gabinete = ? "
                    + "WHERE id_consumibles = ?";

            miConsulta = miObjConexion.prepareStatement(miCadenaSQL);

            miConsulta.setString(1, elObjeto.getNombreConsumible());
            miConsulta.setString(2, elObjeto.getReferenciaConsumible());
            miConsulta.setString(3, elObjeto.getMarcaConsumible());
            miConsulta.setInt(4, elObjeto.getCantidadConsumible());
            miConsulta.setString(5, elObjeto.getFotoConsumible());
            miConsulta.setString(6, elObjeto.getObservacionConsumible());
            miConsulta.setInt(7, elObjeto.getNumeroGabineteConsumible());
            miConsulta.setInt(8, elObjeto.getCodConsumible());

            miCantidad = miConsulta.executeUpdate();

            miObjConexion.close();

            return miCantidad > 0;

        } catch (SQLException ex) {
            Logger.getLogger(DaoConsumible.class.getName()).log(Level.SEVERE, null, ex);

            return false;
        }
    }

    @Override
    public Integer totalRegistros() {
        try {
            miCadenaSQL = "SELECT count(id_consumibles) FROM inv_consumibles";
            miConsulta = miObjConexion.prepareStatement(miCadenaSQL);

            misRegistros = miConsulta.executeQuery();

            while (misRegistros.next()) {
                miCantidad = misRegistros.getInt(1);
            }

            miObjConexion.close();

            return miCantidad;

        } catch (SQLException ex) {
            Logger.getLogger(DaoConsumible.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }

    @Override
    public List<Consumible> buscarNombre(String dato, String nombre) {
        try {

            miCadenaSQL = "SELECT id_consumibles, nom_elemento, referencia, marca, cantidad, foto, observaciones, "
                    + "num_gabinete FROM inv_consumibles WHERE " + nombre + " LIKE ? ";

            System.out.println("cadena: " + miCadenaSQL);
            miConsulta = miObjConexion.prepareStatement(miCadenaSQL);
            miConsulta.setString(1, dato);
            misRegistros = miConsulta.executeQuery();

            List<Consumible> arrayCon = new ArrayList<>();

            while (misRegistros.next()) {
                Integer cod = misRegistros.getInt(1);
                String nomb = misRegistros.getString(2);
                String ref = misRegistros.getString(3);
                String mar = misRegistros.getString(4);
                Integer cant = misRegistros.getInt(5);
                String foto = misRegistros.getString(6);
                String obs = misRegistros.getString(7);
                Integer numG = misRegistros.getInt(8);

                Consumible objCon = new Consumible(cod, nomb, ref, mar, cant, foto, obs, numG);

                arrayCon.add(objCon);
            }
            miObjConexion.close();
            return arrayCon;

        } catch (SQLException ex) {
            Logger.getLogger(DaoConsumible.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

}
