lst = list(input("Enter the list : "))
print(lst)

if int(lst[0]) == int(lst[len(lst)-1]):
    print("Numbers are equal")
else:
    print("Not equal")