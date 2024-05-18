class Funcionario {
    private String nome;
    private float salarioHora;
    private int horasTrabalhadas;

    public Funcionario(String nome, float salarioHora, int horasTrabalhadas) {
        this.nome = nome;
        this.salarioHora = salarioHora;
        this.horasTrabalhadas = horasTrabalhadas;
    }

    public float calcularSalario() {
        float salario = salarioHora * horasTrabalhadas;
        return salario;
    }
}

class Lider extends Funcionario {
    public Lider(String nome, float salarioHora, int horasTrabalhadas) {
        super(nome, salarioHora, horasTrabalhadas);
    }

    @Override
    public float calcularSalario() {
        float salario = super.calcularSalario();
        return salario * 1.02f;
    }
}

class Gerente extends Funcionario {
    public Gerente(String nome, float salarioHora, int horasTrabalhadas) {
        super(nome, salarioHora, horasTrabalhadas);
    }

    @Override
    public float calcularSalario() {
        float salario = super.calcularSalario();
        return salario * 1.05f;
    }
}
