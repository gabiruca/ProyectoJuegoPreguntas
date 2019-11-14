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
public class Estudiante {
    private String nombre;
    private int matricula;

    public Estudiante(String nombre, int matricula) {
        this.nombre = nombre;
        this.matricula = matricula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }
    
    
}
