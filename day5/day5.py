def clean_data():
    with open('input.txt') as input_file:
        data = input_file.readlines()
    

    clean_data = [a.strip('\n') for a in data]
    
    seed_data = clean_data[0]
    clean_data = clean_data[2:]
    split_data = []
    j = 0
    for i,val in enumerate(clean_data):
        if val == "":
            split_data.append(clean_data[j:i])
            j = i+1
    
    split_data = [a[1:] for a in split_data][0]
    for i,val in enumerate(split_data):
        print(val)
        split_data[i] = val.split(" ")
        split_data[i] = [int(a) for a in split_data[i]]

    return seed_data,split_data

def main():
    seeds,data = clean_data()
    
    print(seeds,"\n\n",data)

if __name__ == "__main__":
    main()
