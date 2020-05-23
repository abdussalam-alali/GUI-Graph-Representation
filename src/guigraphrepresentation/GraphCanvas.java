package guigraphrepresentation;

import java.awt.*;
import java.util.Arrays;

public class GraphCanvas extends Canvas{
    
    public int [][]adjMatrixTemp;
    public int n;
    public int type;
    final int c0=650;
    final int c1=400;
    final int r0=300;
    point[] GraphPoints;
    int r2;
    
    public GraphCanvas(int [][]a,int n,int type){
        this.setBackground(Color.white);
        this.setSize(1500,750);
        this.n=n;
        GraphPoints=new point[n];
        this.type=type;
        adjMatrixTemp=a;
        
        if(type==0){
            if(n>=80){
                r2=18;
            }
            else if(n>=55){
                r2=20;
            }
            else if(n>=40){
                r2=30;
            }
            else{
                r2=40;
            }
            normalGraph();
        }
        else{
            if(n>=80){
                r2=20;
            }
            else if(n>=60){
                r2=30;
            }
            else{
                r2=40;
            }
            biGraph();
        }
        
        
    }
    

    @Override
    public void paint(Graphics graphics) {
        graphics.setColor(Color.BLACK);
                for(int i=0;i<n;i++){
                    for(int j=i+1;j<n;j++){
                        if (adjMatrixTemp[i][j]==1){
                            graphics.drawLine((int) GraphPoints[i].x,(int) GraphPoints[i].y,(int) GraphPoints[j].x,(int) GraphPoints[j].y);
                        }
                    }
                }
                
                
                for(int i=0;i<n;i++){
                    graphics.setColor(Color.BLACK);
                    graphics.fillOval((int) GraphPoints[i].x-(r2/2),(int) GraphPoints[i].y-(r2/2),r2,r2);
                    graphics.setColor(Color.WHITE);
                    graphics.drawString(i+1+"",(int) GraphPoints[i].x-7,(int) GraphPoints[i].y+4);
                }
             
    }
    
    public final void normalGraph(){
        for(int i=0;i<n;i++){
            double theta=360*i/n;
            double radian=Math.toRadians(theta);
            GraphPoints[i]=new point(c0+r0*Math.cos(radian),c1+r0*Math.sin(radian));
        }
    }

    public final void biGraph(){
        double z=2500/n;
        for(int i=0;i<n/2;i++){
            GraphPoints[i]=new point(100+z*i,200);
            GraphPoints[i+n/2]=new point(100+z*i,600);
        }
    }
}
class point{
    double x,y;
    public point()
    {
        x=0;
        y=0;
    }
    public point(double x,double y)
    {
        this.x=x;
        this.y=y;
    }
}