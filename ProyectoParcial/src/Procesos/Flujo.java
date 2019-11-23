/**esta clase controla el flujo de ejecucion del rpograma, direcciona el hilo del programa a determinada instancia 
o metodo para seguir con la siguiente linea de codigo**/
package Procesos;
import static Procesos.PrcTermino.juego;
import Entidades.Juego;
import proyectoprimerparcial.pkg2019ii.Menus;

/**
 *
 * @author Gabriela
 */
public class Flujo {
    private int opc;

    //Aqui en el metodo inicio se muestra el menu principal del programa
    //Tambien se controla el flujo del programa segun las opciones que ingrese el usuario dado el menu
    public void Inicio() {
        Menus menu = new Menus();
        do {
            Entrada entrada = new Entrada();
            menu.menuIncio();
            opc = entrada.Entera("Ingrese una opción: ");
            switch (opc) {//manda al metodo o clase correspondiente para continuar el flujo del programa
                case 1:
                    this.configuraciones();//esta representa la primera opcion del menu principal (configuraciones), llama al metodo configuraciones de la clase actual, el cual maneja el flujo de las opciones de menu de configuraciones
                    break;
                case 2:
                    Juego.inicializarJuego(juego);// llama al metodo estatico IncializaJuego el cual permite la seleccion de materia y paralelo, para seleccionar el estudiante y el numero de preguntas por nivel y asi comenzar el juego 
                    break;
                case 3:
                    (new PrcJuego()).generarInforme();//genera el informe(solo los que se realizan durante la ejecucion, es decir los de memoria ram)
                    break;
                case 4:
                    return;//retorna al main() y finaliza la ejecucion
                default:
                    System.out.println("Entrada no valida");
                    break;
            }
        } while (opc != 4);
    }

    //controla el flujo luejgo de seleccionar la opcion configuraciones del menu principal
    public void configuraciones() {
        Menus menu = new Menus();
        do {
            Entrada entrada = new Entrada();
            menu.menuIncioOpc1();
            opc = entrada.Entera("Ingrese una opción: ");
            switch (opc) {
                case 1:
                    this.configuracionesOpc1();
                    break;
                case 2:
                    this.configuracionesOpc2();
                    break;
                case 3:
                    this.configuracionesOpc3();
                    break;
                case 4:
                    this.configuracionesOpc4();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Entrada no valida");
                    break;
            }
        } while (opc != 5);
    }

    //este metodo es para las opciones de temino academico
    public void configuracionesOpc1() {
        Menus menu = menu = new Menus();
        PrcTermino prcTermino = new PrcTermino();//se instancia un objeto tipo Prctermino el cual contiene metodos para las distintas operaciones referente a los terminos academicos
        do {
            Entrada entrada = new Entrada();
            menu.menuInicioOpc1_1();
            opc = entrada.Entera("Ingrese Opción: ");
            switch (opc) {
                case 1:
                    prcTermino.ingresoTermino();//
                    break;
                case 2:
                    prcTermino.eliminarTermino();
                    break;
                case 3:
                    prcTermino.configurarTemrino();
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Entrada no valida");
                    break;
            }
        } while (opc != 4);
    }

    //para las opciones referentes a materia y/o paralelos
    public void configuracionesOpc2() {
        Menus menu = menu = new Menus();
        PrcMaterias prcMateria = new PrcMaterias();//este objeto contienen metodods para las distintas peraciones relacionadas con las materias
        PrcParalelos prcParalelo = new PrcParalelos();//este metodod contiene metodos para las distintas operaciones relacionada con los paralelos
        do {
            Entrada entrada = new Entrada();
            menu.menuInicioOpc1_2();
            opc = entrada.Entera("Ingrese Opción: ");
            switch (opc) {
                case 1:
                    prcMateria.ingresaarMaterias();
                    break;
                case 2:
                    prcMateria.editarMateria();
                    break;
                case 3:
                    prcMateria.desactivarMateria();
                    break;
                case 4:
                    prcParalelo.agregarParalelo();
                    break;
                case 5:
                    prcParalelo.eliminarParaelo();
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Entrada no valida");
                    break;
            }
        } while (opc != 6);
    }

    public void configuracionesOpc3() {
        PrcEstudiantes prcEstudiante = new PrcEstudiantes();
        prcEstudiante.visualizarEstudiantes();//para visualizar estudiantes
    }

    //para las diferentes opciones en relacion a las preguntas
    public void configuracionesOpc4() {
        Menus menu = menu = new Menus();
        PrcPreguntas preguntas = new PrcPreguntas();
        do {
            Entrada entrada = new Entrada();
            menu.menuInicioOpc1_4();
            opc = entrada.Entera("Ingrese Opción: ");
            switch (opc) {
                case 1:
                    preguntas.visualizarPreguntas();
                    break;
                case 2:
                    preguntas.agregarPreguntas();
                    break;
                case 3:
                    preguntas.eliminarPreguntas();
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Entrada no valida");
                    break;
            }
        } while (opc != 4);
    }
}
