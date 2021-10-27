package com.company.Controlador;

import com.company.Modelos.Tecnico;

import java.io.*;
import java.util.List;

import static java.lang.System.exit;

/**
 * Clase de control para los Técnicos.
 * Almacena la información en un fichero de Acceso aleatorio.
 */
public class ControllerTecnicos_OLD {

    //Fichero que almacenará la inforamción de los técnicos.
    private static final String filePath = "src/com/company/Data/Tecnicos.dat";
    private static File fichero = new File(filePath);
    private static RandomAccessFile rafFile; //el fichero de acceso aleatorio
    private static final int reglong = 84; //Define la longitud de un registro de la clase Tecnico.


    //CONSTRUCTORES
    public ControllerTecnicos_OLD() {
    }

    /**
     * Procedimeiento de apertura de fichero
     *
     * @param mode
     * @return boolean Si ha abierto el fichero correntamente o no.
     */
    public boolean openFile(String mode) {

        try {
            //Verificamos la existencia del fichero y si no lo creamos.
            if (fichero.createNewFile()) { //IOException | SecurityException
                System.out.format("Fichero no existente. Creando fichero %s \n",
                        fichero.getAbsoluteFile());
            }

            this.rafFile = new RandomAccessFile(fichero, mode); //NullPointer |IllegalArgument | Filenotfound
            return true;

            // CONTROL DE ERRORES POSIBLES
        } catch (FileNotFoundException e) {
            System.out.println("Fichero no encontrado: " + e);

        } catch (NullPointerException n) {
            System.out.println("Método de apertura o fichero no especificado: " + n);

        } catch (IllegalArgumentException i) {
            System.out.format("Metodo **%s** de apertura no valido.\n Debe ser (r) (rw) o (rwd): " + i,
                    mode);
        } catch (IOException io) {
            System.out.format("Error de acceso I/O en fichero %s. Se cerrara la aplicacion\n",
                    fichero.getAbsoluteFile());
            exit(0);
        }
        return false;

    }

    /**
     * Cierra el fichero
     */
    public void closeFile() {
        try {
            this.rafFile.close();
        } catch (IOException io) {
            System.out.println(io);
        }
    }

    public RandomAccessFile getRafFile() {
        return rafFile;
    }

    /**
     * Funcion para escribir un técncio o varios en el fichero de Tecnicos
     * Lleva sobrecarga de metodos.
     */
    public boolean writeTecnicos(Tecnico t) {
        //Abrimos el fichero y si ha ido bien proseguimos.
        if (!openFile("rw")) return false;
        try {
            getRafFile().writeInt(t.getId());
            getRafFile().writeChars(t.getNombre());

        } catch (IOException io) {
            System.out.println("Error en la escritura del tecnico " + io);
            return false;
        }
        closeFile();
        return true;
    }

    //Metodo sobrecargado de escritura de ArrayList
    public boolean writeTecnicos(List<Tecnico> tecnicoList) {
        //Abrimos el fichero y si ha ido bien proseguimos.
        if (!openFile("rw")) return false;
        try {
            for (Tecnico t : tecnicoList) {
                getRafFile().writeInt(t.getId());
                getRafFile().writeChars(t.getNombre());
            }
        } catch (IOException io) {
            System.out.println("Error en la escritura del array de tecnicos " + io);
            return false;
        }
        closeFile();
        return true;
    }

    /**
     * Funcion que retorna el objeto técnico del fichero dado un id determinado.
     *
     * @param Id id del tecnico a localizar
     * @return Tecnico encontrado o null si no lo encuentra.
     */
    public Tecnico searchTecnicoByID(int Id) {
        Tecnico miTecnico = null;

        if (!(Id > 0)) //para Id superiores a 0
            try {
                //Abrimos el fichero en modo lectura y si ha ido bien proseguimos.
                if (openFile("r")) {
                    //BUSQUEDA EN EL FICHERO

                    //Buscamos el tecnico directamente mendiante la funcion de conversión, si no secuencial.
                    long pos = (Id - 1) * reglong;  //Posicion "teorica del registro buscado si se mantiene en orden"
                    long finalpos = -1;              //para almacenar la posición del registro
                    getRafFile().seek(pos);         //situamos el cursor en la posicion teorica en la que está el técnico.

                    //leemos id y comparamos con el buscado
                    int fileId = rafFile.readInt();
                    if (fileId == Id) {                   //si coincide leemos el nombre
                        //leer nombre
                        StringBuffer fileNombre = new StringBuffer(40);
                        for (int i = 0; i < 40; i++) {
                            fileNombre.append(rafFile.readChar());
                        }
                        return new Tecnico(fileId, fileNombre.toString()); //devolvemos el Tecnico.
                    } else {                         //si no coincide el id lo buscamos secuencialmente en el fichero
                        pos = 0;//comenzamos desde el principio
                        getRafFile().seek(pos);
                        while (rafFile.getFilePointer() != rafFile.length()) {
                            //comparamos id con el del fichero
                            fileId = rafFile.readInt();
                            if (fileId == Id) {
                                finalpos = fileId;
                                break;
                            }
                            pos = pos + reglong;// icrementamos y movemos el cursor para seguir buscando
                            getRafFile().seek(pos);
                        }
                    }
                    //leemos el tecnico encontrado
                    if (finalpos > -1) {
                        getRafFile().seek(finalpos);
                        //leemos y devolvemos el tecnico encontrado.
                        rafFile.readInt(); //leer id
                        //leer nombre
                        StringBuffer nombre = new StringBuffer(40);
                        for (int i = 0; i < 40; i++) {
                            nombre.append(rafFile.readChar());
                        }
                        miTecnico = new Tecnico(Id, nombre.toString());
                    }
                    closeFile(); //Cerramos fichero

                }
            } catch (IOException e) {
                System.out.println("Registro no encontrado " + e);
            }
        return miTecnico;
    }



    public static void main(String[] args) throws IOException {
        System.out.println(new ControllerTecnicos_OLD().openFile("r"));
        System.out.println(fichero.exists());
        System.out.println(fichero.createNewFile());
    }

}
