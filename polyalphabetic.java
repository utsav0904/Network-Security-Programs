

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class AutoKeyCipher
{
	void Encryption() throws IOException
	{
		String pt;int key;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter Plain Text:");
		pt = br.readLine();
		System.out.println("Enter Key:");
		key = Integer.parseInt(br.readLine());
		int curKey = key;
		for(int i=0;i<pt.length();i++)
		{
			int temp = ((int)pt.charAt(i)-97+curKey);
			System.out.print((char)(temp%26 + 65));
			curKey = (int)pt.charAt(i)-97;
		}
		br.read();
	}
	
	void Decryption() throws IOException
	{
		String ct;int key;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("\nEnter Cipher Text:");
		ct = br.readLine();
		System.out.println("Enter Key:");
		key = Integer.parseInt(br.readLine());
		
		int curKey = key;
		for(int i=0;i<ct.length();i++)
		{
			int temp = ((int)ct.charAt(i)-65-curKey);
			temp = (temp<0)?temp+26:temp;
			System.out.print((char)(temp%26 + 97));
			curKey = temp%26;
		}
		br.read();
	}
	
}


public class polyalphabetic {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		AutoKeyCipher ad = new AutoKeyCipher();
		System.out.println("AutoKey Cipher");
		ad.Encryption();
		ad.Decryption();
	}

}
