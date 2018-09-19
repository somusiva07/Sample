package com.sample;

public class UTF2HEX {

	public static String getUTFStringAsHex(String message)
    {
        if (message == null || message.equals(""))
        {
            return null;
        }

        // Returns hex String representation of char c
        char hexDigit[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };

        StringBuffer hexString = new StringBuffer();

        for (int i = 0; i < message.length(); i++)
        {
            char c = message.charAt(i);
            byte lowByte = (byte) (c & 0xff);
            char[] array = { hexDigit[(lowByte >> 4) & 0x0f], hexDigit[lowByte & 0x0f] };
            hexString.append(array);
        }

        if (message.length() < 24)
        {
            for (int i = 0; i < ((24 - message.length()) * 2); i++)
            {
                hexString.append('0');
            }
        }
        return hexString.toString();
    }
	
	public static void main(String ar[])
	{
		String message = "LXLH";
		System.out.println(getUTFStringAsHex(message));
	}
	
}
