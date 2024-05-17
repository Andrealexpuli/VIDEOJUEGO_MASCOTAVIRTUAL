package Mascotas;

import java.util.Random;

import Utils.*;

/**
 * @author Andrea Alexandra Pulido de la Serna
 * Clase abstracta mascota de ella heredan Conejo, Gato y Pajaro
 * perteneciente al paquete Mascotas.
 */
public abstract class Mascota {
    public static Random rdm = new Random();
    private String nombre;
    private int edad = 0;
    private boolean salud = true;
    private boolean vida = true;
    private boolean curado = false;
    private boolean dormido = false;
    private int alimentacion = 80;
    private int higiene = 80;
    private int animo = 80;
    private int contadorJugar = 0;
    private int contadorAlimentar = 0;
    private int contadorLimpiar = 0;
    private int contadorEnferma = 0;

    /**
     * Constructor vacio de Mascota
     */
    public Mascota() {
    }

    /**
     * Constructor de Mascota
     *
     * @param nombre El nombre que el jugador quiera para su mascota
     */
    public Mascota(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el contador de dias que la mascota ha estado enferma
     *
     * @return int de dias que la mascota ha estado enferma
     */
    public int getContadorEnferma() {
        return contadorEnferma;
    }

    /**
     * Establece el contador de días que la mascota ha estado enferma
     *
     * @param contadorEnferma int dias que la mascota ha estado enferma
     */
    public void setContadorEnferma(int contadorEnferma) {
        this.contadorEnferma = contadorEnferma;
    }

    /**
     * Obtiene el contador de veces que la mascota ha jugado
     *
     * @return int veces que la mascota ha jugado
     */
    public int getContadorJugar() {
        return contadorJugar;
    }

    /**
     * Establece el contador de veces que la mascota ha jugado
     *
     * @param contadorJugar int veces que la mascota ha jugado
     */
    public void setContadorJugar(int contadorJugar) {
        this.contadorJugar = contadorJugar;
    }

    /**
     * Obtiene el contador de veces que la mascota se ha alimentado
     *
     * @return veces que la mascota se ha alimentado
     */
    public int getContadorAlimentar() {
        return contadorAlimentar;
    }

    /**
     * Establece el contador de veces que la mascota se ha alimentado
     *
     * @param contadorAlimentar int veces que la mascota se ha alimentado
     */
    public void setContadorAlimentar(int contadorAlimentar) {
        this.contadorAlimentar = contadorAlimentar;
    }

    /**
     * Obtiene el contador de veces que la mascota se ha bañado
     *
     * @return veces que la mascota se ha bañado
     */
    public int getContadorLimpiar() {
        return contadorLimpiar;
    }

    /**
     * Establece el contador de veces que la mascota se ha bañado
     *
     * @param contadorLimpiar int veces que la mascota se ha bañado
     */
    public void setContadorLimpiar(int contadorLimpiar) {
        this.contadorLimpiar = contadorLimpiar;
    }

    /**
     * Obtiene el nombre de la mascota
     *
     * @return String del nombre de la mascota
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre de la mascota
     *
     * @param nombre String del nombre de la mascota
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene la edad de la mascota
     *
     * @return int de la edad de la mascota
     */
    public int getEdad() {
        return edad;
    }

    /**
     * Establece la edad de la mascota
     *
     * @param edad int con la edad de la mascota
     */
    public void setEdad(int edad) {
        this.edad = edad;
    }

    /**
     * Obtiene la salud de la mascota (Sana o Enferma)
     *
     * @return boolean con la salud de la mascota (Sana o Enferma)
     */
    public boolean isSalud() {
        return salud;
    }

    /**
     * Establece la salud de la mascota (Sana o Enferma)
     *
     * @param salud boolean con la salud de la mascota (Sana o Enferma)
     */
    public void setSalud(boolean salud) {
        this.salud = salud;
    }

    /**
     * Obtiene el estado de vida de la mascota (Viva o Muerta)
     *
     * @return boolean con el estado de la mascota (Viva o Muerta)
     */
    public boolean isVida() {
        return vida;
    }

    /**
     * Establece el estado de vida de la mascota (Viva o Muerta)
     *
     * @param vida boolean con el estado de vida de la mascota (Viva o Muerta)
     */
    public void setVida(boolean vida) {
        this.vida = vida;
    }

    /**
     * Obtiene si la mascota esta curada
     *
     * @return boolean con el estado de curación
     */
    public boolean isCurado() {
        return curado;
    }

    /**
     * Establece el estado de curación de la mascota
     *
     * @param curado boolean con el estado de curación de la mascota
     */
    public void setCurado(boolean curado) {
        this.curado = curado;
    }

    /**
     * Obtiene si la mascota está dormida
     *
     * @return boolean con el estado de dormido
     */
    public boolean isDormido() {
        return dormido;
    }

    /**
     * Establece si la mascota esta dormida
     *
     * @param dormido boolean con el estado de dormido
     */
    public void setDormido(boolean dormido) {
        this.dormido = dormido;
    }

    /**
     * Obtiene el nivel de alimentación de la mascota
     *
     * @return int con el nivel de alimentación
     */
    public int getAlimentacion() {
        return alimentacion;
    }

    /**
     * Establece el nivel de alimentacion de la mascota
     *
     * @param alimentacion int con el nivel de alimentación
     */
    public void setAlimentacion(int alimentacion) {
        this.alimentacion = alimentacion;
    }

    /**
     * Obtiene el nivel de higiene de la mascota
     *
     * @return int con el nivel de higiene de la mascota
     */
    public int getHigiene() {
        return higiene;
    }

    /**
     * Establece el nivel de higiene de la mascota
     *
     * @param higiene int con el nivel de higiene
     */
    public void setHigiene(int higiene) {
        this.higiene = higiene;
    }

    /**
     * Obtiene el nivel de estado de animo de la mascota
     *
     * @return int con el nivel de animo
     */
    public int getAnimo() {
        return animo;
    }

    /**
     * Establece el nivel de animo de la mascota
     *
     * @param animo int con el nivel de animo
     */
    public void setAnimo(int animo) {
        this.animo = animo;
    }

    /**
     * cura a la mascota cuando el boolean Salud = false (enferma) y si no se ha efectuado ya una cura
     * para ello genera un valor random segun los valores de los atributos alimentacion, higiene y animo
     * cuanto mas bajos sean el random tendrá un numero más amplio de valores a generar si el resultado del
     * random es = 0 la mascota se cura y los stats por debajo de 30 se reestablecen a 45
     * imprime mensaje cuando la mascota se cura
     * imprime mensaje cuando la mascota no se cura
     * imprime mensaje de alerta cuando el jugador trata de curar dos veces en un día a la mascota
     */
    public void curar() {

        int dado = 1;

        if (!curado) {
            if (alimentacion >= 40 && higiene >= 40 && animo >= 40) {
                dado = rdm.nextInt(0, 2);
            } else if (alimentacion >= 30 || higiene >= 30 || animo >= 30) {
                dado = rdm.nextInt(0, 4);
            } else if (alimentacion >= 20 || higiene >= 20 || animo >= 20) {
                dado = rdm.nextInt(0, 5);
            } else if (alimentacion >= 10 || higiene >= 10 || animo >= 10) {
                dado = rdm.nextInt(0, 6);
            } else {
                dado = rdm.nextInt(0, 101);
            }

            if (dado == 0) {
                if (alimentacion <= 30) {
                    setAlimentacion(45);
                }
                if (higiene <= 30) {
                    setHigiene(45);
                }
                if (animo <= 30) {
                    setAnimo(45);
                }
                setSalud(true);
                Menu.clear();
                System.out.println("\t" + ColorText.bold + ColorText.bGreen + ColorText.black + " ¡Genial, " + getNombre() + " se ha curado! " + ColorText.cleanse);
            } else {
                setSalud(false);
                Menu.clear();
                System.out.println("\t" + ColorText.bold + ColorText.bYellow + ColorText.black + " ¡Qué mal, a " + getNombre() + " no le hizo efecto la medicina " + ColorText.cleanse);
            }
            setCurado(true);
        } else {
            Menu.clear();
            System.out.println("\t" + ColorText.bold + ColorText.bRed + ColorText.black + " " + getNombre() + " no quiere tomar más medicamento por hoy " + ColorText.cleanse);

        }
    }

    /**
     * Suma 1 a la edad
     */
    public void crecer() {
        edad++;
    }

    /**
     * suma 1 al contador de Jugar
     */
    public void aumentarContadorJugar() {
        contadorJugar++;
    }

    /**
     * suma 1 al contador de limpiar
     */
    public void aumentarContadorLimpiar() {
        contadorLimpiar++;
    }

    /**
     * suma 1 al contador de alimentar
     */
    public void aumentarContadorAlimentar() {
        contadorAlimentar++;
    }

    /**
     * comprueba si la mascota esta enferma y suma 1 al contador de dias enferma
     */
    public void aumentarContadorEnfermo() {
        if (!isSalud()) {
            contadorEnferma++;
        }

    }

    /**
     * imprime avisos de estado cuando la mascota tiene un valor por debajo de 50 en
     * los atributos alimentacion, higiene y animo. respectivamente
     * imprime aviso de mascota enferma
     */
    public void avisos() {

        if (alimentacion < 50) {
            System.out.println("\t" + ColorText.bold + ColorText.yellow + "> " + getNombre() + " tiene hambre" + ColorText.cleanse);
        }
        if (higiene < 50) {
            System.out.println("\t" + ColorText.bold + ColorText.yellow + "> " + getNombre() + " huele mal" + ColorText.cleanse);
        }
        if (animo < 50) {
            System.out.println("\t" + ColorText.bold + ColorText.yellow + "> " + getNombre() + " se siente triste" + ColorText.cleanse);
        }
        if (!salud) {
            System.out.println("\t" + ColorText.bold + ColorText.red + "> " + getNombre() + " se encuentra mal" + ColorText.cleanse);
        }

    }

    /**
     * comprueba que los atributos alimentacion, higiene y animo esten en 30 o por debajo
     * si cualquier atributo cumple la condicion cambia la salud a false (enferma)
     * comprueba si alguno de los atributos anteriores llega a 0, si llega cambia
     * vida a false (muerta)
     */
    public void comprobarStats() {
        if (alimentacion <= 30 || higiene <= 30 || animo <= 30) {
            salud = false;
        }
        if (alimentacion <= 0 || higiene <= 0 || animo <= 0) {
            vida = false;
        }
    }

    /**
     * imprime mensaje de que la mascota se ha dormido
     * resetea el boolean de curado
     * baja los atributos alimentacion, higiene y animo, de manera incremental por dia
     * (aumento de 5 cada 3 dias a partir del dia 6, inicia en -5 hasta -30)
     */
    public void dormir() {

        System.out.println("\n\t" + ColorText.bold + ColorText.bPink + ColorText.black + " " + getNombre() + " se ha ido a dormir " + ColorText.cleanse + "\n");
        dormido = true;
        curado = false;

        if (edad <= 6) {
            alimentacion -= 5;
            higiene -= 5;
            animo -= 5;
        } else if (edad <= 9) {
            alimentacion -= 10;
            higiene -= 10;
            animo -= 10;
        } else if (edad <= 12) {
            alimentacion -= 15;
            higiene -= 15;
            animo -= 15;
        } else if (edad <= 15) {
            alimentacion -= 20;
            higiene -= 20;
            animo -= 20;
        } else {
            alimentacion -= 30;
            higiene -= 30;
            animo -= 30;
        }
    }

    /**
     * trasforma a string los atributos de la mascota
     *
     * @return
     */
    @Override
    public String toString() {
        return "Mascota{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", salud=" + salud +
                ", vida=" + vida +
                ", curado=" + curado +
                ", dormido=" + dormido +
                ", alimentacion=" + alimentacion +
                ", higiene=" + higiene +
                ", animo=" + animo +
                '}';
    }

    /**
     * alimenta a la mascota: definido en clase correspondiente
     */
    public abstract void alimentar();

    /**
     * baña a la mascota: definido en clase correspondiente
     */
    public abstract void limpiar();

    /**
     * juega con la mascota: definido en clase correspondiente
     */
    public abstract void jugar();

    /**
     * establece enfermedad de la mascota: definido en clase correspondiente
     */
    public abstract void salud();

    /**
     * imprime el modelo de la mascota: definido en clase correspondiente
     */
    public abstract void imprimirModelo();

    /**
     * String con el tipo de la mascota : definido en clase correspondiente
     *
     * @return
     */
    public abstract String tipoMascota();


}
