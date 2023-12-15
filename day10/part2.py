from part1 import Day10


class Part2:

    def __init__(self,data,loop):
        self.data = data
        self.loop = loop
        
        
    def check_square_in_loop(self):
        out_loop = set()
        for i,row in enumerate(self.data):
            for j,elem in enumerate(row):
                if (i,j) not in self.loop:
                    out_loop.add((i,j))

        return out_loop