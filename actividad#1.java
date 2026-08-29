import java.util.ArrayList;
import java.util.Random;

public class TallerPOO {

    public static void main(String[] args) {
        System.out.println("=== EJECUTANDO EJERCICIO 1 ===");
        ejecutarEjercicio1();
        
        System.out.println("\n=== EJECUTANDO EJERCICIO 2 ===");
        ejecutarEjercicio2();
        
        System.out.println("\n=== EJECUTANDO EJERCICIO 3 ===");
        ejecutarEjercicio3();
    }

    // ----------------------------------------------------------
    // INICIO - EJERCICIO 1: Clase Persona y validación de mayoría de edad
    // ----------------------------------------------------------
    
    public static class Persona {
        private String nombre;
        private int edad;
        private String documento;

        // 1. Constructor para inicializar los tres atributos
        public Persona(String nombre, int edad, String documento) {
            this.nombre = nombre;
            this.edad = edad;
            this.documento = documento;
        }

        // 2. Métodos get y set
        public String getNombre() { return nombre; }
        public void setNombre(String nombre) { this.nombre = nombre; }

        public int getEdad() { return edad; }
        public void setEdad(int edad) { this.edad = edad; }

        public String getDocumento() { return documento; }
        public void setDocumento(String documento) { this.documento = documento; }

        // 3. Método mostrarInformacion()
        public void mostrarInformacion() {
            System.out.println("Documento: " + documento + " | Nombre: " + nombre + " | Edad: " + edad);
        }

        // 4. Método esMayorDeEdad()
        public void esMayorDeEdad() {
            if (this.edad > 18) {
                System.out.println("Nombre: " + this.nombre + " Es mayor de edad");
            } else {
                System.out.println("Nombre: " + this.nombre + " No es mayor de edad");
            }
        }
    }

    public static void ejecutarEjercicio1() {
        ArrayList<Persona> listaPersonas = new ArrayList<>();
        String[] nombresEjemplo = {"Ana", "Carlos", "Beatriz", "David", "Elena", "Fernando", "Gloria", "Héctor", "Inés", "Javier"};
        Random random = new Random();

        // Creación de al menos 10 elementos aleatorios
        for (int i = 0; i < 10; i++) {
            String nombre = nombresEjemplo[random.nextInt(nombresEjemplo.length)];
            int edad = random.nextInt(40) + 10; // Edades aleatorias entre 10 y 49 años
            String documento = "100" + random.nextInt(900000);
            listaPersonas.add(new Persona(nombre, edad, documento));
        }

        // Recorrido del ArrayList
        for (Persona p : listaPersonas) {
            p.mostrarInformacion();
            p.esMayorDeEdad();
            System.out.println("--------------------------------");
        }
    }
    
    // ----------------------------------------------------------
    // FIN - EJERCICIO 1
    // ----------------------------------------------------------

    // ----------------------------------------------------------
    // INICIO - EJERCICIO 2: Sistema de empleados (Herencia y Polimorfismo)
    // ----------------------------------------------------------
    
    public static class Empleado {
        protected String nombre;
        protected double salario;

        public Empleado(String nombre, double salario) {
            this.nombre = nombre;
            this.salario = salario;
        }

        public String getNombre() { return nombre; }
        public double getSalario() { return salario; }
    }

    // Clase Hija 1: EmpleadoTiempoCompleto
    public static class EmpleadoTiempoCompleto extends Empleado {
        private long bonificacion;

        public EmpleadoTiempoCompleto(String nombre, double salario, long bonificacion) {
            super(nombre, salario);
            this.bonificacion = bonificacion;
        }

        public double calcularSalario() {
            return this.salario + this.bonificacion;
        }

        public long getBonificacion() { return bonificacion; }
    }

    // Clase Hija 2: EmpleadoPorHoras
    public static class EmpleadoPorHoras extends Empleado {
        private int horasTrabajadas;
        private double valorHora;

