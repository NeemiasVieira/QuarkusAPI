package br.com.cars.services;

import br.com.cars.model.Car;
import br.com.cars.repositories.CarsRepository;
import br.com.cars.dtos.ListAvailableCarsDTO;
import br.com.reserves.model.Reserve;
import br.com.reserves.respositories.ReservesRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class ListAvailablesCarsService {
    @Inject
    ReservesRepository reservesRepository;
    @Inject
    CarsRepository carsRepository;

    public Response execute(ListAvailableCarsDTO dates) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
        LocalDateTime initialDate = LocalDateTime.parse(dates.getInitialDate(), formatter);
        LocalDateTime finalDate = LocalDateTime.parse(dates.getFinalDate(), formatter);

        // Fetch all reservations from the repository
        List<Reserve> reservations = reservesRepository.getReservationsBetweenDates(initialDate, finalDate);

        // Fetch all cars from the repository
        List<Car> allCars = carsRepository.listAll();

        // Create a list to store available cars
        List<Car> availableCars = new ArrayList<>();

        for (Car car : allCars) {
            boolean isAvailable = true;

            for (Reserve reservation : reservations) {
                LocalDateTime reservationStartDate = LocalDateTime.parse(reservation.getStartDate(), formatter);
                LocalDateTime reservationEndDate = LocalDateTime.parse(reservation.getEndDate(), formatter);

                // Check if there is a date conflict between the requested dates and reservation dates
                if (isDateConflict(initialDate, finalDate, reservationStartDate, reservationEndDate)
                        && reservation.getCarId().equals(car.id)) {
                    isAvailable = false;
                    break;
                }
            }

            // If no conflict was found, add the car to the list of available cars
            if (isAvailable) {
                availableCars.add(car);
            }
        }

        // Return the list of available cars as a response
        return Response.ok(availableCars).build();
    }

    // Check if there is a date conflict between two date ranges
    private boolean isDateConflict(LocalDateTime initialDate1, LocalDateTime finalDate1, LocalDateTime initialDate2, LocalDateTime finalDate2) {
        return (initialDate1.isBefore(finalDate2) || initialDate1.isEqual(finalDate2))
                && (finalDate1.isAfter(initialDate2) || finalDate1.isEqual(initialDate2));
    }



}
