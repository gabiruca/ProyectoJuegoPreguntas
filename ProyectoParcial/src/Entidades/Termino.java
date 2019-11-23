//  En esta clase se instancian los terminos 
package Entidades;
import java.util.ArrayList;
/**
 *
 * @author Gabriela
 */
public class Termino {
    public static ArrayList<Termino> terminos=new ArrayList<>();
    private int ano;
    private int numero;
    
    //Constructor
    public Termino(int ano, int numero){
        this.ano=ano;
        this.numero=numero;
    }

    //Setters y getters
    public int getAno() {
        return ano;
    }
      public void setAno(int ano) {
        this.ano = ano;
    }

    public int getNumero() {
        return numero;
    }
    
    public void setNumero(int numero) {
        this.numero = numero;
    }

    //Hashcode
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + this.ano;
        hash = 67 * hash + this.numero;
        return hash;
    }
    
    //Equals
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
        final Termino other = (Termino) obj;
        if (this.ano != other.ano) {
            return false;
        }
        if (this.numero != other.numero) {
            return false;
        }
        return true;
    }
    
    //To String
    @Override
    public String toString(){
        return this.ano+"-"+this.numero;
    }
}
