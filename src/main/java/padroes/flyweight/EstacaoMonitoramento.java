package padroes.flyweight;

import java.util.ArrayList;
import java.util.List;

public class EstacaoMonitoramento {

    private final TipoSensorFactory fabrica = new TipoSensorFactory();
    private final List<Sensor> sensores = new ArrayList<>();

    public Sensor instalar(String local, double leitura, String modelo, String unidade, String fabricante) {
        TipoSensor tipo = fabrica.getTipoSensor(modelo, unidade, fabricante);
        Sensor sensor = new Sensor(local, leitura, tipo);
        sensores.add(sensor);
        return sensor;
    }

    public List<String> gerarRelatorio() {
        List<String> relatorio = new ArrayList<>();
        for (Sensor sensor : sensores) {
            relatorio.add(sensor.descrever());
        }
        return relatorio;
    }

    public int getTotalSensores() {
        return sensores.size();
    }

    public int getTotalTipos() {
        return fabrica.getTotalTipos();
    }
}
