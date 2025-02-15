# Proyecto de Refactorización | Bootcamp Avanzado de Java - Codigofacilito

**English version: [README](README.md)**

## Fase 2: Primera Iteración de Refactorización

### Descripción General
En esta iteración, reorganizamos significativamente la estructura del proyecto para mejorar su mantenibilidad y modelar mejor el dominio. Basándonos en las correcciones aplicadas en la Fase 1, el enfoque ahora está en refactorizar los modelos de datos y las capas de servicio para proporcionar una representación más realista de los datos de las listas de reproducción. Esta iteración introduce nuevas clases para **Álbum (Album)**, **Artista (Artist)** y **Lista de Reproducción (PlayList)**, y actualiza la clase **Canción (Song)** en consecuencia. También implementa un patrón de fábrica para los servicios de listas de reproducción y una estrategia modular para el análisis de archivos.

### Mejoras Clave

- **Mejoras en el Modelo de Dominio:**
  - **Clase Álbum (`Album`):**  
    Se ha creado una clase `Album` dedicada para encapsular datos relacionados con los álbumes, como ID, nombre, fecha de lanzamiento, número total de pistas y tipo de álbum. Esto separa la información del álbum de la clase `Song`.
  
  - **Clase Artista (`Artist`):**  
    La clase original `SpotifyArtist` ha sido renombrada y refactorizada como `Artist`. Ahora solo contiene la información relevante del artista (ID y nombre), eliminando campos innecesarios o no utilizados.
  
  - **Clase Lista de Reproducción (`PlayList`):**  
    Se ha introducido una nueva clase `PlayList` para gestionar una colección de objetos `Song`. Esta clase proporciona métodos para agregar y eliminar canciones y sirve como contenedor para los datos procesados de la lista de reproducción.
  
  - **Ajustes en la Clase Canción (`Song`):**  
    La clase `Song` ha sido actualizada para:
    - Almacenar la información del álbum como un objeto `Album`, en lugar de usar campos separados relacionados con el álbum.
    - Mantener una lista de objetos `Artist`, permitiendo múltiples artistas por canción en lugar de limitarlo a uno solo.

- **Refactorización de la Capa de Servicio:**
  - Se ha introducido una nueva interfaz `IPlaylistService` junto con su implementación `SpotifyPlaylistJsonService`, que utiliza los modelos de dominio refactorizados para producir un objeto `PlayList`.
  - Se ha implementado un patrón de fábrica en `PlaylistServiceFactory` para encapsular la creación del servicio de listas de reproducción basado en las propiedades de configuración.

- **Mejoras en el Análisis de Archivos:**
  - El mecanismo de análisis de archivos ha sido modularizado con la introducción de la interfaz `IFileParser` y su implementación concreta `JsonFileParser`.
  - Se ha añadido una clase de fábrica (`FileParserFactory`) para obtener el analizador de archivos correcto según el tipo de archivo.
  - Se han mantenido utilidades existentes como `ResourceFileLoader` y `JsonValidationUtils` para garantizar un manejo sólido de archivos y una validación robusta de JSON.
