package com.thoughtworks.gauge.execution.runner.event;

public class ExecutionResult {
    public String status;
    public Integer time;
    public String out;
    public ExecutionError[] errors;
    public ExecutionError beforeHookFailure;
    public ExecutionError afterHookFailure;
    public TableInfo table;

    public boolean skipped() {
        return status.equalsIgnoreCase(ExecutionEvent.SKIP);
    }

    public boolean failed() {
        return status.equalsIgnoreCase(ExecutionEvent.FAIL);
    }
}
