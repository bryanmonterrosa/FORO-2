package HijasClass;

import PadresClass.Equipo;

public class Tablet extends Equipo {
    private String tamanioPantalla;
    private String tecnologiaTouch;
    private String taminoNand;
    private String tipoOS;

    public Tablet(String fabricante, String modelo, String procesador,String tecnologiaTouch, String tamanioPantalla, String taminoNand, String tipoOS) {
        super(fabricante, modelo, procesador);
        this.tamanioPantalla = tamanioPantalla;
        this.tecnologiaTouch = tecnologiaTouch;
        this.taminoNand = taminoNand;
        this.tipoOS = tipoOS;

    }
}
