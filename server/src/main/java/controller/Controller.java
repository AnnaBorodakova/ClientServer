package controller;

import com.company.Constants;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import interfaces.*;
import model.*;

import java.io.*;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;
import java.util.stream.Collectors;

public class Controller implements IController {
    IModel model;
    IView view;

    public void setModel(IModel model) {
        this.model = model;
    }

    public void setView(IView view) {
        this.view = view;
    }

    private void save(String filename, List arr, Type type) {
        File file = new File(filename);
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String jsonResult = gson.toJson(arr, type);
        try (Writer writer = new OutputStreamWriter(new FileOutputStream(file), StandardCharsets.UTF_8)) {
            writer.write(jsonResult);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void load() {
        loadFirm();
        loadTypeExercise();
        loadTypeSimulator();
        loadTraining();
        loadSimulator();
        loadExercise();
    }

    private void loadFirm() {
        Type type = new TypeToken<ArrayList<Firm>>() {
        }.getType();
        File file = new File(Constants.FILE_FIRM);
        Gson gson = new Gson();
        try (JsonReader reader = new JsonReader(new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8))) {
            model.setFirms(gson.fromJson(reader, type));
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void loadTypeExerciseOtherFile(String filename) {
        Type type = new TypeToken<ArrayList<TypeExercise>>() {
        }.getType();
        File file = new File(filename);
        Gson gson = new Gson();
        try (JsonReader reader = new JsonReader(new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8))) {
            List<TypeExercise> teArr = gson.fromJson(reader, type);
            List<TypeExercise> firstArray = model.getTypeExercises();
            TypeExercise te = firstArray.stream().reduce((first, second) -> second).orElse(null);
            int id;
            if (te != null) {
                id = te.getIdTypeExercise();
            } else id = 0;
            for (TypeExercise typeExercise : teArr) {
                id++;
                typeExercise.setIdTypeExercise(id);
            }
            teArr.stream().filter(x -> firstArray.add(x)).collect(Collectors.toList());
            firstArray.stream().distinct().collect(Collectors.toList());
            model.setTypeExercises(firstArray);
            save(Constants.FILE_TYPE_EXERCISE, model.getTypeExercises(), type);
        } catch (IOException e) {
            System.out.println("Отсутствуют записи в файле, который вы хотите скопировать");
        }
    }

    public void loadFirmOtherFile(String filename) {
        Type type = new TypeToken<ArrayList<Firm>>() {
        }.getType();
        File file = new File(filename);
        Gson gson = new Gson();
        try (JsonReader reader = new JsonReader(new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8))) {
            List<Firm> firmArr = gson.fromJson(reader, type);
            List<Firm> firstArray = model.getFirms();
            Firm lastFirm = firstArray.stream().reduce((first, second) -> second).orElse(null);
            int id;
            if (lastFirm != null) {
                id = lastFirm.getIdFirm();
            } else id = 0;
            for (int i = 0; i < firmArr.size(); i++) {
                id++;
                firmArr.get(i).setIdFirm(id);
            }
            firmArr.stream().filter(x -> firstArray.add(x)).collect(Collectors.toList());
            firstArray.stream().distinct().collect(Collectors.toList());
            model.setFirms(firstArray);
            save(Constants.FILE_FIRM, model.getTypeExercises(), type);
        } catch (IOException e) {
            System.out.println("Отсутствуют записи в файле, который вы хотите скопировать");
        }
    }

    public void loadTypeSimulatorOtherFile(String filename) {
        Type type = new TypeToken<ArrayList<TypeSimulator>>() {
        }.getType();
        File file = new File(filename);
        Gson gson = new Gson();
        try (JsonReader reader = new JsonReader(new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8))) {
            List<TypeSimulator> tsArr = gson.fromJson(reader, type);
            List<TypeSimulator> firstTsArray = model.getTypeSimulator();
            TypeSimulator lastTs = firstTsArray.stream().reduce((first, second) -> second).orElse(null);
            int id;
            if (lastTs != null) {
                id = lastTs.getIdTypeSimulator();
            } else id = 0;
            for (int i = 0; i < tsArr.size(); i++) {
                id++;
                tsArr.get(i).setIdTypeSimulator(id);
            }
            tsArr.stream().filter(x -> firstTsArray.add(x)).collect(Collectors.toList());
            firstTsArray.stream().distinct().collect(Collectors.toList());
            model.setTypeSimulators(firstTsArray);
            save(Constants.FILE_TYPE_SIMULATOR, model.getTypeExercises(), type);
        } catch (IOException e) {
            System.out.println("Отсутствуют записи в файле, который вы хотите скопировать");
        }
    }

