import pandas

csvData = {"Usernames":  ["admin", "Charles", "Deku"],
           "Passwords": ["password", "Charl13", "AllMight"]
           }

dataFrame = pandas.DataFrame(csvData)

print(dataFrame)

dataFrame.to_csv("text.csv", index=False)