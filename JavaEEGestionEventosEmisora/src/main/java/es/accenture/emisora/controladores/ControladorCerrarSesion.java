package es.accenture.emisora.controladores;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Controlador encargado de gestionar
 * el cierre de sesion del usuario.
 * 
 * @author manu_
 */
public class ControladorCerrarSesion implements IControlador {

    /**
     * Procesa la peticion de cierre de sesion.
     * 
     * @param request Peticion HTTP
     * @param response Respuesta HTTP
     * @return Vista a la que se redirige
     */
    @Override
    public String procesarPeticion(HttpServletRequest request,
                                   HttpServletResponse response) {

        request.getSession().invalidate();

        return "Login.jsp";
    }
}
