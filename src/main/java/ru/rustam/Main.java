package ru.rustam;

import java.util.List;

import static ru.rustam.CityUtils.*;

public class Main {
    public static void main(String[] args) {

        List<City> list = parse();
        sortNameCity(list);
        print(list);
        sortDistrictAndNameCity(list);
        print(list);

        maxPopulationCity(list);

    }
}
