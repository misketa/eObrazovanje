package com.eObrazovanje.eObrazovanje.model.dto;

import com.eObrazovanje.eObrazovanje.model.entity.Fajl;
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
public class DokumentDTO implements Serializable {

    private String naziv;
    private List<Fajl> fajlovi = new ArrayList<>();
    private Student student;

}
