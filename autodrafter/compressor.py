from xml.dom import minidom
import numpy
from numpy import exp
from numpy import array
from numpy import random as rn
from numpy import dot
import random
import json
import os
import sys
sys.path.insert(1, 'files/')
from generateteams import Display_Draft

# Organizes the xml file with information
class Prepare:
    @classmethod
    def __init__(self):
        file = open('autodrafter/trained.xml','r')
        self.DOC = minidom.parse(file)
        file.close()

    def Data(self):
        A, self.TOTAL, h = [], 0, []
        for i in range(12):
            self.TOTAL += 1
            self.weight1 = self.DOC.getElementsByTagName("value"+str(self.TOTAL))
            for value in self.weight1:
                self.DAT = value.getAttribute("value")
                if self.DAT != "":A.append(self.DAT)
        for k in A:
            c, k = k.split(), []
            for num in c:
                self.NEW,s = [i for i in num], []
                if "[" in self.NEW: self.NEW.remove("[")
                if "]" in self.NEW: self.NEW.remove("]")
                if " " in self.NEW: self.NEW.remove(" ")
                if "," in self.NEW: self.NEW.remove(",")
                g = ''.join(self.NEW)
                k.append(float(g))
            h.append(k)
        return h

    def Weight1(self):
        self.TOTAL, self.ONE = 0, []
        for i in range(7):
            self.TOTAL += 1
            weight1 = self.DOC.getElementsByTagName("weights1"+str(self.TOTAL))
            for value in weight1:
                self.DAT = value.getAttribute("value")
                if self.DAT !="":self.ONE.append(self.DAT)
        return self.ONE

    def Weight2(self):
        self.TOTAL2, self.TWO = 0, []
        for i in range(12):
            self.TOTAL2 +=1
            weight2 = self.DOC.getElementsByTagName("weights2"+str(self.TOTAL2))
            for value in weight2:
                self.DAT2 = value.getAttribute("value")
                if self.DAT2 !="":self.TWO.append(self.DAT2)
        return self.TWO

    def Calculate(self, one, two):
        v, q, self.VAL, self.ONE, self.TWO = [], [], [], one, two
        for k in self.ONE:
            a, k = k.split(), []
            for weight in a:
                self.NEW, s = [i for i in weight], []
                if "[" in self.NEW: self.NEW.remove("[")
                if "]" in self.NEW: self.NEW.remove("]")
                if " " in self.NEW: self.NEW.remove(" ")
                if "," in self.NEW: self.NEW.remove(",")
                k.append(float(''.join(self.NEW)))
            v.append({'weights:': k})

        for k in self.TWO:
            a, k = k.split(), []
            for weight in a:
                self.NEW, s = [i for i in weight], []
                if "[" in self.NEW: self.NEW.remove("[")
                if "]" in self.NEW: self.NEW.remove("]")
                if " " in self.NEW: self.NEW.remove(" ")
                if "," in self.NEW: self.NEW.remove(",")
                g = ''.join(self.NEW)
                k.append(float(g))
            q.append({'weights:': k})
        self.VAL.append(v),self.VAL.append(q)
        return self.VAL

# Takes total weights from the xml file
def Weights():
    a = Prepare().Calculate(Prepare().Weight1(), Prepare().Weight2())
    return a

# Takes the dataset from the xml file
def Dataset():
    b = Prepare().Data()
    return b

# Reads players from the file
def Players():
    file, x = open("saved_data/Player_Data.txt", "r"), []
    for ele in file:
        a,c,q,z = ele.split(","), [], [], []
        for i in a:
            a = [], c.append(i)
        for ele in c:
            new= [i for i in ele]
            if "[" in new: new.remove("[")
            if "]" in new: new.remove("]")
            if "'" in new: new.remove("'")
            new.pop(len(new)-1)
            if "\n" in new: new.remove("\n")
            q.append(''.join(new))
        a,b,c = q[2], q[0], q[1]
        z.append(b), z.append(c), z.append(a[:-1]), x.append(z)
    return x

# Adds Weights from the Weights definer
def WeightVals():
    a, z, total =  Weights(), [], []
    for set in a:
        for list in set:
            z.append(sum(list['weights:']))
        total.append(sum(z))
    return total

# DRAFT_DATA.TXT was used in earlier version do not use
def Order():
    file, z, x, q, g = open("saved_data/Draft_Data.txt", "r"), [], [], [], Display_Draft()
    return (sorted(g, key = lambda x: x[1]))

# Sets up players for draft
def Prepare_Weights():
    a, c, pos, z = Players(), WeightVals(), 0, []
    key = {" POSITION: C" : 2,
        " POSITION: RW" : 2,
        " POSITION: LW" : 2,
        " POSITION: D" : 4,
        " POSITION: G" : 2}

    pos_key = {" POSITION: C" : "C",
        " POSITION: RW" : "RW",
        " POSITION: LW" : "LW",
        " POSITION: D" : "D",
        " POSITION: G" : "G"}
    for player in a:
        q, c = [], [player[2]]
        pos += 1
        for x in c:
            a = x.split(":")
            for i in a:
                try: b = int(i[1:3]), q.append(pos), q.append(key[player[1]]), q.append(pos_key[player[1]]), q.append(int(i[1:3])), z.append(q)
                except ValueError: pass
    return z

