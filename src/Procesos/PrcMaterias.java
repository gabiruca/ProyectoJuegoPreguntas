/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Procesos;
import Entidades.Materia;

/**
 *
 * @author DanielAlvaradoPelaez
 */
public class PrcMaterias {
    
    public void ingresaarMaterias() {// ingreso de materia
        System.out.println("......................");
        System.out.println("Ingreso de Materia");
        Entrada entrada = new Entrada();
        Materia materia = new Materia(entrada.Cadena("Ingrese codigo : "), entrada.Cadena("Ingrese Nombre  : "), entrada.Entera("Ingrese niveles:"));
        Materia.materias.add(materia);
        Materia.materiasAct.add(materia);
        System.out.println("Materia ingresado");
    }

    public void editarMateria() {//Se editan las materias ingresadas tanto el nombre como los niveles
        System.out.println("......................");
        System.out.println("Editar Materia");
        Entrada entrada = new Entrada();
        System.out.println("Seleccione materia");
        int i = 1;
        if (Materia.materiasAct.size() != 0) {//mostrar las materias disponibles(activas) para seleccionar la que se desea editar
            for (Materia m : Materia.materiasAct) {
                System.out.println(i + ". " + m);
                i++;
            }
            int opc;
            do {
                opc = entrada.Entera("Ingrese opción(1-" + (i - 1) + "): ");//preguntara que materia desea editar
                if (!(opc >= 1 && opc <= (i - 1))) {
                    System.out.println("Entrada no valida");
                }
            } while (!(opc >= 1 && opc <= (i - 1)));
            int x = opc;
            char s;
            if (i != 1) {
                System.out.println(Materia.materiasAct.get(opc - 1));
                do {//en este bucle se preguntara que opcion desea editar 
                    System.out.print("EDITAR.\n"
                            + "1. Nombre De Materia\n"
                            + "2. Niveles");
                    opc = entrada.Entera("Ingrese ocpcion(1-2)");
                    if (opc == 1) {
                        Materia.materias.get(x - 1).setNombre(entrada.Cadena("Ingrese nuevo Nombre: "));
                    } else if (opc == 2) {
                        Materia.materias.get(x - 1).setNiveles(entrada.Entera("Ingrese nuevos Niveles: "));
                    } else {
                        System.out.println("Entrada no valida");
                    }
                    s = entrada.Cadena("Desea seguir editando (s/n)").charAt(0);// se preguntara si desea seguir editando
                } while (s == 's' || s == 'S');
            }
        } else {
            System.out.println("No hay materias activas");// en caso de que no existan 
        }
    }
//desactivar materia
    public void desactivarMateria() {
        System.out.println("......................");
        System.out.println("Desactivar Materia");
        Entrada entrada = new Entrada();
        int i = 1;
        if (Materia.materiasAct.size() != 0) {
            for (Materia m : Materia.materiasAct) {
                System.out.println(i + ". " + m);
                i++;
            }
            if (i != 1) {
                int opc;
                do {
                    opc = entrada.Entera("Ingrese opción(1-" + (i - 1) + "): ");
                    if (!(opc >= 1 && opc <= (i - 1))) {
                        System.out.println("Entrada no valida");
                    }
                } while (!(opc >= 1 && opc <= (i - 1)));
                Materia.materiasAct.remove(Materia.materias.get(opc - 1));
                System.out.println("Materia Desactivada");
            } else {
                System.out.println("No existen materia activas");
            }
        } else {
            System.out.println("No hay materia activas ");
        }
    }
}

