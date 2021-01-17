import sys

sys.setrecursionlimit(10**6)

def merge_sort(array):
    if len(array) <= 1:
        return array

    k = len(array)//2
    arr1 = merge_sort(array[:k])
    arr2 = merge_sort(array[k:])

    return merge(arr1, arr2)

def merge(arr1, arr2):
    len1, len2 = len(arr1) , len(arr2)
    j = k = 0
    aux = []
    while j < len1 and k < len2:
        if arr1[j] < arr2[k]:
            aux.append(arr1[j])
            j += 1
        else:
            aux.append(arr2[k])
            k += 1

    while j < len1:
        aux.append(arr1[j])
        j += 1

    while k < len2:
        aux.append(arr2[k])
        k += 1

    return aux


if __name__ == "__main__":
    array = [56, -1,77,-56,8,-555,57,56,57]
    for x in merge_sort(array):
        print(x)