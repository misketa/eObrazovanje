package com.eObrazovanje.eObrazovanje.service;

import com.eObrazovanje.eObrazovanje.model.dto.StudentDTO;
import com.eObrazovanje.eObrazovanje.model.entity.Student;
import com.eObrazovanje.eObrazovanje.payload.requests.StudentPostRequest;

import java.util.List;

public interface StudentService {

    Student findById(Long student_id);
    List<Student> findAll();
    Student save(StudentDTO studentDTO);
    void remove (Long id);
    Student update(Long id, StudentPostRequest studentPostRequest);
}
