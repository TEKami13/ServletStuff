package org.example;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletHolder;
import org.eclipse.jetty.util.resource.Resource;
import org.eclipse.jetty.webapp.WebAppContext;

public class CatServer {

    private final Server server = new Server(8181);

    public void start() throws Exception {
        var resource = Resource.newClassPathResource("/WebApp");
        var webAppContext = new WebAppContext(resource, "/");

        webAppContext.addServlet(new ServletHolder(new AnimeServlet()), "/api/anime");
        webAppContext.addServlet(new ServletHolder(new ApiServlet()), "/api/cat");
        webAppContext.addServlet(new ServletHolder(new TestServlet()), "/api/test");
        webAppContext.addServlet(new ServletHolder(new AstersiskServlet()), "/api/*");

        server.setHandler(webAppContext);

        server.start();

    }
}
