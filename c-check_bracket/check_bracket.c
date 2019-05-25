#include <stdio.h>
#include <stdlib.h>

#define MAX_SIZE 100000

typedef struct Bracket{

    char bracket;
    int location;

}Bracket;

typedef struct BracketStack{

    int top;
    Bracket* stackArray;

}BracketStack;

void push(Bracket element, BracketStack* myStack){

    myStack->stackArray[++myStack->top] = element;

}

int isEmpty(BracketStack* myStack){

    return myStack->top == -1;

}

Bracket pop(BracketStack* myStack){

    if(!isEmpty(myStack)){

        return myStack->stackArray[myStack->top--];

    }

}

BracketStack* createStack(unsigned capacity){

    BracketStack * stack = (BracketStack*)malloc(sizeof(BracketStack));

    stack->top = -1;

    stack->stackArray = (Bracket*)malloc(capacity * sizeof(Bracket));

    return stack;

}

int isBalanced(char str[], BracketStack* myStack){

        int i, myLength = strlen(str);

        for(i = 0; i < myLength; i++){

            char currentBracket = str[i];
            Bracket myBracket;
            myBracket.location = i;
            myBracket.bracket = str[i];

            if(str[i] == '(' || str[i] == '{' || str[i] == '['){push(myBracket, myStack);} // If it is a opening bracket push to stack
            
			else if(str[i] == ')' || str[i] == '}' || str[i] == ']'){ // If it is a closing bracket pop from the stack

                if(isEmpty(myStack)){return (i + 1);}

                Bracket poppedBracket = pop(myStack);
				
				// Check for whether balanced or not

                if((poppedBracket.bracket == '(' && currentBracket != ')') || (poppedBracket.bracket == '[' && currentBracket != ']') ||

                   (poppedBracket.bracket == '{' && currentBracket != '}')

                   ){return (i + 1);}

            }

        }

        if(isEmpty(myStack)){return -1;}

        Bracket popped = pop(myStack);

        return popped.location + 1;

}

int main()
{
    char inputString [MAX_SIZE];

    scanf("%s", inputString);

    BracketStack* myStack =  createStack(strlen(inputString));

    int returnValue = isBalanced(inputString, myStack);

    if (returnValue == -1){printf("Success");}

    else if (returnValue != -1){printf("%d", returnValue);}


    return 0;
}
