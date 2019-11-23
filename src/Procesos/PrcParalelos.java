/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Procesos;

import Entidades.Materia;
import Entidades.Paralelo;
import Entidades.Termino;
/**
 *
 * @author DanielAlvaradoPelaez
 */
public class PrcParalelos {
    
    public void agregarParalelo() {
        int opc;
        System.out.println("......................");
        System.out.println("Agregar paralelo");
        System.out.println("Seleccionar Materia");
        Entrada entrada = new Entrada();
        int i = 1;
        if (Materia.materiasAct.size() != 0) {
            for (Materia m : Materia.materiasAct) {//se mostraran las materias disponibles a las cuales se les puede agregar paralelos
                System.out.println(i + ". " + m);
                i++;
            }
            do {
                opc = entrada.Entera("Ingrese opción(1-" + (i - 1) + "): ");//se selecioona la materia
                if (!(opc >= 1 && opc <= (i - 1))) {
                    System.out.println("Entrada no valida");
                }
            } while (!(opc >= 1 && opc <= (i - 1)));
            Materia materia = Materia.materiasAct.get(opc - 1);
            System.out.println("Seleccionar Termino");
            i = 1;
            for (Termino t : Termino.terminos) {//se muestran los terminos academicos registrados para ingresar los paralelos
                System.out.println(i + ". " + t);
                i++;
            }
            do {
                opc = entrada.Entera("Ingrese opción(1-" + (i - 1) + "): ");
                if(!(opc >= 1 && opc <= (i - 1)))
                    System.out.println("Entrada no valida");
            } while (!(opc >= 1 && opc <= (i - 1)));
            Termino termino = Termino.terminos.get(opc - 1);
            materia.ingresarParalelo(new Paralelo(termino, entrada.Entera("Ingresar número de paralelo: ")));
            System.out.println("Paraleloagregador");
        } else {
            System.out.println("No hay materias activas");
        }
    }

    public void eliminarParaelo() {
        int opc;
        System.out.println("......................");
        System.out.println("Seleccionar Materia");
        Entrada entrada = new Entrada();
        int i = 1;
        for (Materia m : Materia.materiasAct) {
            System.out.println(i + ". " + m);
            i++;
        }
        if (i != 1) {
            do {
                opc = entrada.Entera("Ingrese opción(1-" + (i - 1) + "): ");
                if (!(opc >= 1 && opc <= (i - 1))) {
                    System.out.println("Entrada no valida");
                }
            } while (!(opc >= 1 && opc <= (i - 1)));
            Materia materia = Materia.materiasAct.get(opc - 1);
            i = 1;
            System.out.println("Seleccione paralelo a eliminar");
            for (Paralelo p : materia.getParalelos()) {

                System.out.println(i + ". " + p);
                i++;
            }
            if (i != 1) {
                do {
                    opc = entrada.Entera("Ingrese opción(1-" + (i - 1) + "): ");
                    if (!(opc >= 1 && opc <= (i - 1))) {
                        System.out.println("Entrada no valida");
                    }
                } while (!(opc >= 1 && opc <= (i - 1)));
                Paralelo paralelo = materia.getParalelos().get(opc - 1);
                boolean b = materia.getParalelos().remove(paralelo);
                if (b) {
                    System.out.println("paralelo eliminado");
                }
            } else {
                System.out.println("No existen paralelos");
            }
        } else {
            System.out.println("No existen materias activas");
        }
    }
}

