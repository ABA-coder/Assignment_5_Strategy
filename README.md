# Assignment 5 - Strategy Pattern

For this assignment, I made a study planner in Java. The program asks for a subject, topics, hours per week, and the number of weeks. Then I can choose how I want to study. I can switch to another plan during the same run.


## Strategies

- **Exam preparation:** Reviews topics and uses timed questions. The last week includes a mock exam.
- **Skill building:** Splits the time between learning, practice, and reflection.
- **Project based:** Starts with a prototype, builds features in the middle weeks, and finishes with testing and a presentation.

## How I used Strategy

`StudyPlanStrategy` is the common interface. The three strategy classes implement its `createPlan` method in different ways. `StudyPlanner` keeps a reference to the selected strategy and calls that method. `Main` takes input and lets me change the strategy while the program is running.

The planner does not check which concrete strategy it has. It only works with the interface.

## Example

I can enter `Java` as the subject, `Collections, Streams, Testing` as the topics, `8` hours per week, and `4` weeks. Then I can enter `1`, `2`, or `3` to see each plan. Entering `0` exits the program.

## Clean Code principles I used

1. **Single responsibility:** Each strategy creates only one type of plan. `StudyPlanner` delegates the work, while `Main` handles the console input and output.
2. **Meaningful names:** Names like `ExamPreparationStrategy`, `StudyPlanner`, and `createPlan` show what each part does.
3. **Open/closed principle:** I can add another strategy by implementing `StudyPlanStrategy`. I do not need to change `StudyPlanner` or the existing strategies.
4. **Dependency on an interface:** `StudyPlanner` uses `StudyPlanStrategy` instead of depending on one concrete strategy class.
5. **Polymorphism instead of conditions:** The planner calls the same `createPlan` method for every strategy. There is no `if` or `switch` for strategy types inside the planner.
6. **Input validation:** `Main` checks that the text is not empty and that the numbers are within the allowed ranges.
