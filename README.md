# Movies

## Refactoring: Movies

## <em>**Versión 1.**</em> Clase “Customer” - Método “statement()”

### <em>**Smell code**</em>:
####  Método largo => más de 15 líneas
- Mal reparto de responsabilidades => Falta de Cohesión
- Imposible reutilizar para otro formato (HTML) => Inmóvil
  * copy+paste => DRY
- Cambio de política de coste y puntos => 
  * Viscoso
- copy+paste => multiplica y complica el mantenimiento

### <em>**Refactoring**</em>: 

Extraer Método => switch y código dependiente en método “amountFor” de clase Customer|

![claseCustomer](/out/docs/diagrams/src/movies/movies.svg) 

## <em>**Versión 2.**</em> Clase “Customer“ - Método “amountFor()“

### <em>**Smell code:**</em>

- Malos nombres => “each” y “thisAmount”

### <em>**Refactoring:**</em>

- Renombrar variable => “rental” y “result”

![claseCustomer](/out/docs/diagrams/src/movies2/movies.svg)

## <em>**Versión 3.**</em> Clase “Customer“ - Método “amountFor()“

### <em>**Smell Code:**</em>

- Envidia de características => get(), get(), … desde el servidor

- Clase de Datos => get(), get(), … en el cliente
Experto en Información => la clase responsable es la que tiene la información

### <em>**Refactoring**</em>

- Mover método => método “getCharge” a clase “Rental”

## <em>**Versión 4.**</em> Clase “Customer“ – Método “amountFor()“

### <em>**Smell Code:**</em>

- “Innecesaria descomposición”: método privado sin justificación

### <em>**Refactoring**</em>

- Método en línea => eliminar “amountFor”

![claseCustomer](/out/docs/diagrams/src/movies4/movies.svg)


## <em>**Versión 5.**</em> Clase “Customer“ – Método “statement()“

### <em>**Smell Code:**</em>

- Variable temporal innecesaria => “thisAmount”

### <em>**Refactoring**</em>

- Reemplazar Temporal por Consulta => “each.getCharge()”

![claseCustomer](/out/docs/diagrams/src/movies5/movies.svg)

## <em>**Versión 6.**</em> Clase “Customer“ – Método “statement()“

### <em>**Smell Code:**</em>

- Método largo => más de 15 líneas

### <em>**Refactoring**</em>

- Extraer método => método “getFrequentRenterPoints()“ a clase “Rental”

## <em>**Versión 7.**</em> Clase “Customer“ – Método “statement()“

### <em>**Smell Code:**</em>

- Variable temporal innecesaria => “totalAmount”

### <em>**Refactoring**</em>

- Reemplazar Temporal por Consulta => “this.getTotalCharge()”

![claseCustomer](/out/docs/diagrams/src/movies7/movies.svg)


## <em>**Versión 8.**</em> Clase “Customer“ – Método “statement()“

### <em>**Smell Code:**</em>

- Variable temporal innecesaria => “frequentRenterPoints”

### <em>**Refactoring**</em>

- Reemplazar Temporal por Consulta =>  “this.getTotalFrequentRenterPoints()”

![claseCustomer](/out/docs/diagrams/src/movies8/movies.svg)


## <em>**Versión 9.**</em> Clase “Rental“ – Método “getCharge()“

### <em>**Smell Code:**</em>

- Experto en la Información => la mayor parte de la información es de Movie

### <em>**Refactoring**</em>

- Mover Método => método “getCharge()” a clase “Movie”

![claseCustomer](/out/docs/diagrams/src/movies9/movies.svg)

## <em>**Versión 10.**</em> Clase “Rental“ – Método “getFrequentRenterPoints()“

### <em>**Smell Code:*</em>

- Experto en la Información => la mayor parte de la información es de Movie

### <em>**Refactoring**</em>

- Mover Método => método “getFrequentRenterPoints()” a clase “Movie”

![claseCustomer](/out/docs/diagrams/src/movies10/movies.svg)


## <em>**Versión 11.**</em> Clase “Movie“ – Método “getCharge()“

### <em>**Smell Code:**</em>

- Sentencia Alternativa Múltiple => el comportamiento depende de un tipo/código/...

### <em>**Refactoring**</em>

- Reemplazar Código de Tipo con Estrategia/Estado (inyección de dependencias) => Auto-encapsular campo => “priceCode”

![claseCustomer](/out/docs/diagrams/src/movies11/movies.svg)


## <em>**Versión 12.**</em> Clase “Movie“ – Método “getCharge()“

### <em>**Smell Code:**</em>

- Sentencia Alternativa Múltiple => el comportamiento depende de un tipo/código/...

### <em>**Refactoring**</em>

- Reemplazar Código de Tipo con Estrategia/Estado (inyección de dependencias) => Añadir nuevas clases => “Price”, “ChildrenPrice”, ...

## <em>**Versión 13.**</em> Clase “Movie” - Atributo “priceCode”

### <em>**Smell Code:**</em>

- Sentencia Alternativa Múltiple => el comportamiento depende de un tipo/código/...

### <em>**Refactoring**</em>

- Reemplazar Código de Tipo con Estrategia/Estado (inyección de dependencias) => Sustituir atributo: “int priceCode” por “Price price”


![claseCustomer](/out/docs/diagrams/src/movies13/movies.svg)

## <em>**Versión 14.**</em> Clase “Movie” - método “getCharge()”

### <em>**Smell Code:**</em>

- Sentencia Alternativa Múltiple => el comportamiento depende de un tipo/código/...

### <em>**Refactoring**</em>

- Reemplazar Código de Tipo con Estrategia/Estado (inyección de dependencias) => Mover método: método “getCharge()” a  Clase “Price”

