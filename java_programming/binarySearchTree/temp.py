# Birthday paradox calculation

# 365! / (365^n * (365-n)!)

def factorial(n):
    if n == 0:
        return 1
    else:
        return n * factorial(n-1)
    
def birthdayParadox(n):
    return factorial(365) / (365**n * factorial(365-n))

for i in range(1, 366):
    print(1 - birthdayParadox(i), i)