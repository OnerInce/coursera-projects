#include<iostream>
#include<fstream>
#include <string>
#include <cstring>
#include <stdlib.h>
#include <string.h>
#include <map>
#include <vector>
#include <algorithm>

#define SWAP(x,y) { x = x + y; y = x - y; x = x - y; }

using namespace std;

vector<int> output;

int leftChild(int index){ /* Return the index of the left child */

	return 2*index + 1;

}

int rightChild(int index){ /* Return the index of the right child */

	return 2*index + 2;

}

/* Check and swap elements from top to bottom in binary min heap */

void siftDown(int arr[], int index, int size){
	
	int left = leftChild(index), right = rightChild(index), minIndex = index;
	
	if(left < size && arr[left] < arr[minIndex]){
	
		minIndex = left;
	
	}
	
	if(right < size && arr[right] < arr[minIndex]){
	
		minIndex = right;
	
	}
	
	if( index != minIndex){

		(output[0])++;
		SWAP(arr[index], arr[minIndex]);
		output.push_back(index);
		output.push_back(minIndex);
		siftDown(arr, minIndex, size);
	
	}
}

/* Call siftDown function */

void makeHeap(int arr[],int size)
{
    int i;
    for(i = size/2; i >= 0; i--){
       
	   siftDown(arr,i,size);
	  
	}
}


int main(){

	int size, element, i;
	
	scanf("%d", &size);
	
	int* array = (int*)malloc(size * sizeof(int));
	
	for(i = 0; i < size; i++){
	
		scanf("%d", &element);
	
		array[i] = element;
	
	}
	
	output.push_back(0);
	makeHeap(array, size);
	
	printf("%d\n", output[0]);
	for(i = 1; i < output.size(); i = i + 2){
	
		printf("%d %d\n", output[i], output[i+1]);
	
	}
}
