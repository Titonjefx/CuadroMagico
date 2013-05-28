package logica;

/**
 * Clase que representa un Cromosoma. Implementa la interfaz Cromosoma.
 *
 * @author Jhonderson
 */
public class CromosomaImpl implements Cromosoma {

    private Recursos recursos;
    /**
     * Arreglo de genes contenidos en este cromosoma.
     */
    private Gen[] genes;
    /**
     * Edad del cromosoma; se define en t&eacute;rminos de cuantas generaciones
     * ha recorrido.
     */
    private int edad;
    /**
     * Numero de operaciones gen&eacute;ticas que han sido aplicadas a este
     * cromosoma.
     */
    private int numeroDeOperacionesAplicadas;
    /**
     * Valor de aptitud de este cromosoma.
     */
    private double valorDeAptitud = -1.0000000d;
    /**
     * Valor que define si este cromosoma ser&aacute; seleccionado para la
     * pr&oacute;xima generaci&oacute;n.
     */
    private boolean esSeleccionadoParaLaSiguienteGeneracion;
    /**
     * Representa si este cromosoma ha sido evaluado.
     */
    private boolean haSidoEvaluado = false;

    /**
     * Constructor.
     */
    public CromosomaImpl() {
    }

    /**
     * Vea la interface de Cromosoma para esta descripci&oacute;n.
     */
    @Override
    public void incrementarEdad() {
        edad++;
    }

    /**
     * Vea la interface de Cromosoma para esta descripci&oacute;n.
     */
    @Override
    public void restablecerEdad() {
        edad = 0;
    }

    /**
     * Vea la interface de Cromosoma para esta descripci&oacute;n.
     */
    @Override
    public int getEdad() {
        return edad;
    }

    /**
     * Vea la interface de Cromosoma para esta descripci&oacute;n.
     */
    @Override
    public void setEdad(int edad) {
        this.edad = edad;
    }

    /**
     * Vea la interface de Cromosoma para esta descripci&oacute;n.
     */
    @Override
    public void incrementarNumeroDeOperacionesGeneticas() {
        numeroDeOperacionesAplicadas++;
    }

    /**
     * Vea la interface de Cromosoma para esta descripci&oacute;n.
     */
    @Override
    public void restablecerNumeroDeOperacionesGeneticas() {
        numeroDeOperacionesAplicadas = 0;
    }

    /**
     * Vea la interface de Cromosoma para esta descripci&oacute;n.
     */
    @Override
    public int numeroDeOperacionesGeneticas() {
        return numeroDeOperacionesAplicadas;
    }

    /**
     * Vea la interface de Cromosoma para esta descripci&oacute;n.
     */
    @Override
    public Gen[] getGenes() {
        return genes;
    }

    /**
     * Vea la interface de Cromosoma para esta descripci&oacute;n.
     */
    @Override
    public void setGenes(Gen[] genes) {
        this.genes = genes;
    }

    /**
     * Vea la interface de Cromosoma para esta descripci&oacute;n.
     */
    @Override
    public Gen getGen(int indice) {
        return genes[indice];
    }

    /**
     * Establece un nuevo gen en la posicion indicada.
     *
     * @param indice que indica la posici&oacute;n del gen a ser reemplazado
     * @param gen que se establecer&aacute; en la posici&oacute;n index
     */
    public void setGen(int indice, Gen gen) {
        genes[indice] = gen;
    }

    /**
     * Vea la interface de Cromosoma para esta descripci&oacute;n.
     */
    @Override
    public int tamano() {
        if (genes == null) {
            return 0;
        } else {
            return genes.length;
        }
    }

    /**
     * Vea la interface de Cromosoma para esta descripci&oacute;n.
     */
    @Override
    public void setValorDeAptitud(double valorDeAptitud) {
        this.valorDeAptitud = valorDeAptitud;
        haSidoEvaluado = true;
    }

    /**
     * Vea la interface de Cromosoma para esta descripci&oacute;n.
     */
    @Override
    public double getValorDeAptitud() {
        return this.valorDeAptitud;
    }

    /**
     * @return aptitud del cromosoma
     */
    protected double calcularValorDeAptitud() {
        if (getRecursos() != null) {
            FuncionDeAptitud funcionDeAptitud = getRecursos().
                    getFuncionDeAptitud();
            if (funcionDeAptitud != null) {
                valorDeAptitud = funcionDeAptitud.getValorDeAptitud(this);
                haSidoEvaluado = true;
            }
        }
        return valorDeAptitud;
    }

    /**
     * Vea la interface de Cromosoma para esta descripci&oacute;n.
     */
    @Override
    public void setEsSeleccionadoParaLaSiguienteGeneracion(
            boolean esSeleccionado) {
        this.esSeleccionadoParaLaSiguienteGeneracion = esSeleccionado;
    }

    /**
     * Vea la interface de Cromosoma para esta descripci&oacute;n.
     */
    @Override
    public boolean esSeleccionadoParaLaSiguienteGeneracion() {
        return this.esSeleccionadoParaLaSiguienteGeneracion;
    }

    /**
     * Se establecen todos los genes de este cromosoma a partir de un gen
     * muestra.
     *
     * @param gen muestra con la que se establecen todos los genes de este
     * cromosoma.
     */
    protected void iniciarAPartirDeUnGen(Gen gen) {
        int tamano = tamano();
        for (int i = 0; i < tamano; i++) {
            setGen(i, gen.nuevoGen());
        }
    }

    /**
     * Regresa la referencia a los recursos del algoritmo gen&eacute;tico que
     * posee este cromosoma.
     *
     * @return recursos del algoritmo gen&eacute;tico
     */
    public Recursos getRecursos() {
        return this.recursos;
    }

    /**
     * Establece la referencia a los recursos del algoritmo gen&etico que posee
     * este cromosoma.
     *
     * @param recursos recursos a ser establecidos
     */
    public void setRecursos(Recursos recursos) {
        this.recursos = recursos;
    }

    /**
     * Vea la interface de Cromosoma para esta descripci&oacute;n.
     */
    @Override
    public boolean haSidoEvaluado() {
        return this.haSidoEvaluado;
    }

    @Override
    public void setHaSidoEvaluado(boolean haSidoEvaluado) {
        this.haSidoEvaluado = haSidoEvaluado;
    }
}
