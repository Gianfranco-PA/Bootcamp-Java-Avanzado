# Refactor Project | Advanced Java Bootcamp - Codigofacilito

**Version en español: [README](README-ES.md)**

## Phase 3: Refactor Iteration 2

### Overview
In this iteration, the system is refactored to support an agnostic playlist model that contains only the essential song information for display. The goal is to decouple the domain from extraneous album or artist details and focus on presenting the core playlist data in a consistent format. This iteration also applies several design patterns to improve maintainability and scalability.

### Key Improvements

- **Agnostic Playlist Model:**  
  - The domain is simplified to include only the essential information (song ID, name, album, and list of artist names) needed for display.
  
- **Design Pattern Applications:**  
  - **Template Method Pattern:** Standardizes the workflow for playlist services.
  - **Strategy Pattern:** Enables interchangeable display strategies through the `PlaylistDisplayStrategy` interface and its implementation (`DefaultPlaylistDisplayStrategy`).
  - **Facade Pattern:** Provides a simplified interface via `PlaylistFacade` for accessing the playlist functionality.
  
- **Cleanup and Reorganization:**  
  - Removed unused classes from earlier phases (e.g., `ExampleFileUtils` and `PropertyFactory`).
  - Reorganized the code to clearly separate configuration, display, domain, service, and utility layers.