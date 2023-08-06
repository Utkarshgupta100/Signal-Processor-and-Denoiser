#include <stdio.h>

int top=-1;int rear=-1;

void push(int temp[],int x){
    top =top+1;
    temp[top]=x;
}
int pop(int temp[]){
    return(temp[top]);
    top=top-1;
}

void enqueue(int temp[],int x){
    rear=rear+1;
    temp[rear]=x;
}


int main(){
    int n;
    int last;
    int z;


    printf("enter the number of students");
    scanf("%d",&n);

    int arr[n]; int que[n];

    for(int i=0;i<n;i++){
        scanf("%d",&arr[i]);
    }
    if(n%2==0){
        last=(n/2)-1;
    }
    else if(n%2==1){
        last=(n-1)/2-1;
    } 
    
    int stackarr[last];

    for(int i=0;i<=last;i++){
        push(stackarr,arr[i]);
    }

    for(int i=last;i>=0;i--){
        z=pop(stackarr);
        top--;
        enqueue(que,z);
    }

    for(int i=last+1;i<n;i++){
        enqueue(que,arr[i]);
    }

    for(int i=0;i<n;i++){
        printf("%d ",que[i]);
    }

    return 0;
    
}
