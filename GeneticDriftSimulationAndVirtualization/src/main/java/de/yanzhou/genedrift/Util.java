package de.yanzhou.genedrift;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.DoubleStream;

public class Util {
  public List<Double> geneDrift(int population, double frequency, int generations){
    List<Double> list = new ArrayList<>();
    list.add(frequency);
    while(generations != 0) {
      double currentFrequency = frequency;
      long count = DoubleStream.generate(Math::random).limit(population).filter(i -> i < currentFrequency).count();
      frequency = (double)count / population;
      list.add(frequency);
      generations--;
    }
    return list;
  }
}
