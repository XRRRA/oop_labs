# Reading the string
t = str(input())
max_length = 1
# If the string is empty
if t == '':
    max_length = 0
for i in range(len(t)):
    # Assigning the substring
    substring = t[i]
    # Starting from the next value of I, so we can compare
    for j in range(i + 1, len(t)):
        # Check if the character is already in the substring
        if t[j] not in substring:
            substring = substring + t[j]
            # Updating max_length if it is greater than the existing max_length
            # Choosing the max value between the previous value and the current length of the substring
            max_length = max(max_length, len(substring))
        else:
            break
# Creating a list of substrings
substring_list = []
# Creating a list of repeating substrings
repeating_elements = []
final = {}
for i in range(len(t)):
    temp = ""
    for j in range(i, len(t)):
        # Assign a temporary string
        temp += t[j]
        # if the string is not in the substring list, we add it there
        if temp not in substring_list:
            substring_list.append(temp)
        # If the string is in the substring list that means it repeats at least 2 times
        # So, we add it into the repeating items list
        elif len(temp) >= 2 and temp in substring_list:
            repeating_elements.append(temp)
# Creating a dictionary with all the repeating items and how many times do they repeat
for i in set(repeating_elements):
    final[i] = repeating_elements.count(i) + 1
# Printing the result of the problem using dictionaries
# If the dictionary is empty, we show nothing
if not final:
    print(f"Problem 2: -")
else:
    the_longest_key = max(final, key=len)
    the_longest_key_value = final[the_longest_key]
    if the_longest_key_value >= max(final.values()):
        print(f"Problem 1: {the_longest_key}")
    else:
        print(f"Problem 1: {list(final.keys())[list(final.values()).index(max(final.values()))]}")

print(f"Problem 2: {max_length}")
