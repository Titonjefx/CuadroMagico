package logica;

import logica_implementacion.Poblacion;

/**
 * Clase que define los m&eacute;todos que debe tener una funci&oacute;n de
 * aptitud. Algunos son implementados.
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
    public abstract double evaluar(Cromosoma cromosoma);

    /**
     * Evalua cada cromosoma de la poblacion y le establece su valor de aptitud.
     *
     * @param unaPoblacion poblacion a evaluar
     */
    public abstract void evaluar(Poblacion unaPoblacion);
}
