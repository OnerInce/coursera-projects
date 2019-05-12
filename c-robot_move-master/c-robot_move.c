#include <stdbool.h>
#include <string.h>
#include <stdio.h>
#include <stdlib.h>


int modulo(int x,int N){
    return (x % N + N) %N;
}

int FLR(char* input)
{
    char direction = NULL, currentChar;
    
    int i,myLength = strlen(input), rotate = 0, x = 0, y = 0, result = 0;
    
    for(i = 0; i < myLength; i++){
        
        currentChar = input[i];
        
        if(currentChar == 'R'){rotate = rotate + 90;}
        else if(currentChar == 'L'){rotate = rotate - 90;}
        else if(currentChar == 'F'){
            
            rotate = modulo(rotate, 360); // Find the direction which robot looking to
            
            switch(rotate){
                
                case 0:
                y++;
                direction = 'u';
                break;
                
                case 90:
                x++;
                direction = 'r';
                break;
                
                case 180:
                y--;
                direction = 'd';
                break;
                
                case 270:
                x--;
                direction = 'l';
                break;
                
            }
        }
        
    }
    
    // Go back to starting point according to final looking direction
    
    if(x != 0 && y != 0){
        
        if(direction == 'l' || direction == 'd'){
            
            result = abs(x) + abs(y) + 1;
            
        }
        
        else if(direction != 'l' && direction != 'd'){
            
            result = abs(x) + abs(y) + 2;
            
        }
        
    }
    
    else if(x != 0 && y == 0){
        
        if(direction == 'l'){result = abs(x);}
        else if(direction == 'r'){result = abs(x) + 2;}
        else if(direction == 'u'){result = abs(x) + 1;}
        else if(direction == 'd'){result = abs(x) + 1;}
    
    }
    
    else if(x == 0 && y != 0){
        
        if(direction == 'l'){result = abs(y) + 1;}
        else if(direction == 'r'){result = abs(y) + 1;}
        else if(direction == 'u'){result = abs(y) + 2;}
        else if(direction == 'd'){result = abs(y);}
        
    }
    
    return result;
}
