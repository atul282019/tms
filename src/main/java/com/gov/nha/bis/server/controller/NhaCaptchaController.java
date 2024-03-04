package com.gov.nha.bis.server.controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.OutputStream;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class NhaCaptchaController {
 
    public static final String FILE_TYPE = "jpeg";
	
	private static final Logger logger = LoggerFactory.getLogger(NhaCaptchaController.class);
	
   @RequestMapping(value="/captcha",method = RequestMethod.GET)
   public void getCaptchaImage(HttpServletRequest request, HttpServletResponse response,ModelMap model){
       
		response.setHeader( "Cache-Control", "no-store" );
		response.setHeader( "Pragma", "no-cache" );
		response.setDateHeader( "Expires", 0 );
       
       String captchaStr=generateCaptcha(6);
       try {
           int width=80;      
           int height=35;

           Color bg = new Color(44,45,110);
           Color fg = new Color(255,255,255);

           Font font = new Font("Arial", Font.BOLD, 16);
           BufferedImage cpimg =new BufferedImage(width,height,BufferedImage.TYPE_BYTE_GRAY);
           Graphics g = cpimg.createGraphics();

           g.setFont(font);
           g.setColor(bg);
           g.fillRect(0, 0, width, height);
           g.setColor(fg);
           g.drawString(captchaStr,10,25);   

           HttpSession session = request.getSession(true);
           session.setAttribute("captchaStr", captchaStr);

           logger.info("captchaStr==="+captchaStr);
          OutputStream outputStream = response.getOutputStream();

          ImageIO.write(cpimg, FILE_TYPE, outputStream);
        
          outputStream.flush();
          outputStream.close();

       } catch (Exception e) {
               e.printStackTrace();
       }
   }

   private String generateCaptcha(int captchaLength) {

	   String saltChars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
	   StringBuffer captchaStrBuffer = new StringBuffer();
	   Random rnd = new Random();

	   while (captchaStrBuffer.length() < captchaLength)
	   {
		   int index = (int) (rnd.nextFloat() * saltChars.length());
		   captchaStrBuffer.append(saltChars.substring(index, index+1));
	   }

	   return captchaStrBuffer.toString();

}



}
