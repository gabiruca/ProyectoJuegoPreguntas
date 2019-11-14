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
public class Paralelo {
    private int paralelo;
    private Materia[] materias;
    private Estudiante[] estudiantes;

    public Paralelo(int paralelo, Materia[] materias, Estudiante[] estudiantes) {
        this.paralelo = paralelo;
        this.materias = materias;
        this.estudiantes = estudiantes;
    }

    public int getParalelo() {
        return paralelo;
    }

    public void setParalelo(int paralelo) {
        this.paralelo = paralelo;
    }

    public Materia[] getMaterias() {
        return materias;
    }

    public void setMaterias(Materia[] materias) {
        this.materias = materias;
    }

    public Estudiante[] getEstudiantes() {
        return estudiantes;
    }

    public void setEstudiantes(Estudiante[] estudiantes) {
        this.estudiantes = estudiantes;
    }
    
}
