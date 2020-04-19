
 
import java.util.*;

public class playfair
{	static char playfairmatrix[][]={{'F','M','N','T','U'},
									{'V','G','X','D','E'},								
									{'L','W','S','I','K'},								
									{'A','B','C','O','Z'},
									{'Q','R','H','Y','P'}};
	public static void main(String args[])
	{	String plainText,cipherText;
		Scanner sc=new Scanner(System.in);
		System.out.print("ENTER MESSAGE : ");
		plainText=sc.next();
		cipherText=encrypt(plainText);
		System.out.println("\nENCRYPTION \nCIPHER TEXT : "+cipherText);
		plainText=decrypt(cipherText);
		System.out.println("\nDECRYPTION \nPLAIN TEXT : "+plainText);
	}
	static String encrypt(String plainText)
	{	String midText=plainText.toUpperCase(),t;	
		String cipherText="";
		int len=midText.length();
		midText=midText.replace('J','I');	
		for(int i=0;i<midText.length()-1;i+=2)
		{	
			if(midText.charAt(i)==midText.charAt(i+1) && i<midText.length())
			{	t=midText;
				midText=t.substring(0,i+1)+'X'+midText.substring(i+1,len);
				len=len+1;
			}
		}
		if(midText.length()%2==1)
		{	midText=midText+'X';}
		int col1=0,row1=0,col2=0,row2=0;
		char cur,next;
		for(int i=0;i<midText.length();i+=2)
		{	cur=midText.charAt(i);
			next=midText.charAt(i+1);
			for(int j=0;j<5;j++)
			{	for(int k=0;k<5;k++)
				{	if(cur==playfairmatrix[j][k])
					{	row1=j;		
						col2=k;
					}
					if(next==playfairmatrix[j][k])
					{	col1=k;
						row2=j;
					}
				}
			}
			if(row1==row2)
			{	col1=(col1+1)%5; col2=(col2+1)%5; }
			else if(col1==col2)
			{	row1=(row1+1)%5; row2=(row2+1)%5; }
			cipherText=cipherText+playfairmatrix[row1][col1]+playfairmatrix[row2][col2];	
		}
		return cipherText;
	}
	
	static String decrypt(String cipherText)
	{	String midText=cipherText.toUpperCase(),t;
		String plainText="";
		int len=midText.length();
		
		int col1=0,row1=0,col2=0,row2=0;
		char cur,next;
		for(int i=0;i<midText.length();i+=2)
		{	cur=midText.charAt(i);
			next=midText.charAt(i+1);
			for(int j=0;j<5;j++)
			{	for(int k=0;k<5;k++)
				{	if(cur==playfairmatrix[j][k])
					{	row1=j;		
						col2=k;
					}
					if(next==playfairmatrix[j][k])
					{	col1=k;
						row2=j;
					}
				}
			}
			if(row1==row2)
			{	col1=(col1-1+5)%5; col2=(col2-1+5)%5; }
			else if(col1==col2)
			{	row1=(row1-1+5)%5; row2=(row2-1+5)%5; }
			plainText=plainText+playfairmatrix[row1][col1]+playfairmatrix[row2][col2];	
		}
		return plainText;
	}
}