/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Usuarios;

/**
 *
 * @author DanielAlvaradoPelaez
 */
public class Pregunta {
    private String pregunta;
    private int nivel;
    private String[] opciones;

    public Pregunta(String pregunta, int nivel, String[] opciones) {
        this.pregunta = pregunta;
        this.nivel = nivel;
        this.opciones = opciones;
    }

    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public String[] getOpciones() {
        return opciones;
    }

    public void setOpciones(String[] opciones) {
        this.opciones = opciones;
    }
    
    
}
