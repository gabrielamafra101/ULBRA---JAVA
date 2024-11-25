import javax.swing.JOptionPane;

public class SistemaAvaliacao {

    public static void main(String[] args) {
        String nomeAluno = JOptionPane.showInputDialog("Digite o nome do aluno:");

        double notaProva1 = obterNota("primeira prova");
        double notaProva2 = obterNota("segunda prova");
        double notaTrabalho = obterNota("trabalho");

        double media = calcularMedia(notaProva1, notaProva2, notaTrabalho);
        String situacao = definirSituacao(media);

        String mensagem = String.format(
                "Aluno: %s%n" +
                "Média: %.2f%n" +
                "Situação: %s",
                nomeAluno, media, situacao
        );

        JOptionPane.showMessageDialog(null, mensagem, "Resultado da Avaliação", JOptionPane.INFORMATION_MESSAGE);
    }

    private static double obterNota(String tipoNota) {
        while (true) {
            try {
                String notaStr = JOptionPane.showInputDialog("Digite a nota da " + tipoNota + ":");
                double nota = Double.parseDouble(notaStr);
                if (nota >= 0 && nota <= 10) {
                    return nota;
                } else {
                    JOptionPane.showMessageDialog(null, "Nota inválida. Digite um valor entre 0 e 10.");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Digite apenas números.");
            }
        }
    }

    private static double calcularMedia(double nota1, double nota2, double nota3) {

        return (nota1 + nota2 + nota3) / 3;
    }

    private static String definirSituacao(double media) {
        return (media >= 6.0) ? "Aprovado" : "Reprovado";
    }
}