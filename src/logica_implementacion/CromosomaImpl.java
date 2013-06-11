package logica_implementacion;

import logica.Cromosoma;
import logica.FuncionDeAptitud;
import logica.Gen;

/**
 * Clase que representa un Cromosoma. Implementa la interfaz Cromosoma.
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
     * Representa si este cromosoma ha sido evaluado.
     */
    private boolean haSidoEvaluado = false;

    /**
     * Constructor.
     */
    public CromosomaImpl(int tamano) {
        genes = new Gen[tamano];
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
     * Vea la interface de Cromosoma para esta descripci&oacute;n.
     */
    @Override
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
        if (!haSidoEvaluado) {
            return this.calcularValorDeAptitud();
        }
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
     * Se establecen todos los genes de este cromosoma a partir de un gen
     * muestra.
     *
     * @param gen muestra con la que se establecen todos los genes de este
     * cromosoma.
     */
    protected void iniciarAPartirDeUnGen(Gen gen) {
        int tamano = tamano();
        for (int i = 0; i < tamano; i++) {
            Gen nuevoGen = gen.nuevoGen();
            nuevoGen.setAValorAleatorio();
            setGen(i, nuevoGen);
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

    @Override
    public Cromosoma clonar() {
        Cromosoma copia = new CromosomaImpl(tamano());
        copia.setEdad(getEdad());
        copia.setHaSidoEvaluado(haSidoEvaluado());
        copia.setValorDeAptitud(getValorDeAptitud());

        Gen nuevosGenes[] = new Gen[tamano()];
        for (int i = 0; i < tamano(); i++) {
            nuevosGenes[i] = getGen(i).nuevoGen();
            nuevosGenes[i].setAlelo(new Integer((int)getGen(i).getAlelo()));
        }
        
        copia.setGenes(nuevosGenes);

        return copia;
    }
}
