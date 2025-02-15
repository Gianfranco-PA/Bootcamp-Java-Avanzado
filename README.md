# Refactor Project | Advanced Java Bootcamp - Codigofacilito

**Version en español: [README](README-ES.md)**

## Phase 2: Refactor Iteration 1

### Overview
In this iteration, we significantly reorganize the project structure to improve maintainability and better model the domain. Building upon the fixes applied in Phase 1, the focus now is on refactoring the data models and service layers to support a more realistic representation of playlist data. This iteration introduces new classes for **Album**, **Artist**, and **PlayList**, and updates the **Song** class accordingly. It also implements a factory pattern for playlist services and a modular file parsing strategy.

### Key Improvements

- **Domain Model Enhancements:**
  - **Album Class:**  
    A dedicated `Album` class has been created to encapsulate album-related data such as ID, name, release date, total tracks, and album type. This separates album information from the `Song` class.
  
  - **Artist Class:**  
    The original `SpotifyArtist` has been renamed and refactored to `Artist`. This class now only contains relevant artist information (ID and name), removing unnecessary or unused fields.
  
  - **PlayList Class:**  
    A new `PlayList` class has been introduced to manage a collection of `Song` objects. This class provides methods for adding and removing songs and serves as a container for the processed playlist data.
  
  - **Song Class Adjustments:**  
    The `Song` class has been updated to:
    - Store its album information as an `Album` object rather than using separate album-related fields.
    - Maintain a list of `Artist` objects, allowing multiple artists per song instead of limiting to one.

- **Service Layer Refactoring:**
  - A new interface `IPlaylistService` has been introduced along with its implementation `SpotifyPlaylistJsonService`, which uses the refactored domain models to produce a `PlayList` object.
  - A factory pattern has been implemented in `PlaylistServiceFactory` to encapsulate the creation of the playlist service based on configuration properties.

- **File Parsing Improvements:**
  - The file parsing mechanism has been modularized with the introduction of the `IFileParser` interface and its concrete implementation `JsonFileParser`.
  - A factory class (`FileParserFactory`) is used to obtain the correct file parser based on the file type.
  - Existing utilities such as `ResourceFileLoader` and `JsonValidationUtils` have been retained to support robust file handling and JSON validation.