package Model.CuentaBancaria;

import java.util.*;

/**
 * 
 */
public interface IAdapterSaldo {

    /**
     * @param cbu 
     * @param fecha 
     * @param token
     */
	public double saldoActual(int cbu, String token);

}