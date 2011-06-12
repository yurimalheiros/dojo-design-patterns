package dojo;

public class BookCollection implements IContainer {
	private String[] titles = {"title1", "title2", "title3"};
	
	public IIterator createIterator() {
		return new BookIterator();
	}
	
	private class BookIterator implements IIterator {
		private int position;
		
		public boolean hasNext() {
			if (position < titles.length)
				return true;
			else
				return false;
		}
		
		public Object next() {
			if (this.hasNext())
				return titles[position++];
			else
				return null;
		}
		
	}

}
