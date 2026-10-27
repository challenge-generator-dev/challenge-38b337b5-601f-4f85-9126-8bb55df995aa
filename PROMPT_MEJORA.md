# Prompt para Mejorar el Codigo Base

Copia y pega el contenido del bloque de abajo en un asistente de IA (Claude, ChatGPT)
para obtener un ZIP con el proyecto completo y arrancable.

Si preferis trabajar en tu editor con un agente local (Claude Code, Cursor, Copilot), usa `AGENTS.md` en vez de este archivo: dice lo mismo pero para que escriba los archivos en disco.

## Las dos reglas que no se negocian

1. **Completa el boilerplate.** Todo lo que el proyecto necesita para compilar y arrancar: manifiesto de dependencias, punto de entrada, configuracion, capa de interfaz, y las capas del patron arquitectonico declarado. Eso es andamiaje y es tu trabajo.
2. **NO resuelvas el reto.** Los entregables de las fases son el trabajo de la persona. El hueco pedagogico se deja como esta: el proyecto arranca, pero lo que el reto pide implementar NO esta implementado.

Dicho de otra forma: si algo impide compilar, arreglalo. Si algo es logica de negocio incompleta, validaciones ausentes, un secreto hardcodeado o un patron mejorable, dejalo exactamente como esta — es lo que la persona tiene que encontrar.

## Superficie de practica — NO resuelvas

Estos archivos SON el ejercicio de la persona. No los implementes; deja stubs.

- `src/main/java/com/pragma/backend/infrastructure/config/Resilience4jConfig.java` — El topic pide resiliencia: este archivo es el ejercicio.

## Lo que le falta a este proyecto

Esto NO lo tenes que adivinar: salio de comparar el proyecto contra la arquitectura declarada del reto y de un analisis estatico del codigo. Completalo TODO.

### Referencias colgando en el codigo que si esta

Cada una rompe la compilacion:

- `src/main/java/com/pragma/backend/BackendApplication.java` — `org.slf4j`: El import org.slf4j.Logger pertenece a org.slf4j, pero ninguna dependencia declarada en el pom.xml cubre ese paquete. Falta agregar la dependencia o el import esta mal (libreria equivocada).
- `src/main/java/com/pragma/backend/application/service/ClienteService.java` — `org.slf4j`: El import org.slf4j.Logger pertenece a org.slf4j, pero ninguna dependencia declarada en el pom.xml cubre ese paquete. Falta agregar la dependencia o el import esta mal (libreria equivocada).
- `src/main/java/com/pragma/backend/infrastructure/controller/ClienteController.java` — `io.swagger.v3`: El import io.swagger.v3.oas.annotations.Operation pertenece a io.swagger.v3, pero ninguna dependencia declarada en el pom.xml cubre ese paquete. Falta agregar la dependencia o el import esta mal (libreria equivocada).
- `src/main/java/com/pragma/backend/infrastructure/controller/ClienteController.java` — `org.slf4j`: El import org.slf4j.Logger pertenece a org.slf4j, pero ninguna dependencia declarada en el pom.xml cubre ese paquete. Falta agregar la dependencia o el import esta mal (libreria equivocada).
- `src/main/java/com/pragma/backend/infrastructure/config/LoggingAspect.java` — `org.aspectj.lang`: El import org.aspectj.lang.ProceedingJoinPoint pertenece a org.aspectj.lang, pero ninguna dependencia declarada en el pom.xml cubre ese paquete. Falta agregar la dependencia o el import esta mal (libreria equivocada).
- `src/main/java/com/pragma/backend/infrastructure/config/LoggingAspect.java` — `org.slf4j`: El import org.slf4j.Logger pertenece a org.slf4j, pero ninguna dependencia declarada en el pom.xml cubre ese paquete. Falta agregar la dependencia o el import esta mal (libreria equivocada).
- `src/test/java/com/pragma/backend/infrastructure/controller/ClienteControllerTest.java` — `com.fasterxml.jackson`: El import com.fasterxml.jackson.databind.ObjectMapper pertenece a com.fasterxml.jackson, pero ninguna dependencia declarada en el pom.xml cubre ese paquete. Falta agregar la dependencia o el import esta mal (libreria equivocada).
- `src/main/java/com/pragma/backend/infrastructure/adapter/JpaClienteRepository.java` — `JpaClienteCorporativoRepository.save`: Se invoca `save` sobre `JpaClienteCorporativoRepository`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/pragma/backend/infrastructure/adapter/JpaClienteRepository.java` — `JpaClienteRetailRepository.save`: Se invoca `save` sobre `JpaClienteRetailRepository`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/pragma/backend/infrastructure/adapter/JpaClienteRepository.java` — `JpaClienteCorporativoRepository.findById`: Se invoca `findById` sobre `JpaClienteCorporativoRepository`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/pragma/backend/infrastructure/adapter/JpaClienteRepository.java` — `JpaClienteRetailRepository.findById`: Se invoca `findById` sobre `JpaClienteRetailRepository`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/pragma/backend/infrastructure/adapter/JpaClienteRepository.java` — `JpaClienteCorporativoRepository.findAll`: Se invoca `findAll` sobre `JpaClienteCorporativoRepository`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/pragma/backend/infrastructure/adapter/JpaClienteRepository.java` — `JpaClienteRetailRepository.findAll`: Se invoca `findAll` sobre `JpaClienteRetailRepository`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/pragma/backend/infrastructure/adapter/JpaClienteRepository.java` — `JpaClienteCorporativoRepository.deleteById`: Se invoca `deleteById` sobre `JpaClienteCorporativoRepository`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/pragma/backend/infrastructure/adapter/JpaClienteRepository.java` — `JpaClienteRetailRepository.deleteById`: Se invoca `deleteById` sobre `JpaClienteRetailRepository`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/pragma/backend/infrastructure/adapter/JpaClienteRepository.java` — `ClienteRetail.nit`: Se invoca `nit` sobre `ClienteRetail`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/pragma/backend/infrastructure/adapter/JpaClienteRepository.java` — `ClienteRetail.razonSocial`: Se invoca `razonSocial` sobre `ClienteRetail`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/pragma/backend/infrastructure/adapter/JpaClienteRepository.java` — `ClienteRetail.email`: Se invoca `email` sobre `ClienteRetail`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/pragma/backend/infrastructure/adapter/JpaClienteRepository.java` — `ClienteRetail.telefono`: Se invoca `telefono` sobre `ClienteRetail`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/pragma/backend/infrastructure/adapter/JpaClienteRepository.java` — `ClienteRetail.direccion`: Se invoca `direccion` sobre `ClienteRetail`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/pragma/backend/infrastructure/adapter/JpaClienteRepository.java` — `ClienteRetail.id`: Se invoca `id` sobre `ClienteRetail`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/pragma/backend/infrastructure/adapter/JpaClienteRepository.java` — `ClienteRetail.numeroIdentificacion`: Se invoca `numeroIdentificacion` sobre `ClienteRetail`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/pragma/backend/infrastructure/adapter/JpaClienteRepository.java` — `ClienteRetail.nombres`: Se invoca `nombres` sobre `ClienteRetail`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/pragma/backend/infrastructure/adapter/JpaClienteRepository.java` — `ClienteRetail.apellidos`: Se invoca `apellidos` sobre `ClienteRetail`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/pragma/backend/application/service/ClienteService.java` — `ClienteRetail.nit`: Se invoca `nit` sobre `ClienteRetail`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/pragma/backend/application/service/ClienteService.java` — `ClienteRetail.id`: Se invoca `id` sobre `ClienteRetail`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/pragma/backend/application/service/ClienteService.java` — `ClienteRetail.numeroIdentificacion`: Se invoca `numeroIdentificacion` sobre `ClienteRetail`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/pragma/backend/infrastructure/controller/ClienteController.java` — `ClienteRetail.nit`: Se invoca `nit` sobre `ClienteRetail`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/pragma/backend/infrastructure/controller/ClienteController.java` — `ClienteRetail.id`: Se invoca `id` sobre `ClienteRetail`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/pragma/backend/infrastructure/controller/ClienteController.java` — `ClienteRetail.numeroIdentificacion`: Se invoca `numeroIdentificacion` sobre `ClienteRetail`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/pragma/backend/infrastructure/controller/ClienteController.java` — `ClienteService.obtenerCorporativoPorId`: Se invoca `obtenerCorporativoPorId` sobre `ClienteService`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/pragma/backend/infrastructure/controller/ClienteController.java` — `ClienteService.obtenerRetailPorId`: Se invoca `obtenerRetailPorId` sobre `ClienteService`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/pragma/backend/infrastructure/controller/ClienteController.java` — `ClienteService.listarTodosCorporativos`: Se invoca `listarTodosCorporativos` sobre `ClienteService`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/pragma/backend/infrastructure/controller/ClienteController.java` — `ClienteService.listarTodosRetail`: Se invoca `listarTodosRetail` sobre `ClienteService`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/pragma/backend/infrastructure/controller/ClienteController.java` — `ClienteService.buscarCorporativoPorNit`: Se invoca `buscarCorporativoPorNit` sobre `ClienteService`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/pragma/backend/infrastructure/controller/ClienteController.java` — `ClienteService.buscarRetailPorIdentificacion`: Se invoca `buscarRetailPorIdentificacion` sobre `ClienteService`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/pragma/backend/application/service/ClienteServiceTest.java` — `ClienteService.guardarClienteCorporativo`: Se invoca `guardarClienteCorporativo` sobre `ClienteService`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/pragma/backend/application/service/ClienteServiceTest.java` — `ClienteRetail.nit`: Se invoca `nit` sobre `ClienteRetail`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/pragma/backend/application/service/ClienteServiceTest.java` — `ClienteRetail.razonSocial`: Se invoca `razonSocial` sobre `ClienteRetail`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/pragma/backend/application/service/ClienteServiceTest.java` — `ClienteService.guardarClienteRetail`: Se invoca `guardarClienteRetail` sobre `ClienteService`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/pragma/backend/application/service/ClienteServiceTest.java` — `ClienteRetail.numeroIdentificacion`: Se invoca `numeroIdentificacion` sobre `ClienteRetail`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/pragma/backend/application/service/ClienteServiceTest.java` — `ClienteRetail.nombre`: Se invoca `nombre` sobre `ClienteRetail`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/pragma/backend/application/service/ClienteServiceTest.java` — `ClienteRetail.get`: Se invoca `get` sobre `ClienteRetail`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/pragma/backend/infrastructure/controller/ClienteControllerTest.java` — `ClienteService.guardarClienteCorporativo`: Se invoca `guardarClienteCorporativo` sobre `ClienteService`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/pragma/backend/infrastructure/controller/ClienteControllerTest.java` — `ClienteService.buscarClienteCorporativoPorId`: Se invoca `buscarClienteCorporativoPorId` sobre `ClienteService`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/pragma/backend/infrastructure/controller/ClienteControllerTest.java` — `ClienteService.guardarClienteRetail`: Se invoca `guardarClienteRetail` sobre `ClienteService`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/pragma/backend/infrastructure/controller/ClienteControllerTest.java` — `ClienteService.buscarClienteRetailPorId`: Se invoca `buscarClienteRetailPorId` sobre `ClienteService`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.

## Como saber que terminaste

```bash
mvn clean compile
```

Ese comando corriendo sin errores es la definicion de "listo".

---

```
## Briefing del reto (autoridad)
Este bloque manda sobre los archivos adjuntos. El stack y el rol salen de AQUÍ, no de un topic genérico ni de markdown placeholder.

