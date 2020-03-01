package model;

import interfaces.IModel;
import interfaces.IServices;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class Model implements IModel {
    private IServices<TypeExercise> typeExerciseIServices;
    private IServices<TypeSimulator> typeSimulatorIServices;
    private IServices<Training> trainingIServices;
    private IServices<Simulator> simulatorIServices;
    private IServices<Exercise> exerciseIServices;
    private IServices<Firm> firmIService;

    public void setServices(IServices<Firm> firmIService, IServices<TypeExercise> typeExerciseIServices, IServices<TypeSimulator> typeSimulatorIServices, IServices<Training> sTraining, IServices<Simulator> sSimulator, IServices<Exercise> exerciseS){
        this.firmIService = firmIService;
        this.typeExerciseIServices = typeExerciseIServices;
        this.typeSimulatorIServices = typeSimulatorIServices;
        this.trainingIServices = sTraining;
        this.simulatorIServices = sSimulator;
        this.exerciseIServices = exerciseS;
    }
    //Методы работы с упражнениями
    public List<Exercise> getExercises() {
        return exerciseIServices.get();
    }

    public void setExercises(List<Exercise> exercises) {
        exerciseIServices.set(exercises);
    }

    public boolean createExercise(int idExercise, TypeExercise typeExercise, Training training, Simulator simulator, LocalTime time, int countApproach) {
        Exercise exercise = new Exercise(idExercise, typeExercise, training, simulator, time, countApproach);
        return exerciseIServices.create(exercise);
    }

    public Exercise findExercise(int idExercise) {
        return exerciseIServices.find(idExercise);
    }

    public boolean deleteExercise(int idExercise){
        Exercise exercise = findExercise(idExercise);
        return exerciseIServices.delete(exercise);
    }

    public boolean updateExercise(int idExercise, TypeExercise typeExercise, Training training, Simulator simulator, LocalTime time, int countApproach){
        Exercise exercise = findExercise(idExercise);
        Exercise exercise1 = new Exercise(idExercise,typeExercise, training,simulator,time,countApproach);
        return exerciseIServices.update(exercise,exercise1);
    }
    //Методы работы с тренажёрами
    public void setSimulators(List<Simulator> simulators) {
        simulatorIServices.set(simulators);
    }

    public List<Simulator> getSimulators() {
        return simulatorIServices.get();
    }

    public boolean createSimulator(int idSimulator, String model, Firm firm, TypeSimulator typeSimulator) {
        Simulator simulator = new Simulator(idSimulator, model, firm, typeSimulator);
        return simulatorIServices.create(simulator);
    }

    public boolean deleteSimulator(int idSimulator) {
        Simulator simulator = findSimulator(idSimulator);
        return simulatorIServices.delete(simulator);
    }

    public Simulator findSimulator(int idSimulator) {
        return simulatorIServices.find(idSimulator);
    }

    public boolean updateSimulator(int idSimulator, String model, Firm firm, TypeSimulator typeSimulator){
        Simulator simulator = findSimulator(idSimulator);
        Simulator simulator1 = new Simulator(idSimulator, model, firm, typeSimulator);
        return simulatorIServices.update(simulator, simulator1);
    }


    //Методы работы с тренировками
    public void setTrainings(List<Training> trainings) {
        trainingIServices.set(trainings);
    }

    public List<Training> getTrainings() {
        return trainingIServices.get();
    }

    public boolean createTraining(int idTraining, LocalTime time, LocalDate date) {
        Training training = new Training(idTraining,time,date);
        return trainingIServices.create(training);
    }

    public boolean deleteTraining(int idTraining) {
        Training training = findTraining(idTraining);
        return trainingIServices.delete(training);
    }

    public Training findTraining(int idTraining){
        return trainingIServices.find(idTraining);
    }

    public boolean updateTraining(int idTraining, LocalTime time, LocalDate date){
        Training training = findTraining(idTraining);
        Training training1 = new Training(idTraining, time, date);
        return trainingIServices.update(training,training1);
    }
    //Методы работы с фирмами
    public List<Firm> getFirms() {
        return firmIService.get();
    }

    public void setFirms(List<Firm> firms) {
        firmIService.set(firms);
    }

    public boolean createFirm(int id, String nameFirm) {
        Firm firm = new Firm(id, nameFirm);
        return firmIService.create(firm);
    }

    public boolean deleteFirm(int id) {
        Firm firm = findFirm(id);
        return firmIService.delete(firm);
    }

    public Firm findFirm(int id) {
        return firmIService.find(id);
    }

    public boolean updateFirm(int id1, String nameFirm){
        Firm firstFirm = findFirm(id1);
        Firm secondFirm = new Firm(nameFirm);
        return firmIService.update(firstFirm, secondFirm);
    }

    //Методы работы с типами упражнений
    public List<TypeExercise> getTypeExercises() {
        return typeExerciseIServices.get();
    }

    public void setTypeExercises(List<TypeExercise> typeExercises) {
        typeExerciseIServices.set(typeExercises);
    }

    public boolean createTypeExercise(int id, String nameTE) {
        TypeExercise te = new TypeExercise(id, nameTE);
        return typeExerciseIServices.create(te);
    }

    public boolean deleteTypeExercise(int id) {
        TypeExercise te = findTypeExercise(id);
        return typeExerciseIServices.delete(te);
    }

    public TypeExercise findTypeExercise(int id) {
        return typeExerciseIServices.find(id);
    }

    public boolean updateTypeExercise(int id, String nameTE){
        TypeExercise te = findTypeExercise(id);
        TypeExercise te1 = new TypeExercise(nameTE);
        return typeExerciseIServices.update(te,te1);
    }

    //Методы работы с типами тренажёров
    public List<TypeSimulator> getTypeSimulator() {
        return typeSimulatorIServices.get();
    }

    public void setTypeSimulators(List<TypeSimulator> typeSimulator) {
        typeSimulatorIServices.set(typeSimulator);
    }

    public boolean createTypeSimulator(int id, String nameTS) {
        TypeSimulator typeSimulator = new TypeSimulator(id, nameTS);
        return typeSimulatorIServices.create(typeSimulator);
    }

    public boolean deleteTypeSimulator(int id) {
        TypeSimulator ts = findTypeSimulator(id);
        return typeSimulatorIServices.delete(ts);
    }

    public TypeSimulator findTypeSimulator(int id) {
        return typeSimulatorIServices.find(id);
    }

    public boolean updateTypeSimulator(int id, String name1){
        TypeSimulator ts = findTypeSimulator(id);
        TypeSimulator ts1 = new TypeSimulator(name1);
        return typeSimulatorIServices.update(ts,ts1);
    }


}
