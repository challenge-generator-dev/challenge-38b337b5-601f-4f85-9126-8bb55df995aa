# AGENTS.md

Instrucciones para el agente de IA que abra este repositorio (Claude Code, Cursor, Codex, Copilot, Gemini). Se cargan solas: no hay que pegar nada en ningun chat.

## Que es este repositorio

Es el codigo base de un reto de aprendizaje de Pragma: **Implementación de un Backend con Spring Framework**.

| | |
|---|---|
| Tema | Experiencia en Frameworks |
| Nivel | advanced-l2 |
| Chapter | Backend |
| Especialidad | Java |
| Stack | Java / Spring Boot 3.5 |
| Patron arquitectonico | capas estándar (domain, application, infrastructure) |
| Tiempo estimado | 20 horas |

## Receta del stack

Esqueleto obligatorio:

- `pom.xml en la raiz`
- `clase con @SpringBootApplication`
- `application.yml en src/main/resources`
- `capa de dominio con entidades y puertos`
- `capa de aplicacion con casos de uso`
- `capa de infraestructura con adaptadores y @RestController`

Trampas conocidas:

- TODA `<version>` del pom va con tres segmentos: la del parent (ej. `3.5.6`) y la de cada dependencia que la lleve (ej. Resilience4j `2.2.0`). `3.4` y `2.0` no existen como artefacto y el build muere resolviendo dependencias.
- Las dependencias que el parent POM gestiona van SIN `<version>`: `spring-boot-starter-web`, `-data-jpa`, `-validation`, `-test`, etc.
- Resilience4j publica un artefacto por linea de Spring Boot. Con Spring Boot 3 va `resilience4j-spring-boot3` con version de tres segmentos (ej. `2.2.0`, no `2.0`). `resilience4j-spring-boot2` es de Spring Boot 2 y rompe el arranque.
- Si usas anotaciones de validacion (`@NotNull`, `@Size`, `@Positive`) declara `spring-boot-starter-validation`: el starter web no las trae.
- El `spring-boot-maven-plugin` tiene que estar en `<build><plugins>` o no se empaqueta ejecutable.
- Spring Boot 3 usa `jakarta.*`, nunca `javax.*`.
- Cada archivo empieza con su `package` y con un `import` por cada clase del proyecto que viva en otro paquete. Usar `PaymentService` desde `infrastructure` sin `import com.x.application.PaymentService` no compila.

Dependencias:

- org.springframework.boot:spring-boot-starter-web n/a
- org.springframework.boot:spring-boot-starter-data-jpa n/a
- org.springframework.boot:spring-boot-starter-validation n/a
- org.springframework.boot:spring-boot-starter-actuator n/a
- org.springframework.boot:spring-boot-starter-aop n/a
- io.github.resilience4j:resilience4j-spring-boot3 2.2.0
- org.postgresql:postgresql n/a
- org.projectlombok:lombok n/a
- org.springdoc:springdoc-openapi-starter-webmvc-ui 2.5.0
- org.springframework.boot:spring-boot-starter-test n/a
- org.testcontainers:postgresql 1.19.7

## Tu tarea

Dejar este proyecto en estado **verificable**: que el comando de verificacion corra sin errores. Escribi los archivos en disco, en este repositorio. No generes ZIPs ni archivos adjuntos.

En orden:

1. Corre `mvn clean compile` y mira que falla.
2. Completa lo que falte de la lista de abajo: manifiesto de dependencias, punto de entrada, capa de interfaz y las capas del patron declarado.
3. Arregla SOLO los errores que impiden compilar o arrancar.
4. Volve a correr `mvn clean compile` hasta que pase.
5. Pará ahí.

## Regla dura: las fases son trabajo del humano

**PROHIBIDO implementar los entregables de las fases.** El valor del reto esta en que la persona los resuelva. Tu trabajo es que tenga un proyecto que arranca; el hueco pedagogico se queda como esta.

No resuelvas nada de esto:

- **Fase 1 — Configuración del Entorno**: Proyecto Spring configurado con las dependencias y variables de entorno establecidas.
- **Fase 2 — Implementación de la API REST**: API REST implementada con endpoints para recibir solicitudes de clientes y registro de solicitudes y respuestas en un archivo de logs.
- **Fase 3 — Conexión con Base de Datos**: Aplicación conectada a una base de datos relacional con entidades y repositorios para almacenar la información de los clientes.
- **Fase 4 — Manejo de Picos de Tráfico y Disponibilidad**: Mecanismos implementados para manejar picos de tráfico y garantizar la disponibilidad de los servicios.

Distincion operativa:

