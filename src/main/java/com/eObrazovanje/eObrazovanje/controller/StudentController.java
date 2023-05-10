package com.eObrazovanje.eObrazovanje.controller;

import com.eObrazovanje.eObrazovanje.model.dto.StudentDTO;
import com.eObrazovanje.eObrazovanje.model.entity.Student;
import com.eObrazovanje.eObrazovanje.payload.requests.StudentPostRequest;
import com.eObrazovanje.eObrazovanje.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/studenti")
@CrossOrigin(origins = "http://localhost:4200")
public class StudentController {

    private final StudentService studentService;

    StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> findOne(@PathVariable Long id) {
        Student student =  studentService.findById(id);

        return new ResponseEntity<>(student, HttpStatus.FOUND);
    }

    @GetMapping
    public ResponseEntity<List<Student>> findAll() {
        List<Student> studenti = studentService.findAll();
        return new ResponseEntity<>(studenti, HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<Student> save( @RequestBody StudentDTO studentDTO) {
        Student student = studentService.save(studentDTO);
        return new ResponseEntity<>(student, HttpStatus.CREATED);

    }


    @PutMapping("/update/{id}")
    public ResponseEntity<Student> update(@PathVariable("id") Long id, @RequestBody StudentPostRequest studentPostRequest) {
        Student update = studentService.update(id, studentPostRequest);
        return new ResponseEntity<>(update, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    ResponseEntity<?> deleteArtikal(@PathVariable Long id) {

        studentService.remove(id);

        return ResponseEntity.noContent().build();
    }
}
