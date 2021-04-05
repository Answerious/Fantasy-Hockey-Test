import teamselector
import scheduler


class Info:
    @classmethod
    def __init__(self):
        self.TEAM = teamselector.Team()
        self.GAME_LIST = open("saved_data/Schedule_Data")
        self.WEEK = 1
    def Show(self):
        print(f"TEAM SELECTED: {self.TEAM} Week: {self.WEEK}/6")
        print(f"----------WEEK {self.WEEK} SCHEDULE----------")
        matches = [match for match in self.GAME_LIST if self.TEAM in match]
        if len(matches) == 0: print("        NO GAMES THIS WEEK!")
        for game in matches: print(game)



Info = Info()
Info.Show()