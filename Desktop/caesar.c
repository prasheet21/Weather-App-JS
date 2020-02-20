#include<stdio.h>
#include<cs50.h>
#include<string.h>
#include<ctype.h>
#include<stdlib.h>

int main(int argc , char *args[])
{

    int interm = 0 ;

    if(isalpha(args[1][0]) || isalpha(args[1][0]) isalpha(args[1][]))
    {
        printf("Usage: ./caesar key") ;
        return 1 ;
    }
    else if(argc == 1 || argc > 2)
    {
        printf("Usage: ./caesar key") ;
        return 1 ;
    }
    else
    {
        string plaintext = get_string("plaintext:  ") ;
        char result[strlen(plaintext)] ;
        int k = atoi(args[1]) ;

        for(int i = 0 ; i < strlen(plaintext) ; i++)
        {
            if(isalpha(plaintext[i]))
            {
                if(isupper(plaintext[i]))
                {
                    int asci = plaintext[i] ;
                    interm = ((asci - 65 + k) % 26 + 65) ;
                    result[i] = interm ;

                }
                if(islower(plaintext[i]))
                {
                    int asci = plaintext[i] ;
                    interm = ((asci - 97 + k) % 26 + 97) ;
                    result[i] = interm ;
                }
            }
            else
            {
                result[i] = plaintext[i] ;
            }
        }
        printf("ciphertext: %s \n" , result) ;
    }
    return 0 ;
}