# Calculates the important information for draft
def Player_Weight():
    Player_Vals, z, Weight_Vals = Prepare_Weights(), [], WeightVals()
    for set in Player_Vals:
        a,c,t1 = set[0], set[2], set[1]+set[3]+sum(Weight_Vals)
        t2 = [c,a,t1]
        z.append(t2)
    return z
# Sorts the players by position for draft
class Sorter:
    def __init__(self, x):
        self.GOALIE, self.CENTER, self.RIGHT, self.LEFT, self.DEFENCE, self.PLAYER_LIST = [], [], [], [], [], x
    def __Goalie(self):
        for Player in self.PLAYER_LIST:
            if Player[0] == "G": self.GOALIE.append(Player)
    def __Defence(self):
        for Player in self.PLAYER_LIST:
            if Player[0] == "D": self.DEFENCE.append(Player)
    def __Center(self):
        for Player in self.PLAYER_LIST:
            if Player[0] == "C": self.CENTER.append(Player)
    def __Left(self):
        for Player in self.PLAYER_LIST:
            if Player[0] == "LW": self.LEFT.append(Player)
    def __Right(self):
        for Player in self.PLAYER_LIST:
            if Player[0] == "RW": self.RIGHT.append(Player)

    def List(self, x):
        self.__Goalie(), self.__Defence(), self.__Center(), self.__Left(), self.__Right()
        if x == "G": return self.GOALIE
        if x == "D": return self.DEFENCE
        if x == "LW": return self.LEFT
        if x == "RW": return self.RIGHT
        if x == "C": return self.CENTER

# Sets up the draft pattern
class Choice:
    def __init__(self):
        self.RULE = {"C": 2,
            "LW": 2,
            "RW": 2,
            "D": 4,
            "G":2}
    def __sigmoid(self, x):
        return 1/ (1+exp(-x))
    def __sigmoid_derivative(self, x):
        return x* (1-x)
    def train(self, inputs, outputs, iterations):
        for it in range(iterations):
            output = self.think(inputs)
            error = outputs - output
            adjustment = dot(inputs.T, error * self.__sigmoid_derivative(output))
            self.WEIGHT +=  adjustment
    def think(self, inputs):
        return self.__sigmoid(dot(inputs, self.WEIGHT))

    def __send(self):
        inputs = array([[1]])
        outputs = array([[0]])
        self.train(inputs, outputs, 25)

    def __position(self):
        g,d,l,r,c,self.moves, Active= True, True, True, True, True, [], True
        while Active == True:
            self.WEIGHT = rn.random((1,1)) +random.randint(-7, 3)
            self.__send()
            for number in self.WEIGHT: a = (float(number))
            if g == True: 
                if 0 > a > -2: 
                    self.RULE["G"]-=1 
                    self.moves.append("G")
            if d == True: 
                if 0 < a < 0.250: 
                    self.RULE["D"]-=1 
                    self.moves.append("D")
            if l == True: 
                if 0.250 < a < 1.2: 
                    self.RULE["LW"]-=1 
                    self.moves.append("LW")
            if r == True:
                if 1.2< a < 1.7: 
                    self.RULE["RW"]-=1 
                    self.moves.append("RW")
            if c == True:
                if a < -2 or a > 1.6: 
                    self.RULE["C"]-=1 
                    self.moves.append("C")
            if self.RULE["G"] == 0: g = False
            if self.RULE["D"] == 0: d  = False
            if self.RULE["LW"] == 0: l = False
            if self.RULE["RW"] == 0: r = False
            if self.RULE["C"] == 0: c = False
            if ((g == False and d == False)and(l == False and r == False)and c == False): Active = False 

    def Release(self):
        self.__position()
        return self.moves
        # below is mainly for testing
        print(json.dumps(self.RULE, indent=0))
        print(self.moves)

# Drafts players 
def Draft():
    player_list, total, num, players, a,  b, teampos, final = (Player_Weight()), -1, 0, Players(), (Choice().Release()), (Order()), -1, []
    for _ in range(12):
        teampos = -1
        total += 1
        for i in range(30):
            c = (Sorter(player_list).List(a[total]))
            if len(c) != 0: player = c[0]
            teampos+=1
            num += 1
            h = ([b[teampos][0]] + players[player[1]-1])
            final.append(h)
            if len(player_list) != 0: player_list.remove(player)
    return (sorted(final))

def Save(x):
    save, stats, noteams = open("saved_data/Save#1_Data.txt","w+"), x, -1
    for stat in stats: 
        save.write("{0}\n".format(stat))

Save(Draft())