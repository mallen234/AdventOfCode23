def main():
    with open('input.txt') as input_file:
        data = input_file.readlines()
    clean_data = [a.strip('\n') for a in data]

    
    nums = ['0','1','2','3','4','5','6','7','8','9']
    syms = ['@','$','*','+','/','-','=','#','%','&']
    
    tot = 0
    for i,row in enumerate(clean_data):
        num = ''
        
        for j,col in enumerate(row):

            if col in nums:
                num += col
        
            else:
                if num:
                    chars_to_check = check_above(i,j,clean_data,num) + check_sides(i,j,clean_data,num) + check_below(i,j,clean_data,num)
                    if any(x in chars_to_check for x in syms):
                        print(int(num))
                        tot += int(num)
                    num = ''

    print(tot)

def check_above(i,j,clean_data,num):
    l = len(num)
    return clean_data[i-1][j-l-1:j+1]

def check_sides(i,j,clean_data,num):
    l = len(num)
    return clean_data[i][j-l-1] + clean_data[i][j]

def check_below(i,j,clean_data,num):
    l = len(num)
    return clean_data[i+1][j-l-1:j+1]

if __name__ == '__main__':
    main()
