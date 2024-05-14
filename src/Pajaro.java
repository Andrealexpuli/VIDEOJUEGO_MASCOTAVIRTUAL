import java.util.Random;

public class Pajaro extends Mascota {
    public static Random rdm = new Random();

    public Pajaro() {
    }

    public Pajaro(String nombre) {
        super(nombre);
    }

    public Pajaro(String nombre, int edad, boolean salud, boolean vida, boolean curado, boolean dormido, int alimentacion, int higiene, int animo) {
        super(nombre, edad, salud, vida, curado, dormido, alimentacion, higiene, animo);
    }

    @Override
    public void alimentar() {

        int suerte = rdm.nextInt(0, 4);
        if ((isSalud() || (!isSalud() && suerte == 1)) && getAlimentacion() < 100) {

            setAlimentacion(getAlimentacion() + 10);
            setHigiene(getHigiene() - 5);
            Menu.clear();
            System.out.println(getNombre() + " ha comido");
            aumentarContadorAlimentar();
        } else {
            Menu.clear();
            System.out.println(getNombre() + " no quiere comer");
            System.out.println("  __\n" +
                    " (-,-)\n" +
                    " /)__)\n" +
                    " -\\\"-\\\"-\n");
        }

    }

    @Override
    public void limpiar() {

        int suerte = rdm.nextInt(0, 4);
        if ((isSalud() || (!isSalud() && suerte == 1) && getHigiene() < 100)) {

            setAlimentacion(getAlimentacion() - 5);
            setHigiene(getHigiene() + 10);
            setAnimo(getAnimo() - 5);
            Menu.clear();
            System.out.println(getNombre() + " se ha bañado");
            aumentarContadorLimpiar();
        } else {
            Menu.clear();
            System.out.println(getNombre() + " no quiere bañarse");
            System.out.println("  __\n" +
                    " (-,-)\n" +
                    " /)__)\n" +
                    " -\\\"-\\\"-\n");
        }

    }

    @Override
    public void jugar() {

        int suerte = rdm.nextInt(0, 4);
        if ((isSalud() || (!isSalud() && suerte == 1)) && getAnimo() < 100) {

            setAlimentacion(getAlimentacion() - 5);
            setAnimo(getAnimo() + 10);
            Menu.clear();
            System.out.println(getNombre() + " ha jugado");
            aumentarContadorJugar();
        } else {
            Menu.clear();
            System.out.println(getNombre() + " no quiere jugar");
            System.out.println("  __\n" +
                    " (-,-)\n" +
                    " /)__)\n" +
                    " -\\\"-\\\"-\n");
        }

    }

    @Override
    public void salud() {
        int suerte = rdm.nextInt(0, 7);
        if (isSalud() && suerte == 0) {
            setSalud(false);
        }

    }

    @Override
    public void imprimirModelo() {
        if (!isDormido()) {
            if (!isSalud()) {
                System.out.println("  __\n" +
                        " (x,x)\n" +
                        " /)__)\n" +
                        " -\\\"-\\\"-\n");
            } else {
                int mediaStats = (getAlimentacion() + getAnimo() + getHigiene()) / 3;
                if (mediaStats >= 80) {
                    System.out.println("  __\n" +
                            " (^,^)\n" +
                            " /)__)\n" +
                            " -\\\"-\\\"-\n");
                } else if (mediaStats >= 60) {
                    System.out.println("  __\n" +
                            " (o,o)\n" +
                            " /)__)\n" +
                            " -\\\"-\\\"-\n");
                } else {
                    System.out.println("  __\n" +
                            " (>,<)\n" +
                            " /)__)\n" +
                            " -\\\"-\\\"-\n");
                }
            }

        } else {
            System.out.println("   _\n" +
                    "  ( -,-) zzz\n" +
                    "  / )  )\n" +
                    " /-\"\"-\\\n");


        }
    }
}
