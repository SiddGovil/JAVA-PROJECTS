package lab3;

public class Pen {
	public Pen() {
		example1.BarnYard ms;
		ms = new example1.BarnYard();
		
		example1.Pig bank;
		bank = new example1.Pig();
		bank.start();
		ms.addPig(bank);
		
		example1.Pig pork;
		pork = new example1.Pig();
		pork.start();
		ms.addPig(pork);
		
		example1.Pig farm;
		farm = new example1.Pig();
		farm.start();
		ms.addPig(farm);
		
		example1.Pig bacon;
		bacon = new example1.Pig();
		bacon.start();
		ms.addPig(bacon);
		
	}
}
