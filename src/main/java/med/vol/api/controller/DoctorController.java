package med.vol.api.controller;

import jakarta.validation.Valid;
import med.vol.api.doctor.DataList;
import med.vol.api.doctor.Doctor;
import med.vol.api.doctor.DoctorRepository;
import med.vol.api.doctor.RegisterDataDoctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/doctors")
public class DoctorController {
    @Autowired
    private DoctorRepository repository; //imjeção de dependências
    @PostMapping
    @Transactional
    public void register(@RequestBody @Valid RegisterDataDoctor data) {
        repository.save(new Doctor(data));
        System.out.println(data);
    }

    @GetMapping
    public List<DataList> listDoctors(){
        return repository.findAll().stream().map(DataList::new).toList();
    }
}
