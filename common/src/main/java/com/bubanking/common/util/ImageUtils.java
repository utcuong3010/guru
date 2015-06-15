package com.bubanking.common.util;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.apache.log4j.Logger;

public class ImageUtils {
	
private static final Logger logger = Logger.getLogger(ImageUtils.class);
	
	/**
	 * ThÃªm text vÃ o hÃ¬nh áº£nh
	 * @param g2d
	 * @param x
	 * @param y
	 * @param angle
	 * @param text
	 */
	public static void drawTextOnImage(Graphics2D g2d, float x, float y, int angle, String text)
	{
		FontMetrics fm = g2d.getFontMetrics();
		Rectangle2D rec = fm.getStringBounds(text, g2d);

		g2d.translate(x, y);
		g2d.rotate(Math.toRadians(angle), (rec.getX() + rec.getWidth()) / 2,
				(rec.getY() + rec.getHeight()) / 2);
		g2d.drawString(text, 0, 0);
		g2d.rotate(-Math.toRadians(angle));
		g2d.translate(-x, -y);
		

		
		

	}

	/**
	 * ThÃªm layer filter vÃ o hÃ¬nh áº£nh 
	 * @param img
	 * @param color
	 * @param alpha
	 * @return
	 */
	public static BufferedImage addLayer(BufferedImage img, Color color,
			float alpha)
	{
		Graphics2D g = img.createGraphics();
		g.setColor(color);
		g.fillRect(0, 0, img.getWidth(), img.getHeight());
		g.dispose();
		return img;
	}

	/**
	 * GhÃ©p logo vÃ o mockup
	 * @param logo
	 * @param pathMockup
	 * @param output
	 * @return
	 */
	public static String compositeLogoToMockup(BufferedImage logo,
			String pathMockup, String output)
	{
		try
		{
			BufferedImage resizeLogo = resizeImage(logo, 380, 506, true);

			BufferedImage mockup = ImageIO.read(new File(pathMockup));
			Graphics2D g2d = mockup.createGraphics();
			g2d.drawImage(resizeLogo, 305, 220, null);
			g2d.dispose();

			//mockup = addLayer(mockup, new Color(1.0f, 0.0f, 0.0f, 0.1f), 0.1f);

			ImageIO.write(mockup, "jpg", new File(output));

		} catch (IOException e)
		{
			logger.error("Lá»—i: " + e.getMessage());
		}

		return output;
	}

