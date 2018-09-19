package com.sample;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;

public class EbcdicConverter
{
    public static void main(String[] args) 
        throws Exception
    {
        String ebcdicString ="UNBIATA1CMUA180117121200754cUNH1TKCRES081IAUA754cMSG7917ERC107UNT40UNZ100754c";
        // convert String into InputStream
        InputStream is = new ByteArrayInputStream(ebcdicString.getBytes());
        ByteArrayOutputStream baos=new ByteArrayOutputStream();

        int line;
         while((line = is.read()) != -1) {
             baos.write((char)line);
         }
         String str = baos.toString("Cp500");
         System.out.println(str);
    }
}
