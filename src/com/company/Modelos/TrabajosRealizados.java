package com.company.Modelos;

import java.util.ArrayList;
import java.util.List;

public class TrabajosRealizados {

    private static final List<Trabajo> trabajoList = new ArrayList<>() {};

    public TrabajosRealizados() {
        /*
        Dedicacion d1 = new Dedicacion(1, 1, "Renovar certificados",2.0);
        Dedicacion d2 = new Dedicacion(1,1,"Modificar ReverseProxy",1.0);
        Dedicacion d3 = new Dedicacion(3,2,"Reconfigurar usuarios servidor",0.5);
        Dedicacion d4 = new Dedicacion(4,3,"Tramitar con proveedor Externo",2.0);
        Dedicacion d5 = new Dedicacion(2,4,"Reprogramar funcion ERP",3.5);
        Dedicacion d6 = new Dedicacion(5,7,"Cambiar teclado",0.5);
        Dedicacion d7 = new Dedicacion(9,3,"Tramitar sutitucion disco",1.0);
        Dedicacion d8 = new Dedicacion(9,3,"Reconfigurar RAID dañado",2.0);
        Dedicacion d9 = new Dedicacion(8,6,"Revision acceso con usuario.",0.5);
        Dedicacion d10 = new Dedicacion(7,7,"Asignar permisos conexion a Ramon",0.5);
        Dedicacion d11 = new Dedicacion(3,2,"Sincronizar permisos PDMLink",3.0);
        Dedicacion d12 = new Dedicacion(3,1,"Reconfigurar servicio SSO",1.0);
    */
    }

    public static void add(Trabajo ded) {
        trabajoList.add(ded);
    }

    public static List<Trabajo> getLista() {
        return trabajoList;
    }
}