### Perfil
Chapter Backend, Especialidad Spring, Tecnología Java, Advanced L2

### Brecha de conocimiento
Experiencia comprobable en al menos un marco de trabajo (Framework) en su lenguaje de programación principal (por ejemplo, Spring Framework en Java o ASP .net core en C#) y puede realizar el enrutamiento de solicitudes, controlar las variables de entorno, generar registros de rastros (Logs) y conectarse con bases de datos utilizando un Mapeador Relacional de Objetos (ORM).

### Reto
- Tema: Experiencia en Frameworks
- Seniority: advanced-l2
- Tipo: practical
- Título: Implementación de un Backend con Spring Framework
- Tiempo estimado: 20 horas

### Fases (trabajo del HUMANO — PROHIBIDO completarlas)
No implementes estos entregables. Dejalos como hueco pedagógico. El asistente solo materializa el proyecto arrancable para que el participante pueda trabajar.
- Fase 1: Configuración del Entorno — objetivo: Configurar el entorno de desarrollo y establecer las bases para el proyecto Spring. — entregable (NO resolver): Proyecto Spring configurado con las dependencias y variables de entorno establecidas.
- Fase 2: Implementación de la API REST — objetivo: Crear una API REST que maneje solicitudes de clientes y registre las solicitudes y respuestas en un archivo de logs. — entregable (NO resolver): API REST implementada con endpoints para recibir solicitudes de clientes y registro de solicitudes y respuestas en un archivo de logs.
- Fase 3: Conexión con Base de Datos — objetivo: Conectar la aplicación con una base de datos relacional utilizando un ORM y almacenar la información de los clientes. — entregable (NO resolver): Aplicación conectada a una base de datos relacional con entidades y repositorios para almacenar la información de los clientes.
- Fase 4: Manejo de Picos de Tráfico y Disponibilidad — objetivo: Implementar mecanismos para manejar picos de tráfico y garantizar la disponibilidad de los servicios. — entregable (NO resolver): Mecanismos implementados para manejar picos de tráfico y garantizar la disponibilidad de los servicios.

Eres un asistente experto en análisis, corrección y generación de archivos de cualquier tipo:
código fuente, documentación, hojas de cálculo, documentos Word, configuraciones, entre otros.
Voy a enviarte una cadena de texto que contiene uno o más archivos. Cada archivo está delimitado por un marcador con el siguiente formato:
// === ARCHIVO: ruta/del/archivo.extension ===
o también puede aparecer como:
## === ARCHIVO: ruta/del/archivo.extension ===
Lo que sigue al marcador puede ser:

El contenido real del archivo (código, texto, YAML, etc.)
Una descripción en lenguaje natural de lo que debe contener el archivo


TU TAREA
PASO 0 — ¿Esto es un proyecto o una carcasa?
Antes de extraer archivos, leé el Briefing (si está) y diagnosticá el adjunto.

Es CARCASA si ocurre CUALQUIERA de estas:
- No hay manifiesto de dependencias del stack del briefing (manifest.json de VTEX IO / package.json / pom.xml / build.gradle / requirements.txt / go.mod / *.tf / *.csproj, según corresponda)
- Hay un "binario" que en realidad es un comentario ("no puede ser mostrado como texto plano", placeholder .fig/.docx vacío)
- Los markdowns ya completan entregables de fases posteriores ("se implementó fade-in", lista de áreas ya resuelta)

Si es CARCASA:
- MATERIALIZÁ un proyecto que arranca en el stack del briefing (VTEX IO Store Framework, Angular, Terraform, pytest, Nest, etc.). Incluí manifiesto, punto de entrada y capa de interfaz reales.
- NO copies los markdowns de "solución" como si fueran el producto. Son ruido de generación.
- NO resuelvas las fases del briefing (están marcadas PROHIBIDO). Dejá el hueco pedagógico: el flujo existe, las microinteracciones/calidad/infra que el reto pide NO están hechas.
- Después seguí al PASO 5 (ZIP).

Si es un proyecto REAL (manifiesto + código que compila o arranca):
- Seguí PASO 1 en adelante. 🔴 compilación sí. 🟡 pedagógico no.

PASO 1 — Detección y extracción
Identifica todos los archivos presentes en la cadena. Para cada archivo extrae:

Su ruta completa (ej: src/main/java/com/pragma/Service.java)
Su contenido o descripción

PASO 2 — Clasificación por tipo
Clasifica cada archivo en una de estas categorías:
A) Código fuente (Java, Python, TypeScript, JavaScript, Kotlin, etc.)
B) Configuración / documentación (YAML, properties, Markdown, JSON, txt, etc.)
C) Excel (.xlsx, .xls, .csv)
D) Word (.docx, .doc)
E) Otro tipo de archivo binario o especial
PASO 3 — Clasificación de errores en código fuente

Objetivo prioritario: que el proyecto compile. No corrijas flujo de negocio ni lógica funcional.

Antes de modificar cualquier archivo de código fuente, clasifica cada problema encontrado en una de estas dos categorías:
🔴 ERROR DE COMPILACIÓN — corregir siempre
Son errores que impiden que el proyecto arranque, sin valor pedagógico:

Import faltante o incorrecto
Clase, método o variable referenciada que no existe en ningún archivo del proyecto
Error de sintaxis
Anotación con atributos inválidos
Dependencia ausente en pom.xml, package.json, etc.
Archivo referenciado que no existe y debe ser creado con implementación mínima

→ CORREGIR estos errores.
🟡 PROBLEMA FUNCIONAL O DE CALIDAD — preservar siempre
Son problemas que no impiden compilar. Pueden ser intencionales para el aprendizaje:

Clave secreta hardcodeada ("secret", "password123")
API deprecada que funciona pero tiene reemplazo moderno
Lógica de negocio incorrecta o incompleta
Código redundante o de baja legibilidad
Falta de validaciones en flujo de negocio
Patrones de diseño incorrectos pero funcionales
Concurrencia no segura
Configuración funcional pero no óptima

→ PRESERVAR tal cual. No corregir, no mejorar, no comentar.
PASO 4 — Procesamiento según tipo de archivo
Tipo A — Código fuente
Aplica únicamente las correcciones clasificadas como 🔴 ERROR DE COMPILACIÓN.
No alteres ningún elemento clasificado como 🟡 PROBLEMA FUNCIONAL O DE CALIDAD.
Si falta un archivo referenciado, créalo con la implementación mínima necesaria para compilar.
Tipo B — Configuración / documentación
Extrae el contenido tal cual, sin modificaciones salvo errores evidentes de sintaxis
(ej: YAML mal indentado).
Tipo C — Excel (.xlsx)
Si viene con contenido real, genera el archivo respetando ese contenido.
Si viene con descripción en lenguaje natural, genera un archivo Excel funcional con:

Fila de encabezados en negrita con color de fondo distintivo
Columnas con ancho ajustado al contenido
Tipos de dato correctos por columna
Validaciones si la descripción lo indica
Hojas nombradas descriptivamente si hay más de una
Filas de ejemplo si no hay datos reales

Tipo D — Word (.docx)
Si viene con contenido real, genera el archivo respetando ese contenido.
Si viene con descripción en lenguaje natural, genera un documento Word funcional con:

Estilos de título (Título 1, Título 2) para jerarquía de secciones
Fuente legible (Calibri o equivalente), tamaño 11-12pt para cuerpo
Márgenes estándar
Tabla de contenido si tiene múltiples secciones
Tablas con encabezados en negrita si aplica

Tipo E — Otro
Genera el archivo con el contenido o estructura más apropiada según la descripción.
PASO 5 — Exportación en ZIP
Empaqueta todos los archivos en un único archivo ZIP descargable respetando exactamente
la estructura de rutas indicada por los marcadores.
El ZIP debe incluir:

Archivos de código con únicamente los errores de compilación corregidos
Archivos de configuración y documentación sin cambios
Archivos nuevos creados para resolver dependencias de compilación faltantes
Archivos Excel y Word generados desde descripción

IMPORTANTE: El ZIP debe estar listo para descargar al finalizar. No preguntes si el usuario
quiere generarlo. Simplemente genera el archivo y proporciona el enlace de descarga; No debes desplegar en el chat el resumen de lo que arreglaste al Zip, solo entregalo.

REGLAS IMPORTANTES

No omitas ningún archivo aunque no tenga errores ni modificaciones
Respeta los nombres y rutas exactas indicadas por los marcadores
Si un archivo no tiene marcador claro, infiere el nombre desde su contenido
Si la cadena contiene solo documentación, placeholders o binarios fake, NO la reproduzcas:
aplicá PASO 0 (materializar el proyecto del briefing). Reproducir la carcasa es un fallo.
No agregues texto después del enlace de descarga del ZIP
No preguntes si el usuario quiere el ZIP: simplemente generalo siempre
Si detectas que falta un archivo de configuración necesario para compilar
(pom.xml, package.json, requirements.txt, build.gradle, etc.), créalo e inclúyelo
inferiendo su contenido desde los imports y frameworks detectados en el código
Nunca corrijas problemas 🟡 aunque parezcan obvios o fáciles de mejorar.
El participante que recibirá este proyecto los debe encontrar y resolver él mismo.


INPUT
Aquí está la cadena con los archivos:

// === ARCHIVO: pom.xml ===
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>3.5.6</version>
        <relativePath/>
    </parent>

    <groupId>com.pragma</groupId>
    <artifactId>backend</artifactId>
    <version>0.0.1-SNAPSHOT</version>
    <name>backend</name>
    <description>Backend para gestión de clientes con manejo de picos de tráfico</description>

    <properties>
        <java.version>21</java.version>
        <resilience4j.version>2.2.0</resilience4j.version>
        <springdoc.version>2.5.0</springdoc.version>
    </properties>

    <dependencies>
        <!-- Spring Boot Starters -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-data-jpa</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-validation</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-actuator</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-aop</artifactId>
        </dependency>

        <!-- Resilience4j -->
        <dependency>
            <groupId>io.github.resilience4j</groupId>
            <artifactId>resilience4j-spring-boot3</artifactId>
            <version>${resilience4j.version}</version>
        </dependency>

        <!-- Base de datos -->
        <dependency>
            <groupId>org.postgresql</groupId>
            <artifactId>postgresql</artifactId>
            <scope>runtime</scope>
        </dependency>

        <!-- Lombok -->
        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
            <optional>true</optional>
        </dependency>

        <!-- Documentación OpenAPI -->
        <dependency>
            <groupId>org.springdoc</groupId>
            <artifactId>springdoc-openapi-starter-webmvc-ui</artifactId>
            <version>${springdoc.version}</version>
        </dependency>

        <!-- Testing -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>org.testcontainers</groupId>
            <artifactId>postgresql</artifactId>
            <version>1.19.7</version>
            <scope>test</scope>
        </dependency>
    </dependencies>

    <build>
        <plugins>
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
                <configuration>
                    <excludes>
                        <exclude>
                            <groupId>org.projectlombok</groupId>
                            <artifactId>lombok</artifactId>
                        </exclude>
                    </excludes>
                </configuration>
            </plugin>
        </plugins>
    </build>

    <repositories>
        <repository>
            <id>spring-milestones</id>
            <name>Spring Milestones</name>
            <url>https://repo.spring.io/milestone</url>
            <snapshots>
                <enabled>false</enabled>
            </snapshots>
        </repository>
    </repositories>
