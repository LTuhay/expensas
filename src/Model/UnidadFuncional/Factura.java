package Model.UnidadFuncional;

import java.util.*;

/**
 * 
 */
public class Factura {

    public Factura(Date fechaEmision, Date fechaPago, Double total, EstadoFactura estado) {
        this.fechaEmision = fechaEmision;
        this.fechaPago = fechaPago;
        this.total = total;
        this.estado = estado;
    }

    public Date getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(Date fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public Date getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(Date fechaPago) {
        this.fechaPago = fechaPago;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public EstadoFactura getEstado() {
        return estado;
    }

    public void setEstado(EstadoFactura estado) {
        this.estado = estado;
    }

    private Date fechaEmision;

    /**
     * 
     */
    private Date fechaPago;

    /**
     * 
     */
    private Double total;

    /**
     * 
     */
    private EstadoFactura estado;

}