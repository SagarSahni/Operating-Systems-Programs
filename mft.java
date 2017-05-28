import java.io.*;
import java.util.*;
public class mft 
{
	static int mem[][]=new int[4][4];		// column 0-process residing; 1-flag; 2-time reqd; 3-start tym
	public static void main(String[] args) 
    {
        Scanner in=new Scanner(System.in);
        int A[][]=new int[5][4];
		System.out.println("Each memory slot is of 100kB in 400KB memory");
        System.out.println("Enter the memory required for 5 processes and time for completion:-");
        for(int i=0;i<5;i++)
        {
            System.out.print("Process "+i+":-\nMemory Reqd.:");
			A[i][0]=Integer.parseInt(in.nextLine());	//memory requirement
			System.out.print("Time:");
            A[i][1]=Integer.parseInt(in.nextLine());	//time input
			int slots=A[i][0]/100+1;
            slots=(A[i][0]%100==0)?slots-1:slots;
			A[i][2]=slots;
			A[i][3]=0;
        }				
        for(int i=0;i<4;i++)
            {
			mem[i][0]=-1;								//process set to -1
			mem[i][1]=0;								//flag set to 0 for all slots; empty m/y
			mem[i][2]=-1;
			}
		int tym=0,compProc=0;
		while(compProc<5)
		{
		for(int i=0;i<5;i++)
		{
            if(A[i][3]==0&&A[i][2]<=countslots())
            {
                assignslots(i,A[i][2],A[i][1],tym);
				A[i][3]=1;
            }
		}
		System.out.println("At time "+tym+":-");
		printmem();
		int timeinc=freeafter();
		freetheslots(timeinc);
		compProc=completedpro(A);
		timetravel(timeinc);
		tym+=timeinc;
		}
	}
	static void timetravel(int t)
	{
		for(int i=0;i<4;i++)
		{
			if(mem[i][1]==1)
			mem[i][2]-=t;
		}
	}
	static int freeafter()
	{
		int small=-1,i;
		for(i=0;i<4;i++)
		{
			if(mem[i][1]==1)
			{small=mem[i][2];
			break;
			}
		}
		for(int j=i+1;j<4;j++)
		{
			if(small>mem[j][2]&&mem[j][1]==1)
			small=mem[j][2];
		}
		return small;
	}
	static void assignslots(int pro,int slots,int time,int start)
	{
		for(int k=0;k<4;k++)
        {
            if(mem[k][1]==0)
            {
			mem[k][0]=pro;
			mem[k][1]=1;
			mem[k][2]=time;
			mem[k][3]=start;
			slots-=1;
			if(slots==0)
				break;					
			}
        }  
	}
	static int freetheslots(int t)
	{
		int ct=0;
		for(int i=0;i<4;i++)
		{
			if(mem[i][2]==t)
			{
			mem[i][0]=-1;
			mem[i][1]=0;
			mem[i][2]=-1;
			ct+=1;
			}
		}
		return ct;
	}
	static int countslots()
	{
		int fs=0;
		for(int i=0;i<4;i++)
		{
			if(mem[i][1]==0)
			fs+=1;
		}
		return fs;
	}
	static int completedpro(int A[][])
	{
		int x=0;
		for(int i=0;i<5;i++)
		{
			if(A[i][3]==1)
			x+=1;
		}
		return x;
	}
	static void printmem()
	{
		for(int i=0;i<4;i++)
		{
		System.out.println(mem[i][0]);
		}
	}
}