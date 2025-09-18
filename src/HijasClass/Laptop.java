package HijasClass;

import PadresClass.Equipo;

public class Laptop extends Equipo {
    private String memoria;
    private String tamanioPantalla;
    private String taminioHDD;
    public Laptop(String fabricante, String modelo, String procesador,String memoria, String tamanioPantalla, String taminioHDD) {
        super(fabricante, modelo, procesador);
        this.memoria = memoria;
        this.tamanioPantalla = tamanioPantalla;
        this.taminioHDD = taminioHDD;

    }
}
