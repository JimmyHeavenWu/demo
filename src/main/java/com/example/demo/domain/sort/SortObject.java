package com.example.demo.domain.sort;

import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Created by wuj42 on 6/21/2017.
 */
public class SortObject {

    @NotBlank
    String type;

    @NotNull
    List<Integer> unsortedNumbers;

    protected SortObject(){}

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Integer> getUnsortedNumbers() {
        return unsortedNumbers;
    }

    public void setUnsortedNumbers(List<Integer> unsortedNumbers) {
        this.unsortedNumbers = unsortedNumbers;
    }
}
