/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logica_implementacion;

import java.util.List;
import logica.Cromosoma;
import logica.Gen;
import logica.OperadorGenetico;

/**
 * Operador de mutación del algoritmo genético. Tiene en cuenta que la
 * soluci&oacute;n depende de cada valor de los genes en el cromosoma.
 */
public class OperadorDeMutacionIngenuo implements OperadorGenetico {

    /**
     * Recursos del algoritmo gen&eacute;tico.
     */
    private Recursos recursos;

    /**
     * TODO. Vea la interface de OperadorGenetico para esta descripci&oacute;n.
     * Supone que el operador de cruce ha sido usado, por lo que los cromosomas
     * candidatos contienen los cromosomas descendientes del cruce.
     *
     * @param piscinaDeCromosomas
     */
    @Override
    public void operar(PiscinaDeCromosomas piscinaDeCromosomas) {

        if (piscinaDeCromosomas.tamano() < 1) {
            //No se ha empleado el operador de cruce.

            /**
             * TODO. Borrar la impresion de linea.
             */
            System.out.println("No se ha aplicado el operador de cruce");
            return;
        }

        double porcentajeDeMutacion = recursos.getPorcentajeDeMutacion();
        int numeroDeCromosomas = piscinaDeCromosomas.tamano();
        int numeroDeGenesPorCromosoma = 0;
        if (numeroDeCromosomas > 0) {
            numeroDeGenesPorCromosoma = ((Cromosoma) piscinaDeCromosomas.getCromosomas()
                    .get(0)).tamano();
        }
        int numeroDeGenesAMutar = (int) porcentajeDeMutacion
                * numeroDeCromosomas * numeroDeGenesPorCromosoma;
        List cromosomas = piscinaDeCromosomas.getCromosomas();
        for (int i = 0; i < numeroDeGenesAMutar; i++) {
            int posicionCromosomaAleatorio = (int) (Math.random()
                    * numeroDeCromosomas);
            int posicionGenAleatorio = (int) (Math.random()
                    * numeroDeGenesPorCromosoma);
            /*Cromosoma nuevoCromosoma = ((Cromosoma) cromosomas
                    .get(posicionCromosomaAleatorio)).clonar();*/
            Gen genes[] = ((Cromosoma) cromosomas
                    .get(posicionCromosomaAleatorio)).getGenes();

            genes[posicionGenAleatorio].setAValorAleatorio();

            //cromosomasCandidatos.add(nuevoCromosoma);
        }
    }

    public void setRecursos(Recursos recursos) {
        this.recursos = recursos;
    }

    public Recursos getRecursos() {
        return this.recursos;
    }
}
