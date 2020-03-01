package model;

import java.io.Serializable;
import java.util.Objects;


public class Simulator implements Serializable {
    private String model;
    private Firm firm;
    private TypeSimulator typeSimulator;
    private int idSimulator;

    public int getIdSimulator() {
        return idSimulator;
    }

    public void setIdSimulator(int idSimulator) {
        this.idSimulator = idSimulator;
    }

    public Simulator(int idSimulator, String model, Firm firm, TypeSimulator typeSimulator) {
        this.model = model;
        this.firm = firm;
        this.typeSimulator = typeSimulator;
        this.idSimulator = idSimulator;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        model = model;
    }

    public Firm getFirm() {
        return firm;
    }

    public void setFirm(Firm firm) {
        this.firm = firm;
    }

    public TypeSimulator getTypeSimulator() {
        return typeSimulator;
    }

    public void setTypeSimulator(TypeSimulator typeSimulator) {
        this.typeSimulator = typeSimulator;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Simulator)) return false;
        Simulator simulator = (Simulator) o;
        return getModel().equals(simulator.getModel()) &&
                getFirm().equals(simulator.getFirm()) &&
                getTypeSimulator().equals(simulator.getTypeSimulator());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getModel(), getFirm(), getTypeSimulator());
    }
}
