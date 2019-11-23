
package Procesos;
import entidades.Juego;
import entidades.Termino;
/**
 *
 * @author Gabriela
 */
public class PrcTermino {
    private Termino t;
    public static Juego juego;

    //En este metodo se pueden ingresar terminos academicos en el sistema
    public void ingresoTermino() {
        System.out.println("......................");
        System.out.println("Ingreso de Termino Academico");
        Entrada entrada = new Entrada();
        Termino termino;
        do {
            termino = new Termino(entrada.Entera("Ingrese año   : "), entrada.Entera("Ingrese número:"));
            if (Termino.terminos.contains(termino)) {//valida que el termino instanciado no este ya registrado, es decir que no este en el arraylIST (de clase) termino
                System.out.println("Termino ya existe ingrese otro");
            }
        } while (Termino.terminos.contains(termino));
        Termino.terminos.add(termino);
        System.out.println("Termino ingresado");
    }

    //Elimina el termino seleccionado
    public void eliminarTermino() {
        System.out.println("......................");
        System.out.println("Eliminar Termino Academico");
        int i = 1;
        Entrada entrada = new Entrada();
        for (Termino t : Termino.terminos) {
            System.out.println(i + ". " + t);
            i++;
        }
        if (i != 1) {
            int opc;
            do {
                opc = entrada.Entera("Ingrese opcion(1-" + (i - 1) + "): ");
                if (!(opc >= 1 && opc <= (i - 1))) {
                    System.out.println("opcion no valida");
                }
            } while (!(opc >= 1 && opc <= (i - 1)));
            Termino.terminos.remove(opc - 1);
            System.out.println("Termino Eliminado");
        } else {
            System.out.println("No existen terminos");
        }
    }

    //Permite configurar el termino academico
    public void configurarTermino() {
        System.out.println("......................");
        System.out.println("Seleccionar Termino Academico para el juego");
        int i = 1;
        if (Termino.terminos.size() != 0) {
            for (Termino t : Termino.terminos) {
                System.out.println(i + ". " + t);
                i++;
            }
            Entrada entrada = new Entrada();
            int opc;
            do {
                opc = entrada.Entera("Ingrese opcion(1-" + (i - 1) + "): ");
                if (!(opc >= 1 && opc <= (i - 1))) {
                    System.out.println("opcion no valida");
                }
            } while (!(opc >= 1 && opc <= (i - 1)));
            this.t = Termino.terminos.get(opc - 1);
            Juego juego = new Juego(t);
            PrcTermino.juego = juego;
        } else {
            System.out.println("No hay terminos academicos registrados");
        }
    }
}
