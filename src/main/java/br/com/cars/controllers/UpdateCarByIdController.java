package br.com.cars.controllers;

import br.com.cars.model.Car;
import br.com.cars.services.UpdateCarByIdService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.bson.types.ObjectId;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

@Path("/")
@ApplicationScoped
@Tag(name = "Cars", description = "Car-related operations")
public class UpdateCarByIdController {

    @Inject
    UpdateCarByIdService updateCarByIdService;
    @PATCH
    @Path("car/{id}")
    @Operation(summary = "Update Car By ID", description = "Update Car By ID")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @APIResponse(responseCode = "200", description = "Updated")
    @APIResponse(responseCode = "400", description = "Bad Request")
    public Response updateCarById(@PathParam("id") ObjectId id, Car updatedCar){
        return updateCarByIdService.execute(id, updatedCar);
    }
}
