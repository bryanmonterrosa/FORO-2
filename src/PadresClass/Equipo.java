package PadresClass;

public class Equipo {
    private String fabricante;
    private String modelo;
    private String procesador;

    public Equipo(String fabricante, String modelo, String procesador) {
        this.fabricante = fabricante;
        this.modelo = modelo;
        this.procesador = procesador;
    }
    public String getFabricante() {
        return fabricante;
    }
    public String getModelo() {
        return modelo;
    }
    public String getProcesador() {
        return procesador;
    }
}
