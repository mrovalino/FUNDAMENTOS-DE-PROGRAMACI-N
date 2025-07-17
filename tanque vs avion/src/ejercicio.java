import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import java.util.Scanner;

public class ejercicio extends JPanel {
    private final int ANCHO = 800;
    private final int ALTURA = 600;
    private final int TANQUEX = 50;
    private final int TANQUEY = ALTURA - 50;

    private int avionX, avionY;
    private double disparoX, disparoY;
    private boolean disparando = false;
    private boolean juegoTerminado = false;
    private double anguloActual = 0;
    public ejercicio() {
        setPreferredSize(new Dimension(ANCHO, ALTURA));
        setBackground(Color.CYAN);
        colocarAvion();
    }
    private void colocarAvion() {
        Random rand = new Random();
        avionX = rand.nextInt(400, ANCHO - 50);
        avionY = rand.nextInt(50, 250);
        System.out.println("\n *Necesitamos que derive el avion enemigo*");
    }
    public void disparar(double angulo) {
        disparando = true;
        anguloActual = angulo;
        double rad = Math.toRadians(angulo);
        disparoX = TANQUEX;
        disparoY = TANQUEY;
        Timer timer = new Timer(20, null);
        timer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                disparoX += 10 * Math.cos(rad);
                disparoY -= 10 * Math.sin(rad);
                double distancia = Math.sqrt(Math.pow(disparoX - avionX, 2) + Math.pow(disparoY - avionY, 2));
                if (distancia < 20) {
                    juegoTerminado = true;
                    disparando = false;
                    repaint();
                    ((Timer) e.getSource()).stop();
                    System.out.println("*Acertaste! El avión fue derribado.*");
                    System.exit(0);
                }
                if (disparoX > ANCHO || disparoY > ALTURA || disparoX < 0 || disparoY < 0) {
                    ((Timer) e.getSource()).stop();
                    disparando = false;
                    repaint();
                    System.out.println("Fallaste. :(  El avión estaba en (" + avionX + ", " + avionY + ").");
                    Scanner scanner = new Scanner(System.in);
                    System.out.print("¿Quieres intentar de nuevo? (si o no)?: ");
                    String respuesta = scanner.nextLine();
                    if (respuesta.equalsIgnoreCase("s")) {
                        colocarAvion();
                        pedirAngulo();
                    } else {
                        System.out.println("Gracias por jugar. Me avisas si quieres volver a jugar");
                        System.exit(0);
                    }
                }
                repaint();
            }
        });
        timer.start();
    }
    public void pedirAngulo() {
        Scanner scanner = new Scanner(System.in);
        System.out.print(" *Ingresa un ángulo de disparo (0-90 grados): ");
        try {
            double angulo = Double.parseDouble(scanner.nextLine());
            if (angulo < 0 || angulo > 90) {
                System.out.println("*Ángulo inválido. Debe ser entre 0 y 90.");
                pedirAngulo();
            } else {
                System.out.println("*Disparando a " + angulo + "°...");
                disparar(angulo);
            }
        } catch (Exception e) {
            System.out.println("Entrada inválida. Intenta de nuevo.");
            pedirAngulo();
        }
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.DARK_GRAY);
        g.fillRect(TANQUEX - 10, TANQUEY - 20, 40, 20);
        g.setColor(Color.BLACK);
        g.fillRect(TANQUEX + 10, TANQUEY - 30, 20, 10); 
        g.setColor(Color.RED);
        g.fillOval(avionX - 15, avionY - 10, 40, 20);

        if (disparando) {
            double rad = Math.toRadians(anguloActual);
            int endX = (int) (TANQUEX + 1000 * Math.cos(rad));
            int endY = (int) (TANQUEY - 1000 * Math.sin(rad));

            g.setColor(Color.BLACK);
            g.drawLine(TANQUEX + 20, TANQUEY - 25, endX, endY); 
        }      
    }
    public static void main(String[] args) {
        JFrame ventana = new JFrame("*Disparo con línea*");
        ejercicio juego = new ejercicio();
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.getContentPane().add(juego);
        ventana.pack();
        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true);
        System.out.println("------------------------------------");
        System.out.println("-------BIENVENIDO A MI JUEGO--------");
        System.out.println("------------------------------------");
        System.out.println("*Tu tanque está en la esquina inferior izquierda.*");
        System.out.println("*Un avión aparecerá en el cielo. *Derríbalo ingresando un ángulo*");
        System.out.println("*El disparo se muestra como una línea recta en la ventana gráfica.*\n");
        SwingUtilities.invokeLater(() -> juego.pedirAngulo());
    }
}
