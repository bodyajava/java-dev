
public class myFirstApp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		String[] wordListOne = {"24/7", "multi-Tier", "30,000 foot", "B-to-B", "win-win", "front-end"};
		String[] wordListTwo = {"empowered", "sticky", "value-added", "oriented", "branded", "aligned"};
		String[] wordListThree = {"process", "point", "solution", "mission", "vision", "strategy"};
		
		int oneLength = wordListOne.length;
		int twoLength = wordListTwo.length;
		int threeLength = wordListThree.length;
		
		int random = (int) Math.random();
		int rand1 = (int) (Math.random() * oneLength);
		int rand2 = (int) (Math.random() * twoLength);
		int rand3 = (int) (Math.random() * threeLength);
		
		System.out.println("What we need is a '" + 
				wordListOne[rand1] + " " + wordListTwo[rand2] + " " + wordListThree[rand3] + "' phrase");
	}

}
