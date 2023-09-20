package br.com.reserves.controllers;

import br.com.clients.services.CreateClientService;
import br.com.reserves.dtos.CreateReserveDTO;
import br.com.reserves.services.CreateReserveService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

@ApplicationScoped
@Path("/")
@Tag(name = "Reserves", description = "Reserves-related operations")
public class CreateReserveController {
    @Inject
    CreateReserveService createReserveService;
    @POST
    @Path("/reserve")
    @Operation(summary = "Create Reserve", description = "Create a new Reserve")
    @APIResponse(responseCode = "201", description = "Created")
    @APIResponse(responseCode = "400", description = "Bad request")
    @APIResponse(responseCode = "404", description = "Client or Car not found")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createReserve(@Valid CreateReserveDTO newReserve){
        return this.createReserveService.execute(newReserve);
    }
}
