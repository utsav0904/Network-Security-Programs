

public class keyed
{
    public static String encrypt(String text, String key)
    {
        String res = "";
        char a[][]= new char[4][5];
        text = text.toUpperCase();
        int count=0;
        int flag=0;
        int number;
        for (int i = 0; i < 4; i++)
        {  
        	count=0;
            for(int j=0;j<5;j++)
            {
            	res=String.valueOf(key.charAt(count));
            	number=Integer.parseInt(res);
            	a[i][j]=text.charAt(number-1);
            	count++;
            }
            text=text.substring(count);

        }
        res="";
        for (int i = 0; i < 4; i++)
        {
            for(int j=0;j<5;j++)
            {
            	//System.out.print(a[i][j]);
            	res=res+a[i][j];
            }
        }
        return res;
    }
 
    public static String decrypt(String text, String dkey)
    {
    	 String res = "";
         char a[][]= new char[4][5];
         text = text.toUpperCase();
         int count=0;
         int flag=0;
         int number;
         for (int i = 0; i < 4; i++)
         {  
         	count=0;
             for(int j=0;j<5;j++)
             {
            	 
             	res=String.valueOf(dkey.charAt(count));
             	number=Integer.parseInt(res);
             	a[i][number-1]=text.charAt(count);
             	//System.out.println(a[i][number]);
             	count++;
   
             }
             text=text.substring(count);

         }
         res="";
         for (int i = 0; i < 4; i++)
         {
             for(int j=0;j<5;j++)
             {
             	//System.out.print(a[i][j]);
             	res=res+a[i][j];
             }
         }
         return res;
    }
 
    public static void main(String[] args)
    {
        String message = "enemyattackstonightz";
        String key="31452";
        String dkey="31452";
        String encryptedMsg = encrypt(message,key);
        System.out.println("String: " + message);
        System.out.println("Encrypted message: " + encryptedMsg);
        System.out.println("Decrypted message: " + decrypt(encryptedMsg,dkey));
    }
}