package sample.장난감;

import java.util.BitSet;

public class testclass {
	public static void main(String[] args) {

		BitSet bitSet = new BitSet(5);

		bitSet.set(1);
		bitSet.set(1, false);
		for (int i = 0; i < 5; i++) {
			System.out.println(bitSet.get(i));
		}
	}
}
