package br.com.clients;

import br.com.clients.dtos.CreateClientDTO;
import br.com.clients.models.Client;
import jakarta.enterprise.context.ApplicationScoped;
import org.modelmapper.ModelMapper;

@ApplicationScoped
public class CreateClientMapper {
    private final ModelMapper modelMapper;

    public CreateClientMapper() {
        modelMapper = new ModelMapper();
    }

    public Client toClient(CreateClientDTO dto) {
        return modelMapper.map(dto, Client.class);
    }
}
