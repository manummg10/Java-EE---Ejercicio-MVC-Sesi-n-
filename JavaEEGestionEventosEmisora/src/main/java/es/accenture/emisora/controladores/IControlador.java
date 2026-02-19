package es.accenture.emisora.controladores;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Interfaz que define el metodo para procesar
 * las peticiones HTTP en los controladores.
 * 
 * @author manu_
 */
public interface IControlador {

    /**
     * Procesa la peticion HTTP recibida.
     * 
     * @param request Peticion HTTP
     * @param response Respuesta HTTP
     * @return Vista a la que se redirige
     */
    String procesarPeticion(HttpServletRequest request,
                            HttpServletResponse response);
}