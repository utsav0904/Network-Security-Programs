

import java.util.Scanner;
public class affine
{
public static void main(String args[])
{

	Scanner s=new Scanner(System.in);
	char pltext[]=new char[20];
	char citext[]=new char[20];
	char detext[]=new char[20];
	int plcode[]=new int[20];
	int cicode[]=new int[20];
	int decode[]=new int[20];
	int i,l,u,v,b=1;
	
	System.out.print(" enter string\n:");
	pltext=s.next().toCharArray();
	System.out.print(" enter multiplicative key\n:");
	u=s.nextInt();

	if(u%2==0)
	{
		System.out.println("\nINVALID KEY ");
		System.exit(0);
	}
	
	System.out.print(" enter additive key \n :");
	v=s.nextInt();
	
	l=pltext.length;
	for(i=0;i<l;i++)
	{
		plcode[i]=pltext[i];
		plcode[i]=plcode[i]-97;
	}

	for(i=0;i<l;i++)
	{
		cicode[i]=(plcode[i]*u)+v;
		cicode[i]=cicode[i]%26;
		cicode[i]=cicode[i]+65;
		citext[i]=(char) cicode[i];
	}
	System.out.print(" The cipher text is \t :");

	for(i=0;i<l;i++)
	{
		System.out.print(citext[i]);
	}

	for(i=0;i<26;i++)
	{
		if((u*b)%26==1)
		{
			break;
		}
		else
		{
			b++;
		}
	}
	System.out.print("\n key:"+b);

	for(i=0;i<l;i++)
	{
		cicode[i]=citext[i];
		cicode[i]=cicode[i]-65;
	}

	for(i=0;i<l;i++)
	{
		decode[i]=b*(cicode[i]-v+26);
		decode[i]=decode[i]%26;
		decode[i]=decode[i]+97;
		detext[i]=(char) decode[i];
	}
	System.out.print("\nDecoded text is \t:");

	for(i=0;i<l;i++)
	{
		System.out.print(detext[i]);
	}
}
}
