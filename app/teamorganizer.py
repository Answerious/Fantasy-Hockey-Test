import string
import re
import os
import sys
from pathlib import Path

path = Path(os.getcwd())
updat = (path.parent.absolute())
path = (str(updat)+"/saved_data/Save#1_Data.txt")

def get_lines_with(input_str, substr): 
	lines = [] 
	for line in input_str.strip().split('\n'): 
		if substr in line: 
			lines.append(line) 
	return lines 
 
def txt_lines_with(fname, substr): 
	f_contents = open(fname, 'r').read() 
	return get_lines_with(f_contents, substr) 
 
def filter_txt_lines_to(fname_in, substr): 
	filtered_lines = txt_lines_with(fname_in, substr) 
	joined_lines = '\n'.join(filtered_lines) 
	return joined_lines

def Players():
    sys.path.insert(1, 'saved_data/')
    file,x,q = (filter_txt_lines_to(path, ((open(os.getcwd()+"/playerteam.txt")).read())).split("\n")),[],[]
    for name in file: 
        new, q = [i for i in name], []
        if "[" in new: new.remove("["), new.remove("'"), new.remove("]"), new.remove("'"), new.remove("'"), new.remove("'"), new.remove("'"), new.remove("'"), new.remove("'"), new.remove("'")
        a = ((''.join(new)).split(","))
        for s in a: q.append(re.sub(r"^\s+", "", s)), x.append(q)#(s.translate({ord(c): None for c in string.whitespace})), q.append(re.sub(r"^\s+", "", s)), x.append(q)
    team = [i for n, i in enumerate(x) if i not in x[:n]]
    return team

def Center(list, x):
    for i in list: 
        if "POSITION: C" in i[2]:x.append(i)
    return x

def Right(list, x):
    for i in list: 
        if "POSITION: RW" in i[2]:x.append(i)
    return x

def Left(list, x):
    for i in list: 
        if "POSITION: LW" in i[2]:x.append(i)
    return x

def Defence(list, x):
    for i in list: 
        if "POSITION: D" in i[2]:x.append(i)
    return x

def Goalie(list, x):
    for i in list: 
        if "POSITION: G" in i[2]:x.append(i)
    return x

def Java(c,l,r,d,g):
    playerteam,c1,l1,r1,d1,g1 = open(os.getcwd()+"/playerteam.txt","w+"),c,l,r,d,g
    playerteam.write("placeholder\n")
    for i in c:
        c1 = i[1]+" "+i[3]
        playerteam.write("{0}\n".format(c1))
    for i in l:
        l1 = i[1]+" "+i[3]
        playerteam.write("{0}\n".format(l1))
    for i in r:
        r1 = i[1]+" "+i[3]
        playerteam.write("{0}\n".format(r1))
    for i in d:
        d1 = i[1]+" "+i[3]
        playerteam.write("{0}\n".format(d1))
    for i in g:
        g1 = i[1]+" "+i[3]
        playerteam.write("{0}\n".format(g1))


Java((Center(Players(), [])), (Right(Players(), [])), (Left(Players(), [])), (Defence(Players(), [])), (Goalie(Players(), [])))