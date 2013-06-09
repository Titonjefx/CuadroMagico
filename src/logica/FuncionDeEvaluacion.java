package logica;

/**
 * Clase que define los m&eacute;todos que debe implementar una funci&oacute;n
 * de evaluaci&oacute;n.
 */
public interface FuncionDeEvaluacion {

    /**
     * Compara el primer valor de aptitud con el segundo y retorna true si el
     * primero es mas grande que el segundo. De lo contrario retorna false.
     *
     * @param valorDeAptitud1 primer cromosoma
     * @param valorDeAptitud2 segundo cromosoma
     * @return true: primer valor de aptitud es mayor que el segundo
     */
    boolean esMejor(double valorDeAptitud1, double valorDeAptitud2);

    /**
     * Compara el valor de aptitud del primer cromosoma con el valor de aptitud
     * del segundo cromosoma y retorna true si el primero valor es mas grande
     * que el segundo valor. De lo contrario retorna false.
     *
     * @param cromosoma1 primer cromosoma
     * @param cromosoma2 segundo cromosoma
     * @return true: primer valor de aptitud es mayor que el segundo
     */
    boolean esMejor(Cromosoma cromosoma1, Cromosoma cromosoma2);
}
