
import java.util.Random;

public class Conejo extends Mascota {
    public static Random rdm = new Random();

    public Conejo() {
    }

    public Conejo(String nombre) {
        super(nombre);
    }


    @Override
    public void alimentar() {

        int suerte = rdm.nextInt(0, 2);
        if ((isSalud() || (!isSalud() && suerte == 1)) && getAlimentacion() < 100) {

            setAlimentacion(getAlimentacion() + 15);
            setHigiene(getHigiene() - 5);
            Menu.clear();
            System.out.println("\t"+ColorText.bold+ColorText.bGreen+ColorText.black+" "+getNombre() + " ha comido "+ColorText.cleanse);
            aumentarContadorAlimentar();
        } else {
            Menu.clear();
            System.out.println("\t"+ColorText.bold+ColorText.bRed+ColorText.black+" "+getNombre() + " no quiere comer "+ColorText.cleanse);
            System.out.println("\n\t\t (\\(\\\n" +
                    "\t\t (“-.-)\n" +
                    "\t\t /   \\  ");
        }

    }

    @Override
    public void limpiar() {

        int suerte = rdm.nextInt(0, 2);
        if ((isSalud() || (!isSalud() && suerte == 1)) && getHigiene() < 100) {

            setAlimentacion(getAlimentacion() - 5);
            setHigiene(getHigiene() + 15);
            Menu.clear();
            System.out.println("\t"+ColorText.bold+ColorText.bGreen+ColorText.black+" "+getNombre() + " se ha bañado "+ColorText.cleanse);
            aumentarContadorLimpiar();
        } else {
            Menu.clear();
            System.out.println("\t"+ColorText.bold+ColorText.bRed+ColorText.black+" "+getNombre() + " no quiere bañarse "+ColorText.cleanse);
            System.out.println("\n\t\t  /)/)\n" +
                    "\t\t (-.-“)\n" +
                    "\t\t  /   \\ ");
        }

    }

    @Override
    public void jugar() {

        int suerte = rdm.nextInt(0, 2);
        if ((isSalud() || (!isSalud() && suerte == 1)) && getAnimo() < 100) {

            setAlimentacion(getAlimentacion() - 5);
            setHigiene(getHigiene() - 5);
            setAnimo(getAnimo() + 15);
            Menu.clear();
            System.out.println("\t"+ColorText.bold+ColorText.bGreen+ColorText.black+" "+getNombre() + " ha jugado "+ColorText.cleanse);
            aumentarContadorJugar();
        } else {
            Menu.clear();
            System.out.println("\t"+ColorText.bold+ColorText.bRed+ColorText.black+" "+getNombre() + " no quiere jugar "+ColorText.cleanse);
            System.out.println("\n\t\t (\\(\\\n" +
                    "\t\t (“-.-)\n" +
                    "\t\t /   \\ ");
        }

    }

    @Override
    public void salud() {
        int suerte = rdm.nextInt(0, 11);
        if (isSalud() && suerte == 0) {
            setSalud(false);
        }

    }

    @Override
    public void imprimirModelo() {
        if (!isDormido()) {
            if (!isSalud()) {
                System.out.println("\t\t (\\(\\\n" +
                        "\t\t ( x.x) \n" +
                        "\t\t o_(\")(\")\n");
            } else {

                if (getAlimentacion() > 80 && getAnimo() > 80 && getHigiene() > 80) {
                    System.out.println("\t\t  (\\_/)\n" +
                            "\t\t ( ^.^ )\n" +
                            "\t\t  /   \\ \n");
                } else if (getAlimentacion() > 45 && getAnimo() > 45 && getHigiene() > 45) {
                    System.out.println("\t\t  (\\_/)  \n" +
                            "\t\t ( o.o )\n" +
                            "\t\t  /   \\ \n");
                } else {
                    System.out.println("\t\t  (\\_/)\n" +
                            "\t\t ( >.< )\n" +
                            "\t\t  /   \\ \n");
                }
            }

        } else {
            System.out.println("\t\t (\\_/) zZzZzZ\n" +
                    "\t\t ( -.-)\n" +
                    "\t\t o_(\")(\")");


        }
    }

    @Override
    public String tipoMascota() {
        return "Conejo";
    }
}
