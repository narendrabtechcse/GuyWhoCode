package leetcode_premium.string;

public class Add_Binary_2 {
    public static String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();

        int i = a.length() - 1, j = b.length() - 1, carry = 0;

        while (i >= 0 || j >= 0) {
            int sum = carry;
            if (i >= 0)
                sum = sum + a.charAt(i--) - '0';

            if (j >= 0)
                sum = sum + b.charAt(j--) - '0';

            sb.append(sum % 2);
            carry = sum / 2;
        }

        if (carry != 0)
            sb.append(carry);

        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(addBinary("1010", "1011"));
    }
}
