package com.company.Main;

import com.company.Modelos.*;

import java.io.*;
import java.util.List;

/**
 *Clase para generacion de ficheros .dat de los modelos.
 * Leen los datos de una lista de objetos y lo guardan en un fichero utilizando
 * un flujo de datos de objetos
 */
public class EscribirFicheros_OOS {

    //METODOS DE EJECUCION PUBLICOS DE LAS CLASES
    public static void FicheroAreas(){
        EscribirFicheros_OOS.FicheroAreas.main(null);
    }
    public static void FicheroTecnicos(){
        EscribirFicheros_OOS.FicheroTecnicos.main(null);
    }
    public static void FicheroIncidencias(){
        EscribirFicheros_OOS.FicheroIncidencias.main(null);
    }
    public static void FicheroTrabajos(){
        EscribirFicheros_OOS.FicheroTrabajos.main(null);
    }
    public static void FicheroTipoIncidencias(){
        EscribirFicheros_OOS.FicheroTipoIncidencias.main(null);
    }


    //INNER CLASSES

    /**
     * Clase de ecritura de datos de tipo Area en un fichero
     */
    private static class FicheroAreas {

        private static final String nombrefichero = "src/com/company/Data/Areas.dat";
        private static final List<Area> listaDeCarga= AreasEmpresa.getLista();

        public static void main(String[] args) {
            //GENERAMOS EL FLUJO DE DATOS PARA ESCRITURA EN EL FICHERO
            ObjectOutputStream objectOutputStream = null;

            try {
                objectOutputStream = new ObjectOutputStream(new FileOutputStream(nombrefichero));

                //RECORREMOS LA LISTA
                for (Area a : listaDeCarga) {
                    objectOutputStream.writeObject(a);
                }
                //CERRAMOS FICHERO
                objectOutputStream.close();

            } catch (FileNotFoundException f) {
                System.out.format("Creando fichero no encontrado: %s\n", nombrefichero);
            } catch (IOException io) {
                System.out.format("Error E/S en %s\n", nombrefichero);
            }
        }
    }

    /**
     * Clase de ecritura de datos de tipo Tecnico en un fichero
     */
    private static class FicheroTecnicos {

        private static final String nombrefichero = "src/com/company/Data/Tecnicos.dat";
        private static final List<Tecnico> listaDeCarga= DepartamentoTecnico.getLista();

        public static void main(String[] args) {

            //GENERAMOS EL FLUJO DE DATOS PARA ESCRITURA EN EL FICHERO
            ObjectOutputStream objectOutputStream = null;

            try {
                objectOutputStream = new ObjectOutputStream(new FileOutputStream(nombrefichero));

                //RECORREMOS LA LISTA
                for (Tecnico a : listaDeCarga) {
                    objectOutputStream.writeObject(a);
                }
                //CERRAMOS FICHERO
                objectOutputStream.close();

            } catch (FileNotFoundException f) {
                System.out.format("Creando fichero no encontrado: %s\n", nombrefichero);
            } catch (IOException io) {
                System.out.format("Error E/S en %s\n", nombrefichero);
            }
        }
    }

    /**
     * Clase de ecritura de datos de tipo Incidencia en un fichero
     */
    private static class FicheroIncidencias {

        private static final String nombrefichero = "src/com/company/Data/Incidencias.dat";
        private static final List<Incidencia> listaDeCarga= IncidenciasReportadas.getLista();

        public static void main(String[] args) {
            //GENERAMOS EL FLUJO DE DATOS PARA ESCRITURA EN EL FICHERO
            ObjectOutputStream objectOutputStream = null;

            try {
                objectOutputStream = new ObjectOutputStream(new FileOutputStream(nombrefichero));

                //RECORREMOS LA LISTA
                for (Incidencia a : listaDeCarga) {
                    objectOutputStream.writeObject(a);
                }
                //CERRAMOS FICHERO
                objectOutputStream.close();

            } catch (FileNotFoundException f) {
                System.out.format("Creando fichero no encontrado: %s\n", nombrefichero);
            } catch (IOException io) {
                System.out.format("Error E/S en %s\n", nombrefichero);
            }
        }
    }

    /**
     * Clase de ecritura de datos de tipo Trabajo en un fichero
     */
    private static class FicheroTrabajos {

        private static final String nombrefichero = "src/com/company/Data/Trabajos.dat";
        private static final List<Trabajo> listaDeCarga= TrabajosRealizados.getLista();

        public static void main(String[] args) {
            //GENERAMOS EL FLUJO DE DATOS PARA ESCRITURA EN EL FICHERO
            ObjectOutputStream objectOutputStream = null;

            try {
                objectOutputStream = new ObjectOutputStream(new FileOutputStream(nombrefichero));

                //RECORREMOS LA LISTA
                for (Trabajo a : listaDeCarga) {
                    objectOutputStream.writeObject(a);
                }
                //CERRAMOS FICHERO
                objectOutputStream.close();

            } catch (FileNotFoundException f) {
                System.out.format("Creando fichero no encontrado: %s\n", nombrefichero);
            } catch (IOException io) {
                System.out.format("Error E/S en %s\n", nombrefichero);
            }
        }
    }

    /**
     * Clase de ecritura de datos de tipo Trabajo en un fichero
     */
    private static class FicheroTipoIncidencias {

        private static final String nombrefichero = "src/com/company/Data/TiposDeIncidencia.dat";
        private static final List<String> listaDeCarga= TiposDeIncidencias.getLista();

        public static void main(String[] args) {
            //GENERAMOS EL FLUJO DE DATOS PARA ESCRITURA EN EL FICHERO
            ObjectOutputStream objectOutputStream = null;

            try {
                objectOutputStream = new ObjectOutputStream(new FileOutputStream(nombrefichero));

                //RECORREMOS LA LISTA
                for (String a : listaDeCarga) {
                    objectOutputStream.writeObject(a);
                }
                //CERRAMOS FICHERO
                objectOutputStream.close();

            } catch (FileNotFoundException f) {
                System.out.format("Creando fichero no encontrado: %s\n", nombrefichero);
            } catch (IOException io) {
                System.out.format("Error E/S en %s\n", nombrefichero);
            }
        }
    }

    public static void main(String[] args) {
        FicheroAreas();
        FicheroTecnicos();
        FicheroIncidencias();
        FicheroTrabajos();
        FicheroTipoIncidencias();
    }

}
