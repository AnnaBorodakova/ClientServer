package model.services;

import interfaces.IServices;
import model.Firm;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class SFirm<T extends Firm> implements IServices<T> {
    private List<T> firms = new ArrayList<>();

    public List<T> get() {
        return firms;
    }

    public void set(List<T> firms) {
        this.firms = firms;
    }

    public boolean create(T object) {
        Optional<T> firm = firms.stream().filter(x -> x.getNameFirm().equals(object.getNameFirm())).findFirst();
        if (firm.isPresent()) {
            return false;
        }else {
        return firms.add(object);
        }
    }

    public boolean delete(T object) {
        if (find(object.getIdFirm()) == null) {
            return false;
        }else {
            firms.remove(object);
            return true;
        }
    }

    public boolean update(T fobject, T sobject) {
        if (fobject == null && sobject == null) {
            return false;
        } else {
            fobject.setNameFirm(sobject.getNameFirm());
            return true;
        }
    }

    public T find(int id) {
        Optional<T> firm = firms.stream().filter(x -> x.getIdFirm() == id).findFirst();
        if(firm.isPresent()){
            return firm.get();
        }
        else  return null;
    }
}
