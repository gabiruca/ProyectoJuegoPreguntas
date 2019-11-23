//Se instancian los paralelos de las materias
package Entidades;
import java.util.ArrayList;
/**
 *
 * @author Gabriela
 */
public class Paralelo {
    private Termino termino;
    private int numero;
    private ArrayList<Estudiante> estudiantes=new ArrayList<>();

    //Metodo constructor
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
    
    
    //Setters y getters
    public Termino getTermino() {
        return termino;
    }

    public void setTermino(Termino termino) {
        this.termino = termino;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }
    
    
    //To String
    public String toString(){
        return this.numero+" -- "+this.termino;
    }
}
