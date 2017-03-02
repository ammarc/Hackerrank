#include <math.h> 

#include <stdio.h> 

#include <string.h> 

#include <stdlib.h> 

#include <assert.h> 

#include <limits.h> 

#include <stdbool.h> 

  

int is_not_recurring (char* s, int len); 

  

int main () 

{ 

    int len, max = 0;  

    scanf("%d",&len); 

    char* alpha = (char *) malloc (26 * sizeof(char)); 

    char* s = (char *) malloc (512000 * sizeof(char)); 

    scanf("%s",s); 

     

    // Now let us create the alphabet array 

    for (int i = 0; i < 26; i++) 

    { 

        alpha[i] =  97 + i; 

    } 

     

    // Let us go through the array 

    for (int i = 0; i < 26; i++) 

    { 

        for (int j = 0; j < 26; j++) 

        { 

            // Now we need to create a string with only 2 chars 

            int count = 0; 

            char* alter = (char *) malloc (len * sizeof(char)); 

            for (int k = 0; k < len; k++) 

            { 

                if (alpha[j] == s[k] || alpha[i] == s[k]) 
                { 
                    alter[count] = s[k]; 
                    count++; 
                    
                }
                
                alter[count] = '\0';
                
            } 
             
            
            
            // Now check validity of the created string and update max 

            if (is_not_recurring (alter, count)) 
            { 
                if (count > max && count > 1) 
                { 
                    max = count;
             
                } 
            } 
        } 
    } 

    printf("%d", max); 

    return 0; 
} 

  

int is_not_recurring (char* s, int len) 

{ 

    for (int k = 0; k < (len - 1); k++) 

    { 

        if (s[k] == s[k + 1]) 

        { 
      

            return 0; 

        } 

    } 

    return 1; 

} 

 