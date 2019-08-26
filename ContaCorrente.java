package unicesumarProgramming1;

public class ContaCorrente extends Conta {

	//	Usando Override e Overload de métodos para limite
	
	private double limite;
	
	public ContaCorrente(int agencia, int numero, int digito, double saldo) {
		super();
	}

	public ContaCorrente() {
	}

	
	public void setInfo(int agencia, int numero, int digito, double saldo, double limite) {
		this.agencia = agencia;
		this.numero = numero;
		this.digito = digito;
		
		if (limite < 0) this.limite = 0;
		else this.limite = limite;
		
		if (saldo < 0) this.saldo = 0;
		else this.saldo = saldo;
		
		System.out.println("Conta " + this.numero + " criada com sucesso!");
	}
	

	
	public void saque(double val) {
		if (val > this.saldo + this.limite) {
			System.out.println("O valor do saque é maior que o saldo e o limite!");
			return;
		}
		
		if (val >= this.saldo) {
			val = val - this.saldo;
			this.limite -= val;
			this.saldo = 0;
		} else this.saldo -= val;
		
		System.out.println("========================");
		System.out.println("Foi sacado um valor de " + val);
		System.out.println("Restam " + (this.limite + this.saldo) + " na conta " + this.numero);
		System.out.println("========================");

	}
	
	public void transferencia(double val, Conta ct) {
		if (val > this.saldo + this.limite) {
			System.out.println("O valor do saque é maior que o saldo e o limite!");
			return;
		}
		
		if (val >= this.saldo) {
			val = val - this.saldo;
			this.limite -= val;
			this.saldo = 0;
		} else this.saldo -= val;
		
		System.out.println("Conta " + this.numero + " transferiu " + val + " para conta " + ct.numero);
		ct.deposito(val);
		saque(val);
	}
}
