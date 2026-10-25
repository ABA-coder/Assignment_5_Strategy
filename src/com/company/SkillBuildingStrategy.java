package com.company;

import java.util.ArrayList;
import java.util.List;

public final class SkillBuildingStrategy implements StudyPlanStrategy {
    @Override
    public String getName() {
        return "Skill building";
    }

    @Override
    public List<String> createPlan(List<String> topics, int hoursPerWeek, int weeks) {
        List<String> plan = new ArrayList<>();
        int theoryHours = Math.max(1, hoursPerWeek / 3);
        int practiceHours = hoursPerWeek - theoryHours - 1;

        for (int week = 1; week <= weeks; week++) {
            String topic = topics.get((week - 1) % topics.size());
            plan.add("Week " + week + ": Learn " + topic + " for " + theoryHours
                    + " hours, practice it for " + practiceHours + " hours, and reflect for 1 hour.");
        }

        return plan;
    }
}
