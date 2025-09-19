# 📚 Library Unificado

Proyecto en **Java** que unifica y gestiona funcionalidades de una biblioteca.  
Este repositorio centraliza la lógica y los servicios relacionados con clientes, productos y otros módulos de una librería/biblioteca.

---

## 🚀 Características

- Estructura modular en **Java**.
- Soporte para gestión de **clientes** y **productos**.
- Preparado para integrarse con **Spring Boot** y servicios REST.
- Organización limpia en paquetes (`entity`, `repository`, `services`, `dto`).

---

## 🛠️ Requisitos

- **Java JDK 17+**  
- **Maven** o **Gradle**  
- IDE recomendado: **IntelliJ IDEA** / **Eclipse**  

---

## 📦 Instalación

Clona el repositorio:

```bash
git clone https://github.com/jcbdark/library-unificado.git
cd library-unificado
```

Compila el proyecto con Maven:

```bash
mvn clean install
```

Ejecuta la aplicación:

```bash
mvn spring-boot:run
```

---

## 📌 Estructura del Proyecto

```plaintext
library-unificado/
 ┣ src/main/java/com/example/library/
 ┃ ┣ dto/              # Objetos de transferencia de datos (DTOs)
 ┃ ┣ entity/           # Entidades JPA
 ┃ ┣ repository/       # Repositorios (Spring Data JPA)
 ┃ ┣ services/         # Lógica de negocio
 ┃ ┗ LibraryApplication.java  # Clase principal
 ┣ src/main/resources/
 ┃ ┣ application.properties   # Configuración del proyecto
 ┗ pom.xml             # Configuración Maven
```

---

## 📚 Ejemplo de Uso

### Crear un Cliente (POST)

```http
POST /api/customers
Content-Type: application/json

{
  "name": "Juan Pérez",
  "email": "juan@example.com",
  "phone": "987654321",
  "address": "Av. Siempre Viva 123"
}
```

### Listar Clientes (GET)

```http
GET /api/customers
```

Respuesta:

```json
[
  {
    "id": 1,
    "name": "Juan Pérez",
    "email": "juan@example.com",
    "phone": "987654321",
    "address": "Av. Siempre Viva 123"
  }
]
```

---

## 🤝 Contribución

1. Haz un **fork** del repositorio.  
2. Crea una rama para tu feature o fix:  
   ```bash
   git checkout -b mi-feature
   ```
3. Haz commit de tus cambios:  
   ```bash
   git commit -m "Agregada nueva funcionalidad"
   ```
4. Haz push a la rama:  
   ```bash
   git push origin mi-feature
   ```
5. Abre un **Pull Request**.

---
