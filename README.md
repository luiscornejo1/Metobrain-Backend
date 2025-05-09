# 📘 API REST – AgileBoard Backend (Metobrain)

**Base URL:**  
```
https://metobrain-backend-production.up.railway.app
```

---

## 🔐 Autenticación

> Actualmente **sin autenticación** (pública). Se recomienda proteger con JWT.

---

## 📦 Endpoints disponibles

### 🔹 UsuarioController

| Método | Endpoint                  | Descripción                  |
|--------|---------------------------|------------------------------|
| `GET`  | `/api/usuarios`          | Listar todos los usuarios    |
| `POST` | `/api/usuarios`          | Crear un nuevo usuario       |
| `GET`  | `/api/usuarios/{id}`     | Obtener usuario por ID       |
| `DELETE` | `/api/usuarios/{id}`   | Eliminar usuario por ID      |

📥 **Body ejemplo (POST):**
```json
{
  "nombre": "Luis",
  "email": "luis@correo.com",
  "password": "clave123",
  "rol": "SCRUM_MASTER"
}
```

---

### 🔹 TareaController

| Método   | Endpoint                        | Descripción                     |
|----------|----------------------------------|---------------------------------|
| `GET`    | `/api/tareas`                   | Listar todas las tareas         |
| `POST`   | `/api/tareas`                   | Crear nueva tarea               |
| `PUT`    | `/api/tareas/{id}`              | Actualizar tarea por ID         |
| `DELETE` | `/api/tareas/{id}`              | Eliminar tarea por ID           |
| `GET`    | `/api/tareas/sprint/{sprintId}` | Tareas asociadas a un sprint    |

📥 **Body ejemplo (POST):**
```json
{
  "titulo": "Crear dashboard",
  "descripcion": "Implementar vista gráfica",
  "estado": "PENDIENTE",
  "sprint": {
    "id": 1
  }
}
```

---

### 🔹 SprintController

| Método | Endpoint                                                      | Descripción                             |
|--------|---------------------------------------------------------------|-----------------------------------------|
| `GET`  | `/api/sprints`                                               | Listar todos los sprints                |
| `POST` | `/api/sprints`                                               | Crear un nuevo sprint                   |
| `GET`  | `/api/sprints/tareas-por-estado/sprint/{id}`                 | Cantidad de tareas por estado en sprint |
| `GET`  | `/api/sprints/proyecto/{proyectoId}`                         | Sprints por proyecto                    |

📥 **Body ejemplo (POST):**
```json
{
  "nombre": "Sprint 1",
  "fechaInicio": "2025-05-10",
  "fechaFin": "2025-05-20",
  "proyecto": {
    "id": 1
  }
}
```

---

## 🧪 Cómo probar

- Usa **Swagger UI**:  
  [`/swagger-ui.html`](https://metobrain-backend-production.up.railway.app/swagger-ui.html)
- O Postman con la URL base

---

## 📌 Pendientes sugeridos

- Autenticación con JWT
- Validación con `@Valid` y manejo de errores globales
- Paginación en `/usuarios` y `/tareas`
- Endpoint `/api/dashboard` (resumen global)
