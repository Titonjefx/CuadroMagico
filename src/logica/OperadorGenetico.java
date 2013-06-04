package logica;

import java.util.List;
import logica_implementacion.PiscinaDeCromosomas;

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
     * @param piscinaDeCromosomas cromosomas a los que se les aplicar&aacute; los
     * operadores gen&eacute;ticos
     * @param cromosomasCandidatos cromosomas elegidos para pasar a la siguiente
     * generaci&oacute;n
     */
    public void operar(final PiscinaDeCromosomas piscinaDeCromosomas,
            final List cromosomasCandidatos);
}
