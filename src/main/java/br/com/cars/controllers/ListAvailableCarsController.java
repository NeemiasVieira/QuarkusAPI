package br.com.cars.controllers;

import br.com.cars.services.ListAllCarsService;
import br.com.cars.dtos.ListAvailableCarsDTO;
import br.com.cars.services.ListAvailablesCarsService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

@ApplicationScoped
@Path("/car")
@Tag(name = "Cars", description = "Car-related operations")
public class ListAvailableCarsController {

    @Inject
    ListAvailablesCarsService listAvailablesCarsService;
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @APIResponse(responseCode = "200", description = "Return a list with all available cars between 2 dates")
    @Path("/listAvailableCars")
    public Response listAvailableCars(@Valid ListAvailableCarsDTO listAvailableCarsDTO){
        return listAvailablesCarsService.execute(listAvailableCarsDTO);
    }
}
