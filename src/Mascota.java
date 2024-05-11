
import java.util.Random;

public abstract class Mascota {
    public static Random rdm = new Random();
    private String nombre;
    private int edad = 0;
    private boolean salud = true;
    private boolean vida = true;
    private boolean curado = false;
    private boolean dormido = false;
    private int alimentacion = 100;
    private int higiene = 100;
    private int animo = 100;

    public Mascota() {
    }

    public Mascota(String nombre) {
        this.nombre = nombre;
    }

    public Mascota(String nombre, int edad, boolean salud, boolean vida, boolean curado, boolean dormido, int alimentacion, int higiene, int animo) {
        this.nombre = nombre;
        this.edad = edad;
        this.salud = salud;
        this.vida = vida;
        this.curado = curado;
        this.dormido = dormido;
        this.alimentacion = alimentacion;
        this.higiene = higiene;
        this.animo = animo;

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public boolean isSalud() {
        return salud;
    }

    public void setSalud(boolean salud) {
        this.salud = salud;
    }

    public boolean isVida() {
        return vida;
    }

    public void setVida(boolean vida) {
        this.vida = vida;
    }

    public boolean isCurado() {
        return curado;
    }

    public void setCurado(boolean curado) {
        this.curado = curado;
    }

    public boolean isDormido() {
        return dormido;
    }

    public void setDormido(boolean dormido) {
        this.dormido = dormido;
    }

    public int getAlimentacion() {
        return alimentacion;
    }

    public void setAlimentacion(int alimentacion) {
        this.alimentacion = alimentacion;
    }

    public int getHigiene() {
        return higiene;
    }

    public void setHigiene(int higiene) {
        this.higiene = higiene;
    }

    public int getAnimo() {
        return animo;
    }

    public void setAnimo(int animo) {
        this.animo = animo;
    }


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
                System.out.println("¡Genial, " + getNombre() + " se ha curado!");
            } else {
                setSalud(false);
                System.out.println("¡Qué mal, a " + getNombre() + " no le hizo efecto la medicina");
            }
            setCurado(true);
        } else {
            System.out.println(getNombre() + " no quiere tomar más medicamento por hoy");

        }
    }

    public void crecer() {
        edad++;
    }

    public void avisos() {
        if (alimentacion < 50) {
            System.out.println(getNombre() + " tiene hambre");
        }
        if (higiene < 50) {
            System.out.println(getNombre() + " huele mal");
        }
        if (animo < 50) {
            System.out.println(getNombre() + " se siente triste");
        }
        if (!salud) {
            System.out.println(getNombre() + " se encuentra mal");
        }
    }

    public void comprobarStats() {
        if (alimentacion <= 30 || higiene <= 30 || animo <= 30) {
            salud = false;
        }
        if (alimentacion == 0 || higiene == 0 || animo == 0) {
            vida = false;
        }
    }

    public void dormir() {
        System.out.println(getNombre() + " se ha dormido");
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

    public abstract void alimentar();

    public abstract void limpiar();

    public abstract void jugar();

    public abstract void salud();

    public abstract void imprimirModelo();


}
