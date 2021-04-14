import random
import generateteams

class Creation:
    def __init__(self):
        self.ITERATIONS = (500)
        self.FILE = open('redata/names.txt', 'r')
        self.NAMES = self.FILE.readlines()
        self.PLAYER_LIST = []
    def Name_Creation(self):
        for _ in range(1000):
            f = []
            a = (random.sample(self.NAMES, 2))
            list2 = [x.replace('\n','') for x in a]
            f.append(' '.join(list2))
            self.PLAYER_LIST.append(f)
    def Position_Assignment(self):
        self.ASSIGNED = []
        self.GOALIES = (self.PLAYER_LIST[0:120])
        self.DEFECEMEN = (self.PLAYER_LIST[121:241])
        self.CENTERMEN = (self.PLAYER_LIST[362:482])
        self.RIGHTWING = (self.PLAYER_LIST[483:603])
        self.LEFTWING = (self.PLAYER_LIST[604:724])
        self.DEFECEMEN_2 = (self.PLAYER_LIST[725:845])
        for center in self.CENTERMEN:
            center.append('POSITION: C')
            self.ASSIGNED.append(center)
        for right_wing in self.RIGHTWING:
            right_wing.append('POSITION: RW')
            self.ASSIGNED.append(right_wing)
        for left_wing in self.LEFTWING:
            left_wing.append('POSITION: LW')
            self.ASSIGNED.append(left_wing)
        for defence in self.DEFECEMEN:
            defence.append('POSITION: D')
            self.ASSIGNED.append(defence)
        for defence2 in self.DEFECEMEN_2:
            defence2.append('POSITION: D')
            self.ASSIGNED.append(defence2)
        for goalie in self.GOALIES:
            goalie.append('POSITION: G')
            self.ASSIGNED.append(goalie)
    def Overall_Assignment(self):
        self.OVERALLS = []
        for player in self.ASSIGNED:
            x = random.randint(59,99)
            player.append('OVERALL: {0}'.format(x))
            player.append(x)
            self.OVERALLS.append(player)

    def Organize_Overalls(self):
        self.Name_Creation()
        self.Position_Assignment()
        self.Overall_Assignment()
        self.CHECK = []
        self.FINALIZED = []
        for stat in self.OVERALLS:
            self.NUMS = []
            self.NUMS.append(stat[3])
            self.NUMS.append(stat[0])
            self.NUMS.append(stat[1])
            self.NUMS.append(stat[2])
            self.CHECK.append(self.NUMS)
        self.CURRENT = sorted(self.CHECK, reverse=True)
        for player in self.CURRENT:
            self.FINALIZED.append(player[1::])
        print(len(self.ASSIGNED))
        return self.FINALIZED

def Players():
    CR = Creation().Organize_Overalls()
    return CR