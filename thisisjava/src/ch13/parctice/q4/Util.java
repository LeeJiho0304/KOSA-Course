package ch13.parctice.q4;

public class Util {
	public static <K,V> V getValue(Pair<K, V> p, K key) {
		if(p.key.equals(key)) {
			return p.value;
		}
		return null;
	}
}
