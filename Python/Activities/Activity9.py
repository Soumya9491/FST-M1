lst1 = [2, 4, 3, 5, 6]
lst2 = [7, 8, 5, 4, 8]
lst3 = []
for x in lst1:
    if x%2 != 0:
        lst3.append(x)

print(lst3)

for y in lst2:
    if y%2 == 0:
        lst3.append(y)

print(lst3)
