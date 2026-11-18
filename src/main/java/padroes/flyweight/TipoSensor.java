package padroes.flyweight;

public class TipoSensor {

    private final String modelo;
    private final String unidade;
    private final String fabricante;

    public TipoSensor(String modelo, String unidade, String fabricante) {
        this.modelo = modelo;
        this.unidade = unidade;
        this.fabricante = fabricante;
    }

    public String getModelo() {
        return modelo;
    }

    public String getUnidade() {
        return unidade;
    }

    public String getFabricante() {
        return fabricante;
    }

    public String formatarLeitura(double valor) {
        return modelo + " (" + fabricante + "): " + valor + " " + unidade;
    }
}
