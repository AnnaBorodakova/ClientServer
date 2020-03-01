package interfaces;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

public interface IController {
    void setModel(IModel model);
    void setView(IView view);
    void load();
    boolean validUpdateFirm(int id, String nameFirm);
    boolean validUpdateTypeExercise(int id, String name1);
    boolean validUpdateTypeSimulator(int id, String name1);
    boolean validUpdateTraining(int idTraining, LocalTime time, LocalDate date);
    boolean validUpdateSimulator(int id, String model1, int firm, int typeSimulator);
    boolean validUpdateExercise(int id, int typeExercise, int training, int simulator, LocalTime time, int countApproach);
    boolean validCreateFirm(String nameFirm);
    boolean validCreateTypeExercise(String nameTE);
    boolean validCreateTypeSimulator(String nameTS);
    boolean validCreateTraining(LocalTime time, LocalDate date);
    boolean validCreateSimulator(String model1, int firm, int typeSimulator);
    boolean validCreateExercise(int typeExercise, int training, int simulator, LocalTime time, int countApproach);
    boolean validDeleteFirm(int id);
    boolean validDeleteTypeExercise(int id);
    boolean validDeleteTypeSimulator(int id);
    boolean validDeleteTraining(int idTraining);
    boolean validDeleteSimulator(int id);
    boolean validDeleteExercise(int id);
    void showAllFirm();
    void showAllTypeExercise();
    void showAllTypeSimulator();
    void showAllTrainings();
    void showAllSimulators();
    void showAllExercises();
    void showAll();
    void loadTypeExerciseOtherFile(String filename);
    void loadExerciseOtherFile(String filename);
    void loadSimulatorOtherFile(String filename);
    void loadTypeSimulatorOtherFile(String filename);
    void loadTrainingOtherFile(String filename);
    void loadFirmOtherFile(String filename);
}
