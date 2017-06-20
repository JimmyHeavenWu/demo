package com.example.demo.controller;

import com.example.demo.service.SortService;
import com.google.common.primitives.Ints;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Jimmy on 2017/6/20.
 */
@RestController
@RequestMapping("/api/v1")
public class SortController {

    private final SortService sortService;

    @Autowired
    public SortController(SortService sortService){
        this.sortService = sortService;
    }

    @RequestMapping(value = "/sort", method = RequestMethod.POST)
    public List<Integer> sortNumberList(@RequestBody List<Integer> unsortedList) {
        int[] sortedList = sortService.sortNumbers(Ints.toArray(unsortedList));
        return Ints.asList(sortedList);
    }


}
