package org.example;

import java.util.ArrayList;
import java.util.List;

public class CatRepository {

    private static ArrayList<Cat> catList = new ArrayList<>();

    public static void addCat(Cat cat) {
        catList.add(cat);
    }

    public static List<Cat> getCats() {return catList;}

}
