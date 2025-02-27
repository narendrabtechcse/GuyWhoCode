package leetcode_premium.string;


/*
If the answer is yes (like C++), we may use "==" to compare two strings.
If the answer is no (like Java), we may not use "==" to compare two strings. When we use "==", it actually compares whether these
two objects are the same object.

Immutable or Mutable

Immutable means that you can't change the content of the string once it's initialized.

In some languages (like C++), the string is mutable. That is to say, you can modify the string just like what you did in an array.
In some other languages (like Java), the string is immutable. This feature will bring several problems. We will illustrate the problems and
solutions in the next article.
You can determine whether the string in your favorite language is immutable or mutable by testing the modification operation. Here is an example:


You should be aware of the time complexity of these built-in operations.

For instance, if the length of the string is N, the time complexity of both finding operation and substring operation is O(N).

Also, in languages which the string is immutable, you should be careful with the concatenation operation
 (we will explain this in next article as well).

Never forget to take the time complexity of built-in operations into consideration when you compute the time complexity for your solution.

 */

public class Intro_1 {

        public static void main(String[] args) {
            // initialize
            String s1 = "Hello World";
            System.out.println("s1 is \"" + s1 + "\"");
            String s2 = s1;
            System.out.println("s2 is another reference to s1.");
            String s3 = new String(s1);
            System.out.println("s3 is a copy of s1.");
            // compare using '=='
            System.out.println("Compared by '==':");
            // true since string is immutable and s1 is binded to "Hello World"
            System.out.println("s1 and \"Hello World\": " + (s1 == "Hello World"));
            // true since s1 and s2 is the reference of the same object
            System.out.println("s1 and s2: " + (s1 == s2));
            // false since s3 is refered to another new object
            System.out.println("s1 and s3: " + (s1 == s3));
            // compare using 'equals'
            System.out.println("Compared by 'equals':");
            System.out.println("s1 and \"Hello World\": " + s1.equals("Hello World"));
            System.out.println("s1 and s2: " + s1.equals(s2));
            System.out.println("s1 and s3: " + s1.equals(s3));
            // compare using 'compareTo'
            System.out.println("Compared by 'compareTo':");
            System.out.println("s1 and \"Hello World\": " + (s1.compareTo("Hello World") == 0));
            System.out.println("s1 and s2: " + (s1.compareTo(s2) == 0));
            System.out.println("s1 and s3: " + (s1.compareTo(s3) == 0));


            String s5 = "Hello World";
            // 1. concatenate
            s1 += "!";
            System.out.println(s1);
            // 2. find
            System.out.println("The position of first 'o' is: " + s5.indexOf('o'));
            System.out.println("The position of last 'o' is: " + s5.lastIndexOf('o'));
            // 3. get substring
            System.out.println(s5.substring(6, 11));

            String s = "Hello World";
            char[] str = s.toCharArray();
            str[5] = ',';
            System.out.println(str);

            int n = 10000;
            StringBuilder strs = new StringBuilder();
            for (int i = 0; i < n; i++) {
                strs.append("hello");
            }
            String stt = strs.toString();
        }
    }
