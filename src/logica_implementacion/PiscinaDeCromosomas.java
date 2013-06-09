package logica_implementacion;

import java.util.ArrayList;
import java.util.List;
import logica.Cromosoma;

/**
 * Clase que funciona como una colecci&oacute;n de cromosomas. Aqu&iacute; se
 * guardar&aacute;n los cromosomas seleccionados para la aplicaci&oacute;n de
 * los operadores gen&eacute;ticos.
 */
public class PiscinaDeCromosomas {

    /**
     * Piscina donde los cromosomas son almacenados.
     */
    private List<Cromosoma> piscinaDeCromosomas;

    /**
     * Constructor.
     */
    public PiscinaDeCromosomas() {
        piscinaDeCromosomas = new ArrayList<>();
    }

    /**
     * Remueve un cromosoma de la piscina de cromosomas y lo retorna.
     *
     * @return la instancia de un cromosoma en la piscina de cromosomas
     */
    public Cromosoma popCromosoma() {
        if (piscinaDeCromosomas.isEmpty()) {
            return null;
        } else {
            // Se remueve el ultimo objeto de la piscina y se remueve.
            // esto para que la lista no se "resize"
            return piscinaDeCromosomas.remove(piscinaDeCromosomas.size() - 1);
        }
    }

    /**
     * Agrega un cromosoma a la piscina de cromosomas.
     *
     * @param cromosoma a agregar en la piscina de cromosomas
     */
    public void agregarCromosoma(final Cromosoma cromosoma) {
        piscinaDeCromosomas.add(cromosoma);
    }

    /**
     * Agrega multiples cromosomas a la piscina de cromosomas.
     *
     * @param cromosomas Cromosomas a agregar en la piscina de cromosomas
     */
    public void agregarCromosomas(final List<Cromosoma> cromosomas) {
        piscinaDeCromosomas.addAll(cromosomas);
    }

    /**
     * Regresa el n&uacute;mero de cromosomas en la piscina de cromosomas.
     *
     * @return Numero de cromosomas en la piscina de cromosomas
     */
    public int tamano() {
        return piscinaDeCromosomas.size();
    }

    public List<Cromosoma> getCromosomas() {
        return piscinaDeCromosomas;
    }

    public Cromosoma getCromosoma(int pos) {
        return this.piscinaDeCromosomas.get(pos);
    }
}
