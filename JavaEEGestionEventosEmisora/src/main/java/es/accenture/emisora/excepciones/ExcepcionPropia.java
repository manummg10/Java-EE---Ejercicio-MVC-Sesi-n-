package es.accenture.emisora.excepciones;

import java.sql.SQLException;

/**
 * Clase de excepcion personalizada para la aplicacion.
 * Se utiliza para gestionar errores relacionados con
 * el login, campos obligatorios y ausencia de eventos.
 * 
 * @author manu_
 */
public class ExcepcionPropia extends Exception {

    /**
     * Identificador de version de la clase.
     */
    private static final long serialVersionUID = 1L;

    /**
     * Mensaje de error para login incorrecto.
     */
    public static final String ERROR_LOGIN = "Usuario/Password incorrecta";

    /**
     * Mensaje de error para campos obligatorios.
     */
    public static final String ERROR_OBLIGATORIO = "Usuario/Password son obligatorios";

    /**
     * Mensaje de error cuando no hay eventos disponibles.
     */
    public static final String ERROR_NO_EVENTOS = "No hay resultados";

    /**
     * Constructor de la excepcion personalizada.
     * 
     * @param mensaje Mensaje de error
     * @param e Excepcion SQL original
     */
    public ExcepcionPropia(String mensaje, SQLException e) {
        super(mensaje);
    }
}