- **Arreglar** (si): import faltante, tipo que no existe, dependencia sin declarar, error de sintaxis, archivo referenciado que no existe.
- **No tocar** (no): logica de negocio incompleta, validaciones ausentes, secretos hardcodeados, APIs deprecadas que funcionan, concurrencia insegura, patrones mejorables. Eso es lo que la persona tiene que encontrar.

## Superficie de practica (NO completes)

Estos archivos SON el ejercicio de la persona. No los implementes; deja stubs. No toques la logica que el reto pide completar.

- [ ] `src/main/java/com/pragma/backend/infrastructure/config/Resilience4jConfig.java` — El topic pide resiliencia: este archivo es el ejercicio.

## Lo que falta y tenes que completar

### 1. Referencias colgando (47)

Salieron de un analisis estatico del codigo que SI esta en el repo. Cada una rompe la compilacion:

- [ ] `src/main/java/com/pragma/backend/BackendApplication.java` — `org.slf4j`
      El import org.slf4j.Logger pertenece a org.slf4j, pero ninguna dependencia declarada en el pom.xml cubre ese paquete. Falta agregar la dependencia o el import esta mal (libreria equivocada).
- [ ] `src/main/java/com/pragma/backend/application/service/ClienteService.java` — `org.slf4j`
      El import org.slf4j.Logger pertenece a org.slf4j, pero ninguna dependencia declarada en el pom.xml cubre ese paquete. Falta agregar la dependencia o el import esta mal (libreria equivocada).
- [ ] `src/main/java/com/pragma/backend/infrastructure/controller/ClienteController.java` — `io.swagger.v3`
      El import io.swagger.v3.oas.annotations.Operation pertenece a io.swagger.v3, pero ninguna dependencia declarada en el pom.xml cubre ese paquete. Falta agregar la dependencia o el import esta mal (libreria equivocada).
- [ ] `src/main/java/com/pragma/backend/infrastructure/controller/ClienteController.java` — `org.slf4j`
      El import org.slf4j.Logger pertenece a org.slf4j, pero ninguna dependencia declarada en el pom.xml cubre ese paquete. Falta agregar la dependencia o el import esta mal (libreria equivocada).
- [ ] `src/main/java/com/pragma/backend/infrastructure/config/LoggingAspect.java` — `org.aspectj.lang`
      El import org.aspectj.lang.ProceedingJoinPoint pertenece a org.aspectj.lang, pero ninguna dependencia declarada en el pom.xml cubre ese paquete. Falta agregar la dependencia o el import esta mal (libreria equivocada).
- [ ] `src/main/java/com/pragma/backend/infrastructure/config/LoggingAspect.java` — `org.slf4j`
      El import org.slf4j.Logger pertenece a org.slf4j, pero ninguna dependencia declarada en el pom.xml cubre ese paquete. Falta agregar la dependencia o el import esta mal (libreria equivocada).
- [ ] `src/test/java/com/pragma/backend/infrastructure/controller/ClienteControllerTest.java` — `com.fasterxml.jackson`
      El import com.fasterxml.jackson.databind.ObjectMapper pertenece a com.fasterxml.jackson, pero ninguna dependencia declarada en el pom.xml cubre ese paquete. Falta agregar la dependencia o el import esta mal (libreria equivocada).
