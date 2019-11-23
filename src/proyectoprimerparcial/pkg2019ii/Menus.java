/*
 *Clase donde se describen las opciones de menus
 */
package proyectoprimerparcial.pkg2019ii;

/**
 *
 * @author Walter Gonzalez
 */
public class Menus {

    public void menuIncio() {
        System.out.println("1. Configuraciones\n"
                + "2. Nuevo juego\n"
                + "3. Reporte\n"
                + "4. Salir");
    }

    public void menuIncioOpc1() {
        System.out.println("1. Administrar términos académicos\n"
                + "2. Administrar materias y paralelos\n"
                + "3. Administrar estudiantes\n"
                + "4. Administrar preguntas\n"
                + "5. Salir");
    }

    public void menuInicioOpc1_1() {
        System.out.println("1.- Ingresar término\n"
                + "2.- Eliminar término\n"
                + "3.- Configurar término para el juego\n"
                + "4.- Salir");
    }

    public void menuInicioOpc1_2() {
        System.out.println("1.- Ingresar materia\n"
                + "2.- Editar materia\n"
                + "3.- Desactivar materia\n"
                + "4.- Agregar paralelo\n"
                + "5.- Eliminar paralelo\n"
                + "6.- Salir");
    }

    public void menuInicioOpc1_4() {
        System.out.println("1.- Visualizar preguntas\n"
                + "2.- Agregar pregunta\n"
                + "3.- Eliminar pregunta\n"
                + "4.- Salir");
    }

}
