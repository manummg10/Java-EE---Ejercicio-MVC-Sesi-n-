package es.accenture.emisora.entidades;

/**
 * Clase que representa un Evento dentro del sistema.
 * Contiene la informacion relacionada con un evento como
 * su identificador, nombre, descripcion, lugar, duracion,
 * tipo de evento y numero de asientos disponibles.
 * 
 * @author manu_
 */
public class Evento {

    private int eventoId;
    private String nombre;
    private String descripcion;
    private String lugar;
    private String duracion;
    private String tipoEvento;
    private int asientosDisp;

    /**
     * Constructor vacio de la clase Evento.
     */
    public Evento() {}

    /**
     * Constructor con parametros de la clase Evento.
     * 
     * @param eventoId Identificador del evento
     * @param nombre Nombre del evento
     * @param descripcion Descripcion del evento
     * @param lugar Lugar donde se realiza el evento
     * @param duracion Duracion del evento
     * @param tipoEvento Tipo de evento
     * @param asientosDisp Numero de asientos disponibles
     */
    public Evento(int eventoId, String nombre, String descripcion,
                  String lugar, String duracion,
                  String tipoEvento, int asientosDisp) {

        this.setEventoId(eventoId);
        this.setNombre(nombre);
        this.setDescripcion(descripcion);
        this.setLugar(lugar);
        this.setDuracion(duracion);
        this.setTipoEvento(tipoEvento);
        this.setAsientosDisp(asientosDisp);
    }

    /**
     * Obtiene el identificador del evento.
     * 
     * @return eventoId
     */
    public int getEventoId() {
        return eventoId;
    }

    /**
     * Establece el identificador del evento.
     * 
     * @param eventoId Identificador del evento
     */
    public void setEventoId(int eventoId) {
        this.eventoId = eventoId;
    }

    /**
     * Obtiene el nombre del evento.
     * 
     * @return nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del evento.
     * 
     * @param nombre Nombre del evento
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene la descripcion del evento.
     * 
     * @return descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Establece la descripcion del evento.
     * 
     * @param descripcion Descripcion del evento
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * Obtiene el lugar del evento.
     * 
     * @return lugar
     */
    public String getLugar() {
        return lugar;
    }

    /**
     * Establece el lugar del evento.
     * 
     * @param lugar Lugar del evento
     */
    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    /**
     * Obtiene la duracion del evento.
     * 
     * @return duracion
     */
    public String getDuracion() {
        return duracion;
    }

    /**
     * Establece la duracion del evento.
     * 
     * @param duracion Duracion del evento
     */
    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    /**
     * Obtiene el tipo de evento.
     * 
     * @return tipoEvento
     */
    public String getTipoEvento() {
        return tipoEvento;
    }

    /**
     * Establece el tipo de evento.
     * 
     * @param tipoEvento Tipo de evento
     */
    public void setTipoEvento(String tipoEvento) {
        this.tipoEvento = tipoEvento;
    }

    /**
     * Obtiene el numero de asientos disponibles.
     * 
     * @return asientosDisp
     */
    public int getAsientosDisp() {
        return asientosDisp;
    }

    /**
     * Establece el numero de asientos disponibles.
     * 
     * @param asientosDisp Numero de asientos disponibles
     */
    public void setAsientosDisp(int asientosDisp) {
        this.asientosDisp = asientosDisp;
    }
}
