package logica;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Clase que funciona como una colecci&oacute;n de objetos.
 *
 * @author Jhonderson
 */
public class Piscina {

    /**
     * Objetos en la piscina.
     */
    private List objetosEnLaPiscina;

    /**
     * Constructor.
     */
    public Piscina() {
        objetosEnLaPiscina = Collections.emptyList();
    }

    /**
     * Adquiere una instancia de un objeto de la piscina.
     *
     * @return una instancia de un objeto en la piscina
     */
    public Object popObjeto() {
        if (objetosEnLaPiscina.isEmpty()) {
            return null;
        } else {
            // Se remueve el ultimo objeto de la piscina y se remueve.
            // esto para que la lista no se "resize"
            return objetosEnLaPiscina.remove(objetosEnLaPiscina.size() - 1);
        }
    }

    /**
     * Agrega un objeto a la piscina.
     *
     * @param objeto objeto a agregar en la piscina.
     */
    public void agregarObjeto(final Object objeto) {
        objetosEnLaPiscina.add(objeto);
    }

    /**
     * Agrega objetos a la piscina.
     *
     * @param objetos para agregar a la piscina
     */
    public void agregarObjetos(final Collection objetos) {
        if (objetos != null) {
            objetosEnLaPiscina.addAll(objetos);
        }
    }

    /**
     * Retorna el n&uacute;mero de objetos en esta piscina.s
     *
     * @return el n&uacute;mero de objetos en la piscina.
     */
    public int tamano() {
        return objetosEnLaPiscina.size();
    }

    /**
     * Vac&iacute;a la piscina.
     */
    public void vaciar() {
        objetosEnLaPiscina.clear();
    }
}
