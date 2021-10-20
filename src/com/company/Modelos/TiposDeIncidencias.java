package com.company.Modelos;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase para almacenamiento genérico de las incidencias.
 */
public class TiposDeIncidencias {

    //Lista de Tipos de incidencia el indice de la tabla actua como ID de la misma
    private static final List<String> tiposdeincidencialist = new ArrayList<>();

    public TiposDeIncidencias() {

        tiposdeincidencialist.add("Problema Hardware");
        tiposdeincidencialist.add("Error de acceso");
        tiposdeincidencialist.add("Problema de SW");
        tiposdeincidencialist.add("Error página Web");
        tiposdeincidencialist.add("Error certificados");
        tiposdeincidencialist.add("Fallo metodología");
        tiposdeincidencialist.add("Problema red");
        tiposdeincidencialist.add("Usuario problematico");

    }

    public static void add(String inc) {
        tiposdeincidencialist.add(inc);
    }

    public static List<String> getLista() {
        return tiposdeincidencialist;
    }
}
