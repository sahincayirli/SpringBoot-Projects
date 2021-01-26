package com.sahin.expensetracker.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "expense_tbl")
public class Expense {

    @Id
    private Long id;
    private String descript;
    private String location;
    private Instant expenseDate;

    @JsonIgnore
    @ManyToOne
    private User user;
    @ManyToOne
    private Category category;

}
