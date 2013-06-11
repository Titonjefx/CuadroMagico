package logica_implementacion;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import logica.Cromosoma;
import logica.FuncionDeAptitud;
import logica.Gen;

/**
 * Funcion que calcula el valor de aptitud en un cromosoma. Tiene en cuenta que
 * la soluci&oacute;n depende de cada valor de los genes en el cromosoma.
 */
public class FuncionDeAptitudIngenua extends FuncionDeAptitud {

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
        List<Integer> alelosSinRepetir = new ArrayList();
        for (int i = 0; i < numeroDeGenes; i++) {
            if (!alelosSinRepetir.contains((Integer) genes[i].getAlelo())) {
                alelosSinRepetir.add((Integer) genes[i].getAlelo());
            }
        }
        double p1 = (double) alelosSinRepetir.size() / (double) numeroDeGenes;

        int tamanoDeCuadro = (int) (Math.sqrt(numeroDeGenes));

        int sumasPorLista[] = new int[((tamanoDeCuadro * 2) + 2)];

        for (int i = 0; i < tamanoDeCuadro; i++) {
            for (int j = 0; j < tamanoDeCuadro; j++) {
                int pos = (i * tamanoDeCuadro) + j;
                if (i == j) {
                    sumasPorLista[(2 * tamanoDeCuadro)] =
                            ((sumasPorLista[2 * tamanoDeCuadro])
                            + ((Integer) genes[pos].getAlelo()).intValue());
                }
                if (i == ((tamanoDeCuadro - 1) - j)) {
                    sumasPorLista[(2 * tamanoDeCuadro) + 1] =
                            ((sumasPorLista[(2 * tamanoDeCuadro) + 1]) + ((Integer) genes[pos].getAlelo()).intValue());
                }
                sumasPorLista[i] =
                        ((sumasPorLista[i])
                        + ((Integer) genes[pos].getAlelo()).intValue());

                sumasPorLista[tamanoDeCuadro + j] =
                        ((sumasPorLista[tamanoDeCuadro
                        + j]) + ((Integer) genes[pos].getAlelo()).intValue());
            }
        }

        ArrayList sumasPorListaSinRepetir = new ArrayList();
        for (int i = 0; i < sumasPorLista.length; i++) {
            if (!sumasPorListaSinRepetir.contains(sumasPorLista[i])) {
                sumasPorListaSinRepetir.add(sumasPorLista[i]);
            }
        }

        double p2 = (double) (((tamanoDeCuadro * 2) + 2) - sumasPorListaSinRepetir.size())
                / (double) ((tamanoDeCuadro * 2) + 2);

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
