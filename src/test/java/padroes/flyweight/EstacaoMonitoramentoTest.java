package padroes.flyweight;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertSame;

class EstacaoMonitoramentoTest {

    @Test
    void deveCompartilharTipoEntreSensoresIguais() {
        EstacaoMonitoramento estacao = new EstacaoMonitoramento();

        Sensor a = estacao.instalar("Sala 1", 22.5, "TX-100", "°C", "Termotec");
        Sensor b = estacao.instalar("Sala 2", 24.0, "TX-100", "°C", "Termotec");

        assertSame(a.getTipo(), b.getTipo());
        assertEquals(2, estacao.getTotalSensores());
        assertEquals(1, estacao.getTotalTipos());
    }

    @Test
    void deveCriarTiposDistintosParaModelosDiferentes() {
        EstacaoMonitoramento estacao = new EstacaoMonitoramento();

        Sensor temperatura = estacao.instalar("Sala 1", 22.5, "TX-100", "°C", "Termotec");
        Sensor umidade = estacao.instalar("Sala 1", 55.0, "UM-200", "%", "Higrotec");
        estacao.instalar("Sala 2", 23.0, "TX-100", "°C", "Termotec");
        estacao.instalar("Sala 2", 60.0, "UM-200", "%", "Higrotec");

        assertNotSame(temperatura.getTipo(), umidade.getTipo());
        assertEquals(4, estacao.getTotalSensores());
        assertEquals(2, estacao.getTotalTipos());
    }

    @Test
    void deveManterEstadoExtrinsecoIndependente() {
        EstacaoMonitoramento estacao = new EstacaoMonitoramento();
        estacao.instalar("Sala 1", 22.5, "TX-100", "°C", "Termotec");
        estacao.instalar("Sala 2", 24.0, "TX-100", "°C", "Termotec");

        assertEquals(List.of(
                "Sala 1 - TX-100 (Termotec): 22.5 °C",
                "Sala 2 - TX-100 (Termotec): 24.0 °C"), estacao.gerarRelatorio());
    }

    @Test
    void deveDiferenciarTiposPorFabricante() {
        TipoSensorFactory fabrica = new TipoSensorFactory();

        TipoSensor a = fabrica.getTipoSensor("TX-100", "°C", "Termotec");
        TipoSensor b = fabrica.getTipoSensor("TX-100", "°C", "Outra");

        assertNotSame(a, b);
        assertEquals(2, fabrica.getTotalTipos());
    }
}
