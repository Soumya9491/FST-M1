import pandas

data = pandas.read_excel("excel.xlsx")

print(data.shape)

print(data["Email"])

print(data.sort_values("FirstName"))