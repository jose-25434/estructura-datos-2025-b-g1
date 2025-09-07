## Sistema de Biblioteca (Proyecto en Java)
Autor
Nombre: Jose Gabriel David Mendez
Ingeniería en Sistemas
Tercer Semestre
## 📌 Descripción
Este sistema permite administrar un catálogo de publicaciones, registrar rentas activas y llevar un historial de operaciones.  
Está implementado en Java utilizando *arrays, listas simples y listas dobles*, y se maneja desde un menú de consola.

---

## ⚙️ Estructuras utilizadas
- *Biblioteca (Array + Matriz 2D)*  
  - Se usa un array de publicaciones y una matriz para la disponibilidad en sucursales.  
  - Complejidad: búsqueda e inserción → O(n); modificar stock → O(1).  

- *GestorRentas (Lista Simple)*  
  - Maneja las rentas activas dinámicamente.  
  - Complejidad: insertar o devolver → O(n).  

- *Bitácora (Lista Doble)*  
  - Registra las operaciones del sistema y permite recorrer en ambos sentidos.  
  - Complejidad: insertar → O(1); recorrer → O(n).  

---

## ▶️ Cómo compilar y ejecutar
1. Guardar todos los archivos .java en la misma carpeta.  
2. Compilar en consola:  
   ```bash
   javac *.java