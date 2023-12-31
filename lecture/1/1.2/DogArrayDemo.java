public class DogArrayDemo {
    public static void main(String[] args) {
        /* Create an array of two dogs */
        Dog[] dogs = new Dog[2];
        dogs[0] = new Dog(5);
        dogs[1] = new Dog(20);

        dogs[0].makeNoise();
        dogs[1].makeNoise();
    }
}