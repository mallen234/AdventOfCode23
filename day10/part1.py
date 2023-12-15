class Day10:
    letters = ["L", "-","|","J","F","7"]
    up_letters = ["|","F","7"]
    down_letters = ["|","L","J"]
    r_letters = ["7","-","J"]
    l_letters = ["-","F","L"]
    
    letters = { "L":(0,1,1,0), "-":(0,0,1,1),"|":(1,1,0,0),"J":(0,1,0,1),"F":(1,0,1,0),"7":(1,0,0,1)}
    
    binary_l = {"." : 0,"S" : 15, "L": 6, "-": 3, "|":12, "J":5, "F":10, "7":9}
    pipes = {""}
    def __init__(self,input_file):
        self.data = self._read_data(input_file)
        self.pd = self.data
        self.pad_data = ["." + a + "." for a in self.data]
        self.pad_data.insert(0,"." * len(self.pad_data[0]))
        self.pad_data.append("." * len(self.pad_data[0]))
        self.no_extra_dots = len(self.pad_data) * 2 + len(self.pad_data[0]) - 4
        self.pd = self.pad_data

    def _read_data(self,input_file):
        with open(input_file) as file:
            data = file.readlines()
        clean_data = [a.strip('\n') for a in data]
        return clean_data

    def _pad_data(self,a):
        b = ["." + i + "." for i in a]
        b.insert(0,["." for _ in range(len(a)+2)])
        b.append(["." for _ in range(len(a)+2)])
        return b

    def search_round(self,i,j):
        up = self.pd[i-1][j]
        down = self.pd[i-1][j]
        left = self.pd[i][j-1]
        right = self.pd[i][j+1]
        
        return 0

    def search_up(self,i,j):
        return (Day10.binary_l[self.pd[i-1][j]] & 0b1000 > 0)
            
    def search_down(self,i,j):
        return (Day10.binary_l[self.pd[i+1][j]] & 0b0100 > 0)

    def search_right(self,i,j):
        return (Day10.binary_l[self.pd[i][j+1]] & 0b0001 > 0)

    def search_left(self,i,j):
        return (Day10.binary_l[self.pd[i][j-1]] & 0b0010 > 0)

    def get_next(self,i,j,prev):
        # checking up
        if ((Day10.binary_l[self.pd[i][j]] & 0b0100) > 0):
            if (self.search_up(i,j) & ((i-1,j) != prev)):
                return (i-1,j),(i,j)
        
        # checking down 
        if ((Day10.binary_l[self.pd[i][j]] & 0b1000) > 0):
            # print("HERE in down")
            # print((i,j),prev)
            if (self.search_down(i,j) & ((i+1,j) != prev)):
                # print("go down")
                return (i+1,j),(i,j)
        
        # checking right 
        if ((Day10.binary_l[self.pd[i][j]] & 0b0010) > 0):
            # print("trigger right")
            if (self.search_right(i,j) & ((i,j+1) != prev)):
                return (i,j+1),(i,j)
        
        # checking left 
        if ((Day10.binary_l[self.pd[i][j]] & 0b0001) > 0):
            # print("here in l")
            if (self.search_left(i,j) & ((i,j-1) != prev)):
                return (i,j-1),(i,j)
            

    def get_loop(self):
        loop = set()

        for i,row in enumerate(self.pd):
            for j,val in enumerate(row):
                if val == "S":
                    prev = (i,j)
                    loop.add(prev)
                    print(self.pd[i][j])
        
    
        new,prev = self.get_next(prev[0],prev[1],(0,0))
        loop.add(new)
        i = 1    
        while (self.pd[new[0]][new[1]] != "S"):
            new,prev = self.get_next(new[0],new[1],prev)
            loop.add(new)
            # print(new[0],new[1])
            i = i+1

        return (i, loop)