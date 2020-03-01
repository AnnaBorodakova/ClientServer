package model.services;

import interfaces.IServices;
import model.Exercise;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ExerciseS<T extends Exercise> implements IServices<T> {
    private List<T> exercises;

    public ExerciseS() {
        this.exercises = new ArrayList<>();
    }

    public List<T> get() {
        return exercises;
    }

    public void set(List<T> exercises) {
        this.exercises = exercises;
    }

    public boolean create(T object) {
        Optional<T> exercise = exercises.stream().filter(x -> x.equals(object)).findAny();
        if (exercise.isPresent()) {
            return false;
        }else {
            return exercises.add(object);
        }
    }

    public boolean delete(T object) {
        if (find(object.getIdExercise()) == null) {
            return false;
        } else {
            exercises.remove(object);
            return true;
        }
    }

    public boolean update(T fobject, T sobject) {
        if (fobject == null && sobject == null) {
            return false;
        } else {
            fobject.setTypeExercise(sobject.getTypeExercise());
            fobject.setTraining(sobject.getTraining());
            fobject.setSimulator(sobject.getSimulator());
            fobject.setTime(sobject.getTime());
            fobject.setCountApproach(sobject.getCountApproach());
            return true;
        }
    }

    public T find(int idExercise) {
        Optional<T> exercise = exercises.stream()
                .filter(x -> x.getIdExercise() == idExercise)
                .findFirst();
        if(exercise.isPresent()){
            return exercise.get();
        }
        else  return null;
    }
}
