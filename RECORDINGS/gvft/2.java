// UJJAWAL UPADHYAY (B21MT038)
// INDIAN INTSITUTE OF TECHNOLOGY JODHPUR
// Created on 01.02.2023 
#include <stdio.h>
#include <stdlib.h>
#include <limits.h>
#define SIZE 1000000
//----------------------------------------------------------------//
int f = -1;
int r = -1;
//----------------------------------------------------------------//
struct Queue
{
	int front, rear, size;
	unsigned capacity;
	int *array;
};
//----------------------------------------------------------------//
struct Queue *createdeQueue(unsigned capacity)
{
	struct Queue *deque = (struct Queue *)malloc(
		sizeof(struct Queue));
	deque->capacity = capacity;
	deque->front = deque->size = 0;
	deque->rear = capacity - 1;
	deque->array = (int *)malloc(deque->capacity * sizeof(int));
	return deque;
}
//----------------------------------------------------------------//
// int isEmpty_(struct Queue* deque) { return (deque->size == 0); }
// int isFull(struct Queue* deque) { return (deque->size == deque->capacity); }
// int isEmpty_(struct Queue* deque) { return (deque->size == 0); }
void insert_at_beg(struct Queue *deque, int i)
{
	if (f == -1)
	{
		f = 0;
		deque->array[++r] = i;
	}
	else if (f != 0)
	{
		deque->array[--f] = i;
	}
}
//----------------------------------------------------------------//
void insert_at_end(struct Queue *deque, int i)
{
	if (r >= SIZE - 1)
	{
		;
	}
	else
	{
		if (f == -1)
		{
			f++;
			r++;
		}
		else
		{
			r = r + 1;
		}
		deque->array[r] = i;
	}
}
//----------------------------------------------------------------//
int isFull(struct Queue *deque) { return (deque->size == deque->capacity); }
int isEmpty_(struct Queue *deque) { return (deque->size == 0); }
//----------------------------------------------------------------//
int dequeue(struct Queue *deque)
{
	if (isEmpty_(deque))
		return INT_MIN;
	int item = deque->array[deque->front];
	deque->front = (deque->front + 1) % deque->capacity;
	deque->size = deque->size - 1;
	return item;
}
//----------------------------------------------------------------//
void enqueue(struct Queue *deque, int item)
{
	if (isFull(deque))
		return;

	deque->rear = (deque->rear + 1) % deque->capacity;
	deque->array[deque->rear] = item;
	deque->size = deque->size + 1;
}
//----------------------------------------------------------------//
void fr_rear()
{
	if (f == -1)
	{
		return;
	}
	else
	{
		if (f == r)
		{
			f = r = -1;
		}
		else
			r = r - 1;
	}
}
//----------------------------------------------------------------//

int front(struct Queue *deque)
{
	if (isEmpty_(deque))
		return INT_MIN;
	return deque->array[deque->front];
}
//----------------------------------------------------------------//
int rear(struct Queue *deque)
{
	if (isEmpty_(deque))
		return INT_MIN;
	return deque->array[deque->rear];
}
//----------------------------------------------------------------//
int maxi(int a, int b)
{
	if (a > b)
		return a;
	else
		return b;
}
int answer(int a, int b)
{
	return a + b;
}
int print(int a)
{
	return a;
}
int main()
{
	int n, k;
	int a, b;
	scanf("%d %d", &n, &k);
	int arr[n];
	for (int i = 0; i < n; i++)
	{
		scanf("%d", &arr[i]);
	}
	int arr2[n];
	struct Queue *deque = createdeQueue(n);
	int ans = 0;
	for (int i = 0; i < n - k + 1; i++)
	{
		int max = 0;
		for (int j = i; j < i + k; j++)
		{
			max = maxi(max, arr[j]);
		}
		ans = answer(ans, max);
		enqueue(deque, max);
	}
	printf("%d", print(ans));
	return 0;
}