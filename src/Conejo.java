
import java.util.Random;

public class Conejo extends Mascota {
    public static Random rdm = new Random();

    public Conejo() {
    }

    public Conejo(String nombre) {
        super(nombre);
    }

    public Conejo(String nombre, int edad, boolean salud, boolean vida, boolean curado, boolean dormido, int alimentacion, int higiene, int animo) {
        super(nombre, edad, salud, vida, curado, dormido, alimentacion, higiene, animo);
    }

    @Override
    public void alimentar() {

        int suerte = rdm.nextInt(0, 2);
        if (isSalud() || (!isSalud() && suerte == 1)) {

            setAlimentacion(getAlimentacion() + 15);
            setHigiene(getHigiene() - 5);
        } else {
            System.out.println(getNombre() + " no quiere comer");
            System.out.println(" (\\(\\\n" +
                    " \t\t\t( “-.-)\n" +
                    "  \t /   \\ ");
        }
    }

    @Override
    public void limpiar() {

        int suerte = rdm.nextInt(0, 2);
        if (isSalud() || (!isSalud() && suerte == 1)) {

            setAlimentacion(getAlimentacion() - 5);
            setHigiene(getHigiene() + 15);
        } else {
            System.out.println(getNombre() + " no quiere bañarse");
            System.out.println(" /)/)\n" +
                    " \t\t\t(-.-“ )\n" +
                    "  \t  /   \\ \t");
        }

    }

    @Override
    public void jugar() {

        int suerte = rdm.nextInt(0, 2);
        if (isSalud() || (!isSalud() && suerte == 1)) {

            setAlimentacion(getAlimentacion() - 5);
            setHigiene(getHigiene() - 5);
            setAnimo(getAnimo() + 15);
        } else {
            System.out.println(getNombre() + " no quiere jugar");
            System.out.println("(\\(\\\n" +
                    " \t\t\t( “-.-)\n" +
                    "  \t /   \\ \t");
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
                System.out.println(" (\\(\\\n" +
                        " ( x.x) \n" +
                        " o_(\")(\")\n");
            } else {
                int mediaStats = (getAlimentacion() + getAnimo() + getHigiene()) / 3;
                if (mediaStats >= 80) {
                    System.out.println("  (\\_/)\n" +
                            " ( ^.^ )\n" +
                            "  /   \\ \n");
                } else if (mediaStats >= 60) {
                    System.out.println("  (\\_/)  \n" +
                            " ( o.o )\n" +
                            "  /   \\ \n");
                } else {
                    System.out.println("  (\\_/)\n" +
                            " ( >.< )\n" +
                            "  /   \\");
                }
            }

        } else {
            System.out.println(" (\\_/) zZzZzZ\n" +
                    " ( -.-)\n" +
                    " o(\")(\")\n");

        }
    }
}
