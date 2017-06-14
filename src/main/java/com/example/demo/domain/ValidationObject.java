package com.example.demo.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

/**
 * Created by wuj42 on 6/14/2017.
 */
@ApiModel
public class ValidationObject {

    @Max(10)
    @Min(1)
    int number;

    /**
     * ' ' is @NotBlank false
     * ' ' is @NotEmpty true
     */

    @NotBlank
    String blankText;

    @NotEmpty
    @ApiModelProperty(required = true, dataType = "java.lang.String")
    String emptyText;

    public ValidationObject() {

    }

    public ValidationObject(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getBlankText() {
        return blankText;
    }

    public void setBlankText(String blankText) {
        this.blankText = blankText;
    }

    public String getEmptyText() {
        return emptyText;
    }

    public void setEmptyText(String emptyText) {
        this.emptyText = emptyText;
    }
}
