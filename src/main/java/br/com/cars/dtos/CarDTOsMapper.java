package br.com.cars.dtos;

import br.com.cars.model.Car;
import jakarta.enterprise.context.ApplicationScoped;
import org.modelmapper.ModelMapper;
@ApplicationScoped
public class CarDTOsMapper {
    private final ModelMapper modelMapper;
    public CarDTOsMapper() {
        modelMapper = new ModelMapper();
    }
    public Car toCar(CreateCarDto dto) {
        return modelMapper.map(dto, Car.class);
    }
}