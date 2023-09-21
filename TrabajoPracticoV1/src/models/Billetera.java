package models;

public class Billetera {
	private Double saldo;

	public Billetera(Double saldo) {
		this.saldo = saldo;
	}

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

	@Override
	public String toString() {
		return "Billetera [saldo=" + saldo + "]";
	}
	
	
}
