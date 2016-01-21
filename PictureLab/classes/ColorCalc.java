import java.awt.Color;
/**
 * Write a description of class ColorCalc here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ColorCalc
{
    // instance variables - replace the example below with your own
    private Color color1=null,color2=null,color3=null,color4=null;
    int numColors=0;

    /**
     * Constructor for objects of class ColorCalc
     */
    public ColorCalc(Color color)
    {
        this.color1=color;
        numColors=1;
    }

    public ColorCalc(Color color, Color color1)
    {
        this.color1=color;
        this.color2=color1;
        numColors=2;
    }

    public ColorCalc(Color color, Color color1, Color color2)
    {
        this.color1=color;
        this.color2=color1;
        this.color3=color2;
        numColors=3;
    }

    public ColorCalc(Color color, Color color1, Color color2, Color color3)
    {
        this.color1=color;
        this.color2=color1;
        this.color3=color2;
        this.color4=color3;
        numColors=4;
    }

    public Color negate()
    {
        if(color2!=null)
        {
            System.out.println("Too many colors!");
            return null;
        }
        return new Color(255-color1.getRed(),255-color1.getGreen(),255-color1.getBlue());
    }
    public Color sepia()
    {
        if(color2!=null)
        {
            System.out.println("Too many colors!");
            return null;
        }
        int inputRed = color1.getRed(), inputGreen = color1.getGreen(), inputBlue = color1.getBlue();
        int outputRed = (int)((inputRed * .393) + (inputGreen *.769) + (inputBlue * .189)), outputGreen = (int)((inputRed * .349) + (inputGreen *.686) + (inputBlue * .168)), outputBlue = (int)((inputRed * .272) + (inputGreen *.534) + (inputBlue * .131));
        if(outputRed>255)outputRed=255;
        if(outputGreen>255)outputGreen=255;
        if(outputBlue>255)outputBlue=255;
        return new Color(outputRed, outputGreen, outputBlue);
    }
    public Color modStatic(int range)
    {
        java.util.Random rnd = new java.util.Random();
        if(color2!=null)
        {
            System.out.println("Too many colors!");
            return null;
        }
        int s = rnd.nextInt(range);
        int[] color = {color1.getRed()+s-range/2,color1.getGreen()+s-range/2,color1.getBlue()+s-range/2};
        for(int i = 0;i<color.length;i++)
        {   
            if(color[i]>255)color[i]=255;
            if(color[i]<0)color[i]=0;
        }
        return new Color(color[0],color[1],color[2]);
    
    }
    public Color posterize(int num)
    {
        int[] color = {color1.getRed(), color1.getGreen(), color1.getBlue()};
        for(int i = 0;i<color.length;i++)
        {   for(int j = 0;j<num;j++)
            {
                if((j-1)*(255/num)<color[i]&& color[i]<j*(255/num))color[i]=((j-1)*(255/num)+j*(255/num))/2;
            }
        }
        return new Color(color[0],color[1],color[2]);
    }
    public Color lumGrayScale()
    {
        if(color2!=null)
        {
            System.out.println("Too many colors!");
            return null;
        }
        int avg = (int)(color1.getRed()*0.21+color1.getGreen()*0.72+color1.getBlue()*0.07);
        return new Color(avg, avg, avg);
    }
    public Color avgGrayScale()
    {
        if(color2!=null)
        {
            System.out.println("Too many colors!");
            return null;
        }
        int avg = (color1.getGreen()+color1.getBlue()+color1.getRed())/3;
        return new Color(avg, avg, avg);
    }

    public Color averageColors()
    {
        if (color2==null)//1 color
        {
            return color1;
        }
        else if(color3==null)//2 colors
        {
            float[] comp1=null,comp2=null,avgComp=null;
            comp1 = color1.getColorComponents(comp1);
            comp2 = color2.getColorComponents(comp2);
            avgComp = new float[comp1.length];
            for(int i = 0; i<comp1.length;i++)
            {
                avgComp[i]=(comp1[i]+comp2[i])/numColors;
            }
            return new Color(avgComp[0], avgComp[1], avgComp[2], avgComp[3]);
        }
        else if(color4==null)//3 colors
        {
            float[] comp1=null,comp2=null,comp3=null,avgComp=null;
            comp1 = color1.getColorComponents(comp1);
            comp2 = color2.getColorComponents(comp2);
            comp3 = color3.getColorComponents(comp3);
            avgComp = new float[comp1.length];
            for(int i = 0; i<comp1.length;i++)
            {
                avgComp[i]=(comp1[i]+comp2[i]+comp3[i])/numColors;
            }
            return new Color(avgComp[0], avgComp[1], avgComp[2], avgComp[3]);
        }
        else//4 colors
        {
            float[] comp1=null,comp2=null,comp3=null,comp4=null,avgComp=null;
            comp1 = color1.getColorComponents(comp1);
            comp2 = color2.getColorComponents(comp2);
            comp3 = color3.getColorComponents(comp3);
            comp4 = color4.getColorComponents(comp4);
            avgComp = new float[comp1.length];
            for(int i = 0; i<comp1.length;i++)
            {
                avgComp[i]=(comp1[i]+comp2[i]+comp3[i]+comp4[i])/numColors;
            }
            return new Color(avgComp[0], avgComp[1], avgComp[2], avgComp[3]);
        }
    }

}
