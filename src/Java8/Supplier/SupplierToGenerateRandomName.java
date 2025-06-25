package Java8.Supplier;

import java.util.function.Supplier;

public class SupplierToGenerateRandomName {
    public static void main(String[] args) {
        Supplier<String> x = () -> {
            String[] strs = {"Sunny", "Bunny", "Chinny", "Pinny"};
            int num = (int) (Math.random() * 4);
            return strs[num];
        };

        System.out.println(x.get());
        System.out.println(x.get());
        System.out.println(x.get());
        System.out.println(x.get());
        System.out.println(x.get());
        System.out.println(x.get());
        System.out.println(x.get());
        System.out.println(x.get());
        System.out.println(x.get());
        System.out.println(x.get());
    }
}
