package logica_implementacion;

import java.util.ArrayList;
import java.util.Iterator;
import logica.Cromosoma;
import logica.FuncionDeAptitud;
import logica.Gen;

/**
 * Funcion que calcula el valor de aptitud en un cromosoma. Tiene en cuenta que
 * la soluci&oacute;n depende de la posici&oacute;n de los genes en el
 * cromosoma.
 */
public class FuncionDeAptitudCombinatoria extends FuncionDeAptitud {

    /**
     * Vea la interface de FuncionDeAptitud para esta descripci&oacute;n.
     *
     * @param cromosoma
     * @return
     */
    @Override
    public double evaluar(Cromosoma cromosoma) {
        int numeroDeGenes = cromosoma.tamano();
        Gen genes[] = cromosoma.getGenes();
        ArrayList sumasPorLista = new ArrayList((numeroDeGenes * 2) + 2);

        for (int i = 0; i < numeroDeGenes; i++) {
            for (int j = 0; j < numeroDeGenes; j++) {
                int pos = (i - 1) * numeroDeGenes + j;
                if (i == j) {
                    sumasPorLista.set((2 * numeroDeGenes),
                            (((Integer) sumasPorLista.get(2 * numeroDeGenes)).intValue()
                            + ((Integer) genes[pos].getAlelo()).intValue()));
                }
                if (i == ((numeroDeGenes - 1) - j)) {
                    sumasPorLista.set((2 * numeroDeGenes) + 1,
                            (((Integer) sumasPorLista.get((2 * numeroDeGenes) + 1)).intValue() + ((Integer) genes[pos].getAlelo()).intValue()));
                }
                sumasPorLista.set(i,
                        (((Integer) sumasPorLista.get(i)).intValue()
                        + ((Integer) genes[pos].getAlelo()).intValue()));

                sumasPorLista.set(numeroDeGenes + j,
                        (((Integer) sumasPorLista.get(numeroDeGenes
                        + j)).intValue() + ((Integer) genes[pos].getAlelo()).intValue()));
            }
        }

        ArrayList sumasPorListaSinRepetir = new ArrayList((numeroDeGenes * 2) + 2);
        for (int i = 0; i < sumasPorLista.size(); i++) {
            if (!sumasPorListaSinRepetir.contains(sumasPorLista.get(i))) {
                sumasPorListaSinRepetir.add(sumasPorLista.get(i));
            }
        }

        double p = (((numeroDeGenes * 2) + 1) + sumasPorListaSinRepetir.size())
                / ((numeroDeGenes * 2) + 2);

        return p;
    }

    /**
     * Vea la interface de FuncionDeAptitud para esta descripci&oacute;n.
     *
     * @param poblacion
     * @param funcionDeAptitud
     */
    @Override
    public void evaluar(Poblacion poblacion) {
        Iterator iteradorCromosomas = poblacion.getIterator();
        Cromosoma cromosoma;
        while (iteradorCromosomas.hasNext()) {
            cromosoma = (Cromosoma) iteradorCromosomas.next();
            double valorDeAptitud = this.getValorDeAptitud(cromosoma);
            cromosoma.setValorDeAptitud(valorDeAptitud);
        }
    }
}
