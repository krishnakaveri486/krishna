package com.lms.controller;

import com.lms.entity.Bus;
import com.lms.entity.Stop;
import com.lms.repository.CommentRepository;
import com.lms.repository.PostRepository;
import com.lms.repository.StopRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/stop")
public class StopController {
    private StopRepository stopRepository;


    public StopController(StopRepository stopRepository) {
        this.stopRepository = stopRepository;
    }
    @PostMapping
    public String createStop(
            @RequestBody Stop stop
    ){
        stopRepository.save(stop);
        return "saved successfully";
    }
}
