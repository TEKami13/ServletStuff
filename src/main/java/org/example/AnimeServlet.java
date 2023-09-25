package org.example;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.stream.Collectors;

public class AnimeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        AnimeRepo.getAnime().forEach(anime -> {
            try {
                resp.getWriter().write(anime + " ");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var body = req.getReader().lines().collect(Collectors.joining());
        AnimeRepo.addAnime(body);
        AnimeRepo.getAnime().forEach(anime -> {
            try {
                resp.getWriter().write(anime + " ");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var body = req.getReader().lines().collect(Collectors.joining());
        AnimeRepo.deleteAnime(body);
        AnimeRepo.getAnime().forEach(anime -> {
            try {
                resp.getWriter().write(anime + " ");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var body = req.getReader().lines().collect(Collectors.joining());
        String[] bodyPart = body.split(",,,", 0);
        int id = Integer.parseInt(bodyPart[0]);
        AnimeRepo.editAnime(id, bodyPart[1]);
        AnimeRepo.getAnime().forEach(anime -> {
            try {
                resp.getWriter().write(anime + " ");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }
}
