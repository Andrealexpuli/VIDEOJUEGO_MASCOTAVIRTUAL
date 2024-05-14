import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    public static Scanner sc = new Scanner(System.in);
    private int opcion = -1;
    private int posicion = -1;

    public Menu() {
    }

    ;

    public int getOpcion() {
        return opcion;
    }

    public void setOpcion(int opcion) {
        this.opcion = opcion;
    }

    public int getPosicion() {
        return posicion;
    }

    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }

    public String menuInicio() {
        String salir = "no";

        do {
            clear();
            System.out.println(" >> PETVILLE: MENÚ PRINCIPAL << ");
            System.out.println("\nBienvenid@ al menú de inicio, a continuación le mostramos las opciones disponibles: ");
            System.out.println("\n\t1) Partida nueva \n\t2) Cargar partida \n\t3) Estadísticas \n\t0) Salir");
            do {
                leerOpcion();
                if(opcion > 0 && opcion < 3){
                clear();}
                switch (opcion) {
                    case 1:
                        menuCrearMascota();
                        if (posicion != 0) {
                            crearMascota();
                            menuEleccionJugar();
                        }
                        break;
                    case 2:
                        menuCargarPartida();
                        if (posicion != 0) {
                            Main.partida();
                        }
                        break;
                    case 3:
                        Main.imprimirEstadisticas();
                        break;
                    case 0:
                        System.out.println("¿Seguro que quiere salir? \n(Si esta seguro escriba: SI)");
                        salir = sc.nextLine();

                        break;
                    default:
                        System.out.println("opcion no disponible");
                        break;
                }
            }while (opcion < 0 || opcion > 3);
        } while (opcion != 0);
        return salir;
    }

    public void menuCrearMascota() {
        System.out.println(" >> PETVILLE: MENÚ PARTIDA NUEVA << ");
        System.out.println("\nAsi que quieres comenzar una nueva partida, ¡MUY BIEN!");
        do {
            opcion = 0;
            System.out.println("Espacios de guardado disponibles: \n");
            int i = 1;
            for (Mascota m : Main.mascotasDisponibles) {
                if (m == null) {
                    System.out.println("\t" + i++ + ") espacio disponible");
                } else {
                    System.out.println("\t" + i++ + ") " + m.getNombre() + ", " + m.getEdad() + " Dias");

                }
            }
            System.out.println("\t0) Volver atrás");
            System.out.println("\nSeleccione el espacio que desee para guardar su nueva mascota: ");
            leerPosicion();
            clear();
            if (posicion != 0) {
                if (Main.mascotasDisponibles[posicion - 1] != null) {
                    System.out.println("El espacio elegido ya tiene una mascota creada, si acepta se eliminará permanentemente la mascota, \n¿Desea continuar? \n\n\t1) Continuar \n\t2) Volver atrás");
                    do {
                        leerOpcion();
                        if(opcion != 1 && opcion != 2){
                            System.out.println("Opcion no valida, por favor introduzca un valor entre (1-2): ");
                        }
                    }while (opcion != 1 && opcion != 2);
                    clear();
                }
            } else {
                System.out.println("Volviendo al menú Principal");
            }


        } while (opcion == 2);

    }

    public void crearMascota() {

        System.out.println("¿Qué tipo de mascota quiere crear? ");
        System.out.println("\n\t1) Conejo \n\t2) Gato \n\t3) Pájaro");
        leerOpcion();
        clear();
        switch (opcion) {
            case 1:
                System.out.println("En breves tendremos a su Conejo listo, pero primero... \n¿Qué nombre quieres ponerle?: ");
                String nombreConejo = leerNombre();
                Conejo pet = new Conejo(nombreConejo);
                Main.mascotasDisponibles[posicion - 1] = pet;
                break;

            default:
                System.out.println("Opción no valida");
                break;
        }
    }
    public void menuEleccionJugar(){
        Mascota pet = Main.mascotasDisponibles[posicion - 1];
        clear();
        System.out.println("Su mascota " + pet.getNombre()+ " ha sido creada correctamente y ya se encuentra disponible para jugar,\n¿Desea comenzar la partida?\n\n\t1) Continuar \n\t2) Volver al menú principal");
        do {
            leerOpcion();
            if(opcion != 1 && opcion != 2){
                System.out.println("Opcion no valida, por favor introduzca un valor entre (1-2): ");
            }
        }while (opcion != 1 && opcion != 2);
        clear();
        if(opcion == 1){
            Main.partida();
        }
    }

    public void leerOpcion() {
        opcion = -1;
        do {
            try {
                opcion = sc.nextInt();
            } catch (InputMismatchException ime) {
                System.out.println("Solo se admiten valores enteros, por favor introduzca un valor correcto: ");
            }
            sc.nextLine();

        } while (opcion == -1);
    }

    public void leerPosicion() {

        do {
                try {
                    posicion = sc.nextInt();
                    if (posicion > Main.mascotasDisponibles.length || posicion < 0) {
                        System.out.println("Espacio no existente. \nSeleccione un espacio entre ( 1 - 3 ) ");
                    }

                } catch (InputMismatchException ime) {
                    System.out.println("Solo se admiten valores enteros, por favor introduzca un valor correcto: ");
                }
                sc.nextLine();

        } while (posicion > Main.mascotasDisponibles.length || posicion < 0);
    }
    public String leerNombre(){
        String nombre = sc.nextLine();
        return nombre.substring(0, 1).toUpperCase() + nombre.substring(1).toLowerCase();
    }

    public void menuPartida() {
        Mascota pet = Main.mascotasDisponibles[posicion - 1];
        if (pet.isSalud()) {
            System.out.println("(1) Alimentar\t(2) Bañar\t(3) Jugar\t(0) Salir");
        } else {
            System.out.println("(1) Alimentar\t(2) Bañar\t(3) Jugar\t(4) Curar\t(0) Salir");
        }
        leerOpcion();
        switch (opcion) {
            case 1:
                pet.alimentar();
                break;
            case 2:
                pet.limpiar();
                break;
            case 3:
                pet.jugar();
                break;
            case 4:
                if (!pet.isSalud()) {
                    pet.curar();
                } else {
                    System.out.println("Su mascota ya está sana");
                }
                break;
            case 0:
                System.out.println(" > PARTIDA FINALIZADA < ");
                break;
            default:
                System.out.println("opción no disponible");
                break;

        }

    }
    public void menuCargarPartida() {
        System.out.println(" >> PETVILLE: MENÚ CARGAR PARTIDA << ");
        System.out.println("\nAsi que quieres continuar una partida, ¡MUY BIEN!");
        do {
            opcion = 0;
            System.out.println("Partidas disponibles: \n");
            int i = 1;
            for (Mascota m : Main.mascotasDisponibles) {
                if (m == null) {
                    System.out.println("\t" + i++ + ") Crear partida nueva");
                } else {
                    System.out.println("\t" + i++ + ") " + m.getNombre() + ", " + m.getEdad() + " Dias");

                }
            }
            System.out.println("\t0) Volver atrás");
            System.out.println("\nSeleccione la partida que quiera cargar: ");
            leerPosicion();
            clear();
            if (posicion != 0) {

                if (Main.mascotasDisponibles[posicion - 1] == null) {
                    System.out.println("El espacio elegido no tiene una mascota creada, si acepta se creará una nueva mascota, \n¿Desea continuar?\n\n\t1) Continuar \n\t2) Volver atrás");
                    do {
                        leerOpcion();
                        if(opcion != 1 && opcion != 2){
                            System.out.println("Opcion no valida, por favor introduzca un valor entre (1-2): ");
                        }
                    }while (opcion != 1 && opcion != 2);
                    clear();
                    if(opcion == 1){
                        crearMascota();
                    }
                }
            } else {
                System.out.println("Volviendo al menú Principal");
            }

        } while (opcion == 2);

    }

    public static void clear() {
        for (int i = 0; i < 50; i++)
            System.out.println();
    }

}