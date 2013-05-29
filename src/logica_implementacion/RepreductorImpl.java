package logica_implementacion;

import java.util.Iterator;
import java.util.List;
import logica.Cromosoma;
import logica.FuncionDeAptitud;
import logica.OperadorGenetico;
import logica.Reproductor;
import logica.SelectorNatural;

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
    public Poblacion evolucionar(Poblacion unaPoblacion, Recursos recursos) {

        Poblacion poblacion = unaPoblacion;
        FuncionDeAptitud funcionDeAptitud = recursos.getFuncionDeAptitud();

        // Si es la primera generacion: Establece la edad a uno para permitir
        //operadores geneticos.
        if (recursos.getNumeroDeGeneracionesActuales() == 0) {
            int tamano = poblacion.tamanoDePoblacion();
            for (int i = 0; i < tamano; i++) {
                Cromosoma cromosoma = poblacion.getCromosoma(i);
                cromosoma.incrementarEdad();
            }
            if (funcionDeAptitud != null) {
                funcionDeAptitud.evaluar(poblacion);
                //poblacion = evaluacionDeFuncionDeAptitud(recursos, funcionDeAptitud, poblacion);
                recursos.incrementarNumeroDeGeneracionesActuales();
                return poblacion;
            }
        }
        funcionDeAptitud.evaluar(poblacion);
        // Apply certain NaturalSelectors before GeneticOperators will be executed.
        // ------------------------------------------------------------------------
        poblacion = aplicarSelectoresNaturales(recursos, poblacion);
        int nuevoIndiceDelCromosoma = poblacion.tamanoDePoblacion();
        // Execute all of the Genetic Operators.
        // -------------------------------------
        aplicarOperadoresGeneticos(recursos, poblacion);
        // Reset fitness value of genetically operated chromosomes.
        // Normally, this should not be necessary as the Chromosome class
        // initializes each newly created chromosome with
        // FitnessFunction.NO_FITNESS_VALUE. But who knows which Chromosome
        // implementation is used or if cloning is utilized.
        // ----------------------------------------------------------------
        int tamanoActualDeLaPoblacion = poblacion.tamanoDePoblacion();
        for (int i = nuevoIndiceDelCromosoma; i < tamanoActualDeLaPoblacion;
                i++) {
            Cromosoma chrom = poblacion.getCromosoma(i);
            chrom.setHaSidoEvaluado(false);
            // Mark chromosome as new-born.
            // ----------------------------
            chrom.restablecerEdad();
            // Mark chromosome as being operated on.
            // -------------------------------------
            chrom.incrementarNumeroDeOperacionesGeneticas();
        }
        // Increase age of all chromosomes which are not modified by genetic
        // operations.
        // -----------------------------------------------------------------
        int tamano = Math.min(nuevoIndiceDelCromosoma, tamanoActualDeLaPoblacion);
        for (int i = 0; i < tamano; i++) {
            Cromosoma cromosoma = poblacion.getCromosoma(i);
            cromosoma.incrementarEdad();
            // Mark chromosome as not being operated on.
            // -----------------------------------------
            cromosoma.restablecerNumeroDeOperacionesGeneticas();
        }
        // If a bulk fitness function has been provided, call it.
        // ------------------------------------------------------
        if (funcionDeAptitud != null & recursos.getNumeroDeGeneracionesActuales() > 0) {
            funcionDeAptitud.evaluar(poblacion);
            //poblacion = evaluacionDeFuncionDeAptitud(recursos, funcionDeAptitud, poblacion);
        }

        poblacion = aplicarSelectoresNaturales(recursos, poblacion);

        recursos.incrementarNumeroDeGeneracionesActuales();
        return poblacion;
    }

    /*public Poblacion evaluacionDeFuncionDeAptitud(Recursos unosRecursos,
     FuncionDeAptitud funcionDeAptitud, Poblacion unaPoblacion) {
     if (funcionDeAptitud != null) {

     //remove chromosomes which have been already evaluated
     Poblacion poblacion = removerCromosomasEvaluados(unaPoblacion, unosRecursos);

     if (unosRecursos.esConstanteElTamanoDePoblacion()) {
     poblacion.mantenerConstanteElTamanoDeLaPoblacion();
     }

     if (poblacion.tamanoDePoblacion() > 0) {
     funcionDeAptitud.evaluar(poblacion);
     }
     //Remove the fitness value and add evaluated elements to
     //the List with NO_FITNESS_VALUE
     //and add the NEW elements to pop
     Iterator it2 = poblacion.getCromosomas().iterator();
     while (it2.hasNext()) {
     Cromosoma cromosoma0 = (Cromosoma) it2.next();
     if (!unaPoblacion.getCromosomas().contains((Cromosoma) cromosoma0)) {
     unaPoblacion.agregarCromosoma((Cromosoma) cromosoma0);
     }
     }
     //remove chromosomes which have been already evaluated
     unaPoblacion = removerCromosomasNoEvaluados(unaPoblacion, unosRecursos);
     }
     return unaPoblacion;
     }

     private Poblacion removerCromosomasEvaluados(Poblacion poblacionDeEntrada,
     Recursos unosRecursos) {
     Poblacion poblacionDeSalida = new Poblacion(unosRecursos, 0);
     Cromosoma cromosomaSeleccionados;
     for (int i = 0; i < poblacionDeEntrada.tamanoDePoblacion(); i++) {
     cromosomaSeleccionados = poblacionDeEntrada.getCromosoma(i);
     if (!cromosomaSeleccionados.haSidoEvaluado()) {
     poblacionDeSalida.agregarCromosoma(cromosomaSeleccionados);
     }
     }
     return poblacionDeSalida;
     }

     private Poblacion removerCromosomasNoEvaluados(Poblacion poblacionDeEntrada,
     Recursos unosRecursos) {
     Poblacion poblacionDeSalida = new Poblacion(unosRecursos, 0);
     Cromosoma cromosomaSeleccionados;
     for (int i = 0; i < poblacionDeEntrada.tamanoDePoblacion(); i++) {
     cromosomaSeleccionados = poblacionDeEntrada.getCromosoma(i);
     if (cromosomaSeleccionados.haSidoEvaluado()) {
     poblacionDeSalida.agregarCromosoma(cromosomaSeleccionados);
     }
     }
     return poblacionDeSalida;
     }

     protected void actualizarCromosomas(Poblacion unaPoblacion, Recursos unosRecursos) {
     int tamanoActualDePoblacion = unaPoblacion.tamanoDePoblacion();

     FuncionDeAptitud funcionDeAptitud = unosRecursos.getFuncionDeAptitud();
     if (funcionDeAptitud == null) {
     for (int i = 0; i < tamanoActualDePoblacion; i++) {
     Cromosoma chrom = unaPoblacion.getCromosoma(i);
     chrom.getValorDeAptitud();
     }
     }
     }*/
}
