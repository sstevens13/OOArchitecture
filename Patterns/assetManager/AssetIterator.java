package assetManager;

import java.util.Iterator;
import java.util.Stack;

/*
 * adapted from Head First Java Patterns
 */
public class AssetIterator implements Iterator<Asset> {
	private Stack<Iterator<Asset>> stack;
	
	public AssetIterator(Iterator<Asset> iterator) {
		stack = new Stack<Iterator<Asset>>();
		stack.push(iterator);
	}

	public Asset next() {
		if (hasNext()) {
			Iterator<Asset> iterator = stack.peek();
			Asset asset = iterator.next();
			// If asset is a leaf, it will return a NullIterator
			stack.push(asset.createAssetIterator());
			return asset;
		} else {
			return null;
		}
	}
	
	public boolean hasNext() {
		if (stack.empty()) {
			return false;
		} else {
			Iterator<Asset> iterator = stack.peek();
			if (!iterator.hasNext()) {
				stack.pop();
				return hasNext();
			} else {
				return true;
			}
		}
	}

	public void remove() {
		throw new UnsupportedOperationException();
	}
	
}