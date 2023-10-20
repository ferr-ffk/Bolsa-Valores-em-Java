public class BubbleSort {

	public static void ordenar(int[] v) {
		boolean mudouAlgum = true;

		while (mudouAlgum) {
			mudouAlgum = false;

			for (int i = 0; i < v.length - 1; i++) {
				int temp = v[i];

				if (v[i] > v[i + 1]) {
					mudouAlgum = true;

					v[i] = v[i + 1];
					v[i + 1] = temp;
				}
			}
		}

	}

}
