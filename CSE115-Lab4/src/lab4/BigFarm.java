package lab4;

public class BigFarm {
	private example1.BarnYard _by2;
	private example1.BarnYard _by3;
	
	public BigFarm() {
		_by2 = new example1.BarnYard();
		_by3 = new example1.BarnYard();
	}

		public void addPig(){
		example1.BarnYard temp;
		example1.Pig piggy2;
		piggy2 = new example1.Pig();
		_by2.addPig(piggy2);
		piggy2.start();
		temp = _by2;
		_by2 = _by3;
		_by3 = temp;
		}
		
		public void addButterfly(){
		example1.BarnYard temp;
		example1.Butterfly fly2;
		fly2 = new example1.Butterfly();
		_by2.addButterfly(fly2);
		fly2.start();
		temp = _by2;
		_by2 = _by3;
		_by3 = temp;
		}
		
		public void addChicken(){
			example1.BarnYard temp;
			example1.Chicken chicky2;
			chicky2 = new example1.Chicken();
			_by2.addChicken(chicky2);
			chicky2.start();
			temp = _by2;
			_by2 = _by3;
			_by3 = temp;
		}
		
			
		
		

		
		
	

}
