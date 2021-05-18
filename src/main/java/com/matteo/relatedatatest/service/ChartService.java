package com.matteo.relatedatatest.service;

import java.util.List;

public interface ChartService {

  List<List<Object>> getChartData();
  List<List<Object>> getTableData();
}
