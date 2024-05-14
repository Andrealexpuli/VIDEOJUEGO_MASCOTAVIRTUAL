import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static Scanner sc = new Scanner(System.in);
    public static Mascota[] mascotasDisponibles = new Mascota[3];
    public static Menu menu = new Menu();
    public static ArrayList<Mascota> mascotasEstadisticas = new ArrayList<>();


    public static void main(String[] args) {
        String salir = "no";
        System.out.println("\n\n\n\t\t\t\t\t\t\t > PETVILLE <\n\n\t\t\t\t\t\t  !SALUDOS JUGADOR!" +
                "\n Me complace invitarle a PetVille el vibrante mundo de mascotas virtuales\n");
        System.out.println("\n\t\t\tPor favor pulse cualquier tecla para comenzar");
        sc.nextLine();
        do {
            salir = menu.menuInicio();
        } while (!salir.equalsIgnoreCase("si"));
    }

    public static void partida() {
        Mascota pet = mascotasDisponibles[menu.getPosicion() - 1];

        System.out.println("\n¡ENHORABUENA!\n " + pet.getNombre() + " ya se encuentra en PetVille lista para ser cuidada,\n!MUCHA SUERTE!\n");
        do {
            int i = 0;
            pet.setDormido(false);
            pet.crecer();
            do {
                System.out.println("---------------------------------------------------------------");
                System.out.println(" >> DIA: " + pet.getEdad() + " << ");
                System.out.println("---------------------------------------------------------------\n");

                pet.comprobarStats();
                pet.imprimirModelo();
                pet.avisos();
                pet.status();
                menu.menuPartida();
                pet.comprobarStats();
                i++;

            } while ((i < 3 && pet.isVida()) && menu.getOpcion() != 0);
            if (menu.getOpcion() != 0 && pet.isVida()) {
                pet.dormir();
                pet.comprobarStats();
                pet.imprimirModelo();
                pet.salud();
                contadorEnfermo(pet);
            }

        } while (pet.isVida() && menu.getOpcion() != 0);
        guardarMascotaEliminada(pet);
        if (!pet.isVida()) {
            System.out.println("             _____\n" +
                    "            | RIP |\n" +
                    "      ______|     |______\n" +
                    "         " + pet.getNombre() + " - " + pet.getEdad() + " Dias\n" +
                    "      ______       ______\n" +
                    "            |     |\n" +
                    "            |     |\n" +
                    "            |_____|\n");
            System.out.println("\n > GAME OVER <\n");
            System.out.println("\nPor favor pulse cualquier tecla para volver al menu principal");
            sc.nextLine();
        }
    }

    public static void contadorEnfermo(Mascota pet) {

        if (!pet.isSalud()) {
            pet.setContadorEnferma(pet.getContadorEnferma() + 1);
        }

    }

    public static void guardarMascotaEliminada(Mascota pet) {
        if (!pet.isVida()) {
            mascotasEstadisticas.add(pet);
            mascotasDisponibles[menu.getPosicion() - 1] = null;
        }
    }

    public static void imprimirEstadisticas() {
        Menu.clear();
        System.out.println("> PETVILLE: MENÚ ESTADÍSTICAS <");
        for (Mascota m : mascotasEstadisticas
        ) {
            System.out.println("\nNombre: " + m.getNombre() +
                    "\nDias Sobrevividos: " + m.getEdad() +
                    "\nDias enferma: " + m.getContadorEnferma() +
                    "\nVeces que ha comido: " + m.getContadorAlimentar() +
                    "\nVeces que ha jugado: " + m.getContadorJugar() +
                    "\nVeces que se ha bañado: " + m.getContadorLimpiar() +
                    "\n--------------------------------------");

        }
        System.out.println("\nPor favor pulse cualquier tecla para volver al menu principal");
        sc.nextLine();
    }
}
