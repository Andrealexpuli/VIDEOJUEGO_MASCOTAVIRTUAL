
import java.util.Random;

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

    public Mascota() {
    }

    public Mascota(String nombre) {
        this.nombre = nombre;
    }


    public int getContadorEnferma() {
        return contadorEnferma;
    }

    public void setContadorEnferma(int contadorEnferma) {
        this.contadorEnferma = contadorEnferma;
    }

    public int getContadorJugar() {
        return contadorJugar;
    }

    public void setContadorJugar(int contadorJugar) {
        this.contadorJugar = contadorJugar;
    }

    public int getContadorAlimentar() {
        return contadorAlimentar;
    }

    public void setContadorAlimentar(int contadorAlimentar) {
        this.contadorAlimentar = contadorAlimentar;
    }

    public int getContadorLimpiar() {
        return contadorLimpiar;
    }

    public void setContadorLimpiar(int contadorLimpiar) {
        this.contadorLimpiar = contadorLimpiar;
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
                Menu.clear();
                System.out.println("\t"+ColorText.bold+ColorText.bGreen+ColorText.black+" ¡Genial, " + getNombre() + " se ha curado! "+ColorText.cleanse);
            } else {
                setSalud(false);
                Menu.clear();
                System.out.println("\t"+ColorText.bold+ColorText.bYellow+ColorText.black+" ¡Qué mal, a " + getNombre() + " no le hizo efecto la medicina "+ColorText.cleanse);
            }
            setCurado(true);
        } else {
            Menu.clear();
            System.out.println("\t"+ColorText.bold+ColorText.bRed+ColorText.black+" "+getNombre() + " no quiere tomar más medicamento por hoy "+ColorText.cleanse);

        }
    }

    public void crecer() {
        edad++;
    }

    public void aumentarContadorJugar() {
        contadorJugar++;
    }

    public void aumentarContadorLimpiar() {
        contadorLimpiar++;
    }

    public void aumentarContadorAlimentar() {
        contadorAlimentar++;
    }

    public void aumentarContadorEnfermo() {
        if (!isSalud()) {
            contadorEnferma++;
        }

    }

    public void avisos() {

        if (alimentacion < 50) {
            System.out.println("\t"+ColorText.bold+ColorText.yellow+"> "+getNombre() + " tiene hambre"+ColorText.cleanse);
        }
        if (higiene < 50) {
            System.out.println("\t"+ColorText.bold+ColorText.yellow+"> "+getNombre() + " huele mal"+ColorText.cleanse);
        }
        if (animo < 50) {
            System.out.println("\t"+ColorText.bold+ColorText.yellow+"> "+getNombre() + " se siente triste"+ColorText.cleanse);
        }
        if (!salud) {
            System.out.println("\t"+ColorText.bold+ColorText.red+"> "+getNombre() + " se encuentra mal"+ColorText.cleanse);
        }

    }

    public void comprobarStats() {
        if (alimentacion <= 30 || higiene <= 30 || animo <= 30) {
            salud = false;
        }
        if (alimentacion <= 0 || higiene <= 0 || animo <= 0) {
            vida = false;
        }
    }

    public void dormir() {

        System.out.println("\n\t"+ColorText.bold+ColorText.bPink+ColorText.black+" "+getNombre() + " se ha ido a dormir "+ColorText.cleanse+"\n");
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
    public abstract String tipoMascota();

    public void status() {
        System.out.println("a = " + alimentacion + " h = " + higiene + " j = " + animo);
    }
}
