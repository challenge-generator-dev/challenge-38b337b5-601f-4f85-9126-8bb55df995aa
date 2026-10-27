# Implementación de un Backend con Spring Framework

La empresa necesita un backend robusto que maneje solicitudes de clientes, controle variables de entorno, genere registros de rastros y se conecte con una base de datos utilizando un Mapeador Relacional de Objetos (ORM). Los clientes (ClientesCorporativos, ClientesRetail) enviarán solicitudes a través de una API REST. El sistema debe registrar todas las solicitudes y respuestas en un archivo de logs y almacenar la información de los clientes en una base de datos relacional. El sistema debe ser capaz de manejar picos de tráfico y garantizar la disponibilidad de los servicios.

## Informacion General

| Campo | Valor |
|-------|-------|
| **Tema** | Experiencia en Frameworks |
| **Nivel** | advanced-l2 |
| **Tipo** | practical |
| **Tiempo estimado** | 20 horas |

## Fases del Reto

### Fase 0: Configuración del Proyecto

**Objetivo:** Obtener el proyecto base funcional enviando el Código Base a un asistente de IA, que lo analizará, corregirá errores y generará un ZIP listo para usar.

**Tiempo estimado:** 15-30 minutos

**Instrucciones:**

- Asegúrate de tener instalado para ejecutar el proyecto: JDK 17+, Maven 3.9+, IDE con soporte Java.
- Copia todo el contenido del campo **Código Base** de este reto — incluyendo el texto de instrucciones que aparece al inicio.
- Abre un asistente de IA (Claude en claude.ai, ChatGPT o Gemini — se recomienda Claude), pega el contenido copiado en el chat y envíalo.
- El asistente analizará los archivos, corregirá errores y generará un archivo ZIP descargable. Descárgalo y extráelo en la carpeta donde quieras trabajar.
- Ejecuta `mvn compile` en la raíz. Si no hay errores, estás listo.

**Entregable:** El proyecto compila/arranca sin errores.

<details>
<summary>Pistas de conocimiento</summary>

- Copia el Código Base completo incluyendo el texto de instrucciones al inicio — esas instrucciones le indican al asistente exactamente qué hacer con los archivos.
- Si el asistente no genera el ZIP automáticamente al terminar el análisis, escríbele: "genera el ZIP ahora".
- Si el proyecto tiene errores al arrancar, comparte el mensaje de error con el mismo asistente para que lo corrija.

</details>

### Fase 1: Configuración del Entorno

**Objetivo:** Configurar el entorno de desarrollo y establecer las bases para el proyecto Spring.

**Tiempo estimado:** 4 horas

**Instrucciones:**

- Configurar el proyecto Spring con las dependencias necesarias.
- Establecer las variables de entorno para el proyecto.

**Entregable:** Proyecto Spring configurado con las dependencias y variables de entorno establecidas.

<details>
<summary>Pistas de conocimiento</summary>

- Configuración básica de un proyecto Spring.
- Uso de variables de entorno en aplicaciones Spring.

</details>

### Fase 2: Implementación de la API REST

**Objetivo:** Crear una API REST que maneje solicitudes de clientes y registre las solicitudes y respuestas en un archivo de logs.

**Tiempo estimado:** 6 horas

**Instrucciones:**

- Implementar endpoints REST para recibir solicitudes de clientes.
- Registrar cada solicitud y respuesta en un archivo de logs.

**Entregable:** API REST implementada con endpoints para recibir solicitudes de clientes y registro de solicitudes y respuestas en un archivo de logs.

<details>
<summary>Pistas de conocimiento</summary>

- Creación de endpoints REST en Spring.
- Uso de loggers para registrar información.

</details>

### Fase 3: Conexión con Base de Datos

**Objetivo:** Conectar la aplicación con una base de datos relacional utilizando un ORM y almacenar la información de los clientes.

**Tiempo estimado:** 6 horas

**Instrucciones:**

- Configurar la conexión con la base de datos utilizando un ORM.
- Crear entidades y repositorios para almacenar la información de los clientes.

**Entregable:** Aplicación conectada a una base de datos relacional con entidades y repositorios para almacenar la información de los clientes.

<details>
<summary>Pistas de conocimiento</summary>

- Configuración de la conexión con la base de datos en Spring.
- Uso de ORM para mapear entidades a tablas de la base de datos.

</details>

### Fase 4: Manejo de Picos de Tráfico y Disponibilidad

**Objetivo:** Implementar mecanismos para manejar picos de tráfico y garantizar la disponibilidad de los servicios.

**Tiempo estimado:** 4 horas

**Instrucciones:**

- Implementar mecanismos para manejar picos de tráfico.
- Asegurar la disponibilidad de los servicios en caso de fallos.

**Entregable:** Mecanismos implementados para manejar picos de tráfico y garantizar la disponibilidad de los servicios.

<details>
<summary>Pistas de conocimiento</summary>

- Técnicas para manejar picos de tráfico en aplicaciones Spring.
- Estrategias para garantizar la disponibilidad de los servicios.

</details>

## Dimensiones Evaluadas

- **queEs**: ¿Qué es Spring Framework y para qué se utiliza?
- **paraQueSirve**: ¿Para qué sirve un ORM en una aplicación Spring?
- **comoSeUsa**: ¿Cómo se utiliza un logger para registrar información en una aplicación Spring?
- **erroresComunes**: ¿Cuáles son los errores comunes al conectar una aplicación Spring con una base de datos?
- **queDecisionesImplica**: ¿Qué decisiones implica implementar mecanismos para manejar picos de tráfico y garantizar la disponibilidad de los servicios?

## Criterios de Evaluacion

- Configuración correcta del entorno de desarrollo con Spring Framework.
- Implementación de una API REST que maneje solicitudes de clientes y registre solicitudes y respuestas en un archivo de logs.
- Conexión exitosa con una base de datos relacional utilizando un ORM y almacenamiento de información de clientes.
- Implementación de mecanismos para manejar picos de tráfico y garantizar la disponibilidad de los servicios.

## Como trabajar con un asistente de IA

Hay dos caminos, elegi uno:

- **AGENTS.md** (recomendado) — instrucciones nativas del repo. Abri esta carpeta con tu agente local (Claude Code, Cursor, Codex, Copilot, Gemini) y las carga solo. Sabe que archivos faltan y con que comando se verifica, y completa el scaffold escribiendo en disco.
- **PROMPT_MEJORA.md** — para copiar y pegar en un chat (claude.ai, ChatGPT). Devuelve un ZIP con el proyecto. Sirve si no tenes un agente en el IDE.

Ninguno de los dos resuelve las fases del reto: eso es tu trabajo.

## Verificacion

El proyecto esta listo para trabajar cuando este comando corre sin errores:

```bash
mvn clean compile
```

---

*Reto generado automaticamente por Challenge Generator - Pragma*
