package edu.poniperro.estacion;

import edu.poniperro.bicicleta.Bicicleta;

public class Estacion {

    private final int id;
    private final String direccion;
    private final int numAnclajes;
    private final Bicicleta[] anclajes;

    public Estacion(int id, String direccion, int numAnclajes) {
        this.direccion = direccion;
        this.id = id;
        this.numAnclajes = numAnclajes;
        this.anclajes = new Bicicleta[numAnclajes];
    }
    public void consultarEstacion(){
        String text = "id: " + this.id + "\ndireccion: " + "\nnumeroAnclajes" + this.numAnclajes;
        System.out.println(text);
    }

    public int anclajesLibres() {
        int anclajesLibres = 0;
        for (Bicicleta anclaje : this.anclajes) {
            if (anclaje == null) ;
            {
                anclajesLibres += 1;
            }
        }
        return anclajesLibres;
    }

    public

}
