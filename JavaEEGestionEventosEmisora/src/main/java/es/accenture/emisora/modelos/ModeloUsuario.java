package es.accenture.emisora.modelos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import es.accenture.emisora.entidades.Usuario;
import es.accenture.emisora.excepciones.ExcepcionPropia;

/**
 * Clase que gestiona el acceso a datos relacionados con los usuarios.
 * Permite obtener un usuario a partir de su nombre de usuario
 * y password desde la base de datos.
 * 
 * @author manu_
 */
public class ModeloUsuario {

    private DataSource ds;

    /**
     * Constructor de la clase ModeloUsuario.
     * 
     * @param ds DataSource para la conexion a la base de datos
     */
    public ModeloUsuario(DataSource ds) {
        this.ds = ds;
    }

    /**
     * Obtiene un usuario a partir de su nombre de usuario y password.
     * 
     * @param usuario Nombre de usuario
     * @param password Contrasena del usuario
     * @return Objeto Usuario
     * @throws ExcepcionPropia Si el usuario no existe o ocurre un error en la base de datos
     */
    public Usuario getUsuario(String usuario, String password) throws ExcepcionPropia {

        String sql = "SELECT * FROM usuarios WHERE usuario=? AND password=?";

        try (Connection con = ds.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, usuario);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                return new Usuario(
                        rs.getInt("usuarioId"),
                        rs.getString("nombre"),
                        rs.getString("apellido"),
                        rs.getString("dni"),
                        rs.getString("email"),
                        rs.getString("telefono"),
                        rs.getString("direccion"),
                        rs.getString("usuario"),
                        rs.getString("password")
                );

            } else {
                throw new ExcepcionPropia("Usuario/Password incorrecta", null);
            }

        } catch (SQLException e) {
            throw new ExcepcionPropia("Error en la BBDD", e);
        }
    }
}