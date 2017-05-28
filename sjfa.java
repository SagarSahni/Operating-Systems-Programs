import java.io.*;
import java.util.*;
public class sjfa {

    public static void main(String[] args)throws IOException{
    	BufferedReader BR=new BufferedReader(new InputStreamReader(System.in));
    	int A[][]=new int[5][9];
    	System.out.println("Enter arrival and Service time for 5 processes:-");
    	for(int i=0;i<5;i++)
    	{
    		A[i][0]=i+1;
    		A[i][1]=Integer.parseInt(BR.readLine());
    		A[i][2]=Integer.parseInt(BR.readLine());
    		A[i][8]=0;
       	}
		int st=0,ft,p,s;
		for(int i=0;i<5;i++)
		{
			s=A[i][2];
			p=i;
			for(int j=i+1;j<5&&A[j][1]<=st;j++)
			{
				if(A[j][2]<s&&A[j][8]==0)
				{
					s=A[j][2];
					p=j;
				}
			}
			if(A[p][8]==0)
			{
			if(A[p][1]>st)
				st=A[p][1];
			A[p][3]=st;
			ft=st+A[p][2];
			A[p][4]=ft;
			A[p][5]=A[p][3]-A[p][1];
			A[p][6]=A[p][5]+A[p][2];
			A[p][7]=A[p][6]/A[p][2];
			A[p][8]=1;
			st=ft;
			}
			if(p!=i)
				i-=1;
			
		}
		System.out.println("Process\tArrival\tService\tStart\tFinish\tWaiting\tTurnover Ratio");
		for(int i=0;i<5;i++)
		{
			for(int j=0;j<8;j++)
			{
				System.out.print(A[i][j]+"\t");
			}System.out.println();
		}
    
    }
    
    
}