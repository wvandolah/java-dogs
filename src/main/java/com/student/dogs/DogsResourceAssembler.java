package com.student.dogs;

import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;
@Component
public class DogsResourceAssembler implements ResourceAssembler<Dogs, Resource<Dogs>> {
    @Override
    public Resource<Dogs> toResource(Dogs dogs){
        return new Resource<Dogs>(dogs,
                linkTo(methodOn(DogsController.class).findOne(dogs.getId())).withSelfRel(),
                linkTo(methodOn(DogsController.class).all()).withRel("dogs"));
    }
}
