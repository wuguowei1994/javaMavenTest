public class TestModify {
    public static class Input{
        private int a = 5;
        private int b = 7;

        @Override
        public String toString() {
            return "Input{" +
                    "a=" + a +
                    ", b=" + b +
                    '}';
        }
    }

    public static void main(String[] args) {
        Input input1 = new Input();
        System.out.println(input1);
        test(input1);
        System.out.println(input1);
    }

    public static void test(Input input){
        input.a++;
        input.b++;
    }
}
