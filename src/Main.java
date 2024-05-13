import java.util.Scanner;

public class Main {
    public static Scanner sc = new Scanner(System.in);
    public static Mascota[] mascotasDisponibles = new Mascota[3];
    public static Menu menu = new Menu();


    public static void main(String[] args) {
    String salir = "no";
        do {
            salir = menu.menuInicio();
        } while(!salir.equalsIgnoreCase("si"));
    }

    public static void partida() {
        Mascota pet = mascotasDisponibles[menu.getPosicion() - 1];

        System.out.println("\nTu mascota " + pet.getNombre() + " esta lista para ser cuidada, !Mucha suerte!\n");
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
                pet.comprobarStats();
                pet.dormir();
                pet.imprimirModelo();
                pet.salud();
            }

        } while (pet.isVida() && menu.getOpcion() != 0);

        System.out.println(" > GAME OVER <");
    }

}
