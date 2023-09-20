package br.com.clients.controllers;

import br.com.clients.services.FindClientByNameService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

@ApplicationScoped
@Path("/")
public class FindClientByNameController {

    @Inject
    FindClientByNameService findClientByNameService;

    @GET
    @Path("client")
    @Operation(summary = "Find Client By Name", description = "Find a client using a approximate search")
    @APIResponse(responseCode = "200", description = "Return the User")
    @APIResponse(responseCode = "400", description = "Query parameter 'name' is required.")
    @APIResponse(responseCode = "404", description = "Client not found")
    @Tag(name = "Clients", description = "Clients-related operations")
    public Response findByClientName(@QueryParam("name") String name){
        return findClientByNameService.execute(name);
    }

}
