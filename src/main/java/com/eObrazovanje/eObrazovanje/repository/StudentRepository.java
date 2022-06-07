package com.eObrazovanje.eObrazovanje.repository;

import com.eObrazovanje.eObrazovanje.model.entity.Admin;
import com.eObrazovanje.eObrazovanje.model.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    Student save(Student student);

    void deleteById(Long id);


    Optional<Student> findById(Long studentId);

    Optional<Student> findByKorisnickoIme(String korisnickoIme);
}
