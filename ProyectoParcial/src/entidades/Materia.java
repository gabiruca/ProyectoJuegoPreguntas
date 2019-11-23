/*
 * Clase que contiene la informacion necesaria de materias
 */
package entidades;

import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author Walter Gonzalez 
 */
public class Materia {

    public static ArrayList<Materia> materias = new ArrayList<>();
    public static ArrayList<Materia> materiasAct = new ArrayList<>();
   // public static ArrayList<Materia> materiasDes = new ArrayList<>();
    private String codigo;
    private String nombre;
    private int niveles;
    private ArrayList<Paralelo> paralelos = new ArrayList<>();//cada materia tiene un numero de paralelos 
    private ArrayList<Pregunta> preguntas=new ArrayList<>();// las materias tienen preguntas

    public Materia(String codigo, String nombre, int niveles) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.niveles = niveles;
    }
     @Override
    public int hashCode() {
        int hash = 3;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Materia other = (Materia) obj;
        if (this.getNiveles() != other.getNiveles()) {
            return false;
        }
        if (!Objects.equals(this.codigo, other.codigo)) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.paralelos, other.paralelos)) {
            return false;
        }
        return true;
    }

    /**
     * @return the codigo
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
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

    public String toString() {
        return "Materia: " + this.nombre + " Codigo: " + this.codigo;
    }

    /**
     * @return the niveles
     */
    public int getNiveles() {
        return niveles;
    }

    /**
     * @param niveles the niveles to set
     */
    public void setNiveles(int niveles) {
        this.niveles = niveles;
    }

    public void ingresarParalelo(Paralelo paralelo) {
        this.getParalelos().add(paralelo);
    }

    /**
     * @return the paralelos
     */
    public ArrayList<Paralelo> getParalelos() {
        return paralelos;
    }

    /**
     * @param paralelos the paralelos to set
     */
    public void setParalelos(ArrayList<Paralelo> paralelos) {
        this.paralelos = paralelos;
    }

    /**
     * @return the preguntas
     */
    public ArrayList<Pregunta> getPreguntas() {
        return preguntas;
    }

    /**
     * @param preguntas the preguntas to set
     */
    public void setPreguntas(ArrayList<Pregunta> preguntas) {
        this.preguntas = preguntas;
    }
}
