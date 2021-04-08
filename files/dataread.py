import ctypes
from ctypes import cdll

class Relu_Data:
    @classmethod
    def __init__(self):
        #self.FILE_1 = cdll.LoadLibrary("aidata/func.so")
        #self.FILE_2 = cdll.LoadLibrary("aidata/data.so")
        self.relu_data = open("saved_data/requ.txt","w+")
    def write(self):
        self.relu_data.write("TEAMS = 31\n")
        self.relu_data.write("MAX_GOALIES = 2\n")
        self.relu_data.write("MAX_DEFENCE = 4\n")
        self.relu_data.write("MAX_OFFENCE = 6\n")
        self.relu_data.write("MAX_TEAM_SIZE = 6\n")
    def show(self):
        pass
        """
        print("------SETTINGS------")
        print("TEAMS = {0}".format(self.FILE_1.fun(10,20)))
        self.FILE_2.GoalieR()
        self.FILE_2.DefenceR()
        self.FILE_2.OffenceR()
        self.FILE_2.TeamSizeR()
        print("--------------------")
        """


def settings():
    Relu_Data().show()

def write():
    Relu_Data().write()
Relu_Data().write()
