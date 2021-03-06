package com.dental.Process;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.Size;
import org.opencv.imgproc.Imgproc;

public class PreProcessing {
	
	private Mat dest;
	private Mat original_Image;
	
	// Variables for adjusting image brightness
	private static double alpha = 1;
	private static double beta = -50;
	
	public PreProcessing(Mat image){
		this.original_Image = image;
	}
	
	// Image preprocessing method
	public Mat preProcessing(){
		
		dest = new Mat(original_Image.rows(),original_Image.cols(),original_Image.type());
		
		// Sharpened the image
		Imgproc.GaussianBlur(original_Image, dest, new Size(0,0),101);
		Core.addWeighted(original_Image, 1.5, dest, -0.5, 0, dest);
		
		// Adjust the image brightness 
		original_Image.convertTo(dest, -1, alpha, beta); 
		
		return dest;
		
	}
}
