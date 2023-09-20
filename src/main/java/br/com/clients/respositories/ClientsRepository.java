package br.com.clients.respositories;

import br.com.clients.models.Client;
import io.quarkus.mongodb.panache.PanacheMongoRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ClientsRepository implements PanacheMongoRepository<Client> {

    public Client findByEmail(String email) {
        return find("email", email).firstResult();
    }

    public Client findByUsername(String username){
        return find("username", username).firstResult();
    }
    public Client findByName(String name){
        String regexPattern = ".*" + name + ".*";
        return find("fullName like ?1", regexPattern).firstResult();
    }
}
