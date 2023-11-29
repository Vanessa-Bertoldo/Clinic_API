package med.vol.api.controller;

import med.vol.api.doctor.DataList;
import med.vol.api.patient.DataListPatient;
import med.vol.api.patient.Patient;
import med.vol.api.patient.PatientRepository;
import med.vol.api.patient.RegisterDataPatient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //marca a classe como controladora no padrão RESTful
@RequestMapping("patient") //mapea a URL
public class PatientController {
    @Autowired
    private PatientRepository repository;

    @PostMapping
    @Transactional
    public void register(@RequestBody RegisterDataPatient data){
        repository.save(new Patient(data));

    }

    @GetMapping
    public List<DataListPatient> listDoctors(){
        return repository.findAll().stream().map(DataListPatient::new).toList();
    }


}
