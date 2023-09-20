package br.com.reserves.services;

import br.com.cars.model.Car;
import br.com.cars.repositories.CarsRepository;
import br.com.clients.models.Client;
import br.com.clients.respositories.ClientsRepository;
import br.com.reserves.dtos.CreateReserveDTO;
import br.com.reserves.dtos.ReservesMapper;
import br.com.reserves.model.Reserve;
import br.com.reserves.respositories.ReservesRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;
import org.bson.types.ObjectId;

@ApplicationScoped
public class CreateReserveService {
    @Inject
    ReservesMapper reservesMapper;
    @Inject
    ClientsRepository clientsRepository;
    @Inject
    CarsRepository carsRepository;
    @Inject
    ReservesRepository reservesRepository;
    public Response execute(CreateReserveDTO createReserveDTO){

        ObjectId clientID = new ObjectId(createReserveDTO.getClientId());
        ObjectId carID = new ObjectId(createReserveDTO.getCarId());
        Client client = this.clientsRepository.findById(clientID);
        Car car = this.carsRepository.findById(carID);

        if(car == null) return Response.status(Response.Status.NOT_FOUND).entity("Car not found").build();
        if(client == null) return Response.status(Response.Status.NOT_FOUND).entity("Client not found").build();

        Reserve newReserve = this.reservesMapper.toReserve(createReserveDTO);
        this.reservesRepository.persist(newReserve);
        return Response.status(Response.Status.CREATED).entity(newReserve).build();
    }


}