![claseCustomer](/out/docs/diagrams/src/movies14/movies.svg)


## <em>**Versión 15.**</em> Clase “Price” - método “getCharge()”

### <em>**Smell Code:**</em>

- Sentencia Alternativa Múltiple => el comportamiento depende de un tipo/código/...

### <em>**Refactoring**</em>

- Reemplazar Condicional con Polimorfismo => Redefinir método “getCharge()” en clases derivadas

![claseCustomer](/out/docs/diagrams/src/movies15/movies.svg)


## <em>**Versión 16.**</em> Clase “Price” - método “getFrequentRenterPoints()”

### <em>**Smell Code:**</em>

- Sentencia Alternativa Múltiple => el comportamiento depende de un tipo/código/...

### <em>**Refactoring**</em>

- Reemplazar Condicional con Polimorfismo => Redefinir método “getFrequentRenterPoints()” en clases derivadas

![claseCustomer](/out/docs/diagrams/src/movies16/movies.svg)

## <em>**Versión 17.**</em> Clase “CustomerTest” - métodos de prueba con Tipo/Código

### <em>**Smell Code:**</em>

- Sentencia Alternativa Múltiple => el comportamiento depende de un tipo/código/...

### <em>**Refactoring**</em>

- Ocultar campo: añadir métodos “childrens()”, “regular()” y “newRelease()” en clase “MovieBuilder

![claseCustomer](/out/docs/diagrams/src/movies17/movies.svg)

## <em>**Versión 18.**</em> Clase “CustomerTest” - métodos de prueba con Tipo/Código

### <em>**Smell Code:**</em>

- Sentencia Alternativa Múltiple => el comportamiento depende de un tipo/código/...

### <em>**Refactoring**</em>

-	Ocultar campo: desde “CustomerTest” llamar a métodos “childrens()”, “regular()” y “newRelease()” de clase “MovieBuilder”
-	Sustituir campo: atributo “priceCode” por “Price” en clase “MovieBuilder”
-	Sustituir campo: atributo “priceCode” por “Price” en clase “Movie”

## <em>**Versión 19.**</em> Clase “Price” - método “getPriceCode()”

### <em>**Smell Code:**</em>

- Sentencia Alternativa Múltiple => el comportamiento depende de un tipo/código/...

### <em>**Refactoring**</em>

- Eliminar método: “getPriceCode()” de clases “Price” y “Movie”

## <em>**Versión 20.**</em> Jerarquía “Price”

### <em>**Smell Code:**</em>

- Números mágilos => 2, 1.5, ...

### <em>**Refactoring**</em>

- Añadir atributo: “CHARGE”, “DAYS_RENTER_THRESHOLD”, ... en jerarquía “Price”

![claseCustomer](/out/docs/diagrams/src/movies20/movies.svg)

## <em>**Versión 21**</em>


![claseCustomer](/out/docs/diagrams/src/movies21/movies.svg)

## <em>**Versión 22.**</em> Clase “Customer” - métodos “statement()”, “getTotalCharge()”, “getTotalFrequentRenterPoints()”

### <em>**Smell Code:**</em>
- Duplicación de bucles al recorrer la lista `rentals`.
- Violación de DRY (Don’t Repeat Yourself) en cada método.
- Variable temporal innecesaria

### <em>**Refactoring:**</em>
- **Extract Method** : Se crea `summarizeRentals(...)` para unificar la lógica de iteración en metodos `statement()`,`getTotalCharge()` y `getTotalFrequentRenterPoints()`.
- Parametrización con una **función** (`BiFunction<T,Rental,T>`) que define el proceso específico (sumar cargos, puntos, etc.).
- Eliminar variables innecesarios y reemplazar while por for en `summarizeRentals(...)`

![claseCustomer](/out/docs/diagrams/src/movies22/movies.svg)

## <em>**Versión 23.**</em> Clase “Customer” - método “statement()” y Clase “Rental” - método “getTitle()”

### <em>**Smell Code:**</em>
- **Dependencia innecesaria** entre `Customer` y `Movie` (violación de la Ley de Demeter: `Customer -> Rental -> Movie`).
- **Acoplamiento excesivo**: el método `statement()` accedía al título de la película llamando a `getMovie().getTitle()`.

### <em>**Refactoring:**</em>
- **Encapsulate Field** & **Move Method**: Se introduce `Rental.getTitle()` para que `Customer` no necesite acceder directamente a `Movie`.
- **Eliminación de dependencia**: en `statement()`, se llama a `rental.getTitle()` en lugar de `rental.getMovie().getTitle()`.

![claseCustomer](/out/docs/diagrams/src/movies23/movies.svg)

## <em>**Versión 24.**</em> Clase “Movie“ y "Price"

### <em>**Smell Code:**</em>
- Clase `Movie` delega toda su lógica en `Price` y sus subclases (`RegularPrice`, `NewReleasePrice`, `ChildrenPrice`).
- Dificultad para extender o cambiar reglas: se debe modificar `Movie` (p. ej. setPrice) y crear/ajustar subclases de `Price`.

### <em>**Refactoring:**</em>
- **Inline Class** / “Collapse Hierarchy”:
  - Se crean subclases concretas de `Movie` (`RegularMovie`, `ChildrenMovie`, `NewReleaseMovie`) que contienen la lógica de `Price` y sus derivadas.
  - Se elimina por completo la clase `Price` y todas sus subclases.

![claseCustomer](/out/docs/diagrams/src/movies24/movies.svg)

## <em>**Versión 25.**</em> Clase “CustomerTest“


### <em>**Refactoring:**</em>
- Dividir CustomerTest en diferentes archivos de pruebas.

