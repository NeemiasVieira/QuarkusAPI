package br.com.cars.services;

import br.com.cars.model.Car;
import br.com.cars.repositories.CarsRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;
import org.bson.types.ObjectId;
@ApplicationScoped
public class DeleteCarByIdService {

    @Inject
    CarsRepository carsRepository;

    public Response execute(ObjectId id){
        Car car = Car.findById(id);
        if(car == null) {
            return Response.status(Response.Status.NOT_FOUND).entity("Car not found").build();
        }
        this.carsRepository.delete(car);

        return Response.noContent().build();
    }
}
