package web;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class DrawTextTest {

	public static void main(String[] args) throws IOException, FontFormatException {
		// TODO Auto-generated method stub
		long start =  System.currentTimeMillis();
		
		final BufferedImage image = ImageIO.read(new File("/tmp/test.jpg"));
		
		Graphics graphic = image.getGraphics();
		
		Font font = Font.createFont(Font.TRUETYPE_FONT, new File("/tmp/Helvetica.ttf"));				

		graphic.setFont(font);
		graphic.setColor(Color.YELLOW);
		graphic.drawString("Truong Viet Cuong", 200, 300);
		graphic.dispose();
		
		ImageIO.write(image, "jpg", new File("/tmp/result.jpg"));
		
		long end =  System.currentTimeMillis();
		
		System.err.println("time:" + (end-start));
		

	}

}
