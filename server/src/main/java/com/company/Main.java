package com.company;

import controller.Controller;
import interfaces.*;
import model.*;
import model.services.*;
import view.View;
public class Main {
    public static void main(String[] args){
	// write your code here
        IView view = new View();
        IController controller = new Controller();
        IModel model = new Model();
        IServices<Firm> sFirm = new SFirm();
        IServices<TypeExercise> sTypeExercise = new STypeExercise();
        IServices<TypeSimulator> sTypeSimulator = new STypeSimulator();
        IServices<Training> sTraining = new STraining();
        IServices<Simulator> sSimulator = new SSimulator();
        IServices<Exercise> exerciseS = new ExerciseS();
        view.setController(controller);
        controller.setModel(model);
        model.setServices(sFirm,sTypeExercise,sTypeSimulator,sTraining,sSimulator,exerciseS);
        controller.load();
        controller.setView(view);
        view.runView();
    }
}
