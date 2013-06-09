package logica_implementacion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import logica.Cromosoma;
import logica.FuncionDeEvaluacion;
import logica.Gen;

/**
 * Clase donde estar&aacute;n almacenados todos los cromosomas.
 */
public class Poblacion {

    /**
     * Arreglo de cromosomas de la poblaci&oacute;n.
     */
    private List<Cromosoma> cromosomas;
    /**
     * The fittest Chromosome of the population.
     */
    private Cromosoma mejorCromosoma;
    private Recursos recursos;
    private int tamanoDePoblacion;

    /**
     * Constructor.
     *
     * @param recursos referencia a la clase donde esta todo lo necesario para
     * que el algoritmo funcione
     * @param tamanoDeLaPoblacion tama&ntilde;o de la poblaci&oacute;n
     */
    public Poblacion(Recursos recursos, int tamanoDeLaPoblacion) {
        this.recursos = recursos;
        this.cromosomas = new ArrayList(tamanoDeLaPoblacion);
        this.tamanoDePoblacion = tamanoDeLaPoblacion;
    }

    public Poblacion(Recursos recursos, List cromosomas) {
        this.recursos = recursos;
        this.cromosomas = cromosomas;
        this.tamanoDePoblacion = cromosomas.size();
    }

    public void agregarCromosoma(Cromosoma cromosoma) {
        this.cromosomas.add(cromosoma);
        tamanoDePoblacion++;
    }

    public void agregarCromosomas(Poblacion poblacion) {
        this.cromosomas.addAll(poblacion.getCromosomas());
        tamanoDePoblacion += poblacion.getCromosomas().size();
    }

    public List getCromosomas() {
        return cromosomas;
    }

    public void setCromosomas(List cromosomas) {
        this.cromosomas = cromosomas;
        tamanoDePoblacion = cromosomas.size();
    }

    public Cromosoma getCromosoma(int indice) {
        return cromosomas.get(indice);
    }

    public void setCromosoma(int indice, Cromosoma cromosoma) {
        cromosomas.set(indice, cromosoma);
    }

    public int tamanoDePoblacion() {
        return tamanoDePoblacion;
    }

    public Iterator getIterator() {
        return cromosomas.iterator();
    }

    public Cromosoma[] aCromosomas() {
        return (Cromosoma[]) cromosomas.toArray(
                new Cromosoma[cromosomas.size()]);
    }

    public Cromosoma determinarMejorCromosoma() {
        Iterator iterador = cromosomas.iterator();
        FuncionDeEvaluacion evaluador = getRecursos().getFuncionDeEvaluacion();
        double mejorAptitud;

        //para determinar que es mejor, un valor de aptitud mayor
        //o uno menor
        if (evaluador.esMejor(2.0d, 1.0d)) {
            mejorAptitud = -1.0d;
        } else {
            mejorAptitud = Double.MAX_VALUE;
        }
        double aptitud;
        while (iterador.hasNext()) {
            Cromosoma cromosoma = (Cromosoma) iterador.next();
            aptitud = cromosoma.getValorDeAptitud();
            if (evaluador.esMejor(aptitud, mejorAptitud)
                    || mejorCromosoma == null) {
                mejorCromosoma = cromosoma;
                mejorAptitud = aptitud;
            }
        }
        return mejorCromosoma;
    }

    public Recursos getRecursos() {
        return recursos;
    }

    public void removerCromosoma(int indice) {
        cromosomas.remove(indice);
        tamanoDePoblacion--;
    }

    public void ordenarCromosomasPorAptitud() {
        Collections.sort(getCromosomas(), new Comparator() {
            @Override
            public int compare(final Object cromosoma1, final Object cromosoma2) {
                Cromosoma cromosomaUno = (Cromosoma) cromosoma1;
                Cromosoma cromosomaDos = (Cromosoma) cromosoma2;
                if (getRecursos().getFuncionDeEvaluacion().esMejor(cromosomaUno, cromosomaDos)) {
                    return -1;
                } else if (getRecursos().getFuncionDeEvaluacion().esMejor(cromosomaDos, cromosomaUno)) {
                    return 1;
                } else {
                    return 0;
                }
            }
        });
        mejorCromosoma = (Cromosoma) cromosomas.get(0);
    }
    
    public Cromosoma getMejorCromosoma() {
        ordenarCromosomasPorAptitud();
        return mejorCromosoma;
    }

    public void mantenerConstanteElTamanoDeLaPoblacion() {
        ordenarCromosomasPorAptitud();
        int tamanoMaximo = getRecursos().getTamanoDeLaPoblacion();

        while (tamanoDePoblacion > tamanoMaximo) {
            removerCromosoma(tamanoDePoblacion - 1);
            tamanoDePoblacion--;
        }
    }

    public void llenarPoblacion() {
        Cromosoma cromosomaMuestra = getRecursos().getCromosomaDeMuestra();
        for (int i = 0; i < tamanoDePoblacion; i++) {
            Cromosoma copia = cromosomaMuestra.clonar();
            Gen[] genes = copia.getGenes();
            Gen[] nuevosGenes = new Gen[genes.length];
            for (int j = 0; j < genes.length; j++) {
                nuevosGenes[j] = genes[j].nuevoGen();
                nuevosGenes[j].setAlelo(genes[j].getAlelo());
            }

            for (int j = 0; j < genes.length; j++) {
                //Intercambio de un gen con otro
                int pos1 = (int) (Math.random() * genes.length);
                int pos2 = (int) (Math.random() * genes.length);
                Gen gen = nuevosGenes[pos1];
                nuevosGenes[pos1] = nuevosGenes[pos2];
                nuevosGenes[pos2] = gen;
            }

            copia.setGenes(nuevosGenes);
            agregarCromosoma(copia);
        }
    }
}
