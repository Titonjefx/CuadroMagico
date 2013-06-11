package logica_implementacion;

import logica.Cromosoma;
import logica.Gen;
import static org.testng.Assert.*;
import org.testng.annotations.Test;

/**
 * Clase de prueba para FuncionDeAptitudIngenua.
 */
public class FuncionDeAptitudIngenuaNGTest {
    
    public FuncionDeAptitudIngenuaNGTest() {
    }
    
    @Test
    public void testEvaluar_Cromosoma() {
        Cromosoma cromosomaInicial1 = new CromosomaImpl(9);
        Cromosoma cromosomaInicial2 = new CromosomaImpl(9);

        int cromPrueba1[] = {1, 2, 3, 2, 2, 2, 3, 2, 1};
        int cromPrueba2[] = {5,9,2,8,1,7,6,4,3};
        for (int i = 0; i < cromPrueba1.length; i++) {
            Gen genEntero1 = new GenEntero(1, 9);
            genEntero1.setAlelo(cromPrueba1[i]);
            cromosomaInicial1.setGen(i, genEntero1);
            Gen genEntero2 = new GenEntero(1, 9);
            genEntero2.setAlelo(cromPrueba2[i]);
            cromosomaInicial2.setGen(i, genEntero2);
        }
        FuncionDeAptitudIngenua instance = new FuncionDeAptitudIngenua();
        double expResult1 = 0.625 + (3.0/9.0);
        double result1 = instance.evaluar(cromosomaInicial1);
        double expResult2 = 1.25;
        double result2= instance.evaluar(cromosomaInicial2);
        assertEquals(result1, expResult1, 0.0);
        assertEquals(result2, expResult2, 0.0);
    }
}
