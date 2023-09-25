package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Arrays;
import java.util.stream.Collectors;

public class ApiServlet extends HttpServlet {

    private final static Logger logger = LoggerFactory.getLogger(ApiServlet.class);


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //int first = Integer.parseInt(req.getParameter("first"));
        //int second = Integer.parseInt(req.getParameter("second"));
        //var result = first + second;
        //resp.getWriter().write("Result is " + result);
        //req.getParameterMap().forEach((key, value) -> System.out.println(key + " " + Arrays.toString(value)));
        resp.getWriter().write("<html><a href='test?first=httpbin&second=80'><button>moby dick</button></a></html> ");


        logger.info("Hey, I got a request");


        CatRepository.getCats().forEach(cat -> {
            try {
                resp.getWriter().write(cat.name() + " ");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var payload = req.getReader().lines().collect(Collectors.joining());
        var cat = new ObjectMapper().readValue(payload, Cat.class);
        logger.info(cat.toString());
        CatRepository.addCat(cat);

        CatRepository.getCats().forEach(catN -> {
            try {
                resp.getWriter().write(catN.name() + " ");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }
}

