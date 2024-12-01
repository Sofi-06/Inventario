
package com.usta.daos;

import com.usta.configuraciones.MiConexion;
import com.usta.entities.Encabezado;
import com.usta.entities.Persona;
import com.usta.interfaces.Funcionalidad;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class DaoEncabezado extends MiConexion implements Funcionalidad<Encabezado> {

    @Override
    public boolean registrar(Encabezado elObjeto) {
        
        return false;
        
    }

    @Override
    public List<Encabezado> consultar(String orden) {
        return null;
      }

    @Override
    public Encabezado buscar(Integer llavePrimaria) {
        try {
            miCadenaSQL = "SELECT a.id_encabezado, a.edificio, a.laboratorio, a.semestre, a.fecha_actualizacion, "
                    + "p.id_persona, p.nomBRE "
                    + "FROM encabezados a INNER JOIN personas p "
                    + " ON a.id_persona = p.id_persona "
                    + "WHERE id_encabezado=?";
            miConsulta = miObjConexion.prepareStatement(miCadenaSQL);
            miConsulta.setInt(1, llavePrimaria);

            misRegistros = miConsulta.executeQuery();

            Encabezado objEncontrado = null;

            if (misRegistros.next()) {
                int cod = misRegistros.getInt(1);
                String edi = misRegistros.getString(2);
                String lab = misRegistros.getString(3);
                String sem = misRegistros.getString(4);
                Date fecha = misRegistros.getDate(5);
                
                // FORANEAS
            
                int codP = misRegistros.getInt(6);
                String nomP = misRegistros.getString(7);

                Persona objPersona = new Persona(codP, nomP, "","","", "", "","", "");

                objEncontrado = new Encabezado(cod, edi, lab, sem, fecha, objPersona);
            }
            miObjConexion.close();
            return objEncontrado;

        } catch (SQLException ex) {
            Logger.getLogger(DaoEncabezado.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public boolean eliminar(Integer llavePrimaria) {
        return false;
        }

    @Override
    public boolean actualizar(Encabezado elObjeto) {
        try {
            miCadenaSQL = "UPDATE encabezados SET edificio = ?, laboratorio = ?, semestre = ?, "
                    + "fecha_actualizacion = ?, id_persona = ? WHERE id_encabezado = ?";

            miConsulta = miObjConexion.prepareStatement(miCadenaSQL);

            miConsulta.setString(1, elObjeto.getEdificioEncabezado());
            miConsulta.setString(2, elObjeto.getLaboratorioEncabezado());
            miConsulta.setString(3, elObjeto.getSemestreEncabezado());
            
            long miliSegundos = elObjeto.getFechaActualizacionEncabezado().getTime();
            Date fechaLista = new Date(miliSegundos);
            miConsulta.setDate(4, fechaLista);
            
            miConsulta.setInt(5, elObjeto.getCodPersona().getCodPersona());
            miConsulta.setInt(6, elObjeto.getCodEncabezado());

            miCantidad = miConsulta.executeUpdate();

            miObjConexion.close();

            return miCantidad > 0;

        } catch (SQLException ex) {
            Logger.getLogger(DaoEncabezado.class.getName()).log(Level.SEVERE, null, ex);

            return false;
        }
    }

    @Override
    public Integer totalRegistros() {
        return null;
     }

    @Override
    public List<Encabezado> buscarNombre(String dato, String nombre) {
        return null;
        }
    
}
