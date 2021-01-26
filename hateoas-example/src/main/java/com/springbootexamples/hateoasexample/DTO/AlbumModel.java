package com.springbootexamples.hateoasexample.DTO;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.*;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

import java.util.List;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonRootName(value = "album")
@Relation(collectionRelation = "albums")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AlbumModel extends RepresentationModel<AlbumModel>
{
    private Long id;
    private String title;
    private String description;
    private String releaseDate;

    private List<ActorModel> actors;
}
