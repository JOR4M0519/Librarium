# Proyecto: Librarium

Librarium es un sistema de gestión de bibliotecas desarrollado en Java utilizando Gradle como sistema de construcción. Este proyecto tiene como objetivo buscar los libros en una base de sistemas e irlos agregando al principal. Aportando funcionalidades de busqueda por autores y libros.

## Características principales

- **Gestión de libros**: Registro de libros.
- **Arquitectura modular**: Código organizado para facilitar la escalabilidad.

## Requisitos del sistema

- **Java**: Versión 11 o superior.
- **Gradle**: Versión 7.0 o superior.
- **Base de datos**: PostgreSQL.

## Configuración del proyecto

1. **Clonar el repositorio**

   ```bash
   git clone <URL-del-repositorio>
   ```

2. **Entrar en el directorio del proyecto**

   ```bash
   cd librarium
   ```

3. **Construir el proyecto**

   ```bash
   ./gradlew build
   ```

4. **Ejecutar la aplicación**

   ```bash
   ./gradlew bootRun
   ```

## Estructura del proyecto

```plaintext
librarium/
├── src/                # Código fuente del proyecto
├── build.gradle        # Configuración principal de Gradle
├── settings.gradle     # Configuración de módulos
├── HELP.md             # Documentación adicional
├── .gitignore          # Configuración de exclusión para Git
├── gradlew             # Script para ejecutar Gradle en Unix
├── gradlew.bat         # Script para ejecutar Gradle en Windows
└── .idea/              # Configuración de IntelliJ IDEA (opcional)
```


## Licencia

Este proyecto está bajo la licencia MIT.

---
