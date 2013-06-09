package logica_implementacion;

import interfazgrafica.IGCuadroMagico;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import logica.Cromosoma;
import logica.FuncionDeAptitud;
import logica.FuncionDeEvaluacion;
import logica.Gen;
import logica.OperadorGenetico;
import logica.Reproductor;
import logica.SelectorNatural;
import static utilidades.MapKeyConstantes.*;

/**
 * Clase donde se realiza el algoritmo gen&eacute;tico.
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

        /**
         * TODO. Imprimimos los parametros del algoritmo -- (Borrar)
         */
        System.err.println("Porcentaje de cruce: "
                + parametros.get(MAP_KEY_PORCENTAJE_CRUCE));
        System.err.println("Porcentaje de mutacion: "
                + parametros.get(MAP_KEY_PORCENTAJE_MUTACION));
        System.err.println("Numero maximo de generaciones: "
                + parametros.get(MAP_KEY_NUMERO_MAX_GENERACIONES));
        System.err.println("Numero de cromosomas en la poblacion: "
                + parametros.get(MAP_KEY_NUM_CROM_POBLACION));
        System.err.println("¿Es el algoritmo combinatorio?: "
                + (((boolean) parametros.get(MAP_KEY_ALGORITMO_COMBINATORIO))
                ? "Si" : "No"));
        System.err.println("Tamano del Cuadrado Magico: "
                + ((IGCuadroMagico) parametros.get(MAP_KEY_INTERFAZ_GRAFICA))
                .getTamanoDeCuadroMagico());
        /**
         * -- (Borrar)
         */
    }

    /**
     * Aplicaci&oacute;n del algoritmo gen&eacute;tico.
     */
    public void aplicarAlgoritmo() {

        //Algoritmo

        //Se crean las variables con valores a partir de los parametros
        //recibidos para el algoritmo genetico.
        double porcentajeDeCruce = (double) parametros.get(
                MAP_KEY_PORCENTAJE_CRUCE);
        double porcentajeDeMutacion = (double) parametros.get(
                MAP_KEY_PORCENTAJE_MUTACION);
        int numMaxGeneraciones = (int) parametros.get(
                MAP_KEY_NUMERO_MAX_GENERACIONES);
        int numCromPoblacion = (int) parametros.get(
                MAP_KEY_NUM_CROM_POBLACION);
        boolean esAlgCombinatorio = (boolean) parametros.get(
                MAP_KEY_ALGORITMO_COMBINATORIO);
        int tamanoCuadroMagico = ((IGCuadroMagico) parametros.get(
                MAP_KEY_INTERFAZ_GRAFICA)).getTamanoDeCuadroMagico();
        int numeroDeGenesPorCromosoma = tamanoCuadroMagico * tamanoCuadroMagico;

        //Cromosoma a partir del cual se crearan los demas cromosomas de la
        //poblacion.
        Cromosoma cromosomaInicial = new CromosomaImpl(
                numeroDeGenesPorCromosoma);

        //Se crea una lista de numeros desde 1 hasta numeroDeGenesPorCromosoma
        List numerosAleatorios = new ArrayList();
        for (int i = 1; i <= numeroDeGenesPorCromosoma; i++) {
            numerosAleatorios.add(i);
        }

        //Se ordena esta lista aleatoriamente. permutacion aleatoria.
        Collections.shuffle(numerosAleatorios);

        //Se crea cada gen a partir de los valores de esta lista y se agrega
        //al cromosomaInicial.
        for (int i = 0; i < numeroDeGenesPorCromosoma; i++) {
            Gen genEntero = new GenEntero(1, numeroDeGenesPorCromosoma);
            genEntero.setAlelo((int) numerosAleatorios.get(i));
            cromosomaInicial.setGen(i, genEntero);
        }

        //Clase donde se almacenaran los recursos necesarios para que el
        //algoritmo genetico funcione.
        Recursos recursosDeAlgoritmoGenetico = new Recursos();

        //Se establece el tamano de la poblacion del algoritmo genetico.
        recursosDeAlgoritmoGenetico.setTamanoDeLaPoblacion(numCromPoblacion);

        //Se establece el porcentaje de mutacion del algoritmo genetico.
        recursosDeAlgoritmoGenetico.setPorcentajeDeMutacion(
                porcentajeDeMutacion);

        //Se establece el porcentaje de cruce del algoritmo genetico.
        recursosDeAlgoritmoGenetico.setPorcentajeDeCruce(porcentajeDeCruce);

        //Se establece el numero de cromosomas que seran seleccionados para la
        //reproduccion.
        recursosDeAlgoritmoGenetico.setNumeroDeCromosomasAReproducir(
                (int) porcentajeDeCruce * numCromPoblacion);

        //Se establece un cromosoma a partir del cual se crearan los demas
        //cromosomas de la poblacion. Contiene genes cuyos alelos son numeros
        //aleatorios desde 1 hasta numeroDeGenesPorCromosoma; Cada gen con un
        //alelo diferente a los demas.
        recursosDeAlgoritmoGenetico.setCromosomaDeMuestra(cromosomaInicial);

        //Se agrega el selector natural usado para seleccionar los cromosomas
        //que se reproduciran.
        SelectorNatural selectorNatural = new Selector(
                recursosDeAlgoritmoGenetico);
        recursosDeAlgoritmoGenetico.agregarSelectorNatural(selectorNatural);

        //Se establece la clase encargada de la reproduccion y en general del
        //la logica de un algoritmo genetico.
        Reproductor reproductor = new ReproductorImpl();
        recursosDeAlgoritmoGenetico.setReproductor(reproductor);

        //Se establece la clase deonde se guardaran los cromosomas elegidos para
        //la reproduccion
        recursosDeAlgoritmoGenetico.setPiscinaDeCromosomas(
                new PiscinaDeCromosomas());

        //Se establece la funcion de evaluacion usada para saber que cromosoma
        //es mejor que otro dependiendo de su aptitud.
        FuncionDeEvaluacion funcionDeEvaluacion = new FuncionDeEvaluacionImpl();
        recursosDeAlgoritmoGenetico.setFuncionDeEvaluacion(funcionDeEvaluacion);

        FuncionDeAptitud funcionDeAptitud;
        OperadorGenetico operadorDeCruce;
        OperadorGenetico operadorDeMutacion;

        if (esAlgCombinatorio) {
            //Si el algoritmo es combinatorio, entonces la solucion dependera de
            //las permutaciones realizadas en un cromosoma entre sus genes.

            funcionDeAptitud = new FuncionDeAptitudCombinatoria();
            operadorDeCruce = new OperadorDeCruceCombinatorio();
            operadorDeMutacion = new OperadorDeMutacionCombinatorio();
        } else {
            //Si el algoritmo es ingenuo (no combinatorio), entonces la solucion
            //dependera de los cambios realizados a cada uno de los genes de un
            //cromosoma (sin permutarlos).

            funcionDeAptitud = new FuncionDeAptitudIngenua();
            operadorDeCruce = new OperadorDeCruceIngenuo();
            operadorDeMutacion = new OperadorDeMutacionIngenuo();
        }

        //Se establece la funcion de aptitud que calcula la aptitud de cada
        //cromosoma.
        recursosDeAlgoritmoGenetico.setFuncionDeAptitud(funcionDeAptitud);

        //Se agregan los operadores geneticos de mutacion y de cruce.
        recursosDeAlgoritmoGenetico.agregarOperadorGenetico(operadorDeCruce);
        recursosDeAlgoritmoGenetico.agregarOperadorGenetico(operadorDeMutacion);



        //...

        //FIN Algoritmo

        Cromosoma cromCandtSol;

        /**
         * TODO.
         *
         * BORRAR (Solucion simulada para pruebas).
         */
        int sol[] = {1, 2, 3, 2, 2, 2, 3, 2, 1};

        cromCandtSol = new CromosomaImpl(numeroDeGenesPorCromosoma);
        for (int i = 0; i < numeroDeGenesPorCromosoma; i++) {
            Gen genEntero = new GenEntero(1, numeroDeGenesPorCromosoma);
            genEntero.setAlelo(sol[i]);
            cromCandtSol.setGen(i, genEntero);
        }
        /**
         * FIN BORRAR
         */
        int matrizPosibleSolucionCuadroMagico[][] =
                new int[tamanoCuadroMagico][tamanoCuadroMagico];

        //Se representan los alelos del cromosoma candidato a ser solucion
        //del cuadro magico en una matriz.
        for (int pos = 0; pos < numeroDeGenesPorCromosoma; pos++) {
            int i = (int) Math.floor(pos / tamanoCuadroMagico);
            int j = pos % tamanoCuadroMagico;
            matrizPosibleSolucionCuadroMagico[i][j] = (int) cromCandtSol
                    .getGen(pos).getAlelo();
        }

        //Objeto donde se envian los resultados del algoritmo mediante un mapeo.
        Map<String, Object> resultados = new HashMap<>();

        resultados.put(MAP_KEY_MATRIZ_CUADRO_MAGICO,
                matrizPosibleSolucionCuadroMagico);

        Point[] puntosQueCumplenConSuma = obtenerPuntosQueCoinciden(
                cromCandtSol);
        resultados.put(MAP_KEY_LINEAS_QUE_CUMPLEN, puntosQueCumplenConSuma);

        ((IGCuadroMagico) parametros.get(MAP_KEY_INTERFAZ_GRAFICA))
                .mostrarResultadosDeAlgoritmoGenetico(resultados);
    }

    /**
     * Regresa el conjunto de puntos que conforman las listas que cumplen con la
     * condici&acute;n principal de un cuadro m&aacute;gico, y es que cada fila,
     * columna y diagonal sumen igual. Este es el m&eacute;todo m&aacute;s
     * costoso del algoritmo, pero solo se ejecuta para mostrar la
     * soluci&oacute;n hallada gr&aacute;ficamente.
     *
     * @param cromosoma cromosoma que representa una soluci&oacute;n
     * @return puntos que cumplen
     */
    public Point[] obtenerPuntosQueCoinciden(Cromosoma cromosoma) {
        List<Point> puntos = new ArrayList();

        Map<Integer, List> sumas;
        sumas = new HashMap<>();

        int tamanoDeCuadrado = (int) Math.sqrt(cromosoma.tamano());
        Gen[] genes = cromosoma.getGenes();

        int sumasPorLista[] = new int[((tamanoDeCuadrado * 2) + 2)];

        for (int i = 0; i < tamanoDeCuadrado; i++) {
            for (int j = 0; j < tamanoDeCuadrado; j++) {
                int pos = i * tamanoDeCuadrado + j;
                if (i == j) {
                    sumasPorLista[(2 * tamanoDeCuadrado)] =
                            (sumasPorLista[(2 * tamanoDeCuadrado)]
                            + ((Integer) genes[pos].getAlelo())
                            .intValue());
                }
                if (i == ((tamanoDeCuadrado - 1) - j)) {
                    sumasPorLista[(2 * tamanoDeCuadrado) + 1] =
                            (sumasPorLista[(2 * tamanoDeCuadrado)
                            + 1] + ((Integer) genes[pos].getAlelo())
                            .intValue());
                }
                sumasPorLista[i] = (sumasPorLista[i] + ((Integer) genes[pos]
                        .getAlelo()).intValue());

                sumasPorLista[tamanoDeCuadrado + j] =
                        (sumasPorLista[tamanoDeCuadrado + j]
                        + ((Integer) genes[pos].getAlelo()).intValue());
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

        int numeroMayorDeElementos = 0;
        int sumaConNumeroMayorDeElementos = 0;

        for (Entry<Integer, List> entrada : sumas.entrySet()) {
            if (entrada.getValue().size() > numeroMayorDeElementos) {
                numeroMayorDeElementos = entrada.getValue().size();
                sumaConNumeroMayorDeElementos = entrada.getKey();
            }
        }

        List<Integer> listasQueCumplen = sumas.get(
                sumaConNumeroMayorDeElementos);

        for (Integer listaQueCumple : listasQueCumplen) {
            int idListaQueCumple = listaQueCumple.intValue();

            if (idListaQueCumple < tamanoDeCuadrado) {
                //Si la suma corresponde a alguna fila

                for (int i = 0; i < tamanoDeCuadrado; i++) {
                    puntos.add(new Point(idListaQueCumple, i));
                }
            } else if (idListaQueCumple < (tamanoDeCuadrado * 2)) {
                //Si la suma corresponde a alguna columna

                for (int i = 0; i < tamanoDeCuadrado; i++) {
                    puntos.add(new Point(i, idListaQueCumple
                            - tamanoDeCuadrado));
                }
            } else if (idListaQueCumple == (tamanoDeCuadrado * 2)) {
                //Si la suma corresponde a la diagonal noroeste-sureste

                for (int i = 0; i < tamanoDeCuadrado; i++) {
                    puntos.add(new Point(i, i));
                }
            } else if (idListaQueCumple == ((tamanoDeCuadrado * 2) + 1)) {
                //Si la suma corresponde a la diagonal suroeste-noreste

                for (int i = 0; i < tamanoDeCuadrado; i++) {
                    puntos.add(new Point(i, (tamanoDeCuadrado - 1) - i));
                }
            }
        }

        return (Point[]) puntos.toArray(new Point[puntos.size()]);
    }
}