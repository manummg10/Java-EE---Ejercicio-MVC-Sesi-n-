package es.accenture.emisora.modelos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import es.accenture.emisora.entidades.Evento;
import es.accenture.emisora.excepciones.ExcepcionPropia;

/**
 * Clase que gestiona el acceso a datos relacionados con los eventos.
 * Permite obtener todos los eventos o filtrar eventos por nombre
 * o descripcion desde la base de datos.
 * 
 * @author manu_
 */
public class ModeloEvento {

    private DataSource ds;

    /**
     * Constructor de la clase ModeloEvento.
     * 
     * @param ds DataSource para la conexion a la base de datos
     */
    public ModeloEvento(DataSource ds) {
        this.ds = ds;
    }

    /**
     * Obtiene todos los eventos de la base de datos.
     * 
     * @return Lista de eventos
     * @throws ExcepcionPropia Si ocurre un error en la base de datos
     */
    public List<Evento> getEventos() throws ExcepcionPropia {
        return getEventos("");
    }

    /**
     * Obtiene eventos filtrados por nombre o descripcion.
     * 
     * @param filtro Texto para filtrar eventos
     * @return Lista de eventos filtrados
     * @throws ExcepcionPropia Si ocurre un error en la base de datos
     */
    public List<Evento> getEventos(String filtro) throws ExcepcionPropia {
        List<Evento> lista = new ArrayList<>();
        String sql;

        if (filtro == null || filtro.trim().isEmpty()) {
            sql = "SELECT * FROM eventos";
        } else {
            sql = "SELECT * FROM eventos WHERE nombre LIKE ? OR descripcion LIKE ?";
        }

        try (Connection con = ds.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            if (filtro != null && !filtro.trim().isEmpty()) {
                ps.setString(1, "%" + filtro + "%");
                ps.setString(2, "%" + filtro + "%");
            }

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                lista.add(new Evento(
                    rs.getInt("eventoId"),
                    rs.getString("nombre"),
                    rs.getString("descripcion"),
                    rs.getString("lugar"),
                    rs.getString("duracion"),
                    rs.getString("tipoEvento"),
                    rs.getInt("asientosDisp")
                ));
            }

        } catch (SQLException e) {
            throw new ExcepcionPropia("Error en la BBDD al buscar eventos", e);
        }

        return lista;
    }
}