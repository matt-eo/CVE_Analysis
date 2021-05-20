package com.matteo.relatedatatest.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@ToString
public class ChartEntry extends EntryClass implements Entry {

  private String monthYear;

  public ChartEntry(LocalDateTime dateTime) {
    this.monthYear = dateTime.getMonth().toString() + dateTime.getYear();
  }

  @Override
  public List<Object> getFieldsAsList() {
    return List.of(monthYear, lowCount, mediumCount, highCount, criticalCount);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    ChartEntry that = (ChartEntry) o;

    return monthYear.equals(that.monthYear);
  }

  @Override
  public int hashCode() {
    return monthYear.hashCode();
  }
}
