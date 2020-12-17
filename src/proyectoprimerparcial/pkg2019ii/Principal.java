/*
 Clase que contiene el main principal del proyecto
 */
package proyectoprimerparcial.pkg2019ii;

import Procesos.Flujo;
import Procesos.PrcJuego;
import Procesos.PrcPreguntas;
import Entidades.Estudiante;
import Entidades.Materia;
import Entidades.Paralelo;
import Entidades.Termino;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Walter Gonzalez
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //PrcJuego prcJuego=new PrcJuego();
        //prcJuego.incializarPartidas();
        Principal.inicializar();//se inicializa  el juego con los estudiantes registrados 
        PrcPreguntas prcPreguntas=new PrcPreguntas();
        prcPreguntas.inicializarPreguntas();//se inicializaran las preguntas establecidas para la materia registra por defecto al inicializar los estudiantes
        Flujo flujo=new Flujo();//esta clase controla el flujo del programa(los menus)
        
        flujo.Inicio();//llama al primer flujo que es el menu princpal(ir al paquete Procesos )
    }
    //en este metodo se inicializa el archivo estudiante dado en el proyectp
    public static void inicializar(){        
        BufferedReader csvReader = null;
        try {
            String ruta = "src/archivoEstudiantes/CCPG1005-2-2019-2.csv"; //ruta del archivo que se va a leer
            Materia materia=new Materia("CCPG1005","POO",3);//se instancia un objeto de la clase materia
            Materia.materias.add(materia);//se guarda la materia en el arreglo(atributo estatico de la clase) servira para aceder a las materias registradas
            Materia.materiasAct.add(materia);// la misma instancia se guarda en este arreglo de la clase materia(aqui estan toddas las materias activa), inicialmente todas estaran activas
            Termino termino=new Termino(2019,2);//se instancia el termino al cual pertenecen los estudiantes del archivo 
            Paralelo paralelo=new Paralelo(termino,2);//se instancia el paralelo al cual pertence los estudiantes del archivo
            materia.getParalelos().add(paralelo);//la materia instanciada tiene como atributo un arreglo con todos los paralelos de dicha materia
            Termino.terminos.add(termino);//se registra el termino en un atributo de clase(arreglo), el cual permitira aceder a los terminos regustrados
            csvReader = new BufferedReader(new FileReader(ruta));
            String fila;// = csvReader.readLine();//escapar cabecera de archivo
            while ((fila = csvReader.readLine()) != null) { //iterar en el contenido del archivo
                String[] data = fila.split(",");
                paralelo.getEstudiantes().add(new Estudiante(data[0], data[1], data[2])); //crear objeto y agregar a lista
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Estudiante.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Estudiante.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                csvReader.close();
            } catch (IOException ex) {
                Logger.getLogger(Estudiante.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }   
    
}
