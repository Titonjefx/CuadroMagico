package logica_implementacion;

import java.util.List;
import logica.Cromosoma;
import logica.Gen;
import logica.OperadorGenetico;

/**
 * Operador de mutación del algoritmo genético. Tiene en cuenta que la
 * soluci&oacute;n depende de la posici&oacute;n de los genes en el cromosoma.
 */
public class OperadorDeMutacionCombinatorio implements OperadorGenetico {

    /**
     * Recursos del algoritmo gen&eacute;tico.
     */
    private Recursos recursos;

    /**
     * Operador que intercambia un gen con otro en determinado cromosoma. Supone
     * que el operador de cruce ha sido usado, por lo que los cromosomas
     * candidatos contienen los cromosomas descendientes del cruce.
     *
     * @param piscinaDeCromosomas
     */
    @Override
    public void operar(PiscinaDeCromosomas piscinaDeCromosomas) {

        if (piscinaDeCromosomas.tamano() < 1) {
            //No se ha empleado el operador de cruce.
            return;
        }
        double porcentajeDeMutacion = recursos.getPorcentajeDeMutacion();
        int numeroDeCromosomas = piscinaDeCromosomas.tamano();
        int numeroDeGenesPorCromosoma = 0;
        if (numeroDeCromosomas > 0) {
            numeroDeGenesPorCromosoma = ((Cromosoma) piscinaDeCromosomas.getCromosomas()
                    .get(0)).tamano();
        }
        int numeroDeGenesAMutar = (int) (porcentajeDeMutacion
                * numeroDeCromosomas * numeroDeGenesPorCromosoma);
        List cromosomas = piscinaDeCromosomas.getCromosomas();
        for (int i = 0; i < numeroDeGenesAMutar; i++) {

            int posicionCromosomaAleatorio = (int) (Math.random()
                    * numeroDeCromosomas);
            /*Cromosoma nuevoCromosoma = ((Cromosoma) cromosomas
                    .get(posicionCromosomaAleatorio)).clonar();*/
            Gen[] genes = ((Cromosoma) cromosomas
                    .get(posicionCromosomaAleatorio)).getGenes();

            //Intercambio de un gen con otro
            int pos1 = (int) (Math.random() * numeroDeGenesPorCromosoma);
            int pos2 = (int) (Math.random() * numeroDeGenesPorCromosoma);
            Gen gen = genes[pos1];
            genes[pos1] = genes[pos2];
            genes[pos2] = gen;
            
            //cromosomasCandidatos.add(nuevoCromosoma);
        }
    }

    @Override
    public void setRecursos(Recursos recursos) {
        this.recursos = recursos;
    }

    @Override
    public Recursos getRecursos() {
        return this.recursos;
    }
}
