package view;

import interfaces.IController;
import interfaces.IView;
import org.apache.commons.lang3.StringUtils;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class View implements IView {
    IController controller = null;

    private String readString(int minLength, int maxLength, String captionMessage) {
        Scanner scanner = new Scanner(System.in);
        String s = "";
        while (true) {
            System.out.println(captionMessage + " (exit - возврат)");
            s = scanner.nextLine();
            if (s.equals("exit")) {
                return "";
            }

            if (s.length() > maxLength) {
                System.out.println("Ошибка. Длинна строки больше " + maxLength);
            } else if (s.length() < minLength) {
                System.out.println("Ошибка. Длинна строки меньше " + minLength);
            } else {
                return s;
            }
        }
    }

    private int readInteger(int min, int max, String captionMessage) {
        Scanner scanner = new Scanner(System.in);

        int number;
        while (true) {
            System.out.println(captionMessage);
            number = scanner.nextInt();

            if (number > max) {
                System.out.println("Ошибка. Число больше " + max);
            } else if (number < min) {
                System.out.println("Ошибка. Число меньше " + min);
            } else {
                return number;
            }
        }
    }


    private void mainMenu() {
        System.out.println("-- Добро пожадовать в тренажёрный зал --");
        System.out.println("Основное меню:");
        System.out.println("1 - Добавить запись");
        System.out.println("2 - Изменить запись");
        System.out.println("3 - Удалить запись");
        System.out.println("4 - Добавить к существующему списку записи из другого файла");
        System.out.println("0 - Выход");
    }

    private void showMenu() {
        System.out.println("Что хотите посмотреть?");
        System.out.println("1 - Просмотр фирм");
        System.out.println("2 - Просмотр типов упражнений");
        System.out.println("3 - Просмотр типов тренажёров");
        System.out.println("4 - Просмотр тренировок");
        System.out.println("5 - Просмотр тренажёров");
        System.out.println("6 - Просмотр упражнений");
        System.out.println("7 - Просмотр всех записей");
        System.out.println("0 - Выход");
    }

    private void runMainMenu() {
        while (true) {
            showMenu();
            int i = readInteger(0, 7, "");
            if (i == 0) {
                break;
            }
            switch (i) {
                case 1: {
                    controller.showAllFirm();
                    mainMenu();
                    int k = readInteger(0, 4, "");
                    if (k == 0) {
                        break;
                    }
                    switch (k) {
                        case 1: {
                            createFirmMenu();
                            break;
                        }
                        case 2: {
                            updateFirmMenu();
                            break;
                        }
                        case 3: {
                            deleteFirmMenu();
                            break;
                        }
                        case 4:{
                            appendFileFirm();
                            break;
                        }
                    }
                    break;
                }
                case 2: {
                    controller.showAllTypeExercise();
                    mainMenu();
                    int k = readInteger(0, 4, "");
                    if (k == 0) {
                        break;
                    }
                    switch (k) {
                        case 1: {
                            createTypeExerciseMenu();
                            break;
                        }
                        case 2: {
                            updateTypeExerciseMenu();
                            break;
                        }
                        case 3: {
                            deleteTypeExerciseMenu();
                            break;
                        }
                        case 4:{
                            appendFileTypeExersice();
                            break;
                        }
                    }
                    break;
                }
                case 3: {
                    controller.showAllTypeSimulator();
                    mainMenu();
                    int k = readInteger(0, 4, "");
                    if (k == 0) {
                        break;
                    }
                    switch (k) {
                        case 1: {
                            createTypeSimulatorMenu();
                            break;
                        }
                        case 2: {
                            updateTypeSimulatorMenu();
                            break;
                        }
                        case 3: {
                            deleteTypeSimulatorMenu();
                            break;
                        }
                        case 4:{
                            appendFileTypeSimulator();
                            break;
                        }
                    }
                    break;
                }
                case 4: {
                    controller.showAllTrainings();
                    mainMenu();
                    int k = readInteger(0, 4, "");
                    if (k == 0) {
                        break;
                    }
                    switch (k) {
                        case 1: {
                            createTrainingMenu();
                            break;
                        }
                        case 2: {
                            updateTrainingMenu();
                            break;
                        }
                        case 3: {
                            deleteTrainingMenu();
                            break;
                        }
                        case 4:{
                            appendFileTraining();
                            break;
                        }
                    }
                    break;
                }
                case 5: {
                    controller.showAllSimulators();
                    mainMenu();
                    int k = readInteger(0, 4, "");
                    if (k == 0) {
                        break;
                    }
                    switch (k) {
                        case 1: {
                            createSimulatorMenu();
                            break;
                        }
                        case 2: {
                            updateSimulatorMenu();
                            break;
                        }
                        case 3: {
                            deleteSimulatorMenu();
                            break;
                        }
                        case 4:{
                            appendFileSimulator();
                            break;
                        }
                    }
                    break;
                }
                case 6: {
                    controller.showAllExercises();
                    mainMenu();
                    int k = readInteger(0, 4, "");
                    if (k == 0) {
                        break;
                    }
                    switch (k) {
                        case 1: {
                            createExerciseMenu();
                            break;
                        }
                        case 2: {
                           updateExerciseMenu();
                            break;
                        }
                        case 3: {
                            deleteExerciseMenu();
                            break;
                        }
                        case 4:{
                            appendFileExercise();
                            break;
                        }
                    }
                    break;
                } case 7:{
                    controller.showAll();
                }
            }
        }
    }

    private void deleteFirmMenu() {
        System.out.println("-- Удаление фирмы --");
        int idFirm = readInteger(1, 10, "Введите id фирмы");
        controller.validDeleteFirm(idFirm);
    }

    private void updateFirmMenu() {
        System.out.println("-- Изменение фирмы --");
        int idFirm = readInteger(1, 10, "Введите id фирмы которую хотите заменить");
        String nameFirm = readString(0, 20, "Введите новое название фирмы");
        if (!StringUtils.isEmpty(nameFirm)) {
            controller.validUpdateFirm(idFirm, nameFirm);
        }
    }

    private void createFirmMenu() {
        System.out.println("-- Добавление фирмы --");
        String nameFirm = readString(0, 20, "Введите название фирмы");
        if (!StringUtils.isEmpty(nameFirm)) {
            controller.validCreateFirm(nameFirm);
        }
    }

    private void updateTypeExerciseMenu() {
        System.out.println("-- Изменение фирмы --");
        int idExercise = readInteger(1, 10, "Введите id типа упражнения которое хотите заменить");
        String nameTypeExercise = readString(0, 20, "Введите новое название типа упражнения");
        if (!StringUtils.isEmpty(nameTypeExercise)) {
            controller.validUpdateTypeExercise(idExercise, nameTypeExercise);
        }
    }

    private void appendFileTypeExersice(){
        System.out.println("-- Добавление из другого файла --");
        String nameFile = readString(0, 20, "Введите имя файла (Filename.txt)");
        if (!StringUtils.isEmpty(nameFile)) {
            controller.loadTypeExerciseOtherFile(nameFile);
        }
    }

    private void appendFileFirm(){
        System.out.println("-- Добавление из другого файла --");
        String nameFile = readString(0, 20, "Введите имя файла (Filename.txt)");
        if (!StringUtils.isEmpty(nameFile)) {
            controller.loadFirmOtherFile(nameFile);
        }
    }

    private void appendFileTypeSimulator(){
        System.out.println("-- Добавление из другого файла --");
        String nameFile = readString(0, 20, "Введите имя файла (Filename.txt)");
        if (!StringUtils.isEmpty(nameFile)) {
            controller.loadTypeSimulatorOtherFile(nameFile);
        }
    }

    private void appendFileTraining(){
        System.out.println("-- Добавление из другого файла --");
        String nameFile = readString(0, 20, "Введите имя файла (Filename.txt)");
        if (!StringUtils.isEmpty(nameFile)) {
            controller.loadTrainingOtherFile(nameFile);
        }
    }

    private void appendFileSimulator(){
        System.out.println("-- Добавление из другого файла --");
        String nameFile = readString(0, 20, "Введите имя файла (Filename.txt)");
        if (!StringUtils.isEmpty(nameFile)) {
            controller.loadSimulatorOtherFile(nameFile);
        }
    }

    private void appendFileExercise(){
        System.out.println("-- Добавление из другого файла --");
        String nameFile = readString(0, 20, "Введите имя файла (Filename.txt)");
        if (!StringUtils.isEmpty(nameFile)) {
            controller.loadExerciseOtherFile(nameFile);
        }
    }

    private void createTypeExerciseMenu() {
        System.out.println("-- Добавление типа упражения --");
        String nameTypeExercise = readString(0, 20, "Введите тип упражнения");
        if (!StringUtils.isEmpty(nameTypeExercise)) {
            controller.validCreateTypeExercise(nameTypeExercise);
        }
    }

    private void deleteTypeExerciseMenu() {
        System.out.println("-- Добавление типа упражения --");
        int idNameTypeExercise = readInteger(1, 10, "Введите id типа упражнения которое хотите удалить");
        controller.validDeleteTypeExercise(idNameTypeExercise);
    }

    private void createTypeSimulatorMenu() {
        System.out.println("-- Добавление типа тренажёра --");
        String nameTypeSimulator = readString(0, 20, "Введите тип тренажёра");
        if (!StringUtils.isEmpty(nameTypeSimulator)) {
            controller.validCreateTypeSimulator(nameTypeSimulator);
        }
    }

    private void updateTypeSimulatorMenu() {
        System.out.println("-- Изменение фирмы --");
        int idTypeSimulator = readInteger(1, 10, "Введите номер типа тренажёра которое хотите заменить");
        String nameTypeSimulator = readString(0, 20, "Введите новое название типа тренажёра");
        if (!StringUtils.isEmpty(nameTypeSimulator)) {
            controller.validUpdateTypeSimulator(idTypeSimulator, nameTypeSimulator);
        }
    }

    private void deleteTypeSimulatorMenu() {
        System.out.println("-- Удаление типа тренажёра --");
        int idTypeSimulator = readInteger(1, 10, "Введите номер типа тренажёра которое хотите удалить");
        controller.validDeleteTypeSimulator(idTypeSimulator);
    }

    private void createTrainingMenu() {
        System.out.println("-- Добавление тренировки --");
        String timeBegining = readString(4, 8, "Введите время начала тренировки чч:мм");
        String dateTraining = readString(6, 8, "Введите дату тренировки в формате (dd-mm-yy)");
        if (timeBegining.matches("\\d{2}:\\d{2}") && dateTraining.matches("\\d{2}-\\d{2}-\\d{2}")
                && !StringUtils.isEmpty(timeBegining) && !StringUtils.isEmpty(dateTraining)) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
            LocalTime time = LocalTime.parse(timeBegining, formatter);
            DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("dd-MM-yy");
            LocalDate date = LocalDate.parse(dateTraining, formatter1);
            controller.validCreateTraining(time, date);
        } else System.out.println("При введении даты или времени произошла ошибка");
    }

    private void updateTrainingMenu() {
        System.out.println("-- Изменение тренировки --");
        int idTraining = readInteger(1, 10, "Введите номер тренировки которую хотите изменить");
        String timeBegining = readString(4, 8, "Введите новое время начала тренировки чч:мм");
        String dateTraining = readString(0, 20, "Введите новую дату тренировки в формате (dd-mm-yy)");
        if (timeBegining.matches("\\d{2}:\\d{2}") && dateTraining.matches("\\d{2}-\\d{2}-\\d{2}")
                && !StringUtils.isEmpty(timeBegining) && !StringUtils.isEmpty(dateTraining)) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
            LocalTime time = LocalTime.parse(timeBegining, formatter);
            DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("dd-MM-yy");
            LocalDate date = LocalDate.parse(dateTraining, formatter1);
            controller.validUpdateTraining(idTraining, time, date);
        } else System.out.println("При введении даты или времени произошла ошибка");
    }

    private void deleteTrainingMenu() {
        System.out.println("-- Удаление тренировки --");
        int idTraining = readInteger(1, 10, "Введите номер тренировки, которую хотите удалить");
        controller.validDeleteTraining(idTraining);
    }

    private void createSimulatorMenu() {
        System.out.println("-- Добавление тренажёра --");
        String nameModelSimulator = readString(0, 20, "Введите название модели");
        int idFirm = readInteger(1, 10, "Введите номер фирмы");
        int idTypeSimulator = readInteger(1, 10, "Введите номер типа тренажёра");
        if (!StringUtils.isEmpty(nameModelSimulator)) {
            controller.validCreateSimulator(nameModelSimulator, idFirm, idTypeSimulator);
        }
    }

    private void updateSimulatorMenu() {
        System.out.println("-- Изменение тренажёра --");
        int idSimulator = readInteger(1, 10, "Введите номер тренажёра, который хотите удалить");
        String nameModelSimulator = readString(0, 20, "Введите новое название модели");
        int idFirm = readInteger(1, 10, "Введите номер фирмы");
        int idTypeSimulator = readInteger(1, 10, "Введите номер типа тренажёра");
        if (!StringUtils.isEmpty(nameModelSimulator)) {
            controller.validUpdateSimulator(idSimulator, nameModelSimulator, idFirm, idTypeSimulator);
        }
    }

    private void deleteSimulatorMenu() {
        System.out.println("-- Удаление тренажёра --");
        int idSimulator = readInteger(1, 10, "Введите номер тренажёра, которую хотите удалить");
        controller.validDeleteSimulator(idSimulator);
    }

    private void createExerciseMenu() {
        System.out.println("-- Добавление упражнения --");
        String time = readString(4, 8, "Введите время выполнения упражнения чч:мм");
        int idTypeExercise = readInteger(1, 10, "Введите номер типа упражнения");
        int idTraining = readInteger(1, 10, "Введите номер тренировки");
        int idSimulator = readInteger(1, 10, "Введите номер тренажёра");
        int countApproach = readInteger(1, 9, "Введите количество подходов");
        if (time.matches("\\d{2}:\\d{2}") && !StringUtils.isEmpty(time)) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
            LocalTime date = LocalTime.parse(time, formatter);
            controller.validCreateExercise(idTypeExercise, idTraining, idSimulator, date, countApproach);
        } else System.out.println("При введении времени произошла ошибка");
    }

    private void updateExerciseMenu() {
        System.out.println("-- Изменение упражнения --");
        String time = readString(4, 5, "Введите время выполнения упражнения чч:мм");
        int idExercise = readInteger(1, 10, "Введите номер упражнения, которое хотите изменить");
        int idTypeExercise = readInteger(1, 10, "Введите номер типа упражнения");
        int idTraining = readInteger(1, 10, "Введите номер тренировки");
        int idSimulator = readInteger(1, 10, "Введите номер тренажёра");
        int countApproach = readInteger(1, 9, "Введите количество подходов");
        if (time.matches("\\d{2}:\\d{2}") && !StringUtils.isEmpty(time)) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
            LocalTime date = LocalTime.parse(time, formatter);
            controller.validUpdateExercise(idExercise, idTypeExercise, idTraining, idSimulator, date, countApproach);
        } else System.out.println("При введении времени произошла ошибка");

    }

    private void deleteExerciseMenu() {
        System.out.println("-- Удаление упражнения --");
        int idExercise = readInteger(1, 10, "Введите номер упражнения, которую хотите удалить");
        controller.validDeleteExercise(idExercise);
    }

    public void runView() {
        runMainMenu();
    }

    public void setController(IController controller) {
        this.controller = controller;
    }
}
