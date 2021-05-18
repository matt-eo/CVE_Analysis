package com.matteo.relatedatatest.utility;

import com.matteo.relatedatatest.model.ChartModel;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class FilteredListGeneratorUtil {

  public List<List<Object>> getFilteredChartDataListPerMonth(List<ChartModel> chartModels) {
    List<List<Object>> returnValue = new ArrayList<>();

    returnValue.add(List.of("Year", "LOW", "MEDIUM", "HIGH", "CRITICAL"));

    Map<String, Map<String, Integer>> values = new LinkedHashMap<>();

    for (ChartModel model : chartModels) {
      String year = String.valueOf(model.getDateTime().getYear());
      String month = String.valueOf(model.getDateTime().getMonth());
      String key = month + year;
      String severity = model.getSeverityLevels().toString();

      if (!values.containsKey(key)) {
        values.put(key, new HashMap<>());
      } else {
        if (!values.get(key).containsKey(severity)) {
          values.get(key).put(severity, 1);
        } else {
          values.get(key).put(severity, values.get(key).get(severity) + 1);
        }
      }
    }

    for (Map.Entry<String, Map<String, Integer>> entry : values.entrySet()) {
      int low = entry.getValue().getOrDefault("LOW", 0);
      int medium = entry.getValue().getOrDefault("MEDIUM", 0);
      int high = entry.getValue().getOrDefault("HIGH", 0);
      int critical = entry.getValue().getOrDefault("CRITICAL", 0);

      returnValue.add(List.of(entry.getKey(), low, medium, high, critical));
    }

    return returnValue;
  }

  public List<List<Object>> getFilteredChartDataListPerYear(List<ChartModel> chartModels) {
    List<List<Object>> returnValue = new ArrayList<>();

    Map<String, Map<String, Integer>> values = new LinkedHashMap<>();

    for (ChartModel model : chartModels) {
      String year = String.valueOf(model.getDateTime().getYear());
      String severity = model.getSeverityLevels().toString();

      if (!values.containsKey(year)) {
        values.put(year, new HashMap<>());
      } else {
        if (!values.get(year).containsKey(severity)) {
          values.get(year).put(severity, 1);
        } else {
          values.get(year).put(severity, values.get(year).get(severity) + 1);
        }
      }
    }

    for (Map.Entry<String, Map<String, Integer>> entry : values.entrySet()) {
      int low = entry.getValue().getOrDefault("LOW", 0);
      int medium = entry.getValue().getOrDefault("MEDIUM", 0);
      int high = entry.getValue().getOrDefault("HIGH", 0);
      int critical = entry.getValue().getOrDefault("CRITICAL", 0);

      returnValue.add(List.of(entry.getKey(), low, medium, high, critical));
    }

    return returnValue;
  }
}
