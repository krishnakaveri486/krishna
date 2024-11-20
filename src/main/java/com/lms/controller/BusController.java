package com.lms.controller;

import com.lms.entity.Bus;
import com.lms.entity.Post;
import com.lms.repository.BusRepository;
import com.lms.repository.PostRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/bus")
public class BusController {
    private BusRepository busRepository;


    public BusController(BusRepository busRepository) {
        this.busRepository = busRepository;
    }
    @PostMapping
    public String createBus(
            @RequestBody Bus bus
    ){
        busRepository.save(bus);
        return "saved successfully";
    }
}
