package model.services;

import interfaces.IServices;
import model.Firm;
import model.Simulator;
import model.TypeSimulator;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class SSimulator<T extends Simulator> implements IServices<T> {
    private List<T> simulators;

    public SSimulator() {
        simulators = new ArrayList<>();
    }

    public List<T> get() {
        return simulators;
    }

    public void set(List<T> simulators) {
        this.simulators = simulators;
    }

    public boolean create(T object){
        Optional<T> simulator = simulators.stream().filter(x -> x.equals(object)).findAny();
        if (simulator.isPresent()) {
            return false;
        }else {
            return simulators.add(object);
        }
    }

    public boolean delete(T object) {
        if (find(object.getIdSimulator()) == null) {
           return false;
        }else { simulators.remove(object);
        return true;}
    }

    public boolean update(T fobject, T sobject) {
        if (fobject == null && sobject == null) {
            return false;
        } else {
            fobject.setTypeSimulator(sobject.getTypeSimulator());
            fobject.setFirm(sobject.getFirm());
            fobject.setModel(sobject.getModel());
            return true;
        }
    }

    public T find(int idSimulator)
    {
        Optional<T> simulator = simulators.stream().filter(x -> x.getIdSimulator() == idSimulator).findFirst();
        if(simulator.isPresent()){
            return simulator.get();
        }
        else  return null;
    }
}
