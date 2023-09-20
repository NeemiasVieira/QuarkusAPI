package br.com.cars.repositories;

import br.com.cars.model.Car;
import io.quarkus.mongodb.panache.PanacheMongoRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.bson.types.ObjectId;

import java.util.List;

@ApplicationScoped
public class CarsRepository implements PanacheMongoRepository<Car> {
    public List<Car> getAll(){
        return this.listAll();
    }

    public Car getById(ObjectId id){
        return this.findById(id);
    }
}
