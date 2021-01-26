package com.springbootexamples.hateoasexample.hateoas;


import com.springbootexamples.hateoasexample.DTO.ActorModel;
import com.springbootexamples.hateoasexample.DTO.AlbumModel;
import com.springbootexamples.hateoasexample.controllers.WebController;
import com.springbootexamples.hateoasexample.models.ActorEntity;
import com.springbootexamples.hateoasexample.models.AlbumEntity;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@Component
public class ActorModelAssembler extends RepresentationModelAssemblerSupport<ActorEntity, ActorModel> {


    public ActorModelAssembler() {
        super(WebController.class, ActorModel.class);
    }

    @Override
    public ActorModel toModel(ActorEntity entity) {

        ActorModel actorModel = instantiateModel(entity);

        actorModel.add(linkTo(methodOn(WebController.class).getActorById(entity.getId())).withSelfRel());
        actorModel.setId(entity.getId());
        actorModel.setFirstName(entity.getFirstName());
        actorModel.setLastName(entity.getLastName());
        actorModel.setBirthDate(entity.getBirthDate());
        actorModel.setAlbums(toAlbumModel(entity.getAlbums()));

        return actorModel;
    }

    @Override
    public CollectionModel<ActorModel> toCollectionModel(Iterable<? extends ActorEntity> entities) {
        CollectionModel<ActorModel> actorModels = super.toCollectionModel(entities);

        actorModels.add(linkTo(methodOn(WebController.class).getAllActors()).withSelfRel());

        return actorModels;
    }

    private List<AlbumModel> toAlbumModel(List<AlbumEntity> albumEntities) {

        if (albumEntities == null || albumEntities.isEmpty())
            return Collections.emptyList();


        return albumEntities.stream()
                .map(albumEntity -> AlbumModel.builder()
                        .id(albumEntity.getId())
                        .title(albumEntity.getTitle())
                        .build()
                        .add(linkTo(
                                methodOn(WebController.class)
                                        .getActorById(albumEntity.getId()))
                                .withSelfRel()))
                .collect(Collectors.toList());
    }

}
