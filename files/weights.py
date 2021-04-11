class Layers:
    @classmethod
    def __init__(self):
        self.array = []
        self.total = 0
        self.reto = open('saved_data/Ai_Layers.txt','w+')
    def Native(self):
        with open ('saved_data/Ai_Layers-Combined.txt', 'r') as inp:
            for line in inp:
                for cen in line.split():
                    try: 
                        num = int(cen)
                        self.array.append(num)
                        self.total += 1
                    except ValueError:
                        if cen != ' ': print('{} is not a number!'.format(cen))
        chunk = [self.array[x:x + 17] for x in range(0, len(self.array), 17)]
        for _ in chunk:
            self.reto.write(str(sum(_))+ '\n')
Layers().Native()