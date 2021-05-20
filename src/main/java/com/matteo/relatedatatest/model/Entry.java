package com.matteo.relatedatatest.model;

import java.util.List;

public interface Entry {
  List<Object> getFieldsAsList();

  void increment(SeverityLevels severityLevels);
}
