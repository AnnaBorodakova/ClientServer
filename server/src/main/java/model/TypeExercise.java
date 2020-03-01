package model;

import java.io.Serializable;
import java.util.Objects;


public class TypeExercise implements Serializable {
    private String typeExersise;
    private int idTypeExercise;

    public int getIdTypeExercise() {
        return idTypeExercise;
    }

    public TypeExercise(int idTypeExercise, String typeExersise) {
        this.typeExersise = typeExersise;
        this.idTypeExercise = idTypeExercise;
    }

    public void setIdTypeExercise(int idTypeExercise) {
        this.idTypeExercise = idTypeExercise;
    }

    public TypeExercise(String typeExersise) {
        this.typeExersise = typeExersise;
    }

    public String getTypeExersise() {
        return typeExersise;
    }

    public void setTypeExersise(String typeExersise) {
        this.typeExersise = typeExersise;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TypeExercise)) return false;
        TypeExercise that = (TypeExercise) o;
        return getTypeExersise().equals(that.getTypeExersise());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTypeExersise());
    }
}
