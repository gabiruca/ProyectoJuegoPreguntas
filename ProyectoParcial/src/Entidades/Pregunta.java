/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import Procesos.Entrada;
import java.util.ArrayList;
import java.util.Random;
/**
 *
 * @author DanielAlvaradoPelaez
 */
public class Pregunta {
    
    private String pregunta;
    private String resCorrepta;
    private char c;
    private int nivel;
    private ArrayList<String> respuestas = new ArrayList<>();

    public Pregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    public void validarNivel(Materia materia, int nivel) {
        if (nivel <= materia.getNiveles()) {
            this.setNivel(nivel);
        } else {
            System.out.println("Error. nivel no valido");
            Entrada entrada = new Entrada();
            this.validarNivel(materia, entrada.Entera("Ingrese nivel: "));
        }
    }

    public void agregarRespuesta(String res) {
        this.getRespuestas().add(res);
    }

    public void agregarResCorrepta(int num) {
        this.setResCorrepta(this.getRespuestas().get(num - 1));
        this.respuestas.remove(num - 1);
    }

    /**
     * @return the pregunta
     */
    public String getPregunta() {
        return pregunta;
    }

    /**
     * @param pregunta the pregunta to set
     */
    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    /**
     * @return the resCorrepta
     */
    public String getResCorrepta() {
        return resCorrepta;
    }

    /**
     * @param resCorrepta the resCorrepta to set
     */
    public void setResCorrepta(String resCorrepta) {
        this.resCorrepta = resCorrepta;
    }

    /**
     * @return the respuestas
     */
    public ArrayList<String> getRespuestas() {
        return respuestas;
    }

    /**
     * @param respuestas the respuestas to set
     */
    public void setRespuestas(ArrayList<String> respuestas) {
        this.respuestas = respuestas;
    }

    /**
     * @return the nivel
     */
    public int getNivel() {
        return nivel;
    }

    /**
     * @param nivel the nivel to set
     */
    public void setNivel(int nivel) {
        this.nivel = nivel;
    }
    
    public char getC(){
        return c;
    }
    
    public String toString() {
        Random ram = new Random();
        int n = ram.nextInt(4);
        String cadena = "";
        //en el metodo toString de esta clase como se ve se generara un aleatorio para mostrar diferentes posiciones de la respuesta correpta
        // es decir al ejecutar el juego nuevamente cambiara el orden de mostarar las respuesta
        if (n == 0) {
            cadena += this.getPregunta() + ": \n" + "A." + this.getResCorrepta() + "\nB." + this.respuestas.get(0) + "\nC." + this.respuestas.get(1) + "\nD." + this.respuestas.get(2);
            this.c='A';
        }
        if (n == 1) {
            cadena += this.getPregunta() + ": \n" + "A." + this.respuestas.get(0) + "\nB." + this.getResCorrepta() + "\nC." + this.respuestas.get(1) + "\nD." + this.respuestas.get(2);
            this.c='B';
        }
        if (n == 2) {
            cadena += this.getPregunta() + ": \n" + "A." + this.respuestas.get(0) + "\nB." + this.respuestas.get(1) + "\nC." + this.getResCorrepta() + "\nD." + this.respuestas.get(2);
            this.c='C';
        }
        if (n == 3) {
            cadena += this.getPregunta() + ": \n" + "A." + this.respuestas.get(0) + "\nB." + this.respuestas.get(1) + "\nC." + this.respuestas.get(2) + "\nD" + this.getResCorrepta();
            this.c='D';
        }
        
        return cadena;
    }
}


