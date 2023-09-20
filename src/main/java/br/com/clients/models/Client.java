package br.com.clients.models;

import br.com.clients.dtos.CreateClientDTO;
import io.quarkus.mongodb.panache.PanacheMongoEntity;
import io.quarkus.mongodb.panache.common.MongoEntity;

@MongoEntity(collection = "clients")
public class Client extends PanacheMongoEntity {
    private String username;
    private String email;
    private String password;
    private String driverLicenseNumber;
    private String fullName;
    private String phoneNumber;

    //private List<Reserve> reserves;

    public Client convertToClient(CreateClientDTO clientDTO){
        Client newClient = new Client();
        newClient.setUsername(clientDTO.getUsername());
        newClient.setEmail(clientDTO.getEmail());
        newClient.setPassword(clientDTO.getPassword());
        newClient.setDriverLicenseNumber(clientDTO.getDriverLicenseNumber());
        newClient.setFullName(clientDTO.getFullName());
        newClient.setPhoneNumber(clientDTO.getPhoneNumber());
        return newClient;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setDriverLicenseNumber(String driverLicenseNumber) {
        this.driverLicenseNumber = driverLicenseNumber;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getDriverLicenseNumber() {
        return driverLicenseNumber;
    }

    public String getFullName() {
        return fullName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

}
