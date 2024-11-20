package com.lms.controller;

import com.lms.entity.Bus;
import com.lms.entity.BusStop;
import com.lms.entity.Stop;
import com.lms.repository.BusRepository;
import com.lms.repository.BusStopRepository;
import com.lms.repository.StopRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/busStop")
public class BusStopController {
    private BusRepository busRepository;
    private StopRepository stopRepository;
    private BusStopRepository busStopRepository;

    public BusStopController(BusRepository busRepository, StopRepository stopRepository, BusStopRepository busStopRepository) {
        this.busRepository = busRepository;
        this.stopRepository = stopRepository;
        this.busStopRepository = busStopRepository;
    }

    @PostMapping
    public ResponseEntity<BusStop> allocateBusRoute(
            @RequestParam Long busId,
            @RequestParam Long stopId,
            @RequestBody BusStop busStop

    ){
        Bus bus = busRepository.findById(busId).get();
        Stop stop = stopRepository.findById(stopId).get();


        busStop.setBus(bus);
        busStop.setStop(stop);

        BusStop savedEntity = busStopRepository.save(busStop);
        return new ResponseEntity<>(savedEntity, HttpStatus.CREATED);
    }
}
