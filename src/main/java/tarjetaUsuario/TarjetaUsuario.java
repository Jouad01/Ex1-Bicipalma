package tarjetaUsuario;

public class TarjetaUsuario {
    private final String id;
    private boolean activada = false;

    public TarjetaUsuario(String id, boolean activada) {
        this.id = id;
        this.activada = activada;
    }

    public boolean activada() {

        return this.activada;
    }
}