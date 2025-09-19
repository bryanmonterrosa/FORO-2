package GestionInventario;
import PadresClass.Equipo;
import java.util.ArrayList;

public class Inventario {
    private ArrayList<Equipo> inventario; //Se utiliza un arraylist que nos permitira almacena los objetos

    public Inventario(){
        this.inventario = new ArrayList<>();
    }
    public void agregarEquipo(Equipo equipo){//Metodo para agregar un equipo al arraylist inventario
        this.inventario.add(equipo);
    }
    //Siguiente Metodo devuelve en un arraylist la lista de dispositivos, segun la clase que se elija
    public ArrayList<Equipo> getInventario(Class<?> clase){
        ArrayList<Equipo> equipos = new ArrayList<>(); //Instancia un nuevo arraylist llamada equipos
        for( Equipo equipo : this.inventario){
            if (clase.isInstance(equipo)){//Valida si cada equipo corresponde a la clase que se elija como parametro
                equipos.add(equipo);//Y lo agrega al arraylist equipos
            }
        }
        return equipos;
    }
}
