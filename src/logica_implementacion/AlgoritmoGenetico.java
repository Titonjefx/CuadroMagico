package logica_implementacion;

import interfazgrafica.IGCuadroMagico;
import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
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
        Point[] puntosS = obtenerPuntosQueCoinciden(new int[]{1, 2, 3, 2, 8, 2, 3, 2, 1});
        resultados.put(MAP_KEY_LINEAS_QUE_CUMPLEN, puntosS);

        ((IGCuadroMagico) parametros.get(MAP_KEY_INTERFAZ_GRAFICA))
                .mostrarResultadosDeAlgoritmoGenetico(resultados);
    }

    /**
     * Regresa el conjunto de puntos que conforman las listas que cumplen con la
     * condici&acute;n principal de un cuadro m&aacute;gico, y es que cada fila
     * columna y diagonal sumen igual. Este es el m&eacute;todo m&aacute;s
     * costoso del algoritmo, pero solo se ejecuta para mostrar la
     * soluci&oacute;n hallada gr&aacute;ficamente.
     *
     * @param cromosoma cromosoma que representa una soluci&oacute;n
     * @return puntos que cumplen
     */
    public Point[] obtenerPuntosQueCoinciden(int[] cromosoma) {//Cromosoma cromosoma) {
        List<Point> puntos = new ArrayList();

        Map<Integer, List> sumas;
        sumas = new HashMap<>();

        int tamanoDeCuadrado = (int) Math.sqrt(cromosoma.length);
        /*int tamanoDeCuadrado = (int) Math.sqrt(cromosoma.tamano());
         Gen[] genes = cromosoma.getGenes();

         List sumasPorLista = new ArrayList((numeroDeGenes * 2) + 2);
         for (int i = 0; i < numeroDeGenes; i++) {
         for (int j = 0; j < numeroDeGenes; j++) {
         int pos = (i - 1) * numeroDeGenes + j;
         if (i == j) {
         sumasPorLista[(2 * tamanoDeCuadrado)] =
                            (sumasPorLista[(2 * tamanoDeCuadrado)]
                            + ((Integer) genes[pos].getAlelo())
         .intValue());
         }
         if (i == ((numeroDeGenes - 1) - j)) {
         sumasPorLista[(2 * tamanoDeCuadrado) + 1] =
                            (sumasPorLista[(2 * tamanoDeCuadrado)
                            + 1] + ((Integer) genes[pos].getAlelo())
         .intValue());
         }
         sumasPorLista[i] = (sumasPorLista[i] + ((Integer) genes[pos]
                            .getAlelo()).intValue());

         sumasPorLista[tamanoDeCuadrado + j] =
                        (sumasPorLista[tamanoDeCuadrado + j] + ((Integer)
                        genes[pos].getAlelo()).intValue()));
         }
         }*/

        int sumasPorLista[] = new int[((tamanoDeCuadrado * 2) + 2)];

        for (int i = 0; i < tamanoDeCuadrado; i++) {
            for (int j = 0; j < tamanoDeCuadrado; j++) {
                int pos = i * tamanoDeCuadrado + j;
                if (i == j) {
                    sumasPorLista[(2 * tamanoDeCuadrado)] =
                            (sumasPorLista[(2 * tamanoDeCuadrado)]
                            + cromosoma[pos]);
                }
                if (i == ((tamanoDeCuadrado - 1) - j)) {
                    sumasPorLista[(2 * tamanoDeCuadrado) + 1] =
                            (sumasPorLista[(2 * tamanoDeCuadrado)
                            + 1] + cromosoma[pos]);
                }
                sumasPorLista[i] = (sumasPorLista[i] + cromosoma[pos]);

                sumasPorLista[tamanoDeCuadrado + j] =
                        (sumasPorLista[tamanoDeCuadrado + j] + cromosoma[pos]);
            }
        }

        for (int i = 0; i < sumasPorLista.length; i++) {
            if (!sumas.containsKey(sumasPorLista[i])) {
                List lista = new ArrayList();
                lista.add(i);
                sumas.put(sumasPorLista[i], lista);
            } else {
                sumas.get(sumasPorLista[i]).add(i);
            }
        }

        int numeroMayorDeListas = 0;
        int sumaConNumeroMayorDeListas = 0;

        for (Entry<Integer, List> entrada : sumas.entrySet()) {
            if (entrada.getValue().size() > numeroMayorDeListas) {
                numeroMayorDeListas = entrada.getValue().size();
                sumaConNumeroMayorDeListas = entrada.getKey();
            }
        }

        List<Integer> listasQueCumplen = sumas.get(sumaConNumeroMayorDeListas);

        for (Integer listaQueCumple : listasQueCumplen) {
            int idListaQueCumple = listaQueCumple.intValue();
            if (idListaQueCumple < tamanoDeCuadrado) {
                for (int i = 0; i < tamanoDeCuadrado; i++) {
                    puntos.add(new Point(idListaQueCumple, i));
                }
            } else if (idListaQueCumple < (tamanoDeCuadrado * 2)) {
                for (int i = 0; i < tamanoDeCuadrado; i++) {
                    puntos.add(new Point(i, idListaQueCumple
                            - tamanoDeCuadrado));
                }
            } else if (idListaQueCumple == (tamanoDeCuadrado * 2)) {
                for (int i = 0; i < tamanoDeCuadrado; i++) {
                    puntos.add(new Point(i, i));
                }
            } else if (idListaQueCumple == ((tamanoDeCuadrado * 2) + 1)) {
                for (int i = 0; i < tamanoDeCuadrado; i++) {
                    puntos.add(new Point(i, (tamanoDeCuadrado - 1) - i));
                }
            }
        }

        return (Point[]) puntos.toArray(new Point[puntos.size()]);
    }
}