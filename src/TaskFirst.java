import java.util.*;

public class TaskFirst {
    public static void main(String[] args) {
        Car wolga = new Car("Wolga", 1995, 550_000);
        Car vw = new Car("VW", 2005, 120_000);
        Car volvo = new Car("Volvo", 2008, 90_000);
        Car bmw = new Car("BMW", 1998, 600_000);
        Car audi = new Car("Audi", 2015, 50_000);
        Car fiat = new Car("Fiat", 2006, 250_000);
        Car ferrari = new Car("Ferrari", 1956, 67_000);
        Car opel = new Car("Opel", 2020, 89_000);
        Car honda = new Car("Honda", 2100, 160_000);
        Car ford = new Car();
        List<Car> cars = new ArrayList<>();
        cars.add(wolga);
        cars.add(vw);
        cars.add(volvo);
        cars.add(bmw);
        cars.add(audi);
        cars.add(fiat);
        cars.add(ferrari);
        cars.add(opel);
        cars.add(honda);
        cars.add(ford);
        System.out.println("Список машин : " + cars);

        int totalMileage = cars.stream()
                .filter(car -> (car.getName() != null) && car.getMileage() != 0 && car.getManufactureYear()!=0)
                .filter(car -> car.getManufactureYear() > 1999)
                .mapToInt(Car::getMileage)
                .sum();
        System.out.println("Общий пробег автомобилей новее 1999 года: " + totalMileage + " км");

        Optional<Car> oldCar = cars.stream()
                .filter(car -> (car.getName() != null) && car.getMileage() != 0 && car.getManufactureYear()!=0)
                .filter(car -> car.getMileage() > 500_000)
                .min(Comparator.comparing(Car::getManufactureYear));
        String nameOfOldCar = String.valueOf(oldCar.orElse(null));
        System.out.println("Самая старая машина с пробегом более 500 000 км: " + nameOfOldCar);

        Optional<Car> carWithTheHighestMileage = cars.stream()
                .filter(car -> (car.getName() != null) && car.getMileage() != 0 && car.getManufactureYear()!=0)
                .filter(car -> (car.getName().startsWith("V") ||
                        car.getName().startsWith("W"))
                        && car.getMileage() <= 200_000)
                .max(Comparator.comparing(Car::getMileage));
        String nameOfCarWithTheHighestMileage = String.valueOf(carWithTheHighestMileage.orElse(null));
        System.out.println("Машина с маркой на 'V' или 'W' " +
                "и пробегом не более 200 000 км с наибольшим пробегом: "
                + nameOfCarWithTheHighestMileage);
    }
}
