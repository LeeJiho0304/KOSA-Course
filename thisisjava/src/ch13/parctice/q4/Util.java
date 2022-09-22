package ch13.parctice.q4;

public class Util {
	public static <K,V> V getValue(Pair<K, V> p, K key) {
		if(p.key.equals(key)) {
			return p.value;
		}
		return null;
	}
	
	public static <P extends Pair<K,V>, K, V> V getValue2(P p, K key) {
		if(p.key.equals(key)) {
			return p.value;
		}
		return null;
	}
}
