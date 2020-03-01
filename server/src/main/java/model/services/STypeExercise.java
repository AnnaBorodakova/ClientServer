package model.services;

import interfaces.IServices;
import model.TypeExercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class STypeExercise<T extends TypeExercise> implements IServices<T>{
    private List<T> typeExercises;

    public STypeExercise() {
        typeExercises = new ArrayList<>();
    }

    public List<T> get() {
        return typeExercises;
    }

    public void set(List<T> typeExercises) {
        this.typeExercises = typeExercises;
    }

    public boolean create(T object){
        Optional<T> te = typeExercises.stream().filter(x -> x.getTypeExersise().equals(object.getTypeExersise())).findAny();
        if (te.isPresent()) {
            return false;
        }else {
            return typeExercises.add(object);
        }
    }

    public boolean delete(T object) {
        if (find(object.getIdTypeExercise()) == null) {
            return false;
        }else {typeExercises.remove(object);
        return true;}
    }

    public boolean update(T fobject, T sobject) {
        if (fobject == null && sobject == null) {
            return false;
        } else {
            fobject.setTypeExersise(sobject.getTypeExersise());
            return true;
        }
    }

    public T find(int id) {
        Optional<T> te = typeExercises.stream().filter(x -> x.getIdTypeExercise() == id).findFirst();
        if(te.isPresent()){
            return  te.get();
        }
        else  return null;
    }
}
