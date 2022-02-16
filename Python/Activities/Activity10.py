tup = tuple((input("Enter the tuple elements : ")).split(","))
print(tup)

for x in tup:
    if int(x)%5 == 0:
        print(x)