</project>

// === ARCHIVO: src/main/java/com/pragma/backend/BackendApplication.java ===
package com.pragma.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.retry.annotation.EnableRetry;
import org.springframework.scheduling.annotation.EnableAsync;
import io.github.resilience4j.circuitbreaker.CircuitBreaker;
import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig;
import io.github.resilience4j.retry.Retry;
import io.github.resilience4j.retry.RetryConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.boot.actuate.health.Health;
import java.time.Duration;

@SpringBootApplication
@EnableConfigurationProperties
@EnableRetry
@EnableAsync
public class BackendApplication {
    private static final Logger logger = LoggerFactory.getLogger(BackendApplication.class);
    private final ApplicationProperties applicationProperties;

    public BackendApplication(ApplicationProperties applicationProperties) {
        this.applicationProperties = applicationProperties;
        validateProperties();
    }

    public static void main(String[] args) {
        try {
            var context = SpringApplication.run(BackendApplication.class, args);
            logger.info("Aplicación iniciada con éxito en el perfil: {}", 
                      String.join(",", context.getEnvironment().getActiveProfiles()));
            logger.info("Configuración de Resilience4j: CircuitBreaker={}, Retry={}",
                      context.containsBean("circuitBreaker"), 
                      context.containsBean("retry"));
        } catch (Exception e) {
            logger.error("Error al iniciar la aplicación", e);
            throw new ApplicationStartupException("Falló el inicio de la aplicación", e);
        }
    }

    private void validateProperties() {
        if (applicationProperties.getDatabase().getUrl() == null || 
            applicationProperties.getDatabase().getUrl().isBlank()) {
            throw new IllegalStateException("La URL de la base de datos no puede estar vacía");
        }
        if (applicationProperties.getCircuitBreaker().getFailureRateThreshold() < 1 || 
            applicationProperties.getCircuitBreaker().getFailureRateThreshold() > 100) {
            throw new IllegalStateException("El umbral de fallos del CircuitBreaker debe estar entre 1 y 100");
        }
    }

    @Bean
    public CircuitBreaker circuitBreaker() {
        CircuitBreakerConfig config = CircuitBreakerConfig.custom()
                .failureRateThreshold(applicationProperties.getCircuitBreaker().getFailureRateThreshold())
                .waitDurationInOpenState(Duration.ofSeconds(applicationProperties.getCircuitBreaker().getWaitDurationInOpenState()))
                .permittedNumberOfCallsInHalfOpenState(applicationProperties.getCircuitBreaker().getPermittedNumberOfCallsInHalfOpenState())
                .slidingWindowType(CircuitBreakerConfig.SlidingWindowType.COUNT_BASED)
                .slidingWindowSize(applicationProperties.getCircuitBreaker().getSlidingWindowSize())
                .recordExceptions(Exception.class)
                .build();
        return CircuitBreaker.of("clientServiceCircuitBreaker", config);
    }

    @Bean
    public Retry retry() {
        RetryConfig config = RetryConfig.custom()
                .maxAttempts(applicationProperties.getRetry().getMaxAttempts())
                .waitDuration(Duration.ofMillis(applicationProperties.getRetry().getWaitDuration()))
                .retryExceptions(Exception.class)
                .build();
        return Retry.of("clientServiceRetry", config);
    }

    @Bean
    public HealthIndicator customHealthIndicator() {
        return () -> {
            try {
                // Simulación de verificación de salud de la base de datos
                if (applicationProperties.getDatabase().getUrl().contains("postgresql")) {
                    return Health.up().withDetail("database", "PostgreSQL disponible").build();
                }
                return Health.down().withDetail("database", "Tipo de base de datos no soportado").build();
            } catch (Exception e) {
                return Health.down(e).build();
            }
        };
    }

    public static class ApplicationStartupException extends RuntimeException {
        public ApplicationStartupException(String message, Throwable cause) {
            super(message, cause);
        }
    }
}

// === ARCHIVO: src/main/resources/application.yml ===
spring:
  application:
    name: backend
  profiles:
    active: dev
  datasource:
    url: ${DB_URL:jdbc:postgresql://localhost:5432/clientes_db}
    username: ${DB_USERNAME:postgres}
    password: ${DB_PASSWORD:postgres}
    driver-class-name: org.postgresql.Driver
    hikari:
      connection-timeout: 30000
      maximum-pool-size: 10
      minimum-idle: 2
      idle-timeout: 600000
      max-lifetime: 1800000
  jpa:
    hibernate:
      ddl-auto: update
    show-sql: true
    properties:
      hibernate:
        dialect: org.hibernate.dialect.PostgreSQLDialect
        format_sql: true
  mvc:
    throw-exception-if-no-handler-found: true
  web:
    resources:
      add-mappings: false

server:
  port: ${PORT:8080}
  error:
    include-message: always
    include-binding-errors: always
    include-stacktrace: never

management:
  endpoints:
    web:
      exposure:
        include: health,info,metrics,circuitbreakers,retryevents
  endpoint:
    health:
      show-details: always
    metrics:
      enabled: true

resilience4j:
  circuitbreaker:
    configs:
      default:
        registerHealthIndicator: true
        slidingWindowSize: 10
        minimumNumberOfCalls: 5
        permittedNumberOfCallsInHalfOpenState: 3
        automaticTransitionFromOpenToHalfOpenEnabled: true
        waitDurationInOpenState: 5s
        failureRateThreshold: 50
        eventConsumerBufferSize: 10
        recordExceptions:
          - org.springframework.web.client.HttpServerErrorException
          - java.io.IOException
          - java.util.concurrent.TimeoutException
          - org.springframework.transaction.CannotCreateTransactionException
    instances:
      clientService:
        baseConfig: default
  retry:
    configs:
      default:
        maxAttempts: 3
        waitDuration: 500
        enableExponentialBackoff: true
        exponentialBackoffMultiplier: 2
        retryExceptions:
          - org.springframework.web.client.HttpServerErrorException
          - java.io.IOException
          - java.util.concurrent.TimeoutException
    instances:
      clientService:
        baseConfig: default

logging:
  level:
    root: INFO
    com.pragma.backend: DEBUG
    org.hibernate.SQL: DEBUG
    org.hibernate.type.descriptor.sql.BasicBinder: TRACE
  pattern:
    console: "%d{yyyy-MM-dd HH:mm:ss} - %msg%n"
    file: "%d{yyyy-MM-dd HH:mm:ss} [%thread] %-5level %logger{36} - %msg%n"
  file:
    name: logs/backend.log
    max-size: 10MB
    max-history: 7

application:
  circuitBreaker:
    failureRateThreshold: 50
    waitDurationInOpenState: 5
    permittedNumberOfCallsInHalfOpenState: 3
    slidingWindowSize: 10
  retry:
    maxAttempts: 3
    waitDuration: 500
  database:
    url: ${DB_URL:jdbc:postgresql://localhost:5432/clientes_db}

// === ARCHIVO: src/main/java/com/pragma/backend/domain/model/ClienteCorporativo.java ===
package com.pragma.backend.domain.model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Pattern;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

public record ClienteCorporativo(
    @NotNull(message = "El ID no puede ser nulo")
    UUID id,

    @NotNull(message = "El nombre corporativo no puede ser nulo")
    @Size(min = 3, max = 100, message = "El nombre corporativo debe tener entre 3 y 100 caracteres")
    String nombreCorporativo,

    @NotNull(message = "El NIT no puede ser nulo")
    @Pattern(regexp = "^\\d{9}-[0-9]$", message = "El NIT debe tener el formato 123456789-0")
    String nit,

    @NotNull(message = "La dirección no puede ser nula")
    @Size(min = 10, max = 200, message = "La dirección debe tener entre 10 y 200 caracteres")
    String direccion,

    @NotNull(message = "El teléfono no puede ser nulo")
    @Pattern(regexp = "^\\+?[0-9\\s-]{10,15}$", message = "El teléfono debe ser válido")
    String telefono,

    @NotNull(message = "El correo electrónico no puede ser nulo")
    @Pattern(regexp = "^[A-Za-z0-9+_.-]+@(.+)$", message = "El correo electrónico debe ser válido")
    String correoElectronico,

    @NotNull(message = "El sector no puede ser nulo")
    @Size(min = 3, max = 50, message = "El sector debe tener entre 3 y 50 caracteres")
    String sector,

    @NotNull(message = "El tamaño de la empresa no puede ser nulo")
    @Size(min = 3, max = 20, message = "El tamaño de la empresa debe tener entre 3 y 20 caracteres")
    String tamanoEmpresa,

    @NotNull(message = "La fecha de registro no puede ser nula")
    LocalDate fechaRegistro,

    BigDecimal limiteCredito,

    @Size(max = 500, message = "Las observaciones no pueden exceder los 500 caracteres")
    String observaciones
) {
    public ClienteCorporativo {
        if (limiteCredito != null && limiteCredito.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("El límite de crédito no puede ser negativo");
        }
    }

    public ClienteCorporativo withId(UUID id) {
        return new ClienteCorporativo(
            id,
            this.nombreCorporativo,
            this.nit,
            this.direccion,
            this.telefono,
            this.correoElectronico,
            this.sector,
            this.tamanoEmpresa,
            this.fechaRegistro,
            this.limiteCredito,
            this.observaciones
        );
    }
}

// === ARCHIVO: src/main/java/com/pragma/backend/domain/model/ClienteRetail.java ===
package com.pragma.backend.domain.model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Pattern;
import java.time.LocalDate;
import java.util.UUID;

public record ClienteRetail(
    @NotNull(message = "El ID no puede ser nulo")
    UUID id,

    @NotNull(message = "El nombre no puede ser nulo")
    @Size(min = 3, max = 50, message = "El nombre debe tener entre 3 y 50 caracteres")
    String nombre,

    @NotNull(message = "El apellido no puede ser nulo")
    @Size(min = 3, max = 50, message = "El apellido debe tener entre 3 y 50 caracteres")
    String apellido,

    @NotNull(message = "El número de identificación no puede ser nulo")
    @Pattern(regexp = "^\\d{6,12}$", message = "El número de identificación debe ser válido")
    String numeroIdentificacion,

    @NotNull(message = "La dirección no puede ser nula")
    @Size(min = 10, max = 200, message = "La dirección debe tener entre 10 y 200 caracteres")
    String direccion,

    @NotNull(message = "El teléfono no puede ser nulo")
    @Pattern(regexp = "^\\+?[0-9\\s-]{10,15}$", message = "El teléfono debe ser válido")
    String telefono,

    @NotNull(message = "El correo electrónico no puede ser nulo")
    @Pattern(regexp = "^[A-Za-z0-9+_.-]+@(.+)$", message = "El correo electrónico debe ser válido")
    String correoElectronico,

    @NotNull(message = "La fecha de nacimiento no puede ser nula")
    LocalDate fechaNacimiento,

    @NotNull(message = "La fecha de registro no puede ser nula")
    LocalDate fechaRegistro,

    @Size(max = 500, message = "Las observaciones no pueden exceder los 500 caracteres")
    String observaciones,

    @Pattern(regexp = "^(ACTIVO|INACTIVO|SUSPENDIDO)$", message = "El estado debe ser ACTIVO, INACTIVO o SUSPENDIDO")
    String estado
) {
    public ClienteRetail {
        if (fechaNacimiento != null && fechaNacimiento.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("La fecha de nacimiento no puede ser futura");
        }
        if (fechaRegistro != null && fechaRegistro.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("La fecha de registro no puede ser futura");
        }
    }

    public ClienteRetail withId(UUID id) {
        return new ClienteRetail(
            id,
            this.nombre,
            this.apellido,
            this.numeroIdentificacion,
            this.direccion,
            this.telefono,
            this.correoElectronico,
            this.fechaNacimiento,
            this.fechaRegistro,
            this.observaciones,
            this.estado
        );
    }
}

// === ARCHIVO: src/main/java/com/pragma/backend/domain/port/ClienteRepository.java ===
package com.pragma.backend.domain.port;

import com.pragma.backend.domain.model.ClienteCorporativo;
import com.pragma.backend.domain.model.ClienteRetail;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ClienteRepository {
    ClienteCorporativo saveCorporativo(ClienteCorporativo cliente);
    ClienteRetail saveRetail(ClienteRetail cliente);

    Optional<ClienteCorporativo> findCorporativoById(UUID id);
    Optional<ClienteRetail> findRetailById(UUID id);

    List<ClienteCorporativo> findAllCorporativos();
    List<ClienteRetail> findAllRetail();

    void deleteCorporativo(UUID id);
    void deleteRetail(UUID id);

    Optional<ClienteCorporativo> findCorporativoByNit(String nit);
    Optional<ClienteRetail> findRetailByNumeroIdentificacion(String numeroIdentificacion);
}

// === ARCHIVO: src/main/java/com/pragma/backend/infrastructure/adapter/entity/ClienteEntity.java ===
package com.pragma.backend.infrastructure.adapter.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "clientes_corporativos")
public class ClienteCorporativoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "nit", unique = true, nullable = false)
    private String nit;

    @Column(name = "razon_social", nullable = false)
    private String razonSocial;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "telefono", nullable = false)
    private String telefono;

    @Column(name = "direccion")
    private String direccion;

    @Column(name = "fecha_creacion", nullable = false)
    private LocalDateTime fechaCreacion;

    @Column(name = "fecha_actualizacion")
    private LocalDateTime fechaActualizacion;

    public ClienteCorporativoEntity() {
    }

    public ClienteCorporativoEntity(String nit, String razonSocial, String email, String telefono, String direccion) {
        this.nit = nit;
        this.razonSocial = razonSocial;
        this.email = email;
        this.telefono = telefono;
        this.direccion = direccion;
        this.fechaCreacion = LocalDateTime.now();
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public LocalDateTime getFechaActualizacion() {
        return fechaActualizacion;
    }

    public void setFechaActualizacion(LocalDateTime fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
    }
}

