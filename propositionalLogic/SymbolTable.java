/**
 *
 * Author: George Ferguson
 *
 *
 * Assignment: CSC 242 Project 02
 *
 */

package propositionalLogic;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * A SymbolTable maps names (Strings) to Symbols.
 */
public class SymbolTable {

	protected Map<String,Symbol> symbols = new HashMap<>();

	public SymbolTable() {
		
	}

	private SymbolTable(Map<String, Symbol> symbols) {
		this.symbols = symbols;
	}

	/**
	 * Returns the PropositionSymbol with the given NAME, creating one
	 * and adding it to this SymbolTable if necessary.
	 */
	public Symbol intern(String name) {
		Symbol sym = symbols.get(name);
		if (sym == null) {
			sym = new Symbol(name);
			symbols.put(name, sym);
		}
		return sym;
	}

	/**
	 * Return the number of Symbols stored in this SymbolTable.
	 */
	public int size() {
		return symbols.size();
	}

	/**
	 * Return a Collection containing the Symbols stored in this
	 * SymbolTable.
	 */
	public Collection<Symbol> symbols() {
		return symbols.values();
	}


	public SymbolTable copySymbolTable() {
		return new SymbolTable(new HashMap<String, Symbol>(symbols));
	}

}
