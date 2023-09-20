package br.com.cars.controllers;

import br.com.cars.model.Car;
import br.com.cars.repositories.CarsRepository;
import br.com.cars.services.ListAllCarsService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import java.util.List;

@Path("/")
@ApplicationScoped
@Tag(name = "Cars", description = "Car-related operations")

public class ListAllCarsController {
    @Inject
    ListAllCarsService listAllCarsService;
    @GET
    @Path("cars")
    @Operation(summary = "List All Cars", description = "List All Cars")
    @APIResponse(responseCode = "200", description = "Return a list with all cars")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllCars(){
        return listAllCarsService.execute();
    }
}
