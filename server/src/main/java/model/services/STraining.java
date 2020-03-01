package model.services;

import interfaces.IServices;
import model.Training;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class STraining<T extends Training> implements IServices<T> {
    private List<T> trainings;

    public STraining() {
        this.trainings = new ArrayList<>();
    }

    public List<T> get() {
        return trainings;
    }

    public void set(List<T> trainings) {
        this.trainings = trainings;
    }

    public boolean create(T object){
        Optional<T> training = trainings.stream().filter(x -> x.equals(object)).findAny();
        if (training.isPresent()) {
            return false;
        }else {
            return trainings.add(object);
        }
    }

    public boolean delete(T object) {
        if (find(object.getIdTraining()) == null) {
            return false;
        }
        else {trainings.remove(object); return  true;}
    }

    public boolean update(T fobject, T sobject) {
        if (fobject == null && sobject == null) {
            return false;
        } else {
            fobject.setTime(sobject.getTime());
            fobject.setDate(sobject.getDate());
            return true;
        }
    }

    public T find(int id) {
        Optional<T> training = trainings.stream().filter(x -> x.getIdTraining() == id).findFirst();
        if(training.isPresent()){
            return  training.get();
        }
        else  return null;
    }

}
