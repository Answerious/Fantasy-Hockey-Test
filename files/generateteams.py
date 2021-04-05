import random 

class Team_Holder:
    def __init__(self):
        self.filepath = 'redata/teams.txt'
        self.TEAMS = []
    def Read_Teams(self):
        with open(self.filepath) as fp:
            self.LINE = fp.readline()
            while self.LINE:
                self.LINE.strip()
                self.LINE = fp.readline()
                list2 = [x.replace('\n', '') for x in self.LINE]
                self.TEAMS.append(''.join(list2))
        self.TEAMS.remove('')
    def Draft_Pick_Teams(self):
        self.Read_Teams()
        self.NUMBERS = []
        self.RETURN = []
        for i in range(999):
            self.NUMBERS.append(random.randint(1,31))
        NUMBERS = []
        [NUMBERS.append(x) for x in self.NUMBERS if x not in NUMBERS]
        for TEAM in self.TEAMS:
            for i in NUMBERS:
                a = [TEAM, i]
                NUMBERS.remove(i)
                self.RETURN.append(a)
                break

def Display_Teams():
    Holder = Team_Holder()
    Holder.Read_Teams()
    return Holder.TEAMS

def Display_Draft():
    Holder = Team_Holder()
    Holder.Read_Teams()
    Holder.Draft_Pick_Teams()
    return Holder.RETURN