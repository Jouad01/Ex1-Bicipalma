package edu.poniperro.bicicleta;

public class Bicicleta {
    private final int id;
        public Bicicleta(int id) {
            this.id = id;
        }
    @Override
    public String toString(){
            return Integer.toString(this.id);
    }
}
