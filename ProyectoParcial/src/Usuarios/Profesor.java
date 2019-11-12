/*
 Clase Profesor que guarda los datos de los profesores
 */
package Usuarios;

/**
 *
 * @author Walter Gonzalez
 */
public class Profesor {
    private String nombre;
    private int cedula;

    public Profesor(String nombre, int cedula) {
        this.nombre = nombre;
        this.cedula = cedula;
    }

    public int getCedula() {
        return cedula;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }
     
}
