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

        double p = (double) (((tamanoDeCuadro * 2) + 2) - sumasPorListaSinRepetir.size())
                / (double) ((tamanoDeCuadro * 2) + 2);

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
