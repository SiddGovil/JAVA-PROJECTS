package lab4;

public class SmallFarm {
    private example1.BarnYard _by;
    
    public SmallFarm(){
    	_by = new example1.BarnYard(); }
    	
    public void addPig() {
    	example1.Pig piggy;
    	piggy = new example1.Pig();
    	_by.addPig(piggy);
    	piggy.start();
    	}
    		
		public void addButterfly() {
			example1.Butterfly insect;
			insect = new example1.Butterfly();
			_by.addButterfly(insect);
			insect.start();
		}
		
		public void addChicken() {
    		example1.Chicken chicky;
    		chicky = new example1.Chicken();
    		_by.addChicken(chicky); 
    		chicky.start();
		}
		
		
	
		

}
