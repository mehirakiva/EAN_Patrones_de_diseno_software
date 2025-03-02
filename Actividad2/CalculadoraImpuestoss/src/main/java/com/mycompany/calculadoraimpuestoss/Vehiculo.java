// Modelo
public class Vehiculo {
    private String marca;
    private String modelo;
    private int anoFabricacion;
    private int cilindraje;
    private double avaluoComercial;  // Cambié "avalúo" por "avaluo" (sin tilde)
    private String tipoUso;

    // Constructor
    public Vehiculo(String marca, String modelo, int anoFabricacion, int cilindraje, double avaluoComercial, String tipoUso) {
        this.marca = marca;
        this.modelo = modelo;
        this.anoFabricacion = anoFabricacion;
        this.cilindraje = cilindraje;
        this.avaluoComercial = avaluoComercial;
        this.tipoUso = tipoUso;
    }

    // Getters
    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public int getAnoFabricacion() {
        return anoFabricacion;
    }

    public int getCilindraje() {
        return cilindraje;
    }

    public double getAvaluoComercial() {
        return avaluoComercial;
    }

    public String getTipoUso() {
        return tipoUso;
    }
}