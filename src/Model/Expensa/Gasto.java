package Model.Expensa;

import java.util.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;


/**
 *
 */
public class Gasto {

    /**
     * Default constructor
     */

    public Gasto(Date fecha, Double monto, String tipoGasto, TipoExpensa tipoExpensa, Boolean recurrente) {
        this.fecha = fecha;
        this.monto = monto;
        this.tipoGasto = tipoGasto;
        this.tipoExpensa = tipoExpensa;
        this.recurrente = recurrente;
    }



    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }

    public String getTipoGasto() {
        return tipoGasto;
    }

    public void setTipoGasto(String tipoGasto) {
        this.tipoGasto = tipoGasto;
    }

    public TipoExpensa getTipoExpensa() {
        return tipoExpensa;
    }

    public void setTipoExpensa(TipoExpensa tipoExpensa) {
        this.tipoExpensa = tipoExpensa;
    }

    public Boolean getRecurrente() {
        return recurrente;
    }

    public void setRecurrente(Boolean recurrente) {
        this.recurrente = recurrente;
    }

    /**
     *
     */
    private Date fecha;

    /**
     *
     */
    private Double monto;

    /**
     *
     */
    private String tipoGasto;

    /**
     *
     */
    private TipoExpensa tipoExpensa;

    /**
     *
     */
    private Boolean recurrente;

    /**
     * @return
     */


}