package com.company.Controlador;


import com.company.Main.CargarFicheros_OOS;
import com.company.Modelos.*;

import java.sql.SQLOutput;
import java.util.List;

/**
 * Clase que genera los datos estadisticos requeridos por la aplicacion
 */
public class Controller {

    /**
     * Muestra por cada técnico
     *      El número de incidencias atendidas
     *      Acumulado de incidencias cerradas.
     *      Incidencias atendidas
     *      Horas promedio de inversión de horas en las incidencias
     */
    /*
    public static void TecnicosEstadisticas(){

        //Cargamos los ficheros en memoria para manipular y obtener los datos

        CargarFicheros_OOS.FicheroTecnicos();
        CargarFicheros_OOS.FicheroTipoIncidencias();
        CargarFicheros_OOS.FicheroTrabajos();

        ControllerTecnicos ct = new ControllerTecnicos();

        //Generación de estadísticas
        System.out.println("*  *  *  *  E  S T  D  I  S  T  I  C  A  S    P  O  R    T  É  C  N  I  C  O  *  *  *  *");
        for (Tecnico tecnico: ct.getAllTecnicos()) {
            System.out.println();
            System.out.format("ID: %d Nombre: %s", t.getId(), t.getNombre());
            System.out.println();

            List<Incidencia> incidenciasList = IncidenciasReportadas.getLista();
            List<Trabajo> trabajosList = TrabajosRealizados.getLista();


            //Recorremos los trabajos
            for (Trabajo trabajo : trabajosList) {
                //Leemos el tecnico del trabajo
                Tecnico miTecnico = DepartamentoTecnico.getMap().get(trabajo.getIdTecnico());

                //Si el tecnico es el mismo
                if (miTecnico.getId() == tecnico.getId()) {

                    //Obtenemos la incidencia del trabajo realizado
                    Incidencia incidencia = IncidenciasReportadas.getMap().get(trabajo.getIdIncidencia());

                    //Mostramos los datos del técnico
                    System.out.format("ID: %d\tNombre: %s", );

                    //Mostramos los datos relevantes de la incidencia
                    System.out.format("Descripcion: %-30s\t Area: %s ",
                            incidencia.getDescripcion(),
                            incidencia.getArea());

                }

            }
        }

     */
}
