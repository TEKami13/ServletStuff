package org.example;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletHolder;
import org.eclipse.jetty.util.resource.Resource;
import org.eclipse.jetty.webapp.WebAppContext;

public class CatServer {

    private final Server server = new Server(8181);

    public void start() throws Exception {
        var resource = Resource.newClassPathResource("/WebApp");
        var handler = new WebAppContext(resource, "/");

        handler.addServlet(new ServletHolder(new AnimeServlet()), "/api/anime");
        handler.addServlet(new ServletHolder(new ApiServlet()), "/api/cat");
        handler.addServlet(new ServletHolder(new TestServlet()), "/api/test");
        handler.addServlet(new ServletHolder(new AstersiskServlet()), "/api/*");

        server.setHandler(handler);

        server.start();

    }
}
