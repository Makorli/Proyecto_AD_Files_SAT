package com.company.Main;

import com.company.Modelos.*;
import com.thoughtworks.xstream.XStream;

import java.io.*;


public class XMLWriter {

    public static class ExportDepartamentoTecnico {

        private static String nombrefichero = "src/com/company/XMLs/Tecnicos.xml";

        public static void main(String[] args) throws FileNotFoundException {

            //Cargamos el fichero en memoria
            CargarFicheros_OOS.FicheroTecnicos();

            try{
                //instaciamos el Xstream
                XStream xstream = new XStream();

                //Asociamos las etiquetas a las clases correspondientes.
                xstream.alias("DepartamentoTecnico", DepartamentoTecnico.class);
                xstream.alias("Tecnico", Tecnico.class);

                //Eliminamos las etiquetas /atributos de la clase que no queremos que aparezcan
                //xstream.addImplicitCollection(DepartamentoTecnico.class,"tecnicoMap");


                System.out.format("Generando fichero %s",nombrefichero);

                //Transformamos el fichero cargado en memoria
                xstream.toXML(DepartamentoTecnico.getLista(), new FileOutputStream(nombrefichero));

            } catch (FileNotFoundException f){
                System.out.println("Error E/S");
            }

        }

    }

    public static class ExportAreasEmpresa {

        private static String nombrefichero = "src/com/company/XMLs/Areas.xml";

        public static void main(String[] args) throws FileNotFoundException {

            //Cargamos el fichero en memoria
            CargarFicheros_OOS.FicheroAreas();

            try{
                //instaciamos el Xstream
                XStream xstream = new XStream();

                //Asociamos las etiquetas a las clases correspondientes.
                xstream.alias("AreasEmpresa", AreasEmpresa.class);
                xstream.alias("Area", Area.class);

                //Eliminamos las etiquetas /atributos de la clase que no queremos que aparezcan
                //xstream.addImplicitCollection(DepartamentoTecnico.class,"tecnicoMap");

                System.out.format("Generando fichero %s",nombrefichero);

                //Transformamos el fichero cargado en memoria
                xstream.toXML(AreasEmpresa.getLista(), new FileOutputStream(nombrefichero));

            } catch (FileNotFoundException f){
                System.out.println("Error E/S");
            }

        }

    }

    public static class ExportTiposIncidencias {

        private static String nombrefichero = "src/com/company/XMLs/TiposIncidencia.xml";

        public static void main(String[] args) throws FileNotFoundException {

            //Cargamos el fichero en memoria
            CargarFicheros_OOS.FicheroTipoIncidencias();

            try{
                //instaciamos el Xstream
                XStream xstream = new XStream();

                //Asociamos las etiquetas a las clases correspondientes.
                xstream.alias("TiposDeIncidencia", TiposDeIncidencias.class);
                xstream.alias("Tipo", Incidencia.class);

                //Eliminamos las etiquetas /atributos de la clase que no queremos que aparezcan
                //xstream.addImplicitCollection(DepartamentoTecnico.class,"tecnicoMap");

                System.out.format("Generando fichero %s",nombrefichero);

                //Transformamos el fichero cargado en memoria
                xstream.toXML(TiposDeIncidencias.getLista(), new FileOutputStream(nombrefichero));

            } catch (FileNotFoundException f){
                System.out.println("Error E/S");
            }

        }

    }

    public static class ExportIncidenciasReportadas {

        private static String nombrefichero = "src/com/company/XMLs/Incidencias.xml";

        public static void main(String[] args) throws FileNotFoundException {

            //Cargamos el fichero en memoria
            CargarFicheros_OOS.FicheroIncidencias();

            try{
                //instaciamos el Xstream
                XStream xstream = new XStream();

                //Asociamos las etiquetas a las clases correspondientes.
                xstream.alias("IncidenciasReportadas", TiposDeIncidencias.class);
                xstream.alias("Incidencia", Incidencia.class);

                //Eliminamos las etiquetas /atributos de la clase que no queremos que aparezcan
                //xstream.addImplicitCollection(DepartamentoTecnico.class,"tecnicoMap");

                System.out.format("Generando fichero %s",nombrefichero);

                //Transformamos el fichero cargado en memoria
                xstream.toXML(IncidenciasReportadas.getLista(), new FileOutputStream(nombrefichero));

            } catch (FileNotFoundException f){
                System.out.println("Error E/S");
            }

        }

    }

}