@Entity
@Table(name = "clientes_retail")
public class ClienteRetailEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "numero_identificacion", unique = true, nullable = false)
    private String numeroIdentificacion;

    @Column(name = "nombres", nullable = false)
    private String nombres;

    @Column(name = "apellidos", nullable = false)
    private String apellidos;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "telefono", nullable = false)
    private String telefono;

    @Column(name = "direccion")
    private String direccion;

    @Column(name = "fecha_creacion", nullable = false)
    private LocalDateTime fechaCreacion;

    @Column(name = "fecha_actualizacion")
    private LocalDateTime fechaActualizacion;

    public ClienteRetailEntity() {
    }

    public ClienteRetailEntity(String numeroIdentificacion, String nombres, String apellidos, String email, String telefono, String direccion) {
        this.numeroIdentificacion = numeroIdentificacion;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.email = email;
        this.telefono = telefono;
        this.direccion = direccion;
        this.fechaCreacion = LocalDateTime.now();
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNumeroIdentificacion() {
        return numeroIdentificacion;
    }

    public void setNumeroIdentificacion(String numeroIdentificacion) {
        this.numeroIdentificacion = numeroIdentificacion;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public LocalDateTime getFechaActualizacion() {
        return fechaActualizacion;
    }

    public void setFechaActualizacion(LocalDateTime fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
    }
}

// === ARCHIVO: src/main/java/com/pragma/backend/infrastructure/adapter/JpaClienteRepository.java ===
package com.pragma.backend.infrastructure.adapter;

import com.pragma.backend.domain.model.ClienteCorporativo;
import com.pragma.backend.domain.model.ClienteRetail;
import com.pragma.backend.domain.port.ClienteRepository;
import com.pragma.backend.infrastructure.adapter.entity.ClienteCorporativoEntity;
import com.pragma.backend.infrastructure.adapter.entity.ClienteRetailEntity;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Repository
public class JpaClienteRepository implements ClienteRepository {

    private final JpaClienteCorporativoRepository corporativoRepository;
    private final JpaClienteRetailRepository retailRepository;

    public JpaClienteRepository(JpaClienteCorporativoRepository corporativoRepository,
                                 JpaClienteRetailRepository retailRepository) {
        this.corporativoRepository = corporativoRepository;
        this.retailRepository = retailRepository;
    }

    @Override
    public ClienteCorporativo saveCorporativo(ClienteCorporativo cliente) {
        ClienteCorporativoEntity entity = toCorporativoEntity(cliente);
        entity.setFechaCreacion(LocalDateTime.now());
        ClienteCorporativoEntity saved = corporativoRepository.save(entity);
        return toCorporativoModel(saved);
    }

    @Override
    public ClienteRetail saveRetail(ClienteRetail cliente) {
        ClienteRetailEntity entity = toRetailEntity(cliente);
        entity.setFechaCreacion(LocalDateTime.now());
        ClienteRetailEntity saved = retailRepository.save(entity);
        return toRetailModel(saved);
    }

    @Override
    public Optional<ClienteCorporativo> findCorporativoById(UUID id) {
        return corporativoRepository.findById(id).map(this::toCorporativoModel);
    }

    @Override
    public Optional<ClienteRetail> findRetailById(UUID id) {
        return retailRepository.findById(id).map(this::toRetailModel);
    }

    @Override
    public List<ClienteCorporativo> findAllCorporativos() {
        return corporativoRepository.findAll().stream()
                .map(this::toCorporativoModel)
                .collect(Collectors.toList());
    }

    @Override
    public List<ClienteRetail> findAllRetail() {
        return retailRepository.findAll().stream()
                .map(this::toRetailModel)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteCorporativo(UUID id) {
        corporativoRepository.deleteById(id);
    }

    @Override
    public void deleteRetail(UUID id) {
        retailRepository.deleteById(id);
    }

    @Override
    public Optional<ClienteCorporativo> findCorporativoByNit(String nit) {
        return corporativoRepository.findByNit(nit).map(this::toCorporativoModel);
    }

    @Override
    public Optional<ClienteRetail> findRetailByNumeroIdentificacion(String numeroIdentificacion) {
        return retailRepository.findByNumeroIdentificacion(numeroIdentificacion).map(this::toRetailModel);
    }

    private ClienteCorporativo toCorporativoModel(ClienteCorporativoEntity entity) {
        return new ClienteCorporativo(
                entity.getId(),
                entity.getNit(),
                entity.getRazonSocial(),
                entity.getEmail(),
                entity.getTelefono(),
                entity.getDireccion()
        );
    }

    private ClienteCorporativoEntity toCorporativoEntity(ClienteCorporativo model) {
        ClienteCorporativoEntity entity = new ClienteCorporativoEntity(
                model.nit(),
                model.razonSocial(),
                model.email(),
                model.telefono(),
                model.direccion()
        );
        if (model.id() != null) {
            entity.setId(model.id());
        }
        return entity;
    }

    private ClienteRetail toRetailModel(ClienteRetailEntity entity) {
        return new ClienteRetail(
                entity.getId(),
                entity.getNumeroIdentificacion(),
                entity.getNombres(),
                entity.getApellidos(),
                entity.getEmail(),
                entity.getTelefono(),
                entity.getDireccion()
        );
    }

    private ClienteRetailEntity toRetailEntity(ClienteRetail model) {
        ClienteRetailEntity entity = new ClienteRetailEntity(
                model.numeroIdentificacion(),
                model.nombres(),
                model.apellidos(),
                model.email(),
                model.telefono(),
                model.direccion()
        );
        if (model.id() != null) {
            entity.setId(model.id());
        }
        return entity;
    }
}

// === ARCHIVO: src/main/java/com/pragma/backend/application/service/ClienteService.java ===
package com.pragma.backend.application.service;

import com.pragma.backend.domain.model.ClienteCorporativo;
import com.pragma.backend.domain.model.ClienteRetail;
import com.pragma.backend.domain.port.ClienteRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ClienteService {

    private static final Logger logger = LoggerFactory.getLogger(ClienteService.class);

    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Transactional
    public ClienteCorporativo crearClienteCorporativo(ClienteCorporativo cliente) {
        logger.info("Creando cliente corporativo con NIT: {}", cliente.nit());

        Optional<ClienteCorporativo> existente = clienteRepository.findCorporativoByNit(cliente.nit());
        if (existente.isPresent()) {
            logger.warn("Ya existe cliente corporativo con NIT: {}", cliente.nit());
            throw new ClienteExistenteException("Ya existe un cliente corporativo con el NIT: " + cliente.nit());
        }

        ClienteCorporativo guardado = clienteRepository.saveCorporativo(cliente);
        logger.info("Cliente corporativo creado exitosamente con ID: {}", guardado.id());
        return guardado;
    }

    @Transactional
    public ClienteRetail crearClienteRetail(ClienteRetail cliente) {
        logger.info("Creando cliente retail con identificacion: {}", cliente.numeroIdentificacion());

        Optional<ClienteRetail> existente = clienteRepository.findRetailByNumeroIdentificacion(cliente.numeroIdentificacion());
        if (existente.isPresent()) {
            logger.warn("Ya existe cliente retail con identificacion: {}", cliente.numeroIdentificacion());
            throw new ClienteExistenteException("Ya existe un cliente retail con el numero de identificacion: " + cliente.numeroIdentificacion());
        }

        ClienteRetail guardado = clienteRepository.saveRetail(cliente);
        logger.info("Cliente retail creado exitosamente con ID: {}", guardado.id());
        return guardado;
    }

    @Transactional(readOnly = true)
    public Optional<ClienteCorporativo> obtenerClienteCorporativo(UUID id) {
        logger.debug("Obteniendo cliente corporativo con ID: {}", id);
        return clienteRepository.findCorporativoById(id);
    }

    @Transactional(readOnly = true)
    public Optional<ClienteRetail> obtenerClienteRetail(UUID id) {
        logger.debug("Obteniendo cliente retail con ID: {}", id);
        return clienteRepository.findRetailById(id);
    }

    @Transactional(readOnly = true)
    public List<ClienteCorporativo> listarClientesCorporativos() {
        logger.debug("Listando todos los clientes corporativos");
        return clienteRepository.findAllCorporativos();
    }

    @Transactional(readOnly = true)
    public List<ClienteRetail> listarClientesRetail() {
        logger.debug("Listando todos los clientes retail");
        return clienteRepository.findAllRetail();
    }

    @Transactional
    public void eliminarClienteCorporativo(UUID id) {
        logger.info("Eliminando cliente corporativo con ID: {}", id);
        Optional<ClienteCorporativo> existente = clienteRepository.findCorporativoById(id);
        if (existente.isEmpty()) {
            logger.warn("No se encontro cliente corporativo con ID: {}", id);
            throw new ClienteNoEncontradoException("No se encontro el cliente corporativo con ID: " + id);
        }
        clienteRepository.deleteCorporativo(id);
        logger.info("Cliente corporativo eliminado exitosamente");
    }

    @Transactional
    public void eliminarClienteRetail(UUID id) {
        logger.info("Eliminando cliente retail con ID: {}", id);
        Optional<ClienteRetail> existente = clienteRepository.findRetailById(id);
        if (existente.isEmpty()) {
            logger.warn("No se encontro cliente retail con ID: {}", id);
            throw new ClienteNoEncontradoException("No se encontro el cliente retail con ID: " + id);
        }
        clienteRepository.deleteRetail(id);
        logger.info("Cliente retail eliminado exitosamente");
    }

    public static class ClienteExistenteException extends RuntimeException {
        public ClienteExistenteException(String message) {
            super(message);
        }
    }

    public static class ClienteNoEncontradoException extends RuntimeException {
        public ClienteNoEncontradoException(String message) {
            super(message);
        }
    }
}

// === ARCHIVO: src/main/java/com/pragma/backend/infrastructure/adapter/JpaClienteCorporativoRepository.java ===
package com.pragma.backend.infrastructure.adapter;

import com.pragma.backend.infrastructure.adapter.entity.ClienteCorporativoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface JpaClienteCorporativoRepository extends JpaRepository<ClienteCorporativoEntity, UUID> {
    Optional<ClienteCorporativoEntity> findByNit(String nit);
}

// === ARCHIVO: src/main/java/com/pragma/backend/infrastructure/adapter/JpaClienteRetailRepository.java ===
package com.pragma.backend.infrastructure.adapter;

import com.pragma.backend.infrastructure.adapter.entity.ClienteRetailEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface JpaClienteRetailRepository extends JpaRepository<ClienteRetailEntity, UUID> {
    Optional<ClienteRetailEntity> findByNumeroIdentificacion(String numeroIdentificacion);
}

// === ARCHIVO: src/main/java/com/pragma/backend/infrastructure/controller/ClienteController.java ===
package com.pragma.backend.infrastructure.controller;

import com.pragma.backend.domain.model.ClienteCorporativo;
import com.pragma.backend.domain.model.ClienteRetail;
import com.pragma.backend.application.service.ClienteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/clientes")
@Tag(name = "Clientes", description = "API para gestión de clientes corporativos y retail")
public class ClienteController {

    private static final Logger logger = LoggerFactory.getLogger(ClienteController.class);
    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @PostMapping("/corporativo")
    @Operation(summary = "Crear cliente corporativo", description = "Registra un nuevo cliente corporativo en el sistema")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Cliente corporativo creado exitosamente"),
        @ApiResponse(responseCode = "400", description = "Datos de cliente corporativo inválidos"),
        @ApiResponse(responseCode = "409", description = "Ya existe un cliente con ese NIT")
    })
    public ResponseEntity<ClienteCorporativo> crearClienteCorporativo(
            @Valid @RequestBody ClienteCorporativo cliente) {
        logger.info("Recibida solicitud para crear cliente corporativo con NIT: {}", cliente.nit());
        ClienteCorporativo creado = clienteService.crearClienteCorporativo(cliente);
        logger.info("Cliente corporativo creado exitosamente con ID: {}", creado.id());
        return ResponseEntity.status(HttpStatus.CREATED).body(creado);
    }

    @PostMapping("/retail")
    @Operation(summary = "Crear cliente retail", description = "Registra un nuevo cliente retail en el sistema")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Cliente retail creado exitosamente"),
        @ApiResponse(responseCode = "400", description = "Datos de cliente retail inválidos"),
        @ApiResponse(responseCode = "409", description = "Ya existe un cliente con ese número de identificación")
    })
    public ResponseEntity<ClienteRetail> crearClienteRetail(
            @Valid @RequestBody ClienteRetail cliente) {
        logger.info("Recibida solicitud para crear cliente retail con identificacion: {}", 
                    cliente.numeroIdentificacion());
        ClienteRetail creado = clienteService.crearClienteRetail(cliente);
        logger.info("Cliente retail creado exitosamente con ID: {}", creado.id());
        return ResponseEntity.status(HttpStatus.CREATED).body(creado);
    }

    @GetMapping("/corporativo/{id}")
    @Operation(summary = "Obtener cliente corporativo por ID", description = "Busca un cliente corporativo por su identificador único")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Cliente corporativo encontrado"),
        @ApiResponse(responseCode = "404", description = "Cliente corporativo no encontrado")
    })
    public ResponseEntity<ClienteCorporativo> obtenerCorporativoPorId(
            @Parameter(description = "UUID del cliente corporativo") @PathVariable UUID id) {
        logger.info("Buscando cliente corporativo con ID: {}", id);
        return clienteService.obtenerCorporativoPorId(id)
                .map(cliente -> {
                    logger.info("Cliente corporativo encontrado: {}", cliente.id());
                    return ResponseEntity.ok(cliente);
                })
                .orElseGet(() -> {
                    logger.warn("Cliente corporativo no encontrado con ID: {}", id);
                    return ResponseEntity.notFound().build();
                });
    }

    @GetMapping("/retail/{id}")
    @Operation(summary = "Obtener cliente retail por ID", description = "Busca un cliente retail por su identificador único")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Cliente retail encontrado"),
        @ApiResponse(responseCode = "404", description = "Cliente retail no encontrado")
    })
    public ResponseEntity<ClienteRetail> obtenerRetailPorId(
            @Parameter(description = "UUID del cliente retail") @PathVariable UUID id) {
        logger.info("Buscando cliente retail con ID: {}", id);
        return clienteService.obtenerRetailPorId(id)
                .map(cliente -> {
                    logger.info("Cliente retail encontrado: {}", cliente.id());
                    return ResponseEntity.ok(cliente);
                })
                .orElseGet(() -> {
                    logger.warn("Cliente retail no encontrado con ID: {}", id);
                    return ResponseEntity.notFound().build();
                });
    }

    @GetMapping("/corporativo")
    @Operation(summary = "Listar todos los clientes corporativos", description = "Retorna una lista de todos los clientes corporativos registrados")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Lista de clientes corporativos obtenida exitosamente")
    })
    public ResponseEntity<List<ClienteCorporativo>> listarClientesCorporativos() {
        logger.info("Listando todos los clientes corporativos");
        List<ClienteCorporativo> clientes = clienteService.listarTodosCorporativos();
        logger.info("Se encontraron {} clientes corporativos", clientes.size());
        return ResponseEntity.ok(clientes);
    }

    @GetMapping("/retail")
    @Operation(summary = "Listar todos los clientes retail", description = "Retorna una lista de todos los clientes retail registrados")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Lista de clientes retail obtenida exitosamente")
    })
    public ResponseEntity<List<ClienteRetail>> listarClientesRetail() {
        logger.info("Listando todos los clientes retail");
        List<ClienteRetail> clientes = clienteService.listarTodosRetail();
        logger.info("Se encontraron {} clientes retail", clientes.size());
        return ResponseEntity.ok(clientes);
    }

    @DeleteMapping("/corporativo/{id}")
    @Operation(summary = "Eliminar cliente corporativo", description = "Elimina un cliente corporativo por su identificador único")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "204", description = "Cliente corporativo eliminado exitosamente"),
        @ApiResponse(responseCode = "404", description = "Cliente corporativo no encontrado")
    })
    public ResponseEntity<Void> eliminarClienteCorporativo(
            @Parameter(description = "UUID del cliente corporativo a eliminar") @PathVariable UUID id) {
        logger.info("Eliminando cliente corporativo con ID: {}", id);
        if (clienteService.eliminarClienteCorporativo(id)) {
            logger.info("Cliente corporativo eliminado exitosamente: {}", id);
            return ResponseEntity.noContent().build();
        }
        logger.warn("Cliente corporativo no encontrado para eliminación: {}", id);
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/retail/{id}")
    @Operation(summary = "Eliminar cliente retail", description = "Elimina un cliente retail por su identificador único")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "204", description = "Cliente retail eliminado exitosamente"),
        @ApiResponse(responseCode = "404", description = "Cliente retail no encontrado")
    })
    public ResponseEntity<Void> eliminarClienteRetail(
            @Parameter(description = "UUID del cliente retail a eliminar") @PathVariable UUID id) {
        logger.info("Eliminando cliente retail con ID: {}", id);
        if (clienteService.eliminarClienteRetail(id)) {
            logger.info("Cliente retail eliminado exitosamente: {}", id);
            return ResponseEntity.noContent().build();
        }
        logger.warn("Cliente retail no encontrado para eliminación: {}", id);
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/corporativo/nit/{nit}")
    @Operation(summary = "Buscar cliente corporativo por NIT", description = "Busca un cliente corporativo por su número de NIT")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Cliente corporativo encontrado"),
        @ApiResponse(responseCode = "404", description = "Cliente corporativo no encontrado")
    })
    public ResponseEntity<ClienteCorporativo> buscarCorporativoPorNit(
            @Parameter(description = "NIT del cliente corporativo") @PathVariable String nit) {
        logger.info("Buscando cliente corporativo por NIT: {}", nit);
        return clienteService.buscarCorporativoPorNit(nit)
                .map(cliente -> {
                    logger.info("Cliente corporativo encontrado por NIT: {}", nit);
                    return ResponseEntity.ok(cliente);
                })
                .orElseGet(() -> {
                    logger.warn("Cliente corporativo no encontrado con NIT: {}", nit);
                    return ResponseEntity.notFound().build();
                });
    }

    @GetMapping("/retail/identificacion/{numeroIdentificacion}")
    @Operation(summary = "Buscar cliente retail por número de identificación", 
               description = "Busca un cliente retail por su número de identificación")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Cliente retail encontrado"),
        @ApiResponse(responseCode = "404", description = "Cliente retail no encontrado")
    })
    public ResponseEntity<ClienteRetail> buscarRetailPorIdentificacion(
            @Parameter(description = "Número de identificación del cliente retail") 
            @PathVariable String numeroIdentificacion) {
        logger.info("Buscando cliente retail por identificación: {}", numeroIdentificacion);
        return clienteService.buscarRetailPorIdentificacion(numeroIdentificacion)
                .map(cliente -> {
                    logger.info("Cliente retail encontrado por identificación: {}", numeroIdentificacion);
                    return ResponseEntity.ok(cliente);
                })
                .orElseGet(() -> {
                    logger.warn("Cliente retail no encontrado con identificación: {}", numeroIdentificacion);
                    return ResponseEntity.notFound().build();
                });
    }
}

