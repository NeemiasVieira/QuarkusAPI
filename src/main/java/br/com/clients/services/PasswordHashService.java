package br.com.clients.services;
import jakarta.enterprise.context.ApplicationScoped;
import org.mindrot.jbcrypt.BCrypt;

@ApplicationScoped
public class PasswordHashService {
    public String getHash(String password){
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }
    public Boolean compare(String password, String hashedPassword){
        return BCrypt.checkpw(password, hashedPassword);
    }
}
