package med.vol.api.controller;

import jakarta.validation.Valid;
import med.vol.api.doctor.DataList;
import med.vol.api.patient.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
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
    public Page<DataListPatient> listDoctors(@PageableDefault(sort={"nome"}) Pageable pageable){
        //return repository.findAll().stream().map(DataListPatient::new).toList();
        return repository.findAllByAtivoTrue(pageable).map(DataListPatient::new);
    }

    @PutMapping
    @Transactional
    public void updateDataPatient(@RequestBody @Valid DataUpdatePatient data){
        var patient = repository.getReferenceById(data.id());
        patient.updateData(data);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void deleteDataPatient(@PathVariable Long id){ //PathVariable indicates that the id comes from the link
        var patient = repository.getReferenceById(id);
        patient.inactivatePatient();
    }

}
