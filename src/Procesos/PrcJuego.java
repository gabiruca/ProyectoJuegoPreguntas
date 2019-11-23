/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Procesos;

import Entidades.Estudiante;
import Entidades.Juego;
import Entidades.Pregunta;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PC
 */
public class PrcJuego {

    //Se comienza el juego 
    public void comenzarJuego() {
        ArrayList<String> comodines = new ArrayList<>();//se almacenaran los comodines disponibles
        comodines.add("50/50");
        comodines.add("consulta a compañero");
        comodines.add("consulta a clase");
        Entrada entrada = new Entrada();
        entrada.Cadena("Presione una teca para continuar");
        Juego juego = PrcTermino.juego;//se instancia el juego que fue seleccionado en el menu configuraciones administrar terminos academico
        int numero = 1, cont = 0, premio = 0, nivelMaximo = 0;
        boolean t = true;
        for (Integer i : juego.getNiveles()) {//en este bucle se recorreran las preguntas de la materia selecionada, por niveles
            System.out.println("nivel: " + i);//
            for (Pregunta p : juego.getPreguntasNiveles().get(cont)) {//se recorrean las preguntas de un nivel especificado en el for anterior
                System.out.println(numero + ". " + p);//se muestra la pregunta
                numero++;
                char res;
                do {//se valida que el usuario ingrese como opciones de respuestas de la A  ala D
                    res = entrada.Cadena("ingrese respuest(A-D)(*para comodin): ").toUpperCase().charAt(0);
                    if ((res != 'A' && res != 'B' && res != 'C' && res != 'D' && res != '*')) {
                        System.out.println("Opcion no valida");
                    }
                } while (res != 'A' && res != 'B' && res != 'C' && res != 'D' && res != '*');
                if (res == '*') {//en caso de que el usuario seleccione un comodin
                    int x = 0;
                    for (String c : comodines) {//se muestran los comodines disponibles
                        System.out.print((x + 1) + ". " + c + "  ");
                        x++;
                    }
                    int opc;
                    do {// en este do While se valida que ingrese los comodines correpto
                        opc = entrada.Entera("seleccione comodin: ");
                        if (opc < 1 || opc > comodines.size()) {
                            System.out.println("Opcion no valida");
                        }
                    } while (opc < 1 || opc > comodines.size());
                    if (comodines.get(opc - 1).equalsIgnoreCase("50/50")) {//EN caso que seleccione el primer comodin
                        //este comodin deja dos posibles respuestas
                        switch (p.getC()) {//cada pregunta (p) almacena el literar de su repuesta correpta en un atributo llamado c, por lo que con el metodo getC obtenems que literales el correpto
                            case 'A': {
                                System.out.println(p.getC() + ". " + p.getResCorrepta() + "  B." + p.getRespuestas().get(0));
                                do {//aqui se valida la entrada
                                    res = entrada.Cadena("ingrese respuest(A-B)(*para comodin): ").toUpperCase().charAt(0);
                                } while (res != 'A' && res != 'B');
                            }
                            break;
                            case 'B': {
                                System.out.println(p.getC() + ". " + p.getResCorrepta() + "  C." + p.getRespuestas().get(0));
                                do {
                                    res = entrada.Cadena("ingrese respuest(B-C)(*para comodin): ").toUpperCase().charAt(0);
                                } while (res != 'B' && res != 'C');
                            }
                            break;
                            case 'C': {
                                System.out.println(p.getC() + ". " + p.getResCorrepta() + "  D." + p.getRespuestas().get(0));
                                do {
                                    res = entrada.Cadena("ingrese respuest(C-D)(*para comodin): ").toUpperCase().charAt(0);
                                } while (res != 'C' && res != 'D');
                            }
                            break;
                            case 'D': {
                                System.out.println(p.getC() + ". " + p.getResCorrepta() + "  A." + p.getRespuestas().get(0));
                                do {
                                    res = entrada.Cadena("ingrese respuest(A/D)(*para comodin): ").toUpperCase().charAt(0);
                                } while (res != 'D' && res != 'A');
                            }
                            break;
                        }
                        //comodines.remove(opc-1);
                    } else if (comodines.get(opc - 1).equalsIgnoreCase("consulta a compañero")) {//en caso que como comodin escoja la segunda opcion
                        System.out.println("compañero: " + juego.getCompranero());// en   este caso el compaero seleccionado respondera la pregunta
                        char respComp;
                        do {
                            respComp = entrada.Cadena("elija respuesta: ").toUpperCase().charAt(0);
                            if ((respComp != 'A' && respComp != 'B' && respComp != 'C' && respComp != 'D')) {
                                System.out.println("Opcion no valida");
                            }
                        } while (respComp != 'A' && respComp != 'B' && respComp != 'C' && respComp != 'D');
                        char s;
                        do {//se preguntara si se acepta o no la respuesta del copañero
                            s = entrada.Cadena("acepta la respuesta de su compañero(S/N): ").toUpperCase().charAt(0);
                            if (s != 'S' && s != 'N') {
                                System.out.println("Opción no valida");
                            }
                        } while (s != 'S' && s != 'N');
                        if (s == 'S') {
                            res = respComp;//si acepta la respuesta del compañero 
                        } else if (s == 'N') {
                            do {// en caso de que n acepte la respuesta debera ingresar la suya 
                                res = entrada.Cadena("ingrese respuest(A-D): ").toUpperCase().charAt(0);
                                if (!(res != 'A' && res != 'B' && res != 'C' && res != 'D')) {
                                    System.out.println("Opcion nno valida");
                                }
                            } while (res != 'A' && res != 'B' && res != 'C' && res != 'D');
                        }
                    } else if (comodines.get(opc - 1).equalsIgnoreCase("consulta a clase")) {//consulta a todos los estudiantes registrados
                        int A = 0, B = 0, C = 0, D = 0;// se acumularan las respuestas
                        char alt = 'a';
                        for (Estudiante est : juego.getParalelo().getEstudiantes()) {//recorrera todos los estudiante
                            System.out.println(est);
                            char respuesta = entrada.Cadena("Ingrese Opcion(A-B): ").toUpperCase().charAt(0);// les preguntaran su respuesta 
                            do {
                                respuesta = entrada.Cadena("elija respuesta: ").toUpperCase().charAt(0);
                                if ((respuesta != 'A' && respuesta != 'B' && respuesta != 'C' && respuesta != 'D')) {
                                    System.out.println("Opcion no valida");
                                }
                            } while (respuesta != 'A' && respuesta != 'B' && respuesta != 'C' && respuesta != 'D');
                            switch (respuesta) {//acumulara
                                case 'A':
                                    A++;
                                    break;
                                case 'B':
                                    B++;
                                    break;
                                case 'C':
                                    C++;
                                    break;
                                case 'D':
                                    D++;
                                    break;
                            }
                        }
                        int mayor = A;
                        //aqui se comparara el del mayor boto
                        if (B > mayor) {
                            mayor = B;
                            alt = 'A';
                        } else if (C > mayor) {
                            mayor = C;
                            alt = 'C';
                        } else if (D > mayor) {
                            mayor = D;
                            alt = 'D';
                        }
                        System.out.println("El mas botado es: " + alt);
                        char s;
                        do {//el estudiante decidira si aceptara o no la respuesta del publico (curso)
                            s = entrada.Cadena("acepta la respuesta del curso(S/N): ").toUpperCase().charAt(0);
                            if (s != 'S' && s != 'N') {
                                System.out.println("Opción no valida");
                            }
                        } while (s != 'S' && s != 'N');
                        if (s == 'S') {
                            res = alt;
                        } else {
                            do {
                                res = entrada.Cadena("ingrese respuest(A-D)(*para comodin): ").toUpperCase().charAt(0);
                                if (!(res != 'A' && res != 'B' && res != 'C' && res != 'D')) {
                                    System.out.println("Opcion nno valida");
                                }
                            } while (res != 'A' && res != 'B' && res != 'C' && res != 'D');
                        }
                    }

                    comodines.remove(opc - 1);//el comodin usado se eliminara de la lista ya que no lo podra usar en las isiguientes preguntas
                }
                if ((res + "").toUpperCase().charAt(0) != p.getC()) {//se verificar si la respuesta es correpta
                    t = false;
                    break;// en caso de ser incorrepta saldra automaticamente del for
                }
            }
            cont++;
            if (t) {//si nunca entro al if anterior significa que respondio correptamente las preguntas y mostrada lo siguiente
                System.out.println("Nivel Superado");
                premio += entrada.Entera("Ingres premio para este nivel(numero (int)): ");
                nivelMaximo = i;// se acatuliza el nivel 
            } else {
                System.out.println("usted perdio");
                break;
            }
        }
        if (t) {
            System.out.println("Usted ha superado todos los niveles : total=" + premio);
            System.out.println("................");
        } else {
            System.out.println("Nivel maximo alcanzado: " + nivelMaximo + " premio=" + premio);
        }

        juego.setNivelMaximo(nivelMaximo);
        Date fecha = new Date();

        juego.setFecha(fecha.toString());
        juego.setPremio(premio);

        Juego.juegos.add(juego);

        Juego.informe.add(juego);// se almacena el juego en informe para mostrarlos luego
        //this.guardarjuego();
        //  PrcTermino.juego = null;
    }

    
    //mostrar los juegos realizado
    public void generarInforme() {
        System.out.println("Fecha de juego   Participante   Nivel Maximo Alcanzado   Premio");
        for (Juego juego : Juego.informe) {
            System.out.printf("%14s %12s %26d %5d\n", juego.getFecha().substring(0, 10), juego.getEstudiante().getMatricula(), juego.getNivelMaximo(), juego.getPremio());
        }
    }
}
