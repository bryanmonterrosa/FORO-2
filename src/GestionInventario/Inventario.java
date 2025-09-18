package GestionInventario;
import HijasClass.Desktop;
import HijasClass.Laptop;
import HijasClass.Tablet;
import PadresClass.Equipo;
import java.util.ArrayList;

public class Inventario {
    private ArrayList<Equipo> inventario; //Se utiliza un arraylist que nos permitira almacena los objetos

    public Inventario(){
        this.inventario = new ArrayList<>();

    }
    public void agregarEquipo(Equipo equipo){//Metodo para agregar un equipo al arraylist inventario
        this.inventario.add(equipo);
        System.out.println("Equipo agregado");//Muestra el mensaje confirmando que se agrego
    }
    //Metodo que devuelto el inventario completo
    public ArrayList<Equipo> getInventario(){//Devuelve el contenido almacenado como arraylist para ser mostrado
        return this.inventario;
    }
    //Metodos que nos permitin obtener en una nueva coleccion por tipo de dispositivos
    public ArrayList<Equipo> getDesktop(){
        ArrayList<Equipo> desktops = new ArrayList<>();
        for( Equipo equipo : this.inventario){
            if (equipo instanceof Desktop){
                desktops.add(equipo);
            }
        }
        return desktops;
    }
    public ArrayList<Equipo> getLaptop(){
        ArrayList<Equipo> laptops = new ArrayList<>();
        for( Equipo equipo : this.inventario){
            if (equipo instanceof Laptop){
                laptops.add(equipo);
            }
        }
        return laptops;
    }
    public ArrayList<Equipo> getTablet() {
        ArrayList<Equipo> tablets = new ArrayList<>();
        for (Equipo equipo : this.inventario) {
            if (equipo instanceof Tablet) {
                tablets.add(equipo);
            }
        }
        return tablets;
    }
}
