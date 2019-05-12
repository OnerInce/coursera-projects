#include <algorithm>
#include <iostream>
#include <vector>
#include <sys/resource.h>
#include <bits/stdc++.h> 

using namespace std; 
  
struct Node { 
    int key; 
    vector<Node*> child; 
}; 
  
Node* newNode(int value) 
{ 
    Node* newNode = new Node; 
    newNode->key = value; 
    return newNode; 
}

void addChild(Node* parentNode, Node* childNode){

	(parentNode->child).push_back(childNode);

}

int getMax(int y, int m){

	if(y > m) return y;
	else return m;

}

Node* createTree(int* myInput, Node** nodeArray, int numberOf){

	Node* root = new Node;
	int i, parentIndex;
	for(i = 0; i < numberOf; i++){
	
		parentIndex = myInput[i];
		
		if(parentIndex == -1){
			
			nodeArray[i]->key = i;
			root = nodeArray[i];
		
		}
		
		else{
			
			nodeArray[i]->key = i;
			addChild(nodeArray[parentIndex], nodeArray[i]);
		
		}
	}
	
	return root;
}

void printTree(Node * root){

	int vectorSize = root->child.size(), i;
	
	for(i = 0; i < vectorSize; i++){
	
		printf("%d", root->child[i]->key);
	
	}
	
	printf("\n");
	
	for(i = 0; i < vectorSize; i++){

		printTree((root->child[i]));
	
	}
	
}

int getHeight(Node* root){

	int height = 0;
	
	if(root == NULL) return 0;
	
	int vectorSize = root->child.size(), i;
	
	for(i = 0; i < vectorSize; i++){
	
		height = getMax(height, getHeight(root->child[i]));
	
	}
	
	return height+1;

}

int main(){
	
	int i, inputNumber, *inputArray;
	
	Node** nodeArray;
	
	scanf("%d", &inputNumber);
	
	inputArray = (int*)malloc(inputNumber * sizeof(int));
	nodeArray = (Node**)malloc(inputNumber * sizeof(Node*));
	
	for(i = 0; i < inputNumber; i++){
	
		scanf("%d", &inputArray[i]);
		nodeArray[i] = newNode(inputArray[i]);
	
	}
	
	Node* root = createTree(inputArray, nodeArray, inputNumber);
	
	printf("%d\n", getHeight(root));
		
	return 0;

}