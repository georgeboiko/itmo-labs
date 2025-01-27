def TenToNegTen(n):
    ans = ""
    while n != 0:
        ost = (n%(-10) + 10)%10
        ans += str(ost)
        n = (n-ost)//(-10)
    return ans[::-1]

def TenToFib(n):
    fib = [1, 2]
    while fib[-1]+fib[-2] <= n: fib.append(fib[-1] + fib[-2])
    ans = ""
    for i in range(len(fib)-1, -1, -1):
        if n - fib[i] >= 0:
            ans += "1"
            n -= fib[i]
        else: ans += "0"
    return ans

def FibToTen(s):
    fib = [1, 2]
    while len(fib) < len(s): fib.append(fib[-1] + fib[-2])
    fib = fib[::-1]
    ans = 0
    for i in range(len(s)):
        if s[i] == "1": ans += fib[i]
    return ans

def TenToC(n, p):
    ans = []
    mas = []
    for i in range(0, p//2 + 1): mas.append(str(i))
    for i in range(-(p//2), 0): mas.append("{^" + str(abs(i)) + "}")
    while n != 0:
        ost = n % p
        n //= p
        if ost > p//2: n += 1
        ans.append(mas[ost])
    return "".join(ans[::-1])

n = input("Введите число: ")
f = input("Введите исходную систему счисления: ")
t = input("Введите желаемую систему счисления: ")
if f == "10" and t == "-10": print(TenToNegTen(int(n)))
if f == "10" and t == "fib": print(TenToFib(int(n)))
if f == "fib" and t == "10": print(FibToTen(n))
if f == "10" and t == "7C": print(TenToC(int(n), 7))
if f == "10" and t == "9C": print(TenToC(int(n), 9))
