## Taller — Implementación de listas enlazadas en Java

*Autor:* Tu Nombre  
*Fecha:* 2025-09-08  
*Versión:* 3.0  

## 🎯 Propósito
Implementar y comprender las operaciones de inserción y eliminación en listas enlazadas (simples, dobles y circulares), analizando sus costos computacionales y reforzando la manipulación de nodos en memoria dinámica.

## 📊 Análisis de complejidad

| Operación               | Lista simple | Lista doble |
|--------------------------|--------------|-------------|
| Insertar al inicio       | O(1)         | O(1)        |
| Insertar al final        | O(n)         | O(1)*       |
| Insertar en posición     | O(n)         | O(n)        |
| Eliminar al inicio       | O(1)         | O(1)        |
| Eliminar al final        | O(n)         | O(1)*       |
| Eliminar en posición     | O(n)         | O(n)        |

\* En la lista doble, si se mantiene una referencia al último nodo (fin), las operaciones de inserción y eliminación al final se realizan en O(1).