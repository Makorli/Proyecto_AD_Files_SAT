package com.company.Modelos;

import java.util.*;

public class IncidenciasReportadas {

    private static final Map<Integer,Incidencia> incidenciaMap = new HashMap<>();

    public IncidenciasReportadas() {
        /*
        Incidencia i1 = new Incidencia(1,"Falla acceso Web proveedores","Compras");
        Incidencia i2 = new Incidencia(2,"Errores en Lista de materiales","Almacen");
        Incidencia i3 = new Incidencia(3,"Falla PLM","Ingenieria");
        Incidencia i4 = new Incidencia(4,"No funciona el envio SII","Financiero");
        Incidencia i5 = new Incidencia(6,"Teclado no funciona equipo en taller","Taller");
        Incidencia i6 = new Incidencia(6,"Impresora bloqueada","Compras");
        Incidencia i7 = new Incidencia(7,"No le funciona la VPN a Ramón","PeM");
        Incidencia i8 = new Incidencia(8,"SBO sin acceso","Financiero");
        Incidencia i9 = new Incidencia(9,"Fallo disco servidor Oracle","TICs");
        add(i1);
        add(i2);
        add(i3);
        add(i4);
        add(i5);
        add(i6);
        add(i7);
        add(i8);
        add(i9);

         */

    }

    public static void add(Incidencia obj) {
        if (!getMap().containsKey(obj.getId())){
            getMap().put(obj.getId(),obj);
        }
    }

    public static List<Incidencia> getLista() {
        return new ArrayList<Incidencia>(getMap().values());

    }

    public static Map<Integer, Incidencia> getMap() { return incidenciaMap; }

    /**
     * Proporciona una Key valida para almacenar en el dicccionario (Id)
     * @return int como Key nueva o -1 si error
     */
    public static int getFreeId(){
        int newKey= -1;
        if (!getMap().isEmpty())
            newKey = (Collections.max(getMap().keySet())) +1 ;
        return newKey;
    }}
