package com.kademika.tanks.bf;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Pictures {
    Image imageBlank;
    Image imageBrick;
    Image imageRock;
    Image imageWater;

//    Image imageT34;
//    Image imageBT7;
//    Image imageTiger;
//
//    Image imageBullet;

    public Pictures() {
        try {
            imageBlank = ImageIO.read(new File("Blank.jpg").getAbsoluteFile());
            imageBrick = ImageIO.read(new File("Brick.jpg").getAbsoluteFile());
            imageRock = ImageIO.read(new File("Rock.jpg").getAbsoluteFile());
            imageWater = ImageIO.read(new File("Water.jpg").getAbsoluteFile());

//            imageT34 = ImageIO.read(new File("").getAbsoluteFile());
//            imageBT7 = ImageIO.read(new File("").getAbsoluteFile());
//            imageTiger = ImageIO.read(new File("").getAbsoluteFile());
//
//            imageBullet = ImageIO.read(new File("").getAbsoluteFile());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Image getImageBlank() {
        return imageBlank;
    }

    public Image getImageBrick() {
        return imageBrick;
    }

    public Image getImageRock() {
        return imageRock;
    }

    public Image getImageWater() {
        return imageWater;
    }

//    public Image getImageT34() {
//        return imageT34;
//    }
//
//    public Image getImageBT7() {
//        return imageBT7;
//    }
//
//    public Image getImageTiger() {
//        return imageTiger;
//    }
//
//    public Image getImageBullet() {
//        return imageBullet;
//    }
}
