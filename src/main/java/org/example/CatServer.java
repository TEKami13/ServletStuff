package org.example;

import jakarta.servlet.DispatcherType;
import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.FilterHolder;
import org.eclipse.jetty.servlet.ServletHolder;
import org.eclipse.jetty.util.resource.Resource;
import org.eclipse.jetty.webapp.WebAppContext;

import java.util.EnumSet;

public class CatServer {

    private final Server server = new Server(8181);

    public void start() throws Exception {
        var resource = Resource.newClassPathResource("/WebApp");
        var webAppContext = new WebAppContext(resource, "/");

        webAppContext.addServlet(new ServletHolder(new AnimeServlet()), "/api/anime");
        webAppContext.addFilter(new FilterHolder(new CatFilter()), "/api/anime", EnumSet.of(DispatcherType.REQUEST));


        webAppContext.addServlet(new ServletHolder(new ApiServlet()), "/api/cat");
        webAppContext.addFilter(new FilterHolder(new CatFilter()), "/api/cat", EnumSet.of(DispatcherType.REQUEST));

        webAppContext.addServlet(new ServletHolder(new LoginServlet()), "/login");

        webAppContext.addServlet(new ServletHolder(new TestServlet()), "/api/test");

        webAppContext.addServlet(new ServletHolder(new AstersiskServlet()), "/*");
        webAppContext.addFilter(new FilterHolder(new AstersikFilter()), "/*", EnumSet.of(DispatcherType.REQUEST));

        server.setHandler(webAppContext);

        server.start();

    }
}
