package edu.poniperro;

import static org.junit.Assert.*;

import edu.poniperro.Tarjeta_Usuario.TarjetaUsuario;
import edu.poniperro.bicicleta.Bicicleta;
import edu.poniperro.estacion.Estacion;
import org.junit.Before;
import org.junit.Test;

public class test_bicipalma {

    Estacion estacion;

    @Before
    public void estaciones() {
        estacion = new Estacion(4, "Lllucmajor", 4);
    }

    @Test
    public void test_crear_estacion() {
        Estacion estacion = new Estacion(3, "Palma", 10);
    }

    @Test
    public void test_consultar_estacion() {
        estacion.consultarEstacion();
    }

    @Test
    public void test_anclajes_libres() {
        assertEquals(estacion.anclajesLibres(), 4, 0);
    }

    @Test
    public void crearBicicleta() {
        Bicicleta bici = new Bicicleta(1);
    }

    @Test
    public void anclarBicicleta() {
        Bicicleta bici = new Bicicleta(2);
        estacion.anclarBicicleta(bici);
    }

    @Test
    public void consultarAnclajes() {

        estacion.consultarAnclajes();
    }

    @Test
    public void crearTarjetaUsuario() {

        TarjetaUsuario tarjetaUsuario = new TarjetaUsuario("987654312", true);
    }

    @Test
    public void leerTarjetaUsuario() {
        TarjetaUsuario tarjetaUsuario = new TarjetaUsuario("123456789", true);
        estacion.leerTarjetaUsuario(tarjetaUsuario);
    }

    @Test(timeout = 1000)
    public void retirarBicicleta() {
        estacion.anclarBicicleta(new Bicicleta(342));
        TarjetaUsuario tarjetaUsuario = new TarjetaUsuario("456922729", true);
        estacion.retirarBicicleta(tarjetaUsuario);
    }

    /* @Test
    public void Movil() {
        int getId() Dudas test interfaces movil?¿
    } */

}