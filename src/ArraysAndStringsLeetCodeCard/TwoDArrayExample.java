package ArraysAndStringsLeetCodeCard;

public class TwoDArrayExample {

    public static void main(String[] args) {
        int[][] twoDArr = new int[5][10];

        for(int i=0;i<twoDArr.length;i++)
        {
            for(int j=0;j<twoDArr[0].length;j++)
            {
                twoDArr[i][j] = i+j;
            }
        }

        for (int k=0;k<twoDArr.length;k++)
        {
            System.out.println("Printing twoDArr[k]" );
            System.out.print("twoDArr[k] " +twoDArr[k]);
        }


        for(int i=0;i<twoDArr.length;i++)
        {
            for(int j=0;twoDArr[i] !=null && j<twoDArr[i].length;++j)
            {
                System.out.println("twoDArr[i][j] + ");
                System.out.print(twoDArr[i][j] + " ");
            }
        }

    }
}
