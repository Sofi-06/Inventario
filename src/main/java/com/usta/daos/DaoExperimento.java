package com.usta.daos;

import com.usta.configuraciones.MiConexion;
import com.usta.entities.Elemento;
import com.usta.entities.Experimento;
import com.usta.interfaces.Funcionalidad;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DaoExperimento extends MiConexion implements Funcionalidad<Experimento> {

    @Override
    public boolean registrar(Experimento elObjeto) {
        try {
            miCadenaSQL = "INSERT INTO inv_experimentos(cod_inventario, nom_Experimento,"
                    + " marca, foto, manual, acta, costo, fecha_compra)values(?,?,?,?,?,?,?,?)";
            miConsulta = miObjConexion.prepareStatement(miCadenaSQL);

            miConsulta.setString(1, elObjeto.getCodInventario());
            miConsulta.setString(2, elObjeto.getNombreExperimento());
            miConsulta.setString(3, elObjeto.getMarcaExperimento());
            miConsulta.setString(4, elObjeto.getFotoExperimento());
            miConsulta.setBoolean(5, elObjeto.getManualExperimento());
            miConsulta.setString(6, elObjeto.getActaExperimento());
            miConsulta.setInt(7, elObjeto.getCostoExperimento());
            long miliSegundos = elObjeto.getFechaCompraExperimento().getTime();
            Date fechaLista = new Date(miliSegundos);
            miConsulta.setDate(8, fechaLista);

            miCantidad = miConsulta.executeUpdate();
            miObjConexion.close();
            return miCantidad > 0;
        } catch (SQLException ex) {
            Logger.getLogger(DaoExperimento.class.getName()).log(Level.SEVERE, null, ex);
            return false;

        }
    }

    @Override
    public List<Experimento> consultar(String orden) {
        try {
            if (orden.isEmpty()) {
                orden = "id_experimento";
            }
            miCadenaSQL = "SELECT id_experimento, cod_inventario, nom_Experimento, marca, foto, manual, acta, costo, "
                    + "fecha_compra FROM inv_experimentos "
                    + "ORDER BY "
                    + orden;

            miConsulta = miObjConexion.prepareStatement(miCadenaSQL);
            misRegistros = miConsulta.executeQuery();
            List<Experimento> arregloExp = new ArrayList<>();

            while (misRegistros.next()) {
                Integer cod = misRegistros.getInt(1);
                String codI = misRegistros.getString(2);
                String nomb = misRegistros.getString(3);
                String mar = misRegistros.getString(4);
                String foto = misRegistros.getString(5);
                Boolean man = misRegistros.getBoolean(6);
                String acta = misRegistros.getString(7);
                Integer costo = misRegistros.getInt(8);
                Date fecha = misRegistros.getDate(9);


                Experimento objExp = new Experimento(cod, codI, nomb, mar, foto, man, acta, costo, fecha);

                arregloExp.add(objExp);
            }
            miObjConexion.close();
            return arregloExp;
        } catch (SQLException ex) {
            Logger.getLogger(DaoExperimento.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public Experimento buscar(Integer llavePrimaria) {
        try {
            miCadenaSQL = "SELECT d.id_experimento, d.cod_inventario, d.nom_Experimento, d.marca, d.foto, d.manual, d.acta, d.costo, "
                    + "d.fecha_compra FROM inv_experimentos d WHERE id_experimento = ?";
            miConsulta = miObjConexion.prepareStatement(miCadenaSQL);
            miConsulta.setInt(1, llavePrimaria);
            misRegistros = miConsulta.executeQuery();

            Experimento objEncontrada = null;
            if (misRegistros.next()) {
                Integer cod = misRegistros.getInt(1);
                String codI = misRegistros.getString(2);
                String nomb = misRegistros.getString(3);
                String mar = misRegistros.getString(4);
                String foto = misRegistros.getString(5);
                Boolean man = misRegistros.getBoolean(6);
                String acta = misRegistros.getString(7);
                Integer costo = misRegistros.getInt(8);
                Date fecha = misRegistros.getDate(9);


                objEncontrada = new Experimento(cod, codI, nomb, mar, foto, man, acta, costo, fecha);

            }
            miObjConexion.close();
            return objEncontrada;
        } catch (SQLException ex) {
            Logger.getLogger(DaoExperimento.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public boolean eliminar(Integer llavePrimaria) {
        try {
            miCadenaSQL = "DELETE FROM inv_experimentos "
                    + "WHERE id_experimento = ?";
            miConsulta = miObjConexion.prepareStatement(miCadenaSQL);
            miConsulta.setInt(1, llavePrimaria);

            miCantidad = miConsulta.executeUpdate();
            miObjConexion.close();
            return miCantidad > 0;
        } catch (SQLException ex) {
            Logger.getLogger(DaoExperimento.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public boolean actualizar(Experimento elObjeto) {
        try {
            miCadenaSQL = "UPDATE inv_experimentos SET cod_inventario = ?, nom_Experimento = ?,"
                    + " marca = ?, foto = ?, manual = ?, acta = ?, costo = ?, fecha_compra = ? "
                    + "WHERE id_experimento = ?";

            miConsulta = miObjConexion.prepareStatement(miCadenaSQL);

            miConsulta.setString(1, elObjeto.getCodInventario());
            miConsulta.setString(2, elObjeto.getNombreExperimento());
            miConsulta.setString(3, elObjeto.getMarcaExperimento());
            miConsulta.setString(4, elObjeto.getFotoExperimento());
            miConsulta.setBoolean(5, elObjeto.getManualExperimento());
            miConsulta.setString(6, elObjeto.getActaExperimento());
            miConsulta.setInt(7, elObjeto.getCostoExperimento());
            long miliSegundos = elObjeto.getFechaCompraExperimento().getTime();
            Date fechaLista = new Date(miliSegundos);
            miConsulta.setDate(8, fechaLista);
            miConsulta.setInt(9, elObjeto.getCodExperimento());

            miCantidad = miConsulta.executeUpdate();

            miObjConexion.close();

            return miCantidad > 0;

        } catch (SQLException ex) {
            Logger.getLogger(DaoExperimento.class.getName()).log(Level.SEVERE, null, ex);

            return false;
        }
    }

    @Override
    public Integer totalRegistros() {
        try {
            miCadenaSQL = "SELECT count(id_experimento) FROM inv_experimentos";
            miConsulta = miObjConexion.prepareStatement(miCadenaSQL);

            misRegistros = miConsulta.executeQuery();

            while (misRegistros.next()) {
                miCantidad = misRegistros.getInt(1);
            }

            miObjConexion.close();

            return miCantidad;

        } catch (SQLException ex) {
            Logger.getLogger(DaoExperimento.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }

    @Override
    public List<Experimento> buscarNombre(String dato, String nombre) {
        try {

            miCadenaSQL = "SELECT d.id_experimento, d.cod_inventario, d.nom_Experimento, d.marca, d.foto, d.manual, d.acta, d.costo, d.fecha_compra "
                    + "FROM inv_experimentos d WHERE " + nombre + " LIKE ? ";
            System.out.println("cadena: " + miCadenaSQL);
            miConsulta = miObjConexion.prepareStatement(miCadenaSQL);
            miConsulta.setString(1, dato);
            misRegistros = miConsulta.executeQuery();

            List<Experimento> arrayExp = new ArrayList<>();

            while (misRegistros.next()) {
              Integer cod = misRegistros.getInt(1);
                String codI = misRegistros.getString(2);
                String nomb = misRegistros.getString(3);
                String mar = misRegistros.getString(4);
                String foto = misRegistros.getString(5);
                Boolean man = misRegistros.getBoolean(6);
                String acta = misRegistros.getString(7);
                Integer costo = misRegistros.getInt(8);
                Date fecha = misRegistros.getDate(9);

                Experimento objExp = new Experimento(cod, codI, nomb, mar, foto, man, acta, costo, fecha);

                arrayExp.add(objExp);
            }
            miObjConexion.close();
            return arrayExp;

        } catch (SQLException ex) {
            Logger.getLogger(DaoExperimento.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

}
