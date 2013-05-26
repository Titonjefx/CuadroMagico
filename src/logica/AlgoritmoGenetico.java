package logica;

import interfazgrafica.IGCuadroMagico;
import java.util.HashMap;
import java.util.Map;
import static utilidades.MapKeyConstantes.MAP_KEY_INTERFAZ_GRAFICA;
import static utilidades.MapKeyConstantes.MAP_KEY_PORCENTAJE_CRUCE;
import static utilidades.MapKeyConstantes.MAP_KEY_PORCENTAJE_MUTACION;

/**
 * Clase donde se realiza el algoritmo gen&eacute;tico.
 *
 * @author Jhonderson
 */
public class AlgoritmoGenetico {

    /**
     * Parametros de configuraci&oacute;n del algoritmo gen&eacute;tico.
     */
    private Map<String, Object> parametros;

    /**
     * Constructor.
     */
    public AlgoritmoGenetico() {
    }

    /**
     * Establece los par&aacute;metros del algoritmo gen&eacute;tico.
     *
     * @param parametros par&aacute;metros del algoritmo gen&eacute;tico
     */
    public void setParametrosDeAlgoritmoGenetico(
            Map<String, Object> parametros) {
        this.parametros = parametros;
        System.err.println("Porcentaje de cruce: "
                + parametros.get(MAP_KEY_PORCENTAJE_CRUCE));
        System.err.println("Porcentaje de mutacion: "
                + parametros.get(MAP_KEY_PORCENTAJE_MUTACION));
    }

    /**
     * Aplicaci&oacute;n del algoritmo gen&eacute;tico.
     */
    public void aplicarAlgoritmo() {
        //Algoritmo

        //...

        Map<String, Object> resultados = new HashMap<>();
        ((IGCuadroMagico) parametros.get(MAP_KEY_INTERFAZ_GRAFICA))
                .mostrarResultadosDeAlgoritmoGenetico(resultados);
    }
}
