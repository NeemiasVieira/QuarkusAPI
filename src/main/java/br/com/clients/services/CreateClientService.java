package br.com.clients.services;

import br.com.clients.CreateClientMapper;
import br.com.clients.dtos.CreateClientDTO;
import br.com.clients.models.Client;
import br.com.clients.respositories.ClientsRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;

@ApplicationScoped
public class CreateClientService {
    @Inject
    ClientsRepository clientsRepository;
    @Inject
    CreateClientMapper createClientMapper;
    @Inject
    PasswordHashService passwordHashService;

    public Response execute(CreateClientDTO newClient){
        Client convertedClient = createClientMapper.toClient(newClient);
        convertedClient.setPassword(passwordHashService.getHash(convertedClient.getPassword()));
        clientsRepository.persist(convertedClient);
        return Response.status(Response.Status.CREATED).build();
    }


}
