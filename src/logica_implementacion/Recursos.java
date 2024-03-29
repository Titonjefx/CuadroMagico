package logica_implementacion;

import java.util.ArrayList;
import java.util.List;
import logica.Cromosoma;
import logica.FuncionDeAptitud;
import logica.FuncionDeEvaluacion;
import logica.OperadorGenetico;
import logica.Reproductor;
import logica.SelectorNatural;

/**
 * Clase donde estar&aacute;n todos los recursos necesarios para el
 * funcionamiento del algoritmo gen&eacute;tico.
 */
public class Recursos {

    /**
     * Referencia la actual funcion de aptitud.
     */
    private FuncionDeAptitud funcionDeAptitud;
    /**
     * Referencia el actual evaluador de aptitud.
     */
    private FuncionDeEvaluacion funcionDeEvaluacion;
    /**
     * Realiza la evoluci&oacute;n.
     */
    private Reproductor reproductor;
    /**
     * Cromosoma de muestra.
     */
    private Cromosoma cromosomaDeMuestra;
    /**
     * Referencia la piscina de cromosomas.
     */
    private PiscinaDeCromosomas piscinaDeCromosomas;
    /**
     * Almacena todas las implementaciones de operadores gen&eacute;ticos.
     */
    private List<OperadorGenetico> operadoresGeneticos;
    /**
     * N&uacute;mero de genes en cada cromosoma.
     */
    private int tamanoDeCromosomas;
    /**
     * Selectores gen&eacute;ticos.
     */
    private List<SelectorNatural> selectores;
    /**
     * Indica que tantas evoluciones han ocurrido.
     */
    private int numeroDeGeneracionesActuales;
    /**
     * Tama&ntilde;o de la poblaci&oacute;n.
     */
    private int tamanoDeLaPoblacion;
    /**
     * Porcentaje de mutaci&oacute;n del algoritmo gen&eacute;tico.
     */
    private double porcentajeDeMutacion;
    /**
     * Porcentaje de mutaci&oacute;n del algoritmo gen&eacute;tico.
     */
    private double porcentajeDeCruce;
    /**
     * N&uacute;mero de cromosomas que se seleccionan para ser ingresados a la
     * piscina de cromosomas y aplicarles los operadores gen&eacute;ticos
     * posteriormente.
     */
    private int numeroDeCromosomasAReproducir;

    /**
     * Constructor
     */
    public Recursos() {
        selectores = new ArrayList();
        operadoresGeneticos = new ArrayList();
        tamanoDeLaPoblacion = 100;
    }

    /**
     * Establece la referencia a la funci&oacute;n de aptitud.
     *
     * @param funcionDeAptitud referencia a la función de aptitud
     */
    public void setFuncionDeAptitud(final FuncionDeAptitud funcionDeAptitud) {
        this.funcionDeAptitud = funcionDeAptitud;
    }

    /**
     * Regresa la referencia a la funci&oacute;n de aptitud.
     *
     * @return referencia a la funci&oacute; de aptitud
     */
    public FuncionDeAptitud getFuncionDeAptitud() {
        return funcionDeAptitud;
    }

    /**
     * Establece la referencia a el cromosoma de muestra.
     *
     * @param cromosomaDeMuestra referencia al cromosoma de muestra
     */
    public void setCromosomaDeMuestra(Cromosoma cromosomaDeMuestra) {
        this.cromosomaDeMuestra = cromosomaDeMuestra;
    }

    /**
     * Regresa la referencia al cromosoma de muestra.
     *
     * @return referencia al cromosoma de muestra
     */
    public Cromosoma getCromosomaDeMuestra() {
        return cromosomaDeMuestra;
    }

    /**
     * Regresa el tama&ntilde;o de los cromosomas.
     *
     * @return tama&ntilde; de los cromosomas.
     */
    public int getTamanoDeCromosomas() {
        return tamanoDeCromosomas;
    }

    /**
     * Agrega un selector natural a la lista de selectores naturales.
     *
     * @param selectorNatural a agregar
     */
//    public void setSelectorNatural(final SelectorNatural selectorNatural) {
//        agregarSelectorNatural(selectorNatural);
//    }
    /**
     * Regresa un selector natural en la posici&oacute;n indicada por indice.
     *
     * @param indice posici&oacute;n del selector natural a regresar
     * @return selector natural en dicha posici&oacute;n
     */
    public SelectorNatural getSelectorNatural(final int indice) {
        return (SelectorNatural) selectores.get(indice);
    }

    /**
     * Obtiene la lista de los selectores naturales.
     *
     * @return lista de selectores naturales
     */
    public List obtenerSelectoresNaturales() {
        return selectores;
    }

    /**
     * Regresa el n&uacute;mero de selectores naturales.
     *
     * @return n&uacute;mero de selectores naturales
     */
    public int tamanoDeLosSelectoresNaturales() {
        return selectores.size();
    }

    /**
     * Remueve todos los selectores naturales.
     */
    public void removerSelectoresNaturales() {
        selectores.clear();
    }

    /**
     * Agrega un operador gen&eacute;tico a la lista de operadores
     * gen&eacute;ticos.
     *
     * @param operadorGenetico operador gen&eacute;tico a agregar
     */
    public void agregarOperadorGenetico(final OperadorGenetico operadorGenetico) {
        operadoresGeneticos.add(operadorGenetico);
    }

