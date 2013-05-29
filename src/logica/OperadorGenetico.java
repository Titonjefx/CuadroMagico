package logica;

import java.util.List;
import logica_implementacion.Poblacion;

/**
 * Clase que define los m&eacute;todos que debe implementar un operador
 * gen&eacute;tico determinado.
 *
 * @author Jhonderson
 */
public interface OperadorGenetico {

    /**
     * Aplica el operador genetico a una poblaci&oacute;n de cromosomas
     *
     * @param poblacion poblaci&oacute;n a la que se le aplicar&aacute;n los
     * operadores gen&eacute;ticos
     * @param cromosomasCandidatos cromosomas elegidos para pasar a la siguiente
     * generaci&oacute;n
     */
    public void operar(final Poblacion poblacion,
            final List cromosomasCandidatos);
}
