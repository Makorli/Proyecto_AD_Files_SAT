package com.company.Main;

import com.company.Modelos.*;

import java.io.*;
import java.util.List;
import java.util.Map;

/**
 *Clase para carga de ficheros .dat en las clases de almacenamiento que contienen las listas
 * Leen los datos de un fichero y lo guardan en la lista de objetos correspondiente utilizando
 * un flujo de datos de objetos
 */
public class CargarFicheros_OOS {

    //METODOS DE EJECUCION PUBLICOS DE LAS CLASES
    public static void FicheroAreas(){
        CargarFicheros_OOS.FicheroAreas.main(null);
    }
    public static void FicheroTecnicos(){
        CargarFicheros_OOS.FicheroTecnicos.main(null);
    }
    public static void FicheroIncidencias(){
        CargarFicheros_OOS.FicheroIncidencias.main(null);
    }
    public static void FicheroTrabajos(){ CargarFicheros_OOS.FicheroTrabajos.main(null); }
    public static void FicheroTipoIncidencias(){
        CargarFicheros_OOS.FicheroTipoIncidencias.main(null);
    }


    /**
     * Clase de lectura y carga de datos  de un fichero a una lista con Ojetos de tipo Area
     */
    private static class FicheroAreas{

        private static final String nombrefichero = "src/com/company/Data/Areas.dat";
        private static final Map<Integer, Area> objectMap = AreasEmpresa.getMap();

        public static void main(String[] args) {
            //GENERAMOS EL FLUJO DE DATOS PARA LECTURA DEL FICHERO
            ObjectInputStream objectInputStream = null;

            try {
                objectInputStream = new ObjectInputStream(new FileInputStream(nombrefichero));

                //RECORREMOS EL FICHERO Y LO CARGAMOS EN LA LISTA CORRESPONDIENTE
                Area a = null;
                try{
                    boolean primeravez=true;
                    while (true){
                        if (primeravez){
                            objectMap.clear();
                            primeravez=false;
                        }
                        a = (Area) objectInputStream.readObject();
                        if (!objectMap.containsKey(a.getId())){
                            objectMap.put(a.getId(),a);
                        }
                    }
                }
                catch(EOFException e){
                    System.out.format("Fin de carga fichero %s\n",nombrefichero);
                }  //Salimos del bucle de lectura.
                catch (ClassNotFoundException e) {
                    System.out.println("Clase almacenada incorrecta");
                }

                //CERRAMOS FICHERO
                objectInputStream.close();

            } catch (FileNotFoundException f) {
                System.out.format("Fichero %s no encontrado\n", nombrefichero);
            } catch (IOException io) {
                System.out.format("Error E/S en %s\n", nombrefichero);
            }
        }
    }

    /**
     * Clase de lectura y carga de datos  de un fichero a una lista con Ojetos de tipo Tecnico
     */
    private static class FicheroTecnicos {

        private static final String nombrefichero = "src/com/company/Data/Tecnicos.dat";
        private static final Map<Integer, Tecnico> objectMap = DepartamentoTecnico.getMap();

        public static void main(String[] args) {
            //GENERAMOS EL FLUJO DE DATOS PARA LECTURA DEL FICHERO
            ObjectInputStream objectInputStream = null;

            try {
                objectInputStream = new ObjectInputStream(new FileInputStream(nombrefichero));

                //RECORREMOS EL FICHERO Y LO CARGAMOS EN LA LISTA CORRESPONDIENTE
                Tecnico a = null;
                try{
                    boolean primeravez=true;
                    while (true){
                        if (primeravez){
                            objectMap.clear();
                            primeravez=false;
                        }
                        a = (Tecnico) objectInputStream.readObject();
                        if (!objectMap.containsKey(a.getId())){
                            objectMap.put(a.getId(),a);
                        }
                    }
                }
                catch(EOFException e){
                    System.out.format("Fin de carga fichero %s\n",nombrefichero);
                }  //Salimos del bucle de lectura.
                catch (ClassNotFoundException e) {
                    System.out.println("Clase almacenada incorrecta");
                }

                //CERRAMOS FICHERO
                objectInputStream.close();

            } catch (FileNotFoundException f) {
                System.out.format("Fichero %s no encontrado\n", nombrefichero);
            } catch (IOException io) {
                System.out.format("Error E/S en %s\n", nombrefichero);
            }
        }
    }

    /**
     * Clase de lectura y carga de datos  de un fichero a una lista con Ojetos de tipo Incidencia
     */
    private static class FicheroIncidencias {

