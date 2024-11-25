import java.util.Scanner;

public class CalculadoraDesconto {

    public static void main(String[] args) {
    
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o preço original: R$ ");
        double valorProduto = scanner.nextDouble();
        System.out.print("Digite a % do desconto: ");
        double percentualDesconto = scanner.nextDouble();
        double valorDesconto = (valorProduto * percentualDesconto) / 100;
        double precoFinal = valorProduto - valorDesconto;
        System.out.printf("Valor do desconto: R$ %.2f%n", valorDesconto);
        System.out.printf("Preço com desconto: R$ %.2f%n", precoFinal);
        scanner.close();
    }
}
