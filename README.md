# Refactor Project | Advanced Java Bootcamp - Codigofacilito

## Part 1 - Fix Bugs and Refactor

### Context
The initial project aims to structure and list data of Spotify songs from a file. It is necessary to refactor the code to use other song services.

### Bugs

The project can display the ID, name of the song, name of the artist, and name of the album. However, the metadata is not saved in the correct variable types and does not handle some important exceptions.

List of bugs:
- [X] Types of explicit, playable, and popularity variables in the `Song` class.
- [ ] The `genres` variable is unused in `SpotifyArtist`. Additionally, it is a `LinkedList` of `SpotifyArtist` within a `SpotifyArtist` class, which is unnecessary.
- [ ] Improve exception handling in `ExampleFileUtils`.
- [ ] Improve exception handling in `PropertyFactory`.
- [ ] Improve exception handling in `SongProcessor`.
- [ ] The `SongProcessor` class only saves one artist, and the `Song` class only allows one artist per song.

## Part 2 - Upgrade Java Version