package com.usta.configuraciones;

import java.util.HashMap;
import java.util.Map;

public class DominioRequerimiento {

    public final static Map<Integer, String> ARREGLO_REQUERIMIENTO = new HashMap<Integer, String>() {
        {
            put(0, "Seleccione Requerimiento");
            put(1, "Preventivo");
            put(2, "Correctivo");
            put(3, "Calibración");
        }
    };

}
