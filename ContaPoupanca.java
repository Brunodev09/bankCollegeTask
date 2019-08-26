package unicesumarProgramming1;

public class ContaPoupanca extends Conta {
	public ContaPoupanca(int agencia, int numero, int digito, double saldo) {
		super();
		
	}

	public ContaPoupanca() {
	}

	public void rendimento(double perc) {
		if (perc > 1) {
			System.out.println("Rendimento máximo de 100%!");
			return;
		}
		else if (perc <= 0) {
			System.out.println("Rendimento mínimo de 1%!");
			return;
		}
		this.saldo += (this.saldo * perc);
	}
}
