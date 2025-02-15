# Proyecto de Refactorización | Bootcamp Avanzado de Java - Codigofacilito

**English version: [README](README.md)**

## Fase 1: Corrección de Errores

### Descripción General
La versión original de este proyecto fue diseñada para procesar y listar datos de canciones de Spotify desde un archivo JSON. Sin embargo, la implementación inicial presentaba varios problemas, incluyendo tipos de datos incorrectos, un manejo inadecuado de excepciones y la implementación innecesaria de ciertos campos. En esta fase de **corrección de errores**, nuestro objetivo es resolver estos problemas críticos para que la aplicación pueda leer, analizar y procesar de manera confiable los datos de la lista de reproducción.

### Mejoras clave
- **Corrección de Tipos de Datos:**  
  - Actualizar el modelo `Song` para que los campos como `explicit`, `playable` y `popularity` reflejen correctamente sus tipos de datos previstos.
  
- **Eliminación de Campos Innecesarios:**  
  - Eliminar el campo `genres` de la clase `SpotifyArtist`, ya que no es requerido por la API de Spotify para listas de reproducción.
  
- **Mejoras en el Manejo de Excepciones:**  
  - Mejorar el manejo de errores en `ExampleFileUtils` para garantizar una lectura y análisis robusto de archivos JSON.
  - Fortalecer la gestión de excepciones en `PropertyFactory` durante la carga del archivo de configuración.
  - Agregar validaciones en `SongProcessor` para evitar fallos cuando se procesan datos mal formateados o faltantes.

- **Validación Básica de Datos:**  
  - Asegurar que todas las claves requeridas estén presentes y no sean nulas al analizar los datos JSON. Se lanzarán excepciones significativas cuando falten datos o sean incorrectos.

### Limitaciones Conocidas
- **Un Solo Artista por Canción:**  
  - En esta fase, `SongProcessor` sigue asignando solo un artista por canción, aunque una canción pueda contar con múltiples artistas. Este problema se reconoce y será abordado en fases posteriores.
