# Tutoring Application

Java Spring Boot application for managing students and conducted lessons. The database consists of `Student` and `Lesson` tables. Former stores data structured in 3 columns:

| student_id | name    | surname |
| ---------- | ------- | ------- |
| 100        | Andrew  | Bernard |
| 101        | Dwight  | Schrute |
| 102        | Michael | Scott   |

and the latter uses 10 of them to describe each lesson:

| lesson_id | student_id | lesson_date | start_time | finish_time | duration | description        | wage | to_pay | payment |
| --------- | ---------- | ----------- | ---------- | ----------- | -------- | ------------------ | ---- | ------ | ------- |
| 10        | 100        | 2022-11-16  | 18:00:00   | 19:30:00    | 01:30:00 | Trigonometry       | 60   | 90     | 100     |
| 11        | 102        | 2022-11-16  | 19:45:00   | 21:15:00    | 01:30:00 | Quadratic function | 60   | 90     | 90      |
| 12        | 100        | 2022-11-18  | 18:00:00   | 19:30:00    | 01:30:00 | Matrices           | 60   | 90     | 100     |
| 13        | 101        | 2022-11-18  | 20:00:00   | 21:30:00    | 01:30:00 | Polynomials        | 60   | 90     | 0       |

The database initialization code in SQL can be found here: `src/main/resources/TutoringDatabase.sql`.

## Requirements

- [JDK Development Kit](https://www.oracle.com/pl/java/technologies/downloads/)
- [Apache Maven](https://maven.apache.org/index.html)

## Quickstart

1. Clone the repository: `git clone https://github.com/bartoszbartosik/tutoring-app.git`.
2. Set up your database connection in `application.properties` (path: `src/main/resources/application.properties`).
3. Run the `main` method of `TutoringApplication` class.

## Endpoints

- http://localhost:8765/tutoringapp/students/
- http://localhost:8765/tutoringapp/students/{student_id}
- http://localhost:8765/tutoringapp/lessons/
- http://localhost:8765/tutoringapp/lessons/{lesson_id}
