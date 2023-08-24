package Model;

import java.util.*;

import Model.Administrador.*;
import Model.CuentaBancaria.*;
import Model.Expensa.*;
import Model.ExpensaCriterio.*;
import Model.Notificacion.*;
import Model.UnidadFuncional.*;

/**
 * 
 */
public class Consorcio {

    private List<Administrador> administradores;
    private List<UnidadFuncional> unidadesFuncionales;
    private CuentaBancaria cuentaBancaria;
    private List<Expensa> expensas;
    private ExpensaCriterio criterio;
    private Notificador notificador;
    
    
    public Consorcio() {
    	this.administradores = new ArrayList<Administrador>();
    	this.unidadesFuncionales = new ArrayList<UnidadFuncional>();
    	this.cuentaBancaria = new CuentaBancaria(-1, "");
    	this.expensas = new ArrayList<Expensa>();
    	this.criterio = new PagoCompletoGastos(); //default
    	this.notificador = new Notificador();
    }

    public Consorcio(List<Administrador> administradores, List<UnidadFuncional> unidadesFuncionales, CuentaBancaria cuentaBancaria,
			List<Expensa> expensas, ExpensaCriterio criterio, Notificador notificador) {
		this.administradores = administradores;
		this.unidadesFuncionales = unidadesFuncionales;
		this.cuentaBancaria = cuentaBancaria;
		this.expensas = expensas;
		this.criterio = criterio;
		this.notificador = notificador;
	}


    public void cambiarCriterio(ExpensaCriterio nuevoCriterio) {
        this.criterio = nuevoCriterio;
    }

    public void liquidar(Expensa e) {
        /* Consorcio.liquidar() hace:
		ExpensaCriterio.obtenerSaldo(), que va a traer de CuentaBancaria.saldoActual().
		Luego hace ExpensaCriterio.calcularGastos(), que hace el calcular() de Expensas.
		Despues ejecuta el divisionDeExpensas(), que debería hacer primero el calcularDeuda() de cada UF.
		
		UF.calcularDeuda() devuelve la sumatoria de las facturas impagas. */
    	
    	/*
    	 * Debería generar una nueva Expensa y luego agregarla a la lista.
    	 * */
    	double saldoConsorcio = this.criterio.obtencionDeSaldo(this.cuentaBancaria);
    	
    	this.expensas.add(e);
    	
    	double montoTotal = this.criterio.calculoDeGastos(e);
    	
    	this.criterio.divisionDeExpensas(unidadesFuncionales, montoTotal);
    	
    	//Envía notificaciones
		Notificacion notif = new Notificacion();
		notif.setMensaje("Nueva expensa disponible.");
		notif.setExpensa(e);
		
    	for (UnidadFuncional uf : unidadesFuncionales) {
    		for (Persona p : uf.getPropietario()) {
	    		notif.setPersona(p);
    			this.notificador.setNotificacion(notif);
    			this.notificador.enviar();
    		}
    		if (uf.getInquilino() != null)
	    		for (Persona p : uf.getInquilino()) {
		    		notif.setPersona(p);
		    		this.notificador.setNotificacion(notif);
		    		this.notificador.enviar();
	    		}
    	}
    }

}