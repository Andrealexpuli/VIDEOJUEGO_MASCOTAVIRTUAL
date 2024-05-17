package Mascotas;

import java.util.Random;

import Utils.*;

/**
 * @author Andrea Alexandra Pulido de la Serna
 * Clase Conejo hereda de Mascota
 * perteneciente al paquete Mascotas.
 */
public class Conejo extends Mascota {
    public static Random rdm = new Random();

    /**
     * Constructor vacio
     */
    public Conejo() {
    }

    /**
     * Constructor de Conejo
     *
     * @param nombre el nombre que el jugador quiera ponerle a su Conejo
     */
    public Conejo(String nombre) {
        super(nombre);
    }

    /**
     * alimenta a la mascota.
     * comprueba la salud de la mascota y el valor generado por el random
     * si la mascota esta sana o esta enferma pero el valor del random es 1 y la alimentacion no supera 100
     * entonces sube el atributo alimentacion y baja el atributo higiene
     * imprime confirmacion de accion
     * si no cumple la condicion imprime mensaje de negativa
     */
    @Override
    public void alimentar() {

        int suerte = rdm.nextInt(0, 2);
        if ((isSalud() || (!isSalud() && suerte == 1)) && getAlimentacion() < 100) {

            setAlimentacion(getAlimentacion() + 15);
            setHigiene(getHigiene() - 5);
            Menu.clear();
            System.out.println("\t" + ColorText.bold + ColorText.bGreen + ColorText.black + " " + getNombre()
                    + " ha comido " + ColorText.cleanse);
            aumentarContadorAlimentar();
        } else {
            Menu.clear();
            System.out.println("\t" + ColorText.bold + ColorText.bRed + ColorText.black + " " + getNombre()
                    + " no quiere comer " + ColorText.cleanse);
            System.out.println("\n\t\t (\\(\\\n" +
                    "\t\t (“-.-)\n" +
                    "\t\t /   \\  ");
        }

    }

    /**
     * baña a la mascota.
     * comprueba la salud de la mascota y el valor generado por el random
     * si la mascota esta sana o esta enferma pero el valor del random es 1 y la higiene no supera 100
     * entonces baja el atributo alimentacion y sube el atributo higiene
     * imprime confirmacion de accion
     * si no cumple la condicion imprime mensaje de negativa
     */
    @Override
    public void limpiar() {

        int suerte = rdm.nextInt(0, 2);
        if ((isSalud() || (!isSalud() && suerte == 1)) && getHigiene() < 100) {

            setAlimentacion(getAlimentacion() - 5);
            setHigiene(getHigiene() + 15);
            Menu.clear();
            System.out.println("\t" + ColorText.bold + ColorText.bGreen + ColorText.black + " " + getNombre()
                    + " se ha bañado " + ColorText.cleanse);
            aumentarContadorLimpiar();
        } else {
            Menu.clear();
            System.out.println("\t" + ColorText.bold + ColorText.bRed + ColorText.black + " " + getNombre()
                    + " no quiere bañarse " + ColorText.cleanse);
            System.out.println("\n\t\t  /)/)\n" +
                    "\t\t (-.-“)\n" +
                    "\t\t  /   \\ ");
        }

    }

    /**
     * juega con la mascota.
     * comprueba la salud de la mascota y el valor generado por el random
     * si la mascota esta sana o esta enferma pero el valor del random es 1 y el animo no supera 100
     * entonces sube el atributo animo y baja el atributo higiene y alimentacion
     * imprime confirmacion de accion
     * si no cumple la condicion imprime mensaje de negativa
     */
    @Override
    public void jugar() {

        int suerte = rdm.nextInt(0, 2);
        if ((isSalud() || (!isSalud() && suerte == 1)) && getAnimo() < 100) {

            setAlimentacion(getAlimentacion() - 5);
            setHigiene(getHigiene() - 5);
            setAnimo(getAnimo() + 15);
            Menu.clear();
            System.out.println("\t" + ColorText.bold + ColorText.bGreen + ColorText.black + " " + getNombre()
                    + " ha jugado " + ColorText.cleanse);
            aumentarContadorJugar();
        } else {
            Menu.clear();
            System.out.println("\t" + ColorText.bold + ColorText.bRed + ColorText.black + " " + getNombre()
                    + " no quiere jugar " + ColorText.cleanse);
            System.out.println("\n\t\t (\\(\\\n" +
                    "\t\t (“-.-)\n" +
                    "\t\t /   \\ ");
        }

    }

    /**
     * establece el estado de enfermo
     * genera un random si el resultado es 0 y la mascota esta sana
     * la enferma, cambiando el boolean salud a false
     */
    @Override
    public void salud() {
        int suerte = rdm.nextInt(0, 11);
        if (isSalud() && suerte == 0) {
            setSalud(false);
        }

    }

    /**
     * imprime el modelo en ASCCI del conejo según el valor de
     * los atributos alimentacion, higiene, animo
     * prioriza el modelo de enfermo en caso de que el boolean salud = false
     * imprime el modelo dormir al final de cada dia
     */
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

    /**
     * El tipo de la clase de la mascota
     *
     * @return String con el tipo Conejo
     */
    @Override
    public String tipoMascota() {
        return "Conejo";
    }
}
