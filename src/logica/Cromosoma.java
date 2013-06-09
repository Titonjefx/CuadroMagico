package logica;

/**
 * Interfaz que define los metodos que debe implementar un Cromosoma
 * determinado.
 */
public interface Cromosoma {

    /**
     * Regresa el Gen en el indice indicado.
     *
     * @param indice posici&oacute;n del Gen a retornar
     * @return Gen en el indice indicado
     */
    Gen getGen(int indice);

    /**
     * Regresa los genes de este cromosoma.
     *
     * @return Arreglo de Genes de este cromosoma
     */
    Gen[] getGenes();

    /**
     * Establece todos los genes contenidos en este cromosoma.
     *
     * @param genes para este cromosoma
     */
    void setGenes(Gen[] genes);

    /**
     * Establece el gen en determinada posici&oacute;n.
     *
     * @param posicion se establece el gen en esta posicion
     * @param gen gen a establecer
     */
    void setGen(int indice, Gen gen);

    /**
     * N&uacute;mero de Genes que contiene este cromosoma.
     *
     * @return tamano de este cromosoma (n&uacute;mero de genes)
     */
    int tamano();

    /**
     * Establece el valor de aptitud de este Cromosoma.
     *
     * @param valorDeAptitud valor de aptitud a establecer en este cromosoma
     */
    void setValorDeAptitud(double valorDeAptitud);

    /**
     * Regresa el valor de aptitud de este Cromosoma.
     *
     * @return valor de aptitud de este cromosoma
     */
    double getValorDeAptitud();

    /**
     * Establece si este Cromosoma es seleccionado para la pr&oacute;xima
     * generaci&oacute;n.
     *
     * @param esSeleccionado true si es seleccionado, false de lo contrario
     */
    void setEsSeleccionadoParaLaSiguienteGeneracion(boolean esSeleccionado);

    /**
     * Informa si este Cromosoma es seleccionado para la pr&oacute;xima
     * generaci&oacute;n.
     *
     * @return true si es seleccionado, false de lo contrario
     */
    boolean esSeleccionadoParaLaSiguienteGeneracion();

    /**
     * Incrementa la edad del cromosoma actual; la edad es el n&uacute;mero de
     * veces que ha pasado de generaci&oacute;n en generaci&oacute;n.
     */
    void incrementarEdad();

    /**
     * Restablece la edad del cromosoma actual a cero.
     */
    void restablecerEdad();

    /**
     * Establece la edad del cromosoma actual.
     *
     * @param edad edad a ser establecida para este cromosoma
     */
    void setEdad(int edad);

    /**
     * Regresa la edad de este cromosoma.
     *
     * @return edad de este cromosoma
     */
    int getEdad();

    /**
     * Incrementa en 1 el n&uacute;mero de operaciones aplicadas a este
     * cromosoma.
     */
    void incrementarNumeroDeOperacionesGeneticas();

    /**
     * Restablece el n&uacute;mero de operaciones aplicadas a este cromosoma a
     * cero.
     */
    void restablecerNumeroDeOperacionesGeneticas();

    /**
     * Regresa el n&uacute;mero de operaciones aplicadas a este cromosoma.
     *
     * @return n&uacute;mero de operaciones aplicadas a este cromosoma
     */
    int numeroDeOperacionesGeneticas();

    /**
     * Regresa true si este cromosoma ha sido evaluado. False de lo contrario.
     */
    boolean haSidoEvaluado();

    /**
     * Establece si este cromosoma ha sido evaluado.
     */
    void setHaSidoEvaluado(boolean haSidoEvaluado);

    /**
     * Crea un nuevo cromosoma con las mismas propiedades que este.
     */
    Cromosoma clonar();
}
