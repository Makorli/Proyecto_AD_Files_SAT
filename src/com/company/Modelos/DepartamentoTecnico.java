package com.company.Modelos;

import java.util.*;

public class DepartamentoTecnico {

    private static Map<Integer, Tecnico> tecnicoMap = new HashMap<>();

    public DepartamentoTecnico() {
/*
        Tecnico t1 = new Tecnico(1,"Juanjo");
        Tecnico t2 = new Tecnico(2,"Karmen");
        Tecnico t3 = new Tecnico(3,"Blanca");
        Tecnico t4 = new Tecnico(4,"Dominique");
        Tecnico t5 = new Tecnico(5,"Mikel");
        Tecnico t6 = new Tecnico(6,"Gorka");
        Tecnico t7 = new Tecnico(7,"Nuria");
        tecnicoMap.put(t1.getId(),t1);
        tecnicoMap.put(t2.getId(),t2);
        tecnicoMap.put(t3.getId(),t3);
        tecnicoMap.put(t4.getId(),t4);
        tecnicoMap.put(t5.getId(),t5);
        tecnicoMap.put(t6.getId(),t6);
        tecnicoMap.put(t7.getId(),t7);
*/
    }

    public static void add(Tecnico obj) {
        if (!getMap().containsKey(obj.getId())){
            getMap().put(obj.getId(),obj);
        }
    }

    /**
     * Actualiza y devuelve la lista asociada al Map con los valores asociados
     * @return lista
     */
    public static List<Tecnico> getLista() {
        return new ArrayList<>(getMap().values());
    }

    public static Map<Integer, Tecnico> getMap(){ return tecnicoMap; }

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
