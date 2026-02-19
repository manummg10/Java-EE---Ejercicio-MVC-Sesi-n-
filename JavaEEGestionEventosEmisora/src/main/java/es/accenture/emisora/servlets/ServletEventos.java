package es.accenture.emisora.servlets;

import java.io.IOException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import es.accenture.emisora.controladores.ControladorBuscarEventos;
import es.accenture.emisora.controladores.ControladorCerrarSesion;
import es.accenture.emisora.controladores.ControladorIniciarSesion;
import es.accenture.emisora.controladores.ControladorVolver;
import es.accenture.emisora.controladores.IControlador;

/**
 * Servlet principal que gestiona las peticiones relacionadas
 * con los eventos y el inicio o cierre de sesion.
 * Se encarga de redirigir las acciones a los diferentes
 * controladores segun la accion recibida.
 * 
 * @author manu_
 */
@WebServlet("/ServletEventos")
public class ServletEventos extends HttpServlet {

    /**
     * Identificador de version de la clase.
     */
    private static final long serialVersionUID = 1L;

    private DataSource ds;

    /**
     * Metodo de inicializacion del servlet.
     * Obtiene el DataSource para la conexion a la base de datos.
     * 
     * @throws ServletException Si ocurre un error en el contexto
     */
    @Override
    public void init() throws ServletException {
        try {
            Context ctx = new InitialContext();
            ds = (DataSource) ctx.lookup("java:comp/env/jdbc/festivaldb2");
            System.out.println("DataSource encontrada: " + (ds != null));
        } catch (NamingException e) {
            throw new ServletException(e);
        }
    }

    /**
     * Metodo que gestiona las peticiones POST.
     * Determina la accion a realizar y delega
     * en el controlador correspondiente.
     * 
     * @param request Peticion HTTP
     * @param response Respuesta HTTP
     * @throws ServletException Si ocurre un error en el servlet
     * @throws IOException Si ocurre un error de entrada o salida
     */
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        String accion = request.getParameter("accion");
        IControlador controlador = null;

        switch (accion) {
            case "login":
                controlador = new ControladorIniciarSesion(ds);
                break;
            case "logout":
                controlador = new ControladorCerrarSesion();
                break;
            case "buscar":
                controlador = new ControladorBuscarEventos(ds);
                break;
            case "volver":
                controlador = new ControladorVolver();
                break;
        }

        String vista = controlador.procesarPeticion(request, response);
        request.getRequestDispatcher(vista).forward(request, response);
    }

    /**
     * Metodo que gestiona las peticiones GET.
     * Redirige las peticiones al metodo doPost.
     * 
     * @param request Peticion HTTP
     * @param response Respuesta HTTP
     * @throws ServletException Si ocurre un error en el servlet
     * @throws IOException Si ocurre un error de entrada o salida
     */
    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        doPost(request, response);
    }
}