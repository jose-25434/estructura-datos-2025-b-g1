# COMPLEJIDAD — HashTable (encadenamiento)

## ¿Cómo funciona a nivel de costo?
- Las claves se “reparten” entre varias posiciones llamadas buckets usando hashCode() + una pequeña mezcla de bits.
- Cada bucket tiene una lista enlazada con los pares que caen ahí (colisiones).
- Cuando la tabla supera el 75% de ocupación (factor de carga 0.75), se duplica el arreglo interno y se reubican las entradas (rehashing).

## Complejidad de las operaciones

| Operación        | Promedio (distribución decente) | Peor caso (muchas colisiones en un bucket) |
|------------------|----------------------------------|--------------------------------------------|
| `put(K,V)`       | **O(1)** amortizado              | **O(n)**                                   |
| `get(K)`         | **O(1)**                          | **O(n)**                                   |
| `remove(K)`      | **O(1)**                          | **O(n)**                                   |
| `containsKey(K)` | **O(1)**                          | **O(n)**                                   |
| `size()`         | **O(1)**                          | **O(1)**                                   |
| `isEmpty()`      | **O(1)**                          | **O(1)**                                   |
