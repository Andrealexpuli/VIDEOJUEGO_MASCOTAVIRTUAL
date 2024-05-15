
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
            System.out.println(getNombre() + " ha comido");
            aumentarContadorAlimentar();
        } else {
            Menu.clear();
            System.out.println(getNombre() + " no quiere comer");
            System.out.println(" (\\(\\\n" +
                    " (“-.-)\n" +
                    " /   \\ \n ");
        }

    }

    @Override
    public void limpiar() {

        int suerte = rdm.nextInt(0, 2);
        if ((isSalud() || (!isSalud() && suerte == 1) && getHigiene() < 100)) {

            setAlimentacion(getAlimentacion() - 5);
            setHigiene(getHigiene() + 15);
            Menu.clear();
            System.out.println(getNombre() + " se ha bañado");
            aumentarContadorLimpiar();
        } else {
            Menu.clear();
            System.out.println(getNombre() + " no quiere bañarse");
            System.out.println("  /)/)\n" +
                    " (-.-“)\n" +
                    "  /   \\ \n");
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
            System.out.println(getNombre() + " ha jugado");
            aumentarContadorJugar();
        } else {
            Menu.clear();
            System.out.println(getNombre() + " no quiere jugar");
            System.out.println(" (\\(\\\n" +
                    " (“-.-)\n" +
                    " /   \\ \n");
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
                            "  /   \\ \n");
                }
            }

        } else {
            System.out.println(" (\\_/) zZzZzZ\n" +
                    " ( -.-)\n" +
                    " o_(\")(\")\n");


        }
    }

    @Override
    public String tipoMascota() {
        return "Conejo";
    }
}
