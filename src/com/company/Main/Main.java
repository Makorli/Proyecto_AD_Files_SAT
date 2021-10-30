package com.company.Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {

    //Función genérica de lectura de datos
    private static <T>T leerdato(T o, String textoDescripcion) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String tipodato = o.getClass().getSimpleName();
        textoDescripcion = textoDescripcion == null ? "" : textoDescripcion;

        switch (tipodato.toUpperCase()) {

            case "INTEGER":
                try {
                    System.out.format("Introduce %s: ", (textoDescripcion.isEmpty()) ? "dato" : textoDescripcion);
                    o = (T) Integer.valueOf(br.readLine());
                } catch (NumberFormatException | IOException e) {
                    System.out.format("Dato %s introducido no correcto\n", (textoDescripcion.isEmpty()) ? tipodato : textoDescripcion);
                }
                break;
            case "STRING":
                try {
                    System.out.format("Introduce %s: ", (textoDescripcion.isEmpty()) ? "dato" : textoDescripcion);
                    o = (T) br.readLine();
                } catch (IOException e) {
                    System.out.format("Dato %s introducido no correcto\n", (textoDescripcion.isEmpty()) ? tipodato : textoDescripcion);
                }
                break;
            case "DOUBLE":
                try {
                    System.out.format("Introduce %s: ", (textoDescripcion.isEmpty()) ? "dato" : textoDescripcion);
                    o = (T) Double.valueOf(br.readLine());
                } catch (NumberFormatException | IOException e) {
                    System.out.format("Dato %s introducido no correcto\n", (textoDescripcion.isEmpty()) ? tipodato : textoDescripcion);
                }
                break;
            default:
                System.out.println("ERROR.Tipo de dato no reconocido");
        }
        return o;
    }

    public static void main(String[] args) {
        // write your code here

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String opcion = "";

        Scanner sc = new Scanner(System.in);
        do {
            //MONTAMOS EL MENÚ

            System.out.println("1. Cargar Datos de Prueba.\n" +
                    "2. Gestión de incidencias\n" +
                    "\ta. Generación de Incidencias.\n" +
                    "\tb. Atención de incidencias.\n" +
                    "3. Listados\n" +
                    "\ta. Listado de averías sin resolver.\n" +
                    "\tb. Listado de averías resueltas.\n" +
                    "\tc. Listado de todas las averías del sistema\n" +
                    "4. Exportacion de datos a XML\n" +
                    "\ta. Técnicos\n" +
                    "\tb. Averias (Todas)\n" +
                    "\tc. Averías Resueltas\n" +
                    "\td. Averías Pendientes\n" +
                    "\te. Areas de empresa\n" +
                    "\tf. Tipos de Incidencia\n" +
                    "5. Salir\n");

            opcion = leerdato(opcion, "opcion").toUpperCase();

            int nIncidencias=0;
            switch (opcion) {

                // CARGA DE DATOS INICIALES

                case "1":   //Carga de datos de prueba.
                    System.out.println("Cargando Datos de Prueba");
                    Generador.DatosParaPruebas();
                    break;

                // INCIDENCIAS

                case "2A":  //Generacion de incidencias.
                    nIncidencias= leerdato(nIncidencias, "Incidencias a generar (<0 Aleatorias) :");
                    Generador.NuevasIncidencias(nIncidencias);
                    break;
                case "2B":  //Atender Incidencias.
                    nIncidencias= leerdato(nIncidencias, "Incidencias a atender (<0 Aleatorias) :");
                    Generador.AtenderIncidencias(nIncidencias);
                    break;

                // LISTADOS

                case "3A": //Listado de averías sin resolver.
                    Visualizador.IncidenciasPendientes.main(new String[]{});
                    break;
                case "3B": //Listado de averías resueltas.
                    Visualizador.IncidenciasCerradas.main(new String[]{});
                    break;
                case "3C": //Listado de todas las averías resueltas.
                    Visualizador.TodasLasIncidencias.main(new String[]{});
                    break;

                //EXPORTACION DE DATOS A XML

                case "4A": //Tecnicos a XML.
                    XMLWriter.ExportDepartamentoTecnico.main(new String[]{});
                    break;
                case "4B": //Todas las averías a XML.
                    XMLWriter.ExportIncidenciasReportadas.main(new String[]{});
                    break;
                case "4C": //Averías resueltas a XML.
                    XMLWriter.ExportIncidenciasCerradas.main(new String[]{});
                    break;
                case "4D": //Averís pendientes a XML.
                    XMLWriter.ExportIncidenciasPendientes.main(new String[]{});
                    break;
                case "4E": //Areas de Empresa a XML.
                    XMLWriter.ExportAreasEmpresa.main(new String[]{});
                    break;
                case "4F": //Tipos de Incidencia a XML.
                    XMLWriter.ExportTiposIncidencias.main(new String[]{});
                    break;

                //SALIR DEL PROGRAMA

                case "5":
                    System.out.println("Bye Bye");
                    break;

                //OPCION INCORRECTA
                default:
                    System.out.println("Opcion incorrecta");
            }
            //PAUSA PARA VER LISTADOS Y SALIDA DE CONSOLA
            System.out.println("\nPulsa una tecla para continuar....");
            sc.nextLine();
        } while (!(opcion.equals("5")));

    }
}

