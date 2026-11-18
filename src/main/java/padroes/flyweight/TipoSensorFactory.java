package padroes.flyweight;

import java.util.HashMap;
import java.util.Map;

public class TipoSensorFactory {

    private final Map<String, TipoSensor> tipos = new HashMap<>();

    public TipoSensor getTipoSensor(String modelo, String unidade, String fabricante) {
        String chave = modelo + "|" + unidade + "|" + fabricante;
        TipoSensor tipo = tipos.get(chave);
        if (tipo == null) {
            tipo = new TipoSensor(modelo, unidade, fabricante);
            tipos.put(chave, tipo);
        }
        return tipo;
    }

    public int getTotalTipos() {
        return tipos.size();
    }
}
