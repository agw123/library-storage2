package library;

public class Audiobook extends Book{
	
	private int duration;
	
	public Audiobook(String id, String title, String author, int duration) {
		super(id, title, author);
		this.duration = duration;
	}
	
	 @Override
	    public String toString() {
	        return super.toString() + ", " + duration;
	    }
}
