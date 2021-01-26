package com.springbootexamples.hateoasexample.controllers;


import com.springbootexamples.hateoasexample.DTO.ActorModel;
import com.springbootexamples.hateoasexample.DTO.AlbumModel;
import com.springbootexamples.hateoasexample.hateoas.ActorModelAssembler;
import com.springbootexamples.hateoasexample.hateoas.AlbumModelAssembler;
import com.springbootexamples.hateoasexample.repository.ActorRepository;
import com.springbootexamples.hateoasexample.repository.AlbumRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RequiredArgsConstructor
@RestController
@RequestMapping("api")
public class WebController {

    private final ActorRepository actorRepository;
    private final AlbumRepository albumRepository;
    private final ActorModelAssembler actorModelAssembler;
    private final AlbumModelAssembler albumModelAssembler;


    @GetMapping("actors")
    public ResponseEntity<CollectionModel<ActorModel>> getAllActors() {
        return ResponseEntity.ok(actorModelAssembler.toCollectionModel(actorRepository.findAll()));
    }

    @GetMapping("actors/{id}")
    public ResponseEntity<ActorModel> getActorById(@PathVariable(value = "id") long id) {
        return actorRepository.findById(id)
                .map(actorModelAssembler::toModel)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("albums")
    public ResponseEntity<CollectionModel<AlbumModel>> getAllAlbums() {
        return ResponseEntity.ok(albumModelAssembler.toCollectionModel(albumRepository.findAll()));
    }

    @GetMapping("albums/{id}")
    public ResponseEntity<AlbumModel> getAlbumById(@PathVariable(value = "id") long id) {
        return albumRepository.findById(id)
                .map(albumModelAssembler::toModel)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }



}