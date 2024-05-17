package Mascotas;
import java.util.Random;
import Utils.*;
public class Gato extends Mascota {
    public static Random rdm = new Random();

    public Gato() {
    }

    public Gato(String nombre) {
        super(nombre);
    }

    @Override
    public void alimentar() {

        int suerte = rdm.nextInt(0, 3);
        if ((isSalud() || (!isSalud() && suerte == 1)) && getAlimentacion() < 100) {

            setAlimentacion(getAlimentacion() + 10);
            setAnimo(getAnimo() + 5);
            Menu.clear();
            System.out.println("\t" + ColorText.bold + ColorText.bGreen + ColorText.black + " " + getNombre()
                    + " ha comido " + ColorText.cleanse);
            aumentarContadorAlimentar();
        } else {
            Menu.clear();
            System.out.println("\t" + ColorText.bold + ColorText.bRed + ColorText.black + " " + getNombre()
                    + " no quiere comer " + ColorText.cleanse);
            System.out.println("\n\t\t  /\\/\\\n" +
                    "\t\t (“-.-)\n" +
                    "\t\t /   \\  ");
        }

    }

    @Override
    public void limpiar() {

        int suerte = rdm.nextInt(0, 3);
        if ((isSalud() || (!isSalud() && suerte == 1)) && getHigiene() < 100) {

            setAlimentacion(getAlimentacion() - 5);
            setHigiene(getHigiene() + 10);
            setAnimo(getAnimo() - 10);
            Menu.clear();
            System.out.println("\t" + ColorText.bold + ColorText.bGreen + ColorText.black + " " + getNombre()
                    + " se ha bañado " + ColorText.cleanse);
            aumentarContadorLimpiar();
        } else {
            Menu.clear();
            System.out.println("\t" + ColorText.bold + ColorText.bRed + ColorText.black + " " + getNombre()
                    + " no quiere bañarse " + ColorText.cleanse);
            System.out.println("\n\t\t  /\\/\\\n" +
                    "\t\t (-.-“)\n" +
                    "\t\t  /   \\ ");
        }

    }

    @Override
    public void jugar() {

        int suerte = rdm.nextInt(0, 3);
        if ((isSalud() || (!isSalud() && suerte == 1)) && getAnimo() < 100) {

            setAlimentacion(getAlimentacion() - 5);
            setHigiene(getHigiene() - 5);
            setAnimo(getAnimo() + 10);
            Menu.clear();
            System.out.println("\t" + ColorText.bold + ColorText.bGreen + ColorText.black + " " + getNombre()
                    + " ha jugado " + ColorText.cleanse);
            aumentarContadorJugar();
        } else {
            Menu.clear();
            System.out.println("\t" + ColorText.bold + ColorText.bRed + ColorText.black + " " + getNombre()
                    + " no quiere jugar " + ColorText.cleanse);
            System.out.println("\n\t\t  /\\/\\\n" +
                    "\t\t (“-.-)\n" +
                    "\t\t /   \\ \n");
        }

    }

    @Override
    public void salud() {
        int suerte = rdm.nextInt(0, 8);
        if (isSalud() && suerte == 0) {
            setSalud(false);
        }

    }

    @Override
    public void imprimirModelo() {
        if (!isDormido()) {
            if (!isSalud()) {
                System.out.println("\t\t  /\\/\\\n" +
                        "\t\t ( x.x) \n" +
                        "\t\t (_(\")(\")\n");
            } else {

                if (getAlimentacion() > 80 && getAnimo() > 80 && getHigiene() > 80) {
                    System.out.println("\t\t  /\\_/\\\n" +
                            "\t\t ( ^.^ )\n" +
                            "\t\t  /   \\ \n");
                } else if (getAlimentacion() > 45 && getAnimo() > 45 && getHigiene() > 45) {
                    System.out.println("\t\t  /\\_/\\  \n" +
                            "\t\t ( o.o )\n" +
                            "\t\t  /   \\ \n");
                } else {
                    System.out.println("\t\t  /\\_/\\\n" +
                            "\t\t ( >.< )\n" +
                            "\t\t  /   \\ \n");
                }
            }

        } else {
            System.out.println("\t\t  /\\/\\ zZzZzZ\n" +
                    "\t\t ( -.-)\n" +
                    "\t\t (_(\")(\")");

        }
    }

    @Override
    public String tipoMascota() {
        return "Gato";
    }
}
