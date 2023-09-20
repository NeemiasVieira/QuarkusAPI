package br.com.reserves.respositories;

import br.com.reserves.model.Reserve;
import io.quarkus.mongodb.panache.PanacheMongoRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@ApplicationScoped

public class ReservesRepository implements PanacheMongoRepository<Reserve> {

    public List<Reserve> getReservationsBetweenDates(LocalDateTime initialDate, LocalDateTime finalDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");

        String initialDateStr = initialDate.format(formatter);
        String finalDateStr = finalDate.format(formatter);

        return list("startDate >= ?1 and endDate <= ?2", initialDateStr, finalDateStr);
    }


}
