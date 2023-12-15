from part1 import Day10

import sys
def main():
    file_i = sys.argv[1]
    lines = Day10(file_i) 
    loop_len, loop = lines.get_loop()
    for i in lines.pad_data:
        print (i)

    print(lines.extra_dots)
    # print(lines.pad_data)
    # print(loop_len/2)
    # print(len(loop))

if __name__ == "__main__":
    main()
