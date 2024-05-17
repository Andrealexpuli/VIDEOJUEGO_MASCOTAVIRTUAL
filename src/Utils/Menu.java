package Utils;
import Mascotas.*;
import java.util.InputMismatchException;
import java.util.Scanner;
import App.*;
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
            System.out.println("\t██    " + ColorText.blue + "███    ███ ███████ ███    ██ ██    ██" + ColorText.cleanse
                    + "    ██ \n" +
                    "\t ██   " + ColorText.blue + "████  ████ ██      ████   ██ ██    ██" + ColorText.cleanse
                    + "   ██  \n" +
                    "\t  ██  " + ColorText.blue + "██ ████ ██ █████   ██ ██  ██ ██    ██" + ColorText.cleanse
                    + "  ██   \n" +
                    "\t ██   " + ColorText.blue + "██  ██  ██ ██      ██  ██ ██ ██    ██" + ColorText.cleanse
                    + "   ██  \n" +
                    "\t██    " + ColorText.blue + "██      ██ ███████ ██   ████  ██████" + ColorText.cleanse
                    + "     ██ ");
            System.out.println("\n\tBienvenid@ al menú de inicio." +
                    "\n\tA continuación le mostramos las opciones disponibles: ");
            System.out.println(ColorText.bold + "\n\t\t1) Partida nueva " +
                    "\n\t\t2) Cargar partida " +
                    "\n\t\t3) Estadísticas " +
                    "\n\t\t0) " + ColorText.blue + "Salir" + ColorText.cleanse);
            do {
                leerOpcion();
                if (opcion > 0 && opcion < 3) {
                    clear();
                }
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
                        Main.imprimirFicheroEstadisticas();
                        break;
                    case 0:
                        System.out.println("\t" + ColorText.bold + ColorText.bBlue + ColorText.black
                                + " ¿Seguro que quiere salir? " + ColorText.cleanse + "\n\t" +
                                "(Si esta seguro escriba: SI)");
                        salir = sc.nextLine();

                        break;
                    default:
                        System.out.println("\t" + ColorText.bold + ColorText.bBlue + ColorText.black
                                + " Opcion no disponible " + ColorText.cleanse);
                        break;
                }
            } while (opcion < 0 || opcion > 3);
        } while (opcion != 0);
        return salir;
    }

    public void menuCrearMascota() {
        System.out.println("\t██    " + ColorText.blue + "███    ██ ██    ██ ███████ ██    ██  █████"
                + ColorText.cleanse + "     ██ \n" +
                "\t ██   " + ColorText.blue + "████   ██ ██    ██ ██      ██    ██ ██   ██" + ColorText.cleanse
                + "   ██  \n" +
                "\t  ██  " + ColorText.blue + "██ ██  ██ ██    ██ █████   ██    ██ ███████" + ColorText.cleanse
                + "  ██   \n" +
                "\t ██   " + ColorText.blue + "██  ██ ██ ██    ██ ██       ██  ██  ██   ██" + ColorText.cleanse
                + "   ██  \n" +
                "\t██    " + ColorText.blue + "██   ████  ██████  ███████   ████   ██   ██" + ColorText.cleanse
                + "    ██");
        System.out.println("\n\tAsi que quieres comenzar una nueva partida, ¡MUY BIEN!");
        do {
            opcion = 0;
            System.out.println("\tEspacios de guardado disponibles: \n");
            int i = 1;
            for (Mascota m : Main.mascotasDisponibles) {
                if (m == null) {
                    System.out.println("\t\t" + ColorText.bold + i++ + ") " + ColorText.green + "espacio disponible"
                            + ColorText.cleanse);
                } else {
                    System.out.println("\t\t" + ColorText.bold + i++ + ") " + m.tipoMascota() + ", " + m.getNombre()
                            + ", " + m.getEdad() + " Dias" + ColorText.cleanse);

                }
            }
            System.out.println("\t\t" + ColorText.bold + "0) " + ColorText.blue + "Volver atrás" + ColorText.cleanse);
            System.out.println("\n\tSeleccione el espacio que desee para guardar su nueva mascota: ");
            leerPosicion();
            clear();
            if (posicion != 0) {
                if (Main.mascotasDisponibles[posicion - 1] != null) {
                    System.out.println("\t" + ColorText.bold + ColorText.bRed + ColorText.black
                            + " El espacio elegido ya tiene una mascota creada, si acepta se eliminará permanentemente la mascota "
                            + ColorText.cleanse +
                            "\n\n\t¿Desea sobrescribir la mascota? " +
                            "\n\n\t\t" + ColorText.bold + "1) " + ColorText.red + "Sobrescribir mascota "
                            + ColorText.cleanse +
                            "\n\t\t" + ColorText.bold + "2) " + ColorText.blue + "Volver atrás" + ColorText.cleanse);
                    do {
                        leerOpcion();
                        if (opcion != 1 && opcion != 2) {
                            System.out.println("\t" + ColorText.bold + ColorText.bRed + ColorText.black
                                    + " Opcion no valida, por favor introduzca un valor entre (1-2): "
                                    + ColorText.cleanse);
                        }
                    } while (opcion != 1 && opcion != 2);
                    clear();
                }
            } else {
                System.out.println("\tVolviendo al menú Principal");
            }

        } while (opcion == 2);

    }

    public void crearMascota() {

        System.out.println("\t" + ColorText.bold + ColorText.bGrey + ColorText.black
                + " ¿Qué tipo de mascota quiere crear? " + ColorText.cleanse);
        System.out.println("\n\t\t" + ColorText.bold + "1) Conejo \n\t\t2) Gato \n\t\t3) Pájaro" + ColorText.cleanse);
        leerOpcion();
        clear();
        switch (opcion) {
            case 1:
                System.out.println("\tEn breves tendremos a su Conejo listo, pero primero... " +
                        "\n\t" + ColorText.bold + ColorText.bGrey + ColorText.black + " ¿Qué nombre quieres ponerle?: "
                        + ColorText.cleanse);
                String nombreConejo = leerNombre();
                Conejo pet = new Conejo(nombreConejo);
                Main.mascotasDisponibles[posicion - 1] = pet;
                break;
            case 2:
                System.out.println("\tEn breves tendremos a su Gato listo, pero primero... " +
                        "\n\t" + ColorText.bold + ColorText.bGrey + ColorText.black + " ¿Qué nombre quieres ponerle?: "
                        + ColorText.cleanse);
                String nombreGato = leerNombre();
                Gato pet2 = new Gato(nombreGato);
                Main.mascotasDisponibles[posicion - 1] = pet2;
                break;
            case 3:
                System.out.println("\tEn breves tendremos a su Pajaro listo, pero primero... " +
                        "\n\t" + ColorText.bold + ColorText.bGrey + ColorText.black + " ¿Qué nombre quieres ponerle?: "
                        + ColorText.cleanse);
                String nombrePajaro = leerNombre();
                Pajaro pet3 = new Pajaro(nombrePajaro);
                Main.mascotasDisponibles[posicion - 1] = pet3;
                break;

            default:
                System.out.println(ColorText.bold + ColorText.bRed + ColorText.black + "\t Opción no valida ");
                break;
        }
    }

    public void menuEleccionJugar() {
        Mascota pet = Main.mascotasDisponibles[posicion - 1];
        clear();
        System.out.println("\t" + ColorText.bold + ColorText.bGreen + ColorText.black + " Su mascota " + pet.getNombre()
                + " ha sido creada correctamente " + ColorText.cleanse +
                "\n\t¿Desea comenzar la partida?" + ColorText.bold +
                "\n\n\t\t1) Comenzar partida " +
                "\n\t\t2) " + ColorText.blue + "Volver al menú principal" + ColorText.cleanse);
        do {
            leerOpcion();
            if (opcion != 1 && opcion != 2) {
                System.out.println("\t" + ColorText.bold + ColorText.bRed + ColorText.black
                        + " Opcion no valida, por favor introduzca un valor entre (1-2): " + ColorText.cleanse);
            }
        } while (opcion != 1 && opcion != 2);
        clear();
        if (opcion == 1) {
            Main.partida();
        }
    }

    public void leerOpcion() {
        opcion = -1;
        do {
            try {
                opcion = sc.nextInt();
            } catch (InputMismatchException ime) {
                System.out.println("\t" + ColorText.bold + ColorText.bRed + ColorText.black
                        + " Solo se admiten valores enteros, por favor introduzca un valor correcto: "
                        + ColorText.cleanse);
            }
            sc.nextLine();

        } while (opcion == -1);
    }

    public void leerPosicion() {

        do {
            try {
                posicion = sc.nextInt();
                if (posicion > Main.mascotasDisponibles.length || posicion < 0) {
                    System.out.println("\t" + ColorText.bold + ColorText.bRed + ColorText.black
                            + " Espacio no existente. Seleccione un espacio entre (1 - 3): " + ColorText.cleanse);
                }

            } catch (InputMismatchException ime) {
                System.out.println("\t" + ColorText.bold + ColorText.bRed + ColorText.black
                        + " Solo se admiten valores enteros, por favor introduzca un valor correcto: "
                        + ColorText.cleanse);
            }
            sc.nextLine();

        } while (posicion > Main.mascotasDisponibles.length || posicion < 0);
    }

    public String leerNombre() {
        String nombre = sc.nextLine();
        return nombre.substring(0, 1).toUpperCase() + nombre.substring(1).toLowerCase();
    }

    public void menuPartida() {
        Mascota pet = Main.mascotasDisponibles[posicion - 1];
        if (pet.isSalud()) {
            System.out.println("\n\t" + ColorText.bold + ColorText.bBlue + ColorText.black
                    + " (1) Alimentar  (2) Bañar  (3) Jugar " + ColorText.cleanse + ColorText.bold + ColorText.bBlue
                    + " (0) Salir " + ColorText.cleanse);
        } else {
            System.out.println("\n\t" + ColorText.bold + ColorText.bBlue + ColorText.black
                    + " (1) Alimentar  (2) Bañar  (3) Jugar " + ColorText.bold + ColorText.bGreen + ColorText.black
                    + " (4) Curar " + ColorText.cleanse + ColorText.bold + ColorText.bBlue + " (0) Salir "
                    + ColorText.cleanse);
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
                    System.out.println("\t" + ColorText.bold + ColorText.bGreen + ColorText.black
                            + " Su mascota ya está sana " + ColorText.cleanse);
                }
                break;
            case 0:
                System.out.println("\t" + ColorText.bold + ColorText.bBlue + ColorText.black
                        + " > PARTIDA FINALIZADA < " + ColorText.cleanse);
                break;
            default:
                System.out.println("\t" + ColorText.bold + ColorText.bRed + ColorText.black + " Opción no disponible "
                        + ColorText.cleanse);
                break;

        }

    }

    public void menuCargarPartida() {
        System.out.println("\t██    " + ColorText.blue + "██       ██████   █████  ██████" + ColorText.cleanse
                + "     ██ \n" +
                "\t ██   " + ColorText.blue + "██      ██    ██ ██   ██ ██   ██" + ColorText.cleanse + "   ██  \n" +
                "\t  ██  " + ColorText.blue + "██      ██    ██ ███████ ██   ██" + ColorText.cleanse + "  ██   \n" +
                "\t ██   " + ColorText.blue + "██      ██    ██ ██   ██ ██   ██" + ColorText.cleanse + "   ██  \n" +
                "\t██    " + ColorText.blue + "███████  ██████  ██   ██ ██████ " + ColorText.cleanse + "    ██ ");
        System.out.println("\n\tAsi que quieres continuar una partida, ¡MUY BIEN!");
        do {
            opcion = 0;
            System.out.println("\tPartidas disponibles: \n");
            int i = 1;
            for (Mascota m : Main.mascotasDisponibles) {
                if (m == null) {
                    System.out.println("\t\t" + ColorText.bold + i++ + ") " + ColorText.green + "Crear partida nueva"
                            + ColorText.cleanse);
                } else {
                    System.out.println("\t\t" + ColorText.bold + i++ + ") " + m.tipoMascota() + ", " + m.getNombre()
                            + ", " + m.getEdad() + " Dias" + ColorText.cleanse);

                }
            }
            System.out.println("\t\t" + ColorText.bold + "0) " + ColorText.blue + "Volver atrás" + ColorText.cleanse);
            System.out.println("\n\tSeleccione la partida que quiera cargar: ");
            leerPosicion();
            clear();
            if (posicion != 0) {

                if (Main.mascotasDisponibles[posicion - 1] == null) {

                    System.out.println("\t" + ColorText.bold + ColorText.bRed + ColorText.black
                            + " El espacio elegido no tiene una mascota creada, si acepta se creará una nueva mascota "
                            + ColorText.cleanse +
                            "\n\n\t¿Desea crear la mascota? " +
                            "\n\n\t\t" + ColorText.bold + "1) " + ColorText.red + "Crear mascota " + ColorText.cleanse +
                            "\n\t\t" + ColorText.bold + "2) " + ColorText.blue + "Volver atrás" + ColorText.cleanse);

                    do {
                        leerOpcion();
                        if (opcion != 1 && opcion != 2) {
                            System.out.println("\t" + ColorText.bold + ColorText.bRed + ColorText.black
                                    + " Opcion no valida, por favor introduzca un valor entre (1-2): "
                                    + ColorText.cleanse);
                        }
                    } while (opcion != 1 && opcion != 2);
                    clear();
                    if (opcion == 1) {
                        crearMascota();
                    }
                }
            } else {
                System.out.println("\tVolviendo al menú Principal");
            }

        } while (opcion == 2);

    }

    public static void clear() {
        for (int i = 0; i < 50; i++)
            System.out.println();
    }

}
