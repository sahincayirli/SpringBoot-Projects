package com.sahin.springbootelasticsearch.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(indexName = "users")
public class User {

    @Id
    private String id;
    @Field
    private String firstName;
    @Field
    private String lastName;
    @Field
    private String address;
    @Field
    private Date birthDay;

}
