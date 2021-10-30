package com.company.Controlador;

import com.company.Controlador.*;

public class Visualizador {

    public static class TodasLasIncidencias{
        public static void main(String[] args) {
            System.out.println("CArgando Fichero de incidencias");
            CargarFicheros_OOS.FicheroIncidencias();

            System.out.println("******   Listado de incidencias reportadas ********\n");
            IncidenciasReportadas.visualizarIncidencias();
        }
    }

    public static class IncidenciasPendientes{
        public static void main(String[] args) {
            System.out.println("Cargando Fichero de incidencias");
            CargarFicheros_OOS.FicheroIncidencias();

            System.out.println("******   Listado de incidencias Pendientes reportadas ********\n");
            IncidenciasReportadas.visualizarIncidenciasByState(false);
        }
    }

    public static class IncidenciasCerradas{
        public static void main(String[] args) {
            System.out.println("Cargando Fichero de incidencias");
            CargarFicheros_OOS.FicheroIncidencias();

            System.out.println("******   Listado de incidencias reportadas ya resueltas ********\n");
            IncidenciasReportadas.visualizarIncidenciasByState(true);
        }
    }

    public static class Tecnicos{
        public static void main(String[] args) {
            System.out.println("Cargando Fichero de tecnicos");
            CargarFicheros_OOS.FicheroTecnicos();

            System.out.println("******   Listado de tecnicos en el departamento ********\n");
            DepartamentoTecnico.VisualizarTecnicos();
        }
    }

    public static class AreasDeEmpresa{
        public static void main(String[] args) {
            System.out.println("Cargando Fichero de Areas");
            CargarFicheros_OOS.FicheroAreas();

            System.out.println("******   Listado de Areas de la empresa ********\n");
            AreasEmpresa.visualizarAreas();
        }
    }

    public static class VisualizarTiposDeIncidencia{
        public static void main(String[] args) {
            System.out.println("Cargando Fichero de Tipos de Incidencias");
            CargarFicheros_OOS.FicheroIncidencias();

            System.out.println("******   Listado de Tipo de Incidencias  ********\n");
            TiposDeIncidencias.visualizar();
        }
    }
}
