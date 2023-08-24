package Model.UnidadFuncional;

import java.util.*;


public class UnidadFuncional {

    private String nro;

    private Double porcentaje;


    private Double metrosCuadrado;


    private List<Persona> propietario;

    private TipoUF tipoUF;

    private List<Persona> inquilino;

    private List<Factura> facturas;



    public UnidadFuncional(String nro, Double porcentaje, Double metrosCuadrado, List<Persona> propietario, TipoUF tipoUF, List<Persona> inquilino, List<Factura> facturas) {
        this.nro = nro;
        this.porcentaje = porcentaje;
        this.metrosCuadrado = metrosCuadrado;
        this.propietario = propietario;
        this.tipoUF = tipoUF;
        this.inquilino = inquilino;
        this.facturas = facturas;
    }

    public String getNro() {
        return nro;
    }

    public void setNro(String nro) {
        this.nro = nro;
    }

    public Double getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(Double porcentaje) {
        this.porcentaje = porcentaje;
    }

    public Double getMetrosCuadrado() {
        return metrosCuadrado;
    }

    public void setMetrosCuadrado(Double metrosCuadrado) {
        this.metrosCuadrado = metrosCuadrado;
    }

    public List<Persona> getPropietario() {
        return propietario;
    }

    public void setPropietario(List<Persona> propietario) {
        this.propietario = propietario;
    }

    public TipoUF getTipoUF() {
        return tipoUF;
    }

    public void setTipoUF(TipoUF tipoUF) {
        this.tipoUF = tipoUF;
    }

    public List<Persona> getInquilino() {
        return inquilino;
    }

    public void setInquilino(List<Persona> inquilino) {
        this.inquilino = inquilino;
    }

    public List<Factura> getFacturas() {
        return facturas;
    }

    public void setFacturas(List<Factura> facturas) {
        this.facturas = facturas;
    }

    public Double calcularDeuda() {
        double deuda = 0;
        for (Factura factura : facturas) {
            if (factura.getEstado().toString().equals("IMPAGO")){
                deuda+=factura.getTotal();
            }
        }
        return deuda;
    }

    public void agregarFactura(Date fechaEmision, double total){
        Factura factura = new Factura(fechaEmision,null,total,EstadoFactura.IMPAGO);
        this.facturas.add(factura);
    }



}