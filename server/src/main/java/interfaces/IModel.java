package interfaces;

import model.*;
import model.services.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;
public interface IModel {
    boolean createFirm(int id, String nameFirm);
    boolean deleteFirm(int id);
    List<TypeExercise> getTypeExercises();
    void setTypeExercises(List<TypeExercise> typeExercises);
    boolean createTypeExercise(int id, String nameTE);
    boolean deleteTypeExercise(int id);
    List<TypeSimulator> getTypeSimulator();
    void setTypeSimulators(List<TypeSimulator> typeSimulator);
    boolean createTypeSimulator(int id, String nameTS);
    boolean deleteTypeSimulator(int id);
    void setTrainings(List<Training> trainings);
    List<Training> getTrainings();
    boolean createTraining(int idTraining, LocalTime time, LocalDate date);
    boolean deleteTraining(int idTraining);
    void setFirms(List<Firm> firms);
    List<Firm> getFirms();
    void setSimulators(List<Simulator> simulators);
    List<Simulator> getSimulators();
    boolean createSimulator(int idSimulator, String model, Firm firm, TypeSimulator typeSimulator);
    boolean deleteSimulator(int idSimulator);
    Simulator findSimulator(int idSimulator);
    TypeSimulator findTypeSimulator(int id);
    Firm findFirm(int id);
    List<Exercise> getExercises();
    void setExercises(List<Exercise> exercises);
    boolean createExercise(int idExercise, TypeExercise typeExercise, Training training, Simulator simulator, LocalTime time, int countApproach);
    Exercise findExercise(int idExercise);
    boolean deleteExercise(int idExercise);
    void setServices(IServices<Firm> firmIService, IServices<TypeExercise> typeExerciseIServices, IServices<TypeSimulator> typeSimulatorIServices, IServices<Training> sTraining, IServices<Simulator> sSimulator, IServices<Exercise> exerciseS);
    Training findTraining(int idTraining);
    TypeExercise findTypeExercise(int id);
    boolean updateFirm(int id1, String nameFirm);
    boolean updateTypeExercise(int id, String nameTE);
    boolean updateTypeSimulator(int id, String name1);
    boolean updateTraining(int idTraining, LocalTime time, LocalDate date);
    boolean updateSimulator(int idSimulator, String model, Firm firm, TypeSimulator typeSimulator);
    boolean updateExercise(int idExercise, TypeExercise typeExercise, Training training, Simulator simulator, LocalTime time, int countApproach);
}
