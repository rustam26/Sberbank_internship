package ru.rustam;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class CityUtils {

    public static List<City> parse() {
        List<City> cityList = new ArrayList();
        try {
            FileReader reader = new FileReader("D:/Sberbank internship/city_ru.csv");
            Scanner scanner = new Scanner(reader);

            while (scanner.hasNextLine()) {
                cityList.add(parse(scanner.nextLine()));
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return cityList;
    }

    public static void print(List<City> cityList) {
        for (City city : cityList) {
            System.out.println(city);
        }
    }


    private static City parse(String line) {
        Scanner scanner = new Scanner(line);
        scanner.useDelimiter(";");
        scanner.skip("\\d*");
        String name = scanner.next();
        String region = scanner.next();
        String district = scanner.next();
        int population = scanner.nextInt();
        String foundation = null;
        if (scanner.hasNext()) {
            foundation = scanner.next();
        }
        scanner.close();
        return new City(name, region, district, population, foundation);


    }

    public static void sortNameCity(List<City> cityList) {

        Collections.sort(cityList, (city1, city2) -> {
            if (city1 == city2) {
                return 0;
            }
            String name1 = city1.getName().toLowerCase(Locale.ROOT);
            String name2 = city2.getName().toLowerCase(Locale.ROOT);

            return name1.compareTo(name2);
        });
    }

    public static void sortDistrictAndNameCity(List<City> cityList) {

        Collections.sort(cityList, (city1, city2) -> {
            if (city1 == city2) {
                return 0;
            }
            String name1 = city1.getName().toLowerCase(Locale.ROOT);
            String name2 = city2.getName().toLowerCase(Locale.ROOT);
            String district1 = city1.getDistrict().toLowerCase(Locale.ROOT);
            String district2 = city2.getDistrict().toLowerCase(Locale.ROOT);

            int result = district1.compareTo(district2);

            if (result == 0) {
                result = name1.compareTo(name2);

                return result;
            }
            return result;
        });
    }

    public static void  maxPopulationCity(List<City> cityList){

        List<Integer> integerList = new ArrayList<>();
        for (City city : cityList){
            integerList.add(city.getPopulation());
        }

        Integer[] populationArray =  integerList.toArray(new Integer[0]);

        int max = populationArray[0];
        int index = 0;
        for (int i = 0; i < populationArray.length; i++) {

            if (populationArray[i]>max){
                max = populationArray[i];
                index = i;
            }
        }
        System.out.println("["+index+"] = "+ max);

    }
}
