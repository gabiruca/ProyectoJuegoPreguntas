/*
 * en esta clase se instancia los terminos academicos que constan en el juego 
 */
package entidades;

import java.util.ArrayList;

/**
 *
 * @author Walter Gonzalez 
 */
public class Termino {
    
    public static ArrayList<Termino> terminos=new ArrayList<>();
    private int ano;
    private int numero;
    
    public Termino(int ano, int numero){
        this.ano=ano;
        this.numero=numero;
    }

    /**
     * @return the ano
     */
    public int getAno() {
        return ano;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + this.ano;
        hash = 67 * hash + this.numero;
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
        final Termino other = (Termino) obj;
        if (this.ano != other.ano) {
            return false;
        }
        if (this.numero != other.numero) {
            return false;
        }
        return true;
    }

    /**
     * @param ano the ano to set
     */
    public void setAno(int ano) {
        this.ano = ano;
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
        return this.ano+"-"+this.numero;
    }
}


