package App;

import java.io.*;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

import Mascotas.*;
import Utils.*;

/**
 * @author Andrea Alexandra Pulido de la Serna
 * Clase Main perteneciente al paquete App.
 */
public class Main {
    public static Scanner sc = new Scanner(System.in);
    public static Mascota[] mascotasDisponibles = new Mascota[3];
    public static Menu menu = new Menu();
    public static ArrayList<Mascota> mascotasEstadisticas = new ArrayList<>();

    public static void main(String[] args) {
        String salir = "no";
        pantallaInicial();
        do {
            salir = menu.menuInicio();
        } while (!salir.equalsIgnoreCase("si"));
    }

    /**
     * muestra un mensaje nada mas iniciar el juego a modo de saludo
     */
    public static void pantallaInicial() {
        Menu.clear();
        System.out.println("\t██    " + ColorText.pink + "██████  ███████ ████████" + ColorText.green
                + " ██    ██ ██ ██      ██      ███████ " + ColorText.cleanse + "   ██ \n" +
                "\t ██   " + ColorText.pink + "██   ██ ██         ██  " + ColorText.green
                + "  ██    ██ ██ ██      ██      ██      " + ColorText.cleanse + "  ██  \n" +
                "\t  ██  " + ColorText.pink + "██████  █████      ██   " + ColorText.green
                + " ██    ██ ██ ██      ██      █████   " + ColorText.cleanse + " ██   \n" +
                "\t ██   " + ColorText.pink + "██      ██         ██   " + ColorText.green
                + "  ██  ██  ██ ██      ██      ██      " + ColorText.cleanse + "  ██  \n" +
                "\t██    " + ColorText.pink + "██      ███████    ██   " + ColorText.green
                + "   ████   ██ ███████ ███████ ███████ " + ColorText.cleanse + "   ██ ");
        System.out.println("\n\n\t!SALUDOS JUGADOR!" +
                "\n\tMe complace invitarle a PetVille el vibrante mundo de mascotas virtuales\n");
        System.out.println("\n\t" + ColorText.bold + ColorText.bBlue + ColorText.black
                + " Por favor pulse cualquier tecla para comenzar " + ColorText.cleanse);
        sc.nextLine();
    }

    /**
     * establece el patron de llamadas de metodos para la partida
     * muestra mensaje de inicio y de fin de partida
     */
    public static void partida() {
        Mascota pet = mascotasDisponibles[menu.getPosicion() - 1];

        System.out.println("\n\t" + ColorText.bold + ColorText.green + "¡ENHORABUENA! \n\t"
                + pet.getNombre() + " ya se encuentra en PetVille lista para ser cuidada \n\t" +
                "!MUCHA SUERTE! " + ColorText.cleanse + "\n");
        do {
            int i = 0;
            pet.setDormido(false);
            pet.crecer();
            do {
                System.out.println("\n\t" + ColorText.bold + ColorText.blue
                        + "--------------------------------------------------------" + ColorText.cleanse);
                System.out.println("\t" + ColorText.bold + ColorText.blue + " >> DIA: " + pet.getEdad()
                        + " <<                              " + ColorText.cleanse);
                System.out.println("\t" + ColorText.bold + ColorText.blue
                        + "--------------------------------------------------------" + ColorText.cleanse + "\n");

                pet.comprobarStats();
                pet.imprimirModelo();
                pet.avisos();
                menu.menuPartida();
                pet.comprobarStats();
                i++;

            } while ((i < 3 && pet.isVida()) && menu.getOpcion() != 0);
            if (menu.getOpcion() != 0 && pet.isVida()) {
                pet.dormir();
                pet.comprobarStats();
                pet.imprimirModelo();
                pet.salud();
                pet.aumentarContadorEnfermo();
            }

        } while (pet.isVida() && menu.getOpcion() != 0);
        guardarMascotaEliminada(pet);
        if (!pet.isVida()) {
            System.out.println("\n\n\n\n\t" + ColorText.bold + ColorText.bRed + ColorText.black + " Tristemente " + pet.getNombre()
                    + " no fue capaz de superar el día " + pet.getEdad() + " " + ColorText.cleanse);

            System.out.println("\n\n\t██     " + ColorText.red
                    + "██████   █████  ███    ███ ███████      ██████  ██    ██ ███████ ██████" + ColorText.cleanse
                    + "     ██ \n" +
                    "\t ██   " + ColorText.red
                    + "██       ██   ██ ████  ████ ██          ██    ██ ██    ██ ██      ██   ██" + ColorText.cleanse
                    + "   ██  \n" +
                    "\t  ██  " + ColorText.red
                    + "██   ███ ███████ ██ ████ ██ █████       ██    ██ ██    ██ █████   ██████" + ColorText.cleanse
                    + "   ██   \n" +
                    "\t ██   " + ColorText.red
                    + "██    ██ ██   ██ ██  ██  ██ ██          ██    ██  ██  ██  ██      ██   ██" + ColorText.cleanse
                    + "   ██  \n" +
                    "\t██     " + ColorText.red
                    + "██████  ██   ██ ██      ██ ███████      ██████    ████   ███████ ██   ██" + ColorText.cleanse
                    + "    ██ \n");
            System.out.println("\n\t" + ColorText.bold + ColorText.bBlue + ColorText.black
                    + " Por favor pulse cualquier tecla para volver al menu principal " + ColorText.cleanse);
            sc.nextLine();

        }
    }

