package com.company;

import java.util.ArrayList;
import java.util.List;

public final class ProjectBasedStrategy implements StudyPlanStrategy {
    @Override
    public String getName() {
        return "Project based";
    }

    @Override
    public List<String> createPlan(List<String> topics, int hoursPerWeek, int weeks) {
        List<String> plan = new ArrayList<>();
        plan.add("Week 1: Define a project, set milestones, and prototype " + topics.get(0)
                + " for " + hoursPerWeek + " hours.");

        for (int week = 2; week < weeks; week++) {
            String topic = topics.get((week - 1) % topics.size());
            plan.add("Week " + week + ": Build a project feature using " + topic
                    + " and record the result in " + hoursPerWeek + " hours.");
        }

        plan.add("Week " + weeks + ": Integrate the features, test the project, and present the result in "
                + hoursPerWeek + " hours.");
        return plan;
    }
}
