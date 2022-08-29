package de.yanzhou.genedrift;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
public class GeneDriftController {

  @PostMapping("/get-simulation-data")
  public ResponseEntity<Map<String, List<Double>>> getSimulationData(
          @RequestParam(name="trials", required=false, defaultValue="20") int trials,
          @RequestParam(name="population", required=false, defaultValue="40") int population,
          @RequestParam(name="initFrequency", required=false, defaultValue="0.2") double initFrequency,
          @RequestParam(name="generations", required=false, defaultValue="100") int generations) {
    Map<String, List<Double>> simulationData = new HashMap<>();
    Util util = new Util();
    for(int i=0;i<trials;i++){
      List<Double> list = util.geneDrift(population, initFrequency, generations);
      simulationData.put(i+1 + " trial:", list);
    }
    return new ResponseEntity<>(simulationData, HttpStatus.OK);
  }

}
