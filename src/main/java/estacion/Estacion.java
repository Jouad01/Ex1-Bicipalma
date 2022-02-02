package estacion;

// Libreria para generar un numero aleatorio
import java.util.concurrent.ThreadLocalRandom;

import tarjetaUsuario.TarjetaUsuario;
import bicicleta.Bicicleta;


public class Estacion {

    private final int id;
    private final String direccion;
    private final int numAnclajes;
    private final Bicicleta[] anclajes; // Array

    public Estacion(int id, String direccion, int numAnclajes) {
        this.direccion = direccion;
        this.id = id;
        this.numAnclajes = numAnclajes;
        this.anclajes = new Bicicleta[numAnclajes];
    }
    // Imprime lo que pide main
    public void consultarEstacion() {
        String text = "id: " + this.id + "\nDireccion: " + "\nnumeroAnclajes" + this.numAnclajes;
        System.out.println(text);
    }

    public int anclajesLibres() {
        int anclajesLibres = 0;
        for (Bicicleta anclaje : this.anclajes) {
            if (anclaje == null){
                anclajesLibres += 1; // Si no hay anclaje se añade uno
            }
        }
        return anclajesLibres;
    }

    private void mostrarAnclajes(Bicicleta bicicleta, int numAnclajes) {
        System.out.println("Bicicleta: " + bicicleta + " " + "anclada en el anclaje: " + (numAnclajes + 1));
    }


    public void anclarBicicleta(Bicicleta bicicleta) {
        for (int posicionAnclaje = 0; posicionAnclaje < numAnclajes; posicionAnclaje++) {
            if (anclajes[posicionAnclaje] == null) {
                anclajes[posicionAnclaje] = bicicleta;
                mostrarAnclajes(bicicleta, posicionAnclaje);
                break; // Una vez se añade bicicleta deja de buscar espacios vacios
            }
        }
    }

    public void consultarAnclajes() {
        String text = "";
        for (int posicionAnclaje = 0; posicionAnclaje < numAnclajes; posicionAnclaje++) {
            if (anclajes[posicionAnclaje] == null) {
                text += "Anclaje " + (posicionAnclaje + 1) + " " + "libre\n";
            } else {
                text += "Anclaje " + " " + (posicionAnclaje + 1) + " " + anclajes[posicionAnclaje] + "\n";
            }
        }
        System.out.println(text);
    }

    public boolean leerTarjetaUsuario(TarjetaUsuario tarjeta){
        return tarjeta.activada();
    }

    private int generarAnclaje(){
        return ThreadLocalRandom.current().nextInt(0, numAnclajes); // Libreria generar numero aleatorio
    }

    private void mostrarBicicleta(Bicicleta bicicleta, int numAnclaje){
        String text = "Bicicleta retirada: " + bicicleta + " del anclaje: " + (numAnclaje + 1);
        System.out.println(text);
    }

    public void retirarBicicleta(TarjetaUsuario tarjeta){
        if (tarjeta.activada() && anclajesLibres() > 0){
            int anclaje = generarAnclaje();
            while (anclajes[anclaje] == null) {
                anclaje = generarAnclaje();
            }
            mostrarBicicleta(anclajes[anclaje], anclaje);
            anclajes[anclaje] = null; // Se puede poner this. para tener más claro de donde viene
        }
    }

}