package org.example;

import java.util.ArrayList;
import java.util.List;

public class AnimeRepo {

    private static ArrayList<String> animeList = new ArrayList<>();

    public static void addAnime(String animeName) {
        animeList.add(animeName);
    }

    public static void deleteAnime(String animeName) {
        int id = animeList.indexOf(animeName);
        animeList.remove(id);
    }

    public static void editAnime(int id, String animeName) {
        animeList.remove(id);
        animeList.add(id, animeName);
    }

    public static List<String> getAnime() {

        return animeList;
    }
}
