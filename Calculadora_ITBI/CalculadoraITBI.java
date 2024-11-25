import javax.swing.JOptionPane;

public class CalculadoraITBI {

    public static void main(String[] args) {
        String valorTransacaoStr = JOptionPane.showInputDialog("Digite o valor de transação do imóvel (R$):");
        double valorTransacao = Double.parseDouble(valorTransacaoStr);
        String valorVenalStr = JOptionPane.showInputDialog("Digite o valor venal do imóvel (R$):");
        double valorVenal = Double.parseDouble(valorVenalStr);
        String porcentagemImpostoStr = JOptionPane.showInputDialog("Digite a porcentagem do imposto ITBI (%):");
        double porcentagemImposto = Double.parseDouble(porcentagemImpostoStr);
        double maiorValor = Math.max(valorTransacao, valorVenal);
        double valorImposto = (maiorValor * porcentagemImposto) / 100;
        String mensagem = String.format(
            "Maior valor considerado: R$ %.2f%n" +
            "Valor do imposto ITBI: R$ %.2f",
            maiorValor, valorImposto
        );
        JOptionPane.showMessageDialog(null, mensagem, "Cálculo do ITBI", JOptionPane.INFORMATION_MESSAGE);
    }
}
