/*
 Clase que contiene el juego del proyecto
 */
package entidades;

import Procesos.Entrada;
import Procesos.PrcJuego;
import java.util.ArrayList;
import java.util.Map;
import java.util.Random;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;

/**
 *
 * @Walter Gonzalez
 */
public class Juego {

    public static ArrayList<Juego> juegos = new ArrayList<>(0);
    public static ArrayList<Juego> informe = new ArrayList<>();
    private Estudiante compranero;
    private Termino termino = null;
    private String fecha;
    private Materia materia;
    private String matricula;
    private Estudiante estudiante;
    private Paralelo paralelo;
    private int nivelMaximo, premio;
    private ArrayList<Integer> niveles = new ArrayList<Integer>();
    private ArrayList<ArrayList<Pregunta>> preguntasNiveles = new ArrayList<>();

    public Juego() {
    }

    public Juego(Termino termino) {
        this.termino = termino;
    }

    public ArrayList<Integer> getNiveles() {
        return this.niveles;
    }

    public static void inicializarJuego(Juego juego) {
        int opc;
        Entrada entrada = new Entrada();
        if (juego != null) {
            System.out.println("Seleccionar Materia");
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
                System.out.println("Seleccione paralelo");
                ArrayList<Paralelo> par = new ArrayList<>();
                for (Paralelo p : materia.getParalelos()) {
                    if (juego.getTermino().equals(p.getTermino())) {
                        System.out.println(i + ". " + p);
                        par.add(p);
                        i++;
                    }
                }
                if (i != 1) {
                    do {
                        opc = entrada.Entera("Ingrese opción(1-" + (i - 1) + "): ");
                        if (!(opc >= 1 && opc <= (i - 1))) {
                            System.out.println("Entrada no valida");
                        }
                    } while (!(opc >= 1 && opc <= (i - 1)));
                    Paralelo paralelo = par.get(opc - 1);
                    juego.paralelo = paralelo;
                    SortedMap<Integer, ArrayList<Pregunta>> numPreguntas = Juego.valPreguntasNivel(materia);
                    System.out.println("Ingresar numero de preguntas por nivel");
                    for (Map.Entry<Integer, ArrayList<Pregunta>> s : numPreguntas.entrySet()) {
                        juego.niveles.add(s.getKey());
                        Random ran = new Random();
                        int num;
                        do {
                            num = entrada.Entera("nivel #" + s.getKey() + "(1-:" + s.getValue().size() + "): ");
                            if (num > s.getValue().size() || num < 1) {
                                System.out.println("No existe dicho número de pregunta..");
                            }
                        } while (num > s.getValue().size() || num < 1);
                        int contador = 0;
                        int aleatorio;
                        ArrayList<Pregunta> arreglo = new ArrayList<Pregunta>();
                        do {
                            aleatorio = ran.nextInt(s.getValue().size());
                            Pregunta prg = s.getValue().get(aleatorio);
                            arreglo.add(prg);
                            contador++;
                        } while (contador < num);
                        juego.preguntasNiveles.add(arreglo);
                    }
                    System.out.println("Seleccionar estudiante");
                    i = 1;
                    for (Estudiante estudiante : paralelo.getEstudiantes()) {
                        System.out.println(i + "." + estudiante.getMatricula());
                        i++;
                    }
                    do {
                        opc = entrada.Entera("Ingrese opción(1-" + (i - 1) + "): ");
                        if (!(opc >= 1 && opc <= (i - 1))) {
                            System.out.println("Entrada no valida");
                        }
                    } while (!(opc >= 1 && opc <= (i - 1)));
                    Estudiante estudiante = paralelo.getEstudiantes().get(opc - 1);
                    juego.setEstudiante(estudiante);
                    System.out.println("Seleccione compañero");
                    i = 1;
                    for (Estudiante est : paralelo.getEstudiantes()) {
                        System.out.println(i + "." + est.getMatricula());
                        i++;
                    }
                    do {
                        opc = entrada.Entera("Ingrese opción(1-" + (i - 1) + "): ");
                        if (!(opc >= 1 && opc <= (i - 1))) {
                            System.out.println("Entrada no valida");
                        }
                    } while (!(opc >= 1 && opc <= (i - 1)));
                    Estudiante comp = paralelo.getEstudiantes().get(opc - 1);
                    juego.compranero = comp;
                    juego.setMateria(materia);
                    PrcJuego prcJuego = new PrcJuego();
                    prcJuego.comenzarJuego();
                } else {
                    System.out.println("NO EXISTEN PARALELOS");
                }
            } else {
                System.out.println("No existen materias activas");
            }
        } else {
            System.out.println("No ha estalecido termino academico para el juego\nDIRIJACE AL MENU PRINCIPAL 1.CONFIGURACIONES 2.ADMINISTRAR TERMINOS");
        }
    }

    public static SortedMap<Integer, ArrayList<Pregunta>> valPreguntasNivel(Materia materia) {
        int niveles = materia.getNiveles();
        SortedMap<Integer, ArrayList<Pregunta>> mapa = new TreeMap<Integer, ArrayList<Pregunta>>();
        for (Pregunta pregunta : materia.getPreguntas()) {
            if (mapa.containsKey(pregunta.getNivel())) {
                mapa.get(pregunta.getNivel()).add(pregunta);
            } else {
                ArrayList<Pregunta> p = new ArrayList<Pregunta>();
                p.add(pregunta);
                mapa.put(pregunta.getNivel(), p);
            }
        }

        return mapa;
    }

    /**
     * @return the termino
     */
    public Termino getTermino() {
        return termino;
    }

    /**
     * @param termino the termino to set
     */
    public void setTermino(Termino termino) {
        this.termino = termino;
    }

    /**
     * @return the estudiante
     */
    public Estudiante getEstudiante() {
        return estudiante;
    }

    /**
     * @param estudiante the estudiante to set
     */
    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    /**
     * @return the preguntasNiveles
     */
    public ArrayList<ArrayList<Pregunta>> getPreguntasNiveles() {
        return preguntasNiveles;
    }

    /**
     * @param preguntasNiveles the preguntasNiveles to set
     */
    public void setPreguntasNiveles(ArrayList<ArrayList<Pregunta>> preguntasNiveles) {
        this.preguntasNiveles = preguntasNiveles;
    }

    /**
     * @return the nivelMaximo
     */
    public int getNivelMaximo() {
        return nivelMaximo;
    }

    /**
     * @param nivelMaximo the nivelMaximo to set
     */
    public void setNivelMaximo(int nivelMaximo) {
        this.nivelMaximo = nivelMaximo;
    }

    /**
     * @return the premio
     */
    public int getPremio() {
        return premio;
    }

    /**
     * @param premio the premio to set
     */
    public void setPremio(int premio) {
        this.premio = premio;
    }

    /**
     * @return the fecha
     */
    public String getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    /**
     * @return the matricula
     */
    public String getMatricula() {
        return matricula;
    }

    /**
     * @param matricula the matricula to set
     */
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    /**
     * @return the compranero
     */
    public Estudiante getCompranero() {
        return compranero;
    }

    /**
     * @param compranero the compranero to set
     */
    public void setCompranero(Estudiante compranero) {
        this.compranero = compranero;
    }

    /**
     * @return the materia
     */
    public Materia getMateria() {
        return materia;
    }

    /**
     * @param materia the materia to set
     */
    public void setMateria(Materia materia) {
        this.materia = materia;
    }

    /**
     * @return the paralelo
     */
    public Paralelo getParalelo() {
        return paralelo;
    }

    /**
     * @param paralelo the paralelo to set
     */
    public void setParalelo(Paralelo paralelo) {
        this.paralelo = paralelo;
    }
}