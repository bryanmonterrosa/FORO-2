package GestionInventario.interfaz;

import GestionInventario.Inventario;
import HijasClass.Desktop;
import HijasClass.Laptop;
import HijasClass.Tablet;
import PadresClass.Equipo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class RegistrarEquipoDialog extends JDialog {
    private String tipoEquipo;
    private JPanel panelCampos;
    private JButton btnRegistrar;
    private JButton btnCancelar;
    private Map<String, JTextField> campos;
    private Inventario inventario;

    public RegistrarEquipoDialog(JFrame parent, String tipoEquipo, Inventario inventario) {
        super(parent, "Registrar " + tipoEquipo, true);
        this.tipoEquipo = tipoEquipo;
        this.campos = new HashMap<String, JTextField>();
        this.inventario = inventario;
        
        setSize(500, 400);
        setLocationRelativeTo(parent);
        setLayout(new BorderLayout());

        setup();
        crearCamposDeFormulario();
        configurarBotonesDeFormulario();
    }
    
    private void setup() {
        JLabel lblTitulo = new JLabel("Registrar " + tipoEquipo, SwingConstants.CENTER);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 18));
        lblTitulo.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
        add(lblTitulo, BorderLayout.NORTH);

        panelCampos = new JPanel();
        panelCampos.setBorder(BorderFactory.createTitledBorder("Informacion del " + tipoEquipo));
        
        JScrollPane scrollPane = new JScrollPane(panelCampos);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        add(scrollPane, BorderLayout.CENTER);

        // Botones
        JPanel panelBotones = new JPanel(new FlowLayout());
        btnRegistrar = new JButton("Registrar");
        btnCancelar = new JButton("Cancelar");
        panelBotones.add(btnRegistrar);
        panelBotones.add(btnCancelar);
        add(panelBotones, BorderLayout.SOUTH);
    }
    
    private void crearCamposDeFormulario() {
        panelCampos.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        switch (tipoEquipo) {
            case "Desktop":
                panelCampos.setLayout(new GridLayout(7, 2, 5, 5));
                
                // Fabricante
                JLabel lblFabricante = new JLabel("Fabricante:");
                JTextField txtFabricante = new JTextField(20);
                panelCampos.add(lblFabricante);
                panelCampos.add(txtFabricante);
                campos.put("Fabricante", txtFabricante);
                
                // Modelo
                JLabel lblModelo = new JLabel("Modelo:");
                JTextField txtModelo = new JTextField(20);
                panelCampos.add(lblModelo);
                panelCampos.add(txtModelo);
                campos.put("Modelo", txtModelo);
                
                // Microprocesador
                JLabel lblMicroprocesador = new JLabel("Microprocesador:");
                JTextField txtMicroprocesador = new JTextField(20);
                panelCampos.add(lblMicroprocesador);
                panelCampos.add(txtMicroprocesador);
                campos.put("Microprocesador", txtMicroprocesador);
                
                // Memoria
                JLabel lblMemoria = new JLabel("Memoria:");
                JTextField txtMemoria = new JTextField(20);
                panelCampos.add(lblMemoria);
                panelCampos.add(txtMemoria);
                campos.put("Memoria", txtMemoria);
                
                // Tarjeta grafica
                JLabel lblTarjetaGrafica = new JLabel("Tarjeta grafica:");
                JTextField txtTarjetaGrafica = new JTextField(20);
                panelCampos.add(lblTarjetaGrafica);
                panelCampos.add(txtTarjetaGrafica);
                campos.put("Tarjeta grafica", txtTarjetaGrafica);
                
                // Tamaño de torre
                JLabel lblTamanoTorre = new JLabel("Tamaño de torre:");
                JTextField txtTamanoTorre = new JTextField(20);
                panelCampos.add(lblTamanoTorre);
                panelCampos.add(txtTamanoTorre);
                campos.put("Tamaño de torre", txtTamanoTorre);
                
                // Capacidad de disco duro
                JLabel lblCapacidadDisco = new JLabel("Capacidad de disco duro:");
                JTextField txtCapacidadDisco = new JTextField(20);
                panelCampos.add(lblCapacidadDisco);
                panelCampos.add(txtCapacidadDisco);
                campos.put("Capacidad de disco duro", txtCapacidadDisco);
                break;
                
            case "Laptop":
                panelCampos.setLayout(new GridLayout(6, 2, 5, 5));
                
                // Fabricante
                JLabel lblFabricanteLaptop = new JLabel("Fabricante:");
                JTextField txtFabricanteLaptop = new JTextField(20);
                panelCampos.add(lblFabricanteLaptop);
                panelCampos.add(txtFabricanteLaptop);
                campos.put("Fabricante", txtFabricanteLaptop);
                
                // Modelo
                JLabel lblModeloLaptop = new JLabel("Modelo:");
                JTextField txtModeloLaptop = new JTextField(20);
                panelCampos.add(lblModeloLaptop);
                panelCampos.add(txtModeloLaptop);
                campos.put("Modelo", txtModeloLaptop);
                
                // Microprocesador
                JLabel lblMicroprocesadorLaptop = new JLabel("Microprocesador:");
                JTextField txtMicroprocesadorLaptop = new JTextField(20);
                panelCampos.add(lblMicroprocesadorLaptop);
                panelCampos.add(txtMicroprocesadorLaptop);
                campos.put("Microprocesador", txtMicroprocesadorLaptop);
                
                // Memoria
                JLabel lblMemoriaLaptop = new JLabel("Memoria:");
                JTextField txtMemoriaLaptop = new JTextField(20);
                panelCampos.add(lblMemoriaLaptop);
                panelCampos.add(txtMemoriaLaptop);
                campos.put("Memoria", txtMemoriaLaptop);
                
                // Tamaño pantalla
                JLabel lblTamanoPantalla = new JLabel("Tamaño pantalla:");
                JTextField txtTamanoPantalla = new JTextField(20);
                panelCampos.add(lblTamanoPantalla);
                panelCampos.add(txtTamanoPantalla);
                campos.put("Tamaño pantalla", txtTamanoPantalla);
                
                // Capacidad de disco duro
                JLabel lblCapacidadDiscoLaptop = new JLabel("Capacidad de disco duro:");
                JTextField txtCapacidadDiscoLaptop = new JTextField(20);
                panelCampos.add(lblCapacidadDiscoLaptop);
                panelCampos.add(txtCapacidadDiscoLaptop);
                campos.put("Capacidad de disco duro", txtCapacidadDiscoLaptop);
                break;
                
            case "Tablet":
                panelCampos.setLayout(new GridLayout(7, 2, 5, 5));
                
                // Fabricante
                JLabel lblFabricanteTablet = new JLabel("Fabricante:");
                JTextField txtFabricanteTablet = new JTextField(20);
                panelCampos.add(lblFabricanteTablet);
                panelCampos.add(txtFabricanteTablet);
                campos.put("Fabricante", txtFabricanteTablet);
                
                // Modelo
                JLabel lblModeloTablet = new JLabel("Modelo:");
                JTextField txtModeloTablet = new JTextField(20);
                panelCampos.add(lblModeloTablet);
                panelCampos.add(txtModeloTablet);
                campos.put("Modelo", txtModeloTablet);
                
                // Microprocesador
                JLabel lblMicroprocesadorTablet = new JLabel("Microprocesador:");
                JTextField txtMicroprocesadorTablet = new JTextField(20);
                panelCampos.add(lblMicroprocesadorTablet);
                panelCampos.add(txtMicroprocesadorTablet);
                campos.put("Microprocesador", txtMicroprocesadorTablet);
                
                // Tamano diagonal de pantalla
                JLabel lblTamanoDiagonal = new JLabel("Tamano diagonal de pantalla:");
                JTextField txtTamanoDiagonal = new JTextField(20);
                panelCampos.add(lblTamanoDiagonal);
                panelCampos.add(txtTamanoDiagonal);
                campos.put("Tamano diagonal de pantalla", txtTamanoDiagonal);
                
                // Capacitiva/Resistiva
                JLabel lblCapacitiva = new JLabel("Capacitiva/Resistiva:");
                JTextField txtCapacitiva = new JTextField(20);
                panelCampos.add(lblCapacitiva);
                panelCampos.add(txtCapacitiva);
                campos.put("Capacitiva/Resistiva", txtCapacitiva);
                
                // Tamaño memoria NAND
                JLabel lblMemoriaNAND = new JLabel("Tamaño memoria NAND:");
                JTextField txtMemoriaNAND = new JTextField(20);
                panelCampos.add(lblMemoriaNAND);
                panelCampos.add(txtMemoriaNAND);
                campos.put("Tamaño memoria NAND", txtMemoriaNAND);
                
                // Sistema Operativo
                JLabel lblSistemaOperativo = new JLabel("Sistema Operativo:");
                JTextField txtSistemaOperativo = new JTextField(20);
                panelCampos.add(lblSistemaOperativo);
                panelCampos.add(txtSistemaOperativo);
                campos.put("Sistema Operativo", txtSistemaOperativo);
                break;
                
            default:
                // No hacer nada si el tipo no es reconocido
                break;
        }
    }
    
    private void configurarBotonesDeFormulario() {
        btnCancelar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        
        btnRegistrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                registrarEquipo();
            }
        });
    }
    
    private void registrarEquipo() {
        // Validar que todos los campos esten llenos
        for (Map.Entry<String, JTextField> entry : campos.entrySet()) {
            if (entry.getValue().getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(this,
                    "Por favor complete el campo: " + entry.getKey(),
                    "Campo requerido",
                    JOptionPane.WARNING_MESSAGE);
                entry.getValue().requestFocus();
                return;
            }
        }


        StringBuilder mensaje = new StringBuilder();
        mensaje.append("Equipo registrado exitosamente:\n\n");
        mensaje.append("Tipo: ").append(tipoEquipo).append("\n");
        
        for (Map.Entry<String, JTextField> entry : campos.entrySet()) {
            mensaje.append(entry.getKey()).append(": ").append(entry.getValue().getText()).append("\n");
        }
        
        JOptionPane.showMessageDialog(this, mensaje.toString(), "Equipo Registrado", JOptionPane.INFORMATION_MESSAGE);
        Equipo equipo=null;
        switch (tipoEquipo) {
            case "Desktop":
                equipo = new Desktop(
                        campos.get("Fabricante").getText(),
                        campos.get("Modelo").getText(),
                        campos.get("Microprocesador").getText(),
                        campos.get("Memoria").getText(),
                        campos.get("Tarjeta grafica").getText(),
                        campos.get("Tamaño de torre").getText(),
                        campos.get("Capacidad de disco duro").getText());

                break;

            case "Laptop":
                equipo = new Laptop(
                        campos.get("Fabricante").getText(),
                        campos.get("Modelo").getText(),
                        campos.get("Microprocesador").getText(),
                        campos.get("Memoria").getText(),
                        campos.get("Tamaño pantalla").getText(),
                        campos.get("Capacidad de disco duro").getText());

                break;

            case "Tablet":
                equipo = new Tablet(
                        campos.get("Fabricante").getText(),
                        campos.get("Modelo").getText(),
                        campos.get("Microprocesador").getText(),
                        campos.get("Tamano diagonal de pantalla").getText(),
                        campos.get("Capacitiva/Resistiva").getText(),
                        campos.get("Tamaño memoria NAND").getText(),
                        campos.get("Sistema Operativo").getText());

                break;
        }
        inventario.agregarEquipo(equipo);
        dispose();
    }
}
