package ece325_lab3;

public class Chair extends Equipment{
	
	public Chair(boolean needsWrapping) {
		super(needsWrapping);
	}

	@Override
	public String toString() {
		return "Chair";
	}

}

