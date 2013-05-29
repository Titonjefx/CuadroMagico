package logica;

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
     * @param cromosoma cromosoma a agregar a la piscina de cromosomas
     */
    protected abstract void agregar(Cromosoma cromosoma);

    /**
     * Selecciona un n&uacute;mero de cromosomas de la poblaci&oacute;n que
     * pasar&aacute;n a la pr&oacute;xima generaci&oacute;n basandose en el
     * valor de la aptitud. los cromosomas con mejor aptitud pasaran.
     *
     * @param poblacionInicial la poblaci&oacute;n de cromosomas de donde se
     * seleccionar&aacute;n los cromosomas que pasen
     * @param poblacionResultante la poblaci&oacute;n de cromosomas de donde se
     * guardaran los cromosomas que pasen
     * @param numeroDeSeleccionados n&uacute;mero de cromosomas a seleccionar
     */
    public abstract void seleccionar(final int numeroDeSeleccionados,
            final Poblacion poblacionInicial,
            final Poblacion poblacionResultante);

    /**
     * Compara dos cromosomas.
     */
    public class FitnessValueComparator {

        public int compare(Object first, Object second) {
            Cromosoma chrom1 = (Cromosoma) first;
            Cromosoma chrom2 = (Cromosoma) second;
            if (getRecursos().getFuncionDeEvaluacion().esMejor(chrom2,
                    chrom1)) {
                return 1;
            } else if (getRecursos().getFuncionDeEvaluacion().esMejor(
                    chrom1, chrom2)) {
                return -1;
            } else {
                return 0;
            }
        }
    }

    /**
     * Vacia la poblacion de cromosomas del selector.
     */
    public abstract void vaciar();
}
