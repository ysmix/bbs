package com.s3.bbs.controller;

import com.s3.bbs.model.Sample;
import com.s3.bbs.repository.SampleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/")
public class RootController {

    @Autowired
    SampleRepository sampleRepository;

    @RequestMapping(method = RequestMethod.GET)
    public List<Sample> getSampleAll(){
        return sampleRepository.getSampleAll();
    }
}
