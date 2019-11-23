/*
 Clase que contiene metodo para visualizar a los estudiantes
 */
package Procesos;

import Entidades.Estudiante;
import Entidades.Materia;
import Entidades.Paralelo;
import Entidades.Termino;
import java.util.ArrayList;

/**
 *
 * @author Walter Gonzalez
 */
public class PrcEstudiantes {

    public void visualizarEstudiantes() {
        int opc;
        Entrada entrada = new Entrada();
        int i = 1;
        System.out.println("visualización de Estudiantes.");
        System.out.println("Seleccione Materia");
        if (Materia.materiasAct.size() != 0) {
            for (Materia m : Materia.materiasAct) {
                System.out.println(i + ". " + m);
                i++;
            }
            opc = entrada.Entera("Ingrese opción(1-" + (i - 1) + "): ");
            Materia materia = Materia.materiasAct.get(opc - 1);
            i = 1;
            System.out.println("Seleccione termino");
            if (Termino.terminos.size() != 0) {
                for (Termino t : Termino.terminos) {
                    System.out.println(i + ". " + t);
                    i++;
                }
                opc = entrada.Entera("Ingrese opcion(1-" + (i - 1) + "): ");
                Termino termino = Termino.terminos.get(opc - 1);
                ArrayList<Paralelo> par = new ArrayList<Paralelo>();
                i = 1;
                System.out.println("Paralelo");
                if (materia.getParalelos().size() != 0) {
                    for (Paralelo p : materia.getParalelos()) {
                        if (p.getTermino().equals(termino)) {
                            System.out.println(i + ". " + p.getNumero());
                            par.add(p);
                            i++;
                        }
                    }
                    opc = entrada.Entera("Ingrese opcion(1-" + (i - 1) + "): ");
                    Paralelo p = par.get(opc - 1);
                    i = 1;
                    // String nameFile=materia.getCodigo()+"-"+p.getNumero()+"-"+termino.getAno()+"-"+termino.getNumero()+".csv";
                    for (Estudiante e : p.getEstudiantes()) {
                        System.out.println(i + ". " + e);
                        i++;
                    }
                } else {
                    System.out.println("No hay Paralelos registrados");
                }
            } else {
                System.out.println("No hay Terminos registrados");
            }
        } else {
            System.out.println("No hay materias activas");
        }
    }

}