        private static final String nombrefichero = "src/com/company/Data/Incidencias.dat";
        private static final Map<Integer,Incidencia> objectMap = IncidenciasReportadas.getMap();

        public static void main(String[] args) {
            //GENERAMOS EL FLUJO DE DATOS PARA LECTURA DEL FICHERO
            ObjectInputStream objectInputStream = null;

            try {
                objectInputStream = new ObjectInputStream(new FileInputStream(nombrefichero));

                //RECORREMOS EL FICHERO Y LO CARGAMOS EN LA LISTA CORRESPONDIENTE
                Incidencia a = null;
                try{
                    boolean primeravez=true;
                    while (true){
                        if (primeravez){
                            objectMap.clear();
                            //listaDeCarga.clear();
                            primeravez=false;
                        }
                        a = (Incidencia) objectInputStream.readObject();
                        if (!objectMap.containsKey(a.getId())){
                            objectMap.put(a.getId(),a);
                        }
                    }
                }
                catch(EOFException e){
                    System.out.format("Fin de carga fichero %s\n",nombrefichero);
                }  //Salimos del bucle de lectura.
                catch (ClassNotFoundException e) {
                    System.out.println("Clase almacenada incorrecta");
                }

                //CERRAMOS FICHERO
                objectInputStream.close();

            } catch (FileNotFoundException f) {
                System.out.format("Fichero %s no encontrado\n", nombrefichero);
            } catch (IOException io) {
                System.out.format("Error E/S en %s\n", nombrefichero);
            }
        }
    }

    /**
     * Clase de lectura y carga de datos  de un fichero a una lista con Ojetos de tipo Trabajo 
     */
    private static class FicheroTrabajos {

        private static final String nombrefichero = "src/com/company/Data/Trabajos.dat";
        private static final List<Trabajo> listaDeCarga= TrabajosRealizados.getLista();

        public static void main(String[] args) {
            //GENERAMOS EL FLUJO DE DATOS PARA LECTURA DEL FICHERO
            ObjectInputStream objectInputStream = null;

            try {
                objectInputStream = new ObjectInputStream(new FileInputStream(nombrefichero));

                //RECORREMOS EL FICHERO Y LO CARGAMOS EN LA LISTA CORRESPONDIENTE
                Trabajo a = null;
                try{
                    while (true){
                        a = (Trabajo) objectInputStream.readObject();
                        listaDeCarga.add(a);
                    }
                }
                catch(EOFException e){  }  //Salimos del bucle de lectura.
                catch (ClassNotFoundException e) {
                    System.out.println("Clase almacenada incorrecta");
                }

                //CERRAMOS FICHERO
                objectInputStream.close();

            } catch (FileNotFoundException f) {
                System.out.format("Fichero %s no encontrado\n", nombrefichero);
            } catch (IOException io) {
                System.out.format("Error E/S en %s\n", nombrefichero);
            }
        }
    }

    /**
     * Clase de lectura y carga de datos de un fichero a una lista
     */
    private static class FicheroTipoIncidencias {

        private static final String nombrefichero = "src/com/company/Data/TiposDeIncidencia.dat";
        private static final List<String> listaDeCarga= new TiposDeIncidencias().getLista();

        public static void main(String[] args) {
            //GENERAMOS EL FLUJO DE DATOS PARA LECTURA DEL FICHERO
            ObjectInputStream objectInputStream = null;

            try {
                objectInputStream = new ObjectInputStream(new FileInputStream(nombrefichero));

                //RECORREMOS EL FICHERO Y LO CARGAMOS EN LA LISTA CORRESPONDIENTE
                String a = null;
                try{
                    while (true){
                        a = (String) objectInputStream.readObject();
                        listaDeCarga.add(a);
                    }
                }
                catch(EOFException e){
                    System.out.format("Fin de carga fichero %s\n",nombrefichero);
                }  //Salimos del bucle de lectura.
                catch (ClassNotFoundException e) {
                    System.out.println("Clase almacenada incorrecta");
                }

                //CERRAMOS FICHERO
                objectInputStream.close();

            } catch (FileNotFoundException f) {
                System.out.format("Fichero %s no encontrado\n", nombrefichero);
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

    public static void cargarTodosLosFicheros(){
        FicheroAreas();
        FicheroTecnicos();
        FicheroIncidencias();
        FicheroTrabajos();
        FicheroTipoIncidencias();
    }
}
