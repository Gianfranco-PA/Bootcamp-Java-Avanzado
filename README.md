# Refactor Project | Advanced Java Bootcamp - Codigofacilito

## Part 1 - Fix Bugs and Refactor

### Context
The initial project aims to structure and list data of Spotify songs from a file. It is necessary to refactor the code to use other song services.

### Bugs

The project can display the ID, name of the song, name of the artist, and name of the album. However, the metadata is not saved in the correct variable types and does not handle some important exceptions.

List of bugs:
- [X] Types of `explicit`, `playable`, and `popularity` fields in the `Song` class.
- [X] The `genres` field in SpotifyArtist is unnecessary and incorrectly implemented.
  - In addition, the `genres` field does not exist in the Spotify API for playlists, according to the [Spotify API documentation](https://developer.spotify.com/documentation/web-api/concepts/playlists).
- [ ] Improve exception handling in `ExampleFileUtils`.
- [ ] Improve exception handling in `PropertyFactory`.
- [ ] Improve exception handling in `SongProcessor`.
- [ ] The `SongProcessor` class only saves one artist, and the `Song` class only allows one artist per song.

## Part 2 - Upgrade Java Version