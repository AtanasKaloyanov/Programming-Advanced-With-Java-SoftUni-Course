package T11ExamPreparation.E08February2021.dealership;

import java.util.ArrayList;
import java.util.List;

public class Dealership {
    public List<Car> data;
    public String name;
    public int capacity;

    public Dealership(String name, int capacity) {
        this.data = new ArrayList<>();
        this.name = name;
        this.capacity = capacity;
    }

    public void add(Car car) {
        if (capacity > data.size()) {
            data.add(car);
        }
    }

    public boolean buy(String manufacturer, String model) {
        for (Car datum : data) {
            if (datum.getManufacturer().equals(manufacturer) && datum.getModel().equals(model)) {
                data.remove(datum);
                return true;
            }
        }
        return false;
    }

    public Car getLatestCar() {
        int max = -1;
        Car latestCar = null;
        if (data.isEmpty()) {
            return null;
        } else {
            for (Car datum : data) {
                if (datum.getYear() > max) {
                    max = datum.getYear();
                    latestCar = datum;
                }
            }
        }
        return latestCar;
    }

    public Car getCar(String manufacturer, String model) {
        for (Car datum : data) {
            if (datum.getManufacturer().equals(manufacturer) && datum.getModel().equals(model)) {
                return datum;
            }
        }
        return null;
    }

    public int getCount() {
        return data.size();
    }

    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("The cars are in a car T11ExamPreparation.E08February2021.dealership %s:", name)).append("\n");
        for (Car datum : data) {
            sb.append(datum).append("\n");
        }
        return sb.toString().trim();
    }
}
