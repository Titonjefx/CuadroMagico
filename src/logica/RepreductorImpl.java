package logica;

import java.util.Iterator;
import java.util.List;

/**
 * Clase que representa el reproductor en el algoritmo gen&eacute;tico.
 * Implementa la interfaz reproductor.
 *
 * @author Jhonderson
 */
public class RepreductorImpl implements Reproductor {

    /**
     * Constructor.
     */
    public RepreductorImpl() {
    }

    /**
     * Aplica los selectores naturales de la clase Recursos.
     *
     * @param recursos configuraci&oacute;n a usar
     * @param poblacion poblaci&oacute;n de entrada
     *
     * @return parte de la poblaci&oacute;n de entrada
     */
    protected Poblacion aplicarSelectoresNaturales(Recursos recursos,
            Poblacion poblacion) {
        int tamanoDeSelectores = recursos.tamanoDeLosSelectoresNaturales();
        if (tamanoDeSelectores > 0) {
            int tamanoDeLaPoblacion = recursos.getTamanoDeLaPoblacion();
            int tamanoDeSeleccion;
            Poblacion nuevaPoblacion = new Poblacion(recursos, tamanoDeLaPoblacion);
            SelectorNatural selector;
            for (int i = 0; i < tamanoDeSelectores; i++) {
                selector = recursos.getSelectorNatural(i);
                if ((i == tamanoDeSelectores - 1) && (i > 0)) {
                    tamanoDeSeleccion = tamanoDeLaPoblacion - nuevaPoblacion.tamanoDePoblacion();
                } else {
                    tamanoDeSeleccion = tamanoDeLaPoblacion / tamanoDeSelectores;
                }
                selector.seleccionar(tamanoDeSeleccion, poblacion, nuevaPoblacion);
                selector.vaciar();
            }
            return nuevaPoblacion;
        } else {
            return poblacion;
        }
    }

    /**
     * Aplica todos los operadores genéticos que estan en recursos.
     *
     * @param recursos recursos a usar
     * @param poblacion poblaci&oacute;n de entrada
     */
    protected void aplicarOperadoresGeneticos(Recursos recursos, Poblacion poblacion) {
        List operadoresGeneticos = recursos.getOperadoresGeneticos();
        Iterator iteradorDeOperadores = operadoresGeneticos.iterator();
        while (iteradorDeOperadores.hasNext()) {
            OperadorGenetico operator = (OperadorGenetico) iteradorDeOperadores.next();
            operator.operar(poblacion, poblacion.getCromosomas());
        }
    }

    @Override
    public Poblacion evolucionar(Poblacion poblacion) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
