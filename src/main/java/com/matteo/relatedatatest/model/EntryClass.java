package com.matteo.relatedatatest.model;

public abstract class EntryClass {

    protected int lowCount;
    protected int mediumCount;
    protected int highCount;
    protected int criticalCount;

    public void increment(SeverityLevels severityLevels) {
        switch (severityLevels) {
            case LOW:
                lowCount++;
                break;
            case MEDIUM:
                mediumCount++;
                break;
            case HIGH:
                highCount++;
                break;
            case CRITICAL:
                criticalCount++;
                break;
        }
    }
}
