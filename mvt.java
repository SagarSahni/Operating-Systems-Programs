import java.io.*;
import java.util.*;
public class mvt
{
	static int A[][]=new int[5][3];
	static int mem[][]=new int[5][2];
	static int size=400;
	static int top=-1;
	public static void main(String args[])
	{
		System.out.println("The memory is of 400KB");
		Scanner in=new Scanner(System.in);
		System.out.println("Enter the memory and time required for each process");
		for(int i=0;i<5;i++)
		{
			System.out.println("Process "+i+":-");
			A[i][0]=Integer.parseInt(in.nextLine());
			A[i][1]=Integer.parseInt(in.nextLine());
			A[i][2]=0;		//0-unallocated		1-allocated
		}
		for(int i=0;i<5;i++)
		{
		mem[i][0]=mem[i][1]=-1;
		}
		int tym=0;
		int completed=0;
		while(completed<5)
		{
			for(int i=0;i<5;i++)
			{
				if(A[i][2]==0&&A[i][0]<=size)
				{
					allocate(i);
				}
			}
			System.out.println("At time "+tym+":-");
			printmem();
			int  t=freeafter();
			completed+=finishproc(t);
			tym+=t;
		}
	}
	public static int finishproc(int t)
	{
		int count=0;
		for(int i=0;i<=top;i++)
		{
			mem[i][1]-=t;
			if(mem[i][1]==0)
			{
				size+=A[mem[i][0]][0];
				mem[i][0]=mem[i+1][0];
				mem[i][1]=mem[i+1][1];
				top--;
				i--;
				count++;
			}	
		}
		return count;
	}
	public static int freeafter()
	{
		int small=mem[0][1];
		for(int i=0;i<=top;i++)
		{
			if(mem[i][1]<small)
			small=mem[i][1];
		}
		return small;
	}
	public static void allocate(int a)
	{
		size-=A[a][0];
		mem[++top][0]=a;
		mem[top][1]=A[a][1];
		A[a][2]=1;
	}
	public static void printmem()
	{
		int tot=0;
		for(int i=0;i<=top;i++)
		{
			tot+=A[mem[i][0]][0];
			System.out.println("Process "+mem[i][0]+":"+A[mem[i][0]][0]+"kb");
		}
		System.out.println(tot+"kb used.\t"+(400-tot)+"kb free.");
	}
}