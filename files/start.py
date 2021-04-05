import saving_data
import dataread
import ctypes
from ctypes import cdll

class Start:
    def __init__(self):
        self.open = cdll.LoadLibrary("aidata/data.so")
    def Native(self):
        self.open.main1()

Start().Native()