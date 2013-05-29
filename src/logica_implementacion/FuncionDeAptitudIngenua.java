package logica_implementacion;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import logica.Cromosoma;
import logica.FuncionDeAptitud;
import logica.Gen;

public class FuncionDeAptitudIngenua extends FuncionDeAptitud {

    /**
     * TODO. Vea la interface de FuncionDeAptitud para esta descripci&oacute;n.
     *
     * @param cromosoma
     * @return
     */
    @Override
    public double evaluar(Cromosoma cromosoma) {
        int numeroDeGenes = cromosoma.tamano();
        List genes = new ArrayList(cromosoma.getListaDeGenes().size());
        for (int i = 0; i < genes.size(); i++) {
            Gen nuevoGen = ((Gen) cromosoma.getListaDeGenes().get(i))
                    .nuevoGen();
            nuevoGen.setAlelo(((Gen) cromosoma.getListaDeGenes().get(i))
                    .getAlelo());
            genes.set(i, nuevoGen);
        }
        HashSet hashSet1 = new HashSet();
        hashSet1.addAll(genes);
        genes.clear();
        genes.addAll(hashSet1);

        double p1 = genes.size() / numeroDeGenes;

        ArrayList sumasPorLista = new ArrayList((numeroDeGenes * 2) + 2);
        for (int i = 0; i < numeroDeGenes; i++) {
            for (int j = 0; j < numeroDeGenes; j++) {
                int pos = (i - 1) * numeroDeGenes + j;
                if (i == j) {
                    sumasPorLista.set((2 * numeroDeGenes),
                            ((Integer) sumasPorLista
                            .get(2 * numeroDeGenes)).intValue()
                            + ((Integer) genes.get(pos)).intValue());
                }
                if (i == ((numeroDeGenes - 1) - j)) {
                    sumasPorLista.set((2 * numeroDeGenes) + 1,
                            ((Integer) sumasPorLista
                            .get((2 * numeroDeGenes) + 1))
                            .intValue() + ((Integer) genes.get(pos))
                            .intValue());
                }
                sumasPorLista.set(i, ((Integer) sumasPorLista.get(i))
                        .intValue() + ((Integer) genes.get(pos))
                        .intValue());
                sumasPorLista.set(numeroDeGenes + j,
                        ((Integer) sumasPorLista.get(numeroDeGenes + j))
                        .intValue() + ((Integer) genes.get(pos))
                        .intValue());
            }
        }
        HashSet hashSet2 = new HashSet();
        hashSet2.addAll(sumasPorLista);

        double p2 = (((numeroDeGenes * 2) + 1) + hashSet2.size())
                / ((numeroDeGenes * 2) + 2);

        return p1 + p2;
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
