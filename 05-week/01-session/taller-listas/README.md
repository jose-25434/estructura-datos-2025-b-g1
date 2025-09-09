Fecha: 2025-09-09 | Versión: 4.0 | Autor: Jose Gabriel David Mendez Roncancio
## Descripción general
Este trabajo implementa listas enlazadas en Java (simple, doble y circular) 
usando una estructura de nodo con valor y enlace(s). La lista simple incluye
todas las operaciones mínimas: insertar al inicio, al final y en una posición;
y eliminar al inicio, al final y en una posición. La lista doble agrega punteros
al anterior/siguiente para operar en O(1) en los extremos; la circular mantiene
una referencia al último nodo para recorrer en ciclo. Cada ejercicio tiene su 
propio `main` y muestra por consola la evidencia de que las operaciones funcionan. 
Se controlan casos de error (lista vacía, posiciones inválidas) y se indica la 
complejidad Big-O de las operaciones principales.

## Análisis por ejercicio

### Ejercicio 1 — Lista básica (insertar al final y mostrar)
**Objetivo.** Crear una lista simple, insertar varios elementos **al final** y **mostrar** el contenido.  
**Qué se prueba.** La construcción de nodos, el recorrido secuencial y el enlazado al último.  
**Casos borde.** Lista vacía → primer insert crea la cabeza; un único elemento; varios elementos.  

### Ejercicio 2 — Inserción en cualquier posición (índice)
**Objetivo.** Permitir insertar un elemento en una **posición dada** (0 = inicio).  
**Qué se prueba.** Cálculo del nodo previo a la posición y reasignación de enlaces.  
**Decisiones.** Si el índice ≤ 0, se inserta al inicio; si es mayor al tamaño, se inserta al final (comportamiento seguro).  
**Casos borde.** Índice negativo; índice 0; índice mayor que el tamaño; lista vacía.  

### Ejercicio 3 — Eliminación con validación (por posición)
**Objetivo.** Eliminar un nodo en una **posición específica**, validando errores.  
**Qué se prueba.** Borrado en cabeza y borrado en medio/fin ajustando el enlace del previo.  
**Señales de error.** Devuelve `false` cuando la posición no existe o la lista está vacía.  
**Casos borde.** Lista vacía; posición 0; última posición; posición fuera de rango.  

### Ejercicio 4 — Lista doblemente enlazada (operar en los extremos)
**Objetivo.** Implementar lista **doble** y demostrar **inserción/eliminación al inicio y al final**.  
**Qué se prueba.** Correcto mantenimiento de `anterior` y `siguiente`, y punteros `cabeza/cola`.  
**Casos borde.** Lista vacía; un solo nodo (al eliminar inicio/fin la lista queda vacía).  

### Ejercicio 5 — Lista circular (inserción y eliminación por valor)
**Objetivo.** Usar una lista **circular** (el último apunta al primero), insertar al final y **eliminar por valor**.  
**Qué se prueba.** Recorrido con ciclo usando un `do-while`, manejo del último nodo y caso de lista con un único nodo.  
**Casos borde.** Eliminar el único nodo; eliminar el `ultimo`; valor inexistente; lista vacía.  

### Ejercicio 6 — Caso práctico (cola de consultorio)
**Objetivo.** Simular una **cola FIFO**: encolar = insertar al final; atender = eliminar en posición 0.  
**Qué se prueba.** Reutilización de la lista simple para modelar una estructura de cola con operaciones básicas.  
**Casos borde.** Atender con cola vacía; atender hasta que quede vacía.