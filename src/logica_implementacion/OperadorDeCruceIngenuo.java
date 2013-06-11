package logica_implementacion;

import logica.Cromosoma;
import logica.Gen;
import logica.OperadorGenetico;

/**
 * Operador de cruce del algoritmo genético. Tiene en cuenta que la
 * soluci&oacute;n depende de cada valor de los genes en el cromosoma.
 */
public class OperadorDeCruceIngenuo implements OperadorGenetico {

    private Recursos recursos;
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
        int posAleatoria = (int) (Math.random() * (genesPadre.length - 2)) + 1;
        for (int i = 0; i < genesPadre.length; i++) {
            if (i <= posAleatoria) {
                Gen genTemporal = genesPadre[i];
                genesPadre[i] = genesMadre[i];
                genesMadre[i] = genTemporal;
            }
        }
    }

    @Override
    public void setRecursos(Recursos recursos) {
        this.recursos = recursos;
    }

    @Override
    public Recursos getRecursos() {
        return recursos;
    }
}
