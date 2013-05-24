package logica;

/**
 * Clase que define los m&eacute;todos que debe tener una funci&oacute;n de
 * aptitud. Algunos son implementados.
 *
 * @author Jhonderson
 */
public abstract class FuncionDeAptitud {

    /**
     * Regresa el valor de aptitud de un cromosoma.
     *
     * @param cromosoma cromosoma al que se le calcula el valor de aptitud
     * @return valor de aptitud del cromosoma
     */
    public double getValorDeAptitud(final Cromosoma cromosoma) {
        double valorDeAptitud = evaluar(cromosoma);

        return valorDeAptitud;
    }

    /**
     * Regresa el valor de aptitud de un cromosoma.
     *
     * @param cromosoma al que se le calcula el valor de aptitud
     *
     * @return positivo flotante que representa el valor de aptitud del
     * cromosoma
     */
    protected abstract double evaluar(Cromosoma cromosoma);
}