package br.com.clients.services;

import br.com.clients.models.Client;
import br.com.clients.respositories.ClientsRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;

@ApplicationScoped
public class LoginClientService {

    @Inject
    ClientsRepository clientsRepository;
    @Inject
    PasswordHashService passwordHashService;

    public Response execute(String email, String username, String password) {
        Client client = null;

        if (username != null) {
            client = clientsRepository.findByUsername(username);
        } else if (email != null) {
            client = clientsRepository.findByEmail(email);
        }
        if (client != null && passwordHashService.compare(password, client.getPassword())) {
            return Response.ok("Login Successfuly!").build();
        } else {
            return Response.status(Response.Status.UNAUTHORIZED).entity("Incorrect username or password").build();
        }
    }
}
