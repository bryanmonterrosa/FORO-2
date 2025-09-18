import GestionInventario.Inventario;
import HijasClass.Desktop;
import HijasClass.Laptop;
import HijasClass.Tablet;
import PadresClass.Equipo;

import java.util.ArrayList;
public class Main {
    public static void main(String[] args) {
        Inventario inventario = new Inventario();
        //Agrega los datos nesesarios para cada clase los cuales se almacenaran en el arraylist
        Desktop desktop = new Desktop("Dell","Inspiron","I3","16GB","RTX4090","Grande","256GB");
        Laptop laptop = new Laptop("Lenovo","Thinpad","I5","32GB","15in","1tb");
        Tablet tablet = new Tablet("Samsumg","GalaxyTab","Helio","Capasitiva","12in","128GB","Android");
        //Almacena en la coleccion mediante el metodo agregarEquipo de la clase inventario
        inventario.agregarEquipo(desktop);
        inventario.agregarEquipo(laptop);
        inventario.agregarEquipo(tablet);
        //Muentra mediante un arraylist un listado de dispositivos segun sea el metodo que se utilize
        ArrayList<Equipo> listaEquipos = inventario.getDesktop();
        for(Equipo equipo : listaEquipos){
            System.out.println(equipo.getFabricante());
            System.out.println(equipo.getModelo());
            System.out.println(equipo.getProcesador());
        }
    }
}