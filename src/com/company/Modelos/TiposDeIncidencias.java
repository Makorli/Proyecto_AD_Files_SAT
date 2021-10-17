package com.company.Modelos;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase para almacenamiento genérico de las incidencias.
 */
public class TiposDeIncidencias {

    //Lista de Tipos de incidencia el indice de la tabla actua como ID de la misma
    private static final List<String> tiposdeincidencialist = new ArrayList<>(){};

    public TiposDeIncidencias() {
    }

    public static void add(String inc) {
        tiposdeincidencialist.add(inc);
    }

    public static List<String> getLista() {
        return tiposdeincidencialist;
    }
}
