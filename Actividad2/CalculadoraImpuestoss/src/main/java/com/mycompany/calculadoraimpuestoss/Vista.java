import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;
import java.awt.Color;

// Esta es la nueva vista mejorada con un diseño más elegante
public class Vista extends JFrame {
    private JTextField txtMarca, txtModelo, txtAnoFabricacion, txtCilindraje, txtAvaluoComercial, txtTipoUso;
    private JButton btnCalcular;
    private JLabel lblResultado;
    private Controlador controlador;

    public Vista() {
        setTitle("Universidad EAN");
        setSize(500, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        // Establecer color de fondo de la ventana
        getContentPane().setBackground(new Color(242, 242, 242));  // Color suave para el fondo

        // Crear un panel principal con borde
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(9, 2, 10, 10));
        mainPanel.setBackground(new Color(242, 242, 242));  // Fondo suave del panel
        mainPanel.setBorder(new EmptyBorder(20, 20, 20, 20)); // Agregar margen al panel

        // Título con fuente elegante
        JLabel titleLabel = new JLabel("Cálculo de Impuestos de un Vehículo", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        titleLabel.setForeground(new Color(28, 40, 51));  // Azul oscuro elegante
        titleLabel.setBorder(BorderFactory.createEmptyBorder(10, 0, 20, 0));
        add(titleLabel, BorderLayout.NORTH);

        // Componentes de la interfaz
        addComponent(mainPanel);

        // Botón Calcular
        btnCalcular = new JButton("Calcular");
        btnCalcular.setBackground(new Color(48, 87, 144));  // Azul elegante
        btnCalcular.setForeground(Color.WHITE);
        btnCalcular.setFont(new Font("Arial", Font.BOLD, 14));
        btnCalcular.setFocusPainted(false);
        btnCalcular.setBorder(BorderFactory.createLineBorder(new Color(28, 40, 51), 2));
        btnCalcular.setPreferredSize(new Dimension(150, 40));
        btnCalcular.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnCalcular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controlador.actionPerformed(e);
            }
        });

        // Resultado
        lblResultado = new JLabel("Impuesto: 0.0", JLabel.CENTER);
        lblResultado.setFont(new Font("Arial", Font.BOLD, 16));
        lblResultado.setForeground(new Color(255, 51, 51));
        lblResultado.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));
        mainPanel.add(lblResultado);

        // Agregar el panel principal
        add(mainPanel, BorderLayout.CENTER);

        // Añadir el botón al sur
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(new Color(242, 242, 242));
        buttonPanel.add(btnCalcular);
        add(buttonPanel, BorderLayout.SOUTH);

        // Controlador
        controlador = new Controlador(this);

        // Centrar ventana
        setLocationRelativeTo(null);
    }

    // Métodos para agregar componentes con borde a la interfaz
    private void addComponent(JPanel panel) {
        // Marca
        addLabeledComponent(panel, "Marca:", txtMarca = createTextField());

        // Modelo
        addLabeledComponent(panel, "Modelo:", txtModelo = createTextField());

        // Año de fabricación
        addLabeledComponent(panel, "Año de fabricación:", txtAnoFabricacion = createTextField());

        // Cilindraje
        addLabeledComponent(panel, "Cilindraje:", txtCilindraje = createTextField());

        // Avalúo comercial
        addLabeledComponent(panel, "Avalúo comercial:", txtAvaluoComercial = createTextField());

        // Tipo de uso
        addLabeledComponent(panel, "Tipo de uso (particular o público):", txtTipoUso = createTextField());
    }

    // Métodos para crear campos de texto con bordes y efectos
    private JTextField createTextField() {
        JTextField textField = new JTextField();
        textField.setFont(new Font("Arial", Font.PLAIN, 14));
        textField.setBorder(BorderFactory.createLineBorder(new Color(28, 40, 51), 2));
        textField.setBackground(Color.WHITE);
        textField.setPreferredSize(new Dimension(200, 30));
        return textField;
    }

    // Método para agregar una etiqueta y un campo de texto en el panel
    private void addLabeledComponent(JPanel panel, String labelText, JTextField textField) {
        JLabel label = new JLabel(labelText);
        label.setFont(new Font("Arial", Font.BOLD, 14));
        label.setForeground(new Color(28, 40, 51));  // Azul elegante para las etiquetas
        panel.add(label);
        panel.add(textField);
    }

    // Métodos para obtener datos de la vista
    public String getMarca() {
        return txtMarca.getText();
    }

    public String getModelo() {
        return txtModelo.getText();
    }

    public int getAnoFabricacion() {
        try {
            return Integer.parseInt(txtAnoFabricacion.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Año de fabricación debe ser un número.");
            return -1; // Valor de error
        }
    }

    public int getCilindraje() {
        try {
            return Integer.parseInt(txtCilindraje.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Cilindraje debe ser un número.");
            return -1; // Valor de error
        }
    }

    public double getAvaluoComercial() {
        try {
            return Double.parseDouble(txtAvaluoComercial.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Avalúo comercial debe ser un número.");
            return -1.0; // Valor de error
        }
    }

    public String getTipoUso() {
        return txtTipoUso.getText();
    }

    // Método para mostrar el resultado
    public void setResultado(double impuesto) {
        lblResultado.setText("Impuesto: " + impuesto);
    }

    public JButton getBtnCalcular() {
        return btnCalcular;
    }
}
