package model.services;

import interfaces.IServices;
import model.TypeSimulator;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class STypeSimulator<T extends TypeSimulator> implements IServices<T> {
    private List<T> typeSimulators;

    public List<T> get() {
        return typeSimulators;
    }

    public void set(List<T> typeSimulators) {
        this.typeSimulators = typeSimulators;
    }

    public STypeSimulator() {
        typeSimulators = new ArrayList<>();
    }

    public boolean create(T object) {
        Optional<T> ts = typeSimulators.stream().filter(x -> x.getTypeSimulator().equals(object.getTypeSimulator())).findAny();
        if (ts.isPresent()) {
            return false;
        }else {
            return typeSimulators.add(object);
        }
    }

    public boolean delete(T object) {
        if (find(object.getIdTypeSimulator()) == null) {
            return false;
        }else {typeSimulators.remove(object);
        return true;}
    }

    public boolean update(T fobject, T sobject) {
        if (fobject == null && sobject == null) {
            return false;
        } else {
            fobject.setTypeSimulator(sobject.getTypeSimulator());
            return true;
        }
    }

    public T find(int id) {
        Optional<T> ts = typeSimulators.stream().filter(x -> x.getIdTypeSimulator() == id).findFirst();
        if(ts.isPresent()){
            return ts.get();
        }
        else  return null;
    }
}
