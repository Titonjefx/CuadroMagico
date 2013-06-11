package logica_implementacion;

import java.util.ArrayList;
import java.util.List;
import logica.Cromosoma;
import logica.SelectorNatural;

/**
 * Clase que representa un selector natural en el algoritmo gen&eacute;tico.
 * Se seleccionan cromosomas preferiblemente con mejor aptitud. Extiede de la
 * clase abstracta SelectorNatural.
 */
public class SelectorPorTorneo extends SelectorNatural {

    /**
     * Guarda los cromosomas que son tomados en cuenta para la selecci&oacute;n.
     */
    private Poblacion cromosomas;

    /**
     * Constructor.
     *
     * @param recursos recursos para que el algoritmo gen&eacute;tico funcione
     */
    public SelectorPorTorneo(Recursos recursos) {
        cromosomas = new Poblacion(recursos);
        this.recursos = recursos;
    }
    
    /**
     * Agrega un cromosoma a la lista de cromosomas.
     *
     * @param cromosoma cromosoma a agregar a la lista de cromosomas
     */
    @Override
    protected void agregar(final Cromosoma cromosoma) {
        cromosomas.agregarCromosoma(cromosoma);
    }

    /**
     * Se seleccionan dos cromosomas de poblaci&oacute;n y el que tenga mejor 
     * funci&oacute;n de aptitud pasa. Vea la interfaz SelectorNatural para esta
     * descripci&oacute;n.
     */
    @Override
    public void seleccionar(final int numeroDeSeleccionados,
            final Poblacion poblacionInicial,
            final PiscinaDeCromosomas piscinaDeCromosomas) {
        if (poblacionInicial != null) {
            int tamanoDePoblacion = poblacionInicial.tamanoDePoblacion();
            for (int i = 0; i < tamanoDePoblacion; i++) {
                agregar(poblacionInicial.getCromosoma(i));
            }
        }
        
        List cromosomasYaSeleccionados = new ArrayList();
        Cromosoma cromosomaSeleccionado;
        for (int i = 0; i < numeroDeSeleccionados; i++) {
            while (true) {
                int posAleatoria1 = (int)(Math.random() *
                        cromosomas.tamanoDePoblacion());
                int posAleatoria2 = (int)(Math.random() *
                        cromosomas.tamanoDePoblacion());

                if (getRecursos().getFuncionDeEvaluacion().esMejor(
                        cromosomas.getCromosoma(posAleatoria1),
                        cromosomas.getCromosoma(posAleatoria2))) {
                    if (!cromosomasYaSeleccionados.contains(posAleatoria1)) {
                        cromosomaSeleccionado = cromosomas.getCromosoma(posAleatoria1)
                            .clonar();
                        cromosomasYaSeleccionados.add(posAleatoria1);
                        break;
                    }
                } else {
                    if (!cromosomasYaSeleccionados.contains(posAleatoria2)) {
                        cromosomaSeleccionado = cromosomas.getCromosoma(posAleatoria2)
                            .clonar();
                        cromosomasYaSeleccionados.add(posAleatoria2);
                        break;
                    }
                }
            }
            piscinaDeCromosomas.agregarCromosoma(cromosomaSeleccionado);
        }
    }

    /**
     * Vea la interface de SelectorNatural para esta descripci&oacute;n.
     */
    @Override
    public void vaciar() {
        cromosomas.getCromosomas().clear();
    }
}
