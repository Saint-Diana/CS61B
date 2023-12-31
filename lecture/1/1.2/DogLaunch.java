public class DogLaunch {
    public static void main(String[] args) {
       Dog dog1 = new Dog();
       dog1.weightInPounds = 20;
       System.out.print("Dog1: ");
       dog1.makeNoise();

       Dog dog2 = new Dog(30);
       System.out.print("Dog2: ");
       dog2.makeNoise();
    }
}
