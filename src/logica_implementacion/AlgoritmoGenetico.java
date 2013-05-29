package logica_implementacion;

import interfazgrafica.IGCuadroMagico;
import java.awt.Point;
import java.util.HashMap;
import java.util.Map;
import static utilidades.MapKeyConstantes.*;

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
        System.err.println("Numero maximo de generaciones: "
                + parametros.get(MAP_KEY_NUMERO_MAX_GENERACIONES));
        System.err.println("Numero de cromosomas en la poblacion: "
                + parametros.get(MAP_KEY_NUM_CROM_POBLACION));
    }

    /**
     * Aplicaci&oacute;n del algoritmo gen&eacute;tico.
     */
    public void aplicarAlgoritmo() {
        //Algoritmo

        //...

        int matrizCuadroMagico[][] = new int[3][3];
        matrizCuadroMagico[0][0] = 1;
        matrizCuadroMagico[1][1] = 5;
        matrizCuadroMagico[2][2] = 9;

        Map<String, Object> resultados = new HashMap<>();

        resultados.put(MAP_KEY_MATRIZ_CUADRO_MAGICO, matrizCuadroMagico);
        resultados.put(MAP_KEY_LINEAS_QUE_CUMPLEN, new Point[]{new Point(0, 0),
                    new Point(1, 1), new Point(2, 2)});

        ((IGCuadroMagico) parametros.get(MAP_KEY_INTERFAZ_GRAFICA))
                .mostrarResultadosDeAlgoritmoGenetico(resultados);
    }
}