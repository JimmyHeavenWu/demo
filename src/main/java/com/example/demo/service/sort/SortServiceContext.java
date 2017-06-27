package com.example.demo.service.sort;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * Created by wuj42 on 6/21/2017.
 */
@Component
public class SortServiceContext {

    private Map<String, SortService> sortServiceInstances;

    @Autowired
    public SortServiceContext(List<SortService> sortServiceList){
        this.sortServiceInstances = new HashMap<>();

        sortServiceList.stream().forEach(service -> {
            String lowerCaseName = service.getSortAlgorithmName().toLowerCase();
            this.sortServiceInstances.put(lowerCaseName, service);
        });
    }

    public Optional<SortService> getSuitableSortService(String type) {
        String lowerCaseName = type.toLowerCase();
        return Optional.ofNullable(this.sortServiceInstances.get(lowerCaseName));
    }

    public List<String> getAllSupportedMethod() {
       return new ArrayList(this.sortServiceInstances.keySet());
    }
}
