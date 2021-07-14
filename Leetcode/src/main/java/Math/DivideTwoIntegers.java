package Math;

public class DivideTwoIntegers {
    public int divide(int dividend, int divisor) {
        if(divisor==0||dividend==Integer.MIN_VALUE&&divisor==-1)
            return Integer.MAX_VALUE;
        int res=0;
        int sign=(dividend<0)^(divisor<0)?-1:1;
        long dvd=Math.abs((long)dividend);
        long dvs=Math.abs((long)divisor);
        while(dvd >= dvs)
        {
            long temp=dvs;
            long mul=1;

            while(dvd >= temp<<1)
            {
                temp <<=1;
                mul <<=1;
            }

            res+=mul;
            dvd-=temp;

        }

        return sign==1? res:-res;
    }
}
