package es.accenture.emisora.controladores;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Controlador encargado de volver
 * a la pagina de busqueda de eventos.
 * 
 * @author manu_
 */
public class ControladorVolver implements IControlador {

    /**
     * Procesa la peticion para volver
     * a la pagina de busqueda.
     * 
     * @param request Peticion HTTP
     * @param response Respuesta HTTP
     * @return Vista a la que se redirige
     */
    @Override
    public String procesarPeticion(HttpServletRequest request,
                                   HttpServletResponse response) {

        return "WEB-INF/BuscarEventos.jsp";
    }
}
