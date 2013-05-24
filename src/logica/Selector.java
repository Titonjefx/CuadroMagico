package logica;

import java.util.Collections;
import java.util.Comparator;

/**
 * Clase que representa un selector natural en el algoritmo gen&eacute;tico.
 * Extiede de la clase abstracta SelectorNatural.
 *
 * @author Jhonderson
 */
public class Selector extends SelectorNatural {

    /**
     * Guarda los cromosomas que son tomados en cuenta para la selecci&oacute;n.
     */
    private Poblacion cromosomas;

    /**
     * Constructor.
     *
     * @param recursos recursos para que el algoritmo gen&eacute;tico funcione
     */
    public Selector(final Recursos recursos) {
        cromosomas = new Poblacion(recursos, 0);
    }

    /**
     * Agrega un cromosoma a la lista de cromosomas.
     *
     * @param cromosoma cromosoma a agregar a la lista de cromosomas
     */
    @Override
    protected void agregar(final Cromosoma cromosoma) {
        cromosoma.setEsSeleccionadoParaLaSiguienteGeneracion(false);
        cromosomas.agregarCromosoma(cromosoma);
    }

    /**
     * Vea la interface de SelectorNatural para esta descripci&oacute;n.
     */
    @Override
    public void seleccionar(final int numeroDeSeleccionados,
            final Poblacion poblacionInicial,
            final Poblacion poblacionResultante) {
        if (poblacionInicial != null) {
            int popSize = poblacionInicial.tamanoDePoblacion();
            for (int i = 0; i < popSize; i++) {
                agregar(poblacionInicial.getCromosoma(i));
            }
        }
        int puedenSerElegidos;
        int numeroDeCromosomas = cromosomas.tamanoDePoblacion();
        if (numeroDeSeleccionados > numeroDeCromosomas) {
            puedenSerElegidos = numeroDeCromosomas;
        } else {
            puedenSerElegidos = numeroDeSeleccionados;
        }
        int tamanoRequerido = numeroDeSeleccionados;

        if (puedenSerElegidos > 0) {
            Collections.sort(cromosomas.getCromosomas(),
                    new Comparator() {
                        @Override
                        public int compare(final Object cromosoma1, final Object cromosoma2) {
                            Cromosoma chromosomeOne = (Cromosoma) cromosoma1;
                            Cromosoma chromosomeTwo = (Cromosoma) cromosoma2;
                            if (getRecursos().getFuncionDeEvaluacion().esMejor(chromosomeOne, chromosomeTwo)) {
                                return -1;
                            } else if (getRecursos().getFuncionDeEvaluacion().esMejor(chromosomeTwo, chromosomeOne)) {
                                return 1;
                            } else {
                                return 0;
                            }
                        }
                    });
        }

        Cromosoma cromosomaSeleccionado;
        for (int i = 0; i < puedenSerElegidos; i++) {
            cromosomaSeleccionado = cromosomas.getCromosoma(i);
            cromosomaSeleccionado.setEsSeleccionadoParaLaSiguienteGeneracion(true);
            poblacionResultante.agregarCromosoma(cromosomaSeleccionado);
        }

        //si se requiere seleccionar mas cromosomas de los que hay en la
        //poblacion actual
        int aAgregar;
        aAgregar = tamanoRequerido - poblacionResultante.tamanoDePoblacion();

        for (int i = 0; i < aAgregar; i++) {
            cromosomaSeleccionado = cromosomas.getCromosoma(i % numeroDeCromosomas);
            cromosomaSeleccionado.setEsSeleccionadoParaLaSiguienteGeneracion(true);
            poblacionResultante.agregarCromosoma(cromosomaSeleccionado);
        }
    }

    /**
     * Vea la interface de SelectorNatural para esta descripci&oacute;n.
     */
    @Override
    public void vaciar() {
        cromosomas.getCromosomas().clear();
    }
}