// === ARCHIVO: src/main/java/com/pragma/backend/infrastructure/config/Resilience4jConfig.java ===
package com.pragma.backend.infrastructure.config;

import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig;
import io.github.resilience4j.circuitbreaker.CircuitBreakerRegistry;
import io.github.resilience4j.retry.RetryConfig;
import io.github.resilience4j.retry.RetryRegistry;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Duration;

@Configuration
public class Resilience4jConfig {

    // Superficie de práctica: el estudiante implementará la configuración de CircuitBreaker y Retry
    // para manejar picos de tráfico y garantizar la disponibilidad de los servicios.
    
    @Bean
    public CircuitBreakerRegistry circuitBreakerRegistry() {
        CircuitBreakerConfig config = CircuitBreakerConfig.custom()
                .failureRateThreshold(50)
                .waitDurationInOpenState(Duration.ofSeconds(60))
                .slidingWindowSize(10)
                .minimumNumberOfCalls(5)
                .permittedNumberOfCallsInHalfOpenState(3)
                .automaticTransitionFromOpenToHalfOpenEnabled(true)
                .build();
        return CircuitBreakerRegistry.of(config);
    }

    @Bean
    public RetryRegistry retryRegistry() {
        RetryConfig config = RetryConfig.custom()
                .maxAttempts(3)
                .waitDuration(Duration.ofMillis(500))
                .ignoreExceptions(RuntimeException.class)
                .build();
        return RetryRegistry.of(config);
    }
}

