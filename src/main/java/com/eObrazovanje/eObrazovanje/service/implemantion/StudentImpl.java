package com.eObrazovanje.eObrazovanje.service.implemantion;

import com.eObrazovanje.eObrazovanje.model.dto.StudentDTO;
import com.eObrazovanje.eObrazovanje.model.entity.Student;
import com.eObrazovanje.eObrazovanje.payload.requests.StudentPostRequest;
import com.eObrazovanje.eObrazovanje.repository.StudentRepository;
import com.eObrazovanje.eObrazovanje.service.StudentService;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentImpl implements StudentService {

    private final StudentRepository studentRepository;


    public StudentImpl(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    @Override
    public Student findOne(Long studentId) {
        return (Student) studentRepository.findById(studentId).orElse(null);
    }

    @Override
    public List<Student> findAll() { return studentRepository.findAll(); }

    @Override
    public Student save(StudentDTO studentDTO) {
        Student student = new Student();
        student.setIme(studentDTO.getIme());
        student.setPrezime(studentDTO.getPrezime());
        student.setJmbg(studentDTO.getJmbg());
        student.setTelefon(studentDTO.getTelefon());
        student.setGodinaStudija(studentDTO.getGodinaStudija());
        student.setGodinaUpisa(studentDTO.getGodinaUpisa());
        student.setStatusStudenta(studentDTO.getStatusStudenta());
        student.setBudzet(studentDTO.getBudzet());
        student.setIstorijaStudiranja(studentDTO.getIstorijaStudiranja());

        return studentRepository.save(student);
    }


    @Override
    public void remove(Long id) { studentRepository.deleteById(id); }

    @Override
    public Student update(Long id, StudentPostRequest studentPostRequest) {
        Student student = (Student) studentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Book with id " + id + " not found"));


        student.setIme(studentPostRequest.getIme());
        student.setPrezime(studentPostRequest.getPrezime());
        student.setJmbg(studentPostRequest.getJmbg());
        student.setTelefon(studentPostRequest.getTelefon());
        student.setGodinaStudija(studentPostRequest.getGodinaStudija());
        student.setGodinaUpisa(studentPostRequest.getGodinaUpisa());
        student.setStatusStudenta(studentPostRequest.getStatusStudenta());
        student.setBudzet(studentPostRequest.getBudzet());
        student.setIstorijaStudiranja(studentPostRequest.getIstorijaStudiranja());

        return studentRepository.save(student);

    }



}