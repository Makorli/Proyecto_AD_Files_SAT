package com.company.Modelos;

import java.util.*;

//Enum para recoger el area que registra la incidencia, establecidos por el programa
//El area no debe ser mayor que 15 caracteres.
public class AreasEmpresa {

    private static final Map<Integer,Area> areaMap= new HashMap<>();

    public AreasEmpresa() {

        Area a1 = new Area(1,"Ingeniería");
        Area a2 = new Area(2,"Taller");
        Area a3 = new Area(3,"Compras");
        Area a4 = new Area(4,"RRHH");
        Area a5 = new Area(5,"Administración");
        Area a6 = new Area(6,"TICS");
        Area a7 = new Area(7,"Montaje");
        add(a1);
        add(a2);
        add(a3);
        add(a4);
        add(a5);
        add(a6);
        add(a7);

    }

    public static void add(Area obj) {
        if (!getMap().containsKey(obj.getId())){
            getMap().put(obj.getId(),obj);
        }
    }

    public static List<Area> getLista() {
        return new ArrayList<Area>(getMap().values());
    }

    public static Map<Integer,Area> getMap() {return areaMap;}

    /**
     * Proporciona una Key valida para almacenar en el dicccionario (Id)
     * @return int como Key nueva o -1 si error
     */
    public static int getFreeId(){
        int newKey= -1;
        if (!getMap().isEmpty())
            newKey = (Collections.max(getMap().keySet())) +1 ;
        return newKey;
    }
}
