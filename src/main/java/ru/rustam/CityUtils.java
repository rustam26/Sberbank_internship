package ru.rustam;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CityUtils {

    public static List<City> parse () {
        List<City> listCity = new ArrayList();
        try{
            FileReader reader = new FileReader("D:/Sberbank internship/city_ru.csv");
            Scanner scanner = new Scanner(reader);

            while (scanner.hasNextLine()){
                listCity.add(parse(scanner.nextLine()));
            }

        }catch (FileNotFoundException e){
            e.printStackTrace();
        }

        return listCity;
    }

    public static void print(List <City>listCity){
        for (City city:listCity){
            System.out.println(city);
        }
    }


    private static City parse(String line){
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
}
