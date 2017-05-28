import java.io.*;
import java.util.*;
public class seq
{
	static int mem[]=new int[20];
	static int completed=0,start=0;
	static int A[][];
	public static void main(String args[])
	{
		Scanner in=new Scanner(System.in);
		System.out.println("The memory is divided into 20 segments.");
		System.out.print("Enter the number of files:");
		int n=Integer.parseInt(in.nextLine());
		System.out.println("Give the number of segments needed by each file:-");
		A=new int[n][2];
		for(int i=0;i<n;i++)
		{
			A[i][0]=Integer.parseInt(in.nextLine());
			A[i][1]=-1;
		}
		while(completed<n)
		{
			int flag=0;
			for(int i=0;i<n;i++)
			{
				if(A[i][0]<=20-start&&A[i][1]==-1)
				{
					A[i][1]=start;
					for(int j=0;j<A[i][0];j++)
						mem[start++]=i;
					flag=1;
				}
			}
			if(flag==0)
			{	printmem();
				deallocate();
			}
		}
	}
	public static void deallocate()
	{
		Scanner in=new Scanner(System.in);
		System.out.print("File to move out of main memory:");
		int p=Integer.parseInt(in.nextLine());
		completed+=1;
		int temp=20;
		for(int i=start-1;i>=0;i--)
		{
			if(mem[i]==p)
			{
				temp=i;
				break;
			}
		}
		for(int i=temp+1;i<start;i++)
			mem[i-A[p][0]]=mem[i];
		start-=A[p][0];
	}
	public static void printmem()
	{
		int pt=-1;
		System.out.print("File Num\tSeg Req\tSegments");
		for(int i=0;i<start;i++)
		{
			if(mem[i]==pt)
				System.out.print(" "+i);
			else
			{
				pt=mem[i];
				System.out.print("\n"+pt+"\t\t"+A[pt][0]+"\t"+i);
			}
		}
		System.out.println();
	}
}