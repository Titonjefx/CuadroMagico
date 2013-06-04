package logica;

/**
 * Interfaz que define los metodos que debe implementar un Gen determinado.
 *
 * @author Jhonderson
 */
public interface Gen {

    /**
     * M&eacute;todo para crear nuevos genes con las mismas propiedades que
     * este.
     *
     * @return un nuevo Gen con las mismas propiedades que este.
     */
    Gen nuevoGen();

    /**
     * Modifica el valor actual de este gen..
     *
     * @param valor el nuevo valor del alelo
     */
    void setAlelo(Object valor);

    /**
     * M&eacute;todo para obtener el valor de este Gen.
     *
     * @return el valor de este Gen.
     */
    Object getAlelo();

    /**
     * Cambia el valor interno de este Gen a un valor aleatorio.
     */
    void setAValorAleatorio();

    /**
     * @return una representaci&oacute;n en texto de este Gen.
     */
    @Override
    String toString();
}
