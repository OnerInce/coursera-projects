#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef struct Stack{

	int top;
	unsigned capacity;
	int* array;

}Stack;

Stack* createStack(unsigned capacity){

	Stack* myStack = (Stack*)malloc(sizeof(Stack));
	myStack->top = -1;
	myStack->capacity = capacity;
	myStack->array = (int*) malloc(sizeof(int) * capacity);
	
	return myStack;

}

void push(int data,Stack* myStack){

	myStack->array[++myStack->top] = data;

}

int pop(Stack* myStack){
	
	return myStack->array[myStack->top--];

}

int top(Stack* myStack){
	
	return myStack->array[myStack->top];

}

int main(){
	
	int commandNumber,i;
	char command[10];
	char commandData[5];
	
	scanf("%d", &commandNumber);
	
	Stack* myStack = createStack(commandNumber);
	Stack* myHelperStack = createStack(commandNumber);
	
	for(i = 0; i < commandNumber; i++){
	
		scanf("%s", command);
		if(command[1] == 'u'){
		
		scanf("%s", &commandData);
		
		push(atoi(commandData), myStack);
		
		if(top(myHelperStack) <= atoi(commandData)){push(atoi(commandData),myHelperStack);}
		
		}
		else if(command[1] == 'o'){
		
		if(top(myHelperStack) == top(myStack)){pop(myHelperStack);}
		pop(myStack);
		
		}
		else if(command[1] == 'a'){printf("%d\n", top(myHelperStack));}
		
	
	}
	
	return 0;	
	
}