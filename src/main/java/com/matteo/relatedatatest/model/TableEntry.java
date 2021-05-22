package com.matteo.relatedatatest.model;

import java.time.LocalDateTime;
import java.util.List;

public class TableEntry extends EntryClass implements Entry {

    private String year;

    public TableEntry(LocalDateTime dateTime) {
        this.year = String.valueOf(dateTime.getYear());
    }

    /**
     * Returns the fields as a list - this format is required
     * for Google charts to work
     *
     * @return - the fields as list
     */
    @Override
    public List<Object> getFieldsAsList() {
        return List.of(year, lowCount, mediumCount, highCount, criticalCount);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TableEntry that = (TableEntry) o;

        return year.equals(that.year);
    }

    @Override
    public int hashCode() {
        return year.hashCode();
    }
}
