package models;

import java.util.List;

public class Zoo {
    String title;
    int workerNumbers;
    List<String> animals;

    public Zoo(String title, int workerNumbers, List<String> animals) {
        this.title = title;
        this.workerNumbers = workerNumbers;
        this.animals = animals;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getWorkerNumbers() {
        return workerNumbers;
    }

    public void setWorkerNumbers(int workerNumbers) {
        this.workerNumbers = workerNumbers;
    }

    public List<String> getAnimals() {
        return animals;
    }

    public void setAnimals(List<String> animals) {
        this.animals = animals;
    }

    @Override
    public String toString() {
        return "Zoo{" +
                "title='" + title + '\'' +
                ", workerNumbers='" + workerNumbers + '\'' +
                ", animals=" + animals +
                '}';
    }
}
