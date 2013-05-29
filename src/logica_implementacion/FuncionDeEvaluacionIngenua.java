package logica_implementacion;

import logica.Cromosoma;
import logica.FuncionDeEvaluacion;

public class FuncionDeEvaluacionIngenua implements FuncionDeEvaluacion {

    @Override
    public boolean esMejor(double valorDeAptitud1, double valorDeAptitud2) {
        if (valorDeAptitud1 >= valorDeAptitud2) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean esMejor(Cromosoma cromosoma1, Cromosoma cromosoma2) {
        return this.esMejor(cromosoma1.getValorDeAptitud(),
                cromosoma2.getValorDeAptitud());
    }
}
