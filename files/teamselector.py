"""SINGLE PLAYER MODE"""
import generateteams
import sys
import random

class Choose:
    def __init__(self):
        self.TEAM_OPTIONS = generateteams.Display_Teams()
        self.COUNTER  = 0
        self.TEAM = ""
    def Selector(self):
        for _ in self.TEAM_OPTIONS:
            self.COUNTER += 1
            #print("TEAM: {0} No.{1}".format(TEAM, self.COUNTER))
        self.CHOICE = random.randint(1,30)#int(input("Enter team number 1-30 "))
        if self.CHOICE <= 0: print("ERROR -> Invalid Number") and sys.exit()
        elif self.CHOICE > 30: print("ERROR -> Invalid Number") and sys.exit()
        else: self.TEAM = self.TEAM_OPTIONS[self.CHOICE-1]
        #print(f"TEAM: {self.TEAM_OPTIONS[self.CHOICE-1]}")

def Team():
    Choose1 = Choose()
    Choose1.Selector()
    return Choose1.TEAM