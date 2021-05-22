package com.matteo.relatedatatest.controller;

import com.matteo.relatedatatest.service.ChartService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/api/v1/")
public class ChartController {

  private final ChartService chartService;

  public ChartController(ChartService chartService) {
    this.chartService = chartService;
  }

  @RequestMapping(value = "chart", method = RequestMethod.GET)
  public String getChart(Model model) {
    List<List<Object>> chartDataList = chartService.getChartData();
    List<List<Object>> tableDataList = chartService.getTableData();
    model.addAttribute("dataPointsList", chartDataList);
    model.addAttribute("tableDataList", tableDataList);
    return "index";
  }

}
