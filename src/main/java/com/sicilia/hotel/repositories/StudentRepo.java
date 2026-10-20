package com.sicilia.hotel.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.sicilia.hotel.model.Student;

public interface StudentRepo extends MongoRepository<Student, Integer> {
    
}