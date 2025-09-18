package GestionInventario.interfaz;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class InventarioMenu extends JFrame {
    public InventarioMenu() {
        setTitle("TODOPC");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 200);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JLabel lblTitulo = new JLabel("Bienvenido a TODOPC", SwingConstants.CENTER);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 20));
        add(lblTitulo, BorderLayout.NORTH);

        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new GridLayout(3, 1, 10, 10));
        panelBotones.setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 40));

        JButton btnRegistrar = new JButton("Registrar equipo");
        JButton btnVer = new JButton("Ver equipos");
        JButton btnSalir = new JButton("Salir");

        panelBotones.add(btnRegistrar);
        panelBotones.add(btnVer);
        panelBotones.add(btnSalir);
        add(panelBotones, BorderLayout.CENTER);

        // Accion para salir
        btnSalir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        // Accion para registrar equipo
        btnRegistrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                registrarEquipo();
            }
        });

        // Accion para ver equipos
        btnVer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                verEquipos();
            }
        });
    }

    private void registrarEquipo() {
        // Seleccionar tipo de equipo usando JOptionPane
        String[] tiposEquipo = { "Desktop", "Laptop", "Tablet" };
        String tipoSeleccionado = (String) JOptionPane.showInputDialog(
                this,
                "Seleccione el tipo de equipo que desea registrar:",
                "Tipo de Equipo",
                JOptionPane.QUESTION_MESSAGE,
                null,
                tiposEquipo,
                tiposEquipo[0]);

        if (tipoSeleccionado != null) {
            // Mostrar el formulario dinamico para el tipo seleccionado
            RegistrarEquipoDialog dialog = new RegistrarEquipoDialog(this, tipoSeleccionado);
            dialog.setVisible(true);
        }
    }

    private void verEquipos() {
        // Mostrar opciones para ver equipos
        String[] opciones = { "Desktop", "Laptop", "Tablet" };
        String opcionSeleccionada = (String) JOptionPane.showInputDialog(
                this,
                "Seleccione el tipo de equipos que desea ver:",
                "Ver Equipos",
                JOptionPane.QUESTION_MESSAGE,
                null,
                opciones,
                opciones[0]);

        if (opcionSeleccionada != null) {
            // Mostrar la lista de equipos del tipo seleccionado
            ListaEquiposDialog listaDialog = new ListaEquiposDialog(this, opcionSeleccionada);
            listaDialog.setVisible(true);
        }
    }

    public static void main(String[] args) {
        InventarioMenu menuPrincipal = new InventarioMenu();
        menuPrincipal.setVisible(true);
    }
}
