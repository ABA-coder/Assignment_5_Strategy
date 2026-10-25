# Study Plan Strategy Pattern

This Java console application creates study plans using the Strategy design pattern. The user enters a subject, topics, available hours, and a number of weeks, then chooses a planning approach. The strategy can be changed repeatedly during the same run.

## Strategies

- **Exam preparation** cycles through the topics in priority order, divides each week between review and timed questions, and ends with a mock exam.
- **Skill building** divides every week between learning, practice, and reflection.
- **Project based** starts with a prototype, builds topic-based features, and ends with integration, testing, and a presentation.

## Pattern roles

| Role | Class | Responsibility |
| --- | --- | --- |
| Strategy interface | `StudyPlanStrategy` | Defines the common `createPlan` method. |
| Concrete strategies | `ExamPreparationStrategy`, `SkillBuildingStrategy`, `ProjectBasedStrategy` | Create different weekly plans. |
| Context | `StudyPlanner` | Stores a strategy, delegates plan creation, and allows runtime switching. |
| Client | `Main` | Collects input, selects a strategy, and prints the plan. |

The context contains no conditional logic about strategy types.

## Build and run

Java 8 or newer is required. In PowerShell, run these commands from the project directory:

```powershell
$sources = Get-ChildItem -Recurse src -Filter *.java | ForEach-Object FullName
javac -d build $sources
java -cp build com.company.Main
```

Example input:

```text
Subject: Java
Topics, separated by commas: Collections, Streams, Testing
Hours per week (3-40): 8
Number of weeks (3-12): 4
Selection: 1
Selection: 2
Selection: 3
Selection: 0
```

Selecting 1, 2, and 3 in the same session demonstrates runtime strategy switching.

## Clean Code principles

1. **Single Responsibility Principle:** Each concrete strategy implements one planning algorithm. `StudyPlanner` delegates, and `Main` handles input and output.
2. **Open/Closed Principle:** A new algorithm can implement `StudyPlanStrategy` and be supplied to `StudyPlanner` without changing the context or existing strategies.
3. **Dependency Inversion Principle:** `StudyPlanner` depends on `StudyPlanStrategy`, not on any concrete strategy class.
4. **Meaningful names:** Names such as `ExamPreparationStrategy`, `StudyPlanner`, and `createPlan` explain the purpose of each component.
5. **Polymorphism over strategy conditionals:** The context calls the same interface method for every algorithm. It does not check which concrete strategy it received.
6. **Input validation:** `Main` checks the required text and numeric ranges before creating a plan.

To add another planning algorithm, create a class that implements `StudyPlanStrategy` and register it in the client's strategy menu. The context and the existing strategies do not need changes.
