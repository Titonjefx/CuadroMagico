package logica_implementacion;

import logica.Cromosoma;
import logica.FuncionDeEvaluacion;

/**
 * Funcion que conoce lo que representa el valor de aptitud en un cromosoma. Por
 * esta razon, decide cual de dos cromosomas es mejor.
 */
public class FuncionDeEvaluacionImpl implements FuncionDeEvaluacion {

    /**
     * Vease la interfaz FuncionDeEvaluacion para esta descripci&oacute;.
     *
     * @param valorDeAptitud1
     * @param valorDeAptitud2
     * @return
     */
    @Override
    public boolean esMejor(double valorDeAptitud1, double valorDeAptitud2) {
        if (valorDeAptitud1 >= valorDeAptitud2) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Vease la interfaz FuncionDeEvaluacion para esta descripci&oacute;.
     *
     * @param cromosoma1
     * @param cromosoma2
     * @return
     */
    @Override
    public boolean esMejor(Cromosoma cromosoma1, Cromosoma cromosoma2) {
        return this.esMejor(cromosoma1.getValorDeAptitud(),
                cromosoma2.getValorDeAptitud());
    }
}
