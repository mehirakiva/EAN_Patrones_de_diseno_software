// Clase CalculadoraImpuestos (Lógica de negocio)
public class CalculadoraImpuestos {
    public double calcularImpuesto(Vehiculo vehiculo) {
        double impuesto = 0.0;
        int edadVehiculo = 2025 - vehiculo.getAnoFabricacion(); // Suponiendo que el año actual es 2025
        double tasaBase = 0.01 * vehiculo.getAvaluoComercial();

        // Lógica de cálculo de impuestos dependiendo de la antigüedad y el cilindraje
        if (edadVehiculo < 5) {
            impuesto = tasaBase * 1.2;  // Vehículos nuevos tienen un pequeño incremento
        } else {
            impuesto = tasaBase;
        }

        if (vehiculo.getCilindraje() > 2000) {
            impuesto *= 1.3;  // Los vehículos con cilindraje mayor a 2000 tienen un recargo
        }

        // Tipo de uso (público tiene un recargo extra)
        if ("publico".equalsIgnoreCase(vehiculo.getTipoUso())) {
            impuesto *= 1.5;
        }

        return impuesto;
    }
}
