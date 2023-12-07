

def main():
    with open('input.txt') as input_file:
        data = input_file.readlines()
    clean_data = [a.strip('\n') for a in data]
        
    string_to_digits = {'one': '1', 'two': '2', 'three': '3', 'four': '4', 'five': '5', 'six': '6', 'seven': '7', 'eight': '8', 'nine': '9'}

    digits = ['1','2','3','4','5','6','7','8','9']
    string_digits = ['one','two','three','four','five','six','seven','eight','nine']

    tot_val = 0
    for i in clean_data:
        row_num_list = []
        row_num_string = ''
        for j in i:
            row_num_string += j

            if j in digits:
                row_num_list.append(j)
                row_num_string = ''
            
            for k in string_digits:
                if k in row_num_string:
                    # print(f"{k},{row_num_string}")
                    row_num_list.append(string_to_digits[k])
                    row_num_string = k[-1]

        row_num = int(row_num_list[0] + row_num_list[-1])
        print(row_num,i)
        tot_val += row_num


    print(tot_val)
if __name__ == '__main__':
    main()
