package logica;

import logica_implementacion.PiscinaDeCromosomas;
import logica_implementacion.Poblacion;
import logica_implementacion.Recursos;

/**
 * Define los m&eacute;todos que deben ser implementados por un selector
 * natural. Implementa algunos de ellos.
 *
 * @author Jhonderson
 */
public abstract class SelectorNatural {

    private Recursos recursos;

    /**
     * Constructor.
     */
    public SelectorNatural() {
    }

    /**
     * @return los recursos a usar
     */
    public Recursos getRecursos() {
        return recursos;
    }

    /**
     * Agrega un cromosoma a la piscina de cromosomas del selector.
     *
     * @param cromosoma cromosoma a agregar a la lista de cromosomas que
     * ser&aacute;n tomados en cuenta para el proceso de selecci&oacute;n
     */
    protected abstract void agregar(Cromosoma cromosoma);

    /**
     * Selecciona un n&uacute;mero de cromosomas de la poblaci&oacute;n que
     * pasar&aacute;n a la pr&oacute;xima generaci&oacute;n basandose en el
     * valor de la aptitud.
     *
     * @param poblacionInicial la poblaci&oacute;n de cromosomas de donde se
     * seleccionar&aacute;n los cromosomas que pasen
     * @param piscinaDeCromosomas piscina de cromosomas de donde se guardaran
     * los cromosomas que pasaran a la siguiente generacion
     * @param numeroDeSeleccionados n&uacute;mero de cromosomas a seleccionar
     */
    public abstract void seleccionar(final int numeroDeSeleccionados,
            final Poblacion poblacionInicial,
            final PiscinaDeCromosomas piscinaDeCromosomas);

    /**
     * Vac&iacute;a la lista de cromosomas del selector.
     */
    public abstract void vaciar();
}
