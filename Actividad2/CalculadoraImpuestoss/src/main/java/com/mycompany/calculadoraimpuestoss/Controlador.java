import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Controlador (Lógica de interacción entre Vista y Modelo)
public class Controlador implements ActionListener {
    private Vista vista;
    private CalculadoraImpuestos calculadora;

    public Controlador(Vista vista) {
        this.vista = vista;
        this.calculadora = new CalculadoraImpuestos();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.getBtnCalcular()) {
            // Recoger los datos de la vista
            String marca = vista.getMarca();
            String modelo = vista.getModelo();
            int anoFabricacion = vista.getAnoFabricacion();
            int cilindraje = vista.getCilindraje();
            double avaluoComercial = vista.getAvaluoComercial();
            String tipoUso = vista.getTipoUso();

            // Si algún dato es incorrecto (por ejemplo, número negativo), no continuar con el cálculo
            if (anoFabricacion == -1 || cilindraje == -1 || avaluoComercial == -1) {
                return;
            }

            // Crear el objeto Vehiculo
            Vehiculo vehiculo = new Vehiculo(marca, modelo, anoFabricacion, cilindraje, avaluoComercial, tipoUso);

            // Calcular el impuesto
            double impuesto = calculadora.calcularImpuesto(vehiculo);

            // Mostrar el resultado en la vista
            vista.setResultado(impuesto);
        }
    }
}
