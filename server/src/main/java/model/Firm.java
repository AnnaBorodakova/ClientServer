package model;

import java.io.Serializable;
import java.util.Objects;

public class Firm implements Serializable {

    private String nameFirm;

    private int idFirm;

    public Firm(int idFirm,String nameFirm ) {
        this.nameFirm = nameFirm;
        this.idFirm = idFirm;
    }

    public int getIdFirm() {
        return idFirm;
    }

    public void setIdFirm(int idFirm) {
        this.idFirm = idFirm;
    }

    public Firm(String nameFirm) {
        this.nameFirm = nameFirm;
    }

    public String getNameFirm() {
        return nameFirm;
    }

    public void setNameFirm(String nameFirm) {
        this.nameFirm = nameFirm;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Firm)) return false;
        Firm firm = (Firm) o;
        return getNameFirm().equals(firm.getNameFirm());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNameFirm());
    }
}
