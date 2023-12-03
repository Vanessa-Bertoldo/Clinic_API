package med.vol.api.controller;

import jakarta.validation.Valid;
import med.vol.api.doctor.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
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
    public Page<DataList> listDoctors(@PageableDefault(sort = {"nome"}) Pageable pageable){
        //return repository.findAll(pageable).stream().map(DataList::new).toList();
        return repository.findAllByAtivoTrue(pageable).map(DataList::new);
    }

    @PutMapping
    @Transactional
    public void updateDataDoctor(@RequestBody @Valid DataUpdate data){
        var doctor = repository.getReferenceById(data.id());
        doctor.updateData(data);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void deleteDataDoctor(@PathVariable Long id){
        // permanent deletion
        //repository.deleteById(id);

        // logic deletion
        var doctor = repository.getReferenceById(id);
        doctor.inactivateDoctor();
    }
}
