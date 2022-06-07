package com.eObrazovanje.eObrazovanje.payload.requests;
import com.eObrazovanje.eObrazovanje.model.entity.Ispit;
import com.eObrazovanje.eObrazovanje.model.entity.PredispitneObaveze;
import lombok.Getter;
import com.eObrazovanje.eObrazovanje.model.entity.Smer;
import com.eObrazovanje.eObrazovanje.model.entity.Predavac;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
@Getter
public class PredmetPostRequest {
    @NotBlank
    @Size(min=2,max=50)
    private Long predmet_id;

    @NotBlank
    @Size(min=2,max=50)
    private String naziv;

    @NotBlank
    @Size(min=2,max=50)
    private String semestar;

    @NotBlank
    @Size(min=2,max=15)
    private String espb;

    @NotBlank
    @Size(min=2,max=50)
    private String opis;

    private Smer smer;

    Set <Predavac> likes;
    private Ispit ispit;

    private List<PredispitneObaveze> predispitne=new ArrayList<>();

}
