def calculate(number):
    if number:
        return number + calculate(number - 1)
    else:
        return 0


sum = calculate(10)

print(sum)
