package br.com.cars.controllers;

import br.com.cars.dtos.CreateCarDto;
import br.com.cars.model.Car;
import br.com.cars.services.CreateCarService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

@Path("/")
@ApplicationScoped
@Tag(name = "Cars", description = "Car-related operations")
public class CreateCarController {
@Inject
CreateCarService createCarService;

    @POST
    @Path("/car")
    @Operation(summary = "Create Car", description = "Create a new Car")
    @APIResponse(responseCode = "201", description = "Created")
    @APIResponse(responseCode = "400", description = "Bad request")
    public Response createCar(@Valid CreateCarDto car){
        return createCarService.execute(car);
    }
}
