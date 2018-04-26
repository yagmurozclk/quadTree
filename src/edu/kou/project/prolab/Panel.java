package edu.kou.project.prolab;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Ellipse2D;


import javax.swing.JPanel;

public class Panel extends JPanel implements MouseListener,MouseMotionListener {

    private int width, height;

    int rows;
    int cols;
    int nodeWidth, nodeHeight;
    int margin = 10;

    Node nodeAdded = null;

    NodeTree nodeTree;
    boolean isCircleVisible=false;

    Point circlePoint;
    Point endPoint;

    Panel(int width, int height) {
        setBounds(1, 1, width, height);
        addMouseListener(this);
        addMouseMotionListener(this);
        nodeTree = new NodeTree();
    }

    public void drawCenteredCircle(Graphics2D g, int x, int y, int r) {
        x = x-(r/2);
        y = y-(r/2);
        g.fillOval(x,y,r,r);

    }

    private void drawPoint(Node node, Graphics g) {
        drawCenteredCircle((Graphics2D) g, node.getX(), node.getY(), 7);
    }

    private void drawPoint(Node node, Graphics g,Color color) {
        g.setColor(color);
        drawCenteredCircle((Graphics2D) g, node.getX(), node.getY(), 7);
    }

    void drawNodeTree(Node node, Graphics g) {
        if (node != null) {
            g.setColor(Color.blue);
            //g.drawLine(node.getX(), node.getY(), node.getX(), node.getY());
            drawPoint(node,g);
//            System.out.println("Nokta " + node.getX() +":"+ node.getY());
            g.drawLine(node.getX(), (int) node.getRegion().getY(), node.getX(), (int) node.getRegion().getY() + node.getRegion().height);
//            System.out.println("line " + node.getX() +":"+ (int) node.getRegion().getY()+"->"+node.getX() +":"+node.getRegion().height);
            g.drawLine((int) node.getRegion().getX(), node.getY(), (int) node.getRegion().getX() + node.getRegion().width, node.getY());
//            System.out.println("line " + (int) node.getRegion().getX() +":"+ node.getY()+"->"+node.getRegion().width +":"+node.getY());
//            g.setColor(Color.red);
//            if(node.region0!=null) g.drawRect((int)node.region0.getX(),(int)node.region0.getY(),(int)node.region0.getWidth(),(int)node.region0.getHeight());
//            if(node.region1!=null) g.drawRect((int)node.region1.getX(),(int)node.region1.getY(),(int)node.region1.getWidth(),(int)node.region1.getHeight());
//            if(node.region2!=null) g.drawRect((int)node.region2.getX(),(int)node.region2.getY(),(int)node.region2.getWidth(),(int)node.region2.getHeight());
//            if(node.region3!=null) g.drawRect((int)node.region3.getX(),(int)node.region3.getY(),(int)node.region3.getWidth(),(int)node.region3.getHeight());
//            g.setColor(Color.blue);
            drawNodeTree(node.getNode0(), g);
            drawNodeTree(node.getNode1(), g);
            drawNodeTree(node.getNode2(), g);
            drawNodeTree(node.getNode3(), g);
        }
        //this.repaint();


    }


//    void drawNodeTree(Node node, Graphics g) {
//        if (node != null) {
//            g.setColor(Color.blue);
//            drawPoint(node,g);
//
////            if(node.region0!=null) g.drawRect((int)node.region0.getX(),(int)node.region0.getY(),(int)node.region0.getWidth(),(int)node.region0.getHeight());
////            if(node.region1!=null) g.drawRect((int)node.region1.getX(),(int)node.region1.getY(),(int)node.region1.getWidth(),(int)node.region1.getHeight());
////            if(node.region2!=null) g.drawRect((int)node.region2.getX(),(int)node.region2.getY(),(int)node.region2.getWidth(),(int)node.region2.getHeight());
////            if(node.region3!=null) g.drawRect((int)node.region3.getX(),(int)node.region3.getY(),(int)node.region3.getWidth(),(int)node.region3.getHeight());
//
//        }
//
//
//    }


    public void paint(Graphics g) {


        drawNodeTree(nodeTree.getRoot(), g);
        if(!this.nodeTree.getCircleNodes().isEmpty()){
            for(Node node : this.nodeTree.getCircleNodes()){
                drawPoint(node,this.getGraphics(),Color.green);
            }
        }
          /*
          Graphics2D g2d = (Graphics2D) g;
		  
		  g2d.setColor(Color.orange);
		  g2d.drawLine(3, 5, 40, 45);
		   */
    }

    private void drawCircle(Point endPoint,int radius,Graphics g) {


        drawCircle(g,(int)circlePoint.getX(),(int)circlePoint.getY(),radius);
        //g.drawOval(circleX,circleY,((int)endPoint.getX())-circleX,((int)endPoint.getY())-circleY);
        this.update(g);
       // this.repaint();
    }

    double distance(double x1, double y1, double x2, double y2)
    {
        return Math.sqrt((x2-x1)*(x2-x1) + (y2-y1)*(y2-y1));

    }

    public void drawCircle(Graphics g, int xCenter, int yCenter, int r) {
        g.drawOval(xCenter-r, yCenter-r, 2*r, 2*r);
    }




    @Override
    public void mouseClicked(MouseEvent e) {
        // TODO Auto-generated method stub
        //this.removeAll();
        Node node = new Node();
        node.setX(e.getX());
        node.setY(e.getY());
        nodeTree.addNode(node);

//        drawNodeTree(nodeTree.getRoot(), this.getGraphics());
        System.out.println(e.getX() + " " + e.getY());
        System.out.println("mouse clicked");
        this.update(this.getGraphics());
    }


    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub
//        System.out.println("mouse mouseEntered");

    }


    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub
//        System.out.println("mouse mouseExited");
    }


    @Override
    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub
        System.out.println("mouse mousePressed");
        circlePoint = new Point(e.getX(),e.getY());
        isCircleVisible=false;
    }


    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub
//        System.out.println("mouse mouseReleased");
        if(isCircleVisible){
            int r = (int)distance(circlePoint.getX(),circlePoint.getY(),endPoint.getX(),endPoint.getY());
            this.nodeTree.getCircleNodes().clear();
            nodeTree.findInCircle(circlePoint,r,this.nodeTree.getRoot());

        }
        //this.repaint();
        this.update(this.getGraphics());
    }



    @Override
    public void mouseDragged(MouseEvent e) {
        System.out.println(e.getX() +" "+ e.getY());

        super.paintComponent(this.getGraphics());//this.removeAll();
        endPoint = new Point(e.getX(),e.getY());
        int r = (int)distance(circlePoint.getX(),circlePoint.getY(),endPoint.getX(),endPoint.getY());
        drawCircle(endPoint,r,this.getGraphics());
        isCircleVisible=true;
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        //System.out.println(e.getX() +" "+ e.getY());
    }
}
