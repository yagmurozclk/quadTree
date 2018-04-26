package edu.kou.project.prolab;

import java.awt.Point;
import java.awt.Rectangle;

public class Node {
	
	
	int X;
	int Y;
	Rectangle region;
	
	
	Node node0;
	Node node1;
	Node node2;
	Node node3;

	public Rectangle region0;
	public Rectangle region1;
	public Rectangle region2;
	public Rectangle region3;

	void setChildNode(Node node){
		
		region0 = new Rectangle((int)region.getX(),(int)region.getY(), X-(int)region.getX(),Y-(int)region.getY());
		region1 = new Rectangle(X,(int)region.getY(),region.width - (X-(int)region.getX()),Y-(int)region.getY());
		region2 = new Rectangle((int)region.getX(),Y, X-(int)region.getX() ,region.height - (Y-(int)region.getY()));
		region3 = new Rectangle( X ,Y,region.width - (X-(int)region.getX()) ,region.height - (Y-(int)region.getY()));



		if(region0.contains(new Point(node.getX(),node.getY()))){
			if(node0==null){
				node0  = new Node();
				node0.setX(node.getX());
				node0.setY(node.getY());
				node0.setRegion(region0);
			}
			else{
				node0.setChildNode(node);
			}
		}

		if(region1.contains(new Point(node.getX(),node.getY()))){
			if(node1==null){
				node1  = new Node();
				node1.setX(node.getX());
				node1.setY(node.getY());
				node1.setRegion(region1);
			}
			else{
				node1.setChildNode(node);
			}
		}

		if(region2.contains(new Point(node.getX(),node.getY()))){
			if(node2==null){
				node2  = new Node();
				node2.setX(node.getX());
				node2.setY(node.getY());
				node2.setRegion(region2);
			}
			else{
				node2.setChildNode(node);
			}
		}

		if(region3.contains(new Point(node.getX(),node.getY()))){
			if(node3==null){
				node3  = new Node();
				node3.setX(node.getX());
				node3.setY(node.getY());
				node3.setRegion(region3);
			}
			else{
				node3.setChildNode(node);
			}
		}
		
	}
	
	public int getX() {
		return X;
	}
	public void setX(int x) {
		X = x;
	}
	public int getY() {
		return Y;
	}
	public void setY(int y) {
		Y = y;
	}
	public Rectangle getRegion() {
		return region;
	}
	public void setRegion(Rectangle region) {
		this.region = region;
	}
	public Node getNode0() {
		return node0;
	}
	public void setNode0(Node node0) {
		this.node0 = node0;
	}
	public Node getNode1() {
		return node1;
	}
	public void setNode1(Node node1) {
		this.node1 = node1;
	}
	public Node getNode2() {
		return node2;
	}
	public void setNode2(Node node2) {
		this.node2 = node2;
	}
	public Node getNode3() {
		return node3;
	}
	public void setNode3(Node node3) {
		this.node3 = node3;
	}
	
	
	
	
}
