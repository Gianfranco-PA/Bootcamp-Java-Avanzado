# Refactor Project | Advanced Java Bootcamp - Codigofacilito

**Version en español: [README](README-ES.md)**

## Phase 1: Fix Bugs

### Overview
The original version of this project was designed to process and list Spotify song data from a JSON file. However, the initial implementation had several issues, including incorrect data types, improper exception handling, and an unnecessary implementation of certain fields. In this **fix-bugs** phase, our focus is to resolve these critical issues so that the application can reliably read, parse, and process the playlist data.

### Key Improvements
- **Correct Data Types:**  
  - Update the `Song` model so that fields like `explicit`, `playable`, and `popularity` correctly reflect their intended data types.
  
- **Remove Unnecessary Fields:**  
  - Eliminate the `genres` field from the `SpotifyArtist` class as it is not required by the Spotify API for playlists.
  
- **Improve Exception Handling:**  
  - Enhance error handling in `ExampleFileUtils` to ensure robust reading and parsing of JSON files.
  - Strengthen the exception management in `PropertyFactory` during configuration file loading.
  - Add validations in `SongProcessor` to prevent crashes when processing malformed or missing data.

- **Basic Data Validation:**  
  - Ensure that all required keys are present and non-null when parsing JSON data. Meaningful exceptions are thrown when data is missing or incorrect.

### Known Limitations
- **Single Artist per Song:**
  - In this phase, the `SongProcessor` still assigns only one artist per song even though a song might feature multiple artists. This issue is acknowledged and will be addressed in later phases.