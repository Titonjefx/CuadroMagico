package logica;

import logica_implementacion.Poblacion;
import logica_implementacion.Recursos;

/**
 * Define los m&eacute;todos que deben ser implementados en un reproductor
 * determinado.
 */
public interface Reproductor {

    Poblacion evolucionar(Poblacion poblacion, Recursos recursos);
}