- [ ] `src/main/java/com/pragma/backend/infrastructure/adapter/JpaClienteRepository.java` — `JpaClienteCorporativoRepository.save`
      Se invoca `save` sobre `JpaClienteCorporativoRepository`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/pragma/backend/infrastructure/adapter/JpaClienteRepository.java` — `JpaClienteRetailRepository.save`
      Se invoca `save` sobre `JpaClienteRetailRepository`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/pragma/backend/infrastructure/adapter/JpaClienteRepository.java` — `JpaClienteCorporativoRepository.findById`
      Se invoca `findById` sobre `JpaClienteCorporativoRepository`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/pragma/backend/infrastructure/adapter/JpaClienteRepository.java` — `JpaClienteRetailRepository.findById`
      Se invoca `findById` sobre `JpaClienteRetailRepository`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/pragma/backend/infrastructure/adapter/JpaClienteRepository.java` — `JpaClienteCorporativoRepository.findAll`
      Se invoca `findAll` sobre `JpaClienteCorporativoRepository`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/pragma/backend/infrastructure/adapter/JpaClienteRepository.java` — `JpaClienteRetailRepository.findAll`
      Se invoca `findAll` sobre `JpaClienteRetailRepository`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/pragma/backend/infrastructure/adapter/JpaClienteRepository.java` — `JpaClienteCorporativoRepository.deleteById`
      Se invoca `deleteById` sobre `JpaClienteCorporativoRepository`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/pragma/backend/infrastructure/adapter/JpaClienteRepository.java` — `JpaClienteRetailRepository.deleteById`
      Se invoca `deleteById` sobre `JpaClienteRetailRepository`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/pragma/backend/infrastructure/adapter/JpaClienteRepository.java` — `ClienteRetail.nit`
      Se invoca `nit` sobre `ClienteRetail`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/pragma/backend/infrastructure/adapter/JpaClienteRepository.java` — `ClienteRetail.razonSocial`
      Se invoca `razonSocial` sobre `ClienteRetail`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/pragma/backend/infrastructure/adapter/JpaClienteRepository.java` — `ClienteRetail.email`
      Se invoca `email` sobre `ClienteRetail`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/pragma/backend/infrastructure/adapter/JpaClienteRepository.java` — `ClienteRetail.telefono`
      Se invoca `telefono` sobre `ClienteRetail`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/pragma/backend/infrastructure/adapter/JpaClienteRepository.java` — `ClienteRetail.direccion`
      Se invoca `direccion` sobre `ClienteRetail`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/pragma/backend/infrastructure/adapter/JpaClienteRepository.java` — `ClienteRetail.id`
      Se invoca `id` sobre `ClienteRetail`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/pragma/backend/infrastructure/adapter/JpaClienteRepository.java` — `ClienteRetail.numeroIdentificacion`
      Se invoca `numeroIdentificacion` sobre `ClienteRetail`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/pragma/backend/infrastructure/adapter/JpaClienteRepository.java` — `ClienteRetail.nombres`
      Se invoca `nombres` sobre `ClienteRetail`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/pragma/backend/infrastructure/adapter/JpaClienteRepository.java` — `ClienteRetail.apellidos`
      Se invoca `apellidos` sobre `ClienteRetail`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/pragma/backend/application/service/ClienteService.java` — `ClienteRetail.nit`
      Se invoca `nit` sobre `ClienteRetail`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/pragma/backend/application/service/ClienteService.java` — `ClienteRetail.id`
      Se invoca `id` sobre `ClienteRetail`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/pragma/backend/application/service/ClienteService.java` — `ClienteRetail.numeroIdentificacion`
      Se invoca `numeroIdentificacion` sobre `ClienteRetail`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/pragma/backend/infrastructure/controller/ClienteController.java` — `ClienteRetail.nit`
      Se invoca `nit` sobre `ClienteRetail`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/pragma/backend/infrastructure/controller/ClienteController.java` — `ClienteRetail.id`
      Se invoca `id` sobre `ClienteRetail`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/pragma/backend/infrastructure/controller/ClienteController.java` — `ClienteRetail.numeroIdentificacion`
      Se invoca `numeroIdentificacion` sobre `ClienteRetail`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/pragma/backend/infrastructure/controller/ClienteController.java` — `ClienteService.obtenerCorporativoPorId`
      Se invoca `obtenerCorporativoPorId` sobre `ClienteService`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/pragma/backend/infrastructure/controller/ClienteController.java` — `ClienteService.obtenerRetailPorId`
      Se invoca `obtenerRetailPorId` sobre `ClienteService`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/pragma/backend/infrastructure/controller/ClienteController.java` — `ClienteService.listarTodosCorporativos`
      Se invoca `listarTodosCorporativos` sobre `ClienteService`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/pragma/backend/infrastructure/controller/ClienteController.java` — `ClienteService.listarTodosRetail`
      Se invoca `listarTodosRetail` sobre `ClienteService`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/pragma/backend/infrastructure/controller/ClienteController.java` — `ClienteService.buscarCorporativoPorNit`
      Se invoca `buscarCorporativoPorNit` sobre `ClienteService`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/pragma/backend/infrastructure/controller/ClienteController.java` — `ClienteService.buscarRetailPorIdentificacion`
      Se invoca `buscarRetailPorIdentificacion` sobre `ClienteService`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/pragma/backend/application/service/ClienteServiceTest.java` — `ClienteService.guardarClienteCorporativo`
      Se invoca `guardarClienteCorporativo` sobre `ClienteService`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/pragma/backend/application/service/ClienteServiceTest.java` — `ClienteRetail.nit`
      Se invoca `nit` sobre `ClienteRetail`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/pragma/backend/application/service/ClienteServiceTest.java` — `ClienteRetail.razonSocial`
      Se invoca `razonSocial` sobre `ClienteRetail`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/pragma/backend/application/service/ClienteServiceTest.java` — `ClienteService.guardarClienteRetail`
      Se invoca `guardarClienteRetail` sobre `ClienteService`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/pragma/backend/application/service/ClienteServiceTest.java` — `ClienteRetail.numeroIdentificacion`
      Se invoca `numeroIdentificacion` sobre `ClienteRetail`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/pragma/backend/application/service/ClienteServiceTest.java` — `ClienteRetail.nombre`
      Se invoca `nombre` sobre `ClienteRetail`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/pragma/backend/application/service/ClienteServiceTest.java` — `ClienteRetail.get`
      Se invoca `get` sobre `ClienteRetail`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/pragma/backend/infrastructure/controller/ClienteControllerTest.java` — `ClienteService.guardarClienteCorporativo`
      Se invoca `guardarClienteCorporativo` sobre `ClienteService`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/pragma/backend/infrastructure/controller/ClienteControllerTest.java` — `ClienteService.buscarClienteCorporativoPorId`
      Se invoca `buscarClienteCorporativoPorId` sobre `ClienteService`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/pragma/backend/infrastructure/controller/ClienteControllerTest.java` — `ClienteService.guardarClienteRetail`
      Se invoca `guardarClienteRetail` sobre `ClienteService`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/pragma/backend/infrastructure/controller/ClienteControllerTest.java` — `ClienteService.buscarClienteRetailPorId`
      Se invoca `buscarClienteRetailPorId` sobre `ClienteService`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.

### Presentes (19)

- `pom.xml`
- `src/main/java/com/pragma/backend/BackendApplication.java`
- `src/main/resources/application.yml`
- `src/main/java/com/pragma/backend/domain/model/ClienteCorporativo.java`
- `src/main/java/com/pragma/backend/domain/model/ClienteRetail.java`
- `src/main/java/com/pragma/backend/domain/port/ClienteRepository.java`
- `src/main/java/com/pragma/backend/infrastructure/adapter/entity/ClienteEntity.java`
- `src/main/java/com/pragma/backend/infrastructure/adapter/JpaClienteRepository.java`
- `src/main/java/com/pragma/backend/application/service/ClienteService.java`
- `src/main/java/com/pragma/backend/infrastructure/adapter/JpaClienteCorporativoRepository.java`
- `src/main/java/com/pragma/backend/infrastructure/adapter/JpaClienteRetailRepository.java`
- `src/main/java/com/pragma/backend/infrastructure/controller/ClienteController.java`
- `src/main/java/com/pragma/backend/infrastructure/config/Resilience4jConfig.java`
- `src/main/java/com/pragma/backend/infrastructure/config/LoggingAspect.java`
- `src/main/resources/logback-spring.xml`
- `Dockerfile`
- `docker-compose.yml`
- `src/test/java/com/pragma/backend/application/service/ClienteServiceTest.java`
- `src/test/java/com/pragma/backend/infrastructure/controller/ClienteControllerTest.java`

### Capas del patron declarado

Cada una tiene que existir como directorio real con al menos un archivo. Codigo plano en la raiz no satisface el patron.

- `src/main/java/com/pragma/backend`
- `src/main/java/com/pragma/backend/domain/model`
- `src/main/java/com/pragma/backend/domain/port`
- `src/main/java/com/pragma/backend/application/service`
- `src/main/java/com/pragma/backend/infrastructure/adapter`
- `src/main/java/com/pragma/backend/infrastructure/config`
- `src/main/java/com/pragma/backend/infrastructure/controller`
- `src/main/resources`
- `src/test/java/com/pragma/backend`

## Verificacion

```bash
mvn clean compile
```

El comando tiene que pasar SIN implementar los archivos de la superficie de practica: solo andamiaje.

Ese comando pasando es la definicion de "terminado" para vos.

## Convenciones que tenes que respetar

- Un solo ecosistema: no declares librerias de otro lenguaje ni mezcles gestores de paquetes.
- Toda libreria que uses tiene que estar declarada en el manifiesto de dependencias.
- Todo import declarado tiene que usarse; todo tipo usado tiene que existir o venir de una dependencia declarada.
- El patron es **capas estándar (domain, application, infrastructure)**: los contratos (interfaces, puertos) los define la capa interna y los implementa la externa, nunca al revés.
- Los archivos que crees llevan implementacion real, no stubs: sin `TODO`, sin cuerpos vacios, sin `// getters y setters`.

## Contexto del candidato

Sirve para calibrar el nivel del codigo, no para resolver las fases.

- Perfil: Chapter Backend, Especialidad Spring, Tecnología Java, Advanced L2
- Brecha que el reto ataca: Experiencia comprobable en al menos un marco de trabajo (Framework) en su lenguaje de programación principal (por ejemplo, Spring Framework en Java o ASP .net core en C#) y puede realizar el enrutamiento de solicitudes, controlar las variables de entorno, generar registros de rastros (Logs) y conectarse con bases de datos utilizando un Mapeador Relacional de Objetos (ORM).

---

*Generado por Challenge Generator — Pragma. `README.md` tiene el enunciado completo del reto para la persona. `PROMPT_MEJORA.md` es la variante para pegar en un chat, si se prefiere ese flujo.*
