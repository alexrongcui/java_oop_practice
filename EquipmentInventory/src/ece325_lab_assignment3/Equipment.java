package ece325_lab3;

public abstract class Equipment {
	private boolean needsWrapping;   // A variable indicate whether this kind of equipment needs wrapping 
	
	/**
	 * Constructor
	 * @param a boolean that indicates whether this type of equipment needs wrapping or not
	 */
	public Equipment(boolean needsWrapping) {
		this.needsWrapping = needsWrapping;
	}
	
	
	public void setNeedsWrapping(boolean needsWrapping) {
		this.needsWrapping = needsWrapping;
	}
	
	public boolean getNeedsWrapping() {
		return needsWrapping;
	}
	
	/**
	 * Indicates whether some other equipment is the same type as this one.
	 * @param other equipment
	 */
	public boolean equals(Equipment e) {
		if(this.getClass().equals(e.getClass()))
			return true;
		else 
			return false;
		
	}
	
	public abstract String toString();

}
