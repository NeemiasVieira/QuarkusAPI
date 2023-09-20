package br.com.clients.services;

import br.com.clients.models.Client;
import br.com.clients.respositories.ClientsRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;

@ApplicationScoped

public class FindClientByNameService {

    @Inject
    ClientsRepository clientsRepository;
    public Response execute(String name){

        if (name == null) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("Query parameter 'name' is required.")
                    .build();
        }

        Client client = this.clientsRepository.findByName(name);

        if(client == null) return Response.status(Response.Status.NOT_FOUND).build();

        return Response.ok(client).build();

    }
}
