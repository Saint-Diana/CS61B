public class Dog {
    public int weightInPounds;

    /** Constructors
     * @param wip weightInPounds
     */
    public Dog(int wip) {
        weightInPounds = wip;
    }

    /** Constructors without formal parameters
     * 
     */
    public Dog() {
        weightInPounds = 0;
    }

    public void makeNoise() {
        if (this.weightInPounds < 10) {
            System.out.println("yipyipyip!");
        } else if (this.weightInPounds < 30) {
            System.out.println("bark. bark.");
        } else {
            System.out.println("woof!");
        }
    }
}
