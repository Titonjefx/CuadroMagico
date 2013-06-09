package logica_implementacion;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import logica.*;

/**
 * Clase que representa el reproductor en el algoritmo gen&eacute;tico.
 * Implementa la interfaz reproductor.
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
    protected void aplicarSelectoresNaturales(Recursos recursos,
            Poblacion poblacion, PiscinaDeCromosomas piscinaDeCromosomas) {

        int tamanoDeSeleccion = recursos.getNumeroDeCromosomasAReproducir();

        //El tamano de la poblacion debe ser menor que el de la poblacion
        //actual
        if (tamanoDeSeleccion > poblacion.tamanoDePoblacion()) {
            return;
        }

        //Pueden haber varios selectores naturales
        int tamanoDeSelectores = recursos.tamanoDeLosSelectoresNaturales();


        if (tamanoDeSelectores > 0) {
            int tamanoDeSeleccionPorSelector;
            SelectorNatural selector;

            //Si hay n selectores con seleccion de m cromosomas, cada selector
            //selecciona m/n cromosomas. seleccionando al final n*(m/n)
            //cromosomas
            for (int i = 0; i < tamanoDeSelectores; i++) {
                selector = recursos.getSelectorNatural(i);
                if ((i == tamanoDeSelectores - 1) && (i > 0)) {
                    tamanoDeSeleccionPorSelector = tamanoDeSeleccion
                            - piscinaDeCromosomas.tamano();
                } else {
                    tamanoDeSeleccionPorSelector = tamanoDeSeleccion
                            / tamanoDeSelectores;
                }
                selector.seleccionar(tamanoDeSeleccionPorSelector, poblacion,
                        piscinaDeCromosomas);
                selector.vaciar();
            }
        } else {
        }
    }

    /**
     * Aplica todos los operadores genéticos que estan en recursos.
     *
     * @param recursos recursos a usar
     * @param piscinaDeCromosomas piscina de cromosomas de entrada
     */
    protected List<Cromosoma> aplicarOperadoresGeneticos(Recursos recursos,
            PiscinaDeCromosomas piscinaDeCromosomas) {
        List<Cromosoma> cromosomasResultantes = new ArrayList<>();
        List<OperadorGenetico> operadoresGeneticos = recursos.getOperadoresGeneticos();
        Iterator iteradorDeOperadores = operadoresGeneticos.iterator();
        while (iteradorDeOperadores.hasNext()) {
            OperadorGenetico operator = (OperadorGenetico) iteradorDeOperadores.next();
            operator.operar(piscinaDeCromosomas, cromosomasResultantes);
        }
        return cromosomasResultantes;
    }

    @Override
    public Poblacion evolucionar(Poblacion unaPoblacion, Recursos recursos) {

        //Poblacion a evolucionar
        Poblacion poblacion = unaPoblacion;

        //Se obtiene la instancia de la funcion de aptitud que se encuentra en
        //recursos
        FuncionDeAptitud funcionDeAptitud = recursos.getFuncionDeAptitud();

        //Se evalua cada cromosoma y se le asigna un valor de aptitud
        funcionDeAptitud.evaluar(poblacion);

        //Se selesccionan los cromosomas a reproducir y se guardan en la piscina
        //de cromosomas
        PiscinaDeCromosomas piscinaDeCromosomas = new PiscinaDeCromosomas();
        aplicarSelectoresNaturales(recursos, poblacion, piscinaDeCromosomas);

        List<Cromosoma> cromosomasResultantes = aplicarOperadoresGeneticos(recursos,
                piscinaDeCromosomas);

        for (Cromosoma cromosoma : piscinaDeCromosomas.getCromosomas()) {
            cromosoma.incrementarEdad();
            cromosoma.restablecerNumeroDeOperacionesGeneticas();
        }

        for (Cromosoma cromosoma : cromosomasResultantes) {
            cromosoma.setHaSidoEvaluado(false);
            cromosoma.restablecerEdad();
            cromosoma.incrementarNumeroDeOperacionesGeneticas();
            poblacion.agregarCromosoma(cromosoma);
        }

        //Seria como el reemplazo.
        poblacion.mantenerConstanteElTamanoDeLaPoblacion();

        recursos.incrementarNumeroDeGeneracionesActuales();
        return poblacion;
    }
}
