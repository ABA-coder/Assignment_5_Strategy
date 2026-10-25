package com.company;

import java.util.List;

public final class StudyPlanner {
    private StudyPlanStrategy strategy;

    public StudyPlanner(StudyPlanStrategy strategy) {
        setStrategy(strategy);
    }

    public void setStrategy(StudyPlanStrategy strategy) {
        if (strategy == null) {
            throw new IllegalArgumentException("Strategy cannot be null.");
        }
        this.strategy = strategy;
    }

    public List<String> createPlan(List<String> topics, int hoursPerWeek, int weeks) {
        return strategy.createPlan(topics, hoursPerWeek, weeks);
    }
}
