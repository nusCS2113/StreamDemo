# Project context

- This repository is used to develop a Java project to demonstrate the use of
  Streams in Java for  an introductory software engineering course in an
  undergraduate computer science program. It complements a small lecture segment
  on the same topic
- Lecture learning objectives are as follows
    - Explain Java Streams and how they introduce functional programming
      concepts into Java 
    - Understand and use stream operations
    - Understand how lambda expressions represent anonymous functions
    - Use lambda expressions within stream operations

# Repository structure

- This repository should follow a typical Gradle project structure, with the
  following directories:
    - `src/main/java`: Contains the main Java source code for the project
    - `src/test/java`: Contains unit tests for the project
    - `docs`: Contains any additional documentation or resources related to the
      project

# Build and run
- The project uses Gradle as the build tool. To build the project, run the
  following command in the root directory of the repository:
  ```
  ./gradlew clean
  ./gradlew check test
  ./gradlew build
  ```

# Code style and conventions
- Follow coding standards specified in the config/checkstyle.xml file
- For any missing coding standards from the checkstyle.xml file, follow the
  Google Java Style Guide (https://google.github.io/styleguide/javaguide.html)
- Base package for the project is `org.cs2113.streams` 
  - Sub-packages should be by layer, e.g., `org.cs2113.streams.ui`,
    `org.cs2113.streams.logic`, and `org.cs2113.streams.data`. 

# Default user context
 The  user is a university lecturer who teaches software engineering to year 2
 and year 3 undergraduate students in a computer science program. 

When you respond to the user, incude the teaching points and why some
suggestions make sense in the context of teaching Streams usage to undergraduate
students.

# Architecture and design principles
- The project should follow a layered architecture, separating concerns into
  distinct layers such as presentation, business logic, and data access.
- Clear separation of concerns and single responsibility principle should be
  followed in the design of classes and methods. 

# Testing
- Unit tests should be written for all non-trivial methods and classes, using
  JUnit 5 as the testing framework.
- Unit tests should be placed in the `src/test/java` directory, following the
  same package structure as the main source code with the test names having the
  suffix `Test`. For example, if the class being tested is `MyClass`, the
  corresponding test class should be named `MyClassTest`.

# Agent guardrails
- **Always**:
  - provide explanations for any code generated, including the rationale for
    design choices and how they relate to the learning objectives of the course.
- **Ask first**
  - before any destruction of existing code, and provide a clear explanation of
    the impact of any changes. 
  - introducing any new dependencies or libraries, and explain why they are
    necessary and how they support the learning objectives of the course. 
  - before making any changes to the project structure, and explain how the changes
    support the learning objectives of the course.


# Profile of the user

- Has a good understanding of Java programming and software engineering
  principles
- May not have extenive experience with functional programming concepts and Java
  Streams. 

# Guidance for interacting with the user

- Explain the rationale for significant actions: what you did and why.
- Keep explanations brief but instructive, supporting learning through
  responsible use of AI. For example:
  - Add explanatory Javadoc comments to all classes and to nontrivial methods
    and fields when their purpose or behavior is not obvious.
  - Make generated code as self-explanatory as possible, and include explanatory
    comments where they improve understanding.
  - When faced with a design choice, choose the simplest option that is
    sufficient for the requirements, while briefly explaining relevant more
    advanced alternatives.