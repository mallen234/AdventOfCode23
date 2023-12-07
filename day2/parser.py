import re

def main():
    with open('input.txt') as input_file:
        data = input_file.readlines()
    clean_data = [a.strip('\n') for a in data]
    
    powers = []
    for i,chunk in enumerate(clean_data):
        
        split = re.sub(r'Game [0-9]{1,3}: ', '',chunk).split('; ')
        
        min_hand = {'red': 0, 'green': 0, 'blue': 0}
        
        for j in split:
            hand = j.split(', ')
            for k in hand:
                num, col = k.split(' ')[0],k.split(' ')[1]
                if (min_hand[col] < int(num)):
                    min_hand[col] = int(num)

        curr_power = min_hand['red'] * min_hand['green'] * min_hand['blue']
        powers.append(curr_power)
                    
    print(powers)
    print(sum(powers))

if __name__ == '__main__':
    main()
