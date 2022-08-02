package StandardJavaInterviewWriteCodeQuestions;

/*

Input : N = 5
Output:
          1
        1   1
      1   2   1
    1   3   3   1
  1   4   6   4   1



           0C0
        1C0   1C1
     2C0   2C1   2C2
  3C0   3C1   3C2   3C3



 */


public class Pascaltriangle {

    public int factorial(int i)
    {
        if (i == 0)
            return 1;
        return i * factorial(i - 1);
    }

    public static void main(String[] args)
    {

        int n = 7 , i , j;

        Pascaltriangle pascaltriangle = new Pascaltriangle();

        for(i=0;i<n;i++)
        {
            for(j=0;j<n-i;j++)
            {
                System.out.print(" ");
            }


            for (j = 0; j <= i; j++) {

                // nCr formula
                System.out.print(
                        " "
                                + pascaltriangle.factorial(i)
                                / (pascaltriangle.factorial(i - j)
                                * pascaltriangle.factorial(j)));
            }


            System.out.println();
        }
    }


}
