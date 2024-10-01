#include <stdio.h>
// Implementing SRFT scheduling in C

void results(int arr[][4], int n)
{
    int total_tat = 0, total_wt = 0;
    for(int i = 0; i < n; i++)
    {
        total_tat += arr[i][3] - arr[i][1];
        total_wt += total_tat - arr[i][2];
    }

    printf("Average Turnaround Time: %f\n", (float)total_tat/n);
    printf("Average Waiting Time: %f\n", (float)total_wt/n);
}

int all0s(int arr[][4], int n)
{
    for(int i = 0; i < n; i++)
    {
        if(arr[i][2] != 0) return 0;
    }
    return 1;
}

void simulate(int arr[][4], int n)
{
    int time = 0, no_of_processes_arrived = 0, min_pid = 0, min_burst = 1000000;
    int vis[n];
    for(int i = 0; i < n; i++) vis[i] = 0;

    while(true)
    {
        if(no_of_processes_arrived < n)
        {
            
        }
        else
        {

        }

        time++;
        arr[min_pid][2]--;
 
        if(arr[min_pid][2] == 0)
        {
            arr[min_pid][3] = time;
        }

        if(all0s(arr, n) == 1) break;

    }
}


int main()
{
    int n; scanf("%d", &n);
    int arr[n][4];

    // 0th idx has pid, 1st idx has arrival time, 2nd idx has burst time, 3rd idx has completion time

    for(int i = 0; i < n; i++)
    {
        scanf("%d %d %d", &arr[i][0], &arr[i][1], &arr[i][2]);
        arr[i][3] = 0;
    }

    simulate(arr, n);
    results(arr, n);
    return 0;
}