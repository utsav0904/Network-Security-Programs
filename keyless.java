
public class keyless
{
    public static String encrypt(String text)
    {
        String res = "";
        char a[][]= new char[4][4];
        text = text.toUpperCase();
        int count=0;
        int flag=0;
        for (int i = 0; i < 4; i++)
        {
            for(int j=0;j<4;j++)
            {
            	a[i][j]=text.charAt(count);
            	if(count==text.length()-1)
            	{
            		flag=1;
            		break;
            	}
            	count++;
            }
            if(flag==1)
            {
            	break;
            }
        }

        for (int i = 0; i < 4; i++)
        {
            for(int j=0;j<4;j++)
            {
            	//System.out.print(a[j][i]);
            	res=res+a[j][i];
            }
        }
        return res;
    }
 
    public static String decrypt(String text)
    {
        String res = "";
        text = text.toUpperCase();
        char a[][]=new char[4][4];
        int count=0;
        int flag=0;
        for (int i = 0; i < 4; i++)
        {
           for(int j=0;j<4;j++)
           {
        	   a[j][i]=text.charAt(count);
        	   if(count==text.length()-1)
           	{
           		flag=1;
           		break;
           	}
           	count++;
           }
           if(flag==1)
           {
        	   break;
           }
        }
        
        for(int i=0;i<4;i++)
        {
        	for(int j=0;j<4;j++)
        	{
        		res=res+a[i][j];
        	}
        }
        return res;
    }
 
    public static void main(String[] args)
    {
        String message = "meetmeatthepark";
        String encryptedMsg = encrypt(message);
        System.out.println("String: " + message);
        System.out.println("Encrypted message: " + encryptedMsg);
        System.out.println("Decrypted message: " + decrypt(encryptedMsg));
    }
}