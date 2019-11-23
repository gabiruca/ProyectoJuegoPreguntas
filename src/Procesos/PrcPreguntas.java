/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Procesos;

import Entidades.Estudiante;
import Entidades.Materia;
import Entidades.Pregunta;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PC
 */
public class PrcPreguntas {

    public void guardarArchivo(Materia materia) {
        FileWriter writer = null;
        try {
            String ruta = "src/archivosPreguntas/preguntas" + materia.getNombre() + ".csv"; //ruta del archivo que se va a leer
            writer = new FileWriter(ruta, false);
            for (Pregunta pregunta : materia.getPreguntas()) {
                writer.write(pregunta.getPregunta() + ";" + pregunta.getNivel() + ";" + pregunta.getResCorrepta() + ";" + pregunta.getRespuestas().get(0) + ";" + pregunta.getRespuestas().get(1) + ";" + pregunta.getRespuestas().get(2) + "\n");
            }
            System.out.println("Archio Actualizado");
            writer.close();
        } catch (IOException ex) {

        } finally {
            try {
                writer.close();
            } catch (IOException ex) {

            }
        }
    }

    public void inicializarPreguntas() {
        File archivo;
        archivo = new File("src/archivosPreguntas");
        // if(archivo.isDirectory()){
        File[] lista = archivo.listFiles();
        for (int i = 0; i < lista.length; i++) {
            String nombre = (lista[i].getName().substring(9));
            for (Materia materia : Materia.materiasAct) {
                if ((materia.getNombre() + ".csv").equalsIgnoreCase(nombre)) {
                    BufferedReader csvReader = null;
                    try {
                        csvReader = new BufferedReader(new FileReader(lista[i]));
                        String fila;// = csvReader.readLine();//escapar cabecera de archivo
                        while ((fila = csvReader.readLine()) != null) { //iterar en el contenido del archivo
                            String[] data = fila.split(";");
                            Pregunta p = new Pregunta(data[0]);
                            p.validarNivel(materia, Integer.parseInt(data[1]));
                            p.setResCorrepta(data[2]);
                            p.agregarRespuesta(data[3]);
                            p.agregarRespuesta(data[4]);
                            p.agregarRespuesta(data[5]);
                            materia.getPreguntas().add(p);

                        }
                    } catch (FileNotFoundException ex) {
                    } catch (IOException ex) {
                    } finally {
                        try {
                            csvReader.close();
                        } catch (IOException ex) {
                        }
                    }
                }
            }

        }

    }

    public void visualizarPreguntas() {
        Entrada entrada = new Entrada();
        int i = 1;
        System.out.println("VISUALIZACION DE PREGUNTAS");
        System.out.println("Seleccione materia");
        if (Materia.materiasAct.size()!=0){
        for (Materia m : Materia.materiasAct) {
            System.out.println(i + ". " + m);
            i++;
        }
        int opc = entrada.Entera("Ingrese opción(1-" + (i - 1) + "): ");
        Materia materia = Materia.materiasAct.get(opc - 1);
        i = 1;
        if(materia.getPreguntas().size()!=0){
         System.out.println("...................................");
        for (Pregunta p : materia.getPreguntas()) {
            System.out.println(i + ".- " + p);
            System.out.println();
            i++;
        }
        }else {
            System.out.println("No hay preguntas");
        }
        }else {
            System.out.println("No hay materias disponibles");
        }
    }

    public void agregarPreguntas() {
        Entrada entrada = new Entrada();
        int i = 1;
        if (Materia.materiasAct.size() != 0) {
            for (Materia m : Materia.materiasAct) {
                System.out.println(i + ". " + m);
                i++;
            }
            int opc;
            do {
                opc = entrada.Entera("Ingrese opcion(1-" + (i - 1) + "): ");
                if (!(opc >= 1 && opc <= (i - 1))) {
                    System.out.println("opcion no valida");
                }
            } while (!(opc >= 1 && opc <= (i - 1)));
            Materia materia = Materia.materiasAct.get(opc - 1);
            System.out.println("Niveles permitido hasta " + materia.getNiveles());
            String pregunta = entrada.Cadena("INGRESE PREGUNTA");
            String resCor = entrada.Cadena("Ingrese Respuesta Correpta: ");
            String resB = entrada.Cadena("Ingrese posible respuesta 1: ");
            String resC = entrada.Cadena("Ingrese posible respuesta 2: ");
            String resD = entrada.Cadena("Ingrese Posible respuesta 3:");
            Pregunta p = new Pregunta(pregunta);
            p.setResCorrepta(resCor);
            p.agregarRespuesta(resB);
            p.agregarRespuesta(resC);
            p.agregarRespuesta(resD);
            materia.getPreguntas().add(p);
            this.guardarArchivo(materia);
        } else {
            System.out.println("No hay materia Activas");
        }
    }

    public void eliminarPreguntas() {
        Entrada entrada = new Entrada();
        int i = 1;
        System.out.println("Seleccione materia");
        if (Materia.materiasAct.size() != 0) {
            for (Materia m : Materia.materiasAct) {
                System.out.println(i + ". " + m);
                i++;
            }
            int opc;
            do {
                opc = entrada.Entera("Ingrese opcion(1-" + (i - 1) + "): ");
                if (!(opc >= 1 && opc <= (i - 1))) {
                    System.out.println("opcion no valida");
                }
            } while (!(opc >= 1 && opc <= (i - 1)));
            Materia materia = Materia.materiasAct.get(opc - 1);
            i = 1;
            System.out.println("Seleccione pregunta");
            if (materia.getPreguntas().size() != 0) {
                for (Pregunta p : materia.getPreguntas()) {
                    System.out.println(i + ".- " + p.getPregunta());
                    System.out.println();
                    i++;
                }
                do {
                    opc = entrada.Entera("Ingrese opcion(1-" + (i - 1) + "): ");
                    if (!(opc >= 1 && opc <= (i - 1))) {
                        System.out.println("opcion no valida");
                    }
                } while (!(opc >= 1 && opc <= (i - 1)));
                materia.getPreguntas().remove(opc - 1);
                System.out.println("Pregunta eliminada");
                this.guardarArchivo(materia);
            } else {
                System.out.println("No hay preguntas para eliminar");
            }
        } else {
            System.out.println("No hay materias disponibles");
        }
    }
}
