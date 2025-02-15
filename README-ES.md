# Proyecto de Refactorización | Bootcamp Avanzado de Java - Codigofacilito

**English version: [README](README.md)**

## Fase 3: Segunda Iteración de Refactorización

### Descripción General
En esta iteración, el sistema se refactoriza para admitir un modelo de lista de reproducción agnóstico que contenga únicamente la información esencial de las canciones para su visualización. El objetivo es desacoplar el dominio de detalles innecesarios sobre álbumes o artistas y centrarse en presentar los datos fundamentales de la lista de reproducción en un formato coherente. Además, en esta fase se aplican varios patrones de diseño para mejorar la mantenibilidad y escalabilidad del proyecto.

### Mejoras Clave

- **Modelo Agnóstico de Lista de Reproducción:**  
  - Se ha simplificado el dominio para incluir solo la información esencial necesaria para la visualización (ID de la canción, nombre, álbum y lista de nombres de los artistas).
  
- **Aplicación de Patrones de Diseño:**  
  - **Patrón Método Plantilla (Template Method Pattern):** Estandariza el flujo de trabajo para los servicios de listas de reproducción.
  - **Patrón Estrategia (Strategy Pattern):** Permite estrategias de visualización intercambiables a través de la interfaz `PlaylistDisplayStrategy` y su implementación (`DefaultPlaylistDisplayStrategy`).
  - **Patrón Fachada (Facade Pattern):** Proporciona una interfaz simplificada mediante `PlaylistFacade` para acceder a la funcionalidad de la lista de reproducción.

- **Limpieza y Reorganización del Código:**  
  - Se han eliminado clases no utilizadas de fases anteriores (por ejemplo, `ExampleFileUtils` y `PropertyFactory`).
  - Se ha reorganizado el código para separar de manera clara las capas de configuración, visualización, dominio, servicio y utilidades.
