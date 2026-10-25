package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public final class Main {
    private Main() {
    }

    public static void main(String[] args) {
        StudyPlanStrategy[] strategies = {
                new ExamPreparationStrategy(),
                new SkillBuildingStrategy(),
                new ProjectBasedStrategy()
        };

        Scanner scanner = new Scanner(System.in);
        String subject = readText(scanner, "Subject: ");
        List<String> topics = readTopics(scanner);
        int hoursPerWeek = readInt(scanner, "Hours per week (3-40): ", 3, 40);
        int weeks = readInt(scanner, "Number of weeks (3-12): ", 3, 12);
        StudyPlanner planner = new StudyPlanner(strategies[0]);

        while (true) {
            System.out.println("\nChoose a study strategy:");
            for (int index = 0; index < strategies.length; index++) {
                System.out.println((index + 1) + ". " + strategies[index].getName());
            }
            System.out.println("0. Exit");

            int choice = readInt(scanner, "Selection: ", 0, strategies.length);
            if (choice == 0) {
                break;
            }

            StudyPlanStrategy selected = strategies[choice - 1];
            planner.setStrategy(selected);
            System.out.println("\n" + selected.getName() + " for " + subject);
            for (String activity : planner.createPlan(topics, hoursPerWeek, weeks)) {
                System.out.println(activity);
            }
        }
    }

    private static List<String> readTopics(Scanner scanner) {
        while (true) {
            String input = readText(scanner, "Topics, separated by commas: ");
            List<String> topics = new ArrayList<>();
            for (String topic : input.split(",", -1)) {
                if (!topic.trim().isEmpty()) {
                    topics.add(topic.trim());
                }
            }
            if (!topics.isEmpty()) {
                return topics;
            }
            System.out.println("Enter at least one topic.");
        }
    }

    private static String readText(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            String value = scanner.nextLine().trim();
            if (!value.isEmpty()) {
                return value;
            }
            System.out.println("This field cannot be empty.");
        }
    }

    private static int readInt(Scanner scanner, String prompt, int minimum, int maximum) {
        while (true) {
            System.out.print(prompt);
            try {
                int value = Integer.parseInt(scanner.nextLine().trim());
                if (value >= minimum && value <= maximum) {
                    return value;
                }
            } catch (NumberFormatException exception) {
                System.out.println("Enter a whole number.");
                continue;
            }
            System.out.println("Enter a number from " + minimum + " to " + maximum + ".");
        }
    }
}
