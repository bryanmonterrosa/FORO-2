package HijasClass;

import PadresClass.Equipo;

public class Desktop extends Equipo {
    private String memoria;
    private String grafica;
    private String tamanioTorre;
    private String tamanioHDD;



    public Desktop(String fabricante, String modelo, String procesador, String memoria,String grafica,String tamanioTorre,String tamanioHDD) {
        super(fabricante,modelo,procesador);
        this.memoria = memoria;
        this.grafica = grafica;
        this.tamanioTorre = tamanioTorre;
        this.tamanioHDD = tamanioHDD;
    }
    public  String getMemoria() {
        return memoria;
    }
    public String grafica(){
        return grafica;
    }
    public String tamanioTorre(){
        return tamanioTorre;
    }
    public String tamanioHDD(){
        return tamanioHDD;
    }
}

