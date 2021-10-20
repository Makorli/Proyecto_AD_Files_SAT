package com.company.Main;

import com.company.Modelos.DepartamentoTecnico;
import com.company.Modelos.Tecnico;
import com.thoughtworks.xstream.XStream;

import java.io.*;


public class XMLWriter {

    public static class ExportTEcnicos{

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
                xstream.addImplicitCollection(DepartamentoTecnico.class,"tecnicoMap");

                System.out.format("Generando fichero %s",nombrefichero);

                //Transformamos el fichero cargado en memoria
                xstream.toXML(DepartamentoTecnico.getLista(), new FileOutputStream(nombrefichero));

            } catch (FileNotFoundException f){
                System.out.println("Error E/S");
            }

        }

    }
}
