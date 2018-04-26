package edu.kou.project.prolab;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class NodeTree {

	Node root;
	//List<Node> leaves = new ArrayList<Node>();
	
	
	
	List<Node> circleNodes = new ArrayList<Node>();

	public List<Node> getCircleNodes() {
		return circleNodes;
	}

	void addNode(Node node){
		
		if(root==null){
			root = new Node();
			root.setX(node.getX());
			root.setY(node.getY());
			root.setRegion(new Rectangle(0,0,512,512));

		}
		else{
			root.setChildNode(node);
		}
	}

	private List<Node> findChildren(Node node){
		List<Node> children = new ArrayList<Node>();

		if(node!=null){
			if(node.getNode0()!=null){
				children.add(node.getNode0());
			}
			if(node.getNode1()!=null){
				children.add(node.getNode1());
			}
			if(node.getNode2()!=null){
				children.add(node.getNode2());
			}
			if(node.getNode3()!=null){
				children.add(node.getNode3());
			}
		}

		return children;
	}

	public Node getRoot() {
		return root;
	}

	public void setRoot(Node root) {
		this.root = root;
	}


	public void findInCircle(Point circlePoint,int radius,Node node) {


		if(isInside(circlePoint,radius,new Point(node.getX(),node.getY()))){
			circleNodes.add(node);
		}

		for(Node nnode : findChildren(node)){
			findInCircle(circlePoint,radius,nnode);
		}

	}

	private boolean isInside(Point circlePoint, int radius, Point point) {

		if ((point.getX() - circlePoint.getX()) * (point.getX() - circlePoint.getX()) +
				(point.getY() - circlePoint.getY()) * (point.getY() - circlePoint.getY()) <= radius * radius)
			return true;
		else
			return false;
	}
}
