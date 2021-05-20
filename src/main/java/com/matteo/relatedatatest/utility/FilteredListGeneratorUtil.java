package com.matteo.relatedatatest.utility;

import com.matteo.relatedatatest.model.*;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class FilteredListGeneratorUtil {

  public void fillChartDataList(List<List<Object>> outList,
      List<ChartModel> chartModels, Class entryClass) {

    List<Entry> entries = new ArrayList<>();

    for (ChartModel chartModel : chartModels) {
      Entry entry;

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

    for (Entry entry : entries) {
      outList.add(entry.getFieldsAsList());
    }
  }
}
