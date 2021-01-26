package com.sahin.apidoc.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "Pet Model")
public class Pet {
    @ApiModelProperty(value = "Pet id")
    private Long id;
    @ApiModelProperty(value = "Pet name")
    private String name;
    @ApiModelProperty(value = "Pet date")
    private Date date;
}
