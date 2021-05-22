package com.matteo.relatedatatest.repository;

import com.matteo.relatedatatest.model.ChartModel;
import com.matteo.relatedatatest.model.SeverityLevels;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Repository
public class ChartData {

  @Value("${file.name}")
  private String fileName;
  private final List<ChartModel> unfilteredChartDataList;

  public ChartData(List<ChartModel> unfilteredChartDataList) {
    this.unfilteredChartDataList = unfilteredChartDataList;
  }

  public List<ChartModel> getChartDataFromFile() {
    JSONParser parser = new JSONParser();
    try {
      JSONObject object = (JSONObject) parser.parse(new FileReader(fileName));
      JSONArray array = (JSONArray) object.get("CVE_Items");

      for (Object o : array) {

        JSONObject item = (JSONObject) o;
        String publishedDate = (String) item.get("publishedDate");

        JSONObject impact = (JSONObject) item.get("impact");
        String severity;
        if (!impact.isEmpty()) {

          JSONObject baseMetricV2 = (JSONObject) impact.get("baseMetricV2");

          severity = (String) baseMetricV2.get("severity");

          ChartModel model = new ChartModel();
          model.setDateTime(LocalDateTime.parse(publishedDate, DateTimeFormatter.ISO_DATE_TIME));
          model.setSeverityLevels(SeverityLevels.valueOf(severity));

          unfilteredChartDataList.add(model);
        }
      }
    } catch (IOException | ParseException e) {
      e.printStackTrace();
    }
    return unfilteredChartDataList;
  }
}
