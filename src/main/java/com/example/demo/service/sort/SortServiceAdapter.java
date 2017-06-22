package com.example.demo.service.sort;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

/**
 * Created by wuj42 on 6/21/2017.
 */
@Component
public class SortServiceAdapter {

    private List<SortService> sortServiceList;

    @Autowired
    public SortServiceAdapter(List<SortService> sortServiceList){
        this.sortServiceList = sortServiceList;
    }

    public Optional<SortService> getSuitableSortService(String type) {
        return this.sortServiceList.stream().filter( service -> service.canDo(type)).findFirst();
    }
}
