package lab2;

public class Farm {

	public Farm() {
		example1.BarnYard by;
		by = new example1.BarnYard();
		
		example1.Pig c;
		c = new example1.Pig();
		by.addPig(c);
		c.start();
		
		example1.Pig p;
		p = new example1.Pig();
		by.addPig(p);
		p.start();
		
		example1.Pig r;
		r = new example1.Pig();
		by.addPig(r);
		
		example1.Pig s;
		s = new example1.Pig();
		by.addPig(s);
		
		example1.Butterfly b;
		b = new example1.Butterfly();
		by.addButterfly(b);
		b.start();
		
		example1.Butterfly a;
		a = new example1.Butterfly();
		by.addButterfly(a);
		a.start();
		
		example1.Chicken chick;
		chick = new example1.Chicken();
		by.addChicken(chick);
		chick.start();
		
		example1.Chicken en;
		en = new example1.Chicken();
		by.addChicken(en);
		en.start();
		
		example1.Chicken log;
		log = new example1.Chicken();
		by.addChicken(log);
		
	}

}
