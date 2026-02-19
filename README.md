# Java EE - Ejercicio (MVC + Sesión)
Sistema web desarrollado en Java EE siguiendo el patrón MVC con gestión de sesiones, autenticación de usuarios y búsqueda de eventos conectada a MySQL mediante DataSource.

# 🎟️ Sistema de Gestión de Eventos - Java EE (MVC + Sesión)

Proyecto desarrollado en **Java EE** utilizando el patrón **MVC (Modelo-Vista-Controlador)** con gestión de sesiones, autenticación de usuarios y acceso a base de datos MySQL mediante `DataSource`.

---

## 📌 Descripción del Proyecto

Aplicación web que permite:

- 🔐 Inicio y cierre de sesión de usuarios
- 👤 Gestión de sesión HTTP
- 🔎 Búsqueda de eventos por nombre o descripción
- 📋 Listado dinámico de eventos
- ⚠️ Gestión de errores personalizada

El sistema está conectado a una base de datos MySQL llamada `festivaldb2`.

---

## 🏗️ Arquitectura

El proyecto sigue el patrón **MVC**:

### 📂 Modelo
- `ModeloUsuario`
- `ModeloEvento`
- Acceso a datos mediante `DataSource`
- Uso de `PreparedStatement`
- Excepción personalizada `ExcepcionPropia`

### 🎮 Controladores
- `ControladorIniciarSesion`
- `ControladorCerrarSesion`
- `ControladorBuscarEventos`
- `ControladorVolver`
- Interfaz común `IControlador`

### 🖥️ Vista (JSP + JSTL)
- `Login.jsp`
- `BuscarEventos.jsp`
- `MostrarEventos.jsp`

### 🌐 Servlet Front Controller
- `ServletEventos`

---

## 🗄️ Base de Datos

Base de datos: `festivaldb2`

Tablas principales:

- `usuarios`
- `eventos`

Conexión configurada en:

### `context.xml`
```xml
<Resource name="jdbc/festivaldb2"
          auth="Container"
          type="javax.sql.DataSource"
          username="root"
          password="root"
          driverClassName="com.mysql.cj.jdbc.Driver"
          url="jdbc:mysql://localhost:3306/festivaldb2" />
🛠️ Tecnologías utilizadas
Java EE

Servlets

JSP

JSTL

MVC

MySQL

Apache Tomcat

Bootstrap

HTML5 / CSS3

🚀 Funcionamiento
1️⃣ Inicio de sesión
El usuario introduce:

Usuario

Password

Si las credenciales son correctas:

Se crea sesión (HttpSession)

Se redirige a la búsqueda de eventos

Si son incorrectas:

Se muestra mensaje de error

2️⃣ Búsqueda de eventos
Permite:

Mostrar todos los eventos

Filtrar por nombre o descripción

Consulta SQL utilizada:

SELECT * FROM eventos
WHERE nombre LIKE ? OR descripcion LIKE ?
3️⃣ Cierre de sesión
Se invalida la sesión

Redirección a Login.jsp

🔐 Gestión de Sesión
Se utiliza:

request.getSession().setAttribute("datosUsuario", usuario);
Y para cerrar sesión:

request.getSession().invalidate();
⚠️ Gestión de Errores
Se implementa una excepción personalizada:

public class ExcepcionPropia extends Exception
Mensajes controlados:

Usuario/Password incorrecta

Campos obligatorios

No hay resultados

Error en base de datos

📁 Estructura del Proyecto
src/
 ├── entidades/
 ├── modelos/
 ├── controladores/
 ├── excepciones/
 └── servlets/

WebContent/
 ├── WEB-INF/
 ├── css/
 ├── Login.jsp
 ├── BuscarEventos.jsp
 └── MostrarEventos.jsp
🎯 Objetivos del ejercicio
Aplicar patrón MVC en entorno Java EE

Gestionar sesiones HTTP

Implementar acceso a base de datos con DataSource

Manejar excepciones personalizadas

Separar correctamente responsabilidades

👨‍💻 Autor
Manuel Moraira Garcia

Proyecto académico - Java EE (MVC + Sesión)

📄 Licencia
Uso académico / educativo


---