// === ARCHIVO: src/main/java/com/pragma/backend/infrastructure/config/LoggingAspect.java ===
package com.pragma.backend.infrastructure.config;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import jakarta.servlet.http.HttpServletRequest;
import java.util.Arrays;

@Aspect
@Component
public class LoggingAspect {

    private static final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

    @Pointcut("execution(* com.pragma.backend.infrastructure.controller..*(..))")
    public void controllerMethods() {
    }

    @Pointcut("execution(* com.pragma.backend.application.service..*(..))")
    public void serviceMethods() {
    }

    @Around("controllerMethods()")
    public Object logControllerMethods(ProceedingJoinPoint joinPoint) throws Throwable {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        String className = signature.getDeclaringType().getSimpleName();
        String methodName = signature.getName();
        
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes != null ? attributes.getRequest() : null;
        
        String requestInfo = "";
        if (request != null) {
            requestInfo = String.format("[%s] %s - ", request.getMethod(), request.getRequestURI());
        }
        
        logger.info("{}Iniciando ejecución: {}.{}()", requestInfo, className, methodName);
        
        Object[] args = joinPoint.getArgs();
        if (args != null && args.length > 0) {
            String argsSummary = Arrays.stream(args)
                    .map(arg -> {
                        if (arg == null) return "null";
                        if (arg instanceof HttpServletRequest) return "HttpServletRequest";
                        return arg.toString();
                    })
                    .reduce((a, b) -> a + ", " + b)
                    .orElse("");
            logger.debug("{}Parámetros de {}.{}: [{}]", requestInfo, className, methodName, argsSummary);
        }
        
        long startTime = System.currentTimeMillis();
        Object result = null;
        Throwable error = null;
        
        try {
            result = joinPoint.proceed();
            return result;
        } catch (Throwable ex) {
            error = ex;
            throw ex;
        } finally {
            long duration = System.currentTimeMillis() - startTime;
            
            if (error != null) {
                logger.error("{}Error en {}.{}(): {} - Duración: {}ms", 
                        requestInfo, className, methodName, error.getMessage(), duration);
            } else {
                String resultSummary = result != null ? result.toString() : "void";
                if (resultSummary.length() > 200) {
                    resultSummary = resultSummary.substring(0, 200) + "...";
                }
                logger.info("{}Completado: {}.{}() - Duración: {}ms - Resultado: {}", 
                        requestInfo, className, methodName, duration, resultSummary);
            }
        }
    }

    @Around("serviceMethods()")
    public Object logServiceMethods(ProceedingJoinPoint joinPoint) throws Throwable {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        String className = signature.getDeclaringType().getSimpleName();
        String methodName = signature.getName();
        
        logger.debug("Iniciando servicio: {}.{}()", className, methodName);
        
        long startTime = System.currentTimeMillis();
        Object result = null;
        Throwable error = null;
        
        try {
            result = joinPoint.proceed();
            return result;
        } catch (Throwable ex) {
            error = ex;
            throw ex;
        } finally {
            long duration = System.currentTimeMillis() - startTime;
            
            if (error != null) {
                logger.error("Error en servicio {}.{}(): {} - Duración: {}ms", 
                        className, methodName, error.getMessage(), duration);
            } else {
                logger.debug("Completado servicio: {}.{}() - Duración: {}ms", 
                        className, methodName, duration);
            }
        }
    }
}

// === ARCHIVO: src/main/resources/logback-spring.xml ===
<?xml version="1.0" encoding="UTF-8"?>
<configuration>
    <property name="LOG_PATH" value="${LOG_PATH:-./logs}"/>
    <property name="LOG_FILE" value="${LOG_FILE:-application}"/>
    <property name="LOG_PATTERN" value="%d{yyyy-MM-dd HH:mm:ss.SSS} [%thread] %-5level %logger{36} - %msg%n"/>
    <property name="CONSOLE_LOG_PATTERN" value="%clr(%d{yyyy-MM-dd HH:mm:ss.SSS}){faint} %clr([%thread]){magenta} %clr(%-5level){highlight} %clr(%logger{36}){cyan} - %msg%n"/>
    
    <appender name="CONSOLE" class="ch.qos.logback.core.ConsoleAppender">
        <encoder>
            <pattern>${CONSOLE_LOG_PATTERN}</pattern>
            <charset>UTF-8</charset>
        </encoder>
    </appender>
    
    <appender name="FILE" class="ch.qos.logback.core.rolling.RollingFileAppender">
        <file>${LOG_PATH}/${LOG_FILE}.log</file>
        <encoder>
            <pattern>${LOG_PATTERN}</pattern>
            <charset>UTF-8</charset>
        </encoder>
        <rollingPolicy class="ch.qos.logback.core.rolling.SizeAndTimeBasedRollingPolicy">
            <fileNamePattern>${LOG_PATH}/${LOG_FILE}-%d{yyyy-MM-dd}.%i.log</fileNamePattern>
            <maxFileSize>10MB</maxFileSize>
            <maxHistory>30</maxHistory>
            <totalSizeCap>1GB</totalSizeCap>
        </rollingPolicy>
    </appender>
    
    <appender name="ERROR_FILE" class="ch.qos.logback.core.rolling.RollingFileAppender">
        <file>${LOG_PATH}/error.log</file>
        <filter class="ch.qos.logback.classic.filter.ThresholdFilter">
            <level>ERROR</level>
        </filter>
        <encoder>
            <pattern>${LOG_PATTERN}</pattern>
            <charset>UTF-8</charset>
        </encoder>
        <rollingPolicy class="ch.qos.logback.core.rolling.SizeAndTimeBasedRollingPolicy">
            <fileNamePattern>${LOG_PATH}/error-%d{yyyy-MM-dd}.%i.log</fileNamePattern>
            <maxFileSize>10MB</maxFileSize>
            <maxHistory>60</maxHistory>
            <totalSizeCap>500MB</totalSizeCap>
        </rollingPolicy>
    </appender>
    
    <appender name="AUDIT_FILE" class="ch.qos.logback.core.rolling.RollingFileAppender">
        <file>${LOG_PATH}/audit.log</file>
        <encoder>
            <pattern>%d{yyyy-MM-dd HH:mm:ss.SSS} | %msg%n</pattern>
            <charset>UTF-8</charset>
        </encoder>
        <rollingPolicy class="ch.qos.logback.core.rolling.SizeAndTimeBasedRollingPolicy">
            <fileNamePattern>${LOG_PATH}/audit-%d{yyyy-MM-dd}.%i.log</fileNamePattern>
            <maxFileSize>10MB</maxFileSize>
            <maxHistory>90</maxHistory>
            <totalSizeCap>2GB</totalSizeCap>
        </rollingPolicy>
    </appender>
    
    <logger name="com.pragma.backend" level="DEBUG" additivity="false">
        <appender-ref ref="CONSOLE"/>
        <appender-ref ref="FILE"/>
        <appender-ref ref="ERROR_FILE"/>
    </logger>
    
    <logger name="com.pragma.backend.application" level="DEBUG" additivity="false">
        <appender-ref ref="CONSOLE"/>
        <appender-ref ref="FILE"/>
    </logger>
    
    <logger name="com.pragma.backend.domain" level="INFO" additivity="false">
        <appender-ref ref="CONSOLE"/>
        <appender-ref ref="FILE"/>
    </logger>
    
    <logger name="com.pragma.backend.infrastructure" level="DEBUG" additivity="false">
        <appender-ref ref="CONSOLE"/>
        <appender-ref ref="FILE"/>
        <appender-ref ref="ERROR_FILE"/>
    </logger>
    
    <logger name="org.springframework.web" level="INFO"/>
    <logger name="org.springframework.boot" level="INFO"/>
    <logger name="org.springframework.security" level="WARN"/>
    <logger name="org.hibernate.SQL" level="DEBUG"/>
    <logger name="org.hibernate.type.descriptor.sql.BasicBinder" level="TRACE"/>
    <logger name="org.hibernate.engine.jdbc.batch.internal.BatchingBatch" level="DEBUG"/>
    <logger name="io.github.resilience4j" level="INFO"/>
    <logger name="org.postgresql" level="INFO"/>
    
    <logger name="AUDIT" level="INFO" additivity="false">
        <appender-ref ref="AUDIT_FILE"/>
    </logger>
    
    <springProfile name="dev">
        <root level="DEBUG">
            <appender-ref ref="CONSOLE"/>
            <appender-ref ref="FILE"/>
        </root>
    </springProfile>
    
    <springProfile name="prod">
        <root level="INFO">
            <appender-ref ref="FILE"/>
            <appender-ref ref="ERROR_FILE"/>
        </root>
        <logger name="com.pragma.backend" level="INFO"/>
    </springProfile>
    
    <springProfile name="test">
        <root level="INFO">
            <appender-ref ref="CONSOLE"/>
        </root>
    </springProfile>
    
    <statusListener class="ch.qos.logback.core.status.OnConsoleStatusListener"/>
