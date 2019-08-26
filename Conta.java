package unicesumarProgramming1;

public class Conta {
	
	protected int agencia;
	protected int numero;
	protected int digito;
	protected double saldo;
	
	public Conta() {
	}
	
	public void setInfo(int agencia, int numero, int digito, double saldo) {
		this.agencia = agencia;
		this.numero = numero;
		this.digito = digito;
		
		if (saldo <= 0) this.saldo = saldo;
		else this.saldo = saldo;
		System.out.println("Conta " + this.numero + " criada com sucesso!");
	}
	
	public void saque(double val) {
		if (val > this.saldo) {
			System.out.println("O valor do saque é maior que o saldo!");
			return;
		}
		
		this.saldo -= val;
		System.out.println("========================");
		System.out.println("Foi sacado um valor de " + val);
		System.out.println("Restam " + this.saldo + " na conta " + this.numero);
		System.out.println("========================");

		
	}
	
	public void deposito(double val) {
		this.saldo += val;
		System.out.println("========================");
		System.out.println("Foi depositado um valor de " + val);
		System.out.println("Conta " + this.numero + " possui " + this.saldo + " na conta.");
		System.out.println("========================");
	}
	
	public void transferencia(double val, Conta ct) {
		if (val > this.saldo) {
			System.out.println("O valor da transferência é maior que o saldo!");
			return;
		}
		System.out.println("Conta " + this.numero + " transferiu " + val + " para conta " + ct.numero);
		ct.deposito(val);
		saque(val);
	}
	
	public void saldo() {
		System.out.println("========================");
		System.out.println("Agencia: " + this.agencia);
		System.out.println("Número: " + this.numero);
		System.out.println("Digito: " + this.digito);
		System.out.println("Saldo: " + this.saldo);
		System.out.println("========================");
		
	}

	public static void main(String[] args) {
		
	    
//	    • Crie duas contas correntes e duas poupanças (pode definir os números das contas como quiser)
//	    • Inicie as contas com saldos e limites diferentes de zero.
		ContaCorrente c1 = new ContaCorrente();
		ContaCorrente c2 = new ContaCorrente();
		ContaPoupanca p1 = new ContaPoupanca();
		ContaPoupanca p2 = new ContaPoupanca();
		
		c1.setInfo(1, 1000, 5, 5000, 500);
		c2.setInfo(2, 1001, 6, 10000, 150);
		p1.setInfo(3, 1002, 7, 15000);
		p2.setInfo(4, 1003, 8, 15000);
		
		
//	    • Realize dois saques em quaisquer contas e exiba o saldo a seguir.
		p1.saque(1000);
		p1.saldo();
		
		c1.saque(2000);
		c1.saldo();
		
//	    • Realize duas transferências e exiba os saldos das contas envolvidas.
		c2.transferencia(255.57, c1);
		p1.transferencia(10, c2);
		
//	    • Realize tentativas de um saque e uma transferência para uma conta corrente que não tenha saldo suficiente mesmo com o limite.
		c2.saque(35200);
		c2.transferencia(19999, c1);
		
//	    • Realize tentativas de um saque e uma transferência para uma conta poupança que não tenha saldo suficiente.
		p2.saque(20000);
		p2.transferencia(50000, c1);
	}

}
