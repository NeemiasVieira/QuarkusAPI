package br.com.reserves.dtos;

import br.com.cars.model.Car;
import br.com.cars.repositories.CarsRepository;
import br.com.reserves.model.Reserve;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.bson.types.ObjectId;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

@ApplicationScoped
public class ReservesMapper {

    @Inject
    CarsRepository carsRepository;

    public Reserve toReserve(CreateReserveDTO dto) {
        Reserve reserve = new Reserve();
        reserve.setClientId(new ObjectId(dto.getClientId()));
        reserve.setCarId(new ObjectId(dto.getCarId()));
        reserve.setStartDate(dto.getStartDate());
        reserve.setEndDate(dto.getEndDate());
        reserve.setStatus(dto.getStatus());

        //Convert String to LocalDateTime
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
        LocalDateTime startDateFormatted = LocalDateTime.parse(dto.getStartDate(), formatter);
        LocalDateTime endDateFormatted = LocalDateTime.parse(dto.getEndDate(), formatter);

        long daysDifference = ChronoUnit.DAYS.between(startDateFormatted, endDateFormatted);
        int roundedDaysDifference = Math.toIntExact(Math.round(daysDifference));

        reserve.setTotalDays(roundedDaysDifference);

        Car car = this.carsRepository.getById(reserve.getCarId());
        reserve.setTotalCost(car.getDailyRate() * roundedDaysDifference);
        return reserve;
    }
}
