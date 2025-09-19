# 📚 Library Unificado

Aplicación en **Java + Spring Boot** que unifica la gestión de **productos**, **clientes** y **ventas** en una biblioteca/tienda.  
Incluye **microservicios** independientes y APIs REST para manejar el flujo completo de negocio.

---

## ✨ Características

- 🔹 Microservicios separados para **Products** y **Customers**.  
- 🔹 API REST con operaciones **CRUD**.  
- 🔹 Persistencia en **MySQL** con relaciones entre tablas.  
- 🔹 Organización modular (`entity`, `repository`, `services`, `dto`).  

---

## 🛠️ Requisitos

- ☕ **Java JDK 17+**  
- 📦 **Maven**  
- 🗄️ **MySQL 8+**  
- 💻 IDE recomendado: **IntelliJ IDEA**  

---

## ⚙️ Instalación

Clona el repositorio:

```bash
git clone https://github.com/jcbdark/library-unificado.git
cd library-unificado
```

Configura la base de datos en `application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/library
spring.datasource.username=tu_usuario
spring.datasource.password=tu_password
spring.jpa.hibernate.ddl-auto=update
```

Compila y ejecuta el proyecto:

```bash
mvn clean install
mvn spring-boot:run
```

---

## 🗄️ Script de Base de Datos

Ejemplo de inserciones iniciales:

```sql
-- ==========================
-- Categorías
-- ==========================
INSERT INTO category (name) VALUES ('Útiles Escolares');
INSERT INTO category (name) VALUES ('Tecnología');
INSERT INTO category (name) VALUES ('Papelería');

-- ==========================
-- Productos
-- ==========================
INSERT INTO product (name, description, price, stock, category_id, active)
VALUES ('Cuaderno A4', 'Cuaderno tamaño A4', 5.50, 100, 1, true);

INSERT INTO product (name, description, price, stock, category_id, active)
VALUES ('Lápiz HB', 'Lápiz estándar HB', 1.20, 200, 1, true);

INSERT INTO product (name, description, price, stock, category_id, active)
VALUES ('Laptop', 'Laptop de oficina', 1200.50, 0, 2, true);

INSERT INTO product (name, description, price, stock, category_id, active)
VALUES ('Mouse inalámbrico', 'Mouse óptico', 25.00, 0, 2, true);

-- ==========================
-- Clientes
-- ==========================
INSERT IGNORE INTO customer (name, email, phone, address)
VALUES ('Juan Pérez', 'juan@example.com', '987654321', 'Av. Siempre Viva 742, Lima');

INSERT IGNORE INTO customer (name, email, phone, address)
VALUES ('María López', 'maria@example.com', '912345678', 'Calle Falsa 123, Arequipa');

-- ==========================
-- Ventas
-- ==========================
INSERT IGNORE INTO sales (id, customer_id, sale_date, total_amount)
VALUES (1, 1, NOW(), 2580.00);

-- ==========================
-- Detalle de ventas
-- ==========================
INSERT IGNORE INTO sale_details (id, sale_id, product_id, quantity, price)
VALUES (1, 1, 1, 1, 2500.00);

INSERT IGNORE INTO sale_details (id, sale_id, product_id, quantity, price)
VALUES (2, 1, 2, 1, 80.00);
```

---

## 🌐 Endpoints API

### 📦 Products (puerto `8081`)

- **Listar productos**
  ```http
  GET http://localhost:8081/api/products
  ```

- **Obtener producto por ID**
  ```http
  GET http://localhost:8081/api/products/1
  ```

- **Crear producto**
  ```http
  POST http://localhost:8081/api/products
  Content-Type: application/json

  {
    "name": "Laptop Lenovo Thinkpad",
    "description": "15 pulgadas, Core i9, 32GB RAM",
    "price": 3200.00,
    "stock": 8,
    "categoryId": 1
  }
  ```

- **Eliminar producto**
  ```http
  DELETE http://localhost:8081/api/products/3
  ```

---

### 👤 Customers (puerto `8082`)

- **Listar clientes**
  ```http
  GET http://localhost:8082/api/customers
  ```

- **Obtener cliente por ID**
  ```http
  GET http://localhost:8082/api/customers/2
  ```

- **Crear cliente**
  ```http
  POST http://localhost:8082/api/customers
  Content-Type: application/json

  {
    "name": "Jordan Pérez",
    "email": "jordan@example.com",
    "phone": "987654321",
    "address": "Av. Los Álamos 123"
  }
  ```

- **Eliminar cliente**
  ```http
  DELETE http://localhost:8082/api/customers/5
  ```

---

## 🤝 Contribución

1. Haz un **fork** del repositorio.  
2. Crea una rama:  
   ```bash
   git checkout -b mi-feature
   ```
3. Haz commit de tus cambios.  
4. Haz push a tu rama.  
5. Abre un **Pull Request**.  

---
