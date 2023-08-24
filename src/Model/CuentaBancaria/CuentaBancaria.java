package Model.CuentaBancaria;

/**
 * 
 */
public class CuentaBancaria {

	   private Double saldoActual;
	    private int cbu;
	    private String nroCuenta;
	    private String titular;
	    private IAdapterSaldo adapter;
	    private String token;
	    
	    public CuentaBancaria(int cbu, String token) {
	    	this.cbu = cbu;
	    	this.token = token;
	    	this.adapter = new AdapterSaldo();
	    }

	    public Double saldoActual() {
	        return this.adapter.saldoActual(this.cbu,this.token);
	    }
	}