</configuration>

// === ARCHIVO: Dockerfile ===
FROM eclipse-temurin:21-jdk-alpine AS build

WORKDIR /app

RUN apk add --no-cache maven

COPY pom.xml .
COPY src ./src

RUN mvn clean package -DskipTests -B

FROM eclipse-temurin:21-jre-alpine

WORKDIR /app

RUN apk add --no-cache curl

COPY --from=build /app/target/*.jar app.jar

RUN addgroup -g 1000 appgroup && \
    adduser -u 1000 -G appgroup -s /bin/sh -D appuser

RUN mkdir -p /app/logs && \
    chown -R appuser:appgroup /app

USER appuser

EXPOSE 8080

ENV JAVA_OPTS="-XX:+UseContainerSupport -XX:MaxRAMPercentage=75.0 -Djava.security.egd=file:/dev/./urandom"
ENV SPRING_PROFILES_ACTIVE=prod
ENV LOG_PATH=/app/logs

HEALTHCHECK --interval=30s --timeout=10s --start-period=60s --retries=3 \
    CMD curl -f http://localhost:8080/actuator/health || exit 1

ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -jar /app/app.jar"]

// === ARCHIVO: docker-compose.yml ===
version: '3.8'

services:
  postgres:
    image: postgres:16-alpine
    container_name: backend-postgres
    environment:
      POSTGRES_DB: ${POSTGRES_DB:clientes_db}
      POSTGRES_USER: ${POSTGRES_USER:postgres}
      POSTGRES_PASSWORD: ${POSTGRES_PASSWORD:postgres}
      PGDATA: /var/lib/postgresql/data/pgdata
    ports:
      - "${POSTGRES_PORT:5432}:5432"
    volumes:
      - postgres_data:/var/lib/postgresql/data
    networks:
      - backend-network
    healthcheck:
      test: ["CMD-SHELL", "pg_isready -U ${POSTGRES_USER:postgres}"]
      interval: 10s
      timeout: 5s
      retries: 5
      start_period: 10s
    restart: unless-stopped
    deploy:
      resources:
        limits:
          cpus: '1.0'
          memory: 512M
        reservations:
          cpus: '0.5'
          memory: 256M

  app:
    build:
      context: .
      dockerfile: Dockerfile
    container_name: backend-app
    environment:
      SPRING_PROFILES_ACTIVE: ${SPRING_PROFILES_ACTIVE:prod}
      DATABASE_HOST: postgres
      DATABASE_PORT: 5432
      DATABASE_NAME: ${POSTGRES_DB:clientes_db}
      DATABASE_USERNAME: ${POSTGRES_USER:postgres}
      DATABASE_PASSWORD: ${POSTGRES_PASSWORD:postgres}
      DATABASE_URL: jdbc:postgresql://postgres:5432/${POSTGRES_DB:clientes_db}
      SERVER_PORT: 8080
      JAVA_OPTS: >-
        -XX:+UseContainerSupport
        -XX:MaxRAMPercentage=75.0
        -Djava.security.egd=file:/dev/./urandom
        -Dspring.profiles.active=${SPRING_PROFILES_ACTIVE:prod}
      LOG_PATH: /app/logs
      LOG_FILE: application
      RESILIENCE4J_CIRCUITBREAKER_CONFIG_INSTANCENAME: default
      RESILIENCE4J_RETRY_CONFIG_INSTANCENAME: default
    ports:
      - "${APP_PORT:8080}:8080"
    volumes:
      - app_logs:/app/logs
    networks:
      - backend-network
    depends_on:
      postgres:
        condition: service_healthy
    healthcheck:
      test: ["CMD", "curl", "-f", "http://localhost:8080/actuator/health"]
      interval: 30s
      timeout: 10s
      retries: 3
      start_period: 60s
    restart: unless-stopped
    deploy:
      resources:
        limits:
          cpus: '2.0'
          memory: 1G
        reservations:
          cpus: '1.0'
          memory: 512M

  prometheus:
    image: prom/prometheus:latest
    container_name: backend-prometheus
    volumes:
      - ./prometheus.yml:/etc/prometheus/prometheus.yml
      - prometheus_data:/prometheus
    command:
      - '--config.file=/etc/prometheus/prometheus.yml'
      - '--storage.tsdb.path=/prometheus'
      - '--web.console.libraries=/usr/share/prometheus/console_libraries'
      - '--web.console.templates=/usr/share/prometheus/consoles'
    ports:
      - "9090:9090"
    networks:
      - backend-network
    restart: unless-stopped

  grafana:
    image: grafana/grafana:latest
    container_name: backend-grafana
    environment:
      GF_SECURITY_ADMIN_USER: admin
      GF_SECURITY_ADMIN_PASSWORD: admin
      GF_USERS_ALLOW_SIGN_UP: "false"
    ports:
      - "3000:3000"
    volumes:
      - grafana_data:/var/lib/grafana
    networks:
      - backend-network
    depends_on:
      - prometheus
    restart: unless-stopped

networks:
  backend-network:
    driver: bridge
    ipam:
      config:
        - subnet: 172.20.0.0/16

volumes:
  postgres_data:
    driver: local
  app_logs:
    driver: local
  prometheus_data:
    driver: local
  grafana_data:
    driver: local

// === ARCHIVO: src/test/java/com/pragma/backend/application/service/ClienteServiceTest.java ===
package com.pragma.backend.application.service;

import com.pragma.backend.domain.model.ClienteCorporativo;
import com.pragma.backend.domain.model.ClienteRetail;
import com.pragma.backend.domain.port.ClienteRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@DisplayName("Pruebas unitarias del servicio de clientes")
class ClienteServiceTest {

    @Mock
    private ClienteRepository clienteRepository;

    @InjectMocks
    private ClienteService clienteService;

    private ClienteCorporativo clienteCorporativoMock;
    private ClienteRetail clienteRetailMock;
    private UUID idCorporativo;
    private UUID idRetail;

    @BeforeEach
    void setUp() {
        idCorporativo = UUID.randomUUID();
        idRetail = UUID.randomUUID();

        clienteCorporativoMock = new ClienteCorporativo(
            idCorporativo,
            "12345678-9",
            "Empresa SAS",
            "contacto@empresa.com",
            "Calle 123",
            new BigDecimal("1000000"),
            LocalDate.now()
        );

        clienteRetailMock = new ClienteRetail(
            idRetail,
            "1000000001",
            "Juan Perez",
            "juan@email.com",
            "Carrera 45 #67-89",
            new BigDecimal("50000"),
            LocalDate.of(1990, 5, 15)
        );
    }

    @Nested
    @DisplayName("Escenario: Guardar clientes corporativos")
    class GuardarClienteCorporativo {

        @Test
        @DisplayName("Debe guardar cliente corporativo exitosamente")
        void debeGuardarClienteCorporativoExitosamente() {
            when(clienteRepository.saveCorporativo(any(ClienteCorporativo.class)))
                .thenReturn(clienteCorporativoMock);

            ClienteCorporativo resultado = clienteService.guardarClienteCorporativo(
                "12345678-9",
                "Empresa SAS",
                "contacto@empresa.com",
                "Calle 123",
                new BigDecimal("1000000")
            );

            assertThat(resultado).isNotNull();
            assertThat(resultado.nit()).isEqualTo("12345678-9");
            assertThat(resultado.razonSocial()).isEqualTo("Empresa SAS");
            verify(clienteRepository, times(1)).saveCorporativo(any(ClienteCorporativo.class));
        }

        @Test
        @DisplayName("Debe lanzar excepción cuando el NIT ya existe")
        void debeLanzarExcepcionCuandoNitYaExiste() {
            when(clienteRepository.findCorporativoByNit("12345678-9"))
                .thenReturn(Optional.of(clienteCorporativoMock));

            assertThatThrownBy(() -> clienteService.guardarClienteCorporativo(
                "12345678-9",
                "Empresa SAS",
                "contacto@empresa.com",
                "Calle 123",
                new BigDecimal("1000000")
            )).isInstanceOf(IllegalArgumentException.class)
              .hasMessageContaining("NIT ya registrado");

            verify(clienteRepository, never()).saveCorporativo(any());
        }
    }

    @Nested
    @DisplayName("Escenario: Guardar clientes retail")
    class GuardarClienteRetail {

        @Test
        @DisplayName("Debe guardar cliente retail exitosamente")
        void debeGuardarClienteRetailExitosamente() {
            when(clienteRepository.saveRetail(any(ClienteRetail.class)))
                .thenReturn(clienteRetailMock);

            ClienteRetail resultado = clienteService.guardarClienteRetail(
                "1000000001",
                "Juan Perez",
                "juan@email.com",
                "Carrera 45 #67-89",
                new BigDecimal("50000"),
                LocalDate.of(1990, 5, 15)
            );

            assertThat(resultado).isNotNull();
            assertThat(resultado.numeroIdentificacion()).isEqualTo("1000000001");
            assertThat(resultado.nombre()).isEqualTo("Juan Perez");
            verify(clienteRepository, times(1)).saveRetail(any(ClienteRetail.class));
        }

        @Test
        @DisplayName("Debe lanzar excepción cuando el número de identificación ya existe")
        void debeLanzarExcepcionCuandoNumeroIdentificacionYaExiste() {
            when(clienteRepository.findRetailByNumeroIdentificacion("1000000001"))
                .thenReturn(Optional.of(clienteRetailMock));

            assertThatThrownBy(() -> clienteService.guardarClienteRetail(
                "1000000001",
                "Juan Perez",
                "juan@email.com",
                "Carrera 45 #67-89",
                new BigDecimal("50000"),
                LocalDate.of(1990, 5, 15)
            )).isInstanceOf(IllegalArgumentException.class)
              .hasMessageContaining("identificación ya registrada");

            verify(clienteRepository, never()).saveRetail(any());
        }
    }

    @Nested
    @DisplayName("Escenario: Buscar clientes por ID")
    class BuscarClientePorId {

        @Test
        @DisplayName("Debe encontrar cliente corporativo por ID")
        void debeEncontrarClienteCorporativoPorId() {
            when(clienteRepository.findCorporativoById(idCorporativo))
                .thenReturn(Optional.of(clienteCorporativoMock));

            Optional<ClienteCorporativo> resultado = clienteService
                .buscarClienteCorporativoPorId(idCorporativo);

            assertThat(resultado).isPresent();
            assertThat(resultado.get().nit()).isEqualTo("12345678-9");
        }

        @Test
        @DisplayName("Debe retornar vacío cuando cliente corporativo no existe")
        void debeRetornarVacioCuandoClienteCorporativoNoExiste() {
            UUID idNoExistente = UUID.randomUUID();
            when(clienteRepository.findCorporativoById(idNoExistente))
                .thenReturn(Optional.empty());

            Optional<ClienteCorporativo> resultado = clienteService
                .buscarClienteCorporativoPorId(idNoExistente);

            assertThat(resultado).isEmpty();
        }

        @Test
        @DisplayName("Debe encontrar cliente retail por ID")
        void debeEncontrarClienteRetailPorId() {
            when(clienteRepository.findRetailById(idRetail))
                .thenReturn(Optional.of(clienteRetailMock));

            Optional<ClienteRetail> resultado = clienteService
                .buscarClienteRetailPorId(idRetail);

            assertThat(resultado).isPresent();
            assertThat(resultado.get().numeroIdentificacion()).isEqualTo("1000000001");
        }
    }

    @Nested
    @DisplayName("Escenario: Listar todos los clientes")
    class ListarClientes {

        @Test
        @DisplayName("Debe listar todos los clientes corporativos")
        void debeListarTodosLosClientesCorporativos() {
            when(clienteRepository.findAllCorporativos())
                .thenReturn(List.of(clienteCorporativoMock));

            List<ClienteCorporativo> resultado = clienteService.listarClientesCorporativos();

            assertThat(resultado).hasSize(1);
            assertThat(resultado.get(0).nit()).isEqualTo("12345678-9");
        }

        @Test
        @DisplayName("Debe listar todos los clientes retail")
        void debeListarTodosLosClientesRetail() {
            when(clienteRepository.findAllRetail())
                .thenReturn(List.of(clienteRetailMock));

            List<ClienteRetail> resultado = clienteService.listarClientesRetail();

            assertThat(resultado).hasSize(1);
            assertThat(resultado.get(0).numeroIdentificacion()).isEqualTo("1000000001");
        }

        @Test
        @DisplayName("Debe retornar lista vacía cuando no hay clientes corporativos")
        void debeRetornarListaVaciaCuandoNoHayClientesCorporativos() {
            when(clienteRepository.findAllCorporativos())
                .thenReturn(List.of());

            List<ClienteCorporativo> resultado = clienteService.listarClientesCorporativos();

            assertThat(resultado).isEmpty();
        }
    }

    @Nested
    @DisplayName("Escenario: Eliminar clientes")
    class EliminarClientes {

        @Test
        @DisplayName("Debe eliminar cliente corporativo por ID")
        void debeEliminarClienteCorporativoPorId() {
            doNothing().when(clienteRepository).deleteCorporativo(idCorporativo);

            clienteService.eliminarClienteCorporativo(idCorporativo);

            verify(clienteRepository, times(1)).deleteCorporativo(idCorporativo);
        }

        @Test
        @DisplayName("Debe eliminar cliente retail por ID")
        void debeEliminarClienteRetailPorId() {
            doNothing().when(clienteRepository).deleteRetail(idRetail);

            clienteService.eliminarClienteRetail(idRetail);

            verify(clienteRepository, times(1)).deleteRetail(idRetail);
        }
    }
}

// === ARCHIVO: src/test/java/com/pragma/backend/infrastructure/controller/ClienteControllerTest.java ===
package com.pragma.backend.infrastructure.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pragma.backend.application.service.ClienteService;
import com.pragma.backend.domain.model.ClienteCorporativo;
import com.pragma.backend.domain.model.ClienteRetail;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ClienteController.class)
@DisplayName("Pruebas de integración del controlador de clientes")
class ClienteControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private ClienteService clienteService;

    private ClienteCorporativo clienteCorporativoMock;
    private ClienteRetail clienteRetailMock;
    private UUID idCorporativo;
    private UUID idRetail;

    @BeforeEach
    void setUp() {
        idCorporativo = UUID.randomUUID();
        idRetail = UUID.randomUUID();

        clienteCorporativoMock = new ClienteCorporativo(
            idCorporativo,
            "12345678-9",
            "Empresa SAS",
            "contacto@empresa.com",
            "Calle 123",
            new BigDecimal("1000000"),
            LocalDate.now()
        );

        clienteRetailMock = new ClienteRetail(
            idRetail,
            "1000000001",
            "Juan Perez",
            "juan@email.com",
            "Carrera 45 #67-89",
            new BigDecimal("50000"),
            LocalDate.of(1990, 5, 15)
        );
    }

    @Nested
    @DisplayName("API: Endpoints de clientes corporativos")
    class EndpointsClientesCorporativos {

        @Test
        @DisplayName("POST /api/clientes/corporativos debe crear cliente corporativo")
        void postDebeCrearClienteCorporativo() throws Exception {
            when(clienteService.guardarClienteCorporativo(
                anyString(), anyString(), anyString(), anyString(), any(BigDecimal.class))
            ).thenReturn(clienteCorporativoMock);

            mockMvc.perform(post("/api/clientes/corporativos")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content("""
                        {
                            "nit": "12345678-9",
                            "razonSocial": "Empresa SAS",
                            "correoContacto": "contacto@empresa.com",
                            "direccion": "Calle 123",
                            "cupoCredito": 1000000
                        }
                        """))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.nit").value("12345678-9"))
                .andExpect(jsonPath("$.razonSocial").value("Empresa SAS"));

            verify(clienteService, times(1)).guardarClienteCorporativo(
                anyString(), anyString(), anyString(), anyString(), any(BigDecimal.class));
        }

        @Test
        @DisplayName("GET /api/clientes/corporativos/{id} debe retornar cliente corporativo")
        void getDebeRetornarClienteCorporativo() throws Exception {
            when(clienteService.buscarClienteCorporativoPorId(idCorporativo))
                .thenReturn(Optional.of(clienteCorporativoMock));

            mockMvc.perform(get("/api/clientes/corporativos/{id}", idCorporativo))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nit").value("12345678-9"))
                .andExpect(jsonPath("$.razonSocial").value("Empresa SAS"));
        }

        @Test
        @DisplayName("GET /api/clientes/corporativos/{id} debe retornar 404 cuando no existe")
        void getDebeRetornar404CuandoNoExiste() throws Exception {
            UUID idNoExistente = UUID.randomUUID();
            when(clienteService.buscarClienteCorporativoPorId(idNoExistente))
                .thenReturn(Optional.empty());

            mockMvc.perform(get("/api/clientes/corporativos/{id}", idNoExistente))
                .andExpect(status().isNotFound());
        }

        @Test
        @DisplayName("GET /api/clientes/corporativos debe listar todos los corporativos")
        void getDebeListarTodosLosCorporativos() throws Exception {
            when(clienteService.listarClientesCorporativos())
                .thenReturn(List.of(clienteCorporativoMock));

            mockMvc.perform(get("/api/clientes/corporativos"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(1))
                .andExpect(jsonPath("$[0].nit").value("12345678-9"));
        }

        @Test
        @DisplayName("DELETE /api/clientes/corporativos/{id} debe eliminar cliente corporativo")
        void deleteDebeEliminarClienteCorporativo() throws Exception {
            doNothing().when(clienteService).eliminarClienteCorporativo(idCorporativo);

            mockMvc.perform(delete("/api/clientes/corporativos/{id}", idCorporativo))
                .andExpect(status().isNoContent());

            verify(clienteService, times(1)).eliminarClienteCorporativo(idCorporativo);
        }
    }

    @Nested
    @DisplayName("API: Endpoints de clientes retail")
    class EndpointsClientesRetail {

        @Test
        @DisplayName("POST /api/clientes/retail debe crear cliente retail")
        void postDebeCrearClienteRetail() throws Exception {
            when(clienteService.guardarClienteRetail(
                anyString(), anyString(), anyString(), anyString(), any(BigDecimal.class), any(LocalDate.class))
            ).thenReturn(clienteRetailMock);

            mockMvc.perform(post("/api/clientes/retail")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content("""
                        {
                            "numeroIdentificacion": "1000000001",
                            "nombre": "Juan Perez",
                            "correo": "juan@email.com",
                            "direccion": "Carrera 45 #67-89",
                            "ingresoMensual": 50000,
                            "fechaNacimiento": "1990-05-15"
                        }
                        """))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.numeroIdentificacion").value("1000000001"))
                .andExpect(jsonPath("$.nombre").value("Juan Perez"));

            verify(clienteService, times(1)).guardarClienteRetail(
                anyString(), anyString(), anyString(), anyString(), any(BigDecimal.class), any(LocalDate.class));
        }

        @Test
        @DisplayName("GET /api/clientes/retail/{id} debe retornar cliente retail")
        void getDebeRetornarClienteRetail() throws Exception {
            when(clienteService.buscarClienteRetailPorId(idRetail))
                .thenReturn(Optional.of(clienteRetailMock));

            mockMvc.perform(get("/api/clientes/retail/{id}", idRetail))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.numeroIdentificacion").value("1000000001"))
                .andExpect(jsonPath("$.nombre").value("Juan Perez"));
        }

        @Test
        @DisplayName("GET /api/clientes/retail/{id} debe retornar 404 cuando no existe")
        void getDebeRetornar404CuandoNoExisteRetail() throws Exception {
            UUID idNoExistente = UUID.randomUUID();
            when(clienteService.buscarClienteRetailPorId(idNoExistente))
                .thenReturn(Optional.empty());

            mockMvc.perform(get("/api/clientes/retail/{id}", idNoExistente))
                .andExpect(status().isNotFound());
        }

        @Test
        @DisplayName("GET /api/clientes/retail debe listar todos los retail")
        void getDebeListarTodosLosRetail() throws Exception {
            when(clienteService.listarClientesRetail())
                .thenReturn(List.of(clienteRetailMock));

            mockMvc.perform(get("/api/clientes/retail"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(1))
                .andExpect(jsonPath("$[0].numeroIdentificacion").value("1000000001"));
        }

        @Test
        @DisplayName("DELETE /api/clientes/retail/{id} debe eliminar cliente retail")
        void deleteDebeEliminarClienteRetail() throws Exception {
            doNothing().when(clienteService).eliminarClienteRetail(idRetail);

            mockMvc.perform(delete("/api/clientes/retail/{id}", idRetail))
                .andExpect(status().isNoContent());

            verify(clienteService, times(1)).eliminarClienteRetail(idRetail);
        }
    }

    @Nested
    @DisplayName("API: Validaciones de entrada")
    class ValidacionesEntrada {

        @Test
        @DisplayName("POST /api/clientes/corporativos debe retornar 400 con datos inválidos")
        void postDebeRetornar400DatosInvalidos() throws Exception {
            mockMvc.perform(post("/api/clientes/corporativos")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content("""
                        {
                            "nit": "",
                            "razonSocial": "",
                            "correoContacto": "correo-invalido",
                            "direccion": "Calle 123",
                            "cupoCredito": -100
                        }
                        """))
                .andExpect(status().isBadRequest());
        }

        @Test
        @DisplayName("POST /api/clientes/retail debe retornar 400 con datos inválidos")
        void postRetailDebeRetornar400DatosInvalidos() throws Exception {
            mockMvc.perform(post("/api/clientes/retail")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content("""
                        {
                            "numeroIdentificacion": "",
                            "nombre": "",
                            "correo": "no-es-correo",
                            "direccion": "Carrera 45",
                            "ingresoMensual": -500,
                            "fechaNacimiento": "fecha-invalida"
                        }
                        """))
                .andExpect(status().isBadRequest());
        }
    }
}
```
