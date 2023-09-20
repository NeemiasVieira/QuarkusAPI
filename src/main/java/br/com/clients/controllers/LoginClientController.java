package br.com.clients.controllers;

import br.com.clients.dtos.LoginDTO;
import br.com.clients.respositories.ClientsRepository;
import br.com.clients.services.LoginClientService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

@ApplicationScoped
@Path("/")
public class LoginClientController {
    @Inject
    LoginClientService loginClientService;
    @POST
    @Path("login")
    @Operation(summary = "Login", description = "Login")
    @Tag(name = "Clients", description = "Clients-related operations")
    @APIResponse(responseCode = "200", description = "Login Success")
    @APIResponse(responseCode = "401", description = "Unauthorized (incorrect username or password)")
    @APIResponse(responseCode = "400", description = "Bad request, password is required")

    public Response login(@Valid LoginDTO user){

        try {
            return loginClientService.execute(user.getEmail(), user.getUsername(), user.getPassword());
        }
        catch (Exception e){
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }

}
