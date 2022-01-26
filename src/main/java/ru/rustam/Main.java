package ru.rustam;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<City> listCity = new ArrayList();
        String foundation;

        try {
            FileReader reader = new FileReader("D:/Sberbank internship/city_ru.csv");
            Scanner scanner = new Scanner(reader);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] arrayString = line.split(";");
                if (arrayString.length==6 ) foundation = arrayString[5];
                else foundation = null;
                City city = new City(arrayString[1], arrayString[2], arrayString[3], Integer.parseInt(arrayString[4]),
                        foundation);
                listCity.add(city);
            }

            for (City city: listCity){
                System.out.println(city);
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


    }
}
