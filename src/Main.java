public class Main {
    public static void main(String[] args) {
        Funcionario funcionarioComum = new Funcionario("João", 10.0f, 160);
        Lider lider = new Lider("Maria", 10.0f, 160);
        Gerente gerente = new Gerente("Pedro", 10.0f, 160);

        System.out.println("Salário do funcionário comum: " + funcionarioComum.calcularSalario());
        System.out.println("Salário do líder: " + lider.calcularSalario());
        System.out.println("Salário do gerente: " + gerente.calcularSalario());

        Retangulo retanguloSimples = new RetanguloSimples(5, 3);
        System.out.println("Retângulo simples:");
        retanguloSimples.desenhar();

        Retangulo retanguloBordaArredondada = new RetanguloBordaArredondada(5, 3);
        System.out.println("\nRetângulo com borda arredondada:");
        retanguloBordaArredondada.desenhar();
    }
}