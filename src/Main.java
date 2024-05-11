import java.util.Scanner;

public class Main {
    public static Scanner sc = new Scanner(System.in);
    public static Mascota[] mascotasDisponibles = new Mascota[3];

    public static void main(String[] args) {

        menuInicio();
    }

    public static void menuInicio() {

        int opcion = 0;
        do {
            System.out.println(" >> MASCOTA VIRTUAL << ");
            System.out.println("\nBienvenid@ al menú de inicio, a continuación le mostramos las opciones disponibles: ");
            System.out.println("\n\t1) Crear nueva mascota \n\t2) Jugar \n\t3) Estadísticas \n\t4) Salir");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    int posicion = menuCrearMascota();
                    if (posicion != 0){
                        crearMascota(posicion);
                    }

                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    System.out.println(" > PROGRAMA FINALIZADO < ");
                    break;
                default:
                    System.out.println("opcion no disponible");
                    break;
            }
        } while (opcion != 4);
    }

    public static int menuCrearMascota() {
        int eleccion = 0;
        int posicion = 0;

        do {
            eleccion = 0;
            System.out.println("Espacios disponibles para crear una mascota: \n");
            int i = 1;
            for (Mascota m : mascotasDisponibles) {
                if (m == null) {
                    System.out.println("\t" + i++ + ") espacio disponible");
                } else {
                    System.out.println("\t" + i++ + ") " + m.getNombre() + ", " + m.getEdad() + " Dias");

                }
            }
            System.out.println("\t0) Volver atrás");
            System.out.println("\nSeleccione el espacio que desee para guardar su nueva mascota: ");
            posicion = sc.nextInt();

            if(posicion != 0) {
                if (mascotasDisponibles[posicion - 1] != null) {
                    System.out.println("El espacio elegido ya tiene una mascota creada, si acepta se eliminará permanentemente la mascota, ¿desea continuar? \n\t1) continuar \n\t2) volver atrás");
                    eleccion = sc.nextInt();
                }
            } else {
                System.out.println("Volviendo al menú Principal");
            }
        } while (eleccion == 2);

        return posicion;
    }
        public static void crearMascota(int posicion) {

            System.out.println("¿Qué tipo de mascota quiere crear? ");
            System.out.println("\n\t1) Conejo \n\t2) Gato \n\t3) Pájaro");
            int tipoMascota = sc.nextInt();
            sc.nextLine();

            switch (tipoMascota) {
                case 1:
                    System.out.println("El breves tendremos a su Conejo listo, pero primero... \n¿Qué nombre quieres ponerle?: ");
                    String nombreConejo = sc.nextLine();
                    Conejo pet = new Conejo(nombreConejo);
                    mascotasDisponibles[posicion - 1] = pet;
                    System.out.println("\nTu mascota " + pet.getNombre() + " ha sido creada correctamente y ya se encuentra disponible para jugar\n");
                    break;

                default:
                    System.out.println("opción no valida");
                    break;
            }
        }

    }
