/**
 * This class contains class (static) methods
 * that will help you test the Picture class 
 * methods.  Uncomment the methods and the code
 * in the main to test.
 * 
 * @author Barbara Ericson 
 */
public class PictureTester
{
    /** Method to test zeroBlue */
    public static void testZeroBlue()
    {
        Picture beach = new Picture("beach.jpg");
        beach.explore();
        beach.zeroBlue();
        beach.explore();
    }

    public static void testKeepOnlyBlue()
    {
        Picture beach = new Picture("beach.jpg");
        beach.explore();
        beach.keepOnlyBlue();
        beach.explore();
    }

    public static void testNegate()
    {
        Picture beach = new Picture("beach.jpg");
        beach.explore();
        beach.negate();
        beach.explore();
    }

    public static void testGrayscale()
    {
        Picture beach = new Picture("beach.jpg");
        beach.explore();
        beach.grayscale();
        beach.explore();
    }

    public static void testGrayscaleLum()
    {
        Picture beach = new Picture("beach.jpg");
        beach.explore();
        beach.grayscaleLum();
        beach.explore();
    }

    public static void testFixUnderwater()
    {
        Picture beach = new Picture("water.jpg");
        beach.explore();
        beach.fixUnderwater();
        beach.explore();
    }

    /** Method to test mirrorVertical */
    public static void testMirrorVertical()
    {
        Picture caterpillar = new Picture("caterpillar.jpg");
        caterpillar.explore();
        caterpillar.mirrorVertical();
        caterpillar.explore();
    }

    public static void testMirrorHorizontal()
    {
        Picture caterpillar = new Picture("redMotorcycle.jpg");
        caterpillar.explore();
        caterpillar.mirrorHorizontal();
        caterpillar.explore();
    }

    public static void testDiagonal()
    {
        Picture caterpillar = new Picture("beach.jpg");
        caterpillar.explore();
        caterpillar.mirrorDiagonal();
        caterpillar.explore();
    }

    public static void testMirrorHorizontalBotToTop()
    {
        Picture caterpillar = new Picture("redMotorcycle.jpg");
        caterpillar.explore();
        caterpillar.mirrorHorizontalBotToTop();
        caterpillar.explore();
    }

    public static void testMirrorVerticalRightToLeft()
    {
        Picture caterpillar = new Picture("caterpillar.jpg");
        caterpillar.explore();
        caterpillar.mirrorVerticalRightToLeft();
        caterpillar.explore();
    }

    /** Method to test mirrorTemple */
    public static void testMirrorTemple()
    {
        Picture temple = new Picture("temple.jpg");
        temple.explore();
        temple.mirrorTemple();
        temple.explore();
    }

    public static void testMirrorSnowman()
    {
        Picture temple = new Picture("snowman.jpg");
        temple.explore();
        temple.mirrorSnowman();
        temple.explore();
    }


    public static void testMirrorSeagull()
    {
        Picture temple = new Picture("seagull.jpg");
        temple.explore();
        temple.mirrorSeagull();
        temple.explore();
    }

    /** Method to test the collage method */
    public static void testCollage()
    {
        Picture canvas = new Picture("640x480.jpg");
        canvas.createCollage();
        canvas.explore();
    }

    /** Method to test edgeDetection */
    public static void testEdgeDetection()
    {
        Picture swan = new Picture("swan.jpg");
        swan.edgeDetection(10);
        swan.explore();
    }

    public static void testCropAndCopy()
    {
        Picture picture1 = new Picture("swan.jpg");
        Picture picture2 = new Picture("beach.jpg");
        picture2.cropAndCopy( picture1, 10, 100, 20, 200, 30, 40 );
        picture2.explore();
    }

    public static void testScaleDownRemPix()
    {
        Picture swan = new Picture("swan.jpg");
        swan.scaleDownRemPix(0.9);
        swan.explore();
    }

    /** Main method for testing.  Every class can have a main
     * method in Java */
    public static void main(String[] args)
    {
        Picture canvas = new Picture(750,900);
        Picture orig = new Picture("space.jpg");
        Picture inter = new Picture(375,450);//intermediate picture
        Picture mod = new Picture(375,450);//modified picture
        canvas.cropAndCopy(orig, 25, 525, 125, 725, 0,0);//crop out a resizeable chunk
        canvas.scaleDownRemPix(0.75);//scale it down
        
        
        canvas.makeStatic(50);
        inter.cropAndCopy(canvas, 0,375,0,450,0,0);
        
        mod.copy(inter,0,0);
        mod.posterize(4);
        mod.mirrorVertical();
        canvas.copy(mod,0,0);
        
        mod.copy(inter, 0,0);
        mod.sepia();
        mod.posterize(6);
        mod.mirrorVerticalRightToLeft();
        canvas.copy(mod,0,450);
        
        mod.copy(inter,0,0);
        mod.grayscaleLum();
        mod.posterize(8);
        mod.mirrorVerticalRightToLeft();
        canvas.copy(mod,375,0);
        
        mod.copy(inter,0,0);
        mod.negate();
        mod.posterize(8);
        mod.mirrorVertical();
        canvas.copy(mod,375,450);
        
        canvas.explore();
        canvas.write("MyCollage.jpg");
    }
}