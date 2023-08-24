package Model.CuentaBancaria;

import java.util.*;

/**
 * 
 */
public class AdapterSaldo implements IAdapterSaldo {


	    public double saldoActual(int cbu, String token) {
	    	if (cbu==1111 && token.equals("token1111")) {
	    		return 10000;
	    	}
			return -1;
	    }

	}