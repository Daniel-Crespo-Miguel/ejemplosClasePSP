class Contador {
	private int c = 0;

	Contador(int c) {
		this.c = c;
	}

	public synchronized void incrementa() {
		c = c + 1;
	}

	public synchronized void decrementa() {
		c = c - 1;
	}

	public int getValor() {
		return c;
	}

}// CONTADOR

class HiloA extends Thread {
	private Contador contador;

	public HiloA(String n, Contador c) {
		this.setName(n);
		contador = c;
	}

	public void run() {
		for (int j = 0; j < 300; j++) {
			contador.incrementa();
//			try {
//				sleep(50);
//			} catch (InterruptedException e) {		}
		}
		System.out.println(getName() + " contador vale " + contador.getValor());
	}
}// FIN HILOA

class HiloB extends Thread {
	private Contador contador;

	public HiloB(String n, Contador c) {
		this.setName(n);
		contador = c;
	}

	public void run() {
		for (int j = 0; j < 300; j++) {
			contador.incrementa();
//			try {
//				sleep(50);
//			} catch (InterruptedException e) {}
		}
		System.out.println(getName() + " contador vale " + contador.getValor());
	}
}// FIN HILOB

public class CompartirInf1 {
	public static void main(String[] args) {
		Contador cont = new Contador(100);
		HiloA a = new HiloA("HiloA", cont);
		HiloB b = new HiloB("HiloB", cont);
		a.start();
		b.start();
		System.out.println("Main contador vale " + cont.getValor());
	}
}
