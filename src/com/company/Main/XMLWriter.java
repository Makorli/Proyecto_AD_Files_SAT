package com.company.Main;

import com.company.Modelos.DepartamentoTecnico;
import com.company.Modelos.IncidenciasReportadas;
import com.company.Modelos.Tecnico;
import com.thoughtworks.xstream.XStream;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class XMLWriter {

    public static class ExportTEcnicos{

        private static String nombrefichero = "src/com/company/XML/Tecnicos.xml";

        public static void main(String[] args) throws FileNotFoundException {

            CargarFicheros_OOS.FicheroTecnicos();
            try{
                XStream xstream = new XStream();

                xstream.alias("EepartamentoTecnico", DepartamentoTecnico.class);
                xstream.alias("Tecnico", Tecnico.class);

                DepartamentoTecnico midpto = new DepartamentoTecnico();

                xstream.addImplicitCollection(DepartamentoTecnico.class,"tecnicoslista");

                xstream.toXML(midpto, new FileOutputStream(nombrefichero));

            } catch (FileNotFoundException f){
                System.out.println("Error E/S");
            }

        }

    }
}
