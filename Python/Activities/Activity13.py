def list_sum(num):
    sum = 0
    for x in num:
        sum = sum + x
    return sum


list_num = [5, 4, 3, 2, 1]

int_sum = list_sum(list_num)

print("Sum =" + str(int_sum))
