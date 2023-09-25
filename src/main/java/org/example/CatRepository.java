package org.example;

import java.util.ArrayList;
import java.util.List;

public class CatRepository {

    private static ArrayList<String> catList = new ArrayList<>();

    public static void addCat(Cat cat) {
        catList.add(cat.name());
    }

    public static List<String> getCats() {

        return catList;
    }

}
