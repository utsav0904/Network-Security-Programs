

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

class Hill
{
	int matrix[][] = {{9,7,11,13},{4,7,5,6},{2,21,14,9},{3,23,21,8}};
	int inv_matrix[][] = {{2,15,22,3},{15,0,19,3},{9,9,3,11},{17,0,4,7}};
	//c=pk
	//p=ck-1
	Hill()
	{
	}
	void Encryption() throws IOException
	{
		String pt,ct="";
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter Plain Text:");
		pt = br.readLine();
		
		int r = pt.length()<=4?1:(pt.length()/4) ;
		int ptMat[][]=new int[r][4];
		int i,j=0,come_out=0;
		pt = pt.replaceAll(" ","");
		int pointer = 0;
		for(i=0;i<r;i++)
		{
			for(j=0;j<4;j++)
			{
				if(pointer<pt.length()){
					ptMat[i][j] = (int)pt.charAt(4*i+j)-65;
					pointer++;
				}else{
					come_out=1;
					break;
				}
			}
			if(come_out==1)
				break;
		}
		for(;i<r;i++){
			for(;j<4;j++){
				ptMat[i][j] = 25;
			}
			j=0;
		}
		
		
		//matrix multiplication;
		int sum;
		int ctMat[][] = new int[r][4];
		for(i=0;i<r;i++){
			for(j=0;j<4;j++){
				sum=0;
				for(int y=0;y<4;y++){
					sum = sum + ptMat[i][y]*matrix[y][j];
				}		
				ctMat[i][j] = sum%26;		
			}
		}
		for(i=0;i<r;i++)
		{
			for(j=0;j<4;j++){
				ct = ct + (char)(ctMat[i][j] + 65);
			}
		}
		System.out.println("Cipher text:\n"+ct);
	
		br.read();
	}
	void Decryption() throws IOException
	{
		String ct, key ,pt="";
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("\nEnter Cipher Text:");
		ct = br.readLine();
		int i,j=0,come_out=0;
		int r = ct.length()<=4?1:(ct.length()/4) ;
		int ctMat[][]=new int[r][4];
		ct = ct.replaceAll(" ","");
		int pointer = 0;
		for(i=0;i<r;i++)
		{
			for(j=0;j<4;j++)
			{
				if(pointer<ct.length()){
					ctMat[i][j] = (int)ct.charAt(4*i+j)-65;
					pointer++;
				}else{
					come_out=1;
					break;
				}
			}
			if(come_out==1)
				break;
		}
		for(;i<r;i++){
			for(;j<4;j++){
				ctMat[i][j] = 25;
			}
			j=0;
		}
		int sum;
		int ptMat[][] = new int[r][4];
		for(i=0;i<r;i++){
			for(j=0;j<4;j++){
				sum=0;
				for(int y=0;y<4;y++){
					sum = sum + ctMat[i][y]*inv_matrix[y][j];
				}		
				ptMat[i][j] = sum%26;		
			}
		}
		for(i=0;i<r;i++)
		{
			for(j=0;j<4;j++){
				pt = pt + (char)(ptMat[i][j] + 65);
			}
		}
		System.out.println("Decrypted text:\n"+pt);
	}
	
}

public class HillCipher {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Hill ad = new Hill();
		System.out.println("Hill Cipher");
		ad.Encryption();
		ad.Decryption();
	}

}
