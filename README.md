# poot1


1. Crie um programa para calcular o salário dos funcionários de uma empresa. O salário é baseado no valor hora e quantidade de horas trabalhadas no mês. Porém, para algumas funçõeses existe uma bonificaçãoo. Para os líderes, o salário é incrementado em 2% e para os gerentes em 5%. Desenvolva o diagrama de classe da UML.

 
class Employee {
    private String name;
    private double hourlyRate;
    private int hoursWorked;

    public Employee(String name, double hourlyRate, int hoursWorked) {
        this.name = name;
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
    }

    public double calculateSalary() {
        return hourlyRate * hoursWorked;
    }
}


class Leader extends Employee {
    public Leader(String name, double hourlyRate, int hoursWorked) {
        super(name, hourlyRate, hoursWorked);
    }

    @Override
    public double calculateSalary() {
   
        return super.calculateSalary() * 1.02;
    }
}


class Manager extends Employee {
    public Manager(String name, double hourlyRate, int hoursWorked) {
        super(name, hourlyRate, hoursWorked);
    }

    @Override
    public double calculateSalary() {
     
        return super.calculateSalary() * 1.05;
    }
}


public class Main {
    public static void main(String[] args) {
     
        Employee employee1 = new Employee("João", 20.0, 160);
        Leader leader1 = new Leader("Maria", 25.0, 160);
        Manager manager1 = new Manager("Carlos", 30.0, 160);

        System.out.println("Salário do funcionário João: R$" + employee1.calculateSalary());
        System.out.println("Salário da líder Maria: R$" + leader1.calculateSalary());
        System.out.println("Salário do gerente Carlos: R$" + manager1.calculateSalary());
    }
}






2. Desenvolva objetos que sejam capazes de desenhar um retângulo com um texto. O retângulo pode conter diferentes tipos de decoração (bordas arrendondadas, linhas duplas, ascii art, colorido, etc). Porém cada objeto deve ser capaz de desenhar apenas um tipo de retângulo.



interface RectangleDrawer {
    void drawRectangle(int width, int height, String text);
}


abstract class BaseRectangleDrawer implements RectangleDrawer {
    protected void drawLine(String line) {
        System.out.println(line);
    }
}


class RoundedRectangleDrawer extends BaseRectangleDrawer {
    @Override
    public void drawRectangle(int width, int height, String text) {
        drawLine("╭" + "─".repeat(width) + "╮");
        for (int i = 0; i < height; i++) {
            drawLine("|" + " ".repeat(width) + "|");
        }
        drawLine("╰" + "─".repeat(width) + "╯");
    }
}


class DoubleBorderRectangleDrawer extends BaseRectangleDrawer {
    @Override
    public void drawRectangle(int width, int height, String text) {
        drawLine("╔" + "═".repeat(width) + "╗");
        for (int i = 0; i < height; i++) {
            drawLine("║" + " ".repeat(width) + "║");
        }
        drawLine("╚" + "═".repeat(width) + "╝");
    }
}


class ColorfulRectangleDrawer extends BaseRectangleDrawer {
    @Override
    public void drawRectangle(int width, int height, String text) {
        drawLine("\u001B[44m" + " ".repeat(width));
        for (int i = 0; i < height; i++) {
            drawLine("\u001B[44m" + " ".repeat(width));
        }
        drawLine("\u001B[0m");
    }
}


class RectangleDrawerFactory {
    public static RectangleDrawer createRectangleDrawer(String type) {
        switch (type.toLowerCase()) {
            case "rounded":
                return new RoundedRectangleDrawer();
            case "double":
                return new DoubleBorderRectangleDrawer();
            case "colorful":
                return new ColorfulRectangleDrawer();
            default:
                throw new IllegalArgumentException("Tipo de retângulo não suportado: " + type);
        }
    }
}


public class Main {
    public static void main(String[] args) {
        RectangleDrawer roundedRectangleDrawer = RectangleDrawerFactory.createRectangleDrawer("rounded");
        System.out.println("Rounded Rectangle:");
        roundedRectangleDrawer.drawRectangle(10, 5, "Sample Text");

        RectangleDrawer doubleBorderRectangleDrawer = RectangleDrawerFactory.createRectangleDrawer("double");
        System.out.println("\nDouble Border Rectangle:");
        doubleBorderRectangleDrawer.drawRectangle(8, 3, "Another Text");

        RectangleDrawer colorfulRectangleDrawer = RectangleDrawerFactory.createRectangleDrawer("colorful");
        System.out.println("\nColorful Rectangle:");
        colorfulRectangleDrawer.drawRectangle(6, 4, "Hello");
    }
}
