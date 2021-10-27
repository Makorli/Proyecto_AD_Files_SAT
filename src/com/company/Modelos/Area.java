package com.company.Modelos;

import com.company.Miscelaneous.Utils;

import java.io.Serializable;

public class Area implements Serializable {

    private int id;
    private String nombreArea;  //Maximo 15 caracteres

    //CONSTRUCTORES
    public Area() {
    }

    public Area(int id, String nombreArea) {
        this.id = id;
        this.nombreArea = nombreArea;
    }

    //GETTERS Y SETTERS


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreArea() {
        return nombreArea;
    }

    public void setNombreArea(String nombreArea) {

        //this.nombreArea = Utils.setStringToFixedSize(nombreArea,15);
        this.nombreArea = nombreArea;
    }
}
