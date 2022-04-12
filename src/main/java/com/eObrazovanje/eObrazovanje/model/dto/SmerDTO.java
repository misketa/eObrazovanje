package com.eObrazovanje.eObrazovanje.model.dto;

import com.eObrazovanje.eObrazovanje.model.entity.Predmet;
import com.eObrazovanje.eObrazovanje.model.entity.Student;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SmerDTO implements Serializable {

    private Long smer_id;
    private String naziv;
    private List<Predmet> predmeti = new ArrayList<>();
    private List<Student> studenti = new ArrayList<>();
}
