import java.util.*;
public class fifo
{
	public static int P[][]=new int[3][2];
	public static void main(String args[])
	{
		Scanner in=new Scanner(System.in);
		System.out.println("There are 3 rows in the page table");
		System.out.println("Enter the no. of page requests");
		int n=in.nextInt();
		System.out.println("Enter page requests");
		int A[]=new int[n];
		for(int i=0;i<n;i++)
		{
			A[i]=in.nextInt();
		}
		int pgb=0,j=0;
		for(int i=0;i<n;i++)
		{
			if(j<3)
			{
				if(!check(A[i]))
				{
					P[j][0]=A[i];
					P[j][1]=i;
					j++;
					display();
				}
			}
			else if(!check(A[i]))
			{
				int lp=lrupos();
				P[lp][0]=A[i];
				P[lp][1]=i;
				pgb++;
				display();
			}
		}
		System.out.println("Page Breaks:"+pgb);
	}
	public static int lrupos()
	{
		int small=P[0][1];
		int pos=0;
		for(int i=1;i<3;i++)
		{
			if(small>P[i][1])
			{	small=P[i][1];
				pos=i;
			}
		}
		return pos;
	}
	public static boolean check(int d)
	{
		for(int i=0;i<3;i++)
		{
			if(P[i][0]==d)
			{
				display();
				return true;
			}
		}
		return false;
	}
	public static void display()
	{
		for(int i=0;i<3;i++)
			System.out.print(P[i][0]+"\t");
		System.out.println();
	}
}