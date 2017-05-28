import java.io.*;
import java.util.*;
public class priority
{
    public static void main(String[] args)
	{
    	Scanner in=new Scanner(System.in);
		int A[][]=new int[5][10];
		double ratio[]=new double[5];
		System.out.println("Enter the arrival time ,service time and priority(1-5) for 5 processes:-");
		for(int i=0;i<5;i++)
		{
			System.out.print("Process "+(i+1)+":");
			A[i][0]=i+1;
			String str[]=(in.nextLine()).split(" ");
			A[i][1]=Integer.parseInt(str[0]);
			A[i][2]=Integer.parseInt(str[1]);
			A[i][3]=Integer.parseInt(str[2]);
			A[i][8]=A[i][2];
			A[i][9]=0;
		}
		int pro=0,tym=0;
		outer: for(int i=0;i<5;tym++)
		{
			for(int j=0;j<5&&A[j][1]<=tym;j++)
			{
				if(A[j][8]!=0&&(A[j][3]<A[pro][3]||A[pro][8]==0))
				{
					pro=j;
					if(A[pro][8]==0)
					{
						tym-=1;
						continue outer;
					}
				}
			}
			if(A[pro][9]==0)
			{
				A[pro][4]=tym;
				A[pro][9]=1;
			}
			A[pro][8]-=1;
			if(A[pro][8]==0)
			{
				A[pro][5]=tym+1;
				A[pro][6]=A[pro][5]-A[pro][2]-A[pro][1];
				A[pro][7]=A[pro][6]+A[pro][2];
				ratio[pro]=(double)A[pro][7]/A[pro][2];
				i+=1;
			}
		}
		System.out.println("Process\tArrival\tService\tPriority\tStart\tFinish\tWaiting\tTurnover Ratio");
		for(int i=0;i<5;i++)
		{
			for(int j=0;j<8;j++)
			{
				System.out.print(A[i][j]+"\t");
			}System.out.println("\t"+ratio[i]);
		}
    }
}