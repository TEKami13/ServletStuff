package org.example;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Arrays;
import java.util.stream.Collectors;

public class ApiServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //int first = Integer.parseInt(req.getParameter("first"));
        //int second = Integer.parseInt(req.getParameter("second"));
        //var result = first + second;
        //resp.getWriter().write("Result is " + result);
        //req.getParameterMap().forEach((key, value) -> System.out.println(key + " " + Arrays.toString(value)));
        CatRepository.getCats().forEach(cat -> {
            try {
                resp.getWriter().write(cat+" ");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var body = req.getReader().lines().collect(Collectors.joining());
        CatRepository.addCat(body);
    }
}