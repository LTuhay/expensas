package Model.UnidadFuncional;

/**
 * 
 */
public class Persona {

    /**
     * Default constructor
     */

    public Persona(String nombre, String apellido, String telefono, String email, TipoPersona tipoPersona) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.email = email;
        this.tipoPersona = tipoPersona;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public TipoPersona getTipoPersona() {
        return tipoPersona;
    }

    public void setTipoPersona(TipoPersona tipoPersona) {
        this.tipoPersona = tipoPersona;
    }

    private String nombre;

    /**
     * 
     */
    private String apellido;



    /**
     * 
     */
    private String telefono;

    /**
     * 
     */
    private String email;

    /**
     * 
     */
    private TipoPersona tipoPersona;

}