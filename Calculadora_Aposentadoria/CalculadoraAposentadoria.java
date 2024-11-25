import javax.swing.JOptionPane;

public class CalculadoraAposentadoria {

    public static void main(String[] args) {

        int idade = obterIdade();
        String sexo = obterSexo();
        int anosContribuicao = obterAnosContribuicao();
        int idadeMinima = calcularIdadeMinima(sexo);
        int contribuicaoMinima = calcularContribuicaoMinima(sexo);
        boolean podeAposentar = verificarAposentadoria(idade, anosContribuicao, idadeMinima, contribuicaoMinima);
        exibirResultado(podeAposentar, idade, anosContribuicao, idadeMinima, contribuicaoMinima);
    }

    private static int obterIdade() {
        while (true) {
            try {
                String idadeStr = JOptionPane.showInputDialog("Digite sua idade:");
                int idade = Integer.parseInt(idadeStr);
                if (idade > 0) {
                    return idade;
                } else {
                    JOptionPane.showMessageDialog(null, "Idade inválida. Digite um valor positivo.");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Digite apenas números.");
            }
        }
    }

    private static String obterSexo() {
        while (true) {
            String sexo = JOptionPane.showInputDialog("Digite seu sexo (M para masculino, F para feminino):").toUpperCase();
            if (sexo.equals("M") || sexo.equals("F")) {
                return sexo;
            } else {
                JOptionPane.showMessageDialog(null, "Sexo inválido. Digite 'M' ou 'F'.");
            }
        }
    }


    private static int obterAnosContribuicao() {
        while (true) {
            try {
                String contribuicaoStr = JOptionPane.showInputDialog("Digite seus anos de contribuição:");
                int anosContribuicao = Integer.parseInt(contribuicaoStr);
                if (anosContribuicao >= 0) {
                    return anosContribuicao;
                } else {
                    JOptionPane.showMessageDialog(null, "Anos de contribuição inválidos. Digite um valor positivo ou zero.");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Digite apenas números.");
            }
        }
    }


    private static int calcularIdadeMinima(String sexo) {
        return (sexo.equals("M")) ? 65 : 62; 
    }

    // Método para calcular o tempo de contribuição mínima
    private static int calcularContribuicaoMinima(String sexo) {
        return (sexo.equals("M")) ? 20 : 15;
    }


    private static boolean verificarAposentadoria(int idade, int anosContribuicao, int idadeMinima, int contribuicaoMinima) {
        return idade >= idadeMinima && anosContribuicao >= contribuicaoMinima;
    }


    private static void exibirResultado(boolean podeAposentar, int idade, int anosContribuicao, int idadeMinima, int contribuicaoMinima) {
        if (podeAposentar) {
            JOptionPane.showMessageDialog(null, "Parabéns! Você já pode se aposentar.", "Resultado", JOptionPane.INFORMATION_MESSAGE);
        } else {
            int anosFaltandoIdade = Math.max(0, idadeMinima - idade);
            int anosFaltandoContribuicao = Math.max(0, contribuicaoMinima - anosContribuicao);

            String mensagem = String.format(
                "Você ainda não pode se aposentar.%n" +
                "Faltam %d anos para atingir a idade mínima.%n" +
                "Faltam %d anos para atingir o tempo de contribuição mínimo.",
                anosFaltandoIdade, anosFaltandoContribuicao
            );

            JOptionPane.showMessageDialog(null, mensagem, "Resultado", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
