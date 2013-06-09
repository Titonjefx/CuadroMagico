package logica;

import logica_implementacion.PiscinaDeCromosomas;

/**
 * Clase que define los m&eacute;todos que debe implementar un operador
 * gen&eacute;tico determinado.
 */
public interface OperadorGenetico {

    /**
     * Aplica el operador genetico a una poblaci&oacute;n de cromosomas
     *
     * @param piscinaDeCromosomas cromosomas a los que se les aplicar&aacute; los
     * operadores gen&eacute;ticos
     */
    public void operar(final PiscinaDeCromosomas piscinaDeCromosomas);
}
