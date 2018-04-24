package at.refugeescode.nursery.persistance.repository;

import at.refugeescode.nursery.persistance.model.Patient;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PatientRepository extends MongoRepository<Patient, String> {
}
