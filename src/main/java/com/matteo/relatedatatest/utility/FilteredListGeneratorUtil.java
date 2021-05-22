package com.matteo.relatedatatest.utility;

import com.matteo.relatedatatest.model.*;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class FilteredListGeneratorUtil {

  /**
   * The method is responsible for filtering the data returned after
   * parsing the .json file - it requires and empty List<List<Object>>
   * that will be populated with the data for either the chart or the table.
   * This list is required in order for Google charts to work properly.
   *
   * @param outList - the list we wish to populate
   * @param chartModels - the unfiltered list
   * @param entryClass - the class type
   */
  public void fillChartDataList(List<List<Object>> outList,
      List<ChartModel> chartModels, Class entryClass) {

    List<Entry> entries = new ArrayList<>();

    for (ChartModel chartModel : chartModels) {
      Entry entry;
      // Determine the type of list we need
      if (entryClass.equals(ChartEntry.class)) {
        entry = new ChartEntry(chartModel.getDateTime());
      } else {
        entry = new TableEntry(chartModel.getDateTime());
      }

      int indexOfEntry = entries.indexOf(entry);

      if (indexOfEntry != -1) {
        entry = entries.get(indexOfEntry);
        entry.increment(chartModel.getSeverityLevels());
        entries.set(indexOfEntry, entry);

      } else {
        entry.increment(chartModel.getSeverityLevels());
        entries.add(entry);
      }
    }
    // Populate the list
    for (Entry entry : entries) {
      outList.add(entry.getFieldsAsList());
    }
  }
}
