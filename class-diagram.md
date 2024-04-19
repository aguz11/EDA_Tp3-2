```mermaid
classDiagram
    class Pila~T~ {
        # protected pila: T[]
        # protected length: int
        # protected cursor: int

        + Pila(length: int)
        + toString() String

        + push(T elemento) void
        + pop() T
        + pilaVacia() boolean
        + pilaLlena() boolean
        + verElemento() T
        + invierteEficiente() Pila
        + invierteSimple() void

    }
    class PilaParentesis {
        - arrParentesis: Pila
        - esEquilibrada: Boolean
        - arrParentesis: Character[]
        - parentesis: static char[][enum P]

        + PilaParentesis(cadena: String)
        + toString() String
        + getParentesis(cadena: String) static Character[]
        + esEquilibrada() Boolean
        - esParenApertura() Boolean
        - esParenCierre() Boolean
        - getParenApertura() Character
    }
     class P {
        <<Enumeration>>
        // Apertura y cierre
        // de los paréntesis
        OPEN
        CLOSE
    }

    class UnirPilasOrdenadas {
        + combinarPilas(pila1: Pila, pila2: Pila)static Pila

    }
    class Test {

    }

    PilaParentesis --> Pila
    PilaParentesis --> P
    UnirPilasOrdenadas --> Pila
    Test ..> PilaParentesis
    Test ..> UnirPilasOrdenadas

```
