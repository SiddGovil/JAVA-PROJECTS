package lab3;

public class Coop {

	public Coop() {
		example1.BarnYard lg;
		lg = new example1.BarnYard();
		
		example1.Chicken chick;
		chick = new example1.Chicken();
		chick.start();
		lg.addChicken(chick);
		
		example1.Chicken ken;
		ken = new example1.Chicken();
		ken.start();
		lg.addChicken(ken);
		
		example1.Chicken popeyes;
		popeyes = new example1.Chicken();
		popeyes.start();
		lg.addChicken(popeyes);
		
		example1.Chicken kfc;
		kfc = new example1.Chicken();
		kfc.start();
		lg.addChicken(kfc);
		
		example1.Chicken teryaki;
		teryaki = new example1.Chicken();
		teryaki.start();
		lg.addChicken(teryaki);
		
		example1.Chicken eggs;
		eggs = new example1.Chicken();
		eggs.start();
		lg.addChicken(eggs);
		
		example1.Chicken rooster;
		rooster = new example1.Chicken();
		rooster.start();
		lg.addChicken(rooster);
		
	}
}
