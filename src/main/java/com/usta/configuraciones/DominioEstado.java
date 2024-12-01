package com.usta.configuraciones;

import java.util.HashMap;
import java.util.Map;

public class DominioEstado {

    public final static Map<Integer, String> ARREGLO_ESTADO = new HashMap<Integer, String>() {
        {
            put(0, "Seleccione Uso");
            put(1, "Activo");
            put(2, "Inactivo");
            put(3, "Dar de baja");
        }
    };

}