    /**
     * guarda la mascota recien jugada y muerta en un arrayList
     *
     * @param pet Mascota el objeto mascota de la partida
     */
    public static void guardarMascotaEliminada(Mascota pet) {
        if (!pet.isVida()) {
            escribirFicheroEstadisticas(pet);
            mascotasEstadisticas.add(pet);
            mascotasDisponibles[menu.getPosicion() - 1] = null;
        }
    }

    /**
     * escribe las estadisticas de la partida recien perdida en el fichero Estadisticas
     *
     * @param pet Mascota de la ultima partida perdida
     */
    public static void escribirFicheroEstadisticas(Mascota pet) {
        try {
            String filePath = "Estadisticas.txt";
            FileWriter fw = new FileWriter(filePath, true);

            String texto = ("\n\tTipo: " + pet.tipoMascota() +
                    "\n\tNombre: " + pet.getNombre() +
                    "\n\tDias Sobrevividos: " + pet.getEdad() +
                    "\n\tDias enferma: " + pet.getContadorEnferma() +
                    "\n\tVeces que ha comido: " + pet.getContadorAlimentar() +
                    "\n\tVeces que ha jugado: " + pet.getContadorJugar() +
                    "\n\tVeces que se ha bañado: " + pet.getContadorLimpiar() +
                    "\n\t--------------------------------------");
            fw.write(texto);

            fw.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /**
     * imprime el contenido de estadisticas alojado en el fichero Estadisticas
     */
    public static void imprimirFicheroEstadisticas() {
        Menu.clear();
        System.out.println("\n\t██    " + ColorText.blue + "███████  ██████  ██████  ██████  ███████"
                + ColorText.cleanse + "    ██ \n" +
                "\t ██   " + ColorText.blue + "██      ██      ██    ██ ██   ██ ██" + ColorText.cleanse
                + "        ██  \n" +
                "\t  ██  " + ColorText.blue + "███████ ██      ██    ██ ██████  █████" + ColorText.cleanse
                + "    ██   \n" +
                "\t ██        " + ColorText.blue + "██ ██      ██    ██ ██   ██ ██" + ColorText.cleanse
                + "        ██  \n" +
                "\t██    " + ColorText.blue + "███████  ██████  ██████  ██   ██ ███████ " + ColorText.cleanse
                + "   ██");
        try {
            File archivo = new File("Estadisticas.txt");
            Scanner lector = new Scanner(archivo);
            for (int i = 0; i < archivo.length(); i++) {
                System.out.println(lector.nextLine());
            }
            lector.close();
            if (archivo.length() == 0) {
                throw new EstadisticasVacias();
            }
        } catch (EstadisticasVacias ev) {
            System.out.println(ev.getMessage());
        } catch (FileNotFoundException fnfe) {
            System.out.println(fnfe.getMessage());
        } catch (NoSuchElementException nsee) {
            System.out.println("\t" + ColorText.bold + ColorText.bYellow + ColorText.black
                    + " > No hay más estadísticas < " + ColorText.cleanse);
        }

        System.out.println("\n\t" + ColorText.bold + ColorText.bBlue + ColorText.black
                + " Por favor pulse cualquier tecla para volver al menu principal " + ColorText.cleanse);
        sc.nextLine();
    }

}

/**
 * clase que hereda de Excepcion, creada para la ejecucion de una excepcion personal
 * detecta si el fichero esta vacio e imprime mensaje de aviso
 */
class EstadisticasVacias extends Exception {
    public EstadisticasVacias() {
        super("\n\t" + ColorText.bold + ColorText.bYellow + ColorText.black
                + " Aun no has perdido ninguna partida, cuando lo hagas vuelve para ver sus estadisticas :D "
                + ColorText.cleanse);
    }
}