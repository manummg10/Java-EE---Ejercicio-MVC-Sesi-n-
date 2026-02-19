package es.accenture.emisora.controladores;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import es.accenture.emisora.entidades.Evento;
import es.accenture.emisora.excepciones.ExcepcionPropia;
import es.accenture.emisora.modelos.ModeloEvento;

/**
 * Controlador encargado de gestionar
 * la busqueda de eventos.
 * 
 * @author manu_
 */
public class ControladorBuscarEventos implements IControlador {

    private DataSource ds;

    /**
     * Constructor del controlador.
     * 
     * @param ds DataSource para la conexion a la base de datos
     */
    public ControladorBuscarEventos(DataSource ds) {
        this.ds = ds;
    }

    /**
     * Procesa la peticion de busqueda de eventos.
     * 
     * @param request Peticion HTTP
     * @param response Respuesta HTTP
     * @return Vista a la que se redirige
     */
    @Override
    public String procesarPeticion(HttpServletRequest request,
                                   HttpServletResponse response) {

        String criterio = request.getParameter("filtro");

        ModeloEvento modelo = new ModeloEvento(ds);

        try {
            List<Evento> lista;

            if (criterio == null || criterio.trim().isEmpty()) {
                lista = modelo.getEventos();
            } else {
                lista = modelo.getEventos(criterio);
            }

            if (lista.isEmpty() && criterio != null && !criterio.trim().isEmpty()) {
                request.setAttribute("error", "No hay resultados");
                return "WEB-INF/BuscarEventos.jsp";
            }

            request.setAttribute("listadoEventos", lista);
            return "WEB-INF/MostrarEventos.jsp";

        } catch (ExcepcionPropia e) {
            request.setAttribute("error", "Error al buscar eventos en la BBDD");
            return "WEB-INF/BuscarEventos.jsp";
        }
    }
}