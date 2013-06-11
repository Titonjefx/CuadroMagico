package logica_implementacion;

import logica.Cromosoma;
import logica.Gen;
import org.testng.annotations.Test;

/**
 * Clase de prueba para OperadorDeCruceCombinatorio.
 */
public class OperadorDeCruceCombinatorioNGTest {
    
    public OperadorDeCruceCombinatorioNGTest() {
    }

    @Test
    public void testCruzar() {
        Cromosoma cromosomaInicial1 = new CromosomaImpl(9);
        Cromosoma cromosomaInicial2 = new CromosomaImpl(9);

        int cromPrueba1[] = {4,2,1,9,5,3,7,8,6};
        int cromPrueba2[] = {5,9,2,8,1,7,6,4,3};
        for (int i = 0; i < cromPrueba1.length; i++) {
            Gen genEntero1 = new GenEntero(1, 9);
            genEntero1.setAlelo(cromPrueba1[i]);
            cromosomaInicial1.setGen(i, genEntero1);
            Gen genEntero2 = new GenEntero(1, 9);
            genEntero2.setAlelo(cromPrueba2[i]);
            cromosomaInicial2.setGen(i, genEntero2);
        }
        for (int i = 0; i < cromosomaInicial1.tamano(); i++) {
            System.err.print(cromosomaInicial1.getGen(i).getAlelo());
        }
        System.err.println();
        System.err.println("-----------");
        for (int i = 0; i < cromosomaInicial2.tamano(); i++) {
            System.err.print(cromosomaInicial2.getGen(i).getAlelo());
        }
        System.err.println();
        System.err.println("**************************");
        OperadorDeCruceCombinatorio instance = new OperadorDeCruceCombinatorio();
        instance.cruzar(cromosomaInicial1, cromosomaInicial2);
        for (int i = 0; i < cromosomaInicial1.tamano(); i++) {
            System.err.print(cromosomaInicial1.getGen(i).getAlelo());
        }
        System.err.println();
        System.err.println("-----------");
        for (int i = 0; i < cromosomaInicial2.tamano(); i++) {
            System.err.print(cromosomaInicial2.getGen(i).getAlelo());
        }
    }
    
    @Test
    public void testContiene(){
        System.out.println("contiene");
        Gen genes[] = new Gen[9];
        int cromPrueba[] = {0,0,1,9,5,3,7,0,0};
        for (int i = 0; i < cromPrueba.length; i++) {
            Gen genEntero = new GenEntero(1, 9);
            genEntero.setAlelo(new Integer(cromPrueba[i]));
            genes[i] = genEntero;
        }
        Gen genPrueba = new GenEntero(1, 9);
        genPrueba.setAlelo(8);
        OperadorDeCruceCombinatorio instance = new OperadorDeCruceCombinatorio();
        System.err.println(instance.contiene(genes, new Integer(7)));
    }
}
