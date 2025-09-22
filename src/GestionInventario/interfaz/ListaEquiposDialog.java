package GestionInventario.interfaz;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import GestionInventario.Inventario;
import HijasClass.Desktop;
import HijasClass.Laptop;
import HijasClass.Tablet;
import PadresClass.Equipo;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ListaEquiposDialog extends JDialog {
    private String tipoEquipo;
    private JTable tablaEquipos;
    private DefaultTableModel modeloTabla;
    private JButton btnCerrar;
    private Inventario inventario; // referencia al inventario
    

  public ListaEquiposDialog(JFrame parent, Inventario inventario, String tipoEquipo) {
    super(parent, "Lista de " + tipoEquipo, true);
        this.tipoEquipo = tipoEquipo;
        this.inventario = inventario;
         // guardamos referencia al inventario

        setSize(800, 400);
        setLocationRelativeTo(parent);
        setLayout(new BorderLayout());

        setup();
        cargarDatosDesdeInventario(); // cargar datos desde inventario real
        configurarBotones();
    }

    private void setup() {
        JLabel lblTitulo = new JLabel("Lista de " + tipoEquipo, SwingConstants.CENTER);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 18));
        lblTitulo.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
        add(lblTitulo, BorderLayout.NORTH);

         // Crear tabla con columnas dinamicas segun el tipo de equipo
        String[] columnas = null;
        switch (tipoEquipo) {
            case "Desktop":
                columnas = new String[]{
                        "Fabricante", 
                        "Modelo",
                         "Microprocesador", 
                         "Memoria",
                        "Tarjeta grafica",
                         "Tamano de torre", 
                         "Capacidad de disco duro"
                };
                break;
            case "Laptop":
                columnas = new String[]{
                        "Fabricante", 
                        "Modelo", 
                        "Microprocesador", 
                        "Memoria",
                        "Tamano pantalla",
                         "Capacidad de disco duro"
                };
                break;
            case "Tablet":
                columnas = new String[]{
                        "Fabricante", 
                        "Modelo", 
                        "Microprocesador", 
                        "Tamano diagonal de pantalla",
                        "Capacitiva/Resistiva",
                         "Tamano memoria NAND", 
                         "Sistema Operativo"
                };
                break;
            case "Todos los equipos":
                columnas = new String[]{
                        "Tipo", 
                        "Fabricante", 
                        "Modelo", "Microprocesador", 
                        "Memoria",
                         "Detalles adicionales"
                };
                break;
            default:
                columnas = new String[]{"Informacion"};
                break;
        }

        modeloTabla = new DefaultTableModel(columnas, 0) {
            public boolean isCellEditable(int row, int column) {
                return false;// Hacer la tabla no editable
            }
        };

        tablaEquipos = new JTable(modeloTabla);
        tablaEquipos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tablaEquipos.getTableHeader().setReorderingAllowed(false);

        JScrollPane scrollPane = new JScrollPane(tablaEquipos);
        scrollPane.setBorder(BorderFactory.createTitledBorder("Equipos registrados"));
        add(scrollPane, BorderLayout.CENTER);

         // Panel de botones
        JPanel panelBotones = new JPanel(new FlowLayout());
        btnCerrar = new JButton("Cerrar");
        panelBotones.add(btnCerrar);
        add(panelBotones, BorderLayout.SOUTH);
    }

    private void cargarDatosDesdeInventario() { // nuevo metodo para cargar inventario
        modeloTabla.setRowCount (0);

        for (Equipo eq : inventario.getInventario(Equipo.class)) {
            if ("Desktop".equals(tipoEquipo) && eq instanceof Desktop) {
                Desktop d = (Desktop) eq;
                modeloTabla.addRow(new Object[]{
                        d.getFabricante(), d.getModelo(), d.getProcesador(),
                        d.getMemoria(), d.grafica(), d.tamanioTorre(), d.tamanioHDD()
                });
            } else if ("Laptop".equals(tipoEquipo) && eq instanceof Laptop) {
                Laptop l = (Laptop) eq;
                modeloTabla.addRow(new Object[]{
                        l.getFabricante(), l.getModelo(), l.getProcesador(),
                        l.getMemoria(), l.getTamanioPantalla(), l.getTaminioHDD()
                });
            } else if ("Tablet".equals(tipoEquipo) && eq instanceof Tablet) {
                Tablet t = (Tablet) eq;
                modeloTabla.addRow(new Object[]{
                        t.getFabricante(), t.getModelo(), t.getProcesador(),
                        t.getTamanioPantalla(), t.getTecnologiaTouch(), t.getTaminoNand(), t.getTipoOS()
                });
            } else if ("Todos los equipos".equals(tipoEquipo)) {
                if (eq instanceof Desktop) {
                    Desktop d = (Desktop) eq;
                    modeloTabla.addRow(new Object[]{
                            "Desktop", d.getFabricante(), d.getModelo(), d.getProcesador(),
                            d.getMemoria(), d.grafica() + ", " + d.tamanioTorre() + ", " + d.tamanioHDD()
                    });
                } else if (eq instanceof Laptop) {
                    Laptop l = (Laptop) eq;
                    modeloTabla.addRow(new Object[]{
                            "Laptop", l.getFabricante(), l.getModelo(), l.getProcesador(),
                            l.getMemoria(), l.getTamanioPantalla() + ", " + l.getTaminioHDD()
                    });
                } else if (eq instanceof Tablet) {
                    Tablet t = (Tablet) eq;
                    modeloTabla.addRow(new Object[]{
                            "Tablet", t.getFabricante(), t.getModelo(), t.getProcesador(),
                            "N/A", t.getTamanioPantalla() + ", " + t.getTecnologiaTouch() + ", " + t.getTaminoNand() + ", " + t.getTipoOS()
                    });
                }
            }
        }
    }

    private void configurarBotones() {
        btnCerrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }
}
