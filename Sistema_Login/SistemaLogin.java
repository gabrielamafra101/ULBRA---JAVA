import javax.swing.JOptionPane;

public class SistemaLogin {

    public static void main(String[] args) {
        final String USUARIO_CORRETO = "GAB";
        final String SENHA_CORRETA = "1234";
        int tentativasRestantes = 3;
        while (tentativasRestantes > 0) {
            String usuario = JOptionPane.showInputDialog("Digite seu usuário:");
            String senha = JOptionPane.showInputDialog("Digite sua senha:");
            if (USUARIO_CORRETO.equals(usuario) && SENHA_CORRETA.equals(senha)) {
                JOptionPane.showMessageDialog(null, "Login bem-sucedido! Bem-vindo ao sistema.", 
                    "Acesso Permitido", JOptionPane.INFORMATION_MESSAGE);
                return;
            } else {
                tentativasRestantes--;
                if (tentativasRestantes > 0) {
                    JOptionPane.showMessageDialog(null, 
                        "Usuário ou senha incorretos. Você tem " + tentativasRestantes + " tentativa(s) restante(s).",
                        "Erro de Login", JOptionPane.ERROR_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, 
                        "Número máximo de tentativas excedido. Acesso negado.",
                        "Erro de Login", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
        System.exit(0);
    }
}
