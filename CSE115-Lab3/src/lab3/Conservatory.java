package lab3;

public class Conservatory {

	public Conservatory() {
		example1.BarnYard by;
		by = new example1.BarnYard();
		
		example1.Butterfly butter;
		butter = new example1.Butterfly();
		butter.start();
		by.addButterfly(butter);
		
		example1.Butterfly fly;
		fly = new example1.Butterfly();
		fly.start();
		by.addButterfly(fly);
		
		example1.Butterfly bug;
		bug = new example1.Butterfly();
		bug.start();
		by.addButterfly(bug);
		
		example1.Butterfly insect;
		insect = new example1.Butterfly();
		insect.start();
		by.addButterfly(insect);
		
		example1.Butterfly pokemon;
		pokemon = new example1.Butterfly();
		pokemon.start();
		by.addButterfly(pokemon);
	}
}
