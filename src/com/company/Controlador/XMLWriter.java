package com.company.Controlador;

import com.company.Controlador.*;
import com.company.Modelos.*;
import com.thoughtworks.xstream.XStream;

import java.io.*;


public class XMLWriter {

    public static class ExportDepartamentoTecnico {

        private static String nombrefichero = "src/com/company/DataXML/Tecnicos.xml";

        public static void main(String[] args) {

            //Cargamos el fichero en memoria
            CargarFicheros_OOS.FicheroTecnicos();

            try{
                //instaciamos el Xstream
                XStream xstream = new XStream();

                //Asociamos las etiquetas a las clases /atributos  correspondientes.
                xstream.alias("DepartamentoTecnico", DepartamentoTecnico.class);
                xstream.alias("Tecnico", Tecnico.class);


                System.out.format("Generando fichero %s",nombrefichero);

                //Transformamos el fichero cargado en memoria
                xstream.toXML(DepartamentoTecnico.getLista(), new FileOutputStream(nombrefichero));

            } catch (FileNotFoundException f){
                System.out.println("Error E/S:"+ f.getMessage());
            }

        }

    }

    public static class ExportAreasEmpresa {

        private static String nombrefichero = "src/com/company/DataXML/Areas.xml";

        public static void main(String[] args) {

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
                System.out.println("Error E/S: "+f.getMessage());
            }

        }

    }

    public static class ExportTiposIncidencias {

        private static String nombrefichero = "src/com/company/DataXML/TiposIncidencia.xml";

        public static void main(String[] args) {

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
                System.out.println("Error E/S"+f.getMessage());
            }

        }

    }

    public static class ExportIncidenciasReportadas {

        private static String nombrefichero = "src/com/company/DataXML/Incidencias.xml";

        public static void main(String[] args) {

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
                System.out.println("Error E/S"+f.getMessage());
            }

        }

    }

    public static class ExportIncidenciasPendientes {

        private static String nombrefichero = "src/com/company/DataXML/IncidenciasPendientes.xml";

        public static void main(String[] args) {

            //Cargamos el fichero en memoria
            CargarFicheros_OOS.FicheroIncidencias();

            try{
                //instaciamos el Xstream
                XStream xstream = new XStream();

                //Asociamos las etiquetas a las clases correspondientes.
                xstream.alias("IncidenciasReportadas", TiposDeIncidencias.class);
                xstream.alias("Incidencia", Incidencia.class);

                System.out.format("Generando fichero %s",nombrefichero);

                //Transformamos el fichero cargado en memoria
                xstream.toXML(IncidenciasReportadas.getIncidenciasNoCerradasList(), new FileOutputStream(nombrefichero));

            } catch (FileNotFoundException f){
                System.out.println("Error E/S"+f.getMessage());
            }

        }

    }

    public static class ExportIncidenciasCerradas {

        private static String nombrefichero = "src/com/company/DataXML/IncidenciasCerradas.xml";

        public static void main(String[] args) {

            //Cargamos el fichero en memoria
            CargarFicheros_OOS.FicheroIncidencias();

            try{
                //instaciamos el Xstream
                XStream xstream = new XStream();

                //Asociamos las etiquetas a las clases correspondientes.
                xstream.alias("IncidenciasReportadas", TiposDeIncidencias.class);
                xstream.alias("Incidencia", Incidencia.class);

                System.out.format("Generando fichero %s",nombrefichero);

                //Transformamos el fichero cargado en memoria
                xstream.toXML(IncidenciasReportadas.getIncidenciasCerradasList(), new FileOutputStream(nombrefichero));

            } catch (FileNotFoundException f){
                System.out.println("Error E/S"+f.getMessage());
            }

        }

    }

}
