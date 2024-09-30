public class Main {
    public static void main(String[] args) {
        System.out.println("Start");
        printNumbers(6);
        System.out.println("Finish");
    }
    public static void printNumbers(int limit){
        for (int i = 0; i < limit; i += 2){
            System.out.println(i);
        }
    }
}