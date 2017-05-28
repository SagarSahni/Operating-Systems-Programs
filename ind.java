import java.io.*;
import java.util.*;
public class ind
{
	static String mem[]=new String[20];
	static int n,completed=0;
	static int A[][];
	static ArrayList<Integer> list = new ArrayList<Integer>(20);
	public static void main(String args[])
	{
		Scanner in=new Scanner(System.in);
		System.out.println("The memory is divided into 20 segments.");
		System.out.print("Enter the number of files:");
		n=Integer.parseInt(in.nextLine());
		System.out.println("Give the number of segments needed by each file:-");
		A=new int[n][3];
		for(int i=0;i<n;i++)
		{
			A[i][0]=Integer.parseInt(in.nextLine());
			A[i][1]=-1;
			A[i][2]=0;
		}
        for(int i = 0; i < 20; i++) {
            list.add(i);
			mem[i]="";
        }
		int index,index1;
		Random rand = new Random();
		while(completed<n)
		{
			int flag=0;
			for(int i=0;i<n;i++)
			{
				if(A[i][0]<list.size()&&A[i][1]==-1)
				{
					index = rand.nextInt(list.size());
					A[i][1]=list.get(index);
					list.remove(index);
					for(int j=0;j<A[i][0];j++)
					{
						index1=rand.nextInt(list.size());
						int x=list.get(index1);
						list.remove(index1);
						mem[A[i][1]]+=x+" ";
						mem[x]+=i;
						flag=1;
					}
					A[i][2]=1;
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
		A[p][2]=0;
		completed+=1;
		list.add(A[p][1]);
		String str=mem[A[p][1]];
		int init=0;
		while(init<str.length()-1)
		{
			int num=Integer.parseInt(str.substring(init,str.indexOf(' ',init)));
			mem[num]="";
			list.add(num);
			init=str.indexOf(' ',init)+1;
		}
		mem[A[p][1]]="";
	}
	public static void printmem()
	{
		System.out.println("File Num\tSeg Req\tIndex\tSegments");
		for(int i=0;i<n;i++)
		{
			if(A[i][2]==1)
			{
				System.out.println(i+"\t\t"+A[i][0]+"\t"+A[i][1]+"\t"+mem[A[i][1]]);
			}
		}
	}
}