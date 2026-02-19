package es.accenture.emisora.entidades;

/**
 * Clase que representa un Usuario dentro del sistema.
 * Contiene la informacion personal y de acceso del usuario
 * como identificador, nombre, apellido, dni, email,
 * telefono, direccion, nombre de usuario y password.
 * 
 * @author manu_
 */
public class Usuario {

    private int usuarioId;
    private String nombre;
    private String apellido;
    private String dni;
    private String email;
    private String telefono;
    private String direccion;
    private String usuario;
    private String password;

    /**
     * Constructor vacio de la clase Usuario.
     */
    public Usuario() {}

    /**
     * Constructor con parametros de la clase Usuario.
     * 
     * @param usuarioId Identificador del usuario
     * @param nombre Nombre del usuario
     * @param apellido Apellido del usuario
     * @param dni Documento nacional de identidad
     * @param email Correo electronico del usuario
     * @param telefono Telefono del usuario
     * @param direccion Direccion del usuario
     * @param usuario Nombre de usuario para el acceso
     * @param password Contrasena del usuario
     */
    public Usuario(int usuarioId, String nombre, String apellido,
                   String dni, String email, String telefono,
                   String direccion, String usuario, String password) {
        this.setUsuarioId(usuarioId);
        this.setNombre(nombre);
        this.setApellido(apellido);
        this.setDni(dni);
        this.setEmail(email);
        this.setTelefono(telefono);
        this.setDireccion(direccion);
        this.setUsuario(usuario);
        this.setPassword(password);
    }

    /**
     * Obtiene el identificador del usuario.
     * 
     * @return usuarioId
     */
    public int getUsuarioId() {
        return usuarioId;
    }

    /**
     * Establece el identificador del usuario.
     * 
     * @param usuarioId Identificador del usuario
     */
    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }

    /**
     * Obtiene el nombre del usuario.
     * 
     * @return nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del usuario.
     * 
     * @param nombre Nombre del usuario
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el apellido del usuario.
     * 
     * @return apellido
     */
    public String getApellido() {
        return apellido;
    }

    /**
     * Establece el apellido del usuario.
     * 
     * @param apellido Apellido del usuario
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    /**
     * Obtiene el dni del usuario.
     * 
     * @return dni
     */
    public String getDni() {
        return dni;
    }

    /**
     * Establece el dni del usuario.
     * 
     * @param dni Documento nacional de identidad
     */
    public void setDni(String dni) {
        this.dni = dni;
    }

    /**
     * Obtiene el email del usuario.
     * 
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Establece el email del usuario.
     * 
     * @param email Correo electronico del usuario
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Obtiene el telefono del usuario.
     * 
     * @return telefono
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * Establece el telefono del usuario.
     * 
     * @param telefono Telefono del usuario
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * Obtiene la direccion del usuario.
     * 
     * @return direccion
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * Establece la direccion del usuario.
     * 
     * @param direccion Direccion del usuario
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * Obtiene el nombre de usuario para el acceso.
     * 
     * @return usuario
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * Establece el nombre de usuario para el acceso.
     * 
     * @param usuario Nombre de usuario
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    /**
     * Obtiene la contrasena del usuario.
     * 
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Establece la contrasena del usuario.
     * 
     * @param password Contrasena del usuario
     */
    public void setPassword(String password) {
        this.password = password;
    }
}