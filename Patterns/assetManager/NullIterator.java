package assetManager;

import java.util.Iterator;

/*
 * The iterator that any leaf component returns.
 */
public class NullIterator implements Iterator<Asset> {

	public boolean hasNext() {
		return false;
	}

	public Asset next() {
		return null;
	}

	public void remove() {
		throw new UnsupportedOperationException();
	}

}
