package br.com.cars.services;

import br.com.cars.dtos.CarDTOsMapper;
import br.com.cars.dtos.CreateCarDto;
import br.com.cars.model.Car;
import br.com.cars.repositories.CarsRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;
@ApplicationScoped
public class CreateCarService {

    @Inject
    CarsRepository carsRepository;
    @Inject
    CarDTOsMapper carDTOsMapper;

    public Response execute(CreateCarDto car){

        Car newCar = carDTOsMapper.toCar(car);
        this.carsRepository.persist(newCar);
        return Response.status(Response.Status.CREATED).build();
    }
}
