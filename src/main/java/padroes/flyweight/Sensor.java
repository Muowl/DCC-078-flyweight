package padroes.flyweight;

public class Sensor {

    private final String local;
    private final double leitura;
    private final TipoSensor tipo;

    public Sensor(String local, double leitura, TipoSensor tipo) {
        this.local = local;
        this.leitura = leitura;
        this.tipo = tipo;
    }

    public TipoSensor getTipo() {
        return tipo;
    }

    public String descrever() {
        return local + " - " + tipo.formatarLeitura(leitura);
    }
}
