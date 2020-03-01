package model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;


public class Training implements Serializable {
    private int idTraining;
    private LocalTime timeBegining;
    private LocalDate date;


    public Training(int idTraining, LocalTime time, LocalDate date) {
        this.idTraining = idTraining;
        this.timeBegining = time;
        this.date = date;
    }

    public Training(int idTraining, LocalDate date) {
        this.idTraining = idTraining;
        this.date = date;
    }

    public int getIdTraining() {
        return idTraining;
    }

    public void setIdTraining(int idTraining) {
        this.idTraining = idTraining;
    }

    public LocalTime getTime() {
        return timeBegining;
    }

    public void setTime(LocalTime time) {
        this.timeBegining = time;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Training)) return false;
        Training training = (Training) o;
        return timeBegining.equals(training.timeBegining) &&
                getDate().equals(training.getDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(timeBegining, getDate());
    }
}
