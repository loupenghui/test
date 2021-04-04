package com.hzsun.demotest.commons.utils;

import com.google.zxing.*;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Hashtable;
import java.util.UUID;


public class QRUtils{
	
	private static final Log logger = LogFactory.getLog(QRUtils.class);
	private static final int BLACK = 0xFF000000;  
    private static final int WHITE = 0xFFFFFFFF; 
    private static final int LogoPart = 4; 
    
    /**
     * 生成二维码前的配置信息
     * @param content 生成二维码图片内容
     * @param width   二维码图片的宽度
     * @param height  二维码图片的高度
     * @return
     */
    public static BitMatrix setBitMatrix(String content,int width,int height){
        Hashtable<EncodeHintType, Object> hints = new Hashtable<EncodeHintType, Object>();   
        hints.put(EncodeHintType.CHARACTER_SET, "utf-8");    
        hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);  //指定纠错等级  
        BitMatrix bitMatrix=null;
		try {
			bitMatrix = new MultiFormatWriter().encode(content, BarcodeFormat.QR_CODE, width, height, hints);
		} catch (WriterException e) {
			logger.error("生成二维码错误",e);
		}  
        return bitMatrix;
    }
    
    /**
     * 将LOGO图片放在二维码中间（水印效果）
     * 将生成的图片以流的形式输出到页面展示
     * @param matrix          BitMatrix
     * @param format          图片格式
     * @param outStream       输出流
     * @param logoPath        LOGO地址
     * @param showBottomText  二维码图片底部需要显示的问题
     * @throws IOException    
     */
    public static void megerToFile(BitMatrix matrix,String format,OutputStream outStream,String logoPath,String showBottomText) throws IOException {  
        BufferedImage image = toBufferedImage(matrix);  
        Graphics2D gs = image.createGraphics();  
        
        //1.加入LOGO水印效果
        if(null != logoPath && !"".equals(logoPath)){
        	//1.1 载入LOGO图片 
            BufferedImage logoImg = ImageIO.read(new File(logoPath));  
            //1.2 考虑到LOGO图片贴到二维码中，建议大小不要超过二维码的1/5;  
            int width = image.getWidth() / LogoPart;  
            int height = image.getHeight() / LogoPart;  
            //1.3 LOGO居中显示  
            int x = (image.getWidth() - width) / 2;   
            int y = (image.getHeight() - height) / 2;  
            gs.drawImage(logoImg, x, y, logoImg.getWidth(), logoImg.getHeight(), null);  
            logoImg.flush();  
        }
        //2.二维码图片底部插入文字
        if(null != showBottomText && !"".equals(showBottomText)){
        	//2.1 设置字体样式
        	Font font = new Font("微软雅黑", Font.PLAIN, 14);
        	gs.setColor(Color.BLACK);
        	gs.setFont(font);
        	//2.2 字体显示位置
        	int x = (image.getWidth() - getWatermarkLength(showBottomText, gs))/2;
        	int y = image.getHeight()-2;
        	gs.drawString(showBottomText, x, y);
        }
        gs.dispose();  
        ImageIO.write(image, format, outStream);
    } 
    
    /**
     * 将LOGO图片放在二维码中间（水印效果）
     * 将生成的图片生成到本地硬盘路径下
     * @param matrix          BitMatrix
     * @param format          图片格式
     * @param imagePath       图片存放路径
     * @param logoPath        LOGO地址
     * @param showBottomText  二维码图片底部需要显示的问题
     * @throws IOException    
     */
    public static void megerToFile2(BitMatrix matrix,String format,String imagePath,String logoPath,String showBottomText) throws IOException {  
        BufferedImage image = toBufferedImage(matrix);  
        Graphics2D gs = image.createGraphics();  
        
        //1.加入LOGO水印效果
        if(null != logoPath && !"".equals(logoPath)){
        	BufferedImage logoImg = ImageIO.read(new File(logoPath));  
            int width = image.getWidth() / LogoPart;  
            int height = image.getHeight() / LogoPart;  
            int x = (image.getWidth() - width) / 2;  
            int y = (image.getHeight() - height) / 2;  
            gs.drawImage(logoImg, x, y, logoImg.getWidth(), logoImg.getHeight(), null);  
            logoImg.flush();  
        }
        	
        //2.二维码图片底部插入文字
        if(null != showBottomText && !"".equals(showBottomText)){
        	//2.1 设置字体样式
        	Font font = new Font("微软雅黑", Font.PLAIN, 14);
        	gs.setColor(Color.BLACK);
        	gs.setFont(font);
        	//2.2 字体显示位置
        	int x = (image.getWidth() - getWatermarkLength(showBottomText, gs))/2;
        	int y = image.getHeight()-2;
        	gs.drawString(showBottomText, x, y);
        }
        gs.dispose();
        ImageIO.write(image, format, new File(imagePath));
    } 
    
    /**
     * 获取水印字体的长度
     * @param fontString
     * @param gs
     * @return
     */
    public static int getWatermarkLength(String fontString,Graphics2D gs){
    	return gs.getFontMetrics(gs.getFont()).charsWidth(fontString.toCharArray(),0,fontString.length());
    }
    
    public static BufferedImage toBufferedImage(BitMatrix matrix){  
        int width = matrix.getWidth();  
        int height = matrix.getHeight();  
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_3BYTE_BGR);  
          
        for(int x=0;x<width;x++){  
            for(int y=0;y<height;y++){  
                image.setRGB(x, y, matrix.get(x, y) ? BLACK : WHITE);  
            }  
        }  
        return image;     
    }
    
    
    
    private static final String CHARSET = "utf-8";
	private static final String FORMAT = "JPG";
	// 二维码尺寸
	private static final int QRCODE_SIZE = 300;
	// LOGO宽度
	private static final int LOGO_WIDTH = 60;
	// LOGO高度
	private static final int LOGO_HEIGHT = 60;
 
	private static BufferedImage createImage(String content, String logoPath, boolean needCompress) throws Exception {
		Hashtable<EncodeHintType, Object> hints = new Hashtable<EncodeHintType, Object>();
		hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);
		hints.put(EncodeHintType.CHARACTER_SET, CHARSET);
		hints.put(EncodeHintType.MARGIN, 1);
		BitMatrix bitMatrix = new MultiFormatWriter().encode(content, BarcodeFormat.QR_CODE, QRCODE_SIZE, QRCODE_SIZE,
				hints);
		int width = bitMatrix.getWidth();
		int height = bitMatrix.getHeight();
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				image.setRGB(x, y, bitMatrix.get(x, y) ? 0xFF000000 : 0xFFFFFFFF);
			}
		}
		if (logoPath == null || "".equals(logoPath)) {
			return image;
		}
		// 插入图片
		QRUtils.insertImage(image, logoPath, needCompress);
		return image;
	}
 
	/**
	 * 插入LOGO
	 * 
	 * @param source
	 *            二维码图片
	 * @param logoPath
	 *            LOGO图片地址
	 * @param needCompress
	 *            是否压缩
	 * @throws Exception
	 */
	private static void insertImage(BufferedImage source, String logoPath, boolean needCompress) throws Exception {
		File file = new File(logoPath);
		if (!file.exists()) {
			throw new Exception("logo file not found.");
		}
		Image src = ImageIO.read(new File(logoPath));
		int width = src.getWidth(null);
		int height = src.getHeight(null);
		if (needCompress) { // 压缩LOGO
			if (width > LOGO_WIDTH) {
				width = LOGO_WIDTH;
			}
			if (height > LOGO_HEIGHT) {
				height = LOGO_HEIGHT;
			}
			Image image = src.getScaledInstance(width, height, Image.SCALE_SMOOTH);
			BufferedImage tag = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
			Graphics g = tag.getGraphics();
			g.drawImage(image, 0, 0, null); // 绘制缩小后的图
			g.dispose();
			src = image;
		}
		// 插入LOGO
		Graphics2D graph = source.createGraphics();
		int x = (QRCODE_SIZE - width) / 2;
		int y = (QRCODE_SIZE - height) / 2;
		graph.drawImage(src, x, y, width, height, null);
		Shape shape = new RoundRectangle2D.Float(x, y, width, width, 6, 6);
		graph.setStroke(new BasicStroke(3f));
		graph.draw(shape);
		graph.dispose();
	}
 
	/**
	 * 生成二维码(内嵌LOGO)
	 * 二维码文件名随机
	 * 
	 * @param content
	 *            内容
	 * @param logoPath
	 *            LOGO地址
	 * @param destPath
	 *            存放目录
	 * @param needCompress
	 *            是否压缩LOGO
	 * @throws Exception
	 */
	public static String encode(String content, String logoPath, String destPath, boolean needCompress) throws Exception {
		BufferedImage image = QRUtils.createImage(content, logoPath, needCompress);
		mkdirs(destPath);
		String fileName = UUID.randomUUID().toString();
		ImageIO.write(image, FORMAT, new File(destPath + "/" + fileName));
		return fileName;
	}
	
	/**
	 * 生成二维码(内嵌LOGO)
	 * 调用者指定二维码文件名
	 * 
	 * @param content
	 *            内容
	 * @param logoPath
	 *            LOGO地址
	 * @param destPath
	 *            存放目录
	 * @param fileName
	 *            二维码文件名
	 * @param needCompress
	 *            是否压缩LOGO
	 * @throws Exception
	 */
	public static String encode(String content, String logoPath, String destPath, String fileName, boolean needCompress) throws Exception {
		BufferedImage image = QRUtils.createImage(content, logoPath, needCompress);
		mkdirs(destPath);
		fileName = fileName.substring(0, fileName.indexOf(".")>0?fileName.indexOf("."):fileName.length()) 
				+ "." + FORMAT.toLowerCase();
		ImageIO.write(image, FORMAT, new File(destPath + "/" + fileName));
		return fileName;
	}
 
	/**
	 * 当文件夹不存在时，mkdirs会自动创建多层目录，区别于mkdir．
	 * (mkdir如果父目录不存在则会抛出异常)
	 * @param destPath
	 *            存放目录
	 */
	public static void mkdirs(String destPath) {
		File file = new File(destPath);
		if (!file.exists() && !file.isDirectory()) {
			file.mkdirs();
		}
	}
 
	/**
	 * 生成二维码(内嵌LOGO)
	 * 
	 * @param content
	 *            内容
	 * @param logoPath
	 *            LOGO地址
	 * @param destPath
	 *            存储地址
	 * @throws Exception
	 */
	public static String encode(String content, String logoPath, String destPath) throws Exception {
		return QRUtils.encode(content, logoPath, destPath, false);
	}
 
	/**
	 * 生成二维码
	 * 
	 * @param content
	 *            内容
	 * @param destPath
	 *            存储地址
	 * @param needCompress
	 *            是否压缩LOGO
	 * @throws Exception
	 */
	public static String encode(String content, String destPath, boolean needCompress) throws Exception {
		return QRUtils.encode(content, null, destPath, needCompress);
	}
 
	/**
	 * 生成二维码
	 * 
	 * @param content
	 *            内容
	 * @param destPath
	 *            存储地址
	 * @throws Exception
	 */
	public static String encode(String content, String destPath) throws Exception {
		return QRUtils.encode(content, null, destPath, false);
	}
 
	/**
	 * 生成二维码(内嵌LOGO)
	 * 
	 * @param content
	 *            内容
	 * @param logoPath
	 *            LOGO地址
	 * @param output
	 *            输出流
	 * @param needCompress
	 *            是否压缩LOGO
	 * @throws Exception
	 */
	public static void encode(String content, String logoPath, OutputStream output, boolean needCompress)
			throws Exception {
		BufferedImage image = QRUtils.createImage(content, logoPath, needCompress);
		ImageIO.write(image, FORMAT, output);
	}
 
	/**
	 * 生成二维码
	 * 
	 * @param content
	 *            内容
	 * @param output
	 *            输出流
	 * @throws Exception
	 */
	public static void encode(String content, OutputStream output) throws Exception {
		QRUtils.encode(content, null, output, false);
	}
 
	/**
	 * 解析二维码
	 * 
	 * @param file
	 *            二维码图片
	 * @return
	 * @throws Exception
	 */
	public static String decode(File file) throws Exception {
		BufferedImage image;
		image = ImageIO.read(file);
		if (image == null) {
			return null;
		}
		BufferedImageLuminanceSource source = new BufferedImageLuminanceSource(image);
		BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));
		Result result;
		Hashtable<DecodeHintType, Object> hints = new Hashtable<DecodeHintType, Object>();
		hints.put(DecodeHintType.CHARACTER_SET, CHARSET);
		result = new MultiFormatReader().decode(bitmap, hints);
		String resultStr = result.getText();
		return resultStr;
	}
 
	/**
	 * 解析二维码
	 * 
	 * @param path
	 *            二维码图片地址
	 * @return
	 * @throws Exception
	 */
	public static String decode(String path) throws Exception {
		return QRUtils.decode(new File(path));
	}
 
	public static void main(String[] args) throws Exception {
		String text = "http://www.baidu.com";
		//不含Logo
		QRUtils.encode(text, null, "e:\\", true);
		//含Logo，不指定二维码图片名
		//QRUtils.encode(text, "e:\\csdn.jpg", "e:\\", true);
		//含Logo，指定二维码图片名
		QRUtils.encode(text, "e:\\csdn.jpg", "e:\\", "qrcode", true);
	}

	
}
