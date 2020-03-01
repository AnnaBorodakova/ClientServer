package model;

import java.io.Serializable;
import java.time.LocalTime;
import java.util.Objects;

public class Exercise implements Serializable {
    private int idExercise;
    private TypeExercise typeExercise;
    private Training training;
    private Simulator simulator;
    private LocalTime time;
    private int countApproach;

    public Exercise(int idExercise, TypeExercise typeExercise,
                    Training training, Simulator simulator,LocalTime time, int countApproach) {
        this.idExercise = idExercise;
        this.typeExercise = typeExercise;
        this.training = training;
        this.simulator = simulator;
        this.time = time;
        this.countApproach = countApproach;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public int getIdExercise() {
        return idExercise;
    }

    public void setIdExercise(int idExercise) {
        this.idExercise = idExercise;
    }

    public TypeExercise getTypeExercise() {
        return typeExercise;
    }

    public void setTypeExercise(TypeExercise typeExercise) {
        this.typeExercise = typeExercise;
    }

    public Training getTraining() {
        return training;
    }

    public void setTraining(Training training) {
        this.training = training;
    }

    public Simulator getSimulator() {
        return simulator;
    }

    public void setSimulator(Simulator simulator) {
        this.simulator = simulator;
    }

    public int getCountApproach() {
        return countApproach;
    }

    public void setCountApproach(int countApproach) {
        this.countApproach = countApproach;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Exercise)) return false;
        Exercise exercise = (Exercise) o;
        return getCountApproach() == exercise.getCountApproach() &&
                getTypeExercise().equals(exercise.getTypeExercise()) &&
                getTraining().equals(exercise.getTraining()) &&
                getSimulator().equals(exercise.getSimulator()) &&
                getTime().equals(exercise.getTime());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTypeExercise(), getTraining(), getSimulator(), getTime(), getCountApproach());
    }
}
