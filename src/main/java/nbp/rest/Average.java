package nbp.rest;

import nbp.Calculator;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.JAXBException;
import java.io.IOException;

@Path("/{table}/{topCount}")
public class Average {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public Double getAverage(@PathParam("table") String table, @PathParam("topCount") int topCount) throws IOException, JAXBException {
        return Calculator.getAverageAsk(table, topCount);
    }

    @GET
    @Produces(MediaType.TEXT_HTML)
    public String getAverageHTML(@PathParam("table") String table, @PathParam("topCount") int topCount) throws IOException, JAXBException {
        return "<html><body><h3>" + Calculator.getAverageAsk(table, topCount) + "</h3></body></html>";
    }
}
