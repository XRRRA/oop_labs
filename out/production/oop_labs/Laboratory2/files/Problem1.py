def powerset(n_set):
    # A variable which consists from all the subsets of n
    subsets = []
    # The total number of subsets
    for j in range(2**len(n_set)):
        subset_2 = []
        # Creating the subsets
        for k in range(len(n_set)):
            #  Checks if the k-th bit of j is set.
            # 1 << k uses shifting of 1 to generate a bit mask in which only the k-th bit is set.
            # The & j then masks out the k-bit of j; if the result is not zero the condition is satisfied.
            if j & (1 << k):
                # Add the kth value to the subset
                subset_2.append(n_set[k])
        # After the second for loop is done, add the subset to all the subsets
        subsets.append(subset_2)
    return subsets


raw_list = list(input())  # the list which we input
n = []  # the set with all the elements
subset = []  # creating a simple subset, so we can add the sets within the sets in it
len_raw = len(raw_list)
symbols = ['[', ']', ',', ' ']
for i in range(1, len_raw):
    if raw_list[i] == '[':  # starting from the element when we find a set in the set
        for j in range(i, 1000):
            if raw_list[j-1] != ']':  # if there is not the end of the subset, we add the elements
                subset.append(raw_list[j])
            elif raw_list[j-1] == ']':  # if it is the end of the subset we break the loop
                break
            # in order not to have the elements of the subset in the main set, we delete them
            if raw_list[j] not in symbols:
                raw_list[j] = " "
        n += [''.join(subset)]
        subset = []  # we need to delete the existing subset, so we can work with another one if exists
    if raw_list[i] not in symbols:  # add the simple elements which are not in a subset
        n += raw_list[i]
print(powerset(n))  # execute the power set function

# [a,b,[c],[d,e],[f,g],[h,j,k,l],[q,w,e,r,t,y,u,i]]
