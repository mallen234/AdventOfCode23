from operator import mul
from functools import reduce
class day3:
    
    def __init__(self):
        with open('input.txt') as input_file:
            data = input_file.readlines()
        self.data = [a.strip('\n') for a in data]
        self.nums = ['0','1','2','3','4','5','6','7','8','9']
    
    def check_round(self,i,j,num):
        l = len(num)
        str_check = self.data[i-1][j-l-1:j+1]
        str_check += self.data[i][j-l-1] + self.data[i][j]
        str_check += self.data[i+1][j-l-1:j+1]
        for x in str_check:
            if x not in self.nums and x != '.':
                return True
            else:
                return False

    def main(self):
        tot = 0
        for i,row in enumerate(self.data):
            num = ''
            
            for j,col in enumerate(row):
                if col == '*':
                    a = self.search(i,j)
                    tot += a
                    # print(a)                 
        print(tot)


    def search(self,i,j):
        nums = []
        k,l = i-1,j-1
        while k <= i+1:
            while l <= j+1:
                if self.data[k][l] in self.nums:
                    num,l = self.find_num(k,l)
                    nums.append(int(num))
                else:
                    l+=1
            k,l = k+1,j-1

        # print(nums)                    
        if len(nums) > 1:
            print(nums,reduce(mul,nums,1))
            return reduce(mul,nums,1)
        else:
            return 0

    def find_num(self,i,j):
        nums = ''
        while self.data[i][j] in self.nums:
            j-=1
        j+=1
        while self.data[i][j] in self.nums:
            nums += self.data[i][j]
            j+=1
        return nums,j
if __name__ == '__main__':
    day = day3()
    day.main()
