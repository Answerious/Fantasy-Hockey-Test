import generateteams
import scheduler
import playergen
import teamselector
import dataread

class Create_Saved_Data:
    @classmethod
    def __init__(self):
        self.PLAYERDATA = open("saved_data/Player_Data.txt", "w+")
        self.SCHEDULEDATA = open("saved_data/Schedule_Data.txt", "w+")
        self.DRAFTORDERDATA = open("saved_data/Draft_Data.txt", "w+")
        self.TEAMSELECTEDDATA = open("saved_data/Save#1_Data.txt","w+")
        self.SELECTED_TEAM = ""
        self.SCHEDULES = scheduler.Scheduler()
        self.PLAYERS = playergen.Players()
        self.DRAFT = generateteams.Display_Draft()
    def Team_Schedule(self):
        for x in self.SCHEDULES: self.SCHEDULEDATA.write("{0}\n".format(x))
    def Player_Data(self):
        for i in self.PLAYERS: self.PLAYERDATA.write("{0}\n".format(i))
    def Draft_Order_Data(self):
        pass#for n in self.DRAFT: self.DRAFTORDERDATA.write("{0}\n".format(n))
    def Game_Saved_Data(self):
        self.SELECTED_TEAM = teamselector.Team()
        self.TEAMSELECTEDDATA.write("{0}\n".format(self.SELECTED_TEAM))
    def Create(self):
        self.Team_Schedule()
        self.Player_Data()
        self.Draft_Order_Data()
        self.Game_Saved_Data()
    
CR = classmethod(Create_Saved_Data().Create())