    public void loadTrainingOtherFile(String filename) {
        Type type = new TypeToken<ArrayList<Training>>() {
        }.getType();
        File file = new File(filename);
        Gson gson = new Gson();
        try (JsonReader reader = new JsonReader(new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8))) {
            List<Training> trainingArr = gson.fromJson(reader, type);
            List<Training> firstTrainingArr = model.getTrainings();
            Training lastTraining = firstTrainingArr.stream().reduce((first, second) -> second).orElse(null);
            int id;
            if (lastTraining != null) {
                id = lastTraining.getIdTraining();
            } else id = 0;
            for (int i = 0; i < trainingArr.size(); i++) {
                id++;
                trainingArr.get(i).setIdTraining(id);
            }
            trainingArr.stream().filter(x -> firstTrainingArr.add(x)).collect(Collectors.toList());
            firstTrainingArr.stream().distinct().collect(Collectors.toList());
            model.setTrainings(firstTrainingArr);
            save(Constants.FILE_TRAINING, model.getTypeExercises(), type);
        } catch (IOException e) {
            System.out.println("Отсутствуют записи в файле, который вы хотите скопировать");
        }
    }

    public void loadSimulatorOtherFile(String filename) {
        Type type = new TypeToken<ArrayList<Simulator>>() {
        }.getType();
        File file = new File(filename);
        Gson gson = new Gson();
        try (JsonReader reader = new JsonReader(new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8))) {
            List<Simulator> simulatorArr = gson.fromJson(reader, type);
            List<Simulator> firstSimulatorArr = model.getSimulators();
            Simulator lastSimulator = firstSimulatorArr.stream().reduce((first, second) -> second).orElse(null);
            int id;
            if (lastSimulator != null) {
                id = lastSimulator.getIdSimulator();
            } else id = 0;
            for (int i = 0; i < simulatorArr.size(); i++) {
                id++;
                simulatorArr.get(i).setIdSimulator(id);
            }
            simulatorArr.stream().filter(x -> firstSimulatorArr.add(x)).collect(Collectors.toList());
            firstSimulatorArr.stream().distinct().collect(Collectors.toList());
            model.setSimulators(firstSimulatorArr);
            save(Constants.FILE_SIMULATOR, model.getTypeExercises(), type);
        } catch (IOException e) {
            System.out.println("Отсутствуют записи в файле, который вы хотите скопировать");
        }
    }

    public void loadExerciseOtherFile(String filename) {
        Type type = new TypeToken<ArrayList<Exercise>>() {
        }.getType();
        File file = new File(filename);
        Gson gson = new Gson();
        try (JsonReader reader = new JsonReader(new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8))) {
            List<Exercise> exerciseArr = gson.fromJson(reader, type);
            List<Exercise> firstExerciseArr = model.getExercises();
            Exercise lastExercise = firstExerciseArr.stream().reduce((first, second) -> second).orElse(null);
            int id;
            if (lastExercise != null) {
                id = lastExercise.getIdExercise();
            } else id = 0;
            for (int i = 0; i < exerciseArr.size(); i++) {
                id++;
                exerciseArr.get(i).setIdExercise(id);
            }
            exerciseArr.stream().filter(x -> firstExerciseArr.add(x)).collect(Collectors.toList());
           firstExerciseArr.stream().distinct().collect(Collectors.toList());
            model.setExercises(firstExerciseArr);
            save(Constants.FILE_EXERCISE, model.getTypeExercises(), type);
        } catch (IOException e) {
            System.out.println("Отсутствуют записи в файле, который вы хотите скопировать");
        }
    }

    private void loadTypeExercise() {
        Type type = new TypeToken<ArrayList<TypeExercise>>() {
        }.getType();
        File file = new File(Constants.FILE_TYPE_EXERCISE);
        Gson gson = new Gson();
        try (JsonReader reader = new JsonReader(new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8))) {
            model.setTypeExercises(gson.fromJson(reader, type));
        } catch (IOException e) {
            System.out.println("Отсутствуют типы упражнений");
        }
    }

    private void loadTypeSimulator() {
        Type type = new TypeToken<ArrayList<TypeSimulator>>() {
        }.getType();
        File file = new File(Constants.FILE_TYPE_SIMULATOR);
        Gson gson = new Gson();
        try (JsonReader reader = new JsonReader(new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8))) {
            model.setTypeSimulators(gson.fromJson(reader, type));
        } catch (IOException e) {
            System.out.println("Отсутствуют типы тренажёров");
        }
    }

    private void loadTraining() {
        Type type = new TypeToken<ArrayList<Training>>() {
        }.getType();
        File file = new File(Constants.FILE_TRAINING);
        Gson gson = new Gson();
        try (JsonReader reader = new JsonReader(new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8))) {
            model.setTrainings(gson.fromJson(reader, type));
        } catch (IOException e) {
            System.out.println("Отсутствуют тренировки");
        }
    }

    private void loadSimulator() {
        Type type = new TypeToken<ArrayList<Simulator>>() {
        }.getType();
        File file = new File(Constants.FILE_SIMULATOR);
        Gson gson = new Gson();
        try (JsonReader reader = new JsonReader(new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8))) {
            model.setSimulators(gson.fromJson(reader, type));
        } catch (IOException e) {
            System.out.println("Отсутствуют тренажёры");
        }
    }

    private void loadExercise() {
        Type type = new TypeToken<ArrayList<Exercise>>() {
        }.getType();
        File file = new File(Constants.FILE_EXERCISE);
        Gson gson = new Gson();
        try (JsonReader reader = new JsonReader(new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8))) {
            model.setExercises(gson.fromJson(reader, type));
        } catch (IOException e) {
            System.out.println("Отсутствуют упражнения");
        }
    }

    public boolean validCreateFirm(String nameFirm) {
        System.out.println("Я контроллер. Получил данные на добавление ");
        Firm firm = model.getFirms().stream().reduce((first, second) -> second).orElse(null);
        int id;
        if (firm != null) {
            id = firm.getIdFirm();
        } else id = 0;
        if (model.createFirm(id + 1, nameFirm)) {
            Type type = new TypeToken<ArrayList<Firm>>() {
            }.getType();
            save(Constants.FILE_FIRM, model.getFirms(), type);
            return true;
        }

        return false;
    }

    public boolean validUpdateFirm(int id, String nameFirm) {
        System.out.println("Я контроллер. Получил данные на обновление ");
        if (model.updateFirm(id, nameFirm)) {
            Type type = new TypeToken<ArrayList<Firm>>() {
            }.getType();
            save(Constants.FILE_FIRM, model.getFirms(), type);
            return true;
        }
        return false;
    }

    public boolean validDeleteFirm(int id) {
        System.out.println("Я контроллер. Получил данные на удаление");
        if (model.deleteFirm(id)) {
            Type type = new TypeToken<ArrayList<Firm>>() {
            }.getType();
            save(Constants.FILE_FIRM, model.getFirms(), type);
            return true;
        }
        return false;
    }

    public boolean validCreateTypeExercise(String nameTE) {
        System.out.println("Я контроллер. Получил данные на добавление ");
        TypeExercise te = model.getTypeExercises().stream().reduce((first, second) -> second).orElse(null);
        int id;
        if (te != null) {
            id = te.getIdTypeExercise();
        } else id = 0;
        if (model.createTypeExercise(id + 1, nameTE)) {
            Type type = new TypeToken<ArrayList<TypeExercise>>() {
            }.getType();
            save(Constants.FILE_TYPE_EXERCISE, model.getTypeExercises(), type);
            return true;
        }
        return false;
    }

    public boolean validUpdateTypeExercise(int id, String name1) {
        System.out.println("Я контроллер. Получил данные на обновление ");
        if (model.updateTypeExercise(id, name1)) {
            Type type = new TypeToken<ArrayList<TypeExercise>>() {
            }.getType();
            save(Constants.FILE_TYPE_EXERCISE, model.getTypeExercises(), type);
            return true;
        }
        return false;
    }

    public boolean validDeleteTypeExercise(int id) {
        System.out.println("Я контроллер. Получил данные на удаление");
        if (model.deleteTypeExercise(id)) {
            Type type = new TypeToken<ArrayList<TypeExercise>>() {
            }.getType();
            save(Constants.FILE_TYPE_EXERCISE, model.getTypeExercises(), type);
            return true;
        }
        return false;
    }

    public boolean validCreateTypeSimulator(String nameTS) {
        System.out.println("Я контроллер. Получил данные на добавление ");
        TypeSimulator ts = model.getTypeSimulator().stream().reduce((first, second) -> second).orElse(null);
        int id;
        if (ts != null) {
            id = ts.getIdTypeSimulator();
        } else id = 0;
        if (model.createTypeSimulator(id + 1, nameTS)) {
            Type type = new TypeToken<ArrayList<TypeSimulator>>() {
            }.getType();
            save(Constants.FILE_TYPE_SIMULATOR, model.getTypeSimulator(), type);
            return true;
        }
        return false;
    }

    public boolean validUpdateTypeSimulator(int id, String name1) {
        System.out.println("Я контроллер. Получил данные на обновление ");
        if (model.updateTypeSimulator(id, name1)) {
            Type type = new TypeToken<ArrayList<TypeSimulator>>() {
            }.getType();
            save(Constants.FILE_TYPE_SIMULATOR, model.getTypeSimulator(), type);
            return true;
        }
        return false;
    }

    public boolean validDeleteTypeSimulator(int id) {
        System.out.println("Я контроллер. Получил данные на удаление");
        if (model.deleteTypeSimulator(id)) {
            Type type = new TypeToken<ArrayList<TypeSimulator>>() {
            }.getType();
            save(Constants.FILE_TYPE_SIMULATOR, model.getTypeSimulator(), type);
            return true;
        }
        return false;
    }

    public boolean validCreateTraining(LocalTime time, LocalDate date) {
        System.out.println("Я контроллер. Получил данные на добавление ");
        Training training = model.getTrainings().stream().reduce((first, second) -> second).orElse(null);
        int idTraining;
        if (training != null) {
            idTraining = training.getIdTraining();
        } else idTraining = 0;
        if (model.createTraining(idTraining + 1, time, date)) {
            Type type = new TypeToken<ArrayList<Training>>() {
            }.getType();
            save(Constants.FILE_TRAINING, model.getTrainings(), type);
            return true;
        }
        return false;
    }

    public boolean validUpdateTraining(int idTraining, LocalTime time, LocalDate date) {
        System.out.println("Я контроллер. Получил данные на добавление ");
        if (model.updateTraining(idTraining, time, date)) {
            Type type = new TypeToken<ArrayList<Training>>() {
            }.getType();
            save(Constants.FILE_TRAINING, model.getTrainings(), type);
            return true;
        }
        return false;
    }

    public boolean validDeleteTraining(int idTraining) {
        System.out.println("Я контроллер. Получил данные на добавление ");
        if (model.deleteTraining(idTraining)) {
            Type type = new TypeToken<ArrayList<Training>>() {
            }.getType();
            save(Constants.FILE_TRAINING, model.getTrainings(), type);
            return true;
        }
        return false;
    }

    public boolean validCreateSimulator(String model1, int firm, int typeSimulator) {
        System.out.println("Я контроллер. Получил данные на добавление ");
        Simulator simulator = model.getSimulators().stream().reduce((first, second) -> second).orElse(null);
        int idSimulator;
        if (simulator != null) {
            idSimulator = simulator.getIdSimulator();
        } else idSimulator = 0;
        Firm firm1 = model.findFirm(firm);
        TypeSimulator typeSimulator1 = model.findTypeSimulator(typeSimulator);
        if (firm1 != null && typeSimulator1 != null) {
            if (model.createSimulator(idSimulator + 1, model1, firm1, typeSimulator1)) {
                Type type = new TypeToken<ArrayList<Simulator>>() {
                }.getType();
                save(Constants.FILE_SIMULATOR, model.getSimulators(), type);
                return true;
            }
        } else {
            System.out.println("В справочнике не существует такой фирмы или типа тренажёра");
        }
        return false;
    }

    public boolean validUpdateSimulator(int id, String model1, int firm, int typeSimulator) {
        System.out.println("Я контроллер. Получил данные на изменение ");
        Firm firm1 = model.findFirm(firm);
        TypeSimulator typeSimulator1 = model.findTypeSimulator(typeSimulator);
        if (firm1 != null && typeSimulator1 != null) {
            if (model.updateSimulator(id, model1, firm1, typeSimulator1)) {
                Type type = new TypeToken<ArrayList<Simulator>>() {
                }.getType();
                save(Constants.FILE_SIMULATOR, model.getSimulators(), type);
                return true;
            }
        } else {
            System.out.println("В справочнике не существует такой фирмы или типа тренажёра");
        }
        return false;
    }

    public boolean validDeleteSimulator(int id) {
        System.out.println("Я контроллер. Получил данные на удаление ");
        if (model.deleteSimulator(id)) {
            Type type = new TypeToken<ArrayList<Simulator>>() {
            }.getType();
            save(Constants.FILE_SIMULATOR, model.getSimulators(), type);
            return true;
        }
        return false;
    }

    public boolean validCreateExercise(int typeExercise, int training, int simulator, LocalTime time, int countApproach) {
        System.out.println("Я контроллер. Получил данные на добавление ");
        Exercise exercise = model.getExercises().stream().reduce((first, second) -> second).orElse(null);
        int idExercise;
        if (exercise != null) {
            idExercise = exercise.getIdExercise();
        } else idExercise = 0;
        Training training1 = model.findTraining(training);
        TypeExercise typeExercise1 = model.findTypeExercise(typeExercise);
        Simulator simulator1 = model.findSimulator(simulator);
        if (training1 != null && typeExercise1 != null && simulator1 != null) {
            if (model.createExercise(idExercise + 1, typeExercise1, training1, simulator1, time, countApproach)) {
                Type type = new TypeToken<ArrayList<Exercise>>() {
                }.getType();
                save(Constants.FILE_EXERCISE, model.getExercises(), type);
                return true;
            }
        } else {
            System.out.println("В справочнике не существует такой тренировки, тренажёра или типа упражнения");
        }
        return false;
    }

    public boolean validUpdateExercise(int id, int typeExercise, int training, int simulator, LocalTime time, int countApproach) {
        System.out.println("Я контроллер. Получил данные на изменение ");
        Training training1 = model.findTraining(training);
        TypeExercise typeExercise1 = model.findTypeExercise(typeExercise);
        Simulator simulator1 = model.findSimulator(simulator);
        if (training1 != null && typeExercise1 != null && simulator1 != null) {
            if (model.updateExercise(id, typeExercise1, training1, simulator1, time, countApproach)) {
                Type type = new TypeToken<ArrayList<Exercise>>() {
                }.getType();
                save(Constants.FILE_EXERCISE, model.getExercises(), type);
                return true;
            }
        } else {
            System.out.println("В справочнике не существует такой тренировки, тренажёра или типа упражнения");
        }
        return false;
    }

    public boolean validDeleteExercise(int id) {
        System.out.println("Я контроллер. Получил данные на удаление ");
        if (model.deleteExercise(id)) {
            Type type = new TypeToken<ArrayList<Exercise>>() {
            }.getType();
            save(Constants.FILE_EXERCISE, model.getExercises(), type);
            return true;
        }
        return false;
    }

    public void showAllFirm() {
        loadFirm();
        if (model.getFirms() == null) {
            System.out.println("Список фирм пуст");
        } else {
            System.out.printf("%-15s%-1s%n", "Номер фирмы", "Название фирмы");
            for (Firm firm : model.getFirms()) {
                System.out.format("%-15d%-1s%n", firm.getIdFirm(), firm.getNameFirm());
            }
        }
    }

    public void showAllTypeExercise() {
        loadTypeExercise();
        if (model.getTypeExercises() == null) {
            System.out.println("Список типов упражнений пуст");
        } else {
            System.out.printf("%-10s%-1s%n", "Номер", "Тип упражнения");
            for (TypeExercise typeExercise : model.getTypeExercises()) {
                System.out.format("%-10d%-1s%n", typeExercise.getIdTypeExercise(), typeExercise.getTypeExersise());
            }
        }
    }

    public void showAllTypeSimulator() {
        loadTypeSimulator();
        if (model.getTypeSimulator() == null) {
            System.out.println("Список типов тренажёров пуст");
        } else {
            System.out.printf("%-10s%-1s%n", "Номер", "Тип тренажёра");
            for (TypeSimulator typeSimulator : model.getTypeSimulator()) {
                System.out.format("%-10d%-1s%n", typeSimulator.getIdTypeSimulator(), typeSimulator.getTypeSimulator());
            }
        }
    }

    public void showAllTrainings() {
        loadTraining();
        if (model.getTrainings() == null) {
            System.out.println("Список тренировок пуст");
        } else {
            System.out.printf("%-10s%-20s%-1s%n", "Номер", "Время тренировки", "Дата");
            for (Training training : model.getTrainings()) {
                System.out.format("%-10d%-20s%-1s%n", training.getIdTraining(), training.getTime(), training.getDate());
            }
        }
    }

    public void showAllSimulators() {
        loadSimulator();
        if (model.getSimulators() == null) {
            System.out.println("Список тренажёров пуст");
        }
        System.out.printf("%-20s%-20s%-20s%-1s%n", "Номер тренажёра", "Модель тренажёра", "Название фирмы", "Тип тренажёра");
        for (Simulator simulator : model.getSimulators()) {
            System.out.format("%-20s%-20s%-20s%-1s%n", simulator.getIdSimulator(), simulator.getModel(), simulator.getFirm().getNameFirm(), simulator.getTypeSimulator().getTypeSimulator());
        }
    }

    public void showAllExercises() {
        loadTypeExercise();
        if (model.getExercises() == null) {
            System.out.println("Список упражнений пуст");
        } else {
            System.out.printf("%-20s%-20s%-20s%-20s%-20s%-1s%n", "Номер упражнения", "Тип упражнения", "Номер тренировки", "Номер тренажёра", "Время выполнения", "Количество подходов");
            for (Exercise exercise : model.getExercises()) {
                System.out.format("%-20s%-20s%-20s%-20s%-20s%-1s%n", exercise.getIdExercise(), exercise.getTypeExercise().getTypeExersise(), exercise.getTraining().getIdTraining(), exercise.getSimulator().getIdSimulator(), exercise.getTime(), exercise.getCountApproach());
            }
        }
    }

    public void showAll() {
        System.out.println("\n" + "Таблица фирм");
        showAllFirm();
        System.out.println("\n" + "Таблица типов упражнений");
        showAllTypeExercise();
        System.out.println("\n" + "Таблица типов тренажёров");
        showAllTypeSimulator();
        System.out.println("\n" + "Таблица тренировок");
        showAllTrainings();
        System.out.println("\n" + "Таблица тренажёров");
        showAllSimulators();
        System.out.println("\n" + "Таблица упражнений");
        showAllExercises();
    }
}
