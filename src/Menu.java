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
            System.out.println("\t██    "+ColorText.blue+"███    ███ ███████ ███    ██ ██    ██"+ColorText.cleanse+"    ██ \n" +
                    "\t ██   "+ColorText.blue+"████  ████ ██      ████   ██ ██    ██"+ColorText.cleanse+"   ██  \n" +
                    "\t  ██  "+ColorText.blue+"██ ████ ██ █████   ██ ██  ██ ██    ██"+ColorText.cleanse+"  ██   \n" +
                    "\t ██   "+ColorText.blue+"██  ██  ██ ██      ██  ██ ██ ██    ██"+ColorText.cleanse+"   ██  \n" +
                    "\t██    "+ColorText.blue+"██      ██ ███████ ██   ████  ██████"+ColorText.cleanse+"     ██ ");
            System.out.println("\n\tBienvenid@ al menú de inicio." +
                    "\n\tA continuación le mostramos las opciones disponibles: ");
            System.out.println(ColorText.bold+"\n\t\t1) Partida nueva " +
                    "\n\t\t2) Cargar partida " +
                    "\n\t\t3) Estadísticas " +
                    "\n\t\t0) "+ColorText.blue+"Salir"+ColorText.cleanse);
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
                        Main.imprimirFicheroEstadisticas();
                        break;
                    case 0:
                        System.out.println("¿Seguro que quiere salir? \n(Si esta seguro escriba: SI)");
                        salir = sc.nextLine();

                        break;
                    default:
                        System.out.println(ColorText.red+"\topcion no disponible"+ColorText.cleanse);
                        break;
                }
            }while (opcion < 0 || opcion > 3);
        } while (opcion != 0);
        return salir;
    }

    public void menuCrearMascota() {
        System.out.println("\t██    "+ColorText.blue+"███    ██ ██    ██ ███████ ██    ██  █████"+ColorText.cleanse+"     ██ \n" +
                "\t ██   "+ColorText.blue+"████   ██ ██    ██ ██      ██    ██ ██   ██"+ColorText.cleanse+"   ██  \n" +
                "\t  ██  "+ColorText.blue+"██ ██  ██ ██    ██ █████   ██    ██ ███████"+ColorText.cleanse+"  ██   \n" +
                "\t ██   "+ColorText.blue+"██  ██ ██ ██    ██ ██       ██  ██  ██   ██"+ColorText.cleanse+"   ██  \n" +
                "\t██    "+ColorText.blue+"██   ████  ██████  ███████   ████   ██   ██"+ColorText.cleanse+"    ██");
        System.out.println("\n\tAsi que quieres comenzar una nueva partida, ¡MUY BIEN!");
        do {
            opcion = 0;
            System.out.println("\tEspacios de guardado disponibles: \n");
            int i = 1;
            for (Mascota m : Main.mascotasDisponibles) {
                if (m == null) {
                    System.out.println("\t\t"+ColorText.bold+ i++ + ") "+ColorText.green+"espacio disponible"+ColorText.cleanse);
                } else {
                    System.out.println("\t\t"+ColorText.bold+ i++ + ") "+ m.tipoMascota() +", "+ m.getNombre() + ", " + m.getEdad() + " Dias"+ColorText.cleanse);

                }
            }
            System.out.println("\t\t"+ColorText.bold+"0) "+ColorText.blue+"Volver atrás"+ColorText.cleanse);
            System.out.println("\n\tSeleccione el espacio que desee para guardar su nueva mascota: ");
            leerPosicion();
            clear();
            if (posicion != 0) {
                if (Main.mascotasDisponibles[posicion - 1] != null) {
                    System.out.println("\t"+ColorText.bold+ColorText.bRed+ColorText.black+" El espacio elegido ya tiene una mascota creada, si acepta se eliminará permanentemente la mascota " +ColorText.cleanse+
                            "\n\n\t¿Desea sobrescribir la mascota? " +
                            "\n\n\t\t"+ColorText.bold+"1) "+ColorText.red+"Sobrescribir mascota " +ColorText.cleanse+
                            "\n\t\t"+ColorText.bold+"2) "+ColorText.blue+"Volver atrás"+ColorText.cleanse);
                    do {
                        leerOpcion();
                        if(opcion != 1 && opcion != 2){
                            System.out.println("\t"+ColorText.bold+ColorText.bRed+ColorText.black+" Opcion no valida, por favor introduzca un valor entre (1-2): "+ColorText.cleanse);
                        }
                    }while (opcion != 1 && opcion != 2);
                    clear();
                }
            } else {
                System.out.println("\t Volviendo al menú Principal");
            }


        } while (opcion == 2);

    }

    public void crearMascota() {

        System.out.println("\t"+ColorText.bold+ColorText.bGrey+ColorText.black+" ¿Qué tipo de mascota quiere crear? "+ColorText.cleanse);
        System.out.println("\n\t\t"+ColorText.bold+"1) Conejo \n\t\t2) Gato \n\t\t3) Pájaro"+ColorText.cleanse);
        leerOpcion();
        clear();
        switch (opcion) {
            case 1:
                System.out.println("\tEn breves tendremos a su Conejo listo, pero primero... " +
                        "\n\t"+ColorText.bold+ColorText.bGrey+ColorText.black+" ¿Qué nombre quieres ponerle?: "+ColorText.cleanse);
                String nombreConejo = leerNombre();
                Conejo pet = new Conejo(nombreConejo);
                Main.mascotasDisponibles[posicion - 1] = pet;
                break;
            case 2:
                System.out.println("\tEn breves tendremos a su Gato listo, pero primero... " +
                        "\n\t"+ColorText.bold+ColorText.bGrey+ColorText.black+" ¿Qué nombre quieres ponerle?: "+ColorText.cleanse);
                String nombreGato = leerNombre();
                Gato pet2 = new Gato(nombreGato);
                Main.mascotasDisponibles[posicion - 1] = pet2;
                break;
            case 3:
                System.out.println("\tEn breves tendremos a su Pajaro listo, pero primero... " +
                        "\n\t"+ColorText.bold+ColorText.bGrey+ColorText.black+" ¿Qué nombre quieres ponerle?: "+ColorText.cleanse);
                String nombrePajaro = leerNombre();
                Pajaro pet3 = new Pajaro(nombrePajaro);
                Main.mascotasDisponibles[posicion - 1] = pet3;
                break;

            default:
                System.out.println(ColorText.bold+ColorText.bRed+ColorText.black+"\t Opción no valida ");
                break;
        }
    }
    public void menuEleccionJugar(){
        Mascota pet = Main.mascotasDisponibles[posicion - 1];
        clear();
        System.out.println(ColorText.bold+ColorText.bGreen+ColorText.black+"\tSu mascota " + pet.getNombre()+ " ha sido creada correctamente " +ColorText.cleanse+
                "\n¿Desea comenzar la partida?" +ColorText.bold+
                "\n\n\t1) Continuar " +
                "\n\t2) "+ColorText.blue+"Volver al menú principal"+ColorText.cleanse);
        do {
            leerOpcion();
            if(opcion != 1 && opcion != 2){
                System.out.println("\t"+ColorText.bold+ColorText.bRed+ColorText.black+" Opcion no valida, por favor introduzca un valor entre (1-2): "+ColorText.cleanse);
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
                System.out.println("\t"+ColorText.bold+ColorText.bRed+ColorText.black+" Solo se admiten valores enteros, por favor introduzca un valor correcto: "+ColorText.cleanse);
            }
            sc.nextLine();

        } while (opcion == -1);
    }

    public void leerPosicion() {

        do {
                try {
                    posicion = sc.nextInt();
                    if (posicion > Main.mascotasDisponibles.length || posicion < 0) {
                        System.out.println("\t"+ColorText.bold+ColorText.bRed+ColorText.black+" Espacio no existente. Seleccione un espacio entre (1 - 3): "+ColorText.cleanse);
                    }

                } catch (InputMismatchException ime) {
                    System.out.println("\t"+ColorText.bold+ColorText.bRed+ColorText.black+" Solo se admiten valores enteros, por favor introduzca un valor correcto: "+ColorText.cleanse);
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