	/**
	 * Resize láº¡i kÃ­ch thÆ°á»›c hÃ¬nh áº£nh
	 * @param originalImage
	 * @param width
	 * @param height
	 * @param hint
	 * @return
	 */
	public static BufferedImage resizeImage(BufferedImage originalImage,
			int width, int height, boolean hint)
	{

		BufferedImage resizedImage = new BufferedImage(width, height,
				BufferedImage.TYPE_INT_ARGB);
		Graphics2D g = resizedImage.createGraphics();
		g.drawImage(originalImage, 0, 0, width, height, null);
		g.dispose();

		if (hint)
		{
			g.setComposite(AlphaComposite.Src);

			g.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
					RenderingHints.VALUE_INTERPOLATION_BILINEAR);
			g.setRenderingHint(RenderingHints.KEY_RENDERING,
					RenderingHints.VALUE_RENDER_QUALITY);
			g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
					RenderingHints.VALUE_ANTIALIAS_ON);
		}

		return resizedImage;
	}

	/**
	 * Xuáº¥t áº£nh logo vÃ  banner
	 * @param pathImg
	 * @param pathMockup
	 * @param text
	 * @param pathFont
	 * @param size
	 * @param angle
	 * @param top
	 * @param outputLogo
	 * @param outputBanner
	 * @return
	 */
	public static String createImageFromText(String pathImg, String pathMockup,
			String text, String pathFont, float size, int angle, int top,
			String outputLogo, String outputBanner)
	{
		BufferedImage img = null;
		Graphics2D g2d = null;

		if (!pathImg.equals(""))
		{
			try
			{
				img = ImageIO.read(new File(pathImg));
				g2d = img.createGraphics();
				Font font = Font.createFont(Font.TRUETYPE_FONT, new File(
						pathFont));				

				g2d.setRenderingHint(RenderingHints.KEY_ALPHA_INTERPOLATION,
						RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY);
				g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
						RenderingHints.VALUE_ANTIALIAS_ON);
				g2d.setRenderingHint(RenderingHints.KEY_COLOR_RENDERING,
						RenderingHints.VALUE_COLOR_RENDER_QUALITY);
				g2d.setRenderingHint(RenderingHints.KEY_DITHERING,
						RenderingHints.VALUE_DITHER_ENABLE);
				g2d.setRenderingHint(RenderingHints.KEY_FRACTIONALMETRICS,
						RenderingHints.VALUE_FRACTIONALMETRICS_ON);
				g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
						RenderingHints.VALUE_INTERPOLATION_BILINEAR);
				g2d.setRenderingHint(RenderingHints.KEY_RENDERING,
						RenderingHints.VALUE_RENDER_QUALITY);
				g2d.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL,
						RenderingHints.VALUE_STROKE_PURE);

				float xText = 0, yText = 0;

				for (float i = size; i > 200; i -= 25)
				{
					g2d.setFont(font.deriveFont(i));
					FontMetrics fm = g2d.getFontMetrics();

					int wText = fm.stringWidth(text);

					if (wText > img.getWidth())
						continue;

					int hText = fm.getHeight();
					int wImg = img.getWidth();

					xText = wImg / 2 - wText / 2;

					float height2 = ((fm.getMaxAscent() + fm.getMaxDescent() + hText) / 2) / 2;

					yText = top + (height2) - (hText - fm.getAscent());
					break;
				}

				g2d.setColor(Color.YELLOW);
				drawTextOnImage(g2d, xText, yText, angle, text);

				g2d.dispose();

			} catch (Exception e)
			{
				logger.error("Lá»—i: " + e.getMessage());
			}
		} else
		{
			img = new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB);
			g2d = img.createGraphics();
			Font font = null;

			try
			{
				font = Font.createFont(Font.TRUETYPE_FONT, new File(pathFont));
				g2d.setFont(font.deriveFont(size));

				FontMetrics fm = g2d.getFontMetrics();

				int wText = fm.stringWidth(text);
				int hText = fm.getHeight();
				g2d.dispose();

				img = new BufferedImage(wText, hText,
						BufferedImage.TYPE_INT_ARGB);

				g2d = img.createGraphics();

				g2d.setRenderingHint(RenderingHints.KEY_ALPHA_INTERPOLATION,
						RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY);
				g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
						RenderingHints.VALUE_ANTIALIAS_ON);
				g2d.setRenderingHint(RenderingHints.KEY_COLOR_RENDERING,
						RenderingHints.VALUE_COLOR_RENDER_QUALITY);
				g2d.setRenderingHint(RenderingHints.KEY_DITHERING,
						RenderingHints.VALUE_DITHER_ENABLE);
				g2d.setRenderingHint(RenderingHints.KEY_FRACTIONALMETRICS,
						RenderingHints.VALUE_FRACTIONALMETRICS_ON);
				g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
						RenderingHints.VALUE_INTERPOLATION_BILINEAR);
				g2d.setRenderingHint(RenderingHints.KEY_RENDERING,
						RenderingHints.VALUE_RENDER_QUALITY);
				g2d.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL,
						RenderingHints.VALUE_STROKE_PURE);

				g2d.setFont(font.deriveFont(size));
				fm = g2d.getFontMetrics();
				g2d.setColor(Color.YELLOW);
				g2d.drawString(text, 0, fm.getAscent());

				g2d.dispose();
			} catch (Exception e)
			{
				logger.error("Lá»—i: " + e.getMessage());
			}
		}

		try
		{
			ImageIO.write(img, "jpg", new File(outputLogo));

			compositeLogoToMockup(img, pathMockup, outputBanner);

		} catch (IOException e)
		{
			outputLogo = null;
		}

		return outputBanner;
	}
	
	
	public static void main(String[] args) throws IOException {
		
		long start =  System.currentTimeMillis();
		
//		final BufferedImage image = ImageIO.read(new File("/tmp/test.png"));
		
//		Graphics2D graphics = image.createGraphics();
//		ImageUtils.drawTextOnImage(graphics, 200, 200, 360, "Truong Cuong cuonfs fre");
		String pathFont = "/tmp/Helvetica.ttf";
		int size  = 400;
		int angle  =0;
		int top = 30;
		
		String pathImg = "/tmp/test.jpg";
		String pathMockup = "/tmp/mockup.jpg";
		String outputLogo = "/tmp/logo.jpg";
		String outputBanner = "/tmp/banner.jpg";
		
		String banner = ImageUtils.createImageFromText(pathImg,pathMockup, "Truong Cuong", pathFont, size, angle, top, outputLogo, outputBanner);
		
		
		System.err.println(banner);
		
//		ImageIO.write(image, "png", new File("/tmp/result.png"));
		
		long end =  System.currentTimeMillis();
		
		System.err.println("time:" + (end-start));
		
	}

}
