package T11ExamPreparation.E11June2020.parking;

import java.util.ArrayList;
import java.util.List;

public class Parking {
    private List<Car> data;
    private String type;
    private int capacity;

    public Parking(String type, int capacity) {
        this.data = new ArrayList<>();
        this.type = type;
        this.capacity = capacity;
    }

    public void add(Car car) {
        if (capacity > data.size()) {
            data.add(car);
        }
    }

    public boolean remove(String manufacturer, String model) {
        for (Car datum : data) {
            if (datum.getManufacturer().equals(manufacturer) && datum.getModel().equals(model)) {
                data.remove(datum);
                return true;
            }
        }
        return false;
    }

    public Car getLatestCar() {
        Car latestCar = null;
        int maxYear = 0;
        if (data.isEmpty()) {
            return null;
        } else {
            for (Car datum : data) {
                if (datum.getYear() > maxYear) {
                    maxYear = datum.getYear();
                    latestCar = datum;
                }
            }
            return latestCar;
        }
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
        sb.append(String.format("The cars are parked in %s:%n", type));
        for (Car datum : data) {
            sb.append(datum).append("\n");
        }
        return sb.toString().trim();
    }
}
