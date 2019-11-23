/*
 *Se instancian los paralelos de las materias;
 */
package entidades;

import java.util.ArrayList;

/**
 *
 * @author PC
 */
public class Paralelo {
   
    private Termino termino;
    private int numero;
    private ArrayList<Estudiante> estudiantes=new ArrayList<>();

    public Paralelo(Termino termino, int numero) {
        this.termino = termino;
        this.numero = numero;
    }
    
    public void agregarEstudiantes(Estudiante est){
        this.estudiantes.add(est);
    }
    
    public ArrayList<Estudiante> getEstudiantes(){
        return this.estudiantes;
    }
    /**
     * @return the termino
     */
    public Termino getTermino() {
        return termino;
    }

    /**
     * @param termino the termino to set
     */
    public void setTermino(Termino termino) {
        this.termino = termino;
    }

    /**
     * @return the numero
     */
    public int getNumero() {
        return numero;
    }

    /**
     * @param numero the numero to set
     */
    public void setNumero(int numero) {
        this.numero = numero;
    }
    
    public String toString(){
        return this.numero+" -- "+this.termino;
    }
    
}
