package es.accenture.emisora.controladores;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import es.accenture.emisora.entidades.Usuario;
import es.accenture.emisora.excepciones.ExcepcionPropia;
import es.accenture.emisora.modelos.ModeloUsuario;

/**
 * Controlador encargado de gestionar
 * el inicio de sesion del usuario.
 * 
 * @author manu_
 */
public class ControladorIniciarSesion implements IControlador {

    private DataSource ds;

    /**
     * Constructor del controlador.
     * 
     * @param ds DataSource para la conexion a la base de datos
     */
    public ControladorIniciarSesion(DataSource ds) {
        this.ds = ds;
    }

    /**
     * Procesa la peticion de inicio de sesion.
     * 
     * @param request Peticion HTTP
     * @param response Respuesta HTTP
     * @return Vista a la que se redirige
     */
    @Override
    public String procesarPeticion(HttpServletRequest request,
                                   HttpServletResponse response) {

        String usuario = request.getParameter("usuario").trim();
        String password = request.getParameter("password").trim();

        if (usuario == null || usuario.isEmpty() ||
            password == null || password.isEmpty()) {

            request.setAttribute("error",
                    "Usuario/Password son obligatorios");

            return "Login.jsp";
        }

        ModeloUsuario modelo = new ModeloUsuario(ds);

        try {

            Usuario u = modelo.getUsuario(usuario, password);

            request.getSession().setAttribute("datosUsuario", u);

            return "WEB-INF/BuscarEventos.jsp";

        } catch (ExcepcionPropia e) {

            request.setAttribute("error",
                    "Usuario/Password incorrecta");

            return "Login.jsp";
        }
    }
}