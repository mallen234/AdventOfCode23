from part1 import Day10
import queue

class Part2:
    def __init__(self,data,loop):
        self.data = data
        self.loop = loop
        self.checked_off_queue = set({(0,0)})
        
        
    def check_square_in_loop(self):
        out_loop = set()
        for i,row in enumerate(self.data):
            for j,elem in enumerate(row):
                if (i,j) not in self.loop:
                    out_loop.add((i,j))

        return out_loop


    def isMoreOutterPipe(self,i,j):
        borders = []
        if i != 0:
            borders.append((i-1,j))
        
        if i != (len(self.data) - 1):
            borders.append((i+1,j))
            # print("HERE")

        if j != (0):
            borders.append((i,j-1))

        if j != (len(self.data[0]) - 1):
            borders.append((i,j+1))

        return borders

    def breadth_first_search(self):
        my_queue = queue.Queue()
        my_queue.put((0,0))
        outside_points = 0
        while not my_queue.empty():
            # print(my_queue.not_empty)
            i,j = my_queue.get()
            
            borders = self.isMoreOutterPipe(i,j)
            # print(new_queue)
                # print("HERE")
            for k in borders:
                if ((k not in self.checked_off_queue) and (k not in self.loop)):
                    # print(k,)
                    my_queue.put(k)
                    self.checked_off_queue.add(k)

            outside_points +=1
        print(outside_points)
        self.outside_points = outside_points
        return outside_points

    def scan_across_grid(self):
        #data should be padded data
        in_the_loop = False
        prev = (0,0)
        enclosed = 0
        print(self.loop)
        for i,row in enumerate(self.data):
            for j,elem in enumerate(row):
                # print(f"i,j : {(i,j)}  -> prev : {prev}")
                if ((i,j) in self.loop) ^ (prev in self.loop):
                    in_the_loop = not in_the_loop
                    print(f"trigger XOR: {i,j}, {in_the_loop}")


                if in_the_loop and ((i,j) not in self.loop):
                    enclosed += 1


                prev = (i,j)

            in_the_loop = False

        print(enclosed)