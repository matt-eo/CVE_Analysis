package com.matteo.relatedatatest.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class ChartModel {

  private LocalDateTime dateTime;
  private SeverityLevels severityLevels;
}
