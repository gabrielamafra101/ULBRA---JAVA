import javax.swing.JOptionPane;

public class GeradorTabuada {

    public static void main(String[] args) {
        int numero = obterNumero();
        StringBuilder resultado = new StringBuilder();
        resultado.append("Tabuada do número ").append(numero).append(":\n");
        for (int i = 1; i <= 10; i++) {
            resultado.append(numero).append(" x ").append(i).append(" = ").append(numero * i).append("\n");
        }
        JOptionPane.showMessageDialog(null, resultado.toString(), "Gerador de Tabuada", JOptionPane.INFORMATION_MESSAGE);
    }
    private static int obterNumero() {
        while (true) {
            try {
                String input = JOptionPane.showInputDialog("Digite um número para gerar a tabuada:");
                int numero = Integer.parseInt(input);
                return numero;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Por favor, digite um número válido.", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
