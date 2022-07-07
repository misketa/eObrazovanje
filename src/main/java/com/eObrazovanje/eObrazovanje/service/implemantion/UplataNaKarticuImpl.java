package com.eObrazovanje.eObrazovanje.service.implemantion;

import com.eObrazovanje.eObrazovanje.model.entity.FinansijskaKartica;
import com.eObrazovanje.eObrazovanje.model.entity.Student;
import com.eObrazovanje.eObrazovanje.model.entity.Uplata;
import com.eObrazovanje.eObrazovanje.repository.FinansijskaKarticaRepository;
import com.eObrazovanje.eObrazovanje.repository.UplataRepository;
import com.eObrazovanje.eObrazovanje.service.StudentService;
import com.eObrazovanje.eObrazovanje.service.UplataNaKarticuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UplataNaKarticuImpl implements UplataNaKarticuService {
    @Autowired
    private StudentService studentService;
    @Autowired
    private UplataRepository uplatarepo;
    @Autowired
    private FinansijskaKarticaRepository karticarepo;
    @Override
    public Uplata save(Long student_id, int iznos) {
        Student student=studentService.findOne(student_id);
        FinansijskaKartica kartica = student.getKartica();

        kartica.setStanje(kartica.getStanje()+iznos);
        karticarepo.save(kartica);

        Uplata uplata=new Uplata();
        uplata.setIznos(iznos);
        uplata.setKartica(kartica);
        return uplatarepo.save(uplata);
    }
}
