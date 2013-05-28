package logica;

/**
 * Clase que funciona como una colecci&oacute;n de cromosomas.
 *
 * @author Jhonderson
 */
public class PiscinaDeCromosomas {

    /**
     * Piscina donde los cromosomas son almacenados.
     */
    private Piscina piscinaDeCromosomas;

    /**
     * Constructor.
     */
    public PiscinaDeCromosomas() {
        piscinaDeCromosomas = new Piscina();
    }

    /**
     * Remueve un cromosoma de la piscina de cromosomas y lo retorna.
     *
     * @return la instancia de un cromosoma en la piscina de cromosomas
     */
    public Cromosoma popCromosoma() {
        return (Cromosoma) piscinaDeCromosomas.popObjeto();
    }

    /**
     * Agrega un cromosoma a la piscina de cromosomas.
     *
     * @param cromosoma a agregar en la piscina de cromosomas
     */
    public void agregarCromosoma(final Cromosoma cromosoma) {
        piscinaDeCromosomas.agregarObjeto(cromosoma);
    }
}
