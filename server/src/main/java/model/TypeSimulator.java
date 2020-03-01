package model;

import java.io.Serializable;
import java.util.Objects;

public class TypeSimulator implements Serializable {

    private String typeSimulator;
    private int idTypeSimulator;

    public int getIdTypeSimulator() {
        return idTypeSimulator;
    }

    public TypeSimulator(String typeSimulator) {
        this.typeSimulator = typeSimulator;
    }

    public void setIdTypeSimulator(int idTypeSimulator) {
        this.idTypeSimulator = idTypeSimulator;
    }

    public TypeSimulator(int idTypeSimulator, String typeSimulator) {
        this.typeSimulator = typeSimulator;
        this.idTypeSimulator = idTypeSimulator;
    }

    public String getTypeSimulator() {
        return typeSimulator;
    }

    public void setTypeSimulator(String typeSimulator) {
        this.typeSimulator = typeSimulator;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TypeSimulator)) return false;
        TypeSimulator that = (TypeSimulator) o;
        return getTypeSimulator().equals(that.getTypeSimulator());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTypeSimulator());
    }
}
