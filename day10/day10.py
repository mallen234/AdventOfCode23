from part1 import Day10
from part2 import Part2

import sys
def main():
    file_i = sys.argv[1]
    lines = Day10(file_i) 
    loop_len, loop = lines.get_loop()
    for i in lines.pad_data:
        print (i)

    print(lines.no_extra_dots)
    # print(lines.pad_data)
    # print(loop_len/2)
    # print(len(loop))
    j, padded_loop = lines.get_loop()

    # print(lines.pad_data)
    # print(lines.pd)

    part2_data = Part2(lines.pad_data,padded_loop)
    part2_data.scan_across_grid()
if __name__ == "__main__":
    main()
