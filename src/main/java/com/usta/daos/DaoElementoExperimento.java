package com.usta.daos;

import com.usta.configuraciones.MiConexion;
import com.usta.entities.Elemento;
import com.usta.entities.ElementoExperimento;
import com.usta.entities.Experimento;
import com.usta.interfaces.Funcionalidad;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DaoElementoExperimento extends MiConexion implements Funcionalidad<ElementoExperimento> {

    @Override
    public boolean registrar(ElementoExperimento elObjeto) {
        try {
            miCadenaSQL = "INSERT INTO elementos_invexperimentos (id_elemento, id_experimento, cantidad_accesorios) VALUES (?, ?,?)";

            miConsulta = miObjConexion.prepareStatement(miCadenaSQL);

            miConsulta.setInt(1, elObjeto.getCodElemento().getCodElemento());
            miConsulta.setInt(2, elObjeto.getCodExperimento().getCodExperimento());
            miConsulta.setInt(3, elObjeto.getCantAccesorios());

            miCantidad = miConsulta.executeUpdate();

            miObjConexion.close();

            return miCantidad > 0;

        } catch (SQLException ex) {
            Logger.getLogger(DaoElementoExperimento.class.getName()).log(Level.ALL.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public List<ElementoExperimento> consultar(String orden) {
        try {
            if (orden.isEmpty()) {
                orden = "id_elemento_experimento";
            }
            miCadenaSQL = "SELECT ei.id_elemento_experimento, ei.id_elemento, ei.id_experimento, e.nom_elemento, x.nom_experimento,"
                    + " ei.cantidad_accesorios, x.cod_inventario, x.marca, x.foto, x.manual, x.acta, x.costo, x.fecha_compra "
                    + "FROM elementos_invexperimentos ei\n"
                    + "INNER JOIN elementos e ON ei.id_elemento = e.id_elemento\n"
                    + "INNER JOIN inv_experimentos x ON ei.id_experimento = x.id_experimento\n"
                    + "ORDER BY " + orden;

            List<ElementoExperimento> arregloElex = new ArrayList<>();
            miConsulta = miObjConexion.prepareStatement(miCadenaSQL);
            misRegistros = miConsulta.executeQuery();

            while (misRegistros.next()) {
                int codee = misRegistros.getInt(1);
                int code = misRegistros.getInt(2);
                int codx = misRegistros.getInt(3);
                String nombreElemento = misRegistros.getString(4);
                String nombreExperimento = misRegistros.getString(5);
                int cant = misRegistros.getInt(6);
                String codinv = misRegistros.getString(7);
                String marca = misRegistros.getString(8);
                String foto = misRegistros.getString(9);
                Boolean manual = misRegistros.getBoolean(10);
                String acta = misRegistros.getString(11);
                Integer costo = misRegistros.getInt(12);
                Date fecha = misRegistros.getDate(13);

                Elemento objEl = new Elemento(code, nombreElemento, "", 0, "");
                Experimento objEx = new Experimento(codx, codinv, nombreExperimento, marca, foto, manual, acta, costo, fecha);
                ElementoExperimento objElEx = new ElementoExperimento(codee, objEl, objEx, cant);

                arregloElex.add(objElEx);

            }
            miObjConexion.close();
            return arregloElex;

        } catch (SQLException ex) {
            Logger.getLogger(DaoElementoExperimento.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public ElementoExperimento buscar(Integer llavePrimaria) {
        try {
            miCadenaSQL = "SELECT ei.id_elemento_experimento, ei.id_elemento, ei.id_experimento, e.nom_elemento, x.nom_experimento,"
                    + " ei.cantidad_accesorios\n"
                    + "FROM elementos_invexperimentos ei "
                    + "INNER JOIN elementos e ON ei.id_elemento = e.id_elemento "
                    + "INNER JOIN inv_experimentos x ON ei.id_experimento = x.id_experimento "
                    + "WHERE id_elemento_experimento = ?";
            miConsulta = miObjConexion.prepareStatement(miCadenaSQL);
            miConsulta.setInt(1, llavePrimaria);
            misRegistros = miConsulta.executeQuery();

            ElementoExperimento objEncontrada = null;
            if (misRegistros.next()) {
                int codee = misRegistros.getInt(1);
                int code = misRegistros.getInt(2);
                int codx = misRegistros.getInt(3);
                int cant = misRegistros.getInt(4);

                Elemento objEl = new Elemento(code, "", "", 0, "");
                Experimento objEx = new Experimento(codx, "", "", "", "", false, "", 0, null);
                objEncontrada = new ElementoExperimento(codee, objEl, objEx, cant);

            }
            miObjConexion.close();
            return objEncontrada;
        } catch (SQLException ex) {
            Logger.getLogger(DaoElementoExperimento.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public boolean eliminar(Integer llavePrimaria) {
        try {
            miCadenaSQL = "DELETE FROM elementos_invexperimentos WHERE id_elemento = ?";
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
    public boolean actualizar(ElementoExperimento elObjeto) {
        try {
            miCadenaSQL = "UPDATE elementos_invexperimentos SET id_elemento = ?, id_experimento = ?, cantidad_accesorios = ? WHERE id_elemento_experimento = ?";

            miConsulta = miObjConexion.prepareStatement(miCadenaSQL);

            miConsulta.setInt(1, elObjeto.getCodElemento().getCodElemento());
            miConsulta.setInt(2, elObjeto.getCodExperimento().getCodExperimento());
            miConsulta.setInt(3, elObjeto.getCantAccesorios());

            // Manejar el caso en que getCodElementoExperimento() devuelva null
            if (elObjeto.getCodElementoExperimento() != null) {
                miConsulta.setInt(4, elObjeto.getCodElementoExperimento());
            } else {
                throw new SQLException("El código del elemento experimento es nulo");
            }

            miCantidad = miConsulta.executeUpdate();

            miObjConexion.close();

            return miCantidad > 0;

        } catch (SQLException ex) {
            Logger.getLogger(DaoElementoExperimento.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public Integer totalRegistros() {
        return 0;
    }

    @Override
    public List<ElementoExperimento> buscarNombre(String dato, String nombre) {
        try {
            // Corregir la consulta SQL y asegurar que todo esté bien concatenado
            miCadenaSQL = "SELECT ei.id_elemento_experimento, ei.id_elemento, ei.id_experimento, e.nombre_elemento, "
                    + "x.nom_experimento, x.marca, x.cod_inventario, ei.cantidad_accesorios, x.foto_experimento, "
                    + "x.manual_experimento, x.acta_experimento, x.costo_experimento, x.fecha_compra_experimento "
                    + "FROM elementos_invexperimentos ei "
                    + "INNER JOIN elementos e ON ei.id_elemento = e.id_elemento "
                    + "INNER JOIN inv_experimentos x ON ei.id_experimento = x.id_experimento "
                    + "WHERE " + nombre + " LIKE ?";
            System.out.println("cadena: " + miCadenaSQL);
            miConsulta = miObjConexion.prepareStatement(miCadenaSQL);
            miConsulta.setString(1, "%" + dato + "%"); // Asegúrate de usar % para búsquedas parciales
            misRegistros = miConsulta.executeQuery();

            List<ElementoExperimento> arrayElex = new ArrayList<>();

            while (misRegistros.next()) {
                int codee = misRegistros.getInt(1);
                int code = misRegistros.getInt(2);
                int codx = misRegistros.getInt(3);
                String nombreElemento = misRegistros.getString(4);
                String nombreExperimento = misRegistros.getString(5);
                String marca = misRegistros.getString(6);
                String codinv = misRegistros.getString(7);
                int cant = misRegistros.getInt(8);
                String foto = misRegistros.getString(9);
                boolean manual = misRegistros.getBoolean(10);
                String acta = misRegistros.getString(11);
                int costo = misRegistros.getInt(12);
                Date fecha = misRegistros.getDate(13);

                Elemento objEl = new Elemento(code, nombreElemento, "", 0, "");
                Experimento objEx = new Experimento(codx, codinv, nombreExperimento, marca, foto, manual, acta, costo, fecha);
                ElementoExperimento objElEx = new ElementoExperimento(codee, objEl, objEx, cant);
                arrayElex.add(objElEx);
            }
            miObjConexion.close();
            return arrayElex;
        } catch (SQLException ex) {
            Logger.getLogger(DaoElementoExperimento.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public List<ElementoExperimento> consultarNombresPorExp(Integer codExp) {
        List<ElementoExperimento> arrayElex = new ArrayList<>();

        try {
            miCadenaSQL = "SELECT ex.id_elemento_experimento, ex.id_elemento, e.nom_elemento, ex.cantidad_accesorios FROM elementos_invExperimentos ex "
                    + "INNER JOIN elementos e ON ex.id_elemento = e.id_elemento WHERE id_experimento = ?";
            miConsulta = miObjConexion.prepareStatement(miCadenaSQL);
            miConsulta.setInt(1, codExp);

            misRegistros = miConsulta.executeQuery();

            while (misRegistros.next()) {
                int idElementoExp = misRegistros.getInt(1);
                int idElemento = misRegistros.getInt(2);
                String nombreElemento = misRegistros.getString(3);
                int cantidadAccesorios = misRegistros.getInt(4);

                Elemento objEl = new Elemento(idElemento, nombreElemento, "", 0, "");
                Experimento objEx = new Experimento(codExp, "", "", "", "", false, "", 0, null); // Asumiendo que el primer parámetro es el código del experimento
                ElementoExperimento objElEx = new ElementoExperimento(idElementoExp, objEl, objEx, cantidadAccesorios);
                arrayElex.add(objElEx);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DaoElementoExperimento.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (misRegistros != null) {
                    misRegistros.close();
                }
                if (miConsulta != null) {
                    miConsulta.close();
                }
                if (miObjConexion != null) {
                    miObjConexion.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(DaoElemento.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return arrayElex;
    }

}
