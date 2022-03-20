package com.company.CH8;

import java.util.ArrayList;

// P-8.56
public class LinkedTree<E> {

    private class Node<E>{

        private Node<E> parent;
        private E element;
        private ArrayList<Node<E>> children;

        public Node(Node<E> parent, E element) {
            children = new ArrayList<>();
            this.parent = parent;
            this.element = element;
        }

        public void addChild(Node<E> child){
            children.add(child);
        }

        public boolean removeChild(Node<E> child){
            return children.remove(child);
        }

        public Node<E> getParent() {
            return parent;
        }

        public E getElement() {
            return element;
        }

        public ArrayList<Node<E>> getChildren() {
            return children;
        }

        public void setChildren(ArrayList<Node<E>> children) {
            this.children = children;
        }

        public void setElement(E element) {
            this.element = element;
        }

        public void setParent(Node<E> parent) {
            this.parent = parent;
        }
    }

    private Node<E> root;
    private int size;

    public LinkedTree(){
        size = 0;
    }

    public int numberOfChildren(Node<E> node){
        return node.getChildren().size();
    }

    public boolean isExternal(Node<E> node){
        return node.getChildren().size() == 0;
    }

    public boolean isInternal(Node<E> node){
        return node.getChildren().size() != 0;
    }

    public boolean isRoot(Node<E> node){
        return node.getParent() == null;
    }

    public Node<E> getParent(Node<E> node){
        return node.getParent();
    }

    public void setRoot(Node<E> root) {
        this.root.setParent(this.root.getParent());
        this.root = root;
    }

    public Node<E> getRoot() {
        return root;
    }

    public ArrayList<Node<E>> getChildren(Node<E> node){
        return node.getChildren();
    }

    public int size() {
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public int depth(Node<E> e){
        Node<E> node = e;
        int counter = 0;

        while (node.getParent() != null) {
            node = node.getParent();
            counter++;
        }

        return counter;
    }

}
