package com.example.demo.controller;

import com.example.demo.domain.SortObject;
import com.example.demo.service.SortService;
import com.example.demo.service.SortServiceAdapter;
import com.google.common.primitives.Ints;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.xml.ws.http.HTTPException;
import java.util.List;
import java.util.Optional;

/**
 * Created by Jimmy on 2017/6/20.
 */
@RestController
@RequestMapping("/api/v1")
public class SortController {

    private final SortServiceAdapter sortServiceAdapter;

    @Autowired
    public SortController(SortServiceAdapter sortServiceAdapter){
        this.sortServiceAdapter = sortServiceAdapter;
    }

    @RequestMapping(value = "/sort", method = RequestMethod.POST)
    public ResponseEntity<List<Integer>> sortNumberList(@Valid @RequestBody SortObject arg) {

        Optional<SortService> sortService = sortServiceAdapter.getSuitableSortService(arg.getType());

        if(sortService.isPresent()){
            int[] sortedList = sortService.get().sortNumbers(Ints.toArray(arg.getUnsortedNumbers()));
            return new ResponseEntity<>(Ints.asList(sortedList), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }


}
