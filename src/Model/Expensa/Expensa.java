package Model.Expensa;

import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.time.LocalDate;
public class Expensa {
    private Date fecha;
    private List<Gasto> valorOrdinario;
    private List<Gasto> valorExtraordinario;

    private List<Gasto> valor_Particulares;

    private List<Gasto> valor_Fondos_De_Reservas;

    public Expensa(Date fecha, List<Gasto> valorOrdinario, List<Gasto> valorExtraordinario, List<Gasto> valor_Particulares, List<Gasto> valor_Fondos_De_Reservas) {
        this.fecha = fecha;
        this.valorOrdinario = valorOrdinario;
        this.valorExtraordinario = valorExtraordinario;
        this.valor_Particulares = valor_Particulares;
        this.valor_Fondos_De_Reservas = valor_Fondos_De_Reservas;
    }

    public double calcular() {
        double totalAcumulated = 0.0;
        double totalAcumulated2 = 0.0;
        double totalAcumulated3 = 0.0;
        double totalAcumulated4 = 0.0;


        for (Gasto gasto : valorOrdinario) {
            totalAcumulated += gasto.getMonto();
        }

        for (Gasto gasto : valorExtraordinario) {
            totalAcumulated2 += gasto.getMonto();
        }

        for (Gasto gasto : valor_Particulares) {
            totalAcumulated3 += gasto.getMonto();
        }

        for (Gasto gasto : valor_Fondos_De_Reservas) {
            totalAcumulated4 += gasto.getMonto();
        }
        return totalAcumulated + totalAcumulated2 +totalAcumulated3 + totalAcumulated4;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public List<Gasto> getValorOrdinario() {
        return valorOrdinario;
    }

    public List<Gasto> getValorExtraordinario() {
        return valorExtraordinario;
    }

    public List<Gasto> getValorGastoFondosDeReservas() {
        return valor_Fondos_De_Reservas;
    }

    public List<Gasto> getValorGastoParticular() {
        return valor_Particulares;
    }

    public void addGastoExtraordinario(Gasto g) {
        valorExtraordinario.add(g);
    }

    public void addGastoOrdinario(Gasto g) {
        valorOrdinario.add(g);
    }

    public void addGastoFondosDeReservas(Gasto g) {
        valor_Fondos_De_Reservas.add(g);
    }

    public void addGastoParticular(Gasto g) {
        valor_Particulares.add(g);
    }
}