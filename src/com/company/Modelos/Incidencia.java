package com.company.Modelos;

import com.company.Miscelaneous.Utils;

import java.io.Serializable;
import java.util.List;

/**
 * Clase para almacenar las incidencias registradas para su resolución o consulta.
 * Se debe usar siempre el metodo *setatributo* para establecer los valores de los mismos
 * ya que el control de tamaño esta implementado en el propio campo.
 */
public class Incidencia implements Serializable {


    //ATRIBUTOS
    private int id;   //Id de la incidencia
    private String descripcion; //Tipo de la incidencia (100 caracteres)
    private String area;        //Area que registra la incidencia (15 caracteres)
    private boolean resuelta;   //Indica si la incidencia está resuelta o no

    //CONSTRUCTORES
    public Incidencia() {
    }

    public Incidencia(int id, String descripcion, String area) {
        this.id = id;
        setDescripcion(descripcion); //Tipo de Incidencia
        setArea(area);
        this.resuelta = false;
    }

    // GETTERS Y SETTERS

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        //Control de máximo de 100 caracteres
        this.descripcion = descripcion;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        //Permitido máximo 15 carácteres
        this.area = Utils.setStringToFixedSize(area.trim(),15);
    }


    public boolean isResuelta() {
        return resuelta;
    }

    public void setResuelta(boolean resuelta) {
        this.resuelta = resuelta;
    }

    @Override
    public String toString() {
        return "Incidencia id: " + id +
                ", descripcion: " + descripcion + '\'' +
                ", area: " + area + '\'' +
                ", resuelta: " + resuelta;
    }
}
