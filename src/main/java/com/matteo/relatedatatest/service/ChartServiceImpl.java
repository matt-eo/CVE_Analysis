package com.matteo.relatedatatest.service;

import com.matteo.relatedatatest.model.ChartEntry;
import com.matteo.relatedatatest.model.TableEntry;
import com.matteo.relatedatatest.repository.ChartData;
import com.matteo.relatedatatest.utility.FilteredListGeneratorUtil;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ChartServiceImpl implements ChartService {

  private final ChartData chartData;
  private final FilteredListGeneratorUtil filteredListGeneratorUtil;

  public ChartServiceImpl(
      ChartData chartData, FilteredListGeneratorUtil filteredListGeneratorUtil) {
    this.chartData = chartData;
    this.filteredListGeneratorUtil = filteredListGeneratorUtil;
  }

  @Override
  public List<List<Object>> getChartData() {
    List<List<Object>> returnValue = new ArrayList<>();
    returnValue.add(List.of("Year", "LOW", "MEDIUM", "HIGH", "CRITICAL"));

    filteredListGeneratorUtil.fillChartDataList(
        returnValue, chartData.getChartDataFromFile(), ChartEntry.class);

    return returnValue;
  }

  @Override
  public List<List<Object>> getTableData() {
    List<List<Object>> returnValue = new ArrayList<>();

    filteredListGeneratorUtil.fillChartDataList(
        returnValue, chartData.getChartDataFromFile(), TableEntry.class);

    return returnValue;
  }
}
