import javax.swing.JOptionPane;

public class CircuitoResistencias {

    public static void main(String[] args) {
        double[] resistencias = new double[4];
        for (int i = 0; i < resistencias.length; i++) {
            resistencias[i] = obterResistencia(i + 1);
        }
        double resistenciaEquivalente = calcularResistenciaEquivalente(resistencias);
        double maiorResistencia = encontrarMaiorResistencia(resistencias);
        double menorResistencia = encontrarMenorResistencia(resistencias);
        String mensagem = String.format(
            "Resistência Equivalente: %.2f Ω%n" +
            "Maior Resistência: %.2f Ω%n" +
            "Menor Resistência: %.2f Ω",
            resistenciaEquivalente, maiorResistencia, menorResistencia
        );
        JOptionPane.showMessageDialog(null, mensagem, "Resultados do Circuito", JOptionPane.INFORMATION_MESSAGE);
    }
    private static double obterResistencia(int numero) {
        while (true) {
            try {
                String resistenciaStr = JOptionPane.showInputDialog("Digite o valor da resistência " + numero + " (em Ω):");
                double resistencia = Double.parseDouble(resistenciaStr);
                if (resistencia > 0) {
                    return resistencia;
                } else {
                    JOptionPane.showMessageDialog(null, "Valor inválido. A resistência deve ser positiva.");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Digite um valor numérico válido.");
            }
        }
    }
    private static double calcularResistenciaEquivalente(double[] resistencias) {
        double soma = 0;
        for (double r : resistencias) {
            soma += r;
        }
        return soma;
    }
    private static double encontrarMaiorResistencia(double[] resistencias) {
        double maior = resistencias[0];
        for (double r : resistencias) {
            if (r > maior) {
                maior = r;
            }
        }
        return maior;
    }
    private static double encontrarMenorResistencia(double[] resistencias) {
        double menor = resistencias[0];
        for (double r : resistencias) {
            if (r < menor) {
                menor = r;
            }
        }
        return menor;
    }
}
