package org.example;

public class Main {
    public static void main(String[] args) throws Exception {
        CatServer catServer = new CatServer();

        catServer.start();

        AnimeRepo.addAnime("Bleach");
        AnimeRepo.addAnime("One Piece");
        AnimeRepo.addAnime("Naruto");
        AnimeRepo.addAnime("Overlord");
    }
}