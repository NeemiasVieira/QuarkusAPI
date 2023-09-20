package br.com.cars.controllers;

import br.com.cars.services.DeleteCarByIdService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Response;
import org.bson.types.ObjectId;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

@ApplicationScoped
@Path("/")
@Tag(name = "Cars", description = "Car-related operations")

public class DeleteCarByIdController {

    @Inject
    DeleteCarByIdService deleteCarByIdService;

    @DELETE
    @Path("car/{id}")
    @Operation(summary = "Delete Car By ID", description = "Delete a car by id")
    @APIResponse(responseCode = "204", description = "Deleted with success, No content")
    @APIResponse(responseCode = "400", description = "Bad Request")
    @APIResponse(responseCode = "404", description = "Car not found")
    public Response deleteById(@PathParam("id") ObjectId id){
        return deleteCarByIdService.execute(id);
    }

}
