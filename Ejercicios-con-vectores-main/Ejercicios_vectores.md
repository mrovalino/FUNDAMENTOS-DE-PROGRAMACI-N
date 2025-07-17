# Ejercicios-con-vectores
lass Ejercicio1 {
 public static double[] sumarVectores(double[] v1, double[] v2) {
        double[] resultado = new double[2];
        resultado[0] = v1[0] + v2[0]; 
        resultado[1] = v1[1] + v2[1]; 
        return resultado;
    }

    public static void main(String[] args) {
        double[] vectorA = {3, 4};
        double[] vectorB = {1, -2};
        double[] suma = sumarVectores(vectorA, vectorB);
        
        System.out.println("Resultado: (" + suma[0] + ", " + suma[1] + ")");
    }
}
class Ejercicio2 {
    public static double magnitud(double[] vector) {
        return Math.sqrt(vector[0] * vector[0] + vector[1] * vector[1]);
    }

    public static void main(String[] args) {
        double[] v = {6, 8};
        System.out.println("Magnitud: " + magnitud(v));
    }
}
class Ejercicio3 {
 public static double productoEscalar(double[] v1, double[] v2) {
        return v1[0] * v2[0] + v1[1] * v2[1];
    }

    public static void main(String[] args) {
        double[] a = {2, 3};
        double[] b = {4, -1};
        System.out.println("Producto escalar: " + productoEscalar(a, b));
    }
}
class Ejercicio4 {
  public static double productoEscalar(double[] v1, double[] v2) {
        return v1[0] * v2[0] + v1[1] * v2[1];
    }

    public static double magnitud(double[] v) {
        return Math.sqrt(v[0] * v[0] + v[1] * v[1]);
    }

    public static double anguloEntreVectores(double[] v1, double[] v2) {
        double dot = productoEscalar(v1, v2);
        double mags = magnitud(v1) * magnitud(v2);
        return Math.toDegrees(Math.acos(dot / mags));
    }

    public static void main(String[] args) {
        double[] a = {1, 0};
        double[] b = {0, 1};
        System.out.println("Ángulo: " + anguloEntreVectores(a, b));
    }
}
class Ejercicio5 {
public static double[] descomponerVector(double magnitud, double anguloGrados) {
        double anguloRadianes = Math.toRadians(anguloGrados);
        double x = magnitud * Math.cos(anguloRadianes);
        double y = magnitud * Math.sin(anguloRadianes);
        return new double[]{x, y};
    }

    public static void main(String[] args) {
        double magnitud = 10;
        double angulo = 30; 
        double[] vector = descomponerVector(magnitud, angulo);
        System.out.println("Vector descompuesto: (" + vector[0] + ", " + vector[1] + ")");
    }
}
class Ejercicio6 {
    public static double distancia(double[] a, double[] b) {
        return Math.sqrt(Math.pow(b[0] - a[0], 2) + Math.pow(b[1] - a[1], 2));
    }

    public static void main(String[] args) {
        double[] p1 = {1, 2};
        double[] p2 = {4, 6};
        System.out.println("Distancia: " + distancia(p1, p2));
    }
}
class Ejercicio7 {
 public static double productoEscalar(double[] v1, double[] v2) {
        return v1[0] * v2[0] + v1[1] * v2[1];
    }

    public static boolean sonOrtogonales(double[] a, double[] b) {
        return productoEscalar(a, b) == 0;
    }

    public static void main(String[] args) {
        double[] a = {1, 0};
        double[] b = {0, 1};
        System.out.println("¿Ortogonales? " + sonOrtogonales(a, b));
    }
}
class Ejercicio8 {
   public static double[] rotar(double[] v, double grados) {
        double rad = Math.toRadians(grados);
        double x = v[0] * Math.cos(rad) - v[1] * Math.sin(rad);
        double y = v[0] * Math.sin(rad) + v[1] * Math.cos(rad);
        return new double[]{x, y};
    }

    public static void main(String[] args) {
        double[] v = {1, 0};
        double[] rotado = rotar(v, 90);
        System.out.println("Vector rotado: (" + rotado[0] + ", " + rotado[1] + ")");
    }
}
class Ejercicio9 {
public static double magnitud(double[] v) {
        return Math.sqrt(v[0] * v[0] + v[1] * v[1]);
    }

    public static double[] normalizar(double[] v) {
        double mag = magnitud(v);
        return new double[]{v[0] / mag, v[1] / mag};
    }

    public static void main(String[] args) {
        double[] v = {3, 4};
        double[] unitario = normalizar(v);
        System.out.println("Vector unitario: (" + unitario[0] + ", " + unitario[1] + ")");
    }
}
class Ejercicio10 {
 public static double[] polarACartesiano(double magnitud, double angulo) {
        double x = magnitud * Math.cos(Math.toRadians(angulo));
        double y = magnitud * Math.sin(Math.toRadians(angulo));
        return new double[]{x, y};
    }

    public static void main(String[] args) {
        double[] v = polarACartesiano(5, 45);
        System.out.println("Vector cartesiano: (" + v[0] + ", " + v[1] + ")");
    }
}
class Ejercicio11 {
 public static double productoEscalar(double[] a, double[] b) {
        return a[0] * b[0] + a[1] * b[1];
    }

    public static double[] escalarVector(double[] v, double escalar) {
        return new double[]{v[0] * escalar, v[1] * escalar};
    }

    public static double[] proyectar(double[] a, double[] b) {
        double factor = productoEscalar(a, b) / productoEscalar(b, b);
        return escalarVector(b, factor);
    }

