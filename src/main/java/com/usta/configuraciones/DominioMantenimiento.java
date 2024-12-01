package com.usta.configuraciones;

import java.util.HashMap;
import java.util.Map;

public class DominioMantenimiento {

    public final static Map<Integer, String> ARREGLO_MANTENIMIENTO = new HashMap<Integer, String>() {
        {
            put(0, "Seleccione Mantenimiento");
            put(1, "Semestral");
            put(2, "Bianual");
            put(3, "Anual");
        }
    };

}
