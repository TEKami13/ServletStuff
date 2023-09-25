package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Arrays;

public class AstersikFilter extends HttpFilter {

    private static final Logger logger = LoggerFactory.getLogger(CatFilter.class);
    private final ObjectMapper objectMapper = new ObjectMapper();


    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {

        if (req.getCookies() != null) {

            var cookie = Arrays.stream(req.getCookies()).filter(c -> c.getName().equals("DoCounter")).findFirst().orElse(null);
            if (cookie == null) {
                res.addCookie(new Cookie("DoCounter", "1"));
            } else {
                int counter;
                counter = Integer.parseInt(cookie.getValue());
                counter++;
                res.addCookie(new Cookie("DoCounter", String.valueOf(counter)));
            }
            chain.doFilter(req, res);
        } else {
            res.addCookie(new Cookie("DoCounter", "1"));
            res.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }
    }
}
