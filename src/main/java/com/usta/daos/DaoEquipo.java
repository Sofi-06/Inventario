
package com.usta.daos;

import com.usta.configuraciones.MiConexion;
import com.usta.entities.Elemento;
import com.usta.entities.Equipo;
import com.usta.entities.Experimento;
import com.usta.interfaces.Funcionalidad;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class DaoEquipo extends MiConexion implements Funcionalidad<Equipo> {

    @Override
    public boolean registrar(Equipo elObjeto) {
        try {
            miCadenaSQL = "INSERT INTO inv_equipos(nom_equipo, inventario, modelo, serie, marca, "
                    + "list_mantenimiento, list_req_mantenimiento, list_estado)"
                    + "values(?,?,?,?,?,?,?,?)";
            miConsulta = miObjConexion.prepareStatement(miCadenaSQL);
            
            miConsulta.setString(1, elObjeto.getNombreEquipo());                       
            miConsulta.setString(2, elObjeto.getInventarioEquipo());                       
            miConsulta.setString(3, elObjeto.getModeloEquipo());                       
            miConsulta.setString(4, elObjeto.getSerieEquipo());                       
            miConsulta.setString(5, elObjeto.getMarcaEquipo());                       
            miConsulta.setString(6, elObjeto.getMantemimientoEquipo());                       
            miConsulta.setString(7, elObjeto.getReqMantemimientoEquipo());                       
            miConsulta.setString(8, elObjeto.getEstadoEquipo());                       

            
            miCantidad = miConsulta.executeUpdate();
            miObjConexion.close();
            return miCantidad > 0;
        } catch (SQLException ex) {
            Logger.getLogger(DaoEquipo.class.getName()).log(Level.SEVERE, null, ex);
            return false;
            
        } 
    }

    @Override
    public List<Equipo> consultar(String orden) {
        try {
            if (orden.isEmpty()) {
                orden = "id_equipo";
            }
           miCadenaSQL = "SELECT id_equipo, nom_equipo, inventario, modelo, serie, marca, "
                    + "list_mantenimiento, list_req_mantenimiento, list_estado FROM inv_equipos "
                    + "ORDER BY "
                    + orden;
            
            miConsulta = miObjConexion.prepareStatement(miCadenaSQL);
            misRegistros = miConsulta.executeQuery();
            List<Equipo> arregloEqu = new ArrayList<>();
            
            while (misRegistros.next()) {
                Integer cod = misRegistros.getInt(1);
                String nombre = misRegistros.getString(2);
                String inv = misRegistros.getString(3);
                String mod = misRegistros.getString(4);
                String ser = misRegistros.getString(5);
                String mar = misRegistros.getString(6);
                String man = misRegistros.getString(7);
                String req = misRegistros.getString(8);
                String est = misRegistros.getString(9);


                
                Equipo objEq = new Equipo(cod, nombre, inv, mod, ser, mar, man, req, est);
                
                    arregloEqu.add(objEq);
            }
            miObjConexion.close();
            return arregloEqu;
        } catch (SQLException ex) {
            Logger.getLogger(DaoEquipo.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public Equipo buscar(Integer llavePrimaria) {
       try {
             miCadenaSQL = "SELECT id_equipo, nom_equipo, inventario, modelo, serie, marca, "
                    + "list_mantenimiento, list_req_mantenimiento, list_estado FROM inv_equipos WHERE id_equipo = ?";
            miConsulta = miObjConexion.prepareStatement(miCadenaSQL);
            miConsulta.setInt(1, llavePrimaria);
            misRegistros = miConsulta.executeQuery();

            Equipo objEncontrada = null;
            if (misRegistros.next()) {
                Integer cod = misRegistros.getInt(1);
                String nombre = misRegistros.getString(2);
                String inv = misRegistros.getString(3);
                String mod = misRegistros.getString(4);
                String ser = misRegistros.getString(5);
                String mar = misRegistros.getString(6);
                String man = misRegistros.getString(7);
                String req = misRegistros.getString(8);
                String est = misRegistros.getString(9);

                objEncontrada = new Equipo(cod, nombre, inv, mod, ser, mar, man, req, est);;


            }
            miObjConexion.close();
            return objEncontrada;
        } catch (SQLException ex) {
            Logger.getLogger(DaoEquipo.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public boolean eliminar(Integer llavePrimaria) {
      try {
            miCadenaSQL = "DELETE FROM inv_equipos "
                    + "WHERE id_equipo = ?";
            miConsulta = miObjConexion.prepareStatement(miCadenaSQL);
            miConsulta.setInt(1, llavePrimaria);
            
            miCantidad = miConsulta.executeUpdate();
            miObjConexion.close();
            return miCantidad > 0;
        } catch (SQLException ex) {
            Logger.getLogger(DaoEquipo.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }  }

    @Override
    public boolean actualizar(Equipo elObjeto) {
        try {
            miCadenaSQL = "UPDATE inv_equipos SET nom_equipo = ?, inventario = ?, modelo = ?, serie = ?, marca = ?, "
                    + "list_mantenimiento = ?, list_req_mantenimiento = ?, list_estado = ? "
                    + "WHERE id_equipo = ?";

            miConsulta = miObjConexion.prepareStatement(miCadenaSQL);

            miConsulta.setString(1, elObjeto.getNombreEquipo());                       
            miConsulta.setString(2, elObjeto.getInventarioEquipo());                       
            miConsulta.setString(3, elObjeto.getModeloEquipo());                       
            miConsulta.setString(4, elObjeto.getSerieEquipo());                       
            miConsulta.setString(5, elObjeto.getMarcaEquipo());                       
            miConsulta.setString(6, elObjeto.getMantemimientoEquipo());                       
            miConsulta.setString(7, elObjeto.getReqMantemimientoEquipo());                       
            miConsulta.setString(8, elObjeto.getEstadoEquipo()); 
            miConsulta.setInt(9, elObjeto.getCodEquipo()); 
            

            miCantidad = miConsulta.executeUpdate();

            miObjConexion.close();

            return miCantidad > 0;

        } catch (SQLException ex) {
            Logger.getLogger(DaoEquipo.class.getName()).log(Level.SEVERE, null, ex);

            return false;
        } 
    }

    @Override
    public Integer totalRegistros() {
        try {
            miCadenaSQL = "SELECT count(id_equipo) FROM inv_equipos";
            miConsulta = miObjConexion.prepareStatement(miCadenaSQL);

            misRegistros = miConsulta.executeQuery();

            while (misRegistros.next()) {
                miCantidad = misRegistros.getInt(1);
            }

            miObjConexion.close();

            return miCantidad;

        } catch (SQLException ex) {
            Logger.getLogger(DaoEquipo.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }

    @Override
    public List<Equipo> buscarNombre(String dato, String nombre) {
        try {

             miCadenaSQL = "SELECT id_equipo, nom_equipo, inventario, modelo, serie, marca, "
                    + "list_mantenimiento, list_req_mantenimiento, list_estado FROM inv_equipos WHERE " + nombre + " LIKE ? ";
            
            System.out.println("cadena: " + miCadenaSQL);
            miConsulta = miObjConexion.prepareStatement(miCadenaSQL);
            miConsulta.setString(1, dato);
            misRegistros = miConsulta.executeQuery();

            List<Equipo> arrayEqui = new ArrayList<>();

            while (misRegistros.next()) {
                Integer cod = misRegistros.getInt(1);
                String nomb = misRegistros.getString(2);
                String inv = misRegistros.getString(3);
                String mod = misRegistros.getString(4);
                String ser = misRegistros.getString(5);
                String mar = misRegistros.getString(6);
                String man = misRegistros.getString(7);
                String req = misRegistros.getString(8);
                String est = misRegistros.getString(9);


                
                Equipo objEq = new Equipo(cod, nomb, inv, mod, ser, mar, man, req, est);
                
                    arrayEqui.add(objEq);
            }
            miObjConexion.close();
            return arrayEqui;

        } catch (SQLException ex) {
            Logger.getLogger(DaoEquipo.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
}
