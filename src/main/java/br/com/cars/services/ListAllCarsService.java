package br.com.cars.services;

import br.com.cars.model.Car;
import br.com.cars.repositories.CarsRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;

import java.util.List;

@ApplicationScoped
public class ListAllCarsService {

    @Inject
    CarsRepository carsRepository;

    public Response execute(){
        List<Car> cars = this.carsRepository.listAll();
        return Response.ok(cars).build();
    }
}
