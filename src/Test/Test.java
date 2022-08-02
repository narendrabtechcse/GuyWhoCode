package Test;

public class Test {

    public static void main(String[] args)
    {
        System.out.println(parse("1234"));
    }

    static double parse(String str)
    {
        char[] nums = str.toCharArray();

        double finalVal = 0;
        int j=0;

        for(int i=nums.length-1;i>=0;i--)
        {
            finalVal = finalVal + Integer.parseInt(String.valueOf(nums[i]))*Math.pow(10,j);//4 ,


            System.out.println("Integer.parseInt(String.valueOf(nums[i]))*Math.pow(10,j)"+ Integer.parseInt(String.valueOf(nums[i]))*Math.pow(10,j));

            j++;



            System.out.println("nums[i] "+ nums[i]);
            System.out.println("final val "+ finalVal);

            System.out.println("j "+ j);



        }

        return finalVal;
    }



    static int parse2(String str)
    {
        char[] nums = str.toCharArray();

        int finalVal = 0;
        int j=0;

        for(int i=0;i<nums.length-1;i++)
        {
           // finalVal = finalVal + Integer.valueOf(nums[i]))+ 10*i;


           // System.out.println("nums[i]*Math.pow(10,j)"+ nums[i]*Math.pow(10,j));

            //j++;



            System.out.println("nums[i] "+ nums[i]);
            System.out.println("final val "+ finalVal);

           // System.out.println("j "+ j);



        }

        return finalVal;
    }

    //create a Library List AL,LL , Singly CLL---> add , print method , accept all type of data

}
