package assetManager;

import java.util.Iterator;

/*
 * Base class for composite and leaf
 */
public interface Asset {
	
	/*
	 * method to add leafs and composites
	 */
	void add(Asset asset);
	
	/*
	 * method to remove leafs and composites
	 */
	void remove(String assetName);
	
	/*
	 * allows visitor to work
	 */
	double accept(PricingVisitor visitor);
	
	/*
	 * override equals ==> used for comparing assets
	 */
	boolean equals(String assetName);
	
	/*
	 * override toString() ==> used when adding assets to a list
	 * don't want to add two children of the same name to a parent
	 */
	String toString();
	
	/*
	 * get's value of component 
	 * either the value of a leaf or the value of all the children
	 */
	double currentValue();
	
	/*
	 * each Asset returns an iterator of it's specific set
	 * in the case of leaves, the iterator is a NullIterator
	 */
	Iterator<Asset> createAssetIterator();
	
}
