import java.io.*;
import java.util.*;
public class dead 
{
	static int n,m,R[],Av[],C[][],A[][],req[][];
	public static void main(String args[])
	{
		Scanner in=new Scanner(System.in);
		System.out.print("Enter the number of processes:");
		n=Integer.parseInt(in.nextLine());
		System.out.print("Enter the number of resources:");
		m=Integer.parseInt(in.nextLine());
		R[]=new int[m];
		Av[]=new int[m];
		C[][]=new int[n][m];
		A[][]=new int[n][m];
		req[][]=new int[n][m];
		System.out.println("Enter the total amount of resources:-");
		String str[]=(in.nextLine()).split(" ");
		for(int i=0;i<m;i++)
		{
			R[i]=Integer.parseInt(str[i]);
		}
		System.out.println("Enter the claim array:-");
		for(int i=0;i<n;i++)
		{
			String str1[]=(in.nextLine()).split(" ");
			for(int j=0;j<m;j++)
			{
				C[i][j]=Integer.parseInt(str1[j]);
			}
		}
		System.out.println("Enter the allocated array:-");
		for(int i=0;i<n;i++)
		{
			String str2[]=(in.nextLine()).split(" ");
			for(int j=0;j<m;j++)
			{
				A[i][j]=Integer.parseInt(str2[j]);
				//req[i][j]=C[i][j]-A[i][j];
			}
		}
		int sum;
		for(int j=0;j<m;j++)
		{
			sum=0;
			for(int i=0;i<n;i++)
			{
				sum+=A[i][j];
			}
			Av[j]=R[j]-sum;
		}
		System.out.println("Enter the wanted allocation array:-");
		for(int i=0;i<n;i++)
		{
			String str3[]=(in.nextLine()).split(" ");
			for(int j=0;j<m;j++)
			{
				req[i][j]=Integer.parseInt(str3[j]);
				//req[i][j]=C[i][j]-A[i][j];
			}
		}
		int flag;
		for(int i=0;i<n;i++)
		{
			flag=0;
			for(int j=0;j<m;j++)
			{
				if(A[i][j]+req[i][j]>C[i][j])
				{
					flag=1;
					break;
				}
			}
			if(flag==1)
				System.out.println("Error in i/p for resource "+i+". Processor won't allocate m/y more than required.");
			else
			{
				boolean pro=true;
				while(pro)
				{
					for(int j=0;j<m;j++)
					{
						if(req[i][j]>Av[i][j])
						{	
							flag=1;
							break;
						}
					}
				}
			}
		}
	}
	public static boolean safe(int CAV[])
	{
		boolean possible = true;
		int R[][]=new int[n][m];
		int mark[]=new mark[n];
		int flag;
		for(int i=0;i<n;i++)
			mark[i]=0;
		for(int i=0;i<n;i++)
			{
				for(int j=0;j<m;j++)
				{
					R[i][j]=C[i][j]-A[i][j];
				}
			}
		int ff;
		while(possible)
		{
			ff=0;
			for(int i=0;i<n;i++)
			{
				if(mark[i]==0)
				{
					flag=0;
					for(int j=0;j<m;j++)
					{
						if(R[i][j]>CAV[j])
						{
							flag=1;
							break;
						}
					}
					if(flag==0)
					{	
						mark[i]=1;
						ff=1;
						for(int j=0;j<m;j++)
						CAV[j]+=A[i][j];
					}
				}
			}
			if(ff==0)
				possible=false;
		}
		for(int i=0;i<n;i++)
		{
			if(mark[i]==0)
				return false;
		}
		return true;
	}
}