package med.vol.api.controller;

import med.vol.api.patient.Patient;
import med.vol.api.patient.PatientRepository;
import med.vol.api.patient.RegisterDataPatient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //marca a classe como controladora no padrão RESTful
@RequestMapping("patient") //mapea a URL
public class PacientController {
    @Autowired
    private PatientRepository repository;

    @PostMapping
    @Transactional
    public void register(@RequestBody RegisterDataPatient data){
        repository.save(new Patient(data));

    }


}
