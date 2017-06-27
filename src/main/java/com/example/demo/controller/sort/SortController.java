package com.example.demo.controller.sort;

import com.example.demo.domain.sort.SortObject;
import com.example.demo.service.sort.SortService;
import com.example.demo.service.sort.SortServiceContext;
import com.google.common.primitives.Ints;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

/**
 * Created by Jimmy on 2017/6/20.
 */
@RestController
@RequestMapping("/api/v1")
public class SortController {

    private final SortServiceContext sortServiceContext;

    @Autowired
    public SortController(SortServiceContext sortServiceContext){
        this.sortServiceContext = sortServiceContext;
    }

    @RequestMapping(value = "/sort", method = RequestMethod.POST)
    public ResponseEntity<List<Integer>> sortNumberList(@Valid @RequestBody SortObject arg) {

        Optional<SortService> sortService = sortServiceContext.getSuitableSortService(arg.getType());

        if(sortService.isPresent()){
            int[] sortedList = sortService.get().sortNumbers(Ints.toArray(arg.getUnsortedNumbers()));
            return new ResponseEntity<>(Ints.asList(sortedList), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }

    @RequestMapping(value = "/sort",method = RequestMethod.GET)
    public List<String> getSupportedSortMethod() {
        return sortServiceContext.getAllSupportedMethod();
    }


}
