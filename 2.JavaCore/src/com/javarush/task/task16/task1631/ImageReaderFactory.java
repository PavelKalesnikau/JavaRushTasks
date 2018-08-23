package com.javarush.task.task16.task1631;

import com.javarush.task.task16.task1631.common.*;

public class ImageReaderFactory {
    public static ImageReader getImageReader(ImageTypes imageType) throws IllegalArgumentException{

//        switch (imageType){
//            case BMP:
//                return new BmpReader();
//            case JPG:
//                return new JpgReader();
//            case PNG:
//                return new PngReader();
//            default:
//                throw new IllegalArgumentException();
//        }
        if (imageType == ImageTypes.BMP)
                return new BmpReader();
            else if (imageType == ImageTypes.JPG)
                return new JpgReader();
            else if(imageType == ImageTypes.PNG)
                return new PngReader();
            else  throw new IllegalArgumentException();
    }
}
