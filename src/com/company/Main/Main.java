package com.company.Main;

import com.company.Modelos.*;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        new DepartamentoTecnico();
        new IncidenciasReportadas();
        new AreasEmpresa();

        EscribirFicheros_OOS.main(null);
    }
}
