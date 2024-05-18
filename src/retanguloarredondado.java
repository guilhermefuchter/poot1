interface Retanguloarredondado {
    void desenhar();
}


class RetanguloBordaArredondada implements Retangulo {
    private int largura;
    private int altura;

    public RetanguloBordaArredondada(int largura, int altura) {
        this.largura = largura;
        this.altura = altura;
    }

    @Override
    public void desenhar() {
        System.out.println("╭" + "─".repeat(largura - 2) + "╮");
        for (int i = 0; i < altura - 2; i++) {
            System.out.println("│" + " ".repeat(largura - 2) + "│");
        }
        System.out.println("╰" + "─".repeat(largura - 2) + "╯");
    }
}