    /**
     * Regresa la lista de los operadores gen&eacute;ticos.
     *
     * @return lista de los operadores gen&eacute;ticos
     */
    public List getOperadoresGeneticos() {
        return operadoresGeneticos;
    }

    /**
     * Establece el tama&ntilde;o de la poblaci&oacute;n.
     *
     * @param tamanoDeLaPoblacion tama&ntilde;o de la poblaci&oacute;n a
     * establecer
     */
    public void setTamanoDeLaPoblacion(int tamanoDeLaPoblacion) {
        this.tamanoDeLaPoblacion = tamanoDeLaPoblacion;
    }

    /**
     * Regresa el tama&ntilde;o de la poblaci&oacute;n.
     *
     * @return tama&ntilde;o de la poblaci&oacute;n
     */
    public int getTamanoDeLaPoblacion() {
        return tamanoDeLaPoblacion;
    }

    /**
     * Establece la piscina de cromosomas.
     *
     * @param piscinaDeCromosomas a establecer
     */
    public void setPiscinaDeCromosomas(PiscinaDeCromosomas piscinaDeCromosomas) {
        this.piscinaDeCromosomas = piscinaDeCromosomas;
    }

    /**
     * Regresa la piscina de cromosomas.
     *
     * @return piscina de cromosomas
     */
    public PiscinaDeCromosomas getPiscinaDeCromosomas() {
        return piscinaDeCromosomas;
    }

    /**
     * Agrega un selector natural a la lista de selectores naturales.
     *
     * @param selectorNatural a agregar en la lista de selectores naturales
     */
    public void agregarSelectorNatural(SelectorNatural selectorNatural) {
        selectores.add(selectorNatural);
    }

    /**
     * Regresa la funcion de evaluaci&oacute;n.
     *
     * @return funcion de evaluaci&oacute;n
     */
    public FuncionDeEvaluacion getFuncionDeEvaluacion() {
        return funcionDeEvaluacion;
    }

    /**
     * Establece la funci&oacute;n de evaluaci&oacute;n.
     *
     * @param funcionDeEvaluacion funcion de evaluaci&oacute;n a ser usado
     */
    public void setFuncionDeEvaluacion(
            FuncionDeEvaluacion funcionDeEvaluacion) {
        this.funcionDeEvaluacion = funcionDeEvaluacion;
    }

    /**
     * Incrementa el n&uacute;mero de generaciones actuales.
     */
    public void incrementarNumeroDeGeneracionesActuales() {
        numeroDeGeneracionesActuales++;
    }

    /**
     * Regresa el n&uacute;mero de generaciones actuales.
     *
     * @return n&uacute;mero de generaciones actuales
     */
    public int getNumeroDeGeneracionesActuales() {
        return numeroDeGeneracionesActuales;
    }

    /**
     * Establece el reproductor de este algoritmo gen&eacute;tico.
     *
     * @param reproductor el reproductor de este algoritmo gen&eacute;tico
     */
    public void setReproductor(Reproductor reproductor) {
        this.reproductor = reproductor;
    }

    /**
     * Regresa el reproductor de este algoritmo gen&eacute;tico.
     *
     * @return el reproductor de este algoritmo gen&eacute;tico.
     */
    public Reproductor getReproductor() {
        return reproductor;
    }

    /**
     * Establece el porcentaje de mutaci&oacute;n del algoritmo gen&eacute;tico.
     *
     * @param porcentajeDeMutacion porcentaje de mutaci&oacute;n
     */
    public void setPorcentajeDeMutacion(double porcentajeDeMutacion) {
        this.porcentajeDeMutacion = porcentajeDeMutacion;
    }

    /**
     * Regresa el porcentaje de mutaci&oacute;n del algoritmo gen&eacute;tico.
     *
     * @return porcentaje de mutaci&oacute;n
     */
    public double getPorcentajeDeMutacion() {
        return this.porcentajeDeMutacion;
    }

    /**
     * Regresa el numero de cromosomas que seran ingresados a la piscina de
     * cromosomas para ser reproducidos.
     *
     * @return numero de cromosomas a reproducir
     */
    public int getNumeroDeCromosomasAReproducir() {
        return numeroDeCromosomasAReproducir;
    }

    /**
     * Establece el numero de cromosomas que seran ingresados a la piscina de
     * cromosomas para ser reproducidos.
     *
     * @param numeroDeCromosomasAReproducir numero de cromosomas a reproducir
     */
    public void setNumeroDeCromosomasAReproducir(
            int numeroDeCromosomasAReproducir) {
        this.numeroDeCromosomasAReproducir = numeroDeCromosomasAReproducir;
    }

    /**
     * Establece el porcentaje de cruce del algoritmo gen&eacute;tico.
     *
     * @param porcentajeDeCruce porcentaje de cruce
     */
    public void setPorcentajeDeCruce(double porcentajeDeCruce) {
        this.porcentajeDeCruce = porcentajeDeCruce;
    }

    /**
     * Regresa el porcentaje de cruce del algoritmo gen&eacute;tico.
     *
     * @return porcentaje de cruce
     */
    public double getPorcentajeDeCuce() {
        return porcentajeDeCruce;
    }
}
