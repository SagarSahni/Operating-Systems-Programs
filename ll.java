import java.io.*;
import java.util.*;
public class ll
{
	static int n,completed=0;
	static int A[][];
	static ArrayList<Integer> list = new ArrayList<Integer>(20);
	static LinkedList<Integer>[] L;
	public static void main(String args[])
	{
		Scanner in=new Scanner(System.in);
		System.out.println("The memory is divided into 20 segments.");
		System.out.print("Enter the number of files:");
		n=Integer.parseInt(in.nextLine());
		L=new LinkedList[n];
		for(int i=0;i<n;i++)
		L[i]=new LinkedList<Integer>();
		System.out.println("Give the number of segments needed by each file:-");
		A=new int[n][3];
		for(int i=0;i<n;i++)
		{
			A[i][0]=Integer.parseInt(in.nextLine());
			A[i][1]=-1;
			A[i][2]=0;
		}
		for(int i = 0; i < 20; i++)
		{
            list.add(i);
        }
		int index,index1;
		Random rand = new Random();
		while(completed<n)
		{
			int flag=0;
			for(int i=0;i<n;i++)
			{
				if(A[i][0]<=list.size()&&A[i][1]==-1)
				{
					index = rand.nextInt(list.size());
					A[i][1]=list.get(index);
					L[i].addFirst(A[i][1]);
					list.remove(index);
					for(int j=1;j<A[i][0];j++)
					{
						index1=rand.nextInt(list.size());
						int x=list.get(index1);
						L[i].add(x);
						list.remove(index1);
						flag=1;
					}
					A[i][2]=1;
				}
			}
			if(flag==0)
			{	
				printmem();
				deallocate();
			}
		}
	}
	public static void deallocate()
	{
		Scanner in=new Scanner(System.in);
		System.out.print("File to move out of main memory:");
		int p=Integer.parseInt(in.nextLine());
		A[p][2]=0;
		completed+=1;
		while(L[p].size()>0)
		{
			list.add(L[p].getLast());
			L[p].removeLast();
		}
	}
	public static void printmem()
	{
		System.out.println("File Num\tSeg Req\tSegments");
		for(int i=0;i<n;i++)
		{
			if(A[i][2]==1)
			{
				System.out.println(i+"\t\t"+A[i][0]+"\t"+L[i]);
			}
		}
	}
}