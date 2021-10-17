package com.company.Modelos;

import com.company.Miscelaneous.Utils;
import com.company.Miscelaneous.Utils.*;

import java.io.Serializable;

/**
 * Clase Tecnico. Implemta dde serializable para su uso con ficheros.
 * Se debe usar siempre el metodo *setatributo* para establecer los valores de los mismos
 * ya que el control de tamaño esta implementado en el propio campo.
 * Un registro oc
 */
public class Tecnico implements Serializable {
    //Un objeto tecnico siempre ocupara 84 bytes

    //ATRIBUTOS
    private int id;  // 4 bytes
    private String nombre;  // 40 caracteres * 2 80 bytes

    //CONSTRUCTORES

    public Tecnico() {
    }

    public Tecnico(int idTecnico, String nombre) {
        this.id = idTecnico;
        setNombre(nombre);

    }

    //GETTERSY SETTERS

    public int getId() {
        return id;
    }

    public void setId(int idTecnico) {
        this.id = idTecnico;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        //restringimos la entrada de datos a 40 caracteres.
        this.nombre = Utils.setStringToFixedSize(nombre.trim(),40);
    }

    @Override
    public String toString() {
        return "Tecnico Id" + id +
                ", Nombre: " + nombre;
    }
}
