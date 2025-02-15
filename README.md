# Refactor Project | Advanced Java Bootcamp - Codigofacilito

**Versión en español: [README](README-ES.md)**

## Phase 4: Upgrade to Java 23

### Overview
This branch represents the final, unified version of the project. All previous iterations (fix-bugs, refactor-iteration-1, and refactor-iteration-2) have been merged, and the project has been upgraded from Java 1.8 to Java 23. This upgrade allows us to take full advantage of modern Java language features such as records, pattern matching, switch expressions, and local variable type inference (var), improving code readability, performance, and maintainability.

### Key Upgrades and Improvements

- **Java 23 Upgrade:**
  - Maven compiler settings have been updated to target Java 23.
  - New language features (records, pattern matching for instanceof, switch expressions, and var) have been integrated to modernize the codebase.

- **Modernized Domain and Service Layers:**
  - DTOs for Spotify data have been refactored into Java records to eliminate boilerplate and enforce immutability.
  
- **Enhanced Logging and Exception Handling:**
  - Logging is now implemented with SLF4J and Logback (version 1.5.16) to provide detailed runtime insights.

## Project Evolution Overview

This project evolved through several key phases (each is a branch):
- **Phase 1: Fix Bugs** – Resolved core issues such as incorrect data types, inadequate exception handling, and removal of unnecessary fields.
- **Phase 2: Refactor Iteration 1** – Enhanced the domain model by introducing dedicated classes for Album, Artist, and Playlist, and improved the service layer with a factory pattern.
- **Phase 3: Refactor Iteration 2** – Adopted an agnostic playlist model and applied design patterns (Template Method, Strategy, Facade) to further streamline the architecture.
- **Current (phase 4): Upgrade to Java 23** – Unified all previous iterations and modernized the codebase using Java 23 features (records, pattern matching, switch expressions, and var).
