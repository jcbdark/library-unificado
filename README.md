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
—
PRODUCTS

-- Categorías
INSERT INTO category (name) VALUES ('Útiles Escolares');
INSERT INTO category (name) VALUES ('Tecnología');
INSERT INTO category (name) VALUES ('Papelería');


-- Productos (fíjate que category_id sí lo ponemos porque es FK)
INSERT INTO product (name, description, price, stock, category_id, active)
VALUES ('Cuaderno A4', 'Cuaderno tamaño A4', 5.50, 100, 1, true);


INSERT INTO product (name, description, price, stock, category_id, active)
VALUES ('Lápiz HB', 'Lápiz estándar HB', 1.20, 200, 1, true);


INSERT INTO product (name, description, price, stock, category_id, active)
VALUES ('Laptop', 'Laptop de oficina', 1200.50, 0, 2, true);


INSERT INTO product (name, description, price, stock, category_id, active)
VALUES ('Mouse inalámbrico', 'Mouse óptico', 25.00, 0, 2, true);
  

—-----

INSERT IGNORE INTO customer (name, email, phone, address)
VALUES ('Juan Pérez', 'juan@example.com', '987654321', 'Av. Siempre Viva 742, Lima');


INSERT IGNORE INTO customer (name, email, phone, address)
VALUES ('María López', 'maria@example.com', '912345678', 'Calle Falsa 123, Arequipa');


-- ==========================
-- Sales
-- ==========================
INSERT IGNORE INTO sales (id, customer_id, sale_date, total_amount)
VALUES (1, 1, NOW(), 2580.00);
-- ==========================
-- SaleDetails
INSERT IGNORE INTO sale_details (id, sale_id, product_id, quantity, price)
VALUES (1, 1, 1, 1, 2500.00);


INSERT IGNORE INTO sale_details (id, sale_id, product_id, quantity, price)
VALUES (2, 1, 2, 1, 80.00);






http://localhost:8081/api/products

http://localhost:8081/api/products/1

http://localhost:8082/api/customers

http://localhost:8082/api/customers/2

post

http://localhost:8082/api/customers





{
  "name": "jordan Pérez",
  "email": "jordan@example.com",
  "phone": "987654321",
  "address": "Av. Los Álamos 123"
}




http://localhost:8081/api/products



{
  "name": "Laptop Lenovo Thinkpad",
  "description": "15 pulgadas, Core i9, 32GB RAM",
  "price": 3200.00,
  "stock": 8,
  "categoryId": 1
}

delete

http://localhost:8081/api/products/3




http://localhost:8082/api/customers/5

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
