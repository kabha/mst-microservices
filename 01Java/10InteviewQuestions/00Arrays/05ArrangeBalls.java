package intel;

public class ArrangeBalls {

	public static void main(String[] args) {

		String[] balls = { "Red" ,"Green" ,"Yellow", "Green" , "Yellow" , "Red", "Red" }; 

		arrangeBalesOn(balls);
		for (int i = 0; i < balls.length; i++) {
			System.out.print("  " + balls[i]);
		}

	}

	// O(n)
	private static void arrangeBalesOn(String[] balls) {
		int i = 0, j = balls.length - 1;

		while (i <= j) {
			if (!balls[i].equals("Red")) {
				if (balls[j].equals("Red")) {
					String temp = balls[j];
					balls[j] = balls[i];
					balls[i] = temp;
					j--;
					i++;
				} else {
					j--;
				}
			} else {
				if (balls[i].equals("Red")) {
					i++;
				} else {
					i++;
					j--;
				}
			}
		}

		i = 0;
		j = balls.length - 1;
		while (i <= j) {
			if (!balls[i].equals("Green")) {
				if (balls[j].equals("Green")) {
					j--;
					i++;
				} else {
					i++;
				}
			} else {
				if (!balls[j].equals("Green")) {
					String temp = balls[i];
					balls[i] = balls[j];
					balls[j] = temp;
					j--;
					i++;
				} else {
					j--;
				}
			}

		}
	}
}