        public EmpleadoPorHoras(String nombre, double salarioBase, int horasTrabajadas, double valorHora) {
            super(nombre, salarioBase);
            this.horasTrabajadas = horasTrabajadas;
            this.valorHora = valorHora;
        }

        public double calcularSalario() {
            return this.horasTrabajadas * this.valorHora;
        }

        public int getHorasTrabajadas() { return horasTrabajadas; }
        public double getValorHora() { return valorHora; }
    }

    public static void ejecutarEjercicio2() {
        ArrayList<Empleado> listaEmpleados = new ArrayList<>();
        Random random = new Random();
        String[] nombres = {"Pepito Perez", "Maria Gomez", "Juan Rodriguez", "Lucia Fernandez", "Carlos Ruiz"};

        // Creación de al menos 10 empleados aleatorios
        for (int i = 0; i < 10; i++) {
            String nombre = nombres[random.nextInt(nombres.length)];
            if (i % 2 == 0) {
                listaEmpleados.add(new EmpleadoTiempoCompleto(nombre, 1000000, 200000));
            } else {
                int horas = random.nextInt(30) + 10; // Horas entre 10 y 39
                listaEmpleados.add(new EmpleadoPorHoras(nombre, 0, horas, 60000));
            }
        }

        // Recorrido y visualización de salarios
        int contador = 1;
        for (Empleado emp : listaEmpleados) {
            if (emp instanceof EmpleadoTiempoCompleto) {
                EmpleadoTiempoCompleto etc = (EmpleadoTiempoCompleto) emp;
                System.out.println("Empleado " + contador + ": \"" + etc.getNombre() + "\", Salario Actual: \"" + etc.calcularSalario() + "\", Bonificación: " + etc.getBonificacion());
            } else if (emp instanceof EmpleadoPorHoras) {
                EmpleadoPorHoras eph = (EmpleadoPorHoras) emp;
                System.out.println("Empleado " + contador + ": \"" + eph.getNombre() + "\", Salario Actual: \"" + eph.calcularSalario() + "\", Cantidad horas trabajadas: " + eph.getHorasTrabajadas() + ". Valor de la hora: " + eph.getValorHora());
            }
            contador++;
        }
    }
    
    // ----------------------------------------------------------
    // FIN - EJERCICIO 2
    // ----------------------------------------------------------

    // ----------------------------------------------------------
    // INICIO - EJERCICIO 3: Paso de variables por métodos (Calculadora)
    // ----------------------------------------------------------
    
    public static class Calculadora {
        
        public double sumar(double a, double b) {
            return a + b;
        }

        public double restar(double a, double b) {
            return a - b;
        }

        public double multiplicar(double a, double b) {
            return a * b;
        }

        public double dividir(double a, double b) {
            if (b == 0) {
                System.out.println("Error: División por cero.");
                return 0;
            }
            return a / b;
        }

        public void mostrarResultado(String operacion, double resultado) {
            System.out.println("Operación: " + operacion + " | Resultado: " + resultado);
        }
    }

    public static void ejecutarEjercicio3() {
        Calculadora calculadora = new Calculadora();
        
        double num1 = 20;
        double num2 = 30;

        // Realización de las cuatro operaciones y uso de mostrarResultado
        double resultadoSuma = calculadora.sumar(num1, num2);
        calculadora.mostrarResultado("Suma", resultadoSuma);

        double resultadoResta = calculadora.restar(num1, num2);
        calculadora.mostrarResultado("Resta", resultadoResta);

        double resultadoMultiplicacion = calculadora.multiplicar(num1, num2);
        calculadora.mostrarResultado("Multiplicación", resultadoMultiplicacion);

        double resultadoDivision = calculadora.dividir(num1, num2);
        calculadora.mostrarResultado("División", resultadoDivision);
    }
    
    // ----------------------------------------------------------
    // FIN - EJERCICIO 3
    // ----------------------------------------------------------
}