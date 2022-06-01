package com.eObrazovanje.eObrazovanje.controller;

import  com.eObrazovanje.eObrazovanje.exeptions.StudentNotFoundExeption;
import com.eObrazovanje.eObrazovanje.model.dto.StudentDTO;
import com.eObrazovanje.eObrazovanje.model.entity.Student;
import com.eObrazovanje.eObrazovanje.payload.requests.StudentPostRequest;
import com.eObrazovanje.eObrazovanje.repository.StudentRepository;
import com.eObrazovanje.eObrazovanje.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "/api/studenti")
@CrossOrigin(origins = "http://localhost:4200")
public class StudentController {

    private final StudentRepository studentRepository;
    private final StudentService studentService;

    StudentController(StudentRepository studentRepository, StudentService studentService) {
        this.studentRepository = studentRepository;
        this.studentService = studentService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> findOne(@PathVariable Long id) {
        Student student = (Student) studentRepository.findById(id)
                .orElseThrow(() -> new StudentNotFoundExeption("Student sa datim id ne postoji"));

        return new ResponseEntity<>(student, HttpStatus.FOUND);
    }

    @GetMapping
    public ResponseEntity<List<Student>> findAll() {
        List<Student> artikli = studentService.findAll();
        return new ResponseEntity<>(artikli, HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<Student> save(@Valid @RequestBody StudentDTO studentDTO) {
        Student student = studentService.save(studentDTO);
        return new ResponseEntity<>(student, HttpStatus.CREATED);

    }


    @PutMapping("/update/{id}")
    public ResponseEntity<Student> update(@PathVariable("id") Long id,
                                                @Valid @RequestBody StudentPostRequest studentPostRequest) {
        Student update = studentService.update(id, studentPostRequest);
        return new ResponseEntity<>(update, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    ResponseEntity<?> deleteArtikal(@PathVariable Long id) {

        studentRepository.deleteById(id);

        return ResponseEntity.noContent().build();
    }
}
