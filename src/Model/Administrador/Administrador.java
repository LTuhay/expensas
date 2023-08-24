package Model.Administrador;

/**
 * 
 */
public class Administrador {
	
    private String nombre;
    private String DNI;
    private String usuario;
    private String pass;
    private IAdapterLogin adapter;
    
    public Administrador(String nombre, String DNI,String usuario,String pass, IAdapterLogin adapter){
    	this.usuario = usuario;
    	this.pass = pass;
    	this.adapter = new AdapterLogin();
    }

    public void login(String usuario, String pass) {
        return;
    }

}