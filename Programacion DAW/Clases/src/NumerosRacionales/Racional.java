package NumerosRacionales;

public class Racional {
    private int numerador;
    private int denominador;

    // Constructor
    public Racional(int numerador, int denominador) {
        if (denominador == 0) {
            throw new IllegalArgumentException("El denominador no puede ser cero.");
        }
        this.numerador = numerador;
        this.denominador = denominador;
        simplificar();
    }

    // Setters
    public void asignaNumerador(int x) {
        this.numerador = x;
        simplificar();
    }

    public void asignaDenominador(int y) {
        if (y == 0) {
            throw new IllegalArgumentException("El denominador no puede ser cero.");
        }
        this.denominador = y;
        simplificar();
    }

    // Imprimir racional
    public void imprimirRacional() {
        System.out.println(numerador + "/" + denominador);
    }

    // Suma
    public Racional sumar(Racional otro) {
        int nuevoNumerador = this.numerador * otro.denominador + otro.numerador * this.denominador;
        int nuevoDenominador = this.denominador * otro.denominador;
        return new Racional(nuevoNumerador, nuevoDenominador);
    }

    // Resta
    public Racional restar(Racional otro) {
        int nuevoNumerador = this.numerador * otro.denominador - otro.numerador * this.denominador;
        int nuevoDenominador = this.denominador * otro.denominador;
        return new Racional(nuevoNumerador, nuevoDenominador);
    }

    // Producto
    public Racional multiplicar(Racional otro) {
        int nuevoNumerador = this.numerador * otro.numerador;
        int nuevoDenominador = this.denominador * otro.denominador;
        return new Racional(nuevoNumerador, nuevoDenominador);
    }

    // División
    public Racional dividir(Racional otro) {
        if (otro.numerador == 0) {
            throw new ArithmeticException("No se puede dividir por cero.");
        }
        int nuevoNumerador = this.numerador * otro.denominador;
        int nuevoDenominador = this.denominador * otro.numerador;
        return new Racional(nuevoNumerador, nuevoDenominador);
    }

    // Comparar igualdad
    public boolean esIgual(Racional otro) {
        return this.numerador * otro.denominador == this.denominador * otro.numerador;
    }

    // Simplificar fracción usando máximo común divisor
    private void simplificar() {
        int gcd = mcd(Math.abs(numerador), Math.abs(denominador));
        numerador /= gcd;
        denominador /= gcd;

        // Asegurar que el denominador sea positivo
        if (denominador < 0) {
            numerador = -numerador;
            denominador = -denominador;
        }
    }

    // Método para calcular el MCD
    private int mcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}

