/*
 * Clase que contiene   Los atributos relacionados con los estudiantes como matricula etc
 */
package entidades;

import java.io.Serializable;

/**
 *
 * @Walter Gonzalez
 */
public class Estudiante implements Serializable{
    private String matricula;
    private String nombre;
    private String email;

    public Estudiante(String matricula, String nombre, String email) {
        this.matricula = matricula;
        this.nombre = nombre;
        this.email = email;
    }
    
    public void leerArchivo(){
        
    } 
    /**
     * @return the matricula
     */
    public String getMatricula() {
        return matricula;
    }

    /**
     * @param matricula the matriculañ to set
     */
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }
    
    @Override
    public String toString() {
        return "Estudiante{" + "matricula=" + matricula + ", nombre=" + nombre + ", email=" + email + '}';
    }

}