package src.personal;

/**
 * La clase {@code Personal} representa a un empleado o personal del sistema.
 * Contiene información sobre el identificador del personal y su rol dentro
 * de la organización.
 */
public class Personal {
    private int idPersonal;
    private CodRol rol;

    /**
     * Constructor por defecto que crea una instancia de {@code Personal}.
     */
    Personal(){}

    /**
     * Constructor que inicializa un objeto {@code Personal} con un ID y un rol.
     *
     * @param id El identificador del personal.
     * @param r  El rol que tiene el personal, definido por la enumeración {@code CodRol}.
     */
    Personal(int id, CodRol r){
        this.idPersonal = id;
        this.rol = r;
    }

    /**
     * Obtiene el rol del personal.
     *
     * @return El rol del personal.
     */
    public CodRol getRol() {
        return this.rol;
    }

    /**
     * Establece el rol del personal.
     *
     * @param rol El nuevo rol que se asignará al personal.
     */
    public void setRol(CodRol rol) {
        this.rol = rol;
    }

    /**
     * Obtiene el identificador del personal.
     *
     * @return El identificador del personal.
     */
    public int getIdPersonal() {
        return this.idPersonal;
    }

    /**
     * Establece el identificador del personal.
     *
     * @param idPersonal El nuevo identificador para el personal.
     */
    public void setIdPersonal(int idPersonal) {
        this.idPersonal = idPersonal;
    }

    /**
     * Devuelve una representación en cadena del objeto {@code Personal}.
     *
     * @return Una cadena que representa el personal, incluyendo su ID y rol.
     */
    @Override
    public String toString() {
        return "Personal{" +
                "idPersonal=" + idPersonal +
                ", rol=" + rol +
                '}';
    }
}
