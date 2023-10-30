from prettytable import PrettyTable

# Read the expression
expression = input()
symbols = ["(", ")", " ", "!", "+", "*"]
distinct_letters = []
# Find out how many distinct letters are in the expression
for i in expression:
    if i not in symbols and i not in distinct_letters:
        distinct_letters.append(i)
# Working with the table
truth_table = PrettyTable()
# Adding each column with the value and expression
for i in range(len(distinct_letters)):
    truth_table.add_column(distinct_letters[i], [])
truth_table.add_column(expression, [])

# Changing the operation symbols to boolean bitwise operators
for i in expression:
    if i == '+':
        expression = expression.replace(i, '|')
    elif i == '*':
        expression = expression.replace(i, '&')
    elif i == '!':
        expression = expression.replace(i, '~')
    # Changing the letters in letters a b c ...
    if len(distinct_letters) == 2:
        if i == distinct_letters[0]:
            expression = expression.replace(i, 'a')
        elif i == distinct_letters[1]:
            expression = expression.replace(i, 'b')
    if len(distinct_letters) == 3:
        if i == distinct_letters[0]:
            expression = expression.replace(i, 'a')
        elif i == distinct_letters[1]:
            expression = expression.replace(i, 'b')
        elif i == distinct_letters[2]:
            expression = expression.replace(i, 'c')
    if len(distinct_letters) == 4:
        if i == distinct_letters[0]:
            expression = expression.replace(i, 'a')
        elif i == distinct_letters[1]:
            expression = expression.replace(i, 'b')
        elif i == distinct_letters[2]:
            expression = expression.replace(i, 'c')
        elif i == distinct_letters[3]:
            expression = expression.replace(i, 'd')
    if len(distinct_letters) == 5:
        if i == distinct_letters[0]:
            expression = expression.replace(i, 'a')
        elif i == distinct_letters[1]:
            expression = expression.replace(i, 'b')
        elif i == distinct_letters[2]:
            expression = expression.replace(i, 'c')
        elif i == distinct_letters[3]:
            expression = expression.replace(i, 'd')
        elif i == distinct_letters[4]:
            expression = expression.replace(i, 'e')
    if len(distinct_letters) == 6:
        if i == distinct_letters[0]:
            expression = expression.replace(i, 'a')
        elif i == distinct_letters[1]:
            expression = expression.replace(i, 'b')
        elif i == distinct_letters[2]:
            expression = expression.replace(i, 'c')
        elif i == distinct_letters[3]:
            expression = expression.replace(i, 'd')
        elif i == distinct_letters[4]:
            expression = expression.replace(i, 'e')
        elif i == distinct_letters[5]:
            expression = expression.replace(i, 'f')
# Adding each row
if len(distinct_letters) == 2:
    for a in range(0, 2):
        for b in range(0, 2):
            x = eval(expression)
            truth_table.add_row([a, b, x])
elif len(distinct_letters) == 3:
    for a in range(0, 2):
        for b in range(0, 2):
            for c in range(0, 2):
                x = eval(expression)
                truth_table.add_row([a, b, c, x])
elif len(distinct_letters) == 4:
    for a in range(0, 2):
        for b in range(0, 2):
            for c in range(0, 2):
                for d in range(0, 2):
                    x = eval(expression)
                    truth_table.add_row([a, b, c, d, x])
elif len(distinct_letters) == 5:
    for a in range(0, 2):
        for b in range(0, 2):
            for c in range(0, 2):
                for d in range(0, 2):
                    for e in range(0, 2):
                        x = eval(expression)
                        truth_table.add_row([a, b, c, d, e, x])
elif len(distinct_letters) == 6:
    for a in range(0, 2):
        for b in range(0, 2):
            for c in range(0, 2):
                for d in range(0, 2):
                    for e in range(0, 2):
                        for f in range(0, 2):
                            x = eval(expression)
                            truth_table.add_row([a, b, c, d, e, f, x])
print(truth_table)
