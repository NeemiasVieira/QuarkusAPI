package br.com.cars.services;

import br.com.cars.model.Car;
import br.com.cars.repositories.CarsRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;
import org.bson.types.ObjectId;

@ApplicationScoped
public class UpdateCarByIdService {
    @Inject
    CarsRepository carsRepository;

    public Response execute(ObjectId id, Car updatedCar){
        Car car = Car.findById(id);
        if(car == null){
            return Response.status(Response.Status.BAD_REQUEST).entity("Car does not exist").build();
        }
        updatedCar.id = id;
        carsRepository.update(updatedCar);
        return Response.ok(updatedCar).build();
    }
}
