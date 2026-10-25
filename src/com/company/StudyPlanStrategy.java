package com.company;

import java.util.List;

public interface StudyPlanStrategy {
    String getName();

    List<String> createPlan(List<String> topics, int hoursPerWeek, int weeks);
}
