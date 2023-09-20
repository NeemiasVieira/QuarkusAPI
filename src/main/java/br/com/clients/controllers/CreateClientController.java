package br.com.clients.controllers;

import br.com.clients.dtos.CreateClientDTO;
import br.com.clients.services.CreateClientService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

@Path("/")
@ApplicationScoped
@Tag(name = "Clients", description = "Clients-related operations")
public class CreateClientController {

    @Inject
    CreateClientService createClientService;
    @POST
    @Path("/signup")
    @Operation(summary = "Create Client", description = "Create client")
    @APIResponse(responseCode = "201", description = "Client created with success")
    @APIResponse(responseCode = "400", description = "Bad Request")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response signup(@Valid CreateClientDTO newClient){
        return this.createClientService.execute(newClient);
    }
}
