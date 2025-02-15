# Proyecto de Refactorización | Bootcamp Avanzado de Java - Codigofacilito

**English version: [README](README.md)**

## Fase 4: Actualización a Java 23

### Descripción General
Esta rama representa la versión final y unificada del proyecto. Todas las iteraciones previas (**fix-bugs**, **refactor-iteration-1** y **refactor-iteration-2**) han sido fusionadas, y el proyecto ha sido actualizado de Java 1.8 a Java 23. Esta actualización nos permite aprovechar características modernas del lenguaje Java, como **records**, **pattern matching**, **switch expressions** y **type inference con `var`**, mejorando la **legibilidad, rendimiento y mantenibilidad** del código.

### Mejoras y Actualizaciones Clave

- **Actualización a Java 23:**
  - La configuración del compilador en Maven ha sido actualizada para apuntar a Java 23.
  - Se han integrado nuevas características del lenguaje (**records**, **pattern matching en `instanceof`**, **switch expressions** y **`var`**) para modernizar la base de código.

- **Modernización de las Capas de Dominio y Servicio:**
  - Los DTOs para los datos de Spotify han sido refactorizados utilizando **records de Java**, eliminando código repetitivo y garantizando inmutabilidad.
  
- **Mejoras en el Registro de Logs y Manejo de Excepciones:**
  - Se ha actualizado y ampliado el sistema de registro basado en **SLF4J y Logback (versión 1.5.16)** para proporcionar información detallada sobre la ejecución en tiempo real.

## Resumen de la Evolución del Proyecto

Este proyecto ha evolucionado a través de varias fases clave (cada una es una rama):
- **Fase 1: Corrección de Errores** – Se resolvieron problemas fundamentales como tipos de datos incorrectos, manejo inadecuado de excepciones y eliminación de campos innecesarios.
- **Fase 2: Primera Iteración de Refactorización** – Se mejoró el modelo de dominio con la introducción de clases dedicadas para **Álbum, Artista y Lista de Reproducción**, además de optimizar la capa de servicio mediante un **patrón de fábrica**.
- **Fase 3: Segunda Iteración de Refactorización** – Se adoptó un **modelo de lista de reproducción agnóstico** y se aplicaron **patrones de diseño** (**Template Method, Strategy y Facade**) para mejorar la arquitectura.
- **Fase Actual (Fase 4): Actualización a Java 23** – Se unificaron todas las iteraciones previas y se modernizó la base de código utilizando las características de **Java 23** (**records, pattern matching, switch expressions y var**).
