package com.company.Main;

import com.company.Miscelaneous.Utils;
import com.company.Modelos.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Generador {

    public static void NuevasIncidencias(int nIncidencias) {
        Generador.NuevasIncidencias.main(new String[] {String.valueOf(nIncidencias)});
    }

    public static void AtenderIncidencias(int nTrabajos) {
        Generador.AtenderIncidencias.main(new String[] {String.valueOf(nTrabajos)});
    }

    /**
     * Generador aleatorio de incidencias en los departamentos.
     * La descripcino de la incidencia se realiza de manera genéricas segun la
     */
    private static class NuevasIncidencias {

        public static void main(String[] args) {

            int nIncidenciasNuevas;

            if (args.length == 0){
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                nIncidenciasNuevas =10;
            } else nIncidenciasNuevas= (Integer.parseInt(args[0]));

            //COMPROBAMOS QUE TENEMOS LOS DATOS NECESARIOS PARA GENERAR LAS INCIDENCIAS ALEATORIAMENTE
            //SI NO LOS TENEMOS EN MEMORIA LO CARGAMOS DE LOS FICHEROS Y SI NO HAY DATOS DEVOLVEMOS ERROR

            // Comprobacion Tipos De incidencias para la descripcion
            boolean check1Ok = false;
            if (TiposDeIncidencias.getLista().size() == 0) {
                CargarFicheros_OOS.FicheroTipoIncidencias();
                //Si la carga ha ido bien correcto
                if (TiposDeIncidencias.getLista().size() > 0) check1Ok = true;
            } else check1Ok = true;

            //Comprobacion de Areas
            boolean check2Ok = false;
            if (AreasEmpresa.getLista().size() == 0) {
                CargarFicheros_OOS.FicheroAreas();
                //Si la carga ha ido bien correcto
                if (AreasEmpresa.getLista().size() > 0) check2Ok = true;
            } else check2Ok = true;

            //Si TENEMOS LOS DATOS MINIMOS PARA GENERAR INCIDENCIAS ALEATORIAMENTE, NOS PONEMOS A ELLO

            if (check1Ok && check2Ok) {
                Random rnd = new Random(); //generador de aleatorios
                int incIdxSel;
                int areaIdxSel;

                System.out.format("\nReportando nuevas %d incidencias\n",nIncidenciasNuevas);

                for (int i = 0; i < nIncidenciasNuevas; i++) {
                    incIdxSel = rnd.nextInt(TiposDeIncidencias.getLista().size()); //Tipo de incidencia
                    areaIdxSel = rnd.nextInt(AreasEmpresa.getLista().size()); // Area de que registra la incidencia.

                    //GENERAMOS UNA NUEVA INCIDENCIA CON LOS DATOS ALEATORIOS Y LA GUARDAMOS EN LA LISTA DE INCIDENCIAS
                    Incidencia nuevaIncidencia = new Incidencia(
                            IncidenciasReportadas.getFreeId(),
                            TiposDeIncidencias.getLista().get(incIdxSel),
                            AreasEmpresa.getLista().get(areaIdxSel).getNombreArea()
                    );

                    //Mostramos la Incidencia en pantalla
                    System.out.format("Incidencia: %-30s\tArea: %s\n",
                            nuevaIncidencia.getDescripcion(),
                            nuevaIncidencia.getArea());

                    //Añadimos la nueva incidencia a las incidencias Reportadas
                    IncidenciasReportadas.add(nuevaIncidencia);
                }

                //Anexamos las nuevas incidencias al fichero de Incidencias
                EscribirFicheros_OOS.FicheroIncidencias();

            } else System.out.println("Imposible generar nuevas incidencias, problemas con los ficheros.");


        }

    }

    /**
     * Clase para aleatorizar gestionar la atención de incidencias abiertas por parte de los
     * técnicos existentes.
     */
    private static class AtenderIncidencias {

        //Generador aleatorio de trabajos y atencion de incidencias abiertas.
        public static void main (String[] args) {

            int nTrabajos;

            if (args.length == 0){
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                nTrabajos =10;
            } else nTrabajos= (Integer.parseInt(args[0]));

            //COMPROBAMOS QUE TENEMOS LOS DATOS NECESARIOS PARA ATENDER LAS INCIDENCIAS ALEATORIAMENTE
            //SI NO LOS TENEMOS EN MEMORIA LO CARGAMOS DE LOS FICHEROS Y SI NO HAY DATOS DEVOLVEMOS ERROR

            List<Trabajo> nuevosTrabajos = new ArrayList<>();
            List<Incidencia> incidenciasCerradas = new ArrayList<>();

            // Comprobacion Tecnicos
            boolean check1Ok = false;
            if (DepartamentoTecnico.getLista().size() == 0) {
                CargarFicheros_OOS.FicheroTecnicos();
                //Si la carga ha ido bien correcto
                if (DepartamentoTecnico.getLista().size() > 0) check1Ok = true;
            } else check1Ok = true;

            //Comprobacion Incidencias
            boolean check2Ok = false;
            if (IncidenciasReportadas.getLista().size() == 0) {
                CargarFicheros_OOS.FicheroIncidencias();
                //Si la carga ha ido bien correcto
                if (IncidenciasReportadas.getLista().size() > 0) check2Ok = true;
            } else check2Ok = true;

            //Si TENEMOS LOS DATOS MINIMOS PARA GENERAR TRABAJOS ALEATORIAMENTE, NOS PONEMOS A ELLO

            if (check1Ok && check2Ok) {
                Random rnd = new Random(); //generador de aleatorios
                int maxHoras =4; //el maximo de horas que un técnico puede dedicar a una incidencia en un día
                int incSelIdx;  //Id de incidencia aleatoria
                int tecSelIdx;  //Id de tecnico aleatorio

                System.out.format("\nAtendiendo %d incidencias\n",nTrabajos);

                for (int i = 0; i < nTrabajos; i++) {

                    incSelIdx = rnd.nextInt(IncidenciasReportadas.getLista().size()); //Incidencia
                    tecSelIdx = rnd.nextInt(DepartamentoTecnico.getLista().size()); // Tecnico que atiende la incidencia.

                    //GENERAMOS EL TRABAJO CON LOS DATOS ALEATORIOS Y LA GUARDAMOS EN LA LISTA DE TRABAJOS
                    Incidencia incidenciaSel = IncidenciasReportadas.getLista().get(incSelIdx);

                    //Si la incidencia elegida está resuelta, elegimos otra.
                    while (incidenciaSel.isResuelta()){
                        incSelIdx = rnd.nextInt(IncidenciasReportadas.getLista().size());
                        incidenciaSel = IncidenciasReportadas.getLista().get(incSelIdx);
                    }

                    Tecnico tecnicoSel = DepartamentoTecnico.getLista().get(tecSelIdx);
                    int horas = rnd.nextInt(maxHoras-1)+1;

                    //Montamos el trabajo
                    Trabajo nuevoTrabajo = new Trabajo(
                            incidenciaSel.getId(),
                            tecnicoSel.getId(),
                            horas
                    );

                    //Mostramos el trabajo en pantalla
                    System.out.format("%s\n\tTecnico: %s\n\tHoras: %d\n",
                            incidenciaSel,
                            tecnicoSel,
                            horas);

                    //Añadimos el trabajo a la lista de nuevosTrabajos
                    nuevosTrabajos.add(nuevoTrabajo);


                    //Preguntamos si el tecnico a terminado la incidencia y
                    // si esta resuelta actualizamos la incidencia y
                    //la añadimos a la lista de incidencias cerradas
                    boolean resuelta = rnd.nextBoolean();


                    if (incidenciaSel.isResuelta())
                        //actualizamos la incidencia
                        incidenciaSel.setResuelta(resuelta);
                        incidenciasCerradas.add(incidenciaSel);

                }

                //FIN DE LOS TRABAJOS

                //Añadimos los trabajos realizados y guardamos el fichero.
                CargarFicheros_OOS.FicheroTrabajos();
                for (Trabajo t: nuevosTrabajos) {
                    TrabajosRealizados.add(t);
                }
                EscribirFicheros_OOS.FicheroTrabajos();

                //Si se han cerrado incidencias cerradas actualizamos el fichero
                if (incidenciasCerradas.size()>0) {
                    EscribirFicheros_OOS.FicheroIncidencias();
                }

            } else System.out.println("Imposible atender incidencias, problemas con los ficheros.");

        }


    }
}
