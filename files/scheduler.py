import generateteams
import random

class Schedule:
    def __init__(self):
        self.SCHEDULE = list()
        self.WEEK = 0
        self.DAYS = {
            1:"Monday",
            2:"Tuesday",
            3:"Wednesday",
            4:"Thursday",
            5:"Friday",
            6:"Saturday"
        }
        self.WEEKS = []
    def Organize(self):
        for _ in range(1):
            self.TEAM_LIST = generateteams.Display_Teams()
            random.shuffle(self.TEAM_LIST)
            self.WEEK += 1
            tracker = 0
            day = 0
            for _ in range(12):
                tracker += 1
                day += 1
                a = ("{0} vs {1} on {2}".format(self.TEAM_LIST[0], self.TEAM_LIST[1], self.DAYS[day]))
                self.TEAM_LIST.remove(self.TEAM_LIST[0]) and self.TEAM_LIST.remove(self.TEAM_LIST[1])
                if tracker >= 6:
                    day = 0 
                    tracker = 0
                self.SCHEDULE.append(a)

def Scheduler():
    Schedule1 = Schedule()
    Schedule1.Organize()
    return Schedule1.SCHEDULE