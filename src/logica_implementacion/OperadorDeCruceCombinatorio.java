package logica_implementacion;

import java.util.ArrayList;
import java.util.List;
import logica.Cromosoma;
import logica.Gen;
import logica.OperadorGenetico;

/**
 * Operador de mutación del algoritmo genético. Tiene en cuenta que la
 * soluci&oacute;n depende de la posici&oacute;n de los genes en el cromosoma.
 * Operador de cruce por orden.
 */
public class OperadorDeCruceCombinatorio implements OperadorGenetico {

    /**
     * Cruza los cromosomas en la piscina de cromosomas dejando en esta solo los
     * descendientes de dicho cruce. Vea la interface OperadorGenetico para esta
     * descripci&oacute;n.
     */
    @Override
    public void operar(PiscinaDeCromosomas piscinaDeCromosomas) {
        int numeroDeCruces = piscinaDeCromosomas.tamano();
        for (int i = 0; i < numeroDeCruces; i++) {
            int posPadre = (int) (Math.random() * numeroDeCruces);
            int posMadre = posPadre;
            while (posMadre == posPadre) {
                posMadre = (int) (Math.random() * numeroDeCruces);
            }
            Cromosoma cromosomasPadre = piscinaDeCromosomas.getCromosoma(
                    posPadre);
            Cromosoma cromosomasMadre = piscinaDeCromosomas.getCromosoma(
                    posMadre);
            cruzar(cromosomasPadre, cromosomasMadre);
        }
    }

    private void cruzar(Cromosoma cromosomasPadre, Cromosoma cromosomasMadre) {
        Gen genesPadre[] = cromosomasPadre.getGenes();
        Gen genesMadre[] = cromosomasMadre.getGenes();

        //Se eligen dos posiciones, una que puede ir desde 1 hasta antes de la
        //mitad del tamano de los cromosomas, y la otra puede ir desde la mitad
        //del tamano de los cromosomas hasta el tamano de los cromosomas menos
        //uno. Es como partir cada cromosoma en tres partes donde se garantizar
        //la existencia de al menos un gen en la mitad, al menos uno al
        //principio y al menos uno al final.
        int posAleatoriaMenor = (int) (Math.random()
                * ((1 + (int) (genesPadre.length / 2)) - 2)) + 1;
        int posAleatoriaMayor = (int) (Math.random()
                * ((1 + (int) (genesPadre.length / 2)) - 2)) + 1;

        if (genesPadre.length % 2 != 0) {
            posAleatoriaMayor += (int) (genesPadre.length / 2);
        } else {
            posAleatoriaMayor += (int) (genesPadre.length / 2) - 1;
            if (posAleatoriaMayor != (genesPadre.length - 2)) {
                posAleatoriaMayor++;
            }
        }
        
        List<Gen> genesTempPadre = new ArrayList<>();
        List<Gen> genesTempMadre = new ArrayList<>();
        int puntero = posAleatoriaMayor;
        for (int i = 0; i < genesPadre.length; i++) {
            if (puntero >= genesPadre.length) {
                puntero = 0;
            }
            genesTempPadre.add(genesPadre[puntero]);
            genesTempMadre.add(genesMadre[puntero]);
            puntero++;
        }

        //Se intercambian los genes del medio
        for (int i = (posAleatoriaMenor + 1); i < posAleatoriaMayor; i++) {
            Gen genTemporal = genesPadre[i];
            genesPadre[i] = genesMadre[i];
            genesMadre[i] = genTemporal;
        }

        
    }
}
