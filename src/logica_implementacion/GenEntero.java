package logica;

/**
 * Clase que representa a un Gen cuyos alelos son n&uacute;meros enteros.
 * implementa la interfaz Gen.
 *
 * @author Jhonderson
 */
public class GenEntero implements Gen {

    /**
     * El m&aacute;ximo valor posible representado por este gen.
     */
    private int limiteSuperior;
    /**
     * El m&iacute;nimo valor posible representado por este gen.
     */
    private int limiteInferior;
    /**
     * Valor interno de este Gen (alelo).
     */
    private Integer valorInterno;

    /**
     * Construye un gen entero con las propiedades por defecto.
     */
    public GenEntero() {
        this(Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    /**
     * Construye un nuevo gen con los limites especificados.
     *
     * @param unLimiteInferior l&iacute;mite inferior del gen
     * @param unLimiteSuperior l&iacute;mite superior del gen
     */
    public GenEntero(final int unLimiteInferior,
            final int unLimiteSuperior) {
        limiteInferior = unLimiteInferior;
        limiteSuperior = unLimiteSuperior;
    }

    /**
     * Vea la interface de Gen para esta descripci&oacute;n.
     */
    @Override
    public Gen nuevoGen() {
        GenEntero result = new GenEntero(limiteInferior,
                limiteSuperior);
        return result;
    }

    /**
     * Regresa el valor entero de este gen (int).
     *
     * @return valor entero de este gen.
     */
    public int intValue() {
        return ((Integer) getAlelo()).intValue();
    }

    /**
     * Cambia el valor interno de este Gen a un valor aleatorio entre el
     * l&iacute;mite inferior y el l&iacute;mite superior.
     */
    @Override
    public void setToRandomValue() {
        double valorAleatorio = ((long) limiteSuperior - (long) limiteInferior)
                * Math.random()
                + limiteInferior;
        setAlelo(new Integer((int) Math.round(valorAleatorio)));
    }

    /**
     * Vea la interface de Gen para esta descripci&oacute;n.
     */
    @Override
    public void aplicarMutacion() {
        double rango = ((long) limiteSuperior - (long) limiteInferior)
                * Math.random();
        if (getAlelo() == null) {
            setAlelo(new Integer((int) rango + limiteInferior));
        } else {
            int nuevoValor = (int) Math.round(intValue() + rango);
            setAlelo(new Integer(nuevoValor));
        }
    }

    /**
     * @return una representaci&oacute;n en texto de este gen.
     */
    @Override
    public String toString() {
        String s = "GenEntero(" + limiteInferior + "," + limiteSuperior + ")"
                + "=";
        if (getAlelo() == null) {
            s += "null";
        } else {
            s += getAlelo().toString();
        }
        return s;
    }

    /**
     * @return el l&iacute;mite inferior de este gen.
     */
    public int getLimiteInferior() {
        return limiteInferior;
    }

    /**
     * @return el l&iacute;mite superior de este gen.
     */
    public int getLimiteSuperior() {
        return limiteSuperior;
    }

    /**
     * Regresa el valor interno de este Gen.
     *
     * @return el valor interno de este gen.
     */
    @Override
    public Integer getAlelo() {
        return valorInterno;
    }

    /**
     * Modifica el valor interno de este Gen.
     *
     * @param unValorInterno valor nuevo para el valor interno de este Gen.
     */
    @Override
    public void setAlelo(Object unValorInterno) {
        valorInterno = (Integer) unValorInterno;
    }
}
