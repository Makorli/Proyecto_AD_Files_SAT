package com.company.Modelos;

import com.company.Miscelaneous.Utils;

import java.io.Serializable;

/**
 * Clase para almacenar objetos de dedicacion de tiempo a una indicencia
 * Se debe usar siempre el metodo *setatributo* para establecer los valores de los mismos
 * ya que el control de tamaño esta implementado en el propio campo.
 */

public class Trabajo implements Serializable {

    //ATRIBUTOS

    private int idIncidencia;   //Id de la incidencia a la que se dedica el tiempo.
    private int idTecnico;      //ID del tecnico que realiza la tarea.
    private int horas;       //Tiempo dedicado a la tarea


    //CONSTRUCTORES

    public Trabajo(int idIncidencia, int idTecnico, int horas) {
        this.idIncidencia = idIncidencia;
        this.horas = horas;
    }

    // GETTER Y SETTERS
    public int getIdIncidencia() {
        return idIncidencia;
    }

    public void setIdIncidencia(int idIncidencia) {
        this.idIncidencia = idIncidencia;
    }

    public int getIdTecnico() { return idTecnico; }

    public void setIdTecnico(int idTecnico) { this.idTecnico = idTecnico; }

    public int getHoras() {
        return horas;
    }

    public void setHoras(int horas) {
        this.horas = horas;
    }

}

