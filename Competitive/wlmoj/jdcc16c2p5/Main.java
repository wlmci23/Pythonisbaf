import java.util.Scanner;

public class Main
{
    static double intersectArea(double r1,double r2,double dist)
    {
        //System.out.println(dist);
        double intersectX=(dist*dist+r1*r1-r2*r2)/2/dist;
        double intersectY=Math.sqrt(r1*r1-intersectX*intersectX);
        //System.out.printf("%f %f\n",intersectX,intersectY);
        double arcArea1=Math.asin(intersectY/r1)*r1*r1;
        double arcArea2=Math.asin(intersectY/r2)*r2*r2;
        double triangleArea1=intersectX*intersectY;
        double triangleArea2=(dist-intersectX)*intersectY;
        //System.out.printf("%f %f %f %f\n",arcArea1,arcArea2,triangleArea1,triangleArea2);
        return arcArea1-triangleArea1+arcArea2-triangleArea2;
    }
    public static void main(String[] args)
    {
        Scanner input=new Scanner(System.in);
        double x1=input.nextDouble(),y1=input.nextDouble(),r1=input.nextDouble();
        double x2=input.nextDouble(),y2=input.nextDouble(),r2=input.nextDouble();
        
        double dist=Math.sqrt(Math.pow(x2-x1,2)+Math.pow(y2-y1,2));
        double area=0;
        
        if(dist>=r1+r2) area=0;
        else if(r1>=r2&&dist<=r1-r2) area=r2*r2*Math.PI;
        else if(r1<=r2&&dist<=r2-r1) area=r1*r1*Math.PI;
        else area=intersectArea(r1,r2,dist);
        
        System.out.println(area);
    }
}
