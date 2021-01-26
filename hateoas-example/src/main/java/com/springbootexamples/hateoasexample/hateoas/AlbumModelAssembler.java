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

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@Component
public class AlbumModelAssembler extends RepresentationModelAssemblerSupport<AlbumEntity, AlbumModel> {


    public AlbumModelAssembler() {
        super(WebController.class, AlbumModel.class);
    }

    @Override
    public AlbumModel toModel(AlbumEntity entity) {

        AlbumModel albumModel = instantiateModel(entity);

        albumModel.add(linkTo(methodOn(WebController.class).getAlbumById(entity.getId())).withSelfRel());

        albumModel.setId(entity.getId());
        albumModel.setTitle(entity.getTitle());
        albumModel.setDescription(entity.getDescription());
        albumModel.setReleaseDate(entity.getReleaseDate());
        albumModel.setActors(toActorModel(entity.getActors()));


        return albumModel;
    }

    @Override
    public CollectionModel<AlbumModel> toCollectionModel(Iterable<? extends AlbumEntity> entities) {
        CollectionModel<AlbumModel> albumModels = super.toCollectionModel(entities);
        albumModels.add(linkTo(methodOn(WebController.class).getAllAlbums()).withSelfRel());
        return albumModels;
    }

    private List<ActorModel> toActorModel(List<ActorEntity> actors) {

        if (actors == null || actors.isEmpty())
            return Collections.emptyList();

        return actors.stream()
                .map(actor -> ActorModel.builder()
                        .id(actor.getId())
                        .firstName(actor.getFirstName())
                        .lastName(actor.getLastName())
                        .build()
                        .add(linkTo(methodOn(WebController.class).getActorById(actor.getId())).withSelfRel()))
                .collect(Collectors.toList());

    }
}
