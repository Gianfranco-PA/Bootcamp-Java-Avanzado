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
- [X] No exception handling in `ExampleFileUtils`.
- [X] No exception handling in `PropertyFactory`.
- [X] No exception handling in `SongProcessor`.

### Refactoring

The project can now be better than the original version, but it does not work efficiently.

List of improvements:
- [ ] The `SongProcessor` class only saves one artist, and the `Song` class only allows one artist per song.
  - In the `playlist.json` file, there are songs by only one artist, but a song can have multiple artists.
- [X] Create `Album` class to save Album data And update `Song` class.
- [X] Create `Playlist` class to save the list of `Song` class and implement display info method.
- [X] Rename `SpotifyArtist` to `Artist`
- [ ] Create `PlaylistFactory` class to apply factory pattern.

## Part 2 - Upgrade Java Version