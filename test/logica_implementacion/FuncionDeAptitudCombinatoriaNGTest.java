package logica_implementacion;

import logica.Cromosoma;
import logica.Gen;
import static org.testng.Assert.*;
import org.testng.annotations.Test;

/**
 * Clase de prueba para FuncionDeAptitudCombinatoria.
 */
public class FuncionDeAptitudCombinatoriaNGTest {
    
    public FuncionDeAptitudCombinatoriaNGTest() {
    }
    
    @Test
    public void testEvaluar_Cromosoma() {
        Cromosoma cromosomaInicial = new CromosomaImpl(9);

        int cromPrueba[] = {5,9,2,8,1,7,6,4,3};
        for (int i = 0; i < cromPrueba.length; i++) {
            Gen genEntero = new GenEntero(1, 9);
            genEntero.setAlelo(cromPrueba[i]);
            cromosomaInicial.setGen(i, genEntero);
        }
        FuncionDeAptitudCombinatoria instance = new FuncionDeAptitudCombinatoria();
        double resultadoEsperado = 0.25;
        double resultado= instance.evaluar(cromosomaInicial);
        assertEquals(resultado, resultadoEsperado, 0.0);
    }
}
