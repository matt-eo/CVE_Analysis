package com.matteo.relatedatatest.service;

import com.matteo.relatedatatest.repository.ChartData;
import com.matteo.relatedatatest.utility.FilteredListGeneratorUtil;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChartServiceImpl implements ChartService {

  private final ChartData chartData;
  private FilteredListGeneratorUtil filteredListGeneratorUtil;

  public ChartServiceImpl(
      ChartData chartData, FilteredListGeneratorUtil filteredListGeneratorUtil) {
    this.chartData = chartData;
    this.filteredListGeneratorUtil = filteredListGeneratorUtil;
  }

  @Override
  public List<List<Object>> getChartData() {
    List<List<Object>> returnValue =
        filteredListGeneratorUtil.getFilteredChartDataListPerMonth(
            chartData.getChartDataFromFile());
    return returnValue;
  }

  @Override
  public List<List<Object>> getTableData() {
    List<List<Object>> returnValue =
        filteredListGeneratorUtil.getFilteredChartDataListPerYear(chartData.getChartDataFromFile());
    return returnValue;
  }
}
