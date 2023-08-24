package Controller;
import Model.Administrador.*;

import java.util.ArrayList;
import java.util.List;
/**
 * 
 */
public class AdministradorController {
	
	private static AdministradorController instancia;
	private static IAdapterLogin adapter;
	
    private static List<Administrador> adm = new ArrayList<Administrador>();
    
	public static List<Administrador> getAdministrador() {
		return adm;
	}

	public static void setAdministrador(List<Administrador> adm) {
		AdministradorController.adm = adm;
	}

	public AdministradorController(){
    	this.adapter= new AdapterLogin();
    }
	
    public static synchronized AdministradorController obtenerInstancia() {
        if (instancia == null) {
            try {
				instancia = new AdministradorController();
			} catch (Exception e) {
				
				e.printStackTrace();
			}
        }
        initAdministrador();
        return instancia;
    }
	
    private static void initAdministrador(){

        Administrador a1 = new Administrador("Cristina","309245678","adoopinamar", "123456",adapter);

        adm.add(a1);

    }
    
    public void login(String usuario, String pass) {
        adapter.login(usuario, pass);
    }

}