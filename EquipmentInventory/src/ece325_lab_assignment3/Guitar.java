package ece325_lab3;

public class Guitar extends Instrument{
	
	public Guitar(boolean needsWrapping) {
		super(needsWrapping);
	}

	@Override
	public String toString() {
		return "Guitar";
	}
}

