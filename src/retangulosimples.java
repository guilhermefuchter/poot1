interface Retangulo {
    void desenhar();
}

class RetanguloSimples implements Retangulo {
    private int largura;
    private int altura;

    public RetanguloSimples(int largura, int altura) {
        this.largura = largura;
        this.altura = altura;
    }

    @Override
    public void desenhar() {
        for (int i = 0; i < altura; i++) {
            for (int j = 0; j < largura; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}

