package GestionInventario.interfaz;


import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ListaEquiposDialog extends JDialog {
    private String tipoEquipo;
    private JTable tablaEquipos;
    private DefaultTableModel modeloTabla;
    private JButton btnCerrar;

    public ListaEquiposDialog(JFrame parent, String tipoEquipo) {
        super(parent, "Lista de " + tipoEquipo, true);
        this.tipoEquipo = tipoEquipo;

        setSize(800, 400);
        setLocationRelativeTo(parent);
        setLayout(new BorderLayout());

        setup();
        cargarDatosEjemplo();
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
                        "Modelo",
                        "Microprocesador",
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
                return false; // Hacer la tabla no editable
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

    private void cargarDatosEjemplo() {
        // Cargar datos de ejemplo segun el tipo de equipo
        switch (tipoEquipo) {
            case "Desktop":
                cargarEjemplosDesktop();
                break;
            case "Laptop":
                cargarEjemplosLaptop();
                break;
            case "Tablet":
                cargarEjemplosTablet();
                break;
            case "Todos los equipos":
                cargarTodosLosEquipos();
                break;
        }
    }

    public void cargarDatosDesdeArrayList(java.util.ArrayList<Object[]> equipos) {
        modeloTabla.setRowCount(0);

        for (Object[] equipo : equipos) {
            modeloTabla.addRow(equipo);
        }
    }

    private void cargarEjemplosDesktop() {
        modeloTabla.addRow(new Object[]{
                "Dell", "OptiPlex 7090", "Intel Core i7-11700", "16GB DDR4",
                "NVIDIA GTX 1650", "Mini Torre", "512GB SSD"
        });
        modeloTabla.addRow(new Object[]{
                "HP", "EliteDesk 800 G8", "Intel Core i5-11500", "8GB DDR4",
                "Intel UHD Graphics", "Micro Torre", "256GB SSD"
        });
        modeloTabla.addRow(new Object[]{
                "Lenovo", "ThinkCentre M90q", "Intel Core i7-10700T", "32GB DDR4",
                "NVIDIA Quadro P620", "Tiny", "1TB HDD + 256GB SSD"
        });
    }

    private void cargarEjemplosLaptop() {
        modeloTabla.addRow(new Object[]{
                "ASUS", "ZenBook 14", "AMD Ryzen 7 5700U", "16GB DDR4",
                "14 pulgadas", "512GB SSD"
        });
        modeloTabla.addRow(new Object[]{
                "Lenovo", "ThinkPad X1 Carbon", "Intel Core i7-1165G7", "16GB LPDDR4",
                "14 pulgadas", "1TB SSD"
        });
        modeloTabla.addRow(new Object[]{
                "Dell", "XPS 13", "Intel Core i5-1135G7", "8GB LPDDR4",
                "13.3 pulgadas", "256GB SSD"
        });
    }

    private void cargarEjemplosTablet() {
        modeloTabla.addRow(new Object[]{
                "Apple", "iPad Pro", "Apple M1", "12.9 pulgadas",
                "Capacitiva", "128GB", "iPadOS"
        });
        modeloTabla.addRow(new Object[]{
                "Samsung", "Galaxy Tab S8", "Snapdragon 8 Gen 1", "11 pulgadas",
                "Capacitiva", "128GB", "Android"
        });
        modeloTabla.addRow(new Object[]{
                "Microsoft", "Surface Pro 9", "Intel Core i5-1235U", "13 pulgadas",
                "Capacitiva", "256GB", "Windows 11"
        });
    }

    private void cargarTodosLosEquipos() {
        modeloTabla.addRow(new Object[]{
                "Desktop", "Dell", "OptiPlex 7090", "Intel Core i7-11700", "16GB DDR4",
                "Torre Mini, NVIDIA GTX 1650, 512GB SSD"
        });
        modeloTabla.addRow(new Object[]{
                "Laptop", "ASUS", "ZenBook 14", "AMD Ryzen 7 5700U", "16GB DDR4",
                "14 pulgadas, 512GB SSD"
        });
        modeloTabla.addRow(new Object[]{
                "Tablet", "Apple", "iPad Pro", "Apple M1", "N/A",
                "12.9 pulgadas, Capacitiva, 128GB, iPadOS"
        });
        modeloTabla.addRow(new Object[]{
                "Desktop", "HP", "EliteDesk 800 G8", "Intel Core i5-11500", "8GB DDR4",
                "Micro Torre, Intel UHD, 256GB SSD"
        });
        modeloTabla.addRow(new Object[]{
                "Laptop", "Lenovo", "ThinkPad X1", "Intel Core i7-1165G7", "16GB LPDDR4",
                "14 pulgadas, 1TB SSD"
        });
        modeloTabla.addRow(new Object[]{
                "Tablet", "Samsung", "Galaxy Tab S8", "Snapdragon 8 Gen 1", "N/A",
                "11 pulgadas, Capacitiva, 128GB, Android"
        });
    }

    private void configurarBotones() {
        btnCerrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }
}