import GestionInventario.Inventario;
import GestionInventario.interfaz.InventarioMenu;
import HijasClass.Tablet;
import HijasClass.Desktop;
import HijasClass.Laptop;

public class Main {
    public static void main(String[] args) {
        Inventario inventario = new Inventario();

        Desktop desktop = new Desktop("Dell","Inspiron","I3","16GB","RTX4090","Grande","256GB");
        Laptop laptop = new Laptop("Lenovo","Thinpad","I5","32GB","15in","1tb");
        Tablet tablet = new Tablet("Samsumg","GalaxyTab","Helio","Capasitiva","12in","128GB","Android");
        
        inventario.agregarEquipo(desktop);
        inventario.agregarEquipo(laptop);
        inventario.agregarEquipo(tablet);
       
        InventarioMenu menuPrincipal = new InventarioMenu(inventario);
        menuPrincipal.setVisible(true);
    }

}