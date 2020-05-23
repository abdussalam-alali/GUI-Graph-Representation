/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guigraphrepresentation;

import java.util.Scanner;
import java.util.Random;

/**
 *
 * @author samo
 */
public class Graph {
    private int [][]adjMat;
    private int type; // 0 for normal graph , anything else bipartite graph
    public Graph()
    {
        type=0;
        adjMat=new int[10][10];
        for(int i=0;i<10;i++)
        {
            for(int j=0;j<10;j++)
            {
                if(i==j)continue;
                Random r=new Random();
                adjMat[i][j]=r.nextInt(2);
            }
        }
    }
    public Graph(int a[][])
    {
        adjMat=a;
    }
    public int[][] getAdjMatrix()
    {
        return adjMat;
    }
    public int getType()
    {
        return type;
    }
    public void setType(int type)
    {
        this.type=type;
    }
    public void setAdjMatrix(int [][]adj)
    {
        adjMat=adj;
    }
    public void enterAdjMat()
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter nodes number");
        int n = sc.nextInt();
        adjMat=new int[n][n];
        System.out.println("Enter edges number");
        int e = sc.nextInt();
        System.out.println("Enter "+e+" edges (v,u) note that first node has the number 1");
        for(int i=0;i<e;i++)
        {
            int x,y;
            x=sc.nextInt();
            y=sc.nextInt();
            
            adjMat[x-1][y-1]=1;
            adjMat[y-1][x-1]=1;
        }
    }
    // your graph alogrithms goes here
}