    public static void main(String[] args) {
        double[] a = {3, 4};
        double[] b = {1, 0};
        double[] proyeccion = proyectar(a, b);
        System.out.println("Proyección: (" + proyeccion[0] + ", " + proyeccion[1] + ")");
    }
}
class Ejercicio12 {
   public static double[] interpolar(double[] a, double[] b, double t) {
        double x = a[0] + t * (b[0] - a[0]);
        double y = a[1] + t * (b[1] - a[1]);
        return new double[] { x, y };
    }

    public static void main(String[] args) {
        double[] a = { 0, 0 };
        double[] b = { 10, 10 };
        double[] medio = interpolar(a, b, 0.5);
        System.out.println("Interpolación (t=0.5): (" + medio[0] + ", " + medio[1] + ")");
    }
}
class Ejercicio13 {
  public static double[] interpolar(double[] a, double[] b, double t) {
        double x = a[0] + t * (b[0] - a[0]);
        double y = a[1] + t * (b[1] - a[1]);
        return new double[]{x, y};
    }

    public static void main(String[] args) {
        double[] a = {0, 0};
        double[] b = {10, 10};
        double[] medio = interpolar(a, b, 0.5);
        System.out.println("Interpolación (t=0.5): (" + medio[0] + ", " + medio[1] + ")");
    }
}
class Ejercicio14 {
    public static double[] perpendicular(double[] v) {
        return new double[]{-v[1], v[0]};
    }

    public static void main(String[] args) {
        double[] v = {2, 3};
        double[] p = perpendicular(v);
        System.out.println("Perpendicular: (" + p[0] + ", " + p[1] + ")");
    }
}
class Ejercicio15 {
 public static boolean esRectangulo(double[] a, double[] b, double[] c) {
        double ab2 = Math.pow(b[0] - a[0], 2) + Math.pow(b[1] - a[1], 2);
        double bc2 = Math.pow(c[0] - b[0], 2) + Math.pow(c[1] - b[1], 2);
        double ca2 = Math.pow(a[0] - c[0], 2) + Math.pow(a[1] - c[1], 2);

        return (Math.abs(ab2 + bc2 - ca2) < 1e-9) ||
               (Math.abs(ab2 + ca2 - bc2) < 1e-9) ||
               (Math.abs(bc2 + ca2 - ab2) < 1e-9);
    }

    public static void main(String[] args) {
        double[] a = {0, 0};
        double[] b = {3, 0};
        double[] c = {0, 4};
        System.out.println("¿Triángulo rectángulo? " + esRectangulo(a, b, c));
    }
}
class Ejercicio16 {
     public static double[] suma(double[] a, double[] b) {
        return new double[]{a[0] + b[0], a[1] + b[1]};
    }

    public static void main(String[] args) {
        double[][] vectores = {
            {1, 2},
            {3, 4},
            {-1, 1}
        };

        double[] suma = {0, 0};
        for (double[] v : vectores) {
            suma = suma(suma, v);
        }

        System.out.println("Suma acumulada: (" + suma[0] + ", " + suma[1] + ")");
    }
}
class Ejercicio17 {
 public static double dot(double[] a, double[] b) {
        return a[0] * b[0] + a[1] * b[1];
    }

  
    public static boolean sonOrtogonales(double[] a, double[] b) {
        return dot(a, b) == 0;
    }

    public static void main(String[] args) {
        double[] a = {1, 0};
        double[] b = {0, 2};
        System.out.println("¿Ortogonales? " + sonOrtogonales(a, b));
    }
}
class Ejercicio18 {
    
    public static double[] invertir(double[] v) {
        return new double[]{-v[0], -v[1]};
    }

    public static void main(String[] args) {
        double[] v = {5, -3};
        double[] invertido = invertir(v);
        System.out.println("Invertido: (" + invertido[0] + ", " + invertido[1] + ")");
    }
}
class Ejercicio19 {
   public static String vectorToString(double[] v) {
        return "(" + v[0] + ", " + v[1] + ")";
    }

    public static void main(String[] args) {
        double[] v = {3.5, 4.2};
        System.out.println("Vector como cadena: " + vectorToString(v));
    }
}
class Ejercicio20 {
public static double[] promedio(double[][] vectores) {
        double sumX = 0, sumY = 0;
        for (double[] v : vectores) {
            sumX += v[0];
            sumY += v[1];
        }
        return new double[] { sumX / vectores.length, sumY / vectores.length };
    }

    public static void main(String[] args) {
        double[][] vectores = {
            {2, 4},
            {4, 6},
            {6, 8}
        };
        double[] prom = promedio(vectores);
        System.out.println("Promedio: (" + prom[0] + ", " + prom[1] + ")");
    }
}
Ejercicios adicionales
Asunto: Inconveniente al subir los códigos a la plataforma

Estimado Ingeniero:

Me permito informarle que tuve un inconveniente técnico al momento de subir los códigos a la plataforma. Al intentar cargar los archivos, la ruta se desapareció inesperadamente y los archivos se subieron vacíos.

Sin embargo, deseo dejar constancia de que la tarea fue realizada correctamente. Como respaldo, he subido todos los códigos (del 1 al 20) en mi repositorio de GitHub, el cual puede revisar en el siguiente enlace:
(https://github.com/mrovalino/Ejercicios-con-vectores.git)

Agradezco su comprensión y quedo atento/a a cualquier indicación adicional que deba seguir.

Saludos cordiales,
Mateo Rovalino
1850402791
