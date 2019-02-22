package com.student.dogs;

import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class DogsController {
    private final DogRepository dogsRepos;
    private final DogsResourceAssembler assembler;

    public DogsController(DogRepository dogsRepos, DogsResourceAssembler assembler) {
        this.dogsRepos = dogsRepos;
        this.assembler = assembler;
    }

    @GetMapping("/dogs")
    public Resources<Resource<Dogs>> all(){
        List<Resource<Dogs>> dogs = dogsRepos.findAll().stream()
                .map(assembler::toResource)
                .collect(Collectors.toList());
        return new Resources<>(dogs);
//        // I'm not really sure what the second arg is actually doing. it doesn't seem to be doing anything
//        return new Resources<>(dogs, linkTo(methodOn(DogsController.class).all()).withSelfRel());
    }

    @GetMapping("/dogs/{id}")
    public Resource<Dogs> findOne(@PathVariable Long id){
        Dogs foundDog = dogsRepos.findById(id)
                .orElseThrow(()-> new DogNotFoundException(id));

        return assembler.toResource(foundDog);
    }
}
