package com.sahin.springbootvuetodolist.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.couchbase.core.mapping.Document;
import org.springframework.data.couchbase.core.mapping.Field;
import org.springframework.data.couchbase.core.mapping.id.GeneratedValue;

import static org.springframework.data.couchbase.core.mapping.id.GenerationStrategy.UNIQUE;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document
public class Todo {

    @Id
    @GeneratedValue(strategy = UNIQUE)
    private String id;
    @Field
    private String title;
    @Field
    private String description;
    @Field
    private boolean done;

    public Todo(String title, String description, boolean done) {
        this.title = title;
        this.description = description;
        this.done = done;
    }
}
