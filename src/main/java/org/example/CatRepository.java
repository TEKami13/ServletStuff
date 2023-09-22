package org.example;

import java.util.ArrayList;
import java.util.List;

public class CatRepository {

    private static ArrayList<String> catList = new ArrayList<>();

    public static void addCat(String catName) {
        catList.add(catName);
    }

    public static List<String> getCats() {

        return catList;
    }

}
