package com.company;

import java.util.ArrayList;
import java.util.List;

public final class ExamPreparationStrategy implements StudyPlanStrategy {
    @Override
    public String getName() {
        return "Exam preparation";
    }

    @Override
    public List<String> createPlan(List<String> topics, int hoursPerWeek, int weeks) {
        List<String> plan = new ArrayList<>();
        int reviewHours = Math.max(1, hoursPerWeek / 3);
        int practiceHours = hoursPerWeek - reviewHours;

        for (int week = 1; week <= weeks; week++) {
            String topic = topics.get((week - 1) % topics.size());
            if (week == weeks) {
                plan.add("Week " + week + ": Review " + topic + " for " + reviewHours
                        + " hours, then take a mock exam and review mistakes for "
                        + practiceHours + " hours.");
            } else {
                plan.add("Week " + week + ": Review " + topic + " for " + reviewHours
                        + " hours and complete timed questions for " + practiceHours + " hours.");
            }
        }

        return plan;
